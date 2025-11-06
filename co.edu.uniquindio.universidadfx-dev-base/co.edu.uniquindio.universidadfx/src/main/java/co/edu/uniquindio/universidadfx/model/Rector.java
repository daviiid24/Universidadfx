package co.edu.uniquindio.universidadfx.model;

public class Rector extends Persona {
    private Universidad ownedByUniversidad;

    public Rector() {
    }

    public Universidad getOwnedByUniversidad() {
        return ownedByUniversidad;
    }

    public void setOwnedByUniversidad(Universidad ownedByUniversidad) {
        this.ownedByUniversidad = ownedByUniversidad;
    }
}
