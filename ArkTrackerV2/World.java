import Creatures.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;


public class World extends JPanel implements ActionListener{

    private String FILENAME;
    private String worldName;

    private final int WORLD_WIDTH = 1200;
    private final int WORLD_HEIGHT = 690;
    
    private static ArrayList<Creature> tames = new ArrayList<>();
    
    private static JButton addCreatureButton = new JButton("Add Creature");
    private static JButton deleteCreatureButton = new JButton("Delete Creature");
    private static JButton viewCreaturesButton = new JButton("View Creatures");

    public World() {
        setPreferredSize(new Dimension(WORLD_WIDTH,WORLD_HEIGHT));
        setBackground(Color.green);
    }

    public World(String wn, String fn){
        worldName = wn;
        FILENAME = fn;
        setPreferredSize(new Dimension(WORLD_WIDTH,WORLD_HEIGHT));
        setBackground(Color.green);
        
        
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
        addCreatureButton.setBounds((WORLD_WIDTH/3)-(3*WORLD_WIDTH/3/4),WORLD_HEIGHT-(WORLD_HEIGHT/2),WORLD_WIDTH/3/2,WORLD_HEIGHT/3/2);
        addCreatureButton.addActionListener(this);
        deleteCreatureButton.setBounds((2*WORLD_WIDTH/3)-(3*WORLD_WIDTH/3/4),WORLD_HEIGHT-(WORLD_HEIGHT/2),WORLD_WIDTH/3/2,WORLD_HEIGHT/3/2);
        deleteCreatureButton.addActionListener(this);
        viewCreaturesButton.setBounds((WORLD_WIDTH)-(3*WORLD_WIDTH/3/4),WORLD_HEIGHT-(WORLD_HEIGHT/2),WORLD_WIDTH/3/2,WORLD_HEIGHT/3/2);
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
