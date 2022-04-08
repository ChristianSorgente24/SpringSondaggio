package com.milano.sondaggio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="sondaggio")
@Data
public class Sondaggio implements Serializable{
	private static final long serialVersionUID = -5668297890610489274L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String domanda;
	private String descrizione;
}
