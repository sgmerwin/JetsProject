package jets;

public class Mig15 extends Jet implements CombatReady {

    protected String color;
    protected String owner;
    protected String ownerEmail;
    protected Integer twentyThreeMMrounds;
    protected Integer thirtySevenMMrounds;

    public Mig15() {
        this.model = "Mig15";
        this.speedMPH = 668.0;
        this.rangeMiles = 500.0;
        this.price = 14800.00;
        this.twentyThreeMMrounds = 80;
        this.thirtySevenMMrounds = 40;
    }

    public Mig15(String name, String color, String owner, String ownerEmail) {
        this.model = "Mig15";
        this.speedMPH = 668.0;
        this.rangeMiles = 500.0;
        this.price = 14800.00;
        this.twentyThreeMMrounds = 80;
        this.thirtySevenMMrounds = 40;
        this.name = name;
        this.color = color;
        this.owner = owner;
        this.ownerEmail = ownerEmail;
    }

    @Override
    public String toString() {
        return "Mig15{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", owner='" + owner + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", twentyThreeMMrounds=" + twentyThreeMMrounds +
                ", thirtySevenMMrounds=" + thirtySevenMMrounds +
                "\n speedMPH="+speedMPH+ ", rangeMiles="+rangeMiles+", price="+price+
                '}';
    }

    @Override
    public void fight() {
        if(this.twentyThreeMMrounds.equals(0) && this.thirtySevenMMrounds.equals(0)){
            System.out.println(this.model+" "+this.name+" is out of ammo, not able to fight.");
        }//if
        else if(this.twentyThreeMMrounds >= 20 && this.thirtySevenMMrounds >= 10){
            System.out.println(this.model+" "+this.name+":");
            System.out.println("Current 23mm ammo is "+ this.twentyThreeMMrounds);
            System.out.println("Current 37mm ammo is "+ this.thirtySevenMMrounds);
            System.out.println("You do a fly by dog fight pass and fire the autocannons!");
            System.out.println("You use 20, 23mm rounds and 10, 37mm rounds.");
            this.twentyThreeMMrounds -= 20;
            this.thirtySevenMMrounds -= 10;
        }//else
        else{
            System.out.println(this.model+" "+this.name+":");
            System.out.println("Current 23mm ammo is "+ this.twentyThreeMMrounds);
            System.out.println("Current 37mm ammo is "+ this.thirtySevenMMrounds);
            System.out.println("You do a fly by dog fight pass and fire the autocannons!");
            System.out.println("You use "+this.twentyThreeMMrounds+", 23mm rounds and "+ this.thirtySevenMMrounds+ ", 37mm rounds.");
            System.out.println("You are now out of ammo!");
            this.twentyThreeMMrounds = 0;
            this.thirtySevenMMrounds = 0;
        }//else
    }//method
}//class

