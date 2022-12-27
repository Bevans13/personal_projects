import javax.swing.JButton;

/*Sub-Class of JButtons used to cut down on the amount of coding needed in the 
    UserInterface class for sizing and other general button settings
*/
public class MainMenuSelectionButtons extends JButton {



    public MainMenuSelectionButtons() {
        super();
    }

    public MainMenuSelectionButtons(String s){
        super(s);
        int width = UserInterface.getUI_WIDTH();
        int height = UserInterface.getUI_HEIGHT();
        setSize(WIDTH, HEIGHT);

    }
}
