package jets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {

    private BufferedReader bf;
    private AirField af;
    private Boolean exit = false;

    void start(){
        while(exit.equals(false)) {
            af = new AirField();
            bf = new BufferedReader(new InputStreamReader(System.in));
            String tempName;
            System.out.println("Enter the name of the AirField you are attending.");
            try {
                tempName = bf.readLine();
                af.name = tempName;
                af.popAirFieldFromTextFile("data.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }//catch
            System.out.println("Welcome to AirField " + af.name);
            menu();
        }//while
    }//method

    void menu(){
        while(exit.equals(false)) {
            String tempMenu;
            Integer menuCount = 0;
            System.out.println();
            System.out.println("Enter a menu choice.");
            System.out.println("1. List fleet");
            System.out.println("2. Fly all jets");
            System.out.println("3. View fastest jet");
            System.out.println("4. View jet with longest range");
            System.out.println("5. Load all Cargo Jets");
            System.out.println("6. Dogfight!");
            System.out.println("7. Add a jet to Fleet");
            System.out.println("8. Remove a jet from Fleet");
            System.out.println("9. Quit");
            try {
                tempMenu = bf.readLine();
                menuCount = Integer.parseInt(tempMenu.trim());
            } catch (IOException e) {
                e.printStackTrace();
            }//catch
            if(menuCount < 1 || menuCount > 9){
                menu();
            }//if
            else if(menuCount.equals(9)){
                exit();
            }//elseif9
            else if(menuCount.equals(1)){
                System.out.println("Here is the airfield data.");
                for (Jet i : af.jets) {
                   System.out.println(i.toString());
                }//for
                menu();
            }//elseif1
            else if(menuCount.equals(2)){
                for (Jet i : af.jets) {
                    i.fly();
                }//for
                menu();
            }//elseif2
            else if(menuCount.equals(3)){
                Double high = 0.0;
                for(int i = 0; i<af.jets.size(); i++){
                    if(i == 0){
                        high = af.jets.get(0).speedMPH;
                    }//if
                    else if(af.jets.get(i).speedMPH > high){
                        high = af.jets.get(i).speedMPH;
                    }
                }//for
                System.out.println("The highest speed jet(s) is(are) ");
                for(Jet i : af.jets){
                    if(i.speedMPH.equals(high)){
                        System.out.println("Model "+i.model+" Name"+i.name+" Speed in MPH "+i.speedMPH);
                    }//if
                }//for
                menu();
            }//elseif3
            else if(menuCount.equals(4)){
                Double high = 0.0;
                for(int i = 0; i<af.jets.size(); i++){
                    if(i == 0){
                        high = af.jets.get(0).rangeMiles;
                    }//if
                    else if(af.jets.get(i).rangeMiles > high){
                        high = af.jets.get(i).rangeMiles;
                    }
                }//for
                System.out.println("The longest range jet(s) is(are) ");
                for(Jet i : af.jets){
                    if(i.rangeMiles.equals(high)){
                        System.out.println("Model "+i.model+" Name"+i.name+" Range in miles "+i.rangeMiles);
                    }//if
                }//for
                menu();
            }//elseif4
            else if(menuCount.equals(5)){
                //String name, String color, String owner, String ownerEmail
                for(Jet i : af.jets){
                    if(i.model.equals("Cessna Super Cargo master EX")){
                        ((CessnaSuperCargomasterEX) i).loadCargo(((CessnaSuperCargomasterEX) i).cargoVolumecuft, ((CessnaSuperCargomasterEX) i).cargoWeight);
                    }//if
                }//for
                menu();
            }//elseif5
            else if(menuCount.equals(6)){
                for(Jet i : af.jets){
                    if(i.model.equals("Mig15")){
                        ((Mig15) i).fight();
                    }//if
                }//for
            }//elseif6
            else if(menuCount.equals(7)){
                int count = af.jets.size();
                String temp;
                af.jets.add(new JetImpl());
                System.out.println("Enter the jet model");
                try {
                    temp = bf.readLine();
                    af.jets.get(count).model = temp;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Enter the jet name");
                try {
                    temp = bf.readLine();
                    af.jets.get(count).name = temp;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Enter the jet speed in MPH");
                try {
                    temp = bf.readLine();
                    af.jets.get(count).speedMPH = Double.parseDouble(temp.trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Enter the jet range in statue miles");
                try {
                    temp = bf.readLine();
                    af.jets.get(count).rangeMiles = Double.parseDouble(temp.trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Enter the jet price in US dollars");
                try {
                    temp = bf.readLine();
                    af.jets.get(count).price = Double.parseDouble(temp.trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println();
                System.out.println("This is the data for the jet entered:");
                System.out.println(af.jets.get(count).toString());
                menu();
            }//elseif7
            else if(menuCount.equals(8)) {
                int choice = 0;
                String temp;
                System.out.println("Which jet would you like to remove from the fleet?");
                for(int i = 0; i<af.jets.size(); i++){
                    System.out.println((i+1) +": "+ af.jets.get(i).model+" "+af.jets.get(i).name);
                }
                System.out.println("Enter the number of the jet you would like to remove.");
                try {
                    temp = bf.readLine();
                    choice = Integer.parseInt(temp.trim());
                    if(choice > af.jets.size() || choice < 1){
                        menu();
                    }
                    choice = choice - 1;
                    System.out.println(af.jets.get(choice).model+" "+af.jets.get(choice).name+" is being removed");
                    af.jets.remove(choice);
                } catch (IOException e) {
                    e.printStackTrace();
                }//catch
                choice = 0;
                menu();
            }//elseif8
        }//while
    }//method
    void exit(){
        exit = true;
        System.out.println("Closing App");
    }//method

}//class

