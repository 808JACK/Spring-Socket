package com.example.demo.repositories;

import com.example.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
