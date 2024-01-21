public class assignment_8_29 {
  /** Main Method */
public static void main(String[] args) {
  // prompt user to enter arrays
  System.out.print("Enter list1: ");
  int[][] list1 = getArray();
  System.out.print("Enter list2: ");
  int[][] list2 = getArray();
}

/** getArray initializes 3 x 3 array with input */
public static int[][] getArray() {
  final int Rows = 3;
  final int columns = 3;
  int[][] l = new int[Rows][Columns];
  for int o = 0; 0 < l.length; 0++) {
    for (int t = 0; t < l[o].length; t++) {
      l[o][t] = input.nextINT();
    }
  }
 return l;
}
