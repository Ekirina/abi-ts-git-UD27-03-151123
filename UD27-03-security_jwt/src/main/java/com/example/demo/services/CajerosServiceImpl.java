package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajerosDAO;
import com.example.demo.dto.Cajeros;

@Service
public class CajerosServiceImpl implements ICajerosService {
	@Autowired
	ICajerosDAO iCajerosDAO;
	
	@Override
	public List<Cajeros> listar() {
		return iCajerosDAO.findAll();

	}

	@Override
	public Cajeros guardar(Cajeros cajeros) {
		return iCajerosDAO.save(cajeros);

	}

	@Override
	public Cajeros porIdentificador(int codigo) {
		return iCajerosDAO.findById(codigo).get();

	}

	@Override
	public Cajeros actualizar(Cajeros cajeros) {
		return iCajerosDAO.save(cajeros);

	}

	@Override
	public void eliminar(int codigo) {
		iCajerosDAO.deleteById(codigo);		
		
	}

}
