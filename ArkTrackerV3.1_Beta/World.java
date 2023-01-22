import javax.swing.*;
import java.awt.*;

public class World extends JPanel{

    private String worldName;
    private String saveFilePath;

    //Declare Buttons that will exist for every world
    private JLabel worldLabel;
    private JButton worldButton;
    private static int worldButtonWidth = AppWindow.getFrameWidth()/8;
    private static int worldButtonHeight = AppWindow.getFrameHeight()/12;
    private JButton returnButton = new JButton("Return");
    private JButton addCreatureButton = new JButton("Add");
    private JButton viewCreatureButton = new JButton("View");
    
    public World(String worldName, String filePath) {
        super();
        this.worldName = worldName;
        this.saveFilePath = filePath;
        worldButton = new JButton(worldName);

        //Add ActionListeners
        returnButton.addActionListener(AppWindow.getUserInterface());
    }

    //Runs automatically with constructor to set Panel Size
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
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
    } public static int getWorldButtonHeight() {
        return worldButtonHeight;
    } public static int getWorldButtonWidth() {
        return worldButtonWidth;
    }

}
