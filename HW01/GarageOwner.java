public class GarageOwner{
    private String name;
    private int age;
    private int carsOwned=0;

    public GarageOwner(String name, int age){
        this.name = name;
        this.age = age;
        this.carsOwned = 0; 
    }

    public String getName(){
        return this.name; 
    }

}