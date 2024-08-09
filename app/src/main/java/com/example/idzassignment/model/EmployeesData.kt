package com.example.idzassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmployeesData(
    @SerializedName("employees") val employees: List<Employee>
): Parcelable