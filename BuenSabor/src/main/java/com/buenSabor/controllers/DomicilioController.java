package com.buenSabor.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buenSabor.entity.Domicilio;
import com.buenSabor.services.DomicilioService;
import com.commons.controllers.CommonController;

@RestController
@RequestMapping(path="api/buensabor/domicilio")
public class DomicilioController extends CommonController<Domicilio, DomicilioService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody Domicilio domicilio, @PathVariable Long id){
		Optional <Domicilio> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Domicilio domicilioDB = o.get();
		domicilioDB.setCalle(domicilio.getCalle());
		domicilioDB.setLocalidad(domicilio.getLocalidad());
		domicilioDB.setNumero(domicilio.getNumero());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(domicilioDB));
	}
}
