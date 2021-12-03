package com.project.ebus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "keberangkatan")

public class Keberangkatan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int harga;
	private String kelas;
	private String tanggal;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idJurusan", referencedColumnName = "id")
	private Jurusan idJurusan;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "noPolisi", referencedColumnName = "noPolisi")
	private Bus noPolisi;
}