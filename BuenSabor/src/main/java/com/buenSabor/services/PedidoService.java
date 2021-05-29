package com.buenSabor.services;

import java.util.Optional;

import com.buenSabor.entity.Pedido;

public interface PedidoService {
	
	public Iterable<Pedido> findAll();
	
	public Optional<Pedido> findById(Long id);
	
	public Pedido save(Pedido pedido);
	
	public void deleteById(Long id);
}
