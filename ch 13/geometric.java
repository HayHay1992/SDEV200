public abstract class geometric {
	private String color = "while";
	private boolean filled;
	private java.util.Date dateCreated;

	/** construct default geometric object */
	protected GeoObject() {
		dateCreated = new java.util.Date();
	}

	/** construct geometric object with color and fill value */
	protected GeoObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	/** color */
	public String getColor() {
		return color;
	}

	/** set new color */
	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/** get date created */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color +
			" and filled: " + filled;
	}

	/** get area */
	public abstract double getArea();

	/** get perimeter */
	public abstract double getPerimeter();

}
