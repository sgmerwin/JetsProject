package jets;

public abstract class Jet {
    protected String name;
    protected String model;
    protected Double speedMPH;
    protected Double rangeMiles;
    protected Double price;

    public void fly() {
        System.out.printf("The "+this.model+" "+this.name+" will fly "+ this.rangeMiles+" miles at a speed of "+"%.2f"+" MPH\n",this.speedMPH*.7);
    }//method

}//class

