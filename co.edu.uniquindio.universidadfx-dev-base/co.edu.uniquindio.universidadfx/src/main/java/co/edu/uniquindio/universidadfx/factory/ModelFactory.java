package co.edu.uniquindio.universidadfx.factory;

import co.edu.uniquindio.universidadfx.model.*;
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

    public Estudiante crearEstudiante(String nombre, String apellido, String identificacion, String edad, String nota1, String nota2, String nota3) {
        return universidad.crearEstudiante(
                nombre,
                apellido,
                Integer.parseInt(edad),
                Double.parseDouble(nota1),
                Double.parseDouble(nota2),
                Double.parseDouble(nota3),
                identificacion);
    }
    public Estudiante actualizarEstudiante(String nombre, String apellido, String identificacion, String edad, String nota1, String nota2, String nota3) {
        return universidad.actualizarEstudiante(
                nombre,
                apellido,
                Integer.parseInt(edad),
                Double.parseDouble(nota1),
                Double.parseDouble(nota2),
                Double.parseDouble(nota3),
                identificacion);
    }
    public Estudiante eliminarEstudiante(String identificacion) {
        return universidad.eliminarEstudiante(identificacion);
    }

    public List<Docente> obtenerDocentes() {
        return universidad.getListaDocentes();
    }

    public Docente crearDocente(String nombre,String apellido,String identificacion,String edad,String correo) {
        return universidad.crearDocente(
                nombre, apellido,Integer.parseInt(edad), correo, identificacion);
    }
    public Docente actualizarDocente(String nombre,String apellido,String identificacion,String edad,String correo) {
        return universidad.actualizarDocente(nombre, apellido,Integer.parseInt(edad), correo, identificacion);
    }
    public Docente eliminarDocente(String identificacion) {
        return universidad.eliminarDocente(identificacion);
    }

    public List<Curso> obtenerCursos() {
        return universidad.getListaCursos();
    }

    public Curso crearCurso(String nombre,String semestre, String grupo, String creditos, String jornada, String identificacion) {
        return universidad.crearCurso(
                nombre, semestre, grupo, Double.parseDouble(creditos), jornada, identificacion);
    }
    public Curso actualizarCurso(String nombre,String semestre, String grupo, String creditos, String jornada, String identificacion) {
        return universidad.actualizarCurso(
                nombre, semestre, grupo, Double.parseDouble(creditos), jornada, identificacion);
    }
    public Curso eliminarCurso(String identificacion) {
        return universidad.eliminarCurso(identificacion);
    }


    public boolean asociarDocenteCurso(String idDocente, String idCurso) {
        return universidad.asociarCursoADocente(idDocente, idCurso);
    }
}
