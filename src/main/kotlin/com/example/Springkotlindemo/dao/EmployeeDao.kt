package com.example.Springkotlindemo.dao

import com.example.Springkotlindemo.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeDao: JpaRepository<Employee, Long> {

}