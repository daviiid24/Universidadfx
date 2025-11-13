package co.edu.uniquindio.universidadfx.model;

import java.util.ArrayList;

public class Universidad {

    private String nombre;

    private ArrayList<Estudiante> listaEstudiantes = new ArrayList();
    private ArrayList<Curso> listaCursos = new ArrayList();
    private ArrayList<Docente> listaDocentes = new ArrayList();
    private Rector rector;
    private ArrayList<Persona> listaPersonas = new ArrayList<>();

    public Universidad() {
    }

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public ArrayList<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public Rector getRector() {
        return rector;
    }

    public void setRector(Rector rector) {
        this.rector = rector;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public Estudiante crearEstudiante(String nombre,
                                      String apellido,
                                      int edad,
                                      double nota1,
                                      double nota2,
                                      double nota3,
                                      String identificacion) {

        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if (estudianteEncontrado == null) {
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setEdad(edad);
            estudiante.setNota1(nota1);
            estudiante.setNota2(nota2);
            estudiante.setNota3(nota3);
            estudiante.setIdentificacion(identificacion);
            getListaEstudiantes().add(estudiante);

            return estudiante;
        } else {
            return null;
        }
    }

    public Estudiante eliminarEstudiante(String idEliminar) {
        Estudiante estudianteEncontrado = obtenerEstudiante(idEliminar);
        if (estudianteEncontrado != null) {
            getListaEstudiantes().remove(estudianteEncontrado);
            return estudianteEncontrado;
        } else {
            return null;
        }
    }

    public Estudiante actualizarEstudiante(String nombre, String apellido, int edad, double nota1, double nota2, double nota3, String identificacion) {
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if (estudianteEncontrado.getIdentificacion().equalsIgnoreCase(identificacion)) {
            estudianteEncontrado.setNombre(nombre);
            estudianteEncontrado.setApellido(apellido);
            estudianteEncontrado.setEdad(edad);
            estudianteEncontrado.setNota1(nota1);
            estudianteEncontrado.setNota2(nota2);
            estudianteEncontrado.setNota3(nota3);
            estudianteEncontrado.setIdentificacion(identificacion);

            return estudianteEncontrado;
        } else {
            return null;
        }
    }

    public Estudiante obtenerEstudiante(String identificacion) {
        Estudiante estudianteEncontrado = null;
        for (Estudiante estudiante : getListaEstudiantes()) {
            if (estudiante.getIdentificacion().equalsIgnoreCase(identificacion)) {
                estudianteEncontrado = estudiante;
                break;
            }
        }

        return estudianteEncontrado;
    }


    public Docente crearDocente(String nombre, String apellido,
                                int edad,
                                String correo, String identificacion) {

        Docente docenteEncontrado = obtenerDocente(identificacion);
        if (docenteEncontrado == null) {
            Docente docente = new Docente();
            docente.setApellido(apellido);
            docente.setNombre(nombre);
            docente.setEdad(edad);
            docente.setCorreo(correo);
            docente.setIdentificacion(identificacion);
            getListaDocentes().add(docente);

            return docente;
        } else {
            return null;
        }
    }

    public Docente eliminarDocente(String idEliminar) {
        Docente docenteEncontrado = obtenerDocente(idEliminar);
        if (docenteEncontrado != null) {
            getListaDocentes().remove(docenteEncontrado);
            return docenteEncontrado;
        } else {
            return null;
        }
    }

    public Docente actualizarDocente(String nombre, String apellido,
                                     int edad,
                                     String correo, String identificacion) {
        Docente docenteEncontrado = obtenerDocente(identificacion);
        if (docenteEncontrado.getIdentificacion().equalsIgnoreCase(identificacion)) {
            docenteEncontrado.setNombre(nombre);
            docenteEncontrado.setApellido(apellido);
            docenteEncontrado.setEdad(edad);
            docenteEncontrado.setCorreo(correo);
            docenteEncontrado.setIdentificacion(identificacion);

            return docenteEncontrado;
        } else {
            return null;
        }
    }

    public Docente obtenerDocente(String identificacion) {
        Docente docenteEncontrado = null;
        for (Docente docente : getListaDocentes()) {
            if (docente.getIdentificacion().equalsIgnoreCase(identificacion)) {
                docenteEncontrado = docente;
                break;
            }
        }

        return docenteEncontrado;
    }

    public Curso crearCurso(String nombre, String semestre, String grupo, double creditos, String jornada, String identificacion) {

        Curso cursoEncontrado = obtenerCurso(identificacion);
        if (cursoEncontrado == null) {
            Curso curso = new Curso();
            curso.setNombre(nombre);
            curso.setSemestre(semestre);
            curso.setGrupo(grupo);
            curso.setCreditos(creditos);
            curso.setJornada(jornada);
            curso.setIdentificacion(identificacion);
            getListaCursos().add(curso);

            return curso;
        } else {
            return null;
        }
    }

    public Curso eliminarCurso(String idEliminar) {
        Curso cursoEncontrado = obtenerCurso(idEliminar);
        if (cursoEncontrado != null) {
            getListaCursos().remove(cursoEncontrado);
            return cursoEncontrado;
        } else {
            return null;
        }
    }

    public Curso actualizarCurso(String nombre, String semestre, String grupo, double creditos, String jornada, String identificacion) {
        Curso cursoEncontrado = obtenerCurso(identificacion);
        if (cursoEncontrado.getIdentificacion().equalsIgnoreCase(identificacion)) {
            cursoEncontrado.setNombre(nombre);
            cursoEncontrado.setSemestre(semestre);
            cursoEncontrado.setGrupo(grupo);
            cursoEncontrado.setCreditos(creditos);
            cursoEncontrado.setJornada(jornada);
            cursoEncontrado.setIdentificacion(identificacion);

            return cursoEncontrado;
        } else {
            return null;
        }
    }

    public Curso obtenerCurso(String idCurso) {
        for (Curso curso : listaCursos) {
            if (curso.getIdentificacion().equals(idCurso)) {
                return curso; // debe devolver la referencia real, no una copia
            }
        }
        return null;
    }

    public Rector crearRector(String nombre, String apellido, int edad, String identificacion) {

        if (this.rector == null) {
            Rector rector = new Rector();
            rector.setNombre(nombre);
            rector.setApellido(apellido);
            rector.setEdad(edad);
            rector.setIdentificacion(identificacion);
            this.rector = rector;

            return rector;
        } else {
            return null;
        }
    }

    public Rector eliminarRector() {
        if (this.rector != null) {
            this.rector = null;
            return rector;
        } else {
            return null;
        }
    }

    public Rector actualizarRector(String nombre, String apellido, int edad, String identificacion) {

        if (this.rector != null) {
            rector.setNombre(nombre);
            rector.setApellido(apellido);
            rector.setEdad(edad);
            rector.setIdentificacion(identificacion);

            return rector;
        } else {
            return null;
        }
    }

    public Rector obtenerRector() {
        return this.rector;
    }

    public boolean asociarCursoADocente(String idDocente, String idCurso) {
        Docente docente = obtenerDocente(idDocente);
        Curso curso = obtenerCurso(idCurso);

        if (docente == null || curso == null) {
            System.out.println("Docente o curso no encontrados");
            return false;
        }

        if (curso.getDocenteAsociado() != null && curso.getDocenteAsociado().equals(docente)) {
            System.out.println("El curso ya está asociado a este docente");
            return false;
        }

        if (curso.getDocenteAsociado() != null && !curso.getDocenteAsociado().equals(docente)) {
            System.out.println("El curso ya está asociado a otro docente");
            return false;
        }

        if (docente.getListaCursosAsociados().contains(curso)) {
            System.out.println("El docente ya tiene este curso asociado");
            return false;
        }

        curso.setDocenteAsociado(docente);
        docente.getListaCursosAsociados().add(curso);
        docente.actualizarCursosAsociadosTexto();
        curso.actualizarEstudiantesAsociadosTexto();
        return true;
    }



    public boolean desasociarCursoDeDocente(String idDocente, String idCurso) {
        Docente docente = obtenerDocente(idDocente);
        Curso curso = obtenerCurso(idCurso);
        if (docente != null && curso != null && curso.getDocenteAsociado() == docente) {
            docente.getListaCursosAsociados().remove(curso);
            curso.setDocenteAsociado(null);
            docente.actualizarCursosAsociadosTexto();
            curso.actualizarEstudiantesAsociadosTexto();
            return true;
        }
        return false;
    }

    public boolean asociarEstudianteACurso(String idEstudiante, String idCurso) {
        Estudiante estudiante = obtenerEstudiante(idEstudiante);
        Curso curso = obtenerCurso(idCurso);

        if (estudiante == null || curso == null) {
            System.out.println("Estudiante o curso no encontrados");
            return false;
        }

        if (curso.getListaEstudiantesAsociados().contains(estudiante)) {
            System.out.println("El estudiante ya está asociado a este curso");
            return false;
        }

        if (estudiante.getListaCursosAsociados().contains(curso)) {
            System.out.println("El curso ya está en la lista del estudiante");
            return false;
        }
            curso.getListaEstudiantesAsociados().add(estudiante);
            estudiante.getListaCursosAsociados().add(curso);
            curso.actualizarEstudiantesAsociadosTexto();
            estudiante.actualizarCursosAsociadosTexto();
            return true;
    }

    public boolean desasociarEstudianteACurso(String idEstudiante, String idCurso) {
        Estudiante estudiante = obtenerEstudiante(idEstudiante);
        Curso curso = obtenerCurso(idCurso);
        if (curso != null && estudiante != null && curso.getListaEstudiantesAsociados().contains(estudiante)) {
            curso.getListaEstudiantesAsociados().remove(estudiante);
            estudiante.getListaCursosAsociados().remove(curso);
            curso.actualizarEstudiantesAsociadosTexto();
            estudiante.actualizarCursosAsociadosTexto();
            return true;
        }
        return false;
    }

    public void calcularDefinitivaEstudiante(String idDocente) {
        Docente docenteEncontrado = obtenerDocente(idDocente);

        if (docenteEncontrado != null) {
            for (Estudiante estudiante : getListaEstudiantes()) {
                double definitiva= docenteEncontrado.calcularDefinitivaEstudiante(estudiante.getNota1(),
                        estudiante.getNota2(),
                        estudiante.getNota3());
                System.out.println("Nota definitiva del estudiante: " + estudiante.getNombre() + " es" + definitiva);
            }
        }
    }


    public void calcularEstudianteMayorEstatura(String idDocente) {
        Docente docenteEncontrado = obtenerDocente(idDocente);
        if (docenteEncontrado != null) {
                Estudiante mayor= docenteEncontrado.mostrarEstudianteMayorEstatura();
                System.out.println("Nota definitiva del estudiante: " + mayor.getNombre());
            }
        }
    }
public String obtenerEstudiantesNotaMayor4() {
    String estudiantes="";

    for (Curso curso : listaEstudi) {
        for (Estudiante e : curso.getListaEstudiantesAsociados()) {
            if (e.getNota5() > 4.3) {
                estudiantes.add(e);
            }
        }
    }

    return estudiantes;
}


}









