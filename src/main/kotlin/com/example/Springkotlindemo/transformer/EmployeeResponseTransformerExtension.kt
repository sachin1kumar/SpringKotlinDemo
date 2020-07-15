package com.example.Springkotlindemo.transformer

import com.example.Springkotlindemo.domain.Employee
import com.example.Springkotlindemo.dto.EmployeeResponse

fun Employee?.toEmployeeResponse(): EmployeeResponse {
    return EmployeeResponse(
            id = this?.id ?: 1L,
            fullName = "${this?.lastName}, ${this?.name}"
    )
}