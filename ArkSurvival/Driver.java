import java.io.*;
import java.util.*;
import Creatures.*;

public class Driver {
    
    //An array to store the creature objects being read in to the program
    private static ArrayList<Creature> tames = new ArrayList<>();
        

    public static void main(String[] args) {

        //Set contditional statement to allert user that prior tame data 
        // has successfully been loaded into the program
        BufferedReader br1;
        BufferedWriter bw1;
        String record;
        String[] fields = new String[11];


        Scanner sc1 = new Scanner(System.in);
        System.out.println("Selecte a Map: ");
        String mapChoice = sc1.nextLine().toUpperCase();
        System.out.println("map selection: "+mapChoice);
        try {
            
            //instantiating br here to point to the input file
            br1 = new BufferedReader(new FileReader(mapChoice+".txt"));
            //reading the first record and storing it in the 'record' variable
            record = br1.readLine();
            
            
            //Begins section where program reads existing file and loads creatures into program
            while (record != null) {
                
                // Instantiates the fields array and splits into separate strings for each 
                // value
                fields = splitDelimitedString(record, ",");
                
                // assign each position of the fields array to it's corresponding data
                String n    = fields[0];
                String sp   = fields[1];
                char gen    = fields[2].charAt(0);

                // the following fields are no longer actually strings so use Double method
                // to convert the fields values to double values
                double hp   = Double.valueOf(fields[3]);
                double stam = Double.valueOf(fields[4]);
                double oxy  = Double.valueOf(fields[5]);
                double f    = Double.valueOf(fields[6]);
                double w    = Double.valueOf(fields[7]);
                double mel  = Double.valueOf(fields[8]);
                double mov  = Double.valueOf(fields[9]);
                double torp = Double.valueOf(fields[10]);

                // Runs Static Driver method to create creatures (allows for same create creature code to 
                // be used both in the initial reading of the file as well as when adding creatures later on)
                createCreature(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
                // Read the next record in the file
                record = br1.readLine();
                
            }// End of Try Block which will read existing file
            br1.close();
        }catch (IOException ioe){
            System.out.println("IO Exception Error - Reading");
        }

        
        
        if (tames.size()>1) {
            System.out.println("Tames Save Data Loaded");
        }
        char select = 's';
        //While loop to allow user to select action until they want to exit
        while (select != 'E') {
            Scanner sc = new Scanner(System.in);
            //prompts user request for next steps
            System.out.println("Select to Add/Delete/View a creature(A/D/V/E): ");
            select=Character.toUpperCase(sc.next().charAt(0));
            //Separates what will occur based on user selection
            switch (select) {
                
                case 'A':
                //Requests and accepts user input of Creature details
                System.out.println("Add");      
                System.out.println("Name: ");
                String n = sc.next();
                //eventually add a duplicate creature check?
                System.out.println("Species: ");        
                String sp = sc.next();
                System.out.println("Gender: ");
                char gen = sc.next().charAt(0);
                System.out.println("Health: ");
                double hp = sc.nextDouble();
                System.out.println("Stamina: ");
                double stam = sc.nextDouble();
                System.out.println("Oxygen: ");
                double oxy = sc.nextDouble();
                System.out.println("Food: ");
                double f = sc.nextDouble();
                System.out.println("Weight: ");
                double w = sc.nextDouble();
                System.out.println("Melee: ");
                double mel = sc.nextDouble();
                System.out.println("Movement: ");
                double mov = sc.nextDouble();
                System.out.println("Torpor: ");
                double torp = sc.nextDouble();
                // call create creature function to create object of respective subclass
                createCreature(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
                    break;
                
                case 'D':
                System.out.println("Delete");
                    break;

                case 'V':
                System.out.println("View");
                System.out.println("Select a view (S/B): ");
                char viewOption = Character.toUpperCase(sc.next().charAt(0));
                    switch (viewOption) {
                        //Species view
                        case 'S':
                        selectSpecies(sc);
                        
                        System.out.println("Select a Creature to view: ");
                        int num = sc.nextInt()-1;
                        if (num < tames.size()) {
                            tames.get(num).display();
                        }
                        //Breeding view
                            break;
                        case 'B':

                        System.out.println("Select a Species to breed: ");
                        String speciesToBreed = sc.next();

                        //creates arraylist that is subset of all creatures of only this species
                        ArrayList<Creature> speciesStock = new ArrayList<>();
                        ArrayList<Creature> bestStock    = new ArrayList<>();
                        //checks each creature to see if it belongs in this new subset
                        for (int i = 0; i < tames.size(); i++) {
                            if (tames.get(i).speciesIs(speciesToBreed)) {
                                speciesStock.add(tames.get(i));
                            }
                        }

                        //Beginning of selectively choosing best 3 of each gender and
                        //creating a subset of each of those

                        ArrayList<Creature> bestMales   = new ArrayList<>();
                        ArrayList<Creature> bestFemales = new ArrayList<>();

                        double lowestMaleHealth     = 0;
                        double lowestMaleStamina    = 0;
                        double lowestMaleMelee      = 0;
                        double lowestMaleWeight     = 0;

                        double lowestFemaleHealth   = 0;
                        double lowestFemaleStamina  = 0;
                        double lowestFemaleMelee    = 0;
                        double lowestFemaleWeight   = 0;

                        //iterates through each member of a given species
                        for (int i = 0; i < speciesStock.size(); i++) {
                            // Identifies Male creatures
                            if (speciesStock.get(i).getGender()=='M') {
                                boolean isBetterThanOne = false;
                                boolean isBetterThanTwo = false;
                                boolean isBetterThanThree = false;

                                //Takes action if less than 3 dine's marked preferred
                                if (bestMales.size()<3) {
                                    bestMales.add(speciesStock.get(i));
                                    //Saves lowest value of selected dino's
                                    if (bestMales.size()==0) {
                                        lowestMaleHealth = speciesStock.get(i).getHp();
                                        lowestMaleStamina = speciesStock.get(i).getStamina();
                                        lowestMaleMelee = speciesStock.get(i).getMelee();
                                        lowestMaleWeight = speciesStock.get(i).getWeight();
                                        
                                    } else {
                                        if (lowestMaleHealth > speciesStock.get(i).getHp()); {
                                            lowestMaleHealth = speciesStock.get(i).getHp();
                                        }
                                        if (lowestMaleStamina > speciesStock.get(i).getStamina());{
                                            lowestMaleStamina = speciesStock.get(i).getStamina();
                                        }
                                        if (lowestMaleHealth > speciesStock.get(i).getHp());{
                                            lowestMaleHealth = speciesStock.get(i).getHp();
                                        }
                                        if (lowestMaleHealth > speciesStock.get(i).getHp()); {
                                            lowestMaleHealth = speciesStock.get(i).getHp();
                                        }
                                    }
                                } else {
                                    int qualityOfDino = 0;
                                    if (speciesStock.get(i).getHp()>lowestMaleHealth) {
                                        qualityOfDino++;
                                    }
                                    if (speciesStock.get(i).getMelee()>lowestMaleMelee) {
                                        qualityOfDino++;
                                    }
                                    if (speciesStock.get(i).getStamina()>lowestMaleStamina) {
                                        qualityOfDino++;
                                    }
                                    if (speciesStock.get(i).getWeight()>lowestMaleWeight) {
                                        qualityOfDino++;
                                    }
                                    if (qualityOfDino>2) {
                                        bestMales.add(speciesStock.get(i));
                                        
                                    }
                                }
                            }
                            if (speciesStock.get(i).getGender()=='F') {
                                bestFemales.add(speciesStock.get(i));
                            }
                        }
                        // Start section to display the selected or prefferred creatures


                        
                            break;
                        default:
                            break;
                }
                    break;
                case 'E':  
                System.out.println("Exit App");
                    break;
                default:
                System.out.println("Invalid entry");
                    break;
            } 

        }
    }


    public static ArrayList<Creature> readFile(World world){
        BufferedReader br;
        String record;
        String[] fields;
        try {
            
            //instantiating br here to point to the input file
            br = new BufferedReader(new FileReader(world.getFILENAME()));
            System.out.println(world.getFILENAME());
            //reading the first record and storing it in the 'record' variable
            record = br.readLine();
            
            
            //Begins section where program reads existing file and loads creatures into program
            while (record != null) {
                
                // Instantiates the fields array and splits into separate strings for each 
                // value
                fields = splitDelimitedString(record, ",");
                
                // assign each position of the fields array to it's corresponding data
                String n    = fields[0];
                String sp   = fields[1];
                char gen    = fields[2].charAt(0);

                // the following fields are no longer actually strings so use Double method
                // to convert the fields values to double values
                double hp   = Double.valueOf(fields[3]);
                double stam = Double.valueOf(fields[4]);
                double oxy  = Double.valueOf(fields[5]);
                double f    = Double.valueOf(fields[6]);
                double w    = Double.valueOf(fields[7]);
                double mel  = Double.valueOf(fields[8]);
                double mov  = Double.valueOf(fields[9]);
                double torp = Double.valueOf(fields[10]);

                // Runs Static Driver method to create creatures (allows for same create creature code to 
                // be used both in the initial reading of the file as well as when adding creatures later on)
                createCreature(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
                // Read the next record in the file
                record = br.readLine();
                
            }// End of Try Block which will read existing file
            br.close();
        }catch (IOException ioe){
            System.out.println("IO Exception Error - Reading");
        }
        if (world.getTames().size()>1) {
            System.out.println(world.getWorldName()+"Tames Loaded");
        }
        return tames;
    }

    public static void writeFile(World world){
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(world.getFILENAME()));
            for (int i = 0; i < tames.size(); i++) {
                bw.write(tames.get(i).toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println("IO Exception Error");
        }

    }


    // allows to type in a species name and select a view
    private static void selectSpecies(Scanner sc) {
        
        System.out.println("Select a Species: ");
        String search = sc.next();
        
        for (int i = 0; i < tames.size(); i++){
            if (tames.get(i).speciesIs(search)) {
                System.out.println("#"+(i+1)+" "+tames.get(i).getName()+" "+tames.get(i).getSpecies()+" "+tames.get(i).getGender());    
            }
            if (search.equals("all")) {
                System.out.println("#"+(i+1)+" "+tames.get(i).getName()+" "+tames.get(i).getSpecies()+" "+tames.get(i).getGender());
            }
        }
    }
        
    public static String [] splitDelimitedString (String toSplit, String delimiter) 
    {
    //toSplit is the entire delimited String to be used to populate the array of values
        //delimiter is the character used to separate the values in toSplit
        //for a comma-delimited file, this argument will be the String ","
        String [] valuesAsStrings = toSplit.split(delimiter);
        return valuesAsStrings;
    }


    public static void createCreature(String n, String sp, char gen, double hp, double stam, double oxy, double f,
    double w, double mel, double mov, double torp){
        //Sort and create the creatures based on species
        // Better or more effective way to apply polymorphism??
        switch (sp) {
            case "Raptor":  
            // change to contcatenate the new dino to the end of array
            Raptor raptor = new Raptor(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(raptor);
                break;
            case "Rex":  
            // change to contcatenate the new dino to the end of array
            Rex rex = new Rex(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(rex);
                break;
            case "Parasaur":  
            // change to contcatenate the new dino to the end of array
            Parasaur parasaur = new Parasaur(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(parasaur);
                break;
            case "Pteranadon":  
            // change to contcatenate the new dino to the end of array
            Pteranadon pteranadon = new Pteranadon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(pteranadon);
                break;
            case "Yutyrannus":
            Yutyrannus yutyrannus = new Yutyrannus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(yutyrannus);
                break;
            case "Allosaurus":
            Allosaurus allosaurus = new Allosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(allosaurus);
                break;
            case "Ankylosaurus":
            Ankylosaurus ankylosaurus = new Ankylosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(ankylosaurus);
                break;
            case "Argentavis":
            Argentavis argentavis = new Argentavis(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(argentavis);
                break;
            case "Beelzebufo":
            Beelzebufo Beelzebufo = new Beelzebufo(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(Beelzebufo);
                break;
            case "Brontosaurus":
            Brontosaurus brontosaurus = new Brontosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(brontosaurus);
                break;
            case "Castoroides":
            Castoroides castoroides = new Castoroides(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(castoroides);
                break;
            case "Doedicurus":
            Doedicurus doedicurus = new Doedicurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(doedicurus);
                break;
            case "Kairuku":
            Kairuku kairuku = new Kairuku(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(kairuku);
                break;
            case "Megalodon":
            Megalodon megalodon = new Megalodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(megalodon);
                break;
            case "Megatherium":
            Megatherium megatherium= new Megatherium(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(megatherium);
                break;
            case "Pulmonoscorpius":
            Pulmonoscorpius pulmonoscorpius = new Pulmonoscorpius(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(pulmonoscorpius);
                break;
            case "Sabertooth":
            Sabertooth sabertooth = new Sabertooth(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(sabertooth);
                break;
            case "Therizinosaurus":
            Therizinosaurus therizinosaurus = new Therizinosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(therizinosaurus);
                break;
            case "Titanoboa":
            Titanoboa titanoboa = new Titanoboa(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(titanoboa);
                break;
            case "Direwolf":
            Direwolf direwolf = new Direwolf(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(direwolf);
                break;
            default:
                break;
        }
    }

    public static ArrayList<Creature> getTames() {
        return tames;
    }
    
    public static void setTames(ArrayList<Creature> tames) {
        Driver.tames = tames;
    }
}