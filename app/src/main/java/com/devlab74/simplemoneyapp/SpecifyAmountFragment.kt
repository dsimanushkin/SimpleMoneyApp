package com.devlab74.simplemoneyapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.devlab74.simplemoneyapp.databinding.FragmentSpecifyAmountBinding
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentSpecifyAmountBinding? = null
    private val binding get() = _binding!!

    lateinit var navController: NavController

    lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = requireArguments().getString("recipient")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecifyAmountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.sendBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)

        val message = "Sending money to $recipient"
        binding.recipient.text = message
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            binding.sendBtn.id -> {
                if (!TextUtils.isEmpty(binding.inputAmount.text.toString())) {
                    val amount = Money(BigDecimal(binding.inputAmount.text.toString()))
                    val bundle = bundleOf(
                            "recipient" to recipient,
                            "amount" to amount
                    )

                    navController.navigate(
                            R.id.action_specifyAmountFragment_to_confirmationFragment,
                            bundle
                    )
                } else {
                    Toast.makeText(activity, "Enter an Amount", Toast.LENGTH_SHORT).show()
                }
            }
            binding.sendBtn.id -> requireActivity().onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}