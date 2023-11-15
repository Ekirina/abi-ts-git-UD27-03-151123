package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMaquinas_registradorasDAO;
import com.example.demo.dto.Maquinas_registradoras;

@Service
public class Maquinas_registradorasServiceImpl implements IMaquinas_registradorasService {
	@Autowired
	IMaquinas_registradorasDAO iMaquinas_registradorasDAO;
	@Override
	public List<Maquinas_registradoras> listar() {
		return iMaquinas_registradorasDAO.findAll();

	}

	@Override
	public Maquinas_registradoras guardar(Maquinas_registradoras maquinas_registradoras) {
		return iMaquinas_registradorasDAO.save(maquinas_registradoras);

	}

	@Override
	public Maquinas_registradoras porIdentificador(int codigo_maquina) {
		return iMaquinas_registradorasDAO.findById(codigo_maquina).get();

	}

	@Override
	public Maquinas_registradoras actualizar(Maquinas_registradoras maquinas_registradoras) {
		return iMaquinas_registradorasDAO.save(maquinas_registradoras);

	}

	@Override
	public void eliminar(int codigo_maquina) {
		iMaquinas_registradorasDAO.deleteById(codigo_maquina);		
		
	}

}
