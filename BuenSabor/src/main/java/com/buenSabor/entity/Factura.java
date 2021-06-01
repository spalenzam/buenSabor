package com.buenSabor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="facturas")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "fecha_factura")
	private Date fechaFactura;
	@Column(name= "numero_factura")
	private int numeroFactura;
	@Column(name= "monto_descuento")
	private int montoDescuento;          //ESTO ES INT?
	@Column(name= "nro_tarjeta")
	private Long nroTarjeta;
	
	@Column(name="created_at") //
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	//Método que antes de persistir en la DB, asígna la fecha
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}
	
	//Getter and Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public int getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public int getMontoDescuento() {
		return montoDescuento;
	}
	public void setMontoDescuento(int montoDescuento) {
		this.montoDescuento = montoDescuento;
	}
	public Long getNroTarjeta() {
		return nroTarjeta;
	}
	public void setNroTarjeta(Long nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
