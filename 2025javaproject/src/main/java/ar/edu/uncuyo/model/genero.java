package ar.edu.uncuyo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "genero", schema = "clientes")
public class genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generación automática de ID
    @Column(name = "ID_genero")
    private Long ID_genero;

    @Column(name = "descripcion")
    private String descripcion;

    public genero() {}

    public genero(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters y setters

    public Long getID_genero() {
        return ID_genero;
    }

    public String getdescripcion () {
        return descripcion;
    }

    public void setID_genero(Long ID_genero) {
        this.ID_genero = ID_genero;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "genero{" +
                "ID_genero=" + ID_genero +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

