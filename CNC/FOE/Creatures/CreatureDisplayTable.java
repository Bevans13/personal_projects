package Creatures;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class CreatureDisplayTable extends JTable{

    private Creature tableSubject;
    private String[] columnNames;
    private Object[][] data;

    public CreatureDisplayTable(){
        super();
    }

    public CreatureDisplayTable(TableModel tm){
        super(tm);
    }

    public CreatureDisplayTable(Object[][] d, String[] cn){
        super(d, cn);
    }

    public CreatureDisplayTable(Creature creature){

    }
    
    public Creature getTableSubject() {
        return tableSubject;
    }
    public void setTableSubject(Creature creature) {
        tableSubject = creature;
    }

    public String[] getColumnNames() {
        return columnNames;
    }public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public Object[][] getData() {
        return data;
    }public void setData(Object[][] data) {
        this.data = data;
    }


}
