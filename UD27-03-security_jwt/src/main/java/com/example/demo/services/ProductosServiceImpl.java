package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductosDAO;
import com.example.demo.dto.Productos;

@Service
public class ProductosServiceImpl implements IProductosService {
	@Autowired
	IProductosDAO iProductosDAO;

	@Override
	public List<Productos> listar() {
		return iProductosDAO.findAll();

	}

	@Override
	public Productos guardar(Productos productos) {
		return iProductosDAO.save(productos);

	}

	@Override
	public Productos porIdentificador(int codigo_producto) {
		return iProductosDAO.findById(codigo_producto).get();

	}

	@Override
	public Productos actualizar(Productos productos) {
		return iProductosDAO.save(productos);

	}

	@Override
	public void eliminar(int codigo_producto) {
		iProductosDAO.deleteById(codigo_producto);		
		
	}
}
