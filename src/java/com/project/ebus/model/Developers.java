package com.project.ebus.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// brata

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "developer")
public class Developers {
    @Id
    Long id;
    String nama;
    String usernameFb;
    String usernameIg;
}
