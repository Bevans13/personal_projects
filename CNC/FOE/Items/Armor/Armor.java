package Items.Armor;

import Items.Items;

public class Armor extends Items {
    
    int damageResistance;

    public Armor (double cw, int dr){
        super(cw);
        damageResistance = dr;
    }
}
