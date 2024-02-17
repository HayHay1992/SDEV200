public class assignment15_7 extends Application {
	@Override // Override start method in Application class
	public void start(Stage primaryStage) {
		// Create stack pane
		StackPane pane = new StackPane();

		// Create circle and set its properties
		Circle circle = new Circle(50);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		pane.getChildren().add(circle);

		// Create and register the handler
		pane.setOnMousePressed(e -> {
			circle.setFill(Color.BLACK);
		});

		pane.setOnMouseReleased(e -> {
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
		});

		// Create scene and place it in stage
		Scene scene = new Scene(pane, 120, 120);
		primaryStage.setTitle("assignment15_7"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}
}
