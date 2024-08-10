package com.example.idzassignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.idzassignment.api.BackendServices
import com.example.idzassignment.model.EmployeesData
import com.example.idzassignment.utils.stringTrimmer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val backendServices: BackendServices
): ViewModel() {
    private val _employeeData = MutableLiveData<EmployeesData>()
    val employeeData: LiveData<EmployeesData>
        get() = _employeeData

    fun getEmployees() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = backendServices.getEmployeeDetails()
                if (response.isSuccessful) {
                    _employeeData.postValue(response.body())
                    return@launch
                }
            } catch (e: Exception) {
                Timber.e(e.printStackTrace().stringTrimmer())
            }
        }
    }
}