import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class JavaPopupMenu {

    JavaPopupMenu(){
        final JFrame frame = new JFrame("PopupMenu");

        final JPopupMenu popupMenu = new JPopupMenu("Edit");

        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        popupMenu.add(cut);popupMenu.add(copy);popupMenu.add(paste);

        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                popupMenu.show(frame, e.getX(), e.getY());
            }
        });

        frame.add(popupMenu);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new JavaPopupMenu();
    }
}
