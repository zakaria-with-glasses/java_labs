import java.util.ArrayList;
class Vehicle{

	protected String brand;
	protected String model;
	private double baseRate;

	public Vehicle(String _brand, String _model, double _baseRate){
		this.brand = _brand;
		this.model = _model;
		this.baseRate = _baseRate; 
	}

	public double calculateRentalCost(int days){
		if(days<= 0){
			System.out.println("Something is wrong! No negative days please!");
			return 0;
		}
		return this.baseRate*days;
	}

	public void displayInfo(){
		System.out.printf("Brand: %s\nModel: %s\nBase Rate: %.2f\n", this.brand, this.model, this.baseRate);
	}

}

class Car extends Vehicle{
	private boolean luxuryModel;

	public Car(String _brand, String _model, double _baseRate, boolean _luxuryModel){
		super(_brand, _model, _baseRate);
		this.luxuryModel = _luxuryModel;

	}

	@Override
	public double calculateRentalCost(int days){
		double cost = super.calculateRentalCost(days);
		if(this.luxuryModel){
			return cost*1.2d;
		}

		return cost;
	}

	public double calculateRentalCost(int days, boolean includeInsurance){
		if (includeInsurance){
			return this.calculateRentalCost(days) + 50;
		}
		return this.calculateRentalCost(days);
	}
}

class Motorbike extends Vehicle{
	private int engineCC;

	public Motorbike(String _brand, String _model, double _baseRate, int _engineCC){
		super(_brand, _model, _baseRate);
		this.engineCC = _engineCC;
	}

	@Override
	public double calculateRentalCost(int days){

		double cost = super.calculateRentalCost(days);
		if(engineCC > 500){
			return cost*1.1;
		}
		return cost;
	}

}

class Truck extends Vehicle{
	private double loadCapacity;

	public Truck(String _brand, String _model, double _baseRate, double _loadCapacity){
		super(_brand, _model, _baseRate);
		this.loadCapacity = _loadCapacity;

	}

	@Override
	public double calculateRentalCost(int days){
		double cost = super.calculateRentalCost(days);
		if(this.loadCapacity > 5){
			return cost*(1+ 0.05*(this.loadCapacity - 5));
		}
		return cost;
	}

}


class Main{
	public static void main(String[] args){
		// The examples are AI generated.
		// I don't know much about cars :(
		// ========= AI CODE ============
		Vehicle[] v = new Vehicle[6];

		v[0] = new Car("Renault", "Clio", 250.0, false);
		v[1] = new Car("Mercedes", "S-Class", 1200.0, true);
		v[2] = new Motorbike("Honda", "CB300R", 150.0, 300);
		v[3] = new Motorbike("Yamaha", "MT-07", 250.0, 689);
		v[4] = new Truck("Isuzu", "N-Series", 500.0, 4.0);
		v[5] = new Truck("Volvo", "FH", 900.0, 8.0);

		//======= END OF AI CODE =======
		
		for(Vehicle i : v){
			// poor naming of the variables. i should fix that.
			i.displayInfo();
			System.out.println("Rental Cost for 5 days: "+ i.calculateRentalCost(5));	
			System.out.println("");
		}

	}
}
