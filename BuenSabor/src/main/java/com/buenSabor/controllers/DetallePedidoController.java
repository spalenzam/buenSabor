package com.buenSabor.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buenSabor.entity.DetallePedido;
import com.buenSabor.services.DetallePedidoService;
import com.commons.controllers.CommonController;

@RestController
@RequestMapping(path = "api/buensabor/detallepedido")
public class DetallePedidoController extends CommonController<DetallePedido, DetallePedidoService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody DetallePedido detallepedido, @PathVariable Long id){
		Optional<DetallePedido> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		DetallePedido detallepedidoDB = o.get();
		detallepedidoDB.setCantidad(detallepedido.getCantidad());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(detallepedidoDB));
	}
}
