package com.milano.sondaggio.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "utente_sondaggio", uniqueConstraints = @UniqueConstraint(columnNames = { "id_sondaggio", "id_utente" }))
@Data
public class UtenteSondaggio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_sondaggio")
	private Sondaggio sondaggio;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_utente")
	private Utente utente;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_opzione")
	private Opzione opzione;
}
