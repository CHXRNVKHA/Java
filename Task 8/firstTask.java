/**
 * firstTask
 */
public class firstTask {

    public static void main(String[] args) {
        Engineer eng = new Engineer("name1", "surname1");
        eng.setTask("task1");
        System.out.println(eng.getTask());
        eng.resolveTask("task2");
        System.out.println(eng.getTask() + " " + eng.isTaskResolve);
        Boss b = new Boss("bName", "bSurname", "Dep1");
        b.checkTask(eng.isTaskResolve);
    }
}

/**
 * employee
 */
interface employee {
    void resolveTask();
    void setPremium(int premium);
}

/**
 * Engineer
 */
class Engineer implements employee {
    private int experience;
    private String name;
    private String surname;
    boolean isTaskResolve;
    private int premium;
    String task;
    Engineer() {

    }

    Engineer(String name, String surname) {
        this.name = name;
        this.surname = name;
    }

    void setTask(String task) {
        this.task = task;
    }
    
    String getTask() {
        return this.task;
    }

    public void resolveTask() {
        this.isTaskResolve = true;
    }

    public void resolveTask(String nextTask) {
        this.isTaskResolve = false;
        this.task = nextTask;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    int getPremium() {
        return this.premium;
    }

    void setExperience(int experience) {
        this.experience = experience;
    }

    int getExperience() {
        return this.experience;
    }

    String getName() {
        return this.name + " " + this.surname;
    }
}

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