package com.buenSabor.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buenSabor.entity.Factura;
import com.buenSabor.services.FacturaService;
import com.commons.controllers.CommonController;

@RestController
public class FacturaController extends CommonController<Factura, FacturaService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Factura factura, @PathVariable Long id){
		Optional <Factura> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//Una vez que encontramos el id reemplazamos el Pedido
		Factura facturaDB = o.get();
		facturaDB.setMontoDescuento(factura.getMontoDescuento()); //ESTAS DOS COSAS SE PUEDEN MODIFICAR?
		facturaDB.setNroTarjeta(factura.getNroTarjeta());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(facturaDB));
		
	}
}
