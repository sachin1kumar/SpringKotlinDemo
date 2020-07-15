package com.example.Springkotlindemo.service

import com.example.Springkotlindemo.dao.EmployeeDao
import com.example.Springkotlindemo.domain.Employee
import com.example.Springkotlindemo.dto.AddEmployeeRequest
import com.example.Springkotlindemo.dto.EmployeeResponse
import com.example.Springkotlindemo.dto.UpdateEmployeeRequest
import com.example.Springkotlindemo.transformer.AddEmployeeRequestTransformer
import com.example.Springkotlindemo.transformer.toEmployeeResponse
import org.springframework.context.annotation.Bean
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

@Service
class EmployeeManagementServiceImpl(private val employeeDao: EmployeeDao,
                                    private val addEmployeeRequestTransformer: AddEmployeeRequestTransformer) : EmployeeManagementService {

    override fun findById(id: Long): EmployeeResponse? = this.findEmployeeById(id).toEmployeeResponse()

    override fun findAll(): List<EmployeeResponse> = this.employeeDao.findAll().map(Employee::toEmployeeResponse)

    override fun save(addEmployeeRequest: AddEmployeeRequest): EmployeeResponse {
        return this.saveOrUpdate(addEmployeeRequestTransformer.transform(addEmployeeRequest))
    }

    override fun update(updateEmployeeRequest: UpdateEmployeeRequest): EmployeeResponse {
        val employee = this.findEmployeeById(updateEmployeeRequest.id) ?: throw IllegalStateException("${updateEmployeeRequest.id} not found")
        return this.saveOrUpdate(employee.apply {
            this.name = updateEmployeeRequest.name
            this.lastName = updateEmployeeRequest.lastName
        })
    }

    override fun deleteById(id: Long) {
        this.employeeDao.deleteById(id)
    }

    private fun findEmployeeById(id: Long): Employee? = this.employeeDao.findByIdOrNull(id)

    private fun saveOrUpdate(employee: Employee): EmployeeResponse = this.employeeDao.save(employee).toEmployeeResponse()
}