package co.edu.uniquindio.universidadfx.viewcontroller;

public class ControllerCommunicator {
    private static CrudCursoViewController crudCursoViewController;
    private static CrudDocenteViewController crudDocenteViewController;

    public static CrudCursoViewController getCrudCursoViewController() {
        return crudCursoViewController;
    }

    public static void setCrudCursoViewController(CrudCursoViewController controller) {
        crudCursoViewController = controller;
    }

    public static CrudDocenteViewController getCrudDocenteViewController() {
        return crudDocenteViewController;
    }
    public static void setCrudDocenteViewController(CrudDocenteViewController controller) {
        crudDocenteViewController = controller;
    }
}
