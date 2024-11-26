public class Car{
    private int year;
    private String make;
    private String model;
    private String color;
    private int conditionCategory;
    private boolean isRestored;

    public Car(){
        this.year = 1960;
        this.make = "Jaguar";
        this.model = "E-Type";
        this.color = "silver";
        this.conditionCategory = 89; 
        setIsRestored();
    }

public Car(int year, String make, String model, String color, int conditionCategory){
    this.year = year;
    this.make = make;
    this.model = model;
    this.color = color;
    setConditionCategory(conditionCategory);
    setIsRestored();
}

public void setConditionCategory(int conditionCategory){
    if( conditionCategory >=40 || conditionCategory <= 100 ) {
        this.conditionCategory = conditionCategory;
    }
    else{
        this.conditionCategory = 80; 
    }
    printConditionStatements();
}

public void printConditionStatements(){
    if(this.conditionCategory>=70&&this.conditionCategory<80){
        System.out.println("Fine");
    }
    else if(this.conditionCategory>=60&&this.conditionCategory<70){
        System.out.println("Very Good");
    }
    else if(this.conditionCategory>=50&&this.conditionCategory<60){
        System.out.println("Good");
    }
    else if(this.conditionCategory>=40&&this.conditionCategory<50){
        System.out.println("Driver");
    }
    else if(this.conditionCategory>=80&&this.conditionCategory<90){
        System.out.println("Excellent");
    }
    else if(this.conditionCategory>=90&&this.conditionCategory<=100){
        System.out.println("Perfect"); 
    }
}

public void setIsRestored(){
    this.isRestored = this.conditionCategory >= 90; 
}

public Car(int year, String make, String model){
    this.year = year;
    this.make = make;
    this.model = model;
    this.color = "blue";
    this.conditionCategory = 80;
}

public String getColor(){
    return this.color; 
}

public int getYear(){
    return this.year; 
}

public String getModel(){
    return this.model; 
}

public String getMake(){
    return this.make; 
}

public int getCondition(){
    return this.conditionCategory; 
}
}




