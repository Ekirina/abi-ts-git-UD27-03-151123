package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {
	//Atributos productos
	@Id
	private int codigo_producto;
	@Column(name="nombre")
	private String nombre;
	@Column(name = "precio")
	private int precio;
	
	@OneToMany
	@JoinColumn(name="codigo_producto")
	private List <Venta> venta;
	
	//Constructores
	public Productos() {
		
	}

	public Productos(int codigo_producto, String nombre, int precio, List<Venta> venta) {
		super();
		this.codigo_producto = codigo_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.venta = venta;
	}
	//Getters y setters

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	
	
	//Método String
	
	@Override
	public String toString() {
		return "Productos [codigo_producto=" + codigo_producto + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
}
