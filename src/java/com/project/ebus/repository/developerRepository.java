package com.project.ebus.repository;

import com.project.ebus.model.Developers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface developerRepository extends JpaRepository<Developers, Long> {

}
