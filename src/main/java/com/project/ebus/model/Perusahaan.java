package com.project.ebus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name="Perusahaan")
public class Perusahaan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String nama;
	String alamat;

}