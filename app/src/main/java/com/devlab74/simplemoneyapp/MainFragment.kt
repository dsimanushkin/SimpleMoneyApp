package com.devlab74.simplemoneyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.devlab74.simplemoneyapp.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.viewTransactionsBtn.setOnClickListener(this)
        binding.sendMoneyBtn.setOnClickListener(this)
        binding.viewBalanceBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            binding.viewTransactionsBtn.id -> navController.navigate(R.id.action_mainFragment_to_viewTransactionsFragment)
            binding.sendMoneyBtn.id -> navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
            binding.viewBalanceBtn.id -> navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}