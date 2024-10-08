package com.cibertec.pragma.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String nombre;

	    @Column(nullable = false)
	    private Double precio;

	    // Getters y setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getNombre() { return nombre; }
	    public void setNombre(String nombre) { this.nombre = nombre; }

	    public Double getPrecio() { return precio; }
	    public void setPrecio(Double precio) { this.precio = precio; }
}
