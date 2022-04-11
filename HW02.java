/*
  CS 231 Data Structures and Algorithms
  Homework #2
  Spring 2022

  Answer the questions below the code, one of which involves filling
  in code.  Be sure to test your answer.
 */
import java.util.ArrayList;

public class HW02 {
    int rows, cols;
    int[] a;
    int[][] b;
    ArrayList<Integer> c;
    ArrayList<ArrayList<Integer>> d;

    // constructor
    public HW02(int rows, int cols) {
	// mark 1
	this.rows = rows;
	this.cols = cols;

	// case 1
	a = new int[rows * cols];

	// case 2
	b = new int[rows][];

	for(int i=0;i<rows;i++) {
	    b[i] = new int[cols];
	}

	// case 3
	c = new ArrayList<Integer>(rows * cols);
	for(int i=0;i<rows*cols;i++) {
	    c.add(0);
	}

	// case 4
	d = new ArrayList<ArrayList<Integer>>(rows);
	for(int i=0;i<rows;i++) {
	    d.add( new ArrayList<Integer>(cols) );
	    for(int j=0;j<cols;j++) {
		d.get(i).add(0);
	    }
	}
    }

    // sets row r, column c to value
    public void set(int r, int c, int value) {

	// set the appropriate entry in field a

	// set the appropriate entry in field b

	// set the appropriate entry in field c

	// set the appropriate entry in field d


    }

    public static void main(String[] argv) {
	int rows = 2;
	int cols = 3;
				
	HW02 h = new HW02(rows, cols);

	int r = 1;
	int c = 2;

	h.a[r*cols + c] = 4;
	h.b[r][c] = 5;
	h.c.set(r*cols + c, 6);
	h.d.get(r).set(c, 7);

	// uncomment this line to test the set method
	h.set(0, 1, 15);

	System.out.println("a:");
	for(int i=0;i<rows;i++) {
	    for(int j=0;j<cols;j++) {
		System.out.print(h.a[i*cols+j] + " ");
	    }
	    System.out.println("");
	}

	System.out.println("b:");
	for(int i=0;i<rows;i++) {
	    for(int j=0;j<cols;j++) {
		System.out.print(h.b[i][j] + " ");
	    }
	    System.out.println("");
	}

	System.out.println("c:");
	for(int i=0;i<rows;i++) {
	    for(int j=0;j<cols;j++) {
		System.out.print(h.c.get(i*cols+j) + " ");
	    }
	    System.out.println("");
	}

	System.out.println("d:");
	for(int i=0;i<rows;i++) {
	    for(int j=0;j<cols;j++) {
		System.out.print(h.d.get(i).get(j) + " ");
	    }
	    System.out.println("");
	}

    }
}

/*
  HW 2 Questions

  1) In the constructor, is the "this." necessary in front of rows and cols?
  - Yes it's necessary as it's stating that the parameters passed in the constructor equates to the fields passed before the constructor method.

  2) For each of the 2D data organizations (fields a, b, c, d), draw a
  pictures of what memory looks like after the constructor is
  finished.  (Feel free to write this out on paper and take a picture).

    Rows = 2 Columns = 3
  a = [int,int,int,int,int,int] - since int for a = [6] there's 6 elements inside the Array

  with the respective numbers a would look like = [0,0,0,0,0,4]


  B = [int,int]
	  [int,int]
	  [int, int]	

  c= [[0,0,0,0,0,0,]]

  d = 


  3) Write the four statements that will complete the set method.
  Test it out and make sure it works.

  4) Do the rows and cols variables in the main method shadow the rows and cols fields of a HW02 object?

*/
