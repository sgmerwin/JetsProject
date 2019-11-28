package jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AirField {

    protected String name;
    protected ArrayList<Jet> jets;

    public AirField(){
        this.jets = new ArrayList<>();
    }//method

    public AirField(String name){
        this.jets = new ArrayList<>();
        this.name = name;
    }//method

    public ArrayList popAirFieldFromTextFile(String file){
        try (BufferedReader in = new BufferedReader(new FileReader(
                file))) {
            //String name, String color, String owner, String ownerEmail
            String line = null;
            CessnaSuperCargomasterEX superEX = new CessnaSuperCargomasterEX();
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("mig15")) {
                    this.jets.add(new Mig15(parts[1],parts[2],parts[3],parts[4]));
                }//if
                else if (parts[0].equals("superex")) {
                    this.jets.add(new CessnaSuperCargomasterEX(parts[1],parts[2],parts[3],parts[4]));
                }//elseif
                else {
                    continue;
                }//else
            }//while
        }//try
        catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }//catch
        return this.jets;
    }//method

    @Override
    public String toString() {
        return "AirField{" +
                "name='" + name + '\'' +
                ", jets=" + jets.toString() +
                '}';
    }//method

}//class




