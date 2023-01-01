import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class WorldPanel extends JPanel {

    private JLabel label;
    private String worldName;
    private String saveFilePath;

    private JButton returnButton = new JButton("Return");
    private JButton addCreatureButton = new JButton("Add");
    private JButton viewCreatureButton = new JButton("View");

    private JLabel newCreatureNameLabel = new JLabel("Name: ");
    private JTextField newCreatureNameTextField = new JTextField();
    private JLabel newCreatureSpeciesLabel = new JLabel("Species: ");
    private JTextField newCreatureSpeciesTextField = new JTextField();
    private JButton submitTextFieldButton = new JButton("Submit");

    

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
        viewCreatureButton.setBounds(250, 100, 100, 100);
        add(viewCreatureButton);
        
    }

    public void drawCreateCreatureTextFields(){
        newCreatureNameLabel.setBounds(750, 300, 50, 20);
        add(newCreatureNameLabel);
        newCreatureNameTextField.setBounds(800, 300, 100, 20);
        add(newCreatureNameTextField);
        submitTextFieldButton.setBounds(200, 800, 100, 100);
        add(submitTextFieldButton);
        
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

    public JButton getViewCreatureButton() {
        return viewCreatureButton;
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
    
    public JButton getSubmitTextFieldButton() {
        return submitTextFieldButton;
    }

    public JTextField getNewCreatureNameTextField() {
        return newCreatureNameTextField;
    }
}
