import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

import Creatures.*;

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

    // Main Options on all World Screens
    private JButton returnButton = new JButton("Return");
    private JButton addCreatureButton = new JButton("Add");
    private JButton viewCreatureButton = new JButton("View");

    // Input fields needed to accept user info for creating a new Creature
    private JLabel newCreatureNameLabel = new JLabel("Name: ");
    private JTextField newCreatureNameTextField = new JTextField();
    private JLabel newCreatureSpeciesLabel = new JLabel("Species: ");
    private JTextField newCreatureSpeciesTextField = new JTextField();
    private JLabel newCreatureGenderLabel = new JLabel("Gender: ");
    private JTextField newCreatureGenderTextField = new JTextField();
    private JLabel newCreatureHPLabel = new JLabel("Health: ");
    private JTextField newCreatureHPTextField = new JTextField();
    private JLabel newCreatureStaminaLabel = new JLabel("Stamina: ");
    private JTextField newCreatureStaminaTextField = new JTextField();
    private JLabel newCreatureOxygenLabel = new JLabel("Oxygen: ");
    private JTextField newCreatureOxygenTextField = new JTextField();
    private JLabel newCreatureFoodLabel = new JLabel("Food: ");
    private JTextField newCreatureFoodTextField = new JTextField();
    private JLabel newCreatureWeightLabel = new JLabel("Weight: ");
    private JTextField newCreatureWeighTextField = new JTextField();
    private JLabel newCreatureMeleeLabel = new JLabel("Melee: ");
    private JTextField newCreatureMeleeTextField = new JTextField();
    private JLabel newCreatureMovementLabel = new JLabel("Movement: ");
    private JTextField newCreatureMovementTextField = new JTextField();
    private JLabel newCreatureTorporLabel = new JLabel("Torpor: ");
    private JTextField newCreatureTorporTextField = new JTextField();
    private JLabel[] newCreatureLabels = new JLabel[] {
            newCreatureNameLabel, newCreatureSpeciesLabel, newCreatureGenderLabel,
            newCreatureHPLabel, newCreatureStaminaLabel, newCreatureOxygenLabel,
            newCreatureFoodLabel, newCreatureWeightLabel, newCreatureMeleeLabel,
            newCreatureMovementLabel, newCreatureTorporLabel
    };
    private JTextField[] newCreatureTextFields = new JTextField[] {
            newCreatureNameTextField, newCreatureSpeciesTextField, newCreatureGenderTextField,
            newCreatureHPTextField, newCreatureStaminaTextField, newCreatureOxygenTextField,
            newCreatureFoodTextField, newCreatureWeighTextField, newCreatureMeleeTextField,
            newCreatureMovementTextField, newCreatureTorporTextField
    };
    private JButton submitTextFieldButton = new JButton("Submit");

    // ArrayList containing Tames for each world
    private ArrayList<Creature> tames;

    private JLabel creature1Name;
    private JLabel creature1Species;
    private JLabel creature1Gender;
    private JLabel creature1Health;
    private JLabel creature1Stamina;
    private JLabel creature1Oxygen;
    private JLabel creature1Food;
    private JLabel creature1Weight;
    private JLabel creature1Melee;
    private JLabel creature1Movement;
    private JLabel creature1Torpor;

    private JLabel creature2Name;
    private JLabel creature2Species;

    // Default Constructor (mainly to test functionality of initial program)
    public WorldPanel() {
        super();
        worldName = "The Island";
        label = new JLabel("World Panel");
        tames = new ArrayList<Creature>();

        setBackground(Color.WHITE);
        paint(getGraphics());

    }

    // Contstructor to build each individual world
    public WorldPanel(String worldName, String filePath) {
        super();
        this.worldName = worldName;
        saveFilePath = filePath;
        label = new JLabel(this.worldName);
        tames = new ArrayList<>();
        SaveFileManager.readSaveData(this);

        setBackground(Color.WHITE);
        paint(getGraphics());
    }

    // seems to run automatically as part of contructor? should probable check the
    // Super() contsructor documentation
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
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);

    }

    public void drawButtons(Graphics g) {
        returnButton.setBounds(15, 15, 75, 50);
        add(returnButton);

        addCreatureButton.setBounds(returnButton.getX() + returnButton.getWidth() + 15, 15, 100, 100);
        add(addCreatureButton);
        viewCreatureButton.setBounds(addCreatureButton.getX() + addCreatureButton.getWidth() + 15, 15, 100, 100);
        add(viewCreatureButton);
        // Added this repaint to make buttons come back after removing all as part of
        // return button
        repaint();
    }

    public void drawCreateCreatureTextFields() {

        for (int i = 0; i < newCreatureLabels.length; i++) {
            newCreatureLabels[i].setBounds(WorldPanelWidth / 2 - 100, 130 + (25 * i), 100, 25);
            add(newCreatureLabels[i]);
        }
        for (int i = 0; i < newCreatureTextFields.length; i++) {
            newCreatureTextFields[i].setBounds(WorldPanelWidth / 2, 130 + (25 * i), 100, 25);
            add(newCreatureTextFields[i]);
        }

        submitTextFieldButton.setBounds(200, 800, 100, 100);
        add(submitTextFieldButton);

        paint(getGraphics());

    }

    public void removeCreateCreatureTextFields() {
        for (int i = 0; i < newCreatureLabels.length; i++) {
            remove(newCreatureLabels[i]);
        }
        for (int i = 0; i < newCreatureLabels.length; i++) {
            newCreatureTextFields[i].setText("");
            remove(newCreatureTextFields[i]);
        }
        remove(submitTextFieldButton);
        paint(getGraphics());
    }

    public void viewCreatures() {
        int x;
        int x2;
        int y;
        
        for (int i = 0; i < tames.size(); i++) {
            System.out.println(tames.size()+" " +i);
            if (i < 3) {
                x = (WorldPanelWidth/12)+((i * 4)*(WorldPanelWidth/12));
                x2 = x + WorldPanelWidth / 12;
                y = 200;
                int width = WorldPanelWidth / 12;
                int height = 25;
                
                // left column
                creature1Name = new JLabel(tames.get(i).getName());
                creature1Name.setBounds(x, y, width, height);
                add(creature1Name);
                creature1Species = new JLabel(tames.get(i).getSpecies());
                creature1Species.setBounds(x, y + 25, width, height);
                add(creature1Species);
                creature1Gender = new JLabel(String.valueOf(tames.get(i).getGender()));
                creature1Gender.setBounds(x, y + 50, width, height);
                add(creature1Gender);
                creature1Oxygen = new JLabel("O2   "+String.valueOf(tames.get(i).getOxygen()));
                creature1Oxygen.setBounds(x, y + 75, width, height);
                add(creature1Oxygen);
                creature1Food = new JLabel("Food  "+String.valueOf(tames.get(i).getFood()));
                creature1Food.setBounds(x, y + 100, width, height);
                add(creature1Food);
                //right column
                creature1Health = new JLabel("HP  " + Double.toString(tames.get(i).getHp()));
                creature1Health.setBounds(x2, y, width, height);
                add(creature1Health);
                creature1Stamina = new JLabel("Stam  "+String.valueOf(tames.get(i).getStamina()));
                creature1Stamina.setBounds(x2, y + 25, width, height);
                add(creature1Stamina);
                creature1Weight = new JLabel("Weight  "+String.valueOf(tames.get(i).getWeight()));
                creature1Weight.setBounds(x2, y + 50, width, height);
                add(creature1Weight);
                creature1Melee = new JLabel("Melee  "+String.valueOf(tames.get(i).getMelee()));
                creature1Melee.setBounds(x2, y + 75, width, height);
                add(creature1Melee);
                creature1Movement = new JLabel("Movement  "+String.valueOf(tames.get(i).getMovement()));
                creature1Movement.setBounds(x2, y + 100, width, height);
                add(creature1Movement);
                creature1Torpor = new JLabel("Torpor  "+String.valueOf(tames.get(i).getTorpor()));
                creature1Torpor.setBounds(x2, y + 125, width, height);
                add(creature1Torpor); 

            } 
            if (i >= 3 && i<6) {
                x = (WorldPanelWidth/12)+(((i-3) * 4)*(WorldPanelWidth/12));
                x2 = x + WorldPanelWidth / 12;
                y = 400;
                int width = WorldPanelWidth / 12;
                int height = 25;
                
                // left column
                creature1Name = new JLabel(tames.get(i).getName());
                creature1Name.setBounds(x, y, width, height);
                add(creature1Name);
                creature1Species = new JLabel(tames.get(i).getSpecies());
                creature1Species.setBounds(x, y + 25, width, height);
                add(creature1Species);
                creature1Gender = new JLabel(String.valueOf(tames.get(i).getGender()));
                creature1Gender.setBounds(x, y + 50, width, height);
                add(creature1Gender);
                creature1Oxygen = new JLabel("O2   "+String.valueOf(tames.get(i).getOxygen()));
                creature1Oxygen.setBounds(x, y + 75, width, height);
                add(creature1Oxygen);
                creature1Food = new JLabel("Food  "+String.valueOf(tames.get(i).getFood()));
                creature1Food.setBounds(x, y + 100, width, height);
                add(creature1Food);
                //right column
                creature1Health = new JLabel("HP  " + Double.toString(tames.get(i).getHp()));
                creature1Health.setBounds(x2, y, width, height);
                add(creature1Health);
                creature1Stamina = new JLabel("Stam  "+String.valueOf(tames.get(i).getStamina()));
                creature1Stamina.setBounds(x2, y + 25, width, height);
                add(creature1Stamina);
                creature1Weight = new JLabel("Weight  "+String.valueOf(tames.get(i).getWeight()));
                creature1Weight.setBounds(x2, y + 50, width, height);
                add(creature1Weight);
                creature1Melee = new JLabel("Melee  "+String.valueOf(tames.get(i).getMelee()));
                creature1Melee.setBounds(x2, y + 75, width, height);
                add(creature1Melee);
                creature1Movement = new JLabel("Movement  "+String.valueOf(tames.get(i).getMovement()));
                creature1Movement.setBounds(x2, y + 100, width, height);
                add(creature1Movement);
                creature1Torpor = new JLabel("Torpor  "+String.valueOf(tames.get(i).getTorpor()));
                creature1Torpor.setBounds(x2, y + 125, width, height);
                add(creature1Torpor); 

            }
            System.out.println(tames.get(i).toString());

        }
        paint(getGraphics());
    }

    //Method is called when the Submit Button is pressed
    //Determines Species and creates Object of correct Sub-Class
    //Then added that creature to the Tames list for the world
    public void createCreature(String n, String sp, char gen, double hp, double stam, double oxy, double f,
    double w, double mel, double mov, double torp){
        //Sort and create the creatures based on species
        // Better or more effective way to apply polymorphism??
        switch (sp) {
            case "Allosaurus":
            Allosaurus allosaurus = new Allosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(allosaurus);
                break;
            case "Ankylosaurus":
            Ankylosaurus ankylosaurus = new Ankylosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(ankylosaurus);
                break;
            case "Argentavis":
            Argentavis argentavis = new Argentavis(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(argentavis);
                break;
            case "Beelzebufo":
            Beelzebufo Beelzebufo = new Beelzebufo(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(Beelzebufo);
                break;
            case "Brontosaurus":
            Brontosaurus brontosaurus = new Brontosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(brontosaurus);
                break;
            case "Castoroides":
            Castoroides castoroides = new Castoroides(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(castoroides);
                break;
            case "Raptor":  
            Raptor raptor = new Raptor(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(raptor);
                break;
            case "Rex":  
            Rex rex = new Rex(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(rex);
                break;
            case "Parasaur":  
            Parasaur parasaur = new Parasaur(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(parasaur);
                break;
            case "Pteranadon":  
            Pteranadon pteranadon = new Pteranadon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(pteranadon);
                break;
            case "Yutyrannus":
            Yutyrannus yutyrannus = new Yutyrannus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(yutyrannus);
                break;
            
            case "Doedicurus":
            Doedicurus doedicurus = new Doedicurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(doedicurus);
                break;
            case "Kairuku":
            Kairuku kairuku = new Kairuku(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(kairuku);
                break;
            case "Megalodon":
            Megalodon megalodon = new Megalodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(megalodon);
                break;
            case "Megatherium":
            Megatherium megatherium= new Megatherium(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(megatherium);
                break;
            case "Pulmonoscorpius":
            Pulmonoscorpius pulmonoscorpius = new Pulmonoscorpius(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(pulmonoscorpius);
                break;
            case "Sabertooth":
            Sabertooth sabertooth = new Sabertooth(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(sabertooth);
                break;
            case "Therizinosaurus":
            Therizinosaurus therizinosaurus = new Therizinosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(therizinosaurus);
                break;
            case "Titanoboa":
            Titanoboa titanoboa = new Titanoboa(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(titanoboa);
                break;
            case "Direwolf":
            Direwolf direwolf = new Direwolf(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(direwolf);
                break;
            default:
                break;
        }
    }




    // Getters Section
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

    public JTextField getNewCreatureGenderTextField() {
        return newCreatureGenderTextField;
    }

    public JTextField getNewCreatureHPTextField() {
        return newCreatureHPTextField;
    }

    public JTextField getNewCreatureStaminaTextField() {
        return newCreatureStaminaTextField;
    }

    public JTextField getNewCreatureOxygenTextField() {
        return newCreatureOxygenTextField;
    }

    public JTextField getNewCreatureFoodTextField() {
        return newCreatureFoodTextField;
    }

    public JTextField getNewCreatureWeighTextField() {
        return newCreatureWeighTextField;
    }

    public JTextField getNewCreatureMeleeTextField() {
        return newCreatureMeleeTextField;
    }

    public JTextField getNewCreatureMovementTextField() {
        return newCreatureMovementTextField;
    }

    public JTextField getNewCreatureTorporTextField() {
        return newCreatureTorporTextField;
    }

    public JTextField getNewCreatureSpeciesTextField() {
        return newCreatureSpeciesTextField;
    }

}
