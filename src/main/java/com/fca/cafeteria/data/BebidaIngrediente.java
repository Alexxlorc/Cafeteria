package com.fca.cafeteria.data;

import jakarta.persistence.*;

@Entity
@Table(name = "tBebidaIngrediente")
public class BebidaIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBebidaIngrediente")
    private int idBebidaIngrediente;

    @Column(name = "idBebida", nullable = false)
    private int idBebida;

    @Column(name = "idIngrediente", nullable = false)
    private int idIngrediente;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    // Getters y Setters
    public int getIdBebidaIngrediente() {
        return idBebidaIngrediente;
    }

    public void setIdBebidaIngrediente(int idBebidaIngrediente) {
        this.idBebidaIngrediente = idBebidaIngrediente;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
