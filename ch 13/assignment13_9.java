public class assignment13_9 {
	/** main method */
	public static void main(String[] args) {
		// create three circle objects
		circle circle1 = new circle(5, "red", true);
		circle circle2 = new circle(5, "blue", false);
		circle circle3 = new circle(4, "blue", false);

		// display results
		System.out.println("circle1 radius: " + circle1.getRadius());
		System.out.println("circle2 radius: " + circle2.getRadius());
		System.out.println("circle3 radius: " + circle3.getRadius());

		System.out.println("circle1 is " + (circle1.equals(circle2) ? "" : "not ") +
			"equal to circle2");

		System.out.println("circle1 is " + (circle1.equals(circle3) ? "" : "not ") +
			"equal to circle3");
	}
}
