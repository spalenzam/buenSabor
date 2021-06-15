package com.buenSabor.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Autoincremental
	private Long id;
	
	@Column(name= "numero_pedido")
	private int numeroPedido;
	@Column(name= "fecha_pedido")
	private Date fechaPedido;
	@Column(name= "hora_estimada_fin_pedido")
	private Time horaEstimadaFinPedido;         //REVISAR ESTO O LOCALTIME
	@Column(name= "tipo_envio_pedido")
	private String tipoEnvioPedido;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_mercado_pago_datos")
	private MercadoPagoDatos mercadoPagoDatos;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "domicilio")
	private Domicilio domicilio;
	
	@Column(name="created_at") //
	@Temporal(TemporalType.TIMESTAMP) //se guarda la fecha y la hora
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
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public Date getHoraEstimadaFinPedido() {
		return horaEstimadaFinPedido;
	}
	public void setHoraEstimadaFinPedido(Time horaEstimadaFinPedido) {
		this.horaEstimadaFinPedido = horaEstimadaFinPedido;
	}
	public String getTipoEnvioPedido() {
		return tipoEnvioPedido;
	}
	public void setTipoEnvioPedido(String tipoEnvioPedido) {
		this.tipoEnvioPedido = tipoEnvioPedido;
	}


}
