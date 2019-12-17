package app;

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