package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Division;
import com.example.servingwebcontent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Integer> {
}