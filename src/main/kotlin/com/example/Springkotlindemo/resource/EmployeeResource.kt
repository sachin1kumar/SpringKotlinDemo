package com.example.Springkotlindemo.resource

import com.example.Springkotlindemo.dto.AddEmployeeRequest
import com.example.Springkotlindemo.dto.EmployeeResponse
import com.example.Springkotlindemo.dto.UpdateEmployeeRequest
import org.springframework.http.ResponseEntity

interface EmployeeResource {
    fun findById(id: Long): ResponseEntity<EmployeeResponse?>
    fun findAll(): ResponseEntity<List<EmployeeResponse>>
    fun save(addEmployeeRequest: AddEmployeeRequest): ResponseEntity<EmployeeResponse>
    fun update(updateEmployeeRequest: UpdateEmployeeRequest): ResponseEntity<EmployeeResponse>
    fun deleteById(id: Long): ResponseEntity<Unit>
}