package co.edu.uniquindio.universidadfx.model;

import java.util.ArrayList;

public class Estudiante extends Persona {

    private String correo;
    private String semestre;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double nota5;
    private ArrayList<Curso> listaCursosAsociados = new ArrayList<>();
    private String cursosAsociadosTexto;
    private Universidad ownedByUniversidad;

    public Estudiante() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public double getNota5() {
        return nota5;
    }

    public void setNota5(double nota5) {
        this.nota5 = nota5;
    }

    public Universidad getOwnedByUniversidad() {
        return ownedByUniversidad;
    }

    public void setOwnedByUniversidad(Universidad ownedByUniversidad) {
        this.ownedByUniversidad = ownedByUniversidad;
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

    public void actualizarCursosAsociadosTexto() {
        if (listaCursosAsociados == null || listaCursosAsociados.isEmpty()) {
            cursosAsociadosTexto = "Sin cursos";
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
