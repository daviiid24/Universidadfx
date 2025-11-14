package co.edu.uniquindio.universidadfx.controller;

import co.edu.uniquindio.universidadfx.factory.ModelFactory;

public class ConsultasController {
    ModelFactory modelFactory;

    public ConsultasController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public String consultarDefinitivas(String idDocente) {
        return modelFactory.consultarDefinitivas(idDocente);
    }

    public String consultarDocente(String idDocente) {
        return modelFactory.consultarDocente(idDocente);
    }
}
