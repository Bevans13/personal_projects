import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

public class WorldPanel extends JPanel {

    private static int WorldPanelWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static int WorldPanelHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static int labelWidth;
    private static int labelHeight;
    private static int textFieldWidth;
    private static int textFieldHeight;
    
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
    private JLabel newCreatureGenderLabel = new JLabel("Gender: ");
    private JTextField newCreatureGenderTextField = new JTextField();
    private JLabel newCreatureHPLabel = new JLabel("Health");
    private JTextField newCreatureHPTextField = new JTextField();
    private JLabel newCreatureStaminaLabel = new JLabel("Stamina");
    private JTextField newCreatureStaminaTextField = new JTextField();
    private JLabel newCreatureOxygenLabel = new JLabel("Oxygen");
    private JTextField newCreatureOxygenTextField = new JTextField();
    private JLabel newCreatureFoodLabel = new JLabel("Food");
    private JTextField newCreatureFoodTextField = new JTextField();
    private JLabel newCreatureWeightLabel = new JLabel("Weight");
    private JTextField newCreatureWeighTextField = new JTextField();
    private JLabel newCreatureMeleeLabel = new JLabel("Melee");
    private JTextField newCreatureMeleeTextField = new JTextField();
    private JLabel newCreatureMovementLabel = new JLabel("Movement");
    private JTextField newCreatureMovementTextField = new JTextField();
    private JLabel newCreatureTorporLabel = new JLabel("Torpor");
    private JTextField newCreatureTorporTextField = new JTextField();

    private JLabel[] newCreatureLabels = new JLabel[]{
        newCreatureNameLabel, newCreatureSpeciesLabel, newCreatureGenderLabel, 
        newCreatureHPLabel, newCreatureStaminaLabel, newCreatureOxygenLabel, 
        newCreatureFoodLabel, newCreatureWeightLabel, newCreatureMeleeLabel,
        newCreatureMovementLabel, newCreatureTorporLabel
    };

    private JTextField[] newCreatureTextFields = new JTextField[]{
        newCreatureNameTextField, newCreatureSpeciesTextField, newCreatureGenderTextField,
        newCreatureHPTextField, newCreatureStaminaTextField, newCreatureOxygenTextField,
        newCreatureFoodTextField, newCreatureWeighTextField, newCreatureMeleeTextField, 
        newCreatureMovementTextField, newCreatureTorporTextField
    };

    private JButton submitTextFieldButton = new JButton("Submit");

    //ArrayList containing Tames for each world
    private ArrayList<Creature> tames;
    
    //Default Constructor (mainly to test functionality of initial program)
    public WorldPanel() {
        super();
        worldName = "The Island";
        label = new JLabel("World Panel");
        tames = new ArrayList<Creature>();

        setBackground(Color.WHITE);
        paint(getGraphics());

    }
    
    //Contstructor to build each individual world
    public WorldPanel(String worldName, String filePath) {
        super();
        this.worldName = worldName;
        saveFilePath = filePath;
        label = new JLabel(this.worldName);
        SaveFileManager.readSaveData(this);

        setBackground(Color.WHITE);
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

        addCreatureButton.setBounds(returnButton.getX()+returnButton.getWidth()+15, 15, 100, 100);
        add(addCreatureButton);
        viewCreatureButton.setBounds(addCreatureButton.getX()+addCreatureButton.getWidth()+15, 15, 100, 100);
        add(viewCreatureButton);
        
    }

    public void drawCreateCreatureTextFields(){

        newCreatureNameLabel.setBounds(WorldPanelWidth/2-50, 130, 50, 25);
        add(newCreatureNameLabel);
        newCreatureNameTextField.setBounds(WorldPanelWidth/2, 130, 50, 25);
        add(newCreatureNameTextField);

        submitTextFieldButton.setBounds(200, 800, 100, 100);
        add(submitTextFieldButton);

        paint(getGraphics());
        
    }

    public void removeCreateCreatureTextFields(){
        remove(newCreatureNameLabel);
        remove(newCreatureNameTextField);
        remove(submitTextFieldButton);
        paint(getGraphics());
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

    @Override
    public String toString() {
        return worldName + super.toString();
    }
}
