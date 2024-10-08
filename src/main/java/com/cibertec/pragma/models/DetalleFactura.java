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
@Table(name = "detalle_factura")
public class DetalleFactura {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "factura_id", nullable = false)
	    private Factura factura;

	    @ManyToOne
	    @JoinColumn(name = "producto_id", nullable = false)
	    private Producto producto;

	    @Column(nullable = false)
	    private Integer cantidad;

	    @Column(nullable = false)
	    private Double subtotal;

	    // Getters y setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public Factura getFactura() { return factura; }
	    public void setFactura(Factura factura) { this.factura = factura; }

	    public Producto getProducto() { return producto; }
	    public void setProducto(Producto producto) { this.producto = producto; }

	    public Integer getCantidad() { return cantidad; }
	    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

	    public Double getSubtotal() { return subtotal; }
	    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }
}
