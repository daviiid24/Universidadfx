package co.edu.uniquindio.universidadfx.utils;


import co.edu.uniquindio.universidadfx.model.*;

public class DataUtil {

    public static Universidad inicializarDatos() {
        Universidad universidad = new Universidad();
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Pedro");
        estudiante1.setApellido("Perez");
        estudiante1.setEdad(20);
        estudiante1.setCorreo("juan.perez@universidad.edu");
        estudiante1.setSemestre("10");
        estudiante1.setNota1(5.0);
        estudiante1.setNota2(5.0);
        estudiante1.setNota3(5.0);
        estudiante1.setNota4(5.0);
        estudiante1.setNota5(5.0);
        estudiante1.setIdentificacion("1094");
        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Ana");
        estudiante2.setApellido("Arias");
        estudiante2.setEdad(23);
        estudiante2.setNota1(2.4);
        estudiante2.setNota2(3.9);
        estudiante2.setNota3(1.8);
        estudiante2.setIdentificacion("1095");
        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombre("Carlos");
        estudiante3.setApellido("Perez");
        estudiante3.setEdad(20);
        estudiante3.setNota1(3.0);
        estudiante3.setNota2(3.0);
        estudiante3.setNota3(3.0);
        estudiante3.setIdentificacion("1096");

        Docente docente = new Docente();
        docente.setNombre("Juan");
        docente.setApellido("Pérez");
        docente.setEdad(35);
        docente.setIdentificacion("123456789");
        docente.setEstatura(1.75);
        docente.setCorreo("juan.perez@universidad.edu");
        docente.setOwnedByUniversidad(universidad);

        Docente docente1 = new Docente();
        docente1.setNombre("Ju");
        docente1.setApellido("Pérez");
        docente1.setEdad(50);
        docente1.setIdentificacion("1234567890");
        docente1.setCorreo("ju.perez@universidad.edu");
        docente1.setOwnedByUniversidad(universidad);

        Curso curso = new Curso();
        curso.setNombre("Curso");
        curso.setSemestre("10");
        curso.setGrupo("04N");
        curso.setCreditos(4);
        curso.setJornada("Diurna");
        curso.setIdentificacion("1095");
        curso.setDocenteAsociado(docente);


        Curso curso1 = new Curso();
        curso1.setNombre("Fisica");
        curso1.setSemestre("10");
        curso1.setGrupo("05N");
        curso1.setCreditos(5);
        curso1.setJornada("Nocturna");
        curso1.setIdentificacion("1096");


        curso.getListaEstudiantesAsociados().add(estudiante1);
        curso.getListaEstudiantesAsociados().add(estudiante2);
        curso.getListaEstudiantesAsociados().add(estudiante3);
        curso.actualizarEstudiantesAsociadosTexto();
        curso1.actualizarEstudiantesAsociadosTexto();

        docente.getListaCursosAsociados().add(curso);
        docente.actualizarCursosAsociadosTexto();
        docente1.actualizarCursosAsociadosTexto();

        Rector rector = new Rector();
        rector.setNombre("Pedro");
        rector.setApellido("Perez");
        rector.setEdad(20);
        rector.setIdentificacion("1094");


        universidad.getListaEstudiantes().add(estudiante1);
        universidad.getListaEstudiantes().add(estudiante2);
        universidad.getListaEstudiantes().add(estudiante3);
        universidad.getListaDocentes().add(docente);
        universidad.getListaDocentes().add(docente1);
        universidad.getListaCursos().add(curso);
        universidad.getListaCursos().add(curso1);

        return universidad;
    }
}
