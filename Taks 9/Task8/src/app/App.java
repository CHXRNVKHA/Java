package app;

public class App {
    public static void main(String[] args) throws Exception {
        Engineer eng = new Engineer("name1", "surname1");
        eng.setTask("task1");
        System.out.println(eng.getTask());
        eng.resolveTask("task2");
        System.out.println(eng.getTask() + " " + eng.isTaskResolve);
        Boss b = new Boss("bName", "bSurname", "Dep1");
        b.checkTask(eng.isTaskResolve);
    }
}