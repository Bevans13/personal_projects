import javax.swing.*;
import java.awt.*;

public class World extends JPanel{

    private String worldName;
    private String saveFilePath;

    //Declare Buttons that will exist for every world
    private JLabel worldLabel;
    private JButton worldButton;
    private JButton returnButton = new JButton("Return");
    private JButton addCreatureButton = new JButton("Add");
    private JButton viewCreatureButton = new JButton("View");
    
    public World(String worldName, String filePath) {
        super();
        this.worldName = worldName;
        this.saveFilePath = filePath;
        worldButton = new JButton(worldName);
        worldLabel = new JLabel(worldName);

        //Add ActionListeners
        // returnButton.addActionListener(AppWindow.getUserInterface());
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
    } 

}
