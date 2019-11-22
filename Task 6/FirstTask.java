/**
 * FirstTask
 */
public class FirstTask {
    public static void main(String[] args) {
        
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

   
}

