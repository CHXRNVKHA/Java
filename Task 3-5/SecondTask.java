/**
 * SecondTask
 */
public class SecondTask {

    public static void main(String[] args) {
        Triangle trangle = new Triangle(2.00, 2.00, 60.00);
        System.out.println(trangle.TypeOf());
        System.out.println(trangle.LengthBetweenCircles(2.50, 1.50));
        System.out.println(trangle.GetOtherAngels());
    }

    
}
/**
     * Triangle
     */
    class Triangle {
        double FrstSide = 0;
        double SecSide = 0;
        double AngleBetween = 0;
        Triangle(){

        }
        Triangle(double FrstSide, double SecSide, double AngleBetween){
            this.FrstSide = FrstSide;
            this.SecSide = SecSide;
            this.AngleBetween = AngleBetween;
        }
        void ChangeAngleSize(double Num){
            if(Num>0){
               double buf = this.AngleBetween * (Math.abs(Num)/100);
               this.AngleBetween += buf;
            }
            else if(Num<0){
               double buf = this.AngleBetween * (Math.abs(Num)/100);
               this.AngleBetween -= buf;
            }
        }
        String TypeOf(){
            if(this.SecSide!=this.FrstSide&&this.AngleBetween!=60){
                return "Разносторонний";
            }
            else if(this.FrstSide==this.SecSide){
                return "Равнобедренный";
            }
            else if(this.FrstSide==this.SecSide&&this.AngleBetween==60){
                return "Равносторонний";
            }
            return "undefined";
        }
        double LengthBetweenCircles(double radiusOfAroundCirc, double radiusOfInCirc){
            return Math.sqrt(Math.abs(Math.pow(radiusOfAroundCirc,2) - (2*radiusOfAroundCirc*radiusOfInCirc)));
        }
        String GetOtherAngels(){
            double ThirdSide = Math.sqrt(Math.pow(this.FrstSide,2)+Math.pow(this.SecSide,2)-(2*this.FrstSide*this.SecSide*Math.cos(this.AngleBetween)));
            double SecAngle = Math.acos((Math.pow(this.SecSide,2)+Math.pow(ThirdSide, 2) - Math.pow(this.FrstSide,2))/(2*this.SecSide*ThirdSide));
            double ThirdAngle = Math.acos((Math.pow(this.FrstSide,2)+Math.pow(ThirdSide, 2) - Math.pow(this.SecSide,2))/(2*this.FrstSide*ThirdSide));
            return SecAngle + " " + ThirdAngle;
        }
    }