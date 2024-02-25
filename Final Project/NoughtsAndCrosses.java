import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class NoughtsAndCrosses implements ActionListener{

    // Create game frame of NoughtsAndCrosses AKA TicTacToe
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

        // Set frame size
        // Set frame colour

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.getContentPane().setBackground(new Colour(10,10,10));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Colour(26,25,25));
        textfield.setForeground(new Colour(245,242,242));
        textfield.setFont(new Font("Ink Free",Font.Bold,85));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("NoughtsAndCrosses");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,900,100);

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        

    }

    @Override
    public void actionPerformed(ActionEvent e){
        // TODO Auto-generated method

    }
