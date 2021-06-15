package com.buenSabor.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buenSabor.entity.RubroGeneral;
import com.buenSabor.services.RubroGeneralService;
import com.commons.controllers.CommonController;

@RestController
@RequestMapping(path="api/buensabor/rubrogeneral")
public class RubroGeneralController extends CommonController<RubroGeneral, RubroGeneralService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody RubroGeneral rubrogeneral, @PathVariable Long id){
		Optional<RubroGeneral> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		RubroGeneral rubrogeneralDB = o.get();
		rubrogeneralDB.setDenominacion(rubrogeneral.getDenominacion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(rubrogeneralDB));
	}
}
