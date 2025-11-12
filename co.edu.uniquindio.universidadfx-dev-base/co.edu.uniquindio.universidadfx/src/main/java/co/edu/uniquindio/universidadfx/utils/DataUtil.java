package co.edu.uniquindio.universidadfx.utils;


import co.edu.uniquindio.universidadfx.model.*;

public class DataUtil {

    public static Universidad inicializarDatos() {
        Universidad universidad = new Universidad();
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Pedro");
        estudiante1.setApellido("Perez");
        estudiante1.setEdad(20);
        estudiante1.setNota1(3.0);
        estudiante1.setNota1(4.0);
        estudiante1.setNota1(2.0);
        estudiante1.setIdentificacion("1094");
        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Ana");
        estudiante2.setApellido("Arias");
        estudiante2.setEdad(23);
        estudiante2.setNota1(2.0);
        estudiante2.setNota1(3.0);
        estudiante2.setNota1(1.0);
        estudiante2.setIdentificacion("1095");
        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombre("Carlos");
        estudiante3.setApellido("Perez");
        estudiante3.setEdad(20);
        estudiante3.setNota1(3.0);
        estudiante3.setNota1(3.0);
        estudiante3.setNota1(3.0);
        estudiante3.setIdentificacion("1096");

        Docente docente = new Docente();
        docente.setNombre("Juan");
        docente.setApellido("Pérez");
        docente.setEdad(35);
        docente.setIdentificacion("123456789");
        docente.setEstatura(1.75);
        docente.setCorreo("juan.perez@universidad.edu");
        docente.setOwnedByUniversidad(universidad);

        Curso curso = new Curso();
        curso.setNombre("Curso");
        curso.setSemestre("10");
        curso.setGrupo("04N");
        curso.setCreditos(4);
        curso.setJornada("Diurna");
        curso.setIdentificacion("1095");
        curso.setDocenteAsociado(docente);
        curso.getListaEstudiantesAsociados().add(estudiante1);
        curso.getListaEstudiantesAsociados().add(estudiante2);
        curso.getListaEstudiantesAsociados().add(estudiante3);
        curso.actualizarEstudiantesAsociadosTexto();

        docente.getListaCursosAsociados().add(curso);
        docente.actualizarCursosAsociadosTexto();

        Rector rector = new Rector();
        rector.setNombre("Pedro");
        rector.setApellido("Perez");
        rector.setEdad(20);
        rector.setIdentificacion("1094");


        universidad.getListaEstudiantes().add(estudiante1);
        universidad.getListaEstudiantes().add(estudiante2);
        universidad.getListaEstudiantes().add(estudiante3);
        universidad.getListaDocentes().add(docente);
        universidad.getListaCursos().add(curso);

        return universidad;
    }
}
