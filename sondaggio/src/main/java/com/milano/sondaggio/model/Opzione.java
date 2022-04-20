package com.milano.sondaggio.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="opzione")
public class Opzione implements Serializable{
	
	private static final long serialVersionUID = -3631495711562326064L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_sondaggio")
	private Sondaggio sondaggio;
	
	
	private String descrizione;
}
