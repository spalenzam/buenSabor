package com.buenSabor.services;

import java.util.List;

import com.buenSabor.entity.Factura;
import com.commons.services.CommonService;

public interface FacturaService extends CommonService<Factura> {

	public Factura findByNumeroFactura(Integer numFactura);
}
