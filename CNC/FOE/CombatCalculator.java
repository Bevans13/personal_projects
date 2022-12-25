import javax.swing.*;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import Creatures.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class CombatCalculator extends JPanel implements ActionListener {
    //Declare and estabish overall characteristics of CombatCalculator JPanel itself
    private final int CC_WIDTH = 1200;
    private final int CC_HEIGHT = 690;
    
    //Establish Lists for use in storing creatures that will be displayed 
    private ArrayList<Creature> enemies = new ArrayList<>();
    private ArrayList<Creature> companions = new ArrayList<>();
    private ArrayList<Player> charactersToDisplay = new ArrayList<>();
    
    //Buttons for the Combat Calculator JPanel
    private JButton addCharacterButton = new JButton("Add Character");
    private static JButton addEnemiesButton = new JButton("Add Enemies");
    //Establish MenuBar and Menus to go onto it.
    private static JMenuBar CombatCalculatorMenuBar = new JMenuBar();
    private static JMenu CharacterToCombatMenu = new JMenu("Add Character");
    private static ArrayList<JMenuItem> charactersToMenu = new ArrayList<>();
    private static JMenuItem characterMenuItem;
    //Establish panels and components that go into those panels for each respective Creature
    private ArrayList<JTextArea> playerTextAreas = new ArrayList<>();
    private ArrayList<JLabel> playerLabels = new ArrayList<>();
    private ArrayList<JPanel> playerPanels = new ArrayList<>();
    private ArrayList<JPanel> enemyPanels = new ArrayList<>();
    private ArrayList<Rectangle> playerPanelRectangle = new ArrayList<>();

    public CombatCalculator() {

        setPreferredSize(new Dimension(CC_WIDTH,CC_HEIGHT));
        setBackground(Color.GREEN);
        CombatCalculatorMenuBar.add(CharacterToCombatMenu);

    }

    public void createCombatCalculatorMenus() {
        //checks if the Menu for playable characters matches the number of playable characters there are
        if (charactersToMenu.size() < FallOutEquestria.getPlayableCharacters().size()) {
            for (int i = 0; i < FallOutEquestria.getPlayableCharacters().size(); i++) {
                Player c= FallOutEquestria.getPlayableCharacters().get(i);
                characterMenuItem = new JMenuItem(c.getName());
                characterMenuItem.addActionListener(this);
                CharacterToCombatMenu.add(characterMenuItem);
                charactersToMenu.add(characterMenuItem);;
            }     
            System.out.println("# in Menu now: "+charactersToMenu.size());
        }
        //Set MenuBar to the Window
        FallOutEquestria.getWindow().setJMenuBar(CombatCalculatorMenuBar);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawButtons(g);
    }

    private void drawButtons(Graphics g) {
        FallOutEquestria.getReturnToHomeButton().setBounds(10, 10, 50, 50);
        this.add(FallOutEquestria.getReturnToHomeButton());
        FallOutEquestria.getReturnToHomeButton().addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
       if (e.getSource()==FallOutEquestria.getReturnToHomeButton()) {
           //Removes Combat Calculator Menu Bar
            FallOutEquestria.getWindow().setJMenuBar(null);
            clearField();
            FallOutEquestria.getCombatCalculator().setBackground(Color.GREEN);
            FallOutEquestria.returnToUserInterface();
       }
        for (int i = 0; i < charactersToMenu.size(); i++) {
            if (e.getSource()==charactersToMenu.get(i)) {
                setBackground(Color.BLACK);
                System.out.println(charactersToMenu.get(i).getText());
                updateFieldOfBattle(FallOutEquestria.getPlayableCharacters().get(i));
            }
        }
        for (int i = 0; i < charactersToDisplay.size(); i++) {
            Player player = charactersToDisplay.get(i);
            if (e.getSource()==player.getAttackButton()) {
                setBackground(Color.ORANGE);
            }
            if (e.getSource()==player.getItemsButton()) {
                setBackground(Color.PINK);
                //Test for inventory popup Menu
                JPopupMenu itemCategory = new JPopupMenu("Item menu");
                itemCategory.setBounds(400, 250, 200, 200);
                itemCategory.setVisible(true);
                this.add(itemCategory);
            }
            if (e.getSource()==player.getMiscButton()) {
                setBackground(Color.CYAN);
                player.takeDamage(50);
            }
        }
        FallOutEquestria.writeSaveData();
    }
    
    public void updateFieldOfBattle(Player player){
        if(!charactersToDisplay.contains(player)){
            charactersToDisplay.add(player);

            addPlayerTable(player);


            repaint();
        }

    }

    private void addPlayerTable(Player player) {
        //Creates Panel to hold components for given Player
        int JPanelWidth = 120;
        int JPanelHeight = 320;
        int TableRowHeight = 20;
        TableColumn column;
        JPanel newPlayerPanel = new JPanel();
        newPlayerPanel.setBounds(10+((20+JPanelWidth)*charactersToDisplay.indexOf(player)), 70, JPanelWidth, JPanelHeight);
        playerPanels.add(newPlayerPanel);
        DefaultTableCellRenderer centerAlignRenderer = new DefaultTableCellRenderer();
        centerAlignRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.add(newPlayerPanel);


        
        //HP Bar create and place
        player.getHealthBar().setBounds(0, 0, JPanelWidth, TableRowHeight);
        player.getHealthBar().setBackground(Color.red);
        player.getHealthBar().setForeground(Color.green);
        newPlayerPanel.add(player.getHealthBar());
 

        //Create and Place SPECIAL Table 
        PlayerDisplayTable newPlayerSPECIALTable = new PlayerDisplayTable(new PlayerDisplayTableModel(player,1));
        newPlayerSPECIALTable.setBounds(0, 20, JPanelWidth, newPlayerSPECIALTable.getRowCount()*TableRowHeight);
        // newPlayerSPECIALTable.setBackground(Color.YELLOW);
        newPlayerSPECIALTable.setRowHeight(TableRowHeight);
        // newPlayerSPECIALTable.setGridColor(Color.RED);
        for (int i = 0; i < 7; i++) {
            column = newPlayerSPECIALTable.getColumnModel().getColumn(i);
            column.setMaxWidth(JPanelWidth/newPlayerSPECIALTable.getColumnCount());
            column.setCellRenderer(centerAlignRenderer);
        }
        newPlayerPanel.add(newPlayerSPECIALTable);

        //Create and position table for the player/panel
        PlayerDisplayTable newPlayerTable = new PlayerDisplayTable(new PlayerDisplayTableModel(player));
        newPlayerTable.setBounds(0, newPlayerSPECIALTable.getY()+newPlayerSPECIALTable.getHeight(), JPanelWidth, newPlayerTable.getRowCount()*TableRowHeight);
        // newPlayerTable.setBackground(Color.RED);
        newPlayerTable.setRowHeight(TableRowHeight);
        //Creates column and renderer to set Column widths and assign alignments
        for (int i = 0; i < 2; i++) {
            column = newPlayerTable.getColumnModel().getColumn(i);
            if (i==0) {
                column.setMaxWidth(JPanelWidth-50);
            } else {
                column.setMaxWidth(50);
                column.setCellRenderer(centerAlignRenderer);
            }
        }   
        newPlayerPanel.add(newPlayerTable);

        //Create and position JButtons for each player
        player.getAttackButton().setBounds(0, newPlayerTable.getY()+newPlayerTable.getHeight(), JPanelWidth/3, JPanelWidth/3);
        player.getAttackButton().addActionListener(this);
        newPlayerPanel.add(player.getAttackButton());
        player.getItemsButton().setBounds(player.getAttackButton().getWidth(), player.getAttackButton().getY(), JPanelWidth/3, JPanelWidth/3);
        player.getItemsButton().addActionListener(this);
        newPlayerPanel.add(player.getItemsButton());
        player.getMiscButton().setBounds(player.getAttackButton().getWidth()*2, player.getAttackButton().getY(), JPanelWidth/3, JPanelWidth/3);
        player.getMiscButton().addActionListener(this);
        newPlayerPanel.add(player.getMiscButton());

    }

    public void clearField(){
        charactersToDisplay.clear();
        for (int i = 0; i < playerPanels.size(); i++) {
            playerPanels.get(i).removeAll();
        }
        playerPanels.clear();
        removeAll();
        
        repaint();
    }

}