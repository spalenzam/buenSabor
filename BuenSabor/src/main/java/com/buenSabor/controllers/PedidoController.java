package com.buenSabor.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buenSabor.entity.Pedido;
import com.buenSabor.services.PedidoService;
import com.commons.controllers.CommonController;

@RestController
public class PedidoController extends CommonController<Pedido, PedidoService>{
		
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Pedido pedido, @PathVariable Long id){
		Optional <Pedido> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		//Una vez que encontramos el id reemplazamos el Pedido
		Pedido pedidoDB = o.get();
		pedidoDB.setNumeroPedido(pedido.getNumeroPedido()); //ESTAS DOS COSAS SE PUEDEN MODIFICAR?
		pedidoDB.setTipoEnvioPedido(pedido.getTipoEnvioPedido());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedidoDB));
		
	}

}
