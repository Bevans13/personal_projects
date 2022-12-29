import Creatures.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class World extends JPanel implements ActionListener{

    private String FILENAME;
    private String worldName;

    private static final int WORLD_WIDTH = (int) UserInterface.getScreensize().getWidth();
    private int buttonWidth = WORLD_WIDTH/8;
    private static final int WORLD_HEIGHT = (int) UserInterface.getScreensize().getHeight();
    private int buttonHeight = WORLD_HEIGHT/12;

    private static ArrayList<Creature> tames = new ArrayList<>();
    
    private static JButton addCreatureButton = new JButton("Add Creature");
    private static JButton deleteCreatureButton = new JButton("Delete Creature");
    private static JButton viewCreaturesButton = new JButton("View Creatures");

    public World() {
        setPreferredSize(new Dimension(WORLD_WIDTH,WORLD_HEIGHT));
        setBackground(Color.green);
        SaveFileManager.readSaveData(this);
    }

    public World(String wn, String fn){
        worldName = wn;
        FILENAME = fn;
        setPreferredSize(new Dimension(WORLD_WIDTH,WORLD_HEIGHT));
        setBackground(Color.green);
        SaveFileManager.readSaveData(this);
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawButtons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.orange);

    }

    private void drawButtons(){
        addCreatureButton.setBounds((WORLD_WIDTH/3)-(3*WORLD_WIDTH/3/4),WORLD_HEIGHT-(WORLD_HEIGHT/2), buttonWidth, buttonHeight);
        deleteCreatureButton.setBounds((2*WORLD_WIDTH/3)-(3*WORLD_WIDTH/3/4),WORLD_HEIGHT-(WORLD_HEIGHT/2), buttonWidth, buttonHeight);
        viewCreaturesButton.setBounds((WORLD_WIDTH)-(3*WORLD_WIDTH/3/4),WORLD_HEIGHT-(WORLD_HEIGHT/2), buttonWidth, buttonHeight);
        
        addCreatureButton.addActionListener(this);
        deleteCreatureButton.addActionListener(this);
        viewCreaturesButton.addActionListener(this);
        
        this.add(addCreatureButton);
        this.add(deleteCreatureButton);
        this.add(viewCreaturesButton);

    }

    public String getFILENAME() {
        return FILENAME;
    }
    public void setFILENAME(String fILENAME) {
        FILENAME = fILENAME;
    }
    public ArrayList<Creature> getTames() {
        return tames;
    }
    public void setTames(ArrayList<Creature> inhabitants) {
        tames = inhabitants;
    }
    public String getWorldName() {
        return worldName;
    }
    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

}
