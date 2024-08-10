package com.example.idzassignment.api

import com.example.idzassignment.model.EmployeesData
import retrofit2.Response
import retrofit2.http.GET

interface BackendServices {
    @GET("dummy/EmployeeDetails.json")
    suspend fun getEmployeeDetails(): Response<EmployeesData>
}