import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import Creatures.*;

public class WorldPanel extends JPanel{

    private static int WorldPanelWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static int WorldPanelHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    private JLabel label;
    private String worldName;
    private String saveFilePath;

    //Variables to build background image
    private String targetFileName;
    private File targetFile;
    private BufferedImage backgroundImage;

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
    private int controlVariable;

    //View Option Labels and Buttons
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
    private JLabel[] creatureDisplayLabels = new JLabel[]{
        creature1Name, creature1Species, creature1Gender,
        creature1Health,creature1Stamina,creature1Oxygen,
        creature1Food, creature1Weight, creature1Melee,
        creature1Movement,creature1Torpor};
    private JButton RIPCreature1Button = new JButton("RIP 1");
    private JButton RIPCreature2Button = new JButton("RIP 2");
    private JButton RIPCreature3Button = new JButton("RIP 3");
    private JButton RIPCreature4Button = new JButton("RIP 4");
    private JButton RIPCreature5Button = new JButton("RIP 5");
    private JButton RIPCreature6Button = new JButton("RIP 6");
    private JButton RIPCreature7Button = new JButton("RIP 7");
    private JButton RIPCreature8Button = new JButton("RIP 8");
    private JButton RIPCreature9Button = new JButton("RIP 9");
    private JButton RIPCreature10Button = new JButton("RIP 10");
    private JButton RIPCreature11Button = new JButton("RIP 11");
    private JButton RIPCreature12Button = new JButton("RIP 12");
    private JButton[] RIPButtons = new JButton[]{
        RIPCreature1Button,RIPCreature2Button,RIPCreature3Button,RIPCreature4Button,
        RIPCreature5Button,RIPCreature6Button,RIPCreature7Button,RIPCreature8Button,
        RIPCreature9Button,RIPCreature10Button,RIPCreature11Button,RIPCreature12Button
    };
    private JButton nextPageButton = new JButton("Next Page");
    private JButton prevPageButton = new JButton("Prev Page");
    private int currentPage = 1;
    private JLabel pageIndicator = new JLabel("Page #"+currentPage);

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

