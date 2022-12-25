package Creatures;

import javax.swing.JButton;
import javax.swing.JProgressBar;

public class Creature {
    
private int health, damageResistance, actionPoints, currentHealth;

private JProgressBar healthBar;

private JButton attackButton = new JButton("Atk");
private JButton itemsButton = new JButton("Items");
private JButton miscButton = new JButton("Misc");

public Creature(int h, int dr, int ap, int ch){
    health = h;
    damageResistance = dr;
    actionPoints = ap;
    currentHealth = ch;

    healthBar = new JProgressBar(0,health);
    healthBar.setValue(currentHealth);
}

public void takeDamage(int damage){
currentHealth -= damage;
}

public void useActionPoints(int pointsUsed){
    actionPoints -= pointsUsed;
}

public void display(){
    System.out.println(health+" "+damageResistance+" "+actionPoints);
}

public int getActionPoints() {
    return actionPoints;
}public void setActionPoints(int actionPoints) {
    this.actionPoints = actionPoints;
}public int getDamageResistance() {
    return damageResistance;
}public void setDamageResistance(int damageResistance) {
    this.damageResistance = damageResistance;
}public int getHealth() {
    return health;
}public void setHealth(int health) {
    this.health = health;
}public int getCurrentHealth() {
    return currentHealth;
}public void setCurrentHealth(int currentHealth) {
    this.currentHealth = currentHealth;
}public JButton getAttackButton() {
    return attackButton;
}public void setAttackButton(JButton attackButton) {
    this.attackButton = attackButton;
}public JButton getItemsButton() {
    return itemsButton;
}public void setItemsButton(JButton itemsButton) {
    this.itemsButton = itemsButton;
}public JButton getMiscButton() {
    return miscButton;
}public void setMiscButton(JButton miscButton) {
    this.miscButton = miscButton;
}public JProgressBar getHealthBar() {
    return healthBar;
}public void setHealthBar(JProgressBar healthBar) {
    this.healthBar = healthBar;
}

}