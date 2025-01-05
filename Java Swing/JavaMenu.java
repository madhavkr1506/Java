import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JavaMenu {

    JMenu menu,submenu;
    JMenuItem i1,i2,i3,i4,i5;
    JavaMenu(){
        JFrame frame = new JFrame("Java Menu");
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Menu");
        submenu = new JMenu("Submenu");
        i1 = new JMenuItem("item1");
        i2 = new JMenuItem("item2");
        i3 = new JMenuItem("item3");
        i4 = new JMenuItem("item4");
        i5 = new JMenuItem("item5");

        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        submenu.add(i4);
        submenu.add(i5);
        menu.add(submenu);
        mb.add(menu);

        frame.setJMenuBar(mb);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    public static void main(String[] args) {
        new JavaMenu();
    }
}
