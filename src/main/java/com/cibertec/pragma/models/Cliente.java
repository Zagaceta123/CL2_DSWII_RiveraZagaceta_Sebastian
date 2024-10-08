package com.cibertec.pragma.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity
@javax.persistence.Table(name = "clientes")
public class Cliente {

	  	@javax.persistence.Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String nombre;

	    @Column(nullable = false)
	    private String direccion;

	    @Column(nullable = false, unique = true)
	    private String email;

	    // Getters y setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getNombre() { return nombre; }
	    public void setNombre(String nombre) { this.nombre = nombre; }

	    public String getDireccion() { return direccion; }
	    public void setDireccion(String direccion) { this.direccion = direccion; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }
}

