package org.example.xonoughtsandcrossesfx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

class XONoughtsANDCrossesFX extends Application {
    // Player turns
    private char whoseTurn = 'X';

    // Create board
    private final Cell[][] cell =  new Cell[3][3];

    // Create players
    private final Label lblStatus = new Label("X's turn");

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                pane.add(cell[i][j] = new Cell(), j, i);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(lblStatus);

        // Create board scene
        Scene scene = new Scene(borderPane, 450, 450);
        primaryStage.setTitle("NoughtsANDCrosses"); // Set title
        primaryStage.setScene(scene);
        primaryStage.show(); // Display
    }

    /** Determine if all squares are occupied */
    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (cell[i][j].getToken() == ' ')
                    return false;

        return true;
    }

    /** Determine which player wins */
    public boolean isWon(char token) {
        for (int i = 0; i < 3; i++)
            if (cell[i][0].getToken() == token
                    && cell[i][1].getToken() == token
                    && cell[i][2].getToken() == token) {
                return true;
            }

        for (int j = 0; j < 3; j++)
            if (cell[0][j].getToken() ==  token
                    && cell[1][j].getToken() == token
                    && cell[2][j].getToken() == token) {
                return true;
            }

        if (cell[0][0].getToken() == token
                && cell[1][1].getToken() == token
                && cell[2][2].getToken() == token) {
            return true;
        }

        return cell[0][2].getToken() == token
                && cell[1][1].getToken() == token
                && cell[2][0].getToken() == token;
    }

    public class Cell extends Pane {
        // Token used for cell
        private char token = ' ';

        public Cell() {
            setStyle("-fx-border-color: #131313");
            this.setPrefSize(900, 900);
            this.setOnMouseClicked(e -> handleMouseClick());
        }

        /** Return token */
        public char getToken() {
            return token;
        }

        /** Set new token */
        public void setToken(char c) {
            token = c;

            if (token == 'X') {
                Line line1 = new Line(10, 10,
                        this.getWidth() - 10, this.getHeight() - 10);
                line1.endXProperty().bind(this.widthProperty().subtract(10));
                line1.endYProperty().bind(this.heightProperty().subtract(10));
                Line line2 = new Line(10, this.getHeight() - 10,
                        this.getWidth() - 10, 10);
                line2.startYProperty().bind(
                        this.heightProperty().subtract(10));
                line2.endXProperty().bind(this.widthProperty().subtract(10));
                line1.setStroke(Color.PURPLE);
                line2.setStroke(Color.PURPLE);

                // Add lines to the pane
                this.getChildren().addAll(line1, line2);
            }
            else if (token == 'O') {
                Ellipse ellipse = new Ellipse(this.getWidth() / 2,
                        this.getHeight() / 2, this.getWidth() / 2 - 10,
                        this.getHeight() / 2 - 10);
                ellipse.centerXProperty().bind(
                        this.widthProperty().divide(2));
                ellipse.centerYProperty().bind(
                        this.heightProperty().divide(2));
                ellipse.radiusXProperty().bind(
                        this.widthProperty().divide(2).subtract(10));
                ellipse.radiusYProperty().bind(
                        this.heightProperty().divide(2).subtract(10));
                ellipse.setStroke(Color.CORNFLOWERBLUE);
                ellipse.setFill(Color.CORNFLOWERBLUE);
                getChildren().add(ellipse);
            }
        }

        /* mouse click event */
        private void handleMouseClick() {
            // If cell is empty and game is not over
            if (token == ' ' && whoseTurn != ' ') {
                setToken(whoseTurn); // Set token in the cell

                // Check game status
                if (isWon(whoseTurn)) {
                    lblStatus.setText(whoseTurn + " won! Game Over");
                    whoseTurn = ' '; // Game over
                }
                else if (isFull()) {
                    lblStatus.setText("Draw! Game Over");
                    whoseTurn = ' '; // Game over
                }
                else {
                    // Change the turn
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    // Display whose turn
                    lblStatus.setText(whoseTurn + "'s turn");
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
