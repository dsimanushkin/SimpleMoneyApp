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
import com.devlab74.simplemoneyapp.databinding.FragmentChooseRecipientBinding

class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentChooseRecipientBinding? = null
    private val binding get() = _binding!!

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseRecipientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.nextBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            binding.nextBtn.id -> {
                if (!TextUtils.isEmpty(binding.inputRecipient.text.toString())) {
                    val bundle = bundleOf("recipient" to binding.inputRecipient.text.toString())

                    navController.navigate(
                            R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                            bundle
                    )
                } else {
                    Toast.makeText(activity, "Enter a Recipient", Toast.LENGTH_SHORT).show()
                }
            }
            binding.cancelBtn.id -> requireActivity().onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}