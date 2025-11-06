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
        //Obtener el estduiante
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if(estudianteEncontrado == null) {
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
        }else{
            return null;
        }
    }

    private Estudiante obtenerEstudiante(String identificacion) {
        Estudiante estudianteEncontrado =  null;
        for (Estudiante estudiante : getListaEstudiantes()) {
            if(estudiante.getIdentificacion().equalsIgnoreCase(identificacion)) {
                estudianteEncontrado = estudiante;
                break;
            }
        }

        return estudianteEncontrado;
    }

    public void calcularDefinitivaEstudiante(String cedulaDocente) {
        Docente docenteEncontrado = obtenerDocente(cedulaDocente);
        if(docenteEncontrado != null) {
            for (Estudiante estudiante : getListaEstudiantes()) {
                double definitiva = docenteEncontrado.calcularDefinitivaEstudiante(
                        estudiante.getNota1(),
                        estudiante.getNota2(),
                        estudiante.getNota3());
                System.out.println("Nota definitiva del estudiante: "+ estudiante.getNombre()+ " es: "+definitiva);
            }
        }
    }

    private Docente obtenerDocente(String cedulaDocente) {
        return null;
    }
}









