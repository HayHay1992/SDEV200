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
        textfield.setText("NoughtsAndCrosses")
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,900,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Colour(240,237,237));

        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Comic Sans MS",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }
        
        

        title_panel.add(textfield);
        frame.add(title_panel),BorderLayout.NORTH);
        frame.add(button_panel);
            

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // TODO Auto-generated method

    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if(random.nextInt(2)==0) {
            player1_turn=true;
            textfield.setText("X turn");
        }
        else {
            player1_turn=false;
            textfield.setText("O turn");

    }

    public void check() {

    }
