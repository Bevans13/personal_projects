import javax.swing.*;
import java.awt.*;

public class World extends JPanel{

    private String worldName;
    private String saveFilePath;

    //Declare Buttons that will exist for every world
    private JButton returnButton = new JButton("Return");
    private JButton addCreatureButton = new JButton("Add");
    private JButton viewCreatureButton = new JButton("View");
    
    public World(String worldName, String filePath) {
        super();
        this.worldName = worldName;
        this.saveFilePath = filePath;

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
    }

}
