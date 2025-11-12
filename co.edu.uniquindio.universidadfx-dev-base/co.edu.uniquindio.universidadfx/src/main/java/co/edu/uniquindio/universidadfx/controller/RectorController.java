package co.edu.uniquindio.universidadfx.controller;

import co.edu.uniquindio.universidadfx.factory.ModelFactory;
import co.edu.uniquindio.universidadfx.model.Estudiante;
import co.edu.uniquindio.universidadfx.model.Rector;

import java.util.List;

public class RectorController {
    ModelFactory modelFactory;


    public RectorController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public Rector obtenerRector() {
        return modelFactory.obtenerRector();
    }

    public Rector crearRector(String nombre, String apellido, String identificacion, String edad) {
        return modelFactory.crearRector(nombre,apellido,identificacion,edad);
    }
    public Rector actualizarRector(String nombre, String apellido, String identificacion, String edad){
        return modelFactory.actualizarRector(nombre,apellido,identificacion,edad);
    }
    public Rector eliminarRector() {
        return modelFactory.eliminarRector();
    }
}
