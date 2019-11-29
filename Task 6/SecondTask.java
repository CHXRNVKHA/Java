import java.util.ArrayList;
import java.util.Comparator;

/**
 * SecondTask
 */
public class SecondTask {

    public static void main(String[] args) {
        HomeElectricalApp microWave = new HomeElectricalApp(2, 300, "microWave");
        HomeElectricalApp tV = new HomeElectricalApp(4, 400, "tV");
        HomeElectricalApp computer = new HomeElectricalApp(1, 800, "computer");
        computer.turnOn();
        tV.turnOn();
        Flat myFlat = new Flat();
        myFlat.addApp(computer);
        myFlat.addApp(microWave);
        myFlat.addApp(tV);
        System.out.println(myFlat.countConsumePower());
        myFlat.showAllApps();
        myFlat.sortAppsByPower();
        myFlat.showAllApps();
        System.out.println(myFlat.findApp("computer").getName());
        myFlat.turnOnApp("microWave");
        System.out.println(myFlat.countConsumePower());
        myFlat.turnOffAll();
        System.out.println(myFlat.countConsumePower());
        myFlat.delApp("tV");
        myFlat.showAllApps();
    }
}

/**
 * Flat
 */
class Flat {
    private ArrayList<HomeElectricalApp> flatElectricalApps;

    Flat() {
        this.flatElectricalApps = new ArrayList<HomeElectricalApp>();
    }

    Flat(HomeElectricalApp apps[]) {
        this.flatElectricalApps = new ArrayList<HomeElectricalApp>();
        for (int i = 0; i < apps.length; i++) {
            this.flatElectricalApps.add(apps[i]);
        }
    }

    void addApp(HomeElectricalApp app) {
        this.flatElectricalApps.add(app);
    }

    void delApp(String name) {
        for (int i = 0; i < this.flatElectricalApps.size(); i++) {
            HomeElectricalApp currentApp = this.flatElectricalApps.get(i);
            if(currentApp.getName() == name) {
                this.flatElectricalApps.remove(i);
                break;
            }
        }
    }

    int countConsumePower() {
        int powerSum = 0;
        for (int i = 0; i < this.flatElectricalApps.size(); i++) {
            HomeElectricalApp currentApp = this.flatElectricalApps.get(i);
            if(currentApp.isOn()) powerSum += currentApp.getCapacity();
        }
        return powerSum;
    }

    void sortAppsByPower() {
        Comparator<HomeElectricalApp> comparator = new Comparator<HomeElectricalApp>() {
            public int compare(HomeElectricalApp app1, HomeElectricalApp app2) {
                int x = app1.getCapacity();
                int y = app2.getCapacity();
                return (x < y) ? -1 : ((x == y) ? 0 : 1);
            }
        };
        this.flatElectricalApps.sort(comparator);
    }

    void turnOnApp(String name) {
        HomeElectricalApp app = this.findApp(name);
        if (app != null) {
            app.turnOn();
        }
    }

    void turnOffApp(String name) {
        HomeElectricalApp app = this.findApp(name);
        if (app != null) {
            app.turnOff();
        }
    }

    void turnOnAll() {
        for (int i = 0; i < this.flatElectricalApps.size(); i++) {
            HomeElectricalApp currentApp = this.flatElectricalApps.get(i);
            currentApp.turnOn();
        }
    }

    void turnOffAll() {
        for (int i = 0; i < this.flatElectricalApps.size(); i++) {
            HomeElectricalApp currentApp = this.flatElectricalApps.get(i);
            currentApp.turnOff();
        }
    }

    HomeElectricalApp findApp(String name) {
        for (int i = 0; i < this.flatElectricalApps.size(); i++) {
            HomeElectricalApp currentApp = this.flatElectricalApps.get(i);
            if(currentApp.getName() == name) return currentApp;
        }
        return null;
    }

    HomeElectricalApp findApp(String name, int priority) {
        for (int i = 0; i < this.flatElectricalApps.size(); i++) {
            HomeElectricalApp currentApp = this.flatElectricalApps.get(i);
            if(currentApp.getName() == name && currentApp.getPriority() == priority) return currentApp;
        }
        return null;
    }

    HomeElectricalApp findApp(String name, int priority, int capacity) {
        for (int i = 0; i < this.flatElectricalApps.size(); i++) {
            HomeElectricalApp currentApp = this.flatElectricalApps.get(i);
            if (
                currentApp.getName() == name && 
                currentApp.getPriority() == priority && 
                currentApp.getCapacity() == capacity
            ) 
            return currentApp;
        }
        return null;
    }

    void showAllApps() {
        for (int i = 0; i < this.flatElectricalApps.size(); i++) {
            HomeElectricalApp currentApp = this.flatElectricalApps.get(i);
            System.out.println(
                "\t" + (i+1) + ". " + currentApp.getName() + 
                ": Power - " + currentApp.getCapacity() + 
                ": Priority - " + currentApp.getPriority()
            );   
        }
        System.out.println();
    }
}

/**
 * HomeElectricalApp
 */
class HomeElectricalApp {
    private int priority;
    private int capacity;
    private String name;
    private boolean on;

    HomeElectricalApp() {

    }

    HomeElectricalApp(int priority, int capacity, String name) {
        this.priority = priority;
        this.capacity = capacity;
        this.name = name;
    }

    void setPriority(int value) {
        this.priority = value;
    }

    int getPriority() {
        return this.priority;
    }

    void setCapacity(int value) {
        this.capacity = value;
    }

    int getCapacity() {
        return this.capacity;
    }

    void setName(String value) {
        this.name = value;
    }

    String getName() {
        return this.name;
    }

    void turnOn() {
        if (this.on) { 
            System.out.println("it is already on!");
        }
        else this.on = true;
    } 

    void turnOff() {
        if (!this.on) { 
            System.out.println("it is already off!");
        }
        else this.on = false;
    }   
    
    boolean isOn() {
        if (this.on) return true;
        return false;
    }
}