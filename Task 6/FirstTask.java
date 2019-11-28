/**
 * FirstTask
 */
public class FirstTask {
    public static void main(String[] args) {
        Engine engine = new Engine("good", true, 700);
        Chassis chassis = new Chassis("good", true, "some type");
        Wing wing = new Wing("good", true, 300);
        Plane plane = new Plane(engine, chassis, wing, "Berlin");  
        System.out.println(plane.isFly());
        plane.fly();
        System.out.println(plane.isFly());
    }
}
 /**
     * PlaneModule
     */
    class PlaneModule {
        protected String condition;
        protected boolean isReady;

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
    class Engine extends PlaneModule {
        private int power;
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
    class Chassis extends PlaneModule {
        private String tireType;
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
    class Wing extends PlaneModule {
        private int width;
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
        private String route;
        private Engine engine;
        private Chassis chassis;
        private boolean fly;
        private Wing wing;
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