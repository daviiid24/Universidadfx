package co.edu.uniquindio.universidadfx.viewcontroller;

public class ControllerCommunicator {
    private static CrudCursoViewController crudCursoViewController;
    private static CrudDocenteViewController crudDocenteViewController;
    private static CrudEstudianteViewController crudEstudianteViewController;

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

    public static CrudEstudianteViewController getCrudEstudianteViewController() {
        return crudEstudianteViewController;
    }

    public static void setCrudEstudianteViewController(CrudEstudianteViewController controller) {
        crudEstudianteViewController = controller;
    }
}
