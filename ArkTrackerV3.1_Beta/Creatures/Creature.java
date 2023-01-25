package Creatures;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class Creature implements Serializable{
    
    private String name;
    private String species;
    private char gender;
    private double hp;
    private double stamina;
    private double oxygen;
    private double food;
    private double weight;
    private double melee;
    private double movement;
    private double torpor;

    // Input fields needed to accept user info for creating a new Creature
    private static JLabel newCreatureNameLabel = new JLabel("Name: ");
    private static JTextField newCreatureNameTextField = new JTextField();
    private static JLabel newCreatureSpeciesLabel = new JLabel("Species: ");
    private static JTextField newCreatureSpeciesTextField = new JTextField();
    private static JLabel newCreatureGenderLabel = new JLabel("Gender: ");
    private static JTextField newCreatureGenderTextField = new JTextField();
    private static JLabel newCreatureHPLabel = new JLabel("Health: ");
    private static JTextField newCreatureHPTextField = new JTextField();
    private static JLabel newCreatureStaminaLabel = new JLabel("Stamina: ");
    private static JTextField newCreatureStaminaTextField = new JTextField();
    private static JLabel newCreatureOxygenLabel = new JLabel("Oxygen: ");
    private static JTextField newCreatureOxygenTextField = new JTextField();
    private static JLabel newCreatureFoodLabel = new JLabel("Food: ");
    private static JTextField newCreatureFoodTextField = new JTextField();
    private static JLabel newCreatureWeightLabel = new JLabel("Weight: ");
    private static JTextField newCreatureWeighTextField = new JTextField();
    private static JLabel newCreatureMeleeLabel = new JLabel("Melee: ");
    private static JTextField newCreatureMeleeTextField = new JTextField();
    private static JLabel newCreatureMovementLabel = new JLabel("Movement: ");
    private static JTextField newCreatureMovementTextField = new JTextField();
    private static JLabel newCreatureTorporLabel = new JLabel("Torpor: ");
    private static JTextField newCreatureTorporTextField = new JTextField();
    private static JLabel[] newCreatureLabels = new JLabel[] {
    newCreatureNameLabel, newCreatureSpeciesLabel, newCreatureGenderLabel,
    newCreatureHPLabel, newCreatureStaminaLabel, newCreatureOxygenLabel,
    newCreatureFoodLabel, newCreatureWeightLabel, newCreatureMeleeLabel,
    newCreatureMovementLabel, newCreatureTorporLabel};
    private static JTextField[] newCreatureTextFields = new JTextField[] {
    newCreatureNameTextField, newCreatureSpeciesTextField, newCreatureGenderTextField,
    newCreatureHPTextField, newCreatureStaminaTextField, newCreatureOxygenTextField,
    newCreatureFoodTextField, newCreatureWeighTextField, newCreatureMeleeTextField,
    newCreatureMovementTextField, newCreatureTorporTextField};
    private static JButton submitTextFieldButton = new JButton("Submit");

    //View Option Labels and Buttons
    private JLabel nameLabel;
    private JLabel speciesLabel;
    private JLabel genderLabel;
    private JLabel healthLabel;
    private JLabel staminaLabel;
    private JLabel oxygenLabel;
    private JLabel foodLabel;
    private JLabel weightLabel;
    private JLabel meleeLabel;
    private JLabel movementLabel;
    private JLabel torporLabel;
    private JLabel[] creatureDisplayLabels = new JLabel[]{
        nameLabel, speciesLabel, genderLabel,
        healthLabel,staminaLabel,oxygenLabel,
        foodLabel, weightLabel, meleeLabel,
        movementLabel,torporLabel};

    
    public Creature(String n, String sp, char gen, double health, double stam, double oxy, 
    double f, double w, double mel, double move, double torp){
        name = n;
        species = sp;
        gender = gen;
        hp = health;
        stamina = stam;
        oxygen = oxy;
        food = f;
        weight = w;
        melee = mel;
        movement = move;
        torpor = torp;
    }

    public static void drawCreateCreatureTextFields(JPanel panel) {
        int frameWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int frameHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();


        for (int i = 0; i < newCreatureLabels.length; i++) {
            newCreatureLabels[i].setBounds(frameWidth / 2 - 100, 130 + (25 * i), 100, 25);
            panel.add(newCreatureLabels[i]);
        }
        for (int i = 0; i < newCreatureTextFields.length; i++) {
            newCreatureTextFields[i].setBounds(frameWidth / 2, 130 + (25 * i), 100, 25);
            panel.add(newCreatureTextFields[i]);
        }

        submitTextFieldButton.setBounds(335, 15, 100, 100);
        panel.add(submitTextFieldButton);
    }

    public static void removeCreateCreatureTextFields(JPanel panel) {
        for (int i = 0; i < newCreatureLabels.length; i++) {
            panel.remove(newCreatureLabels[i]);
        }
        for (int i = 0; i < newCreatureLabels.length; i++) {
            newCreatureTextFields[i].setText("");
            panel.remove(newCreatureTextFields[i]);
        }
        panel.remove(submitTextFieldButton);
    }

    

    public void display(){
        System.out.println(name+" "+species+" "+gender);
        System.out.println("Health "+hp);
        System.out.println("Stamina "+stamina);
        System.out.println("Oxygen "+oxygen);
        System.out.println("Food "+food);
        System.out.println("Weight "+weight);
        System.out.println("Melee "+melee);
        System.out.println("Movement "+movement);
        System.out.println("Torpor "+torpor);
        System.out.println("Object of "+ getClass()+" Class");
    }

    public boolean speciesIs(String search){
        return search.equals(this.species);            
    }

    @Override
    public String toString() {
        return name+","+species+","+gender+","+hp+","+stamina+","+oxygen+","+
        food+","+weight+","+melee+","+movement+","+torpor+", Object of "+getClass()+" Class";
    }
    
    // Setter/Getter section
    public String getName() {
        return name;
    } public void setName(String name) {
        this.name = name;
    } public String getSpecies() {
        return species;
    } public void setSpecies(String species) {
        this.species = species;
    } public char getGender() {
        return gender;
    } public void setGender(char gender) {
        this.gender = gender;
    } public double getHp() {
        return hp;
    } public void setHp(double hp) {
        this.hp = hp;
    } public double getStamina() {
        return stamina;
    } public void setStamina(double stamina) {
        this.stamina = stamina;
    } public double getOxygen() {
        return oxygen;
    } public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    } public double getFood() {
        return food;
    } public void setFood(double food) {
        this.food = food;
    } public double getWeight() {
        return weight;
    } public void setWeight(double weight) {
        this.weight = weight;
    } public double getMelee() {
        return melee;
    } public void setMelee(double melee) {
        this.melee = melee;
    } public double getMovement() {
        return movement;
    } public void setMovement(double movement) {
        this.movement = movement;
    } public double getTorpor() {
        return torpor;
    } public void setTorpor(double torpor) {
        this.torpor = torpor;
    }

}