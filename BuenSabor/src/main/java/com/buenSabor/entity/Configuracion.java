package com.buenSabor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name="configuracion")
public class Configuracion {
	
	@Column(name = "cantidad_cocineros")
	private int cantidadCocineros;
	
	@Column(name = "email_empresa")
	private String emailEmpresa;
	
	@Column(name = "token_mercado_pago")
	private String tokenMercadoPago;

	public int getCantidadCocineros() {
		return cantidadCocineros;
	}

	public void setCantidadCocineros(int cantidadCocineros) {
		this.cantidadCocineros = cantidadCocineros;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public String getTokenMercadoPago() {
		return tokenMercadoPago;
	}

	public void setTokenMercadoPago(String tokenMercadoPago) {
		this.tokenMercadoPago = tokenMercadoPago;
	}
}
