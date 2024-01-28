public class assignment9_9 {
	/** Main method */
  
	public static void main(String[] args) {
		// create three RegularPolygons

		RegularPolygon regularPolygon1 = new RegularPolygon();
		RegularPolygon regularPolygon2 = new RegularPolygon(6, 4);
		RegularPolygon regularPolygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

		// display perimeter and area

		System.out.println("\n--------------------------------------------------");
		System.out.println("- Regular Polygons -  Perimeter  -  Area  -");
		System.out.println("--------------------------------------------------");
		System.out.printf( "-       Polygon# 1        -  %8.2f    -  %6.2f -  \n", 
			regularPolygon1.getPerimeter(), regularPolygon1.getArea());
		System.out.printf( "-       Polygon# 2        -  %8.2f    -  %6.2f -  \n", 
			regularPolygon2.getPerimeter(), regularPolygon2.getArea());
		System.out.printf( "-       Polygon# 3        -  %8.2f    -  %6.2f -  \n", 
			regularPolygon3.getPerimeter(), regularPolygon3.getArea());
		System.out.println("--------------------------------------------------");
	}
}