        //Establishing Background and loading image
        targetFileName = "../ArkTrackerImages/"+saveFilePath+"_MAP.jpeg";
        targetFile = new File(targetFileName);
        try {
            backgroundImage = ImageIO.read(targetFile);
        } catch (IOException exc) {
            System.out.println("Error opening image file: "+exc.getMessage());
        }
        setBackground(Color.WHITE);
    }

    // seems to run automatically as part of contructor? should probable check the
    // Super() contsructor documentation
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawLabel(g);
        drawButtons(g);
    }

    public void drawBackground(Graphics g) {
        
        g.drawImage(backgroundImage, 0, 0, WorldPanelWidth, WorldPanelHeight, null);
    }

    public void drawLabel(Graphics g) {
        label.setBounds((5*WorldPanelWidth)/12, 5, WorldPanelWidth/6, 25);
        add(label);
        //remove or fix
        //pageIndicator.setText("Page #"+currentPage);
        //pageIndicator = new JLabel("Page #"+currentPage);
        pageIndicator.setBounds((WorldPanelWidth-75), 15, 50, 25);
        add(pageIndicator);

    }

    public void drawButtons(Graphics g) {
        returnButton.setBounds(15, 15, 75, 50);
        add(returnButton);

        addCreatureButton.setBounds(returnButton.getX() + returnButton.getWidth() + 15, 15, 100, 100);
        add(addCreatureButton);
        viewCreatureButton.setBounds(addCreatureButton.getX() + addCreatureButton.getWidth() + 15, 15, 100, 100);
        add(viewCreatureButton);
        
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

        submitTextFieldButton.setBounds(viewCreatureButton.getX()+viewCreatureButton.getWidth()+15, 15, 100, 100);
        add(submitTextFieldButton);
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


    public void viewCreatures(ArrayList<Creature> tamesToView) {
        int x;
        int y;
        //allows i to be manipulated and varied based on the page of creatures program is on
        controlVariable = (9*(currentPage-1));

        
        
        for (int i = 0; i < 9 && i < tames.size()-controlVariable; i++) {
            //Adds a RIP Button for each of the creatures shown
            RIPButtons[i].setBounds(400+(i*50), 35, 35, 20);
            add(RIPButtons[i]);
            // 0 1 2
            if ((i+controlVariable)/3 == 0+(controlVariable/3)) {
                x = (WorldPanelWidth/12)+((i * 4)*(WorldPanelWidth/12));
                y = 200;
                displayCreature(x, y, i+controlVariable);
            } 
            // 3 4 5
            if ((i+controlVariable)/3==1+(controlVariable/3)) {
                x = (WorldPanelWidth/12)+(((i-3) * 4)*(WorldPanelWidth/12));
                y = 400;
                displayCreature(x, y, i+controlVariable);
                
            }
            // 6 7 8
            if ((i+controlVariable)/3==2+(controlVariable/3)) {
                x = (WorldPanelWidth/12)+(((i-6) * 4)*(WorldPanelWidth/12));
                y = 600;
                displayCreature(x, y, i+controlVariable);
                
            }
            if (tames.size()>9*currentPage) {
                nextPageButton.setBounds((7*WorldPanelWidth)/8, 15, 100, 25);
                add(nextPageButton);
            }
            if (currentPage != 1) {
                prevPageButton.setBounds(nextPageButton.getX()-125, 15, 100,25);
                add(prevPageButton);
            }

            // System.out.println(tames.get(i).toString()); Seemingly not needed anymore
        }

        paint(getGraphics());
    }

    public void displayCreature(int x, int y, int i){
        int width = WorldPanelWidth/12;
        int height = 25;
        int x1 = 0;
        int x2 = x1 + width;

        JPanel creatureDispJPanel = new JPanel();
        creatureDispJPanel.setBounds(x, y, width*2, height*8);

        // left column
        creature1Name = new JLabel(tames.get(i).getName());
        creature1Name.setBounds(x1, 25, width, height);
        creatureDispJPanel.add(creature1Name);
        creature1Species = new JLabel(tames.get(i).getSpecies());
        creature1Species.setBounds(x1, 50, width, height);
        creatureDispJPanel.add(creature1Species);
        creature1Gender = new JLabel(String.valueOf(tames.get(i).getGender()));
        creature1Gender.setBounds(x1, 75, width, height);
        creatureDispJPanel.add(creature1Gender);
        creature1Oxygen = new JLabel("O2   "+String.valueOf(tames.get(i).getOxygen()));
        creature1Oxygen.setBounds(x1, 100, width, height);
        creatureDispJPanel.add(creature1Oxygen);
        creature1Food = new JLabel("Food  "+String.valueOf(tames.get(i).getFood()));
        creature1Food.setBounds(x1, 125, width, height);
        creatureDispJPanel.add(creature1Food);
        //right column
        creature1Health = new JLabel("HP  " + Double.toString(tames.get(i).getHp()));
        creature1Health.setBounds(x2, 0, width, height);
        creatureDispJPanel.add(creature1Health);
        creature1Stamina = new JLabel("Stam  "+String.valueOf(tames.get(i).getStamina()));
        creature1Stamina.setBounds(x2, 25, width, height);
        creatureDispJPanel.add(creature1Stamina);
        creature1Weight = new JLabel("Weight  "+String.valueOf(tames.get(i).getWeight()));
        creature1Weight.setBounds(x2, 50, width, height);
        creatureDispJPanel.add(creature1Weight);
        creature1Melee = new JLabel("Melee  "+String.valueOf(tames.get(i).getMelee()));
        creature1Melee.setBounds(x2, 75, width, height);
        creatureDispJPanel.add(creature1Melee);
        creature1Movement = new JLabel("Movement  "+String.valueOf(tames.get(i).getMovement()));
        creature1Movement.setBounds(x2, 100, width, height);
        creatureDispJPanel.add(creature1Movement);
        creature1Torpor = new JLabel("Torpor  "+String.valueOf(tames.get(i).getTorpor()));
        creature1Torpor.setBounds(x2, 125, width, height);
        creatureDispJPanel.add(creature1Torpor); 

        add(creatureDispJPanel);
    }

    //Method is called when the Submit Button is pressed
    //Determines Species and creates Object of correct Sub-Class
    //Then added that creature to the Tames list for the world
    public void createCreature(String n, String sp, char gen, double hp, double stam, double oxy, double f,
    double w, double mel, double mov, double torp){
        //Sort and create the creatures based on species
        // Better or more effective way to apply polymorphism??
        sp = sp.toLowerCase();

        switch (sp) {
            case "achatina":
            Achatina achatina = new Achatina(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(achatina);
                break;
            case "allosaurus":
            Allosaurus allosaurus = new Allosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(allosaurus);
                break;
            case "angler":
            Angler angler = new Angler(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(angler);
                break;
            case "ankylosaurus":
            Ankylosaurus ankylosaurus = new Ankylosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(ankylosaurus);
                break;
            case "araneo":
            Araneo araneo = new Araneo(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(araneo);
                break;
            case "archaeopteryx":
            Archaeopteryx archaeopteryx = new Archaeopteryx(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(archaeopteryx);
                break;
            case "argentavis":
            Argentavis argentavis = new Argentavis(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(argentavis);
                break;
            case "arthropluera":
            Arthropluera arthropluera = new Arthropluera(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(arthropluera);
                break;
            case "baryonyx":
            Baryonyx baryonyx = new Baryonyx(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(baryonyx);
                break;
            case "basilosaurus":
            Basilosaurus basilosaurus = new Basilosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(basilosaurus);
                break;
            case "beelzebufo":
            Beelzebufo Beelzebufo = new Beelzebufo(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(Beelzebufo);
                break;
            case "brontosaurus":
            Brontosaurus brontosaurus = new Brontosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(brontosaurus);
                break;
            case "carbonemys":
            Carbonemys carbonemys = new Carbonemys(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(carbonemys);
                break;
            case "carcharodontosaurus":
            Carcharodontosaurus carcharodontosaurus = new Carcharodontosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(carcharodontosaurus);
                break;
            case "carnotaurus":
            Carnotaurus carnotaurus = new Carnotaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(carnotaurus);
                break;
            case "castoroides":
            Castoroides castoroides = new Castoroides(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(castoroides);
                break;
            case "chalicotherium":
            Chalicotherium chalicotherium = new Chalicotherium(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(chalicotherium);
                break;
            case "coelacanth":
            Coelacanth coelacanth = new Coelacanth(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(coelacanth);
                break;
            case "compy":
            Compy compy = new Compy(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(compy);
                break;
            case "daeodon":
            Daeodon daeodon = new Daeodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(daeodon);
                break;
            case "dilophosaur":
            Dilophosaur dilophosaur = new Dilophosaur(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(dilophosaur);
                break;
            case "dimetrodon":
            Dimetrodon dimetrodon = new Dimetrodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(dimetrodon);
                break;
            case "dimorphodon":
            Dimorphodon dimorphodon = new Dimorphodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(dimorphodon);
                break;
            case "diplocaulus":
            Diplocaulus diplocaulus = new Diplocaulus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(diplocaulus);
                break;
            case "diplodocus":
            Diplodocus diplodocus = new Diplodocus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(diplodocus);
                break;
            case "direbear":
            Direbear direbear = new Direbear(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(direbear);
                break;
            case "direwolf":
            Direwolf direwolf = new Direwolf(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(direwolf);
                break;
            case "dodo":
            Dodo dodo = new Dodo(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(dodo);
                break;
            case "doedicurus":
            Doedicurus doedicurus = new Doedicurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(doedicurus);
                break;
            case "dung Beetle":
            DungBeetle dungBeetle = new DungBeetle(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(dungBeetle);
                break;
            case "dunkleosteus":
            Dunkleosteus dunkleosteus = new Dunkleosteus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(dunkleosteus);
                break;
            case "electrophorus":
            Electrophorus electrophorus = new Electrophorus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(electrophorus);
                break;
            case "equus":
            Equus equus = new Equus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(equus);
                break;
            case "gallimimus":
            Gallimimus gallimimus = new Gallimimus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(gallimimus);
                break;
            case "giant bee":
            GiantBee giantBee = new GiantBee(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(giantBee);
                break;
            case "giganotosaurus":
            Giganotosaurus giganotosaurus = new Giganotosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(giganotosaurus);
                break;
            case "gigantopithecus":
            Gigantopithecus gigantopithecus = new Gigantopithecus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(gigantopithecus);
                break;
            case "hesperornis":
            Hesperornis hesperornis = new Hesperornis(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(hesperornis);
                break;
            case "hyaenodon":
            Hyaenodon hyaenodon = new Hyaenodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(hyaenodon);
                break;
            case "ichthyornis":
            Ichthyornis ichthyornis = new Ichthyornis(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(ichthyornis);
                break;
            case "ichthyosaurus":
            Ichthyosaurus ichthyosaurus = new Ichthyosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(ichthyosaurus);
                break;
            case "iguanodon":
            Iguanodon iguanodon = new Iguanodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(iguanodon);
                break;
            case "kairuku":
            Kairuku kairuku = new Kairuku(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(kairuku);
                break;
            case "kaprosuchus":
            Kaprosuchus kaprosuchus = new Kaprosuchus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(kaprosuchus);
                break;
            case "kentrosaurus":
            Kentrosaurus kentrosaurus = new Kentrosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(kentrosaurus);
                break;
            case "liopleurodon":
            Liopleurodon liopleurodon = new Liopleurodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(liopleurodon);
                break;
            case "lystrosaurus":
            Lystrosaurus lystrosaurus = new Lystrosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(lystrosaurus);
                break;
            case "mammoth":
            Mammoth mammoth = new Mammoth(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(mammoth);
                break;
            case "manta":
            Manta manta = new Manta(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(manta);
                break;
            case "megalania":
            Megalania megalania = new Megalania(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(megalania);
                break;
            case "megaloceros":
            Megaloceros megaloceros = new Megaloceros(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(megaloceros);
                break;
            case "megalodon":
            Megalodon megalodon = new Megalodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(megalodon);
                break;
            case "megalosaurus":
            Megalosaurus megalosaurus = new Megalosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(megalosaurus);
                break;
            case "megatherium":
            Megatherium megatherium= new Megatherium(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(megatherium);
                break;
            case "mesopithecus":
            Mesopithecus mesopithecus = new Mesopithecus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(mesopithecus);
                break;
            case "microraptor":
            Microraptor microraptor = new Microraptor(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(microraptor);
                break;
            case "mosasaurus":
            Mosasaurus mosasaurus = new Mosasaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(mosasaurus);
                break;
            case "moschops":
            Moschops moschops = new Moschops(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(moschops);
                break;
            case "onyc":
            Onyc onyc = new Onyc(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(onyc);
                break;
            case "otter":
            Otter otter = new Otter(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(otter);
                break;
            case "oviraptor":
            Oviraptor oviraptor = new Oviraptor(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(oviraptor);
                break;
            case "ovis":
            Ovis ovis = new Ovis(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(ovis);
                break;
            case "pachy":
            Pachy pachy = new Pachy(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(pachy);
                break;
            case "pachyrhinosaurus":
            Pachyrhinosaurus pachyrhinosaurus = new Pachyrhinosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(pachyrhinosaurus);
                break;
            case "paraceratherium":
            Paraceratherium paraceratherium = new Paraceratherium(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(paraceratherium);
                break;
            case "parasaur":  
            Parasaur parasaur = new Parasaur(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(parasaur);
                break;
            case "pegomastax":
            Pegomastax pegomastax = new Pegomastax(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(pegomastax);
                break;
            case "pelagornis":
            Pelagornis pelagornis = new Pelagornis(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(pelagornis);
                break;
            case "phiomia":
            Phiomia phiomia = new Phiomia(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(phiomia);
                break;
            case "plesiosaur":
            Plesiosaur plesiosaur = new Plesiosaur(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(plesiosaur);
                break;
            case "procoptodon":
            Procoptodon procoptodon = new Procoptodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(procoptodon);
                break;
            case "pteranodon":  
            Pteranodon pteranodon = new Pteranodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(pteranodon);
                break;
            case "pulmonoscorpius":
            Pulmonoscorpius pulmonoscorpius = new Pulmonoscorpius(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(pulmonoscorpius);
                break;
            case "purlovia":
            Purlovia purlovia = new Purlovia(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(purlovia);
                break;
            case "quetzal":
            Quetzal quetzal = new Quetzal(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(quetzal);
                break;
            case "raptor":  
            Raptor raptor = new Raptor(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(raptor);
                break;
            case "rex":  
            Rex rex = new Rex(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(rex);
                break;
            case "sabertooth":
            Sabertooth sabertooth = new Sabertooth(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(sabertooth);
                break;
            case "sarco":
            Sarco sarco = new Sarco(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(sarco);
                break;
            case "spinosaurus":
            Spinosaurus spinosaurus = new Spinosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(spinosaurus);
                break;
            case "stegosaurus":
            Stegosaurus stegosaurus = new Stegosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(stegosaurus);
                break;
            case "tapejara":
            Tapejara tapejara = new Tapejara(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(tapejara);
                break;
            case "terror bird":
            TerrorBird terrorBird = new TerrorBird(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(terrorBird);
                break;
            case "therizinosaurus":
            Therizinosaurus therizinosaurus = new Therizinosaurus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(therizinosaurus);
                break;
            case "thylacoleo":
            Thylacoleo thylacoleo = new Thylacoleo(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(thylacoleo);
                break;
            case "titanoboa":
            Titanoboa titanoboa = new Titanoboa(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(titanoboa);
                break;
            case "triceratops":
            Triceratops triceratops = new Triceratops(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(triceratops);
                break;
            case "troodon":
            Troodon troodon = new Troodon(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(troodon);
                break;
            case "tusoteuthis":
            Tusoteuthis tusoteuthis = new Tusoteuthis(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(tusoteuthis);
                break;
            case "woolly rhino":
            WoollyRhino woollyRhino = new WoollyRhino(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(woollyRhino);
                break;
            case "yutyrannus":
            Yutyrannus yutyrannus = new Yutyrannus(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
            tames.add(yutyrannus);
                break;
            default:
            System.out.println("Creature Class not found, Not Added to Tames");
                break;
        }
    }

    public void killCreature(JButton button){

         for (int i = 0; i < RIPButtons.length; i++) {
            if (RIPButtons[i]==button) {
                System.out.println("Goodbye: "+tames.get(i+controlVariable).getName());
                tames.remove(i+controlVariable);
            }
         }
        
    }

    //calls sort() on the Tames ArrayList
    public void sortTames(){
    tames.sort(null);
        for (int i = 0; i < tames.size(); i++) {
        
        }
    }

    @Override
    public String toString() {
        return worldName + super.toString();
    }

    // Getters Section
    public JLabel getLabel() {
        return label;
    }public JButton getReturnButton() {
        return returnButton;
    } public JButton getAddCreatureButton() {
        return addCreatureButton;
    } public JButton getViewCreatureButton() {
        return viewCreatureButton;
    } public String getWorldName() {
        return worldName;
    } public String getSaveFilePath() {
        return saveFilePath;
    } public ArrayList<Creature> getTames() {
        return tames;
    } public void setTames(ArrayList<Creature> tames) {
        this.tames = tames;
    } public JButton getSubmitTextFieldButton() {
        return submitTextFieldButton;
    } public JTextField getNewCreatureNameTextField() {
        return newCreatureNameTextField;
    }public JTextField getNewCreatureGenderTextField() {
        return newCreatureGenderTextField;
    }public JTextField getNewCreatureHPTextField() {
        return newCreatureHPTextField;
    } public JTextField getNewCreatureStaminaTextField() {
        return newCreatureStaminaTextField;
    } public JTextField getNewCreatureOxygenTextField() {
        return newCreatureOxygenTextField;
    } public JTextField getNewCreatureFoodTextField() {
        return newCreatureFoodTextField;
    } public JTextField getNewCreatureWeighTextField() {
        return newCreatureWeighTextField;
    } public JTextField getNewCreatureMeleeTextField() {
        return newCreatureMeleeTextField;
    } public JTextField getNewCreatureMovementTextField() {
        return newCreatureMovementTextField;
    } public JTextField getNewCreatureTorporTextField() {
        return newCreatureTorporTextField;
    } public JTextField getNewCreatureSpeciesTextField() {
        return newCreatureSpeciesTextField;
    } public JButton[] getRIPButtons() {
        return RIPButtons;
    } public JButton getNextPageButton() {
        return nextPageButton;
    } public int getCurrentPage() {
        return currentPage;
    } public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    } public void incrementCurrentPage(){
        ++currentPage;
    } public void decrementCurrentPage(){
        --currentPage;
    } public JButton getPrevPageButton() {
        return prevPageButton;
    } public JLabel getPageIndicator() {
        return pageIndicator;
    } 
}