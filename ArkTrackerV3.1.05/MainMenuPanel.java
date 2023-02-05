import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.ImageIO;

public class MainMenuPanel extends JPanel{
    
    private static JLabel label;
    private static JButton theIslandMenuButton;
    private static JButton theCenterMenuButton;

    private static int MainMenuPanelWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static int MainMenuPanelHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static int buttonWidth = MainMenuPanelWidth/8;
    private static int buttonHeight = MainMenuPanelHeight/12;

    //Variables for setting the background
    private String targetFileName;
    private File targetFile;
    private BufferedImage backgroundImage;

    //Testing making an Icon show using JLabel
    /* Currently unalbe to get to work try again later
    // See line 52 fo this Class as well (in drawLabel())
    private static File testFile = new File("../../ArkTrackerImages/RaptorIcon.png");
    private static JLabel iconTest = new JLabel(new ImageIcon(testFile.getAbsolutePath()));
    */

    public MainMenuPanel() {
        super();
        label = new JLabel("Main Menu");
        theIslandMenuButton = new JButton("The Island");
        theCenterMenuButton = new JButton("The Center");
        
        setBackground(Color.WHITE);
        targetFileName = "../ArkTrackerImages/ark_main_menu_image.jpeg";
        targetFile = new File(targetFileName);
        try {
            backgroundImage = ImageIO.read(targetFile);
        } catch (IOException exc) {
            System.out.println("Error opening image file: "+exc.getMessage());
        }

    }

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
        
        g.drawImage(backgroundImage, 0, 0, MainMenuPanelWidth, MainMenuPanelHeight, null);

    }

    public void drawLabel(Graphics g) {
        label.setBounds(MainMenuPanelWidth/2-(80/2), 15, 80, 25);
        add(label);

        //Testing area for Icon implementations
        /* Unable to get to work, try again later
        // See line 20 of this Class as well
        System.out.println(testFile.getAbsolutePath());
        iconTest.setBounds(400, 400, 125, 125);
        add(iconTest);
         */
    }

    public void drawButtons(Graphics g) {
        theIslandMenuButton.setBounds(MainMenuPanelWidth/16, MainMenuPanelHeight/9, buttonWidth, buttonHeight);
        add(theIslandMenuButton);
        theCenterMenuButton.setBounds(5*MainMenuPanelWidth/16, MainMenuPanelHeight/9, buttonWidth, buttonHeight);
        add(theCenterMenuButton);

    }

    public static JButton getTheIslandMenuButton() {
        return theIslandMenuButton;
    }

    public static JButton getTheCenterMenuButton() {
        return theCenterMenuButton;
    }

}