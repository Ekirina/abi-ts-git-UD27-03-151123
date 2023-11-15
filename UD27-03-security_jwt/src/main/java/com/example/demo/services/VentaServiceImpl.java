package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IVentaDAO;
import com.example.demo.dto.Venta;

@Service
public class VentaServiceImpl implements IVentaService {
	@Autowired
	IVentaDAO iVentaDAO;

	@Override
	public List<Venta> listar() {
		return iVentaDAO.findAll();

	}

	@Override
	public Venta guardar(Venta venta) {
		return iVentaDAO.save(venta);

	}

	@Override
	public Venta porIdentificador(int id) {
		return iVentaDAO.findById(id).get();

	}

	@Override
	public Venta actualizar(Venta venta) {
		return iVentaDAO.save(venta);

	}

	@Override
	public void eliminar(int id) {
		iVentaDAO.deleteById(id);				
		
	}
	

}
