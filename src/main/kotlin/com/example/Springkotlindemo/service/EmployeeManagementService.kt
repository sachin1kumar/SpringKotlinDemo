package com.example.Springkotlindemo.service

import com.example.Springkotlindemo.dto.AddEmployeeRequest
import com.example.Springkotlindemo.dto.EmployeeResponse
import com.example.Springkotlindemo.dto.UpdateEmployeeRequest

interface EmployeeManagementService {
    fun findById(id: Long): EmployeeResponse?
    fun findAll(): List<EmployeeResponse>
    fun save(addEmployeeRequest: AddEmployeeRequest): EmployeeResponse
    fun update(updateEmployeeRequest: UpdateEmployeeRequest): EmployeeResponse
    fun deleteById(id: Long)
}