package StudentGrade;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;

public class StudentGrade {
	
	 /**
	   Prints the options menu and returns the letter that the user types does not check for invalid selection
	      @return the next token on the input stream
	   */
	public static String printMenuAndGetChoice() {
		System.out.println("********Student Grades Database Menu********");
		   System.out.println("(A)dd\n(R)emove\n(M)odify\n(P)rint\n(Q)uit\nEnter Letters Above to Access Those Functions:");

			Scanner sc = new Scanner(System.in);
		   return sc.nextLine();
		   }

	   /**
	      Prints the students and grades
	      @param gradeMap the map to print
	   */
	public static void printGrades(Map<Student, String> studentToGradeMap, Map<Integer, Student> idtostudent, HashSet<Student> h, FileWriter file) throws IOException {
		BufferedWriter br = new BufferedWriter(file);
		System.out.println("********Student Grades Database********");
		   for(Student a : studentToGradeMap.keySet()) {
			   System.out.println(a + ": Grade=" + studentToGradeMap.get(a) + " ID=" + a.getID());
			   br.write(a + ": Grade=" + studentToGradeMap.get(a) + " ID = " + a.ID + " Hash=" + a.hash);
		   }
		   file.close();
		System.out.println("***************************************");
	   }

	   /**
	   Modifies an entry based on user input.  Prints an error if an invalid student is modified
	      @param gradeMap the map to modify
	   */
	 public static void modifyStudent(Map<Student, String> studentToGradeMap, Map<Integer, Student> idToStudentMap, HashSet<Student> h, FileWriter file)  throws IOException
 {
		 for(int a : idToStudentMap.keySet()) {
			 System.out.println(idToStudentMap.get(a)  + "'s ID=" + a);
		 }
		   Scanner sc = new Scanner(System.in);
		   System.out.println("Please Enter the ID of The Student You Want To Modify");
		   int ID = Integer.parseInt(sc.nextLine());
		   if(!idToStudentMap.containsKey(ID)) {
			   System.err.println("ID: "+ ID + " does not exist in Map!");
		   }
		   else {
			   System.out.println("Please Enter Updated Grade");
			   String grade = sc.nextLine();
			   studentToGradeMap.put(idToStudentMap.get(ID), grade);
			   printGrades(studentToGradeMap, idToStudentMap, h, file);
		   }
	   }

	   /**
	      Removes a student from the map based on user input
	      @param gradeMap the map to remove the student from
	   */
	 public static void removeStudent(Map<Student, String> studentToGradeMap,
	     Map<Integer, Student> idToStudentMap, HashSet<Student> h, FileWriter file)  throws IOException
 {
		 for(int a : idToStudentMap.keySet()) {
			 System.out.println(idToStudentMap.get(a)  + "'s ID=" + a);
		 }
		   Scanner sc = new Scanner(System.in);
		   System.out.println("Please Enter ID of Student You Want To Remove");
		   int ID = Integer.parseInt(sc.nextLine());
		   if(!idToStudentMap.containsKey(ID)) {
			   System.err.println("ID: " + ID + " does not exist in Map!");
		   }
		   else {
			   System.out.println("Student Removed");
			   h.remove(idToStudentMap.get(ID));
			   studentToGradeMap.remove(idToStudentMap.get(ID));
			   idToStudentMap.remove(ID);
			   printGrades(studentToGradeMap, idToStudentMap, h, file);
		   }
	   }

	   /**
	      Adds a student based on user input.  Prints an error if a student
	      is added that already exists in the map.
	      @param gradeMap the map to add the student to
	   */
	 public static void addStudent(Map<Student, String> studentToGradeMap,
	         Map<Integer, Student> idToStudentMap, HashSet<Student> h, FileWriter file)
 {
		   Scanner sc = new Scanner(System.in);
		   System.out.println("Please Enter First Name of Student You Want To Add");
		   String firstname = sc.nextLine();
		   System.out.println("Please Enter Last Name of Student You Want To Add");
		   String lastname = sc.nextLine();
		   System.out.println("Please ID Name of Student You Want To Add");
		   int ID = Integer.parseInt(sc.nextLine());
		   while(idToStudentMap.containsKey(ID)) {
			   System.err.println("ID: " +ID+ " already exists, please enter a unique ID number:");
			   ID = Integer.parseInt(sc.nextLine());
		   }
		   Student a = new Student(firstname, lastname, ID);
		   idToStudentMap.put(ID, a);
		   //try h.contains(a)
		   if(!studentToGradeMap.containsKey(idToStudentMap.get(ID))) {
			   System.out.println("Please Enter "+ firstname +"'s grade");
			   String grade = sc.nextLine();
			   studentToGradeMap.put(idToStudentMap.get(ID), grade);
			   h.add(a);
			   a.setHash(a.hashCode());
			   try {
				printGrades(studentToGradeMap, idToStudentMap, h, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   else {
			   System.err.println("Student Already In Map");
		   }
	   }
	   //Extension 1 HashCode
	/* Supply compatible hashCode and equals methods to the Student class.
	 Test the hash code by adding Student objects to a hash set. */
	   //Extension 2 Database
	  /*Since a database is not very helpful if it must be re-entered every time,
determine a way that you could save the data on a hard drive, to retrieve and edit as needed.*/
	

}