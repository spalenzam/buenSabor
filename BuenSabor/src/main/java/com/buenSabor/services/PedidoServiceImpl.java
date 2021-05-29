package com.buenSabor.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buenSabor.entity.Pedido;
import com.buenSabor.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository repository; 
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Pedido> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Pedido save(Pedido pedido) {
		return repository.save(pedido);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
