public class Garage{
    private GarageOwner theOwner;
    private Car[] carCatalogue;

    public Garage(GarageOwner theOwner, Car[] carCatalogue){
        this.theOwner = theOwner;
        this.carCatalogue = carCatalogue; 
    }

    public Garage(){
        this.theOwner =new GarageOwner("Enzo Ferrari", 35);
        this.carCatalogue = new Car[4]; 

    }

    public void addCar(int index, Car car){
        Car beingReplaced = this.carCatalogue[index];
        System.out.printf("A %s %d %s %s was just parked here.%n", beingReplaced.getColor(), beingReplaced.getYear(), beingReplaced.getMake(), beingReplaced.getModel()); 
        this.carCatalogue[index] = car;  
    }

    public Car sellCar(int index){
        Car soldCar = this.carCatalogue[index];
        System.out.printf("%s just sold a %s %d %s %s%n", this.theOwner.getName(), soldCar.getColor(), soldCar.getYear(), soldCar.getMake(), soldCar.getModel());
        if(index<this.carCatalogue.length){
            carCatalogue[index] = null;
            return soldCar; 
        }
        else{
            System.out.println("There was no car to sell!");
            return null; 
        }
    }

    public void showCertainCars(int conditionCategory){
        for(int i = 0; i<this.carCatalogue.length; i++){
            if(this.carCatalogue[i]!=null&&this.carCatalogue[i].getCondition()>conditionCategory){
                System.out.println(carCatalogue[i].getCondition());
                System.out.printf("A %s %d %s with a condition category of %d %n", carCatalogue[i].getColor(), carCatalogue[i].getYear(), carCatalogue[i].getMake(), carCatalogue[i].getCondition());
            }
        }
    }

    public Car[] getCatalogue(){
        return this.carCatalogue; 
    }
}