package StudentGrade;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class StudentGradeTester {

	public static void main(String[] args)  throws IOException{
			Map<Student, String> studentToGradeMap = new TreeMap<Student, String>();
			Map<Integer, Student> itToStudentMap = new TreeMap<Integer, Student>();
			FileWriter file = new FileWriter(new File("H:\\workspace2021\\Maps\\src\\StudentGrade\\Database.txt"));
			HashSet<Student> hash = new HashSet<Student>();
			StudentGrade a = new StudentGrade();
			int hi = 0;
			while(hi!=1) {
			String op = a.printMenuAndGetChoice();
		
				if(op.equals("A"))
				{
				a.addStudent(studentToGradeMap,itToStudentMap, hash, file);
				}
				if(op.equals("R"))
				{
				a.removeStudent(studentToGradeMap, itToStudentMap, hash, file);
				}
				if(op.equals("M"))
				{
				a.modifyStudent(studentToGradeMap, itToStudentMap, hash, file);
				}
				if(op.equals("P"))
				{
				a.printGrades(studentToGradeMap, itToStudentMap, hash, file);
				}
				if(op.equals("Q"))
				{
				break;
				}
				
			}

	}
}
