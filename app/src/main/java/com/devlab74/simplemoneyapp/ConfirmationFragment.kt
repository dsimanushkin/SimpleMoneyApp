package com.devlab74.simplemoneyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devlab74.simplemoneyapp.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment() {

    private var _binding: FragmentConfirmationBinding? = null
    private val binding get() = _binding!!

    lateinit var recipient: String
    lateinit var money: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = requireArguments().getString("recipient")!!
        money = requireArguments().getParcelable("amount")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val amount = money.amount
        val confirmationMessage = "You have sent $$amount to $recipient!"
        binding.confirmationMessage.text = confirmationMessage
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}