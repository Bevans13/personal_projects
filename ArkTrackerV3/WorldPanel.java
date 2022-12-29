import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class WorldPanel extends JPanel{
    
public WorldPanel() {
    super();
    setBackground(Color.RED);
    add(new JLabel("World Panel"));
    //setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
}

@Override
public Dimension getPreferredSize() {
    return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
}


}
