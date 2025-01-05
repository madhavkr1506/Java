

import javax.swing.*;

public class JavaSwing1 {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        JButton b =new JButton("Madhav");

        b.setBounds(130,100,100,40); //--> x-axis, y-axis, width, height

        f.add(b);
        f.setSize(400,500); //--> width, height
        f.setLayout(null); //--> using no layout managers
        f.setVisible(true); // --> making frame visible
    }
} 

/*
 Swing is a Java Foundation Classes [JFC] library and an extension of the abstract window toolkit [AWT].
// Java swing offer much improved functionality over AWT, new components, Expanded components features, and excellent event hanling with drag and drop support.
// It is built on the top of AWT API and entirely written in java.

// Unlike AWT, Java swing is platform independent and light weight components.
// The javax.swing package provides classes for java swing API such as JButtom, JTextField, JTextArea, JRadioButton, JCheckbox, JMenu, JColorChooser etc.

// Java AWT : 

// Platform dependent
// Components are heavyWeight
// Doesn't support pluggable look and feel
// Provides less components than swing.
// Doesn't follow MVC(Model view controller) where model represents data, view represents presentation and controller acts as an interface between model and view.


// Java Swing

// Platform independent
// Components are light weight
// Supports pluggable look and feel
// Provides more powerful  components such as tables, list, scrollpanes, colorchooser, tabbedpane etc.
// Follow MVC

// JFC : The java foundation classes are a set of GUI components which simplify the development of desktop applications.

// Commonly used methods of component class

// public void add (component c) --> add a component on another component.

// public void setSize(int width, int height) --> sets size of the component.

// public void setLayout(LayoutManager m) --> sets the layout manager for the component.

// public void setVisible(boolean b) --> Sets the visibility of the component. it is by default false.


// Java swing examples : 

// There are two ways to create a frame : 
// by creating the object of frame class
// by extending frame class(inheritence)

*/
