package com.example.Springkotlindemo.domain

import javax.persistence.*

@Entity
data class Employee(
        @Id
        @SequenceGenerator(name = EMPLOYEE_SEQUENCE, sequenceName = EMPLOYEE_SEQUENCE, initialValue = 1, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = EMPLOYEE_SEQUENCE)
        val id: Long = 1,
        var name: String = "",
        var lastName: String? = null){

    companion object{
        const val EMPLOYEE_SEQUENCE: String = "EMPLOYEE_SEQUENCE"
    }
}