package iu4.smurigin.sea_war.game_classes.swing;

import ru.ivansmurygin.javabase.lesson7.ver1.game_classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{

    public JFrame frame = new JFrame();

    private JPanel panelForActions = new JPanel();
    private JPanel panelForFieldsIdentifying = new JPanel();

    public Label labelOfPlayer = new Label();
    public Label labelOfComputer = new Label();
    public Label labelForPlayerTurns = new Label();
    public Label labelForComputerTurns = new Label();

    public JLabel labelComputerField = new JLabel("The field of computer", JLabel.CENTER);
    public JLabel labelPlayerField = new JLabel("The field of player",  JLabel.CENTER);

    public JMenuBar menuBar = new JMenuBar();

    public Field playerField;
    public Field computerField;

    private GraphicField playerGraphicField;
    private GraphicField computerGraphicField;

    public Gui(){

        playerGraphicField = new GraphicField(true, this);
        computerGraphicField = new GraphicField(false, this);

        frame.setTitle("Sea Battle, Swing version 1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(GraphicField.WIDTH * 2+30, GraphicField.HEIGHT + 100);
        frame.setLayout(new BorderLayout());

        playerGraphicField.setPreferredSize(new Dimension(330,300));
        computerGraphicField.setPreferredSize(new Dimension(330,300));

        frame.add(playerGraphicField, BorderLayout.CENTER);
        frame.add(computerGraphicField, BorderLayout.EAST);

        createMenu(frame);

        labelPlayerField.setFont(new Font("Serif", Font.BOLD, 18));
        labelComputerField.setFont(new Font("Serif", Font.BOLD, 18));

        labelPlayerField.setPreferredSize(new Dimension(360,20));
        labelComputerField.setPreferredSize(new Dimension(300,20));

        labelOfComputer.setPreferredSize(new Dimension(280,20));
        labelForComputerTurns.setPreferredSize(new Dimension(50,20));
        labelOfPlayer.setPreferredSize(new Dimension(300,20));
        labelForPlayerTurns.setPreferredSize(new Dimension(50,20));

        panelForFieldsIdentifying.add(labelPlayerField);
        panelForFieldsIdentifying.add(labelComputerField);
        frame.add(panelForFieldsIdentifying, BorderLayout.NORTH);

        panelForActions.add(labelForComputerTurns);
        panelForActions.add(labelOfComputer);
        panelForActions.add(labelForPlayerTurns);
        panelForActions.add(labelOfPlayer);


        frame.add(panelForActions, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        drawGameField();
    }

    public void drawGameField() {

        playerField = new Field("Ivan Smurygin");
        playerField.createFieldRandShips();

        computerField = new Field("Computer");
        computerField.createFieldRandShips();

        playerGraphicField.setField(playerField);
        computerGraphicField.setField(computerField);

        playerGraphicField.clearField();
        computerGraphicField.clearField();

        playerGraphicField.printField();
        computerGraphicField.printField();

        playerGraphicField.setComputerTerns(0);
        computerGraphicField.setPlayerTerns(0);
    }

    public Field getPlayerField() {
        return playerField;
    }

    public void setPlayerField(Field playerField) {
        this.playerField = playerField;
    }

    public GraphicField getPlayerGraphicField() {
        return playerGraphicField;
    }

    public void createMenu(JFrame frame){
        JMenu menuFile = new JMenu("File");
            JMenuItem regenerate = new JMenuItem("Regenerate Fields");
            JMenuItem exit = new JMenuItem("Exit");

        JMenu menuInfo = new JMenu("Info");
            JMenuItem about = new JMenuItem("About");
            JMenuItem help = new JMenuItem("Help");

        menuBar.add(menuFile);
        regenerate.addActionListener(new MenuRegenerateListener());
        menuFile.add(regenerate);
        exit.addActionListener(new MenuExitListener());
        menuFile.add(exit);

        menuBar.add(menuInfo);
        about.addActionListener(new MenuAboutListener());
        menuInfo.add(about);
        help.addActionListener(new MenuHelpListener());
        menuInfo.add(help);

        menuBar.add(Box.createHorizontalGlue());



        frame.setJMenuBar(menuBar);
    }

    class MenuRegenerateListener implements ActionListener {
         public void actionPerformed(ActionEvent event) {
             labelOfComputer.setText("Your field was regenerated");
             labelOfPlayer.setText("The field of Computer was regenerated");
             drawGameField();
         }
    }

    class MenuExitListener implements ActionListener {
         public void actionPerformed(ActionEvent event) {
             frame.dispose();
         }
    }

    class MenuAboutListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(frame, "Game:Sea Battle.  Version 1.0\n" +
                                                 "   Author - Smurygin Ivan");
        }
    }

    class MenuHelpListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(frame, "To hit ships try to shoot to them \n" +
                                                 "       with left mouse click");
        }
    }

}
