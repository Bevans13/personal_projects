package Items.Weapons;

import Items.Items;

public class Weapons extends Items{
    
    int damage;
    String type;

    public Weapons(double cw, int d, String t) {
        super(cw);
        damage = d;
        type = t;
    }


}
