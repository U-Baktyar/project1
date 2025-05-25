package org.example.controller;

public class ExitController {
    private static volatile ExitController exitController;
    private ExitController() {}
    public static ExitController getInstance() {
        if (exitController == null) {
            synchronized (ExitController.class) {
                if (exitController == null) {
                    exitController = new ExitController();
                }
            }
        }
        return exitController;

    }

    public void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
