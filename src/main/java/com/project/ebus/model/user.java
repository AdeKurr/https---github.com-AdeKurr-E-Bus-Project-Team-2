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
@Table(name = "user")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nama;
    private String nik;
    // @ManyToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "namaJk", referencedColumnName = "namaJk")
    // private JenisKelamin namaJk;
    private String jenis_kelamin;
    private String tanggal_lahir;
    private String email;
    private String password;

}
