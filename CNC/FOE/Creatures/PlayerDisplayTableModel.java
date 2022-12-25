package Creatures;

import javax.swing.table.AbstractTableModel;

public class PlayerDisplayTableModel extends AbstractTableModel {

    private String[] columnNames;
    private Object[][] data; 

    public PlayerDisplayTableModel(Player player){
        super();
        String[] names = {"Stats","Value"};
        columnNames = names;
        data = new Object [8][2];
        

        //Sets Table Values based on the player input:
        setValueAt(player.getName(), 0, 0);
        setValueAt("Lvl "+ player.getLevel(), 0, 1);
        setValueAt("Health", 1, 0);
        setValueAt(player.getHealth(), 1, 1);
        setValueAt("S. Guns", 2, 0);
        setValueAt(player.getSmallGuns(), 2, 1);
        setValueAt("B. Guns", 3, 0);
        setValueAt(player.getBigGuns(), 3, 1);
        setValueAt("M.E.W.", 4, 0);
        setValueAt(player.getMagicalEnergyWeapons(), 4, 1);
        setValueAt("Melee", 5, 0);
        setValueAt(player.getMeleeWeapons(), 5, 1);
        setValueAt("Unarmed", 6, 0);
        setValueAt(player.getUnarmed(), 6, 1);
        setValueAt("Expl.", 7, 0);
        setValueAt(player.getExplosives(), 7, 1);

    }
    
    public PlayerDisplayTableModel(Player player, int selection){
        super();
        String[] names = {"Strength","Perception","Endurance","Perception","Intelligence","Agility","Luck"};
        columnNames = names;
        data = new Object[2][7];

        setValueAt('S', 0, 0);
        setValueAt('P', 0, 1);
        setValueAt('E', 0, 2);
        setValueAt('C', 0, 3);
        setValueAt('I', 0, 4);
        setValueAt('A', 0, 5);
        setValueAt('L', 0, 6);
        setValueAt(player.getStrength(), 1, 0);
        setValueAt(player.getPerception(), 1, 1);
        setValueAt(player.getEndurance(), 1, 2);
        setValueAt(player.getCharisma(), 1, 3);
        setValueAt(player.getIntelligence(), 1, 4);
        setValueAt(player.getAgility(), 1, 5);
        setValueAt(player.getLuck(), 1, 6);
    }

    public PlayerDisplayTableModel(Object[][] d, String[] cn){
        super();
        columnNames = cn;
        data = d;

    }

    public int getRowCount() {
        return data.length;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);

    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public Class getColumnClass(int c){
        return getValueAt(0, c).getClass();
    }
    
}
