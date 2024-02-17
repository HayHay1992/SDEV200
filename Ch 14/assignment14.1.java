public class assignment14.1 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane to hold the images views
		GridPane pane = new GridPane();

		// Place nodes in the pane
		pane.add(new ImageView(new Image("image/flag1.gif")), 0, 0);
		pane.add(new ImageView(new Image("image/flag2.gif")), 1, 0);
		pane.add(new ImageView(new Image("image/flag6.gif")), 0, 1);
		pane.add(new ImageView(new Image("image/flag7.gif")), 1, 1);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("assignment14.1"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	}
}
