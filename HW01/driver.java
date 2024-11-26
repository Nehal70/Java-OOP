import java.security.cert.CertPathValidator;

public class driver{
    public static void main(String[] args){
        GarageOwner Nehal = new GarageOwner("Nehal", 18); 
        Car[] myCatalogue = new Car[3];  
        Car Jaguar = new Car();
        Car Creta = new Car(2017, "Hyundai", "Creta", "White", 94);
        Car Lexus = new Car(2012, "Lexus", "SUV", "Black", 89);
        Car One = new Car(); 
        Car Two = new Car();
        Car Three = new Car();
        myCatalogue[0] = One;
        myCatalogue[1] = Two;
        myCatalogue[2] = Three; 

        Garage pratham48 = new Garage(Nehal, myCatalogue); 

        pratham48.addCar(0, Creta);
        pratham48.addCar(1, Jaguar);
        pratham48.addCar(2, Lexus);
        pratham48.sellCar(1);
        int count = 0;
        for(int i = 0; i<pratham48.getCatalogue().length; i++){
            if (pratham48.getCatalogue()[i]!=null){
                count++; 
            }
        }
        System.out.println(count); 
        pratham48.showCertainCars(90); 
    }
}