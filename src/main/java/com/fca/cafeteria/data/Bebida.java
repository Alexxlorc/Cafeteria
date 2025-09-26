package com.fca.cafeteria.data;

import jakarta.persistence.*;

@Entity
@Table(name = "tbebida")
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "idTipoBebida")
    private int idTipoBebida;

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTipoBebida() {
        return idTipoBebida;
    }

    public void setIdTipoBebida(int idTipoBebida) {
        this.idTipoBebida = idTipoBebida;
    }


}
