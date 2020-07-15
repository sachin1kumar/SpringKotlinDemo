package com.example.Springkotlindemo.resource

import com.example.Springkotlindemo.dto.AddEmployeeRequest
import com.example.Springkotlindemo.dto.EmployeeResponse
import com.example.Springkotlindemo.dto.UpdateEmployeeRequest
import com.example.Springkotlindemo.resource.EmployeeResourceImpl.Companion.BASE_PERSON_URL
import com.example.Springkotlindemo.service.EmployeeManagementService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class EmployeeResourceImpl(private val employeeManagementService: EmployeeManagementService) : EmployeeResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<EmployeeResponse?> {
        val employeeResponse: EmployeeResponse? = this.employeeManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse)
    }

    @GetMapping
    override fun findAll(): ResponseEntity<List<EmployeeResponse>> = ResponseEntity.ok(this.employeeManagementService.findAll())

    @PostMapping
    override fun save(@RequestBody addEmployeeRequest: AddEmployeeRequest): ResponseEntity<EmployeeResponse> {
        val employeeResponse = this.employeeManagementService.save(addEmployeeRequest)
        return ResponseEntity
                .created(URI.create(BASE_PERSON_URL.plus("/${employeeResponse.id}")))
                .body(employeeResponse)
    }

    @PutMapping
    override fun update(@RequestBody updateEmployeeRequest: UpdateEmployeeRequest): ResponseEntity<EmployeeResponse> {
        return ResponseEntity.ok(this.employeeManagementService.update(updateEmployeeRequest))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.employeeManagementService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object{
        const val BASE_PERSON_URL: String = "api/v1/employee"
    }
}