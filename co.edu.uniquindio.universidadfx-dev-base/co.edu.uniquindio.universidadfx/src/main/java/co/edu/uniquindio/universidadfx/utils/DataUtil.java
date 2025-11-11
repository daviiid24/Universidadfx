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

        Curso curso1 = new Curso();
        curso1.setNombre("Fisica");
        curso1.setGrupo("04N");
        Curso curso2 = new Curso();
        curso2.setNombre("Matematicas");
        curso2.setGrupo("04N");
        Curso curso3 = new Curso();
        curso3.setNombre("Español");
        curso3.setGrupo("04N");

// Crear el docente y asociar los cursos
        Docente docente = new Docente();
        docente.setNombre("Juan");
        docente.setApellido("Pérez");
        docente.setEdad(35);
        docente.setIdentificacion("123456789");
        docente.setEstatura(1.75);
        docente.setCorreo("juan.perez@universidad.edu");
        docente.setOwnedByUniversidad(universidad);

// Asignar los cursos al docente
        docente.agregarCurso(curso1);
        docente.agregarCurso(curso2);
        docente.agregarCurso(curso3);

// Actualizar texto de los cursos asociados
        docente.actualizarCursosAsociadosTexto();

// Mostrar los datos de los cursos asociados
        System.out.println("Cursos asociados al docente: " + docente.getCursosAsociadosTexto());

        universidad.getListaEstudiantes().add(estudiante1);
        universidad.getListaEstudiantes().add(estudiante2);
        universidad.getListaEstudiantes().add(estudiante3);
        universidad.getListaDocentes().add(docente);

        return universidad;
    }
}
