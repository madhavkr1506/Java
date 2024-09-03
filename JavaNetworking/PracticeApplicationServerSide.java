import javax.swing.JFrame;

public class PracticeApplicationServerSide {

    private static JFrame frame = new JFrame("Java Application Server Side");

    PracticeApplicationServerSide(){
        prepareGui();
    }

    public static void prepareGui(){

        frame.setSize(500,400);
        frame.setLocation(700,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        
    }
}
