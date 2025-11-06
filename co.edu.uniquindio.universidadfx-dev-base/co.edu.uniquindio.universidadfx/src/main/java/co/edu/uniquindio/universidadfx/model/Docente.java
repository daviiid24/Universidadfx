package co.edu.uniquindio.universidadfx.model;

public class Docente extends Persona {

    private String correo;

    public Docente() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double calcularDefinitivaEstudiante(double nota1, double nota2, double nota3) {
        double definitiva = (nota1 + nota2 + nota3)/3;
        return definitiva;
    }


    public String mostrarEstudianteMayorEstatura(Estudiante estudiante1, Estudiante estudiante2, Estudiante estudiante3) {
        String resultado = "";
        if(estudiante1.getEstatura() > estudiante2.getEstatura() && estudiante1.getEstatura() > estudiante3.getEstatura()) {
            resultado = estudiante1.getNombre()+" "+ estudiante1.getApellido();
        } else if (estudiante2.getEstatura() > estudiante3.getEstatura()) {
            resultado = estudiante2.getNombre()+" "+ estudiante2.getApellido();
        }else{
            resultado = estudiante3.getNombre()+" "+ estudiante3.getApellido();
        }

        return resultado;
    }
    public String obtenerEstudianteNotaMayor4 (Estudiante estudiante) {
        String resultado = "";
        if(estudiante.getNota5() > 4.3) {
            resultado = estudiante.getNombre()+" "+estudiante.getApellido();
        }
        return resultado;
    }
}
