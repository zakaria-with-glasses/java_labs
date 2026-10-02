class Pet{
	String name;
	String species;
	int age;

	public Pet(String _name, String _species, int _age){
		name = _name;
		species = _species;
		age = _age;
	}

	public void introduce(){
		System.out.printf("This is %s, and he is %d years old. he is a %s\n", name, age, species);
	}
}

class Main{
	public static void main(String[] args){
		Pet garfield = new Pet("Garfield", "cat", 1000);
		Pet ratatouille = new Pet("Ratatouille", "mouse", 1);

		garfield.introduce();
		ratatouille.introduce();
	}
}

