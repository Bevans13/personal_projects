package Creatures;

import java.io.Serializable;
public class Creature implements Serializable, Comparable<Creature>{
    //perhaps make a Variation Enum Class for constant variables?
    public static enum Variation {
        REGULAR, ABERRANT, TEK, R, X
    };

    private Variation variety;
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
    
    //unused variables for future use
    private Creature mother;
    private Creature father;
    private Boolean imprinted;


    public Creature(String n, String sp, char gen, double health, double stam, double oxy, 
    double f, double w, double mel, double move, double torp, Variation v){
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
        variety = v;
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
        food+","+weight+","+melee+","+movement+","+torpor+", Object of "+getClass()+" Class: " +variety;
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
    } public Variation getVariety() {
        return variety;
    } public void setVariety(Variation variety) {
        this.variety = variety;
    }


    @Override
    public int compareTo(Creature o) {
        return 0; // species.compareTo(o.species);
    }

}
