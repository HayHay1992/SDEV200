public class circle
		extends GeoObject implements Comparable<Circle> {
	private double radius;

	public circle() {
	}

	public circle(double radius) {
		this.radius = radius;
	}

	public circle(double radius, 
		String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}

	/** radius */
	public double getRadius() {
		return radius;
	}

	/** Set new radius */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/** area */
	public double getArea() {
		return radius * radius * Math.PI;
	}

	/** diameter */
	public double getDiameter() {
		return 2 * radius;
	}

	/** perimeter */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	/** true if objects radii are same */
	public boolean equals(Object o) {
		return this.compareTo((circle)o) == 0;
	}

	/** compare to method */
	public int compareTo(circle o) {
		if (this.radius > o.radius)
			return 1;
		else if (this.radius < o.radius)
			return -1;
		else
			return 0;
	}

	public String toString() {
		return super.toString() + "\nDate created: " + getDateCreated() +
			"\nRadius: " + radius;
	}
}
