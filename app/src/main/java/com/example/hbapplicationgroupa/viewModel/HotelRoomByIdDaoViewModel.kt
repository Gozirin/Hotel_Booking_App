package com.example.hbapplicationgroupa.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hbapplicationgroupa.models.adminModule.userByIdModel.UserById
import com.example.hbapplicationgroupa.models.hotelModule.hotelRoomByIdModel.HotelRoomByIdData
import com.example.hbapplicationgroupa.repository.HotelRoomDaoByIdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotelRoomByIdDaoViewModel @Inject constructor(val hotelRoomDaoByIdRepository: HotelRoomDaoByIdRepository): ViewModel() {
    val hotelRoomByIdLiveData : MutableLiveData<List<HotelRoomByIdData>> = MutableLiveData()
    val userLoginLiveData: MutableLiveData<UserById> = MutableLiveData()
}