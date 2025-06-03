package ar.edu.uncuyo.controller;

import ar.edu.uncuyo.dao.generoDAO;
import ar.edu.uncuyo.model.genero;



public class generoController {
    private generoDAO dao = new generoDAO();

    public void guardar(String descripcion) {
        genero g = new genero();
        g.setDescripcion(descripcion);
        dao.insert_genero(g);
    }

    public void eliminarGenero( Long Id) {
        genero g = dao.getIdGenero(Id);
        if (g != null) {
            dao.delete_genero(g);
        } else {
            throw new IllegalArgumentException("Género no encontrado");
        }
    }

    public void modificarGenero(Long id, String descripcion) {
        genero g = dao.getIdGenero(id);
        if (g != null) {
            g.setDescripcion(descripcion);
            dao.updateGenero(g);
        } else {
            throw new IllegalArgumentException("Género no encontrado");
        }
    }
}
