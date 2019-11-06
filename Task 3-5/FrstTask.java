/**
 * FrstTask
 */
public class FrstTask {

    public static void main(String[] args) {
        aeronauticalMetrology aero = new aeronauticalMetrology("task1","feat1","struct1","meas1");
        System.out.println(aero.GetHash());
        System.out.println(aero.GetString());
        System.out.println("includes: "+aero.includes("task1","feat1","struct1","meas1"));
        String[][] arr = aero.GetString(true);
        for(int i = 0; i<4; i++){
            for(int j = 0; j<2; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        arr = aero.GetString(true, true);
        for(int i = 0; i<4; i++){
            for(int j = 0; j<2; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        aero.setTasks("task2","task3","task4");
        System.out.println(aero.getTasks());
        aero.setFeatures("feat2","feat3");
        System.out.println(aero.getFeatures());
        System.out.println("includes: "+aero.includes("task1","feat1","struct1","meas1"));
        aeronauticalMetrology obj1 = new aeronauticalMetrology("task1","feat1","struct1","meas1");
        aeronauticalMetrology obj2 = new aeronauticalMetrology();
        medicalMetrology obj3 = new medicalMetrology();
        System.out.println("compare: "+aero.compare(aero));
        System.out.println("compare: "+aero.compare(obj1,obj2));
        System.out.println("compare: "+aero.compare(obj1, obj2, obj3));
    }
}
class aeronauticalMetrology  {
        String tasks;
        String features;
        String structure;
        String measuring;
        aeronauticalMetrology(){

        }
        aeronauticalMetrology(String tasks, String features, String structure, String measuring){
            this.tasks = tasks;
            this.features = features;
            this.structure = structure;
            this.measuring = measuring;
        }

        String getTasks(){
            return this.tasks;
        }

        String getFeatures(){
            return this.features;
        }

        void setTasks(String... values){
            for(String v : values){
                this.tasks += " " + v;
            }
        }

        void setFeatures(String... values){
            for(String v : values){
                this.features += " " + v;
            }
        }

        boolean includes(String tasks){
            if(this.tasks==tasks) return true;
            return false;
        }

        boolean includes(String tasks, String features){
            if(this.tasks==tasks&&this.features==features) return true;
            return false;
        }

        boolean includes(String tasks, String features, String struct){
            if(this.tasks==tasks&&this.features==features&&this.structure==struct) return true;
            return false;
        }

        boolean includes(String tasks, String features, String struct, String meas){
            if(this.tasks==tasks&&this.features==features&&this.structure==struct&&this.measuring==meas) return true;
            return false;
        }


        int GetHash(){
            int sum = this.tasks.hashCode()+this.features.hashCode()+this.structure.hashCode()+this.measuring.hashCode();
            return sum %= 4;
        }


        String GetString(){
            return this.toString();
        }

        String[][] GetString(boolean toArray){
            if(toArray){
                String[][] arr = new String[4][2];
                arr[0][0] = "tasks";
                arr[0][1] = this.tasks;
                arr[1][0] = "features";
                arr[1][1] = this.features;
                arr[2][0] = "structure";
                arr[2][1] = this.structure;
                arr[3][0] = "measuring";
                arr[3][1] = this.measuring;
                return arr;
            }
            return new String[0][0];       
        }

        String[][] GetString(boolean toArray, boolean withHash){
            if(toArray&&withHash){
                String[][] arr = new String[4][2];
                arr[0][0] = ""+this.tasks.hashCode();
                arr[0][1] = this.tasks;
                arr[1][0] = ""+this.features.hashCode();
                arr[1][1] = this.features;
                arr[2][0] = ""+this.structure.hashCode();
                arr[2][1] = this.structure;
                arr[3][0] = ""+this.measuring.hashCode();
                arr[3][1] = this.measuring;
                return arr;
            }
            return new String[0][0];       
        }

        boolean compare(Object obj){
            return this.equals(obj);
        }

        boolean compare(Object... values){
            for(Object v : values){
                if(this.equals(v)==false){
                    return false;
                }
            }
            return true;
        }  
    }

    /**
     * Applied Metrology
     */
    class chemicalMetrology {
        String tasks;
        String features;
        String structure;
        String measuring;
        chemicalMetrology(){
        
        }
        chemicalMetrology(String tasks, String features, String structure, String measuring){
            this.tasks = tasks;
            this.features = features;
            this.structure = structure;
            this.measuring = measuring;
        }
         int GetHash(){
            return this.GetHash();
        }

        String GetString(){
            return this.toString();
        }

        boolean Equal(Object obj){
            return this.Equal(obj);
        }
    }

    /**
     * Legal metrology
     */
    class medicalMetrology {
        String tasks;
        String features;
        String structure;
        String measuring;
        medicalMetrology(){
            
        }
        medicalMetrology(String tasks, String features, String structure, String measuring){
            this.tasks = tasks;
            this.features = features;
            this.structure = structure;
            this.measuring = measuring;
        }
         int GetHash(){
            return this.GetHash();
        }

        String GetString(){
            return this.toString();
        }

        boolean Equal(Object obj){
            return this.Equal(obj);
        }
    }

