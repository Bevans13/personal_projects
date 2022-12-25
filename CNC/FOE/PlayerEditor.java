import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerEditor extends JPanel implements ActionListener {
    
    private final int CE_WIDTH = 1200;
    private final int CE_HEIGHT = 690;

    private Rectangle[] inputFields = new Rectangle[19];

    private Rectangle nameFieldBounds;
    private Rectangle strengthFieldBounds;
    private Rectangle perceptionFieldBounds;
    private Rectangle enduranceFieldBounds;
    private Rectangle charismaFieldBounds;
    private Rectangle intelligenceFieldBounds;
    private Rectangle agilityFieldBounds;
    private Rectangle luckFieldBounds;
    private Rectangle levelFieldBounds                  ;
    private Rectangle healthPointsFieldBounds           ;
    private Rectangle smallGunsFieldBounds              ;
    private Rectangle bigGunsFieldBounds                ;
    private Rectangle magicalEnergyWeaponsFieldBounds   ;
    private Rectangle meleeWeaponsFieldBounds           ;
    private Rectangle unarmedFieldBounds                ;
    private Rectangle explosiveFieldBounds              ;
    private Rectangle damageResistanceFieldBounds       ;
    private Rectangle actionPointsFieldBounds           ;
    private Rectangle carryWeightFieldBounds;

    public PlayerEditor(){
        setPreferredSize(new Dimension(CE_WIDTH,CE_HEIGHT));
        setBackground(Color.MAGENTA);
        
        //Assign field Rectangles to array index applicable
        inputFields[0] = nameFieldBounds;
        inputFields[1] = strengthFieldBounds;
        inputFields[2] = perceptionFieldBounds;
        inputFields[3] = enduranceFieldBounds;
        inputFields[4] = charismaFieldBounds;
        inputFields[5] = intelligenceFieldBounds;
        inputFields[6] = agilityFieldBounds;
        inputFields[7] = luckFieldBounds;
        inputFields[8] = levelFieldBounds;
        inputFields[9] = healthPointsFieldBounds;
        inputFields[10] = smallGunsFieldBounds;
        inputFields[11] = bigGunsFieldBounds;
        inputFields[12] = magicalEnergyWeaponsFieldBounds;
        inputFields[13] = meleeWeaponsFieldBounds;
        inputFields[14] = unarmedFieldBounds;
        inputFields[15] = explosiveFieldBounds;
        inputFields[16] = damageResistanceFieldBounds;
        inputFields[17] = actionPointsFieldBounds;
        inputFields[18] = carryWeightFieldBounds;

        for (int i = 0; i < inputFields.length; i++) {
            if (i<8) {
                //inputFields[0].setBounds(300, 240+(i*60), 120, 16);
                inputFields[i] = new Rectangle(300, 240+(i*60), 120, 16);
            }
            if (i>=8) {
                inputFields[i] = new Rectangle(600, 200+(i*30), 60, 16);
            }
        }
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawButtons(g);
    }

    private void drawButtons(Graphics g){
        //Return to Original Menu button
        FallOutEquestria.getReturnToHomeButton().setBounds(20, 20, 50, 50);
        this.add(FallOutEquestria.getReturnToHomeButton());
        FallOutEquestria.getReturnToHomeButton().addActionListener(this);
        //Create a Character Button
        FallOutEquestria.getCreateCharacterButton().setBounds((CE_WIDTH)/2-(3*CE_WIDTH/8), CE_HEIGHT-(3*CE_HEIGHT/16), CE_WIDTH/4, CE_HEIGHT/8);
        this.add(FallOutEquestria.getCreateCharacterButton());
        FallOutEquestria.getCreateCharacterButton().addActionListener(this);

    }

    private void drawJTextFields(){
        JTextField[] inputJTextFields = new JTextField[19];
        for (int i = 0; i < inputFields.length; i++) {
            //inputJTextFields[i].setBounds(inputFields[i]);
            //inputJTextFields[i].setBackground(Color.WHITE);
            this.add(inputJTextFields[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==FallOutEquestria.getReturnToHomeButton()) {
            FallOutEquestria.returnToUserInterface();
        }
        if (e.getSource()==FallOutEquestria.getCreateCharacterButton()) {
            setBackground(Color.BLACK);
            //drawJTextFields();
            //repaint();
        }
    }

    

    



}
