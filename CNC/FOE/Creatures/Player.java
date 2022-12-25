package Creatures;

import java.util.ArrayList;

import Items.*;

public class Player extends Creature {
    
    private String name;
    private int strength, perception, endurance, charisma, intelligence, agility,
    luck, level, smallGuns, bigGuns, magicalEnergyWeapons, meleeWeapons,
    unarmed, explosives, experiencePoints;
    private double carryWeightLimit, currentCarryWeight;
    private ArrayList<Items> inventory;
    private String inventoryFile;
    private boolean isOverEncumbered;

    public Player(String n, int s, int p, int e, int c, int i,
    int a, int l, int lvl, int h, int sg, int bg, int mew,
    int melee, int un, int expl, int dr, int ap, int ch, int XP) {
        super(h, dr, ap, ch);
        name = n; 
        strength = s;
        perception = p;
        endurance = e;
        charisma = c;
        intelligence = i;
        agility = a;
        luck = l;
        level = lvl;
        smallGuns = sg;
        bigGuns = bg;
        magicalEnergyWeapons = mew;
        meleeWeapons = melee;
        unarmed = un;
        explosives = expl;
        experiencePoints = XP;

        inventoryFile = name+"Inventory_Save.txt";
    
    }

    @Override
    public void display() {
        super.display();
        System.out.println(name+" "+strength+" "+perception+" "+
        endurance+" "+charisma+" "+intelligence+" "+agility+" "+
        luck+" "+level+" "+smallGuns+" "+bigGuns+" "+magicalEnergyWeapons+" "+
        meleeWeapons+" "+unarmed+" "+explosives);
    }

    @Override
    public String toString() {
        return name+","+strength+","+perception+","+endurance+","+charisma+","+
        intelligence+","+agility+","+luck+","+level+","+super.getHealth()+","+smallGuns+","+
        bigGuns+","+magicalEnergyWeapons+","+meleeWeapons+","+unarmed+","+explosives+","+
        super.getDamageResistance()+","+super.getActionPoints()+","+super.getCurrentHealth()+","+
        experiencePoints;
    }

    public String getName() {
        return name;
    } public void setName(String name) {
        this.name = name;
    } public int getStrength() {
        return strength;
    } public void setStrength(int strength) {
        this.strength = strength;
    } public int getPerception() {
        return perception;
    } public void setPerception(int perception) {
        this.perception = perception;
    } public int getEndurance() {
        return endurance;
    } public void setEndurance(int endurance) {
        this.endurance = endurance;
    } public int getCharisma() {
        return charisma;
    } public void setCharisma(int charisma) {
        this.charisma = charisma;
    } public int getIntelligence() {
        return intelligence;
    } public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    } public int getAgility() {
        return agility;
    } public void setAgility(int agility) {
        this.agility = agility;
    } public int getLuck() {
        return luck;
    } public void setLuck(int luck) {
        this.luck = luck;
    } public int getLevel() {
        return level;
    } public void setLevel(int level) {
        this.level = level;
    } public int getSmallGuns() {
        return smallGuns;
    } public void setSmallGuns(int smallGuns) {
        this.smallGuns = smallGuns;
    } public int getBigGuns() {
        return bigGuns;
    } public void setBigGuns(int bigGuns) {
        this.bigGuns = bigGuns;
    } public int getMagicalEnergyWeapons() {
        return magicalEnergyWeapons;
    } public void setMagicalEnergyWeapons(int magicalEnergyWeapons) {
        this.magicalEnergyWeapons = magicalEnergyWeapons;
    } public int getMeleeWeapons() {
        return meleeWeapons;
    } public void setMeleeWeapons(int meleeWeapons) {
        this.meleeWeapons = meleeWeapons;
    } public int getUnarmed() {
        return unarmed;
    } public void setUnarmed(int unarmed) {
        this.unarmed = unarmed;
    } public int getExplosives() {
        return explosives;
    }public void setExplosives(int explosives) {
        this.explosives = explosives;
    } public int getExperiencePoints() {
        return experiencePoints;
    }public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }public ArrayList<Items> getInventory() {
        return inventory;
    }public void setInventory(ArrayList<Items> inventory) {
        this.inventory = inventory;
    }public String getInventoryFile() {
        return inventoryFile;
    }public void setInventoryFile(String inventoryFile) {
        this.inventoryFile = inventoryFile;
    }public double getCarryWeightLimit() {
        return carryWeightLimit;
    }public void setCarryWeightLimit(double carryWeightLimit) {
        this.carryWeightLimit = carryWeightLimit;
    }public double getCurrentCarryWeight() {
        return currentCarryWeight;
    }public void setCurrentCarryWeight(double currentCarryWeight) {
        this.currentCarryWeight = currentCarryWeight;
    }public void setOverEncumbered(boolean isOverEncumbered) {
        this.isOverEncumbered = isOverEncumbered;
    }
}
