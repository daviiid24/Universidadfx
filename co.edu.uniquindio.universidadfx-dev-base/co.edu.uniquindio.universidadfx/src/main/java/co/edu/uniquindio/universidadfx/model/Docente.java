package co.edu.uniquindio.universidadfx.model;

import java.util.ArrayList;

public class Docente extends Persona {

    private String correo;

    private ArrayList<Curso> listaCursosAsociados = new ArrayList<>();
    private String cursosAsociadosTexto;
    private Universidad ownedByUniversidad;

    public Docente() {
    }
    public Docente(ArrayList<Curso> listaCursosAsociados) {
        actualizarCursosAsociadosTexto();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Curso> getListaCursosAsociados() {
        return listaCursosAsociados;
    }

    public void setListaCursosAsociados(ArrayList<Curso> listaCursosAsociados) {
        this.listaCursosAsociados = listaCursosAsociados;
    }

    public String getCursosAsociadosTexto() {
        return cursosAsociadosTexto;
    }

    public void setCursosAsociadosTexto(String cursosAsociadosTexto) {
        this.cursosAsociadosTexto = cursosAsociadosTexto;
    }

    public Universidad getOwnedByUniversidad() {
        return ownedByUniversidad;
    }

    public void setOwnedByUniversidad(Universidad ownedByUniversidad) {
        this.ownedByUniversidad = ownedByUniversidad;
    }

    public double calcularDefinitivaEstudiante(double nota1, double nota2, double nota3) {
        double definitiva = (nota1 + nota2 + nota3) / 3;
        return definitiva;
    }

    public Estudiante mostrarEstudianteMayorEstatura() {
        Estudiante mayor = null;

        for (Curso curso : listaCursosAsociados) {
            for (Estudiante estudiante : curso.getListaEstudiantesAsociados()) {
                if (mayor == null || estudiante.getEstatura() > mayor.getEstatura()) {
                    mayor = estudiante;
                }
            }
        }
        return mayor;
    }


    public String obtenerEstudiantesNotaMayor4() {

        String estudiantesNotaMayor = "";

        for (Curso curso : listaCursosAsociados) {
            for (Estudiante estudiante : curso.getListaEstudiantesAsociados()) {
                if (calcularDefinitivaEstudiante(estudiante.getNota1(), estudiante.getNota2(), estudiante.getNota3()) > 4.0) {
                    estudiantesNotaMayor += estudiante.getNombre();
                }
            }
        }

        return estudiantesNotaMayor;
    }


    public void actualizarCursosAsociadosTexto() {
        if (listaCursosAsociados == null || listaCursosAsociados.isEmpty()) {
            cursosAsociadosTexto = "Sin clases";
        } else {
            String texto = "";
            for (int i = 0; i < listaCursosAsociados.size(); i++) {
                texto += listaCursosAsociados.get(i).getNombre();
                if (i < listaCursosAsociados.size() - 1) {
                    texto += ", ";
                }
            }
            cursosAsociadosTexto = texto;
        }
    }

}
