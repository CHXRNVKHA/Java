package app;

/**
 * Boss 
 */
class Boss extends Engineer {
    String controlledDep;
    Boss() {

    }

    Boss(String name, String surname, String controlDep) {
        super(name, surname);
        this.controlledDep = controlDep;
    }

    void setControlledDep(String controlDep) {
        this.controlledDep = controlDep;
    }

    String getControlledDep() {
        return this.controlledDep;
    }

    void checkTask(Boolean isResolveTask) {
        if (isResolveTask) System.out.println("Done"); 
        System.out.println("Working"); 
    }

    void checkTask(Boolean[] task) {
        for (int i = 0; i < task.length; i++) {
            checkTask(task[i]);
        }
    }
}