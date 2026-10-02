import java.util.ArrayList
class Student{
	String name;
	ArrayList<int> grades;

	public Student(String _name, int[] grades){
		this.name = _name;
		for(int i=0;i<grades.length(); i++){
			this.grades.add(grades[i]);
		}
	}

	public double calculateAverage(){
		double result = 0;

		for(int i=0; i<this.grades.size(); i++){
			result += this.grades.get(i);
		}

		result /= this.grades.size();
		return result;
	}

	public boolean hasPassed(){
		double avg = this.calculateAverage();
		if(avg >= 10){
			return true;
		}
		
		return false;
	}

	public static void main(String[] args){
		St
	}


}
