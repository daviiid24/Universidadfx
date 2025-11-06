package co.edu.uniquindio.universidadfx.factory;

import co.edu.uniquindio.universidadfx.model.Estudiante;
import co.edu.uniquindio.universidadfx.model.Universidad;
import co.edu.uniquindio.universidadfx.utils.DataUtil;

import java.util.List;

public class ModelFactory {
    private static ModelFactory modelFactory;
    private Universidad universidad;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        universidad = DataUtil.inicializarDatos();
    }

    public List<Estudiante> obtenerEstudiantes() {
        return universidad.getListaEstudiantes();
    }

    public Estudiante crearEstudiante(String nombre, String apellido, String identificacion, String edad) {
        return universidad.crearEstudiante(
                nombre,
                apellido,
                Integer.parseInt(edad),
                0.0,
                0.0,
                0.0,
                identificacion);
    }
}
