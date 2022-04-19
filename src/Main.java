import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 19/04/2022, martedì
 * @topics : JMenu JList JTabbedPane JFrame
 **/

public class Main {
    public static void main(String[] args) {
        /**creazione Frame*/
        JFrame frame = new JFrame("TITOLO THREAD");
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /**creazione Panel con etichette*/
       JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,2));
        panel1.add(new JLabel("label 1"));
        panel1.add(new JLabel("label 2"));
        panel1.add(new JLabel("label 3"));
        panel1.add(new JLabel("label 4"));
        panel1.add(new JTextArea("sono una textarea"));

        /**creazione TabbedPane con etichette*/
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("tab1",new JLabel("SONO IL TAB 1"));
        tabbedPane.addTab("tab2",new JLabel("SONO IL TAB 2"));
        tabbedPane.addTab("tab3",new JLabel("SONO IL TAB 3"));

        JTabbedPane tabbedPane2 = new JTabbedPane();
        tabbedPane2.addTab("tab1",new JLabel("SONO IL TAB 1 di tp2"));
        tabbedPane2.addTab("tab2",new JLabel("SONO IL TAB 2 di tp2"));
        tabbedPane2.addTab("tab3",new JLabel("SONO IL TAB 3 di tp2"));

        /**creazione Menu*/
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("MENU");
        JMenuItem item1 = new JMenuItem("ITEM 1");
        JMenuItem item2 = new JMenuItem("ITEM 2");

        ActionListener cambiaPane = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(((JMenuItem)e.getSource()).getText().equalsIgnoreCase("ITEM 1")){
                    tabbedPane.setVisible(true);
                    tabbedPane2.setVisible(false);
                }
                else{
                    tabbedPane.setVisible(false);
                    tabbedPane2.setVisible(true);
                }
            }
        };

        item1.addActionListener(cambiaPane);
        item2.addActionListener(cambiaPane);
        menu.add(item1);
        menu.add(item2);
        bar.add(menu);

        /**creazione List*/
        String[] str = {"a","b","c"};
        JList list = new JList(str);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(e.getSource());
            }
        });

        JPanel body = new JPanel();
        //body.add(tabbedPane);
        //body.add(tabbedPane2);
        tabbedPane.setVisible(false);
        tabbedPane2.setVisible(false);

        /**creazione Button*/
        JButton btn1 = new JButton("BTN1");
        JRadioButton btn2 = new JRadioButton("BTN 2");
        JRadioButton btn4 = new JRadioButton("BTN 4");
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(btn2);
        btnGroup.add(btn4);
        JCheckBox btn3 = new JCheckBox("BTN");
        body.add(btn1);
        body.add(btn3);
        body.add(btn2);
        body.add(btn4);

        frame.setJMenuBar(bar);
        frame.getContentPane().add(BorderLayout.CENTER,body);
    }
}
