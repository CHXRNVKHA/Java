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