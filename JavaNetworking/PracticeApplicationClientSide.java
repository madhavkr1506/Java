import javax.swing.JFrame;

public class PracticeApplicationClientSide {
    private static JFrame frame = new JFrame("Java Application Client Side");


    PracticeApplicationClientSide(){
        prepareGui();

    }

    public static void prepareGui(){

        frame.setSize(500,400);
        frame.setLocation(100,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        prepareGui();
    }
}
