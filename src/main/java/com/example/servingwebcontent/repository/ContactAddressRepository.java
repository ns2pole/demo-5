package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.ContactAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ContactAddressRepository extends JpaRepository<ContactAddress, Integer> {
	public Optional<ContactAddress> findByUserId(int userId);

}