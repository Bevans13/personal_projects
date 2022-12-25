package Creatures;

import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class PlayerDisplayTable extends CreatureDisplayTable{

public PlayerDisplayTable(TableModel tm){
    super(tm);

    TableColumn column;
        for (int k = 0; k < 2; k++) {
            column = getColumnModel().getColumn(k);
            column.setPreferredWidth(50);
        }
        
}

public PlayerDisplayTable(Player player){
    super();
}

}
