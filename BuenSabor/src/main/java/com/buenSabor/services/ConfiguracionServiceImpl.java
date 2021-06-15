package com.buenSabor.services;

import org.springframework.stereotype.Service;

import com.buenSabor.entity.Configuracion;
import com.buenSabor.repository.ConfiguracionRepository;
import com.commons.services.CommonServiceImpl;

@Service
public class ConfiguracionServiceImpl extends CommonServiceImpl<Configuracion, ConfiguracionRepository>implements ConfiguracionService {

}
