public class assignment04_ch9_9UML {
	/** data field */
	private int n;
	private double side;
	private double x;
	private double y;

	/** creates regular polygon with default values */
	RegularPolygon() {
		n = 3;
		side = 1;
		x = y = 0;
	}

	/** creates regular polygon with specified number centered at (0,0) */
	RegularPolygon(int newNum, double newSide) {
		n = newNum;
		side = newSide;
		x = y = 0;
	}

	/** creates regular polygon with specified number and x and y coordinates */
	RegularPolygon(int newNum, double newSide, double newX, double newY) {
		n = newNum;
		side = newSide;
		x = newX;
		y = newY;
	}

	/** methods */
	/** new num */
	public void setNum(int newNum) {
		num = newNum;
	}

	/** new length of side */
	public void setSide(double newSide) {
		side = newSide;
	}

	/** new x coordinate */
	public void setX(double newX) {
		x = newX;
	}

	/** new y coordinate */
	public void setY(double newY) {
		y = newY;
	}

	/** returns num */
	public int getNum() {
		return num;
	}

	/** returns length of side */
	public double getSide() {
		return side;
	}

	/** returns x coordinate */
	public double getX() {
		return x;
	}

	/** returns y coordinate */
	public double getY() {
		return y;
	}

	/** returns perimeter of polygon */
	public double getPerimeter() {
		return side * num;
	}

	/** returns area of polygon */
	public double getArea() {
		return (num * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / num));
	}
}
