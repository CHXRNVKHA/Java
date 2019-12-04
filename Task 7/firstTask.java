import java.util.Scanner;

/**
 * firstTask
 */
public class firstTask {

    public static void main(String[] args) {
        
    }
}

/**
 * Gun
 */
class Gun {
    int length;
    int weight;
    int clipCapacity;
    String ammoType;
    int ammo;

    Gun() {

    }
    
    Gun(int clipCapacity) {
        this.clipCapacity = clipCapacity;
        this.ammo = clipCapacity;
    }

    boolean isClipEmpty() {
        if (this.ammo == 0) return true;
        return false;
    }

    void reload() {
        this.ammo = this.clipCapacity;
    }

    void fire() {
        if (!isClipEmpty()) {
            this.ammo--;
        }
        else {
            System.out.println("Reload Gun!!!");
        }
    }
}

/**
 * Rifle
 */
class Rifle extends Gun {
    String type;
    String name;
    Rifle(int clipCapacity, String name) {
        super(clipCapacity);
        this.name = name;
    }
}

/**
 * AssaultRifle
 */
class AssaultRifle extends Rifle {
    String fireMode;
    AssaultRifle(int clipCapacity, String name, String fireMode) {
        super(clipCapacity, name);
        this.fireMode = fireMode;
    }

    void reload (int clipCapacity) {
        this.clipCapacity = clipCapacity;
        this.ammo = clipCapacity;
    }

    void changeFireMode() {
        System.out.println("choose fire mode");
        System.out.println("\t 1 - single");
        System.out.println("\t 2 - bursting");
        System.out.println("\t 3 - automatic");
        Scanner in = new Scanner(System.in);
        this.fireMode = in.nextLine();
        in.close();
        System.out.println("\t switched to" + this.fireMode + "fire mode");
    }
    
    void fire() {
        switch(this.fireMode) {
            case "single": {
                super.fire();
                break;
            }
            case "bursting": {
                if (!isClipEmpty()) {
                    this.ammo -= 3;
                }
                else {
                    System.out.println("Reload Gun!!!");
                }
                break;
            }
            case "automatic": {
                if (!isClipEmpty()) {
                    while (!isClipEmpty()) {
                        this.ammo--;
                    }
                }
                else {
                    System.out.println("Reload Gun!!!");
                }
                break;
            }
        }
    }
}