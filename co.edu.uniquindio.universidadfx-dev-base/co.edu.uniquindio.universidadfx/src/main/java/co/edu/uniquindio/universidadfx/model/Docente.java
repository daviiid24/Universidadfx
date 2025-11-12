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


    public String mostrarEstudianteMayorEstatura(Estudiante estudiante1, Estudiante estudiante2, Estudiante estudiante3) {
        String resultado = "";
        if (estudiante1.getEstatura() > estudiante2.getEstatura() && estudiante1.getEstatura() > estudiante3.getEstatura()) {
            resultado = estudiante1.getNombre() + " " + estudiante1.getApellido();
        } else if (estudiante2.getEstatura() > estudiante3.getEstatura()) {
            resultado = estudiante2.getNombre() + " " + estudiante2.getApellido();
        } else {
            resultado = estudiante3.getNombre() + " " + estudiante3.getApellido();
        }

        return resultado;
    }

    public String obtenerEstudianteNotaMayor4(Estudiante estudiante) {
        String resultado = "";
        if (estudiante.getNota5() > 4.3) {
            resultado = estudiante.getNombre() + " " + estudiante.getApellido();
        }
        return resultado;
    }

    public void agregarCurso(Curso curso) {
        if (!listaCursosAsociados.contains(curso)) {
            listaCursosAsociados.add(curso);
            curso.setDocenteAsociado(this);

            if (this.ownedByUniversidad != null) {
                curso.setOwnedByUniversidad(this.ownedByUniversidad);
            }
            actualizarCursosAsociadosTexto();
        }
    }

    public void eliminarCurso(Curso curso) {
        if (listaCursosAsociados.contains(curso)) {
            listaCursosAsociados.remove(curso);
            curso.setDocenteAsociado(null);
        }
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
