package com.buenSabor.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buenSabor.entity.MercadoPagoDatos;
import com.buenSabor.services.MercadoPagoDatosService;
import com.commons.controllers.CommonController;

@RestController
@RequestMapping(path="api/buensabor/mercadoPagoDatos")
public class MercadoPagoDatosController extends CommonController<MercadoPagoDatos, MercadoPagoDatosService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody MercadoPagoDatos mercadoPagoDatos, @PathVariable Long identificadorPago){
		Optional <MercadoPagoDatos> o = service.findById(identificadorPago);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		//Una vez que encontramos el id reemplazamos el MercadoPagoDatos
		MercadoPagoDatos mercadoPagoDatosDB = o.get();
		mercadoPagoDatosDB.setFormaPago(mercadoPagoDatos.getFormaPago());
		mercadoPagoDatosDB.setMetodoPago(mercadoPagoDatos.getMetodoPago());
		mercadoPagoDatosDB.setEstado(mercadoPagoDatos.getEstado());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(mercadoPagoDatosDB));		
	}

}