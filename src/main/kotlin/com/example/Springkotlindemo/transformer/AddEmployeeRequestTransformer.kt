package com.example.Springkotlindemo.transformer

import com.example.Springkotlindemo.domain.Employee
import com.example.Springkotlindemo.dto.AddEmployeeRequest
import com.example.Springkotlindemo.dto.EmployeeResponse
import org.springframework.context.annotation.Bean

class AddEmployeeRequestTransformer: Transformer<AddEmployeeRequest, Employee> {
    @Bean
    override fun transform(source: AddEmployeeRequest): Employee {
        return Employee(
                name = source.name,
                lastName = source.lastName
        )
    }
}