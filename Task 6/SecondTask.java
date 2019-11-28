/**
 * SecondTask
 */
public class SecondTask {

    public static void main(String[] args) {
        homeElectricalApp microVawe = new homeElectricalApp();
        microVawe.setPriority(1);
        System.out.println(microVawe.getPriority());
    }
}

/**
 * electricalApp
 */
class homeElectricalApp {
    private int priority;
    private int capacity;
    private String name;
    private boolean on;

    homeElectricalApp() {

    }

    homeElectricalApp(int priority, int capacity, String name) {
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
        if (on) { 
            System.out.println("it is already on!");
        }
        else this.on = true;
    } 

    void turnOff() {
        if (!on) { 
            System.out.println("it is already off!");
        }
        else this.on = false;
    }   
    
    boolean isOn() {
        if (on) return true;
        return false;
    }
}