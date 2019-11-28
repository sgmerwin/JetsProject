package jets;

public class CessnaSuperCargomasterEX extends Jet implements CargoCarrier{

    protected String color;
    protected String owner;
    protected String ownerEmail;
    protected Integer cargoWeight;
    protected Integer cargoVolumecuft;

    public CessnaSuperCargomasterEX() {
        this.model = "Cessna Super Cargo master EX";
        this.speedMPH = 213.0;
        this.rangeMiles = 1041.0;
        this.price = 1900000.00;
        this.cargoWeight = 1410;
        this.cargoVolumecuft = 143;
    }//method

    public CessnaSuperCargomasterEX(String name, String color, String owner, String ownerEmail) {
        this.model = "Cessna Super Cargo master EX";
        this.speedMPH = 213.0;
        this.rangeMiles = 1041.0;
        this.price = 1900000.00;
        this.cargoWeight = 1410;
        this.cargoVolumecuft = 143;
        this.name = name;
        this.color = color;
        this.owner = owner;
        this.ownerEmail = ownerEmail;
    }//method

    @Override
    public String toString() {
        return "CessnaSuperCargomasterEX{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", owner='" + owner + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", cargoWeight=" + cargoWeight +
                ", cargoVolumecuft=" + cargoVolumecuft +
                "\n speedMPH="+speedMPH+ ", rangeMiles="+rangeMiles+", price="+price+
                '}';
    }

    @Override
    public void loadCargo(int volume, int weight) {
        System.out.println("Cargo data for "+this.model+""+this.name);
        System.out.println("Your current available cargo volume is "+this.cargoVolumecuft);
        System.out.println("Your current available cargo weight is "+ this.cargoWeight);
        if(this.cargoVolumecuft.equals(0) || this.cargoWeight.equals(0)){
            System.out.println("The cargo hold is full.");
        }//if
        else if(this.cargoVolumecuft - volume < 0){
            System.out.println("The volume you want to load is too much.");
        }//elseif
        else if(this.cargoWeight - weight < 0){
            System.out.println("The weight you want to load is too much.");
        }//elseif
        else{
            System.out.println("The cargo is loaded.");
            this.cargoVolumecuft -= volume;
            this.cargoWeight -= weight;
            System.out.println("Your updated available cargo volume is "+this.cargoVolumecuft);
            System.out.println("Your updated available cargo weight is "+ this.cargoWeight);
        }//else
    }//method
}//class

