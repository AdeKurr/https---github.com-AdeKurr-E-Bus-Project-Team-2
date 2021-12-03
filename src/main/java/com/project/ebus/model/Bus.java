package com.project.ebus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Bus")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bus {
	@Id
	String noPolisi;
	int kapasitas;
	String namaSupir;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "namaPerusahaan", referencedColumnName = "nama")
	Perusahaan namaPerusahaan;

}
