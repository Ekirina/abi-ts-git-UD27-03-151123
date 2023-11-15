package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@ManyToOne
	@JoinColumn(name="codigo_cajero")
	Cajeros cajeros;
	
	@ManyToOne
	@JoinColumn(name="codigo_producto")
	Productos productos;
	
	@ManyToOne
	@JoinColumn(name="codigo_maquina")
	Maquinas_registradoras maquinas_registradoras;
	
	//Constructores
	public Venta() {
	}

	public Venta(Cajeros cajeros, Productos productos, Maquinas_registradoras maquinas_registradoras) {
		//super();
		this.cajeros = cajeros;
		this.productos = productos;
		this.maquinas_registradoras = maquinas_registradoras;
	}
	//Getters y setters

	public Cajeros getCajeros() {
		return cajeros;
	}

	public void setCajeros(Cajeros cajeros) {
		this.cajeros = cajeros;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public Maquinas_registradoras getMaquinas_registradoras() {
		return maquinas_registradoras;
	}

	public void setMaquinas_registradoras(Maquinas_registradoras maquinas_registradoras) {
		this.maquinas_registradoras = maquinas_registradoras;
	}
	
	//Método String
	
	@Override
	public String toString() {
		return "Venta [cajeros=" + cajeros + ", productos=" + productos + ", maquinas_registradoras="
				+ maquinas_registradoras + "]";
	}
}
