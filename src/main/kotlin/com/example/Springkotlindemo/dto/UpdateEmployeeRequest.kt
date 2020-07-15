package com.example.Springkotlindemo.dto

data class UpdateEmployeeRequest(val id: Long, val name: String, val lastName: String? = null)