import java.awt.*;
import javax.swing.*;

public class UserInterface extends JPanel {

private final int UI_WIDTH = 1200;
private final int UI_HEIGHT = 700;
private static final Color BACKGROUND_COLOR = Color.cyan;


public UserInterface(){
    setPreferredSize(new Dimension(UI_WIDTH,UI_HEIGHT));
    setBackground(BACKGROUND_COLOR);

}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
}

public int getUI_HEIGHT() {
    return UI_HEIGHT;
}

public int getUI_WIDTH() {
    return UI_WIDTH;
}

}