package com.example.hbapplicationgroupa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.hbapplicationgroupa.R
import com.example.hbapplicationgroupa.databinding.FragmentPaymentCheckoutBinding
import com.example.hbapplicationgroupa.model.hotelmodule.bookhotel.BookHotel
import com.example.hbapplicationgroupa.viewModel.HotelViewModel

class PaymentCheckoutFragment : Fragment() {
    //Set up view binding here
    private var _binding: FragmentPaymentCheckoutBinding? = null
    private val binding get() = _binding!!
    private val hotelViewModel: HotelViewModel by viewModels()
    private lateinit var selectedPaymentOption: BookHotel
    private val navToGPay = binding.paymentOptionGpay
    private val navToVisa = binding.paymentOptionGpay
    private val navToMasterCard = binding.paymentOptionGpay
    private val navToDebitCard = binding.paymentOptionGpay
    private val navToPaytm = binding.paymentOptionGpay

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //Enabled view binding here
        _binding = FragmentPaymentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //navigating to next fragment
        val navigateToCongratFragment = binding.paymentOptionBackBtn
            navigateToCongratFragment.setOnClickListener{
                val navController = Navigation.findNavController(requireActivity(), R.id.navigation_graph)
                //Add destination here
                navController.navigate(R.id.action_paymentCheckoutFragment_to_bookingConfirmationFragment)
            }

        //back arrow navigation
        val backArrow = binding.paymentOptionBackBtn
        backArrow.setOnClickListener{
            findNavController().popBackStack()
        }

        //google pay navigation
       // val navToGPay = binding.paymentOptionGpay
        navToGPay.setOnClickListener{
            Toast.makeText(requireContext(), "Gpay Payment Received", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_paymentCheckoutFragment_to_bookingConfirmationFragment)
        }

        //Visa navigation
        //val navToVisa = binding.paymentOptionGpay
        navToVisa.setOnClickListener{
            Toast.makeText(requireContext(), "Visa Payment Received", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_paymentCheckoutFragment_to_bookingConfirmationFragment)
        }

        //MasterCard navigation
       // val navToMasterCard = binding.paymentOptionGpay
        navToMasterCard.setOnClickListener{
            Toast.makeText(requireContext(), "MasterCrd Payment Received", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_paymentCheckoutFragment_to_bookingConfirmationFragment)
        }

        //Debit Card navigation
       // val navToDebitCard = binding.paymentOptionGpay
        navToDebitCard.setOnClickListener{
            Toast.makeText(requireContext(), "Debit Card Payment Received", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_paymentCheckoutFragment_to_bookingConfirmationFragment)
        }

        //Paytm navigation
       // val navToPaytm = binding.paymentOptionGpay
        navToPaytm.setOnClickListener{
            Toast.makeText(requireContext(), "Paytm Payment Received", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_paymentCheckoutFragment_to_bookingConfirmationFragment)
        }

        onBackPressed()
    }

    //Method to handle back press
    private fun onBackPressed(){
        //Overriding onBack press to navigate to home Fragment onBack Pressed
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }


//    private fun paymentOptionSelected() {
//        if (navToGPay.isPressed) {
//            selectedPaymentOption = BookHotel(navToGPay.toString())
//        }
//        if (navToVisa.isPressed) {
//            selectedPaymentOption = BookHotel(navToVisa.toString())
//        }
//        if (navToMasterCard.isPressed) {
//            selectedPaymentOption = BookHotel(navToMasterCard.toString())
//        }
//        if (navToDebitCard.isPressed) {
//            selectedPaymentOption = BookHotel(navToDebitCard.toString())
//        }
//        if (navToPaytm.isPressed) {
//            selectedPaymentOption = BookHotel(navToPaytm.toString())
//        }
//    }

//    private fun pushPaymentOption() {
//        val selectedPaymentOption = BookHotel(paymentOptionSelected().toString())
//        hotelViewModel.pushBookHotel(selectedPaymentOption)
//        hotelViewModel.bookingInfo.observe(viewLifecycleOwner, {
//            if (it != null) {
//                findNavController().navigate(R.id.action_paymentCheckoutFragment_to_bookingConfirmationFragment)
//            }
//        })
//    }
}