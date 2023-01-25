import javax.swing.*;
import Creatures.*;
import java.awt.*;
import java.util.*;

public class World extends JPanel{

    private String worldName;
    private String saveFilePath;

    //Declare Buttons that will exist for every world
    private JLabel worldLabel;
    private JButton worldButton;
    private JButton returnButton = new JButton("Return");
    private JButton addCreatureButton = new JButton("Add");
    private JButton viewCreatureButton = new JButton("View");
    
    //Page management variables (for Viewing Tames)
    private JButton nextPageButton = new JButton("Next Page");
    private JButton prevPageButton = new JButton("Prev Page");
    private int currentPage = 1;
    private JLabel pageIndicator = new JLabel("Page #"+currentPage);


    //Creatures Tamed in the given World
    private ArrayList<Creature> tames;


    public World(String worldName, String filePath) {
        super();
        this.worldName = worldName;
        this.saveFilePath = filePath;
        worldButton = new JButton(worldName);
        worldLabel = new JLabel(worldName);

    }

    //Runs automatically with constructor to set Panel Size
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLabel(g);
        drawButtons(g);
    }

    public void drawLabel(Graphics g) {
        worldLabel.setBounds(AppWindow.getFrameWidth()/2-40, 15, 80, 25);
        add(worldLabel);
    }

    public void drawButtons(Graphics g){
        returnButton.setBounds(15, 15, 75, 50);
        add(returnButton);
        returnButton.addActionListener(AppWindow.getUserInterface());

        addCreatureButton.setBounds(returnButton.getX() + returnButton.getWidth() + 15, 15, 100, 100);
        add(addCreatureButton);
        addCreatureButton.addActionListener(AppWindow.getUserInterface());

        viewCreatureButton.setBounds(addCreatureButton.getX() + addCreatureButton.getWidth() + 15, 15, 100, 100);
        add(viewCreatureButton);
        viewCreatureButton.addActionListener(AppWindow.getUserInterface());

    }

    public void viewCreatures(World world) {
        int x;
        int y;
        //allows i to be manipulated and varied based on the page of creatures program is on
        int controlVariable = (9*(world.getCurrentPage()-1));

        
        
        for (int i = 0; i < 9 && i < tames.size()-controlVariable; i++) {
            System.out.println(tames.size()+" " +i);
            int width = AppWindow.getFrameWidth();
            int height = AppWindow.getFrameHeight();
            // 0 1 2
            if ((i+controlVariable)/3 == 0+(controlVariable/3)) {
                x = (width/12)+((i * 4)*(width/12));
                y = 200;
                displayCreature(x, y, i+controlVariable);
            } 
            // 3 4 5
            if ((i+controlVariable)/3==1+(controlVariable/3)) {
                x = (width/12)+(((i-3) * 4)*(width/12));
                y = 400;
                displayCreature(x, y, i);
                
            }
            // 6 7 8
            if ((i+controlVariable)/3==2+(controlVariable/3)) {
                x = (width/12)+(((i-6) * 4)*(width/12));
                y = 600;
                displayCreature(x, y, i);
                
            }
            if (tames.size()>9) {
                nextPageButton.setBounds((7*width)/8, 15, 100, 25);
                add(nextPageButton);
                prevPageButton.setBounds(nextPageButton.getX()-125, 15, 100,25);
                add(prevPageButton);
            }
            System.out.println(tames.get(i).toString());
        }
        paint(getGraphics());
    }

    public void displayCreature(int x, int y, int i){
        int x2 = x + WorldPanelWidth/12;
        int width = WorldPanelWidth/12;
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


    //Getters & Setters
    public String getWorldName() {
        return worldName;
    } public void setWorldName(String worldName) {
        this.worldName = worldName;
    } public String getSaveFilePath() {
        return saveFilePath;
    } public void setSaveFilePath(String saveFilePath) {
        this.saveFilePath = saveFilePath;
    } public JButton getWorldButton() {
        return worldButton;
    } public JLabel getWorldLabel() {
        return worldLabel;
    } public int getCurrentPage() {
        return currentPage;
    } public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
