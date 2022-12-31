import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class WorldPanel extends JPanel {

    private JLabel label;
    private JButton returnButton = new JButton("Return");
    private JButton addCreatureButton = new JButton("Add");
    private String worldName;
    private String saveFilePath;

    //ArrayList containing Tames for each world
    private ArrayList<Creature> tames;
    
    //Default Constructor (mainly to test functionality of initial program)
    public WorldPanel() {
        super();
        worldName = "The Island";
        label = new JLabel("World Panel");
        tames = new ArrayList<Creature>();

        setBackground(Color.RED);
        paint(getGraphics());

    }
    
    //Contstructor to build each individual world
    public WorldPanel(String worldName, String filePath) {
        super();
        this.worldName = worldName;
        saveFilePath = filePath;
        label = new JLabel(this.worldName);
        SaveFileManager.readSaveData(this);

        setBackground(Color.ORANGE);
        paint(getGraphics());
    }

    //seems to run automatically as part of contructor? should probable check the Super() contsructor documentation
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawLabel(g);
        drawButtons(g);
    }
    
    public void drawLabel(Graphics g) {
        //label.setBounds(100, 100, 300, 600);
        add(label);
        
    }
    
    public void drawButtons(Graphics g) {
        returnButton.setBounds(15, 15, 75, 50);
        add(returnButton);
        addCreatureButton.setBounds(100, 100, 100, 100);
        add(addCreatureButton);
        
    }
    
    public void addTame(){

    }



    public JLabel getLabel() {
        return label;
    }
    
    public JButton getReturnButton() {
        return returnButton;
    }

    public JButton getAddCreatureButton() {
        return addCreatureButton;
    }

    public String getWorldName() {
        return worldName;
    }

    public String getSaveFilePath() {
        return saveFilePath;
    }

    public ArrayList<Creature> getTames() {
        return tames;
    }

    public void setTames(ArrayList<Creature> tames) {
        this.tames = tames;
    }
    
}
