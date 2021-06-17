package com.buenSabor.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "rubro_articulo")
public class RubroArticulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "denominacion")
	private String denominacion;
	
	@JsonIgnoreProperties(value= {"rubroarticuloHijos"})
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private RubroArticulo rubroarticuloPadre;
	
	@JsonIgnoreProperties(value= {"rubroarticuloPadre"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="rubroarticuloPadre", cascade = CascadeType.ALL)
	private List<RubroArticulo> rubroarticuloHijos;
	
	public RubroArticulo() {
		this.rubroarticuloHijos = new ArrayList<>();
	}

	public RubroArticulo() {
        this.rubroarticuloHijos = new ArrayList<>();
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public RubroArticulo getRubroarticuloPadre() {
		return rubroarticuloPadre;
	}

	public void setRubroarticuloPadre(RubroArticulo rubroarticuloPadre) {
		this.rubroarticuloPadre = rubroarticuloPadre;
	}

	public List<RubroArticulo> getRubroarticuloHijos() {
		return rubroarticuloHijos;
	}

	public void setRubroarticuloHijos(List<RubroArticulo> rubroarticuloHijos) {
		this.rubroarticuloHijos = rubroarticuloHijos;
	}

	

	
	
}
