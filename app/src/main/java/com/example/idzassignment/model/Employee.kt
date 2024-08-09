package com.example.idzassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employee(
    @SerializedName("age") val age: Int? = 1,
    @SerializedName("name") val name: String? = "",
    @SerializedName("salary") val salary: Int? = 1
): Parcelable