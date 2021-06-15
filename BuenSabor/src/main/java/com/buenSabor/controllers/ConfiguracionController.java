package com.buenSabor.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buenSabor.entity.Configuracion;
import com.buenSabor.services.ConfiguracionService;
import com.commons.controllers.CommonController;

@RestController
@RequestMapping(path = "api/buensabor/configuracion")
public class ConfiguracionController extends CommonController<Configuracion, ConfiguracionService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Configuracion configempresa, @PathVariable Long id){
		Optional <Configuracion> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Configuracion configempresaDB = o.get();
		configempresaDB.setCantidadCocineros(configempresa.getCantidadCocineros()); 
			
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(configempresaDB));		
	}
}
