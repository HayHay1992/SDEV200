import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class NoughtsAndCrosses implements ActionListener{

    // Create game frame of NoughtsAndCrosses AKA XO
    // Include two players

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    boolean player2_turn;

    NoughtsAndCrosses(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        // TODO Auto-generated method

    }
