package co.edu.uniquindio.universidadfx.model;

import java.util.ArrayList;

public class Curso {
        private String nombre;
        private String semestre;
        private String grupo;
        private double creditos;
        private String jornada;
        private String identificacion;
        private Docente docenteAsociado;
        private String nombreDocenteAsociado;
        private ArrayList<Estudiante> listaEstudiantesAsociados = new ArrayList<>();
        private String estudiantesAsociadosTexto;
        private Universidad ownedByUniversidad;
        public Curso(){

        }
    public Curso(ArrayList<Estudiante> listaEstudiantesAsociados) {
        actualizarEstudiantesAsociadosTexto();
    }


    public Curso(String nombre, String semestre, String grupo, double creditos, String jornada, String identificacion, Universidad ownedByUniversidad) {
            this.nombre = nombre;
            this.semestre = semestre;
            this.grupo = grupo;
            this.creditos = creditos;
            this.jornada = jornada;
            this.identificacion = identificacion;
            this.listaEstudiantesAsociados = new ArrayList<>();
            this.ownedByUniversidad = ownedByUniversidad;
        }


    public void agregarEstudiante(Estudiante estudiante) {
            if (!listaEstudiantesAsociados.contains(estudiante)) {
                listaEstudiantesAsociados.add(estudiante);
                estudiante.agregarCurso(this);
            } if (this.ownedByUniversidad != null) {
                estudiante.setOwnedByUniversidad(this.ownedByUniversidad);
            }
        }

        public void eliminarEstudiante(Estudiante estudiante) {
            if (listaEstudiantesAsociados.contains(estudiante)) {
                listaEstudiantesAsociados.remove(estudiante);
                estudiante.eliminarCurso(this);
            }
        }

        public Docente getDocenteAsociado() {
            return docenteAsociado;
        }

        public void setDocenteAsociado(Docente docenteAsociado) {
            this.docenteAsociado = docenteAsociado;
        }

        public ArrayList<Estudiante> getListaEstudiantesAsociados() {
            return listaEstudiantesAsociados;
        }

        public void setListaEstudiantesAsociados(ArrayList<Estudiante> listaEstudiantesAsociados) {
            this.listaEstudiantesAsociados = listaEstudiantesAsociados;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getSemestre() {
            return semestre;
        }

        public void setSemestre(String semestre) {
            this.semestre = semestre;
        }

        public String getGrupo() {
            return grupo;
        }

        public void setGrupo(String grupo) {
            this.grupo = grupo;
        }

        public double getCreditos() {
            return creditos;
        }

        public void setCreditos(double creditos) {
            this.creditos = creditos;
        }

        public String getJornada() {
            return jornada;
        }

        public void setJornada(String jornada) {
            this.jornada = jornada;
        }

        public String getIdentificacion() {
            return identificacion;
        }

        public void setIdentificacion(String identificacion) {
            this.identificacion = identificacion;
        }

        public Universidad getOwnedByUniversidad() {
            return ownedByUniversidad;
        }

        public void setOwnedByUniversidad(Universidad ownedByUniversidad) {
            this.ownedByUniversidad = ownedByUniversidad;
        }

    public String getEstudiantesAsociadosTexto() {
        return estudiantesAsociadosTexto;
    }

    public void setEstudiantesAsociadosTexto(String estudiantesAsociadosTexto) {
        this.estudiantesAsociadosTexto = estudiantesAsociadosTexto;
    }

    public void actualizarEstudiantesAsociadosTexto() {
        if (listaEstudiantesAsociados == null || listaEstudiantesAsociados.isEmpty()) {
            estudiantesAsociadosTexto = "Sin estudiantes";
        } else {
            String texto = "";
            for (int i = 0; i < listaEstudiantesAsociados.size(); i++) {
                texto += listaEstudiantesAsociados.get(i).getNombre();
                if (i < listaEstudiantesAsociados.size() - 1) {
                    texto += ", ";
                }
            }
            estudiantesAsociadosTexto = texto;
        }
    }

    public String getNombreDocenteAsociado() {
        if (docenteAsociado != null) {
            return docenteAsociado.getNombre() + " " + docenteAsociado.getApellido();
        } else {
            return "Sin docente";
        }
    }


    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", semestre='" + semestre + '\'' +
                ", grupo='" + grupo + '\'' +
                ", creditos=" + creditos +
                ", jornada='" + jornada + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", docenteAsociado=" + docenteAsociado +
                ", listaEstudiantesAsociados=" + listaEstudiantesAsociados +
                ", ownedByUniversidad=" + ownedByUniversidad +
                '}';
    }
}
