package StudentGrade;

public class Student implements Comparable{
	String first;
	String last;
	int ID;
	int hash;
	public Student(String first, String last, int ID) {
		this.first = first;
		this.last = last;
		this.ID = ID;
	}
	public String getFirst() {
		return first;
	}
	public String getLast() {
		return last;
	}
	public int getID() {
		return ID;
	}
	public String toString() {
		return first + " " + last;
	}
	public void setHash(int hash) {
		this.hash = hash;
	}
	@Override
	public boolean equals(Object o) {
		return(this.hash == ((Student)o).hash);
	}
	@Override
	public int compareTo(Object o) {
		if(this.last.compareTo(((Student)o).getLast()) > 0){
			return 1;
		}
		else if(this.last.compareTo(((Student)o).getLast()) < 0){
			return -1;
		}
		else if(this.first.compareTo(((Student)o).getFirst()) > 0) {
			return 1;
		}
		else if(this.first.compareTo(((Student)o).getFirst()) < 0) {
			return -1;
		}
		else if(this.ID > ((Student)o).getID()) {
			return 1;
		}
		else if(this.ID < ((Student)o).getID()) {
			return -1;
		}
		else 
			return 0;
	}
}

