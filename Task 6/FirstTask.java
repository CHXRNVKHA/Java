/**
 * FirstTask
 */
public class FirstTask {
    public static void main(String[] args) {
        Plane plane = new Plane();
    }

    /**
     * PlaneModule
     */
    public class PlaneModule {
        String condition;
        boolean isReady;

        PlaneModule() {}

        PlaneModule(String condition, boolean isReady) {
            this.condition = condition;
            this.isReady = isReady;
        }

        void setReadiness(boolean value) {
            this.isReady = value;
        }

        boolean getReadiness() {
            return this.isReady;
        }

        void setCondition(String value) {
            if (value.length() < 30) {
                this.condition = value;
            }
        }

        String getCondition() {
            if (this.condition.length() == 0) {
                return "Condition is empty";
            }
            else {
                return this.condition;
            }
        }
    }

    /**
     * Engine 
     */
    public class Engine extends PlaneModule {
        int power;
        Engine() {}
        Engine(String condition, boolean isReady, int power) {
            super(condition, isReady);
            this.power = power;
        }

        void setPower(int value) {
            this.power = value;
        }

        int getPower() {
            return this.power;
        }
    }

    /**
     * Chassis
     */
    public class Chassis extends PlaneModule {
        String tireType;
        Chassis() {}
        Chassis(String condition, boolean isReady, String tireType) {
            super(condition, isReady);
            this.tireType = tireType;
        }

        void setTireType(String value) {
            this.tireType = value;
        }

        String getTireType() {
            return this.tireType;
        }
    }

    /**
     * Wing
     */
    public class Wing extends PlaneModule {
        int width;
        Wing() {}
        Wing(String condition, boolean isReady, int width) {
            super(condition, isReady);
            this.width = width;
        }

        void setWidth(int value) {
            this.width = value;
        }

        int getWidth() {
            return this.width;
        }
    }

    /**
     * Plane
     */
    class Plane {
        String route;
        Engine engine;
        Chassis chassis;
        boolean fly;
        Wing wing;
        Plane() {}
        Plane(Engine engine, Chassis chassis, Wing wing, String route) {
            this.engine = engine;
            this.chassis = chassis;
            this.wing = wing;
            this.route = route;
        }

        void setWing(Wing value) {
            this.wing = value;
        }

        Wing getWing() {
            return this.wing;
        }

        void setEngine(Engine value) {
            this.engine = value;
        }

        Engine getEngine() {
            return this.engine;
        }

        void setChassis(Chassis value) {
            this.chassis = value;
        }

        Chassis getChassis() {
            return this.chassis;
        }

        void setRoute(String value) {
            this.route = value;
        }

        String getRoute() {
            return this.route;
        }

        void fly() {
            if(this.engine.isReady && this.wing.isReady && this.chassis.isReady) {
                this.fly = true;
            }
            else {
                this.fly = false;
            }
        }

        boolean isFly() {
            return this.fly;
        }
    }
}