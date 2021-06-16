package com.buenSabor.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Autoincremental
	private Long id;
	
	@NotEmpty
	@Column(name= "numero_pedido")
	private int numeroPedido;
	
	@NotEmpty
	@Column(name= "fecha_pedido")
	private Date fechaPedido;
	
	@NotEmpty
	@Column(name= "hora_estimada_fin_pedido")
	private Time horaEstimadaFinPedido;         //REVISAR ESTO O LOCALTIME
	
	@NotEmpty
	@Column(name= "tipo_envio_pedido")
	private String tipoEnvioPedido;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_mercado_pago_datos")
	private MercadoPagoDatos mercadoPagoDatos;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "domicilio")
	private Domicilio domicilio;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	
	@JsonIgnoreProperties(value = {"pedido"}, allowSetters = true)
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetallePedido> detallepedidos;
	
	public Pedido() {
		this.detallepedidos = new ArrayList<>();
	}
	
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

	public MercadoPagoDatos getMercadoPagoDatos() {
		return mercadoPagoDatos;
	}

	public void setMercadoPagoDatos(MercadoPagoDatos mercadoPagoDatos) {
		this.mercadoPagoDatos = mercadoPagoDatos;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetallePedido> getDetallepedidos() {
		return detallepedidos;
	}

	public void setDetallepedidos(List<DetallePedido> detallepedidos) {
		this.detallepedidos.clear();
		detallepedidos.forEach(this::addDetallepedidos);
	}

	public void addDetallepedidos(DetallePedido detallepedido) {
		this.detallepedidos.add(detallepedido);
		detallepedido.setPedido(this);
	}
	
	public void removeDetallepedidos(DetallePedido detallepedido) {
		this.detallepedidos.remove(detallepedido);
		detallepedido.setPedido(null);
	}
}
