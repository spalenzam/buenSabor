package com.buenSabor.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buenSabor.entity.DetalleFactura;
import com.buenSabor.services.DetalleFacturaService;
import com.commons.controllers.CommonController;

@RestController
@RequestMapping(path = "api/buensabor/detallefactura")
public class DetalleFacturaController extends CommonController<DetalleFactura, DetalleFacturaService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody DetalleFactura detallefactura, @PathVariable Long id){
		Optional<DetalleFactura> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		DetalleFactura detallefacturaDB = o.get();
		detallefacturaDB.setCantidad(detallefactura.getCantidad());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(detallefacturaDB));
	}
}
