package ar.edu.uncuyo.controller;

import ar.edu.uncuyo.dao.clienteDAO;
import ar.edu.uncuyo.model.cliente;



public class clienteController {
    
    public void guardar(cliente c) {
        clienteDAO dao = new clienteDAO();
        dao.insert_cliente(c);
    }

    public void eliminarCliente(cliente cliente) {
        clienteDAO dao = new clienteDAO();
        dao.delete_cliente(cliente);
    }

    public void modificarCliente(cliente clienteNuevo) {
        clienteDAO dao = new clienteDAO();
        dao.updateCliente(clienteNuevo);
    }

}
