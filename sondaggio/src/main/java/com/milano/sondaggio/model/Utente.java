package com.milano.sondaggio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "utente")
@Data
public class Utente implements Serializable{
	
	private static final long serialVersionUID = -5991481784471334924L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="username", unique=true, nullable=false)
	private String username;
	@Column(name="password", nullable=false)
	private String password;
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	
}
