package com.buenSabor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "articuloManufacturado")
public class ArticuloManufacturado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tiempoEstimadoCocina")
	private int tiempoEstimadoCocina;
	
	@Column(name = "denominacion")
	private String denominación;
	
	@Column(name = "precioVenta")
	private double precioVenta;
	
	//VER EL TIPO DE DATO DE IMAGEN MAGNI PONE STRING
	//LOB campo de objeto pesado 
	@Lob
	@JsonIgnore
	private byte [] imagen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTiempoEstimadoCocina() {
		return tiempoEstimadoCocina;
	}

	public void setTiempoEstimadoCocina(int tiempoEstimadoCocina) {
		this.tiempoEstimadoCocina = tiempoEstimadoCocina;
	}

	public String getDenominación() {
		return denominación;
	}

	public void setDenominación(String denominación) {
		this.denominación = denominación;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
}
