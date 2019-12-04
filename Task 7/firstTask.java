import java.util.Scanner;

/**
 * firstTask
 */
public class firstTask {

    public static void main(String[] args) {
        Gun myGun = new Gun(5);
        System.out.println("ammo - " + myGun.ammo);
        myGun.fire();
        System.out.println("ammo - " + myGun.ammo);
        Rifle myRifle = new Rifle(5, "mosinka");
        myRifle.ammo = 1;
        myRifle.fire();
        myRifle.fire();
        myRifle.ammo = 1;
        myRifle.fire();
        myRifle.fire();
        System.out.println("ammo - " + myRifle.ammo);
        myRifle.reload();
        myRifle.fire();
        System.out.println("ammo - " + myRifle.ammo);
        System.out.println("ammo - " + myRifle.ammo);
        AssaultRifle myAssaultRifle = new AssaultRifle(30, "stg 44", "single");
        System.out.println("ammo - " + myAssaultRifle.ammo);
        myAssaultRifle.fire();
        System.out.println("ammo - " + myAssaultRifle.ammo);
        myAssaultRifle.fireMode = "bursting";
        myAssaultRifle.fire();
        System.out.println("ammo - " + myAssaultRifle.ammo);
        myAssaultRifle.reload(45);
        System.out.println("ammo - " + myAssaultRifle.ammo);
        myAssaultRifle.fireMode = "automatic";
        myAssaultRifle.fire();
        System.out.println("ammo - " + myAssaultRifle.ammo);
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
            System.out.println("Reload Gun!!!(input \'1\')");
            Scanner in = new Scanner(System.in);
            if (in.nextInt() == 1) {
                this.reload();
            }
            System.out.println("Gun Ready!!!");
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
        Scanner in1 = new Scanner(System.in);
        int txt = in1.nextInt();
        switch (txt) {
            case 1: {
                this.fireMode = "single";
                break;
            }
            case 2: {
                this.fireMode = "bursting";
                break;
            }
            case 3: {
                this.fireMode = "automatic";
                break;
            }
        }
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
                    System.out.println("Reload Gun!!!(input \'1\')");
                    Scanner in = new Scanner(System.in);
                    if (in.nextInt() == 1) {
                        this.reload();
                    }
                    System.out.println("Gun Ready!!!");
                }
                break;
            }
            case "automatic": {
                if (!isClipEmpty()) {
                    while (!isClipEmpty()) {
                        this.ammo--;
                        System.out.println("Shoot!");
                    }
                }
                else {
                    System.out.println("Reload Gun!!!(input \'1\')");
                    Scanner in = new Scanner(System.in);
                    if (in.nextInt() == 1) {
                        this.reload();
                    } 
                    System.out.println("Gun Ready!!!");
                }
                System.out.println("Reload Gun!!!(input \'1\')");
                Scanner in = new Scanner(System.in);
                if (in.nextInt() == 1) {
                    this.reload();
                } 
                System.out.println("Gun Ready!!!");
                break;
            }
        }
    }
}