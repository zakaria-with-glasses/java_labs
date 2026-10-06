import java.util.ArrayList;
class Product{
	String name; 
	double price;
	public static Product getInstance(String _name, double _price){

		if(_name == null || _name.isEmpty() || _price < 0){
			return null;	
		}

		return new Product(_name, _price);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product(String _name, double _price){
		this.name = _name;
		this.price = _price;
	}


	@Override
	public String toString(){
		return "Product: "+ this.name + " Price: "+ this.price + "\n";
	}
}

class CartItem{
	Product p;
	int quantity;

	public static CartItem getInstance(Product _p, int _quantity){

		if(_p == null || _quantity < 1){
			return null; 

		}

		return new CartItem(_p, _quantity);
	}

	public CartItem(Product _p, int _quantity){
		this.p = _p;
		this.quantity = _quantity;
	}

	public Product getProduct() {
		return this.p;
	}

	public void setProduct(Product p) {
		this.p = p;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	double lineTotal(){
		return this.getProduct().getPrice()*this.getQuantity();
	}

}


class Cart{
	ArrayList<CartItem> cart_items = new ArrayList<CartItem>();
	double discount = 0d; // i added this because there has been no mension of the discount variable in the lab.
			      // missing signature
	private CartItem _exists(String lookup_name){
		if(lookup_name == null) return null;

		for(CartItem c : cart_items){
			if(c.getProduct().getName().equalsIgnoreCase(lookup_name)){
				// found out product CartItem, here we return it;
				return c;
			}
		}

		return null;
	}

	public void addItem(Product p, int qty){
		if(p == null || qty <= 0){
			System.out.println("Invalid Product or quantity.");
			return;
		}
		CartItem cI = this._exists(p.getName());
		// once cI is not null we should add it, if not we should increase it's quantity.

		if (cI == null){
			// element not found meaning we should create one.
			CartItem newCI = CartItem.getInstance(p, qty);

			if(newCI == null){
				System.out.println("Couldn't create a new cartItem...");
				return;
			}

			// the object has been created, it should be added to the cart_items list

			cart_items.add(newCI);
			return;
		}

		cI.setQuantity(cI.getQuantity() + qty);
		// once the product quantity is updated, nothing else to do.

		return;
	}

	public void updateQuantity(String productName, int newQty){
		CartItem cI = this._exists(productName);
		if(cI == null){
			System.out.println("Product Not found.");
			return;
		}
		if(newQty <= 0){
			//TODO: remove from cart
			cart_items.remove(cI);
			return;
		}

		cI.setQuantity(newQty);
	}

	public void removeItem(String productName){
		CartItem cI = this._exists(productName);

		if (cI == null){
			System.out.println("Couldn't find a Product by this name.");
			return;
		}

		cart_items.remove(cI);
		return;
	}

	public void listItems(){
		for(CartItem cI : cart_items){
			System.out.printf(
					"%s x %d -> %.2f\n",
					cI.getProduct().getName(),
					cI.getQuantity(),
					cI.lineTotal()		
					);
		}
	}

	public double getSubtotal(){
		double subtotal = 0d;

		for(CartItem cI : cart_items){
			subtotal += cI.lineTotal();
		}

		return subtotal;
	}

	public double applyDiscount(double threshold, double percent){
		// the main issue here is that we should add another discount variable in the cart.
		// looks logican enough.

		double subtotal = this.getSubtotal();
		if(subtotal >= threshold){
			this.discount =  subtotal * (percent/100);		
		}else{
			this.discount = 0;
		}

		return this.discount;
	}

	public double getTotal(){

		double subtotal = this.getSubtotal(); // can be optimized since we get the subtotal value twice in this call
						      // once in the subTotal and once in the applyDiscount

		return subtotal - this.discount;
	}



	public static void main(String[] args){

		Product keyboard = Product.getInstance("Keyboard", 199);
		Product mouse = Product.getInstance("Mouse", 79);
		Product headset = Product.getInstance("Headset", 250);

		Cart cart = new Cart();

		cart.addItem(keyboard, 1);
		cart.addItem(mouse, 2);
		cart.addItem(headset, 1);

		System.out.println("Cart:");
		cart.listItems();

		System.out.printf("Subtotal: %.2f\n", cart.getSubtotal());

		double discount = cart.applyDiscount(500, 10);

		System.out.printf("Discount: %.2f\n", discount);
		System.out.printf("Total: %.2f\n", cart.getTotal());

		System.out.println("\nAfter updating Mouse:");
		cart.updateQuantity("Mouse", 3);

		cart.listItems();
		System.out.printf("Subtotal: %.2f\n", cart.getSubtotal());

		discount = cart.applyDiscount(500, 10);

		System.out.printf("Discount: %.2f\n", discount);
		System.out.printf("Total: %.2f\n", cart.getTotal());

		System.out.println("\nAfter removing Keyboard:");
		cart.removeItem("Keyboard");

		cart.listItems();

		discount = cart.applyDiscount(500, 10);

		System.out.printf("Subtotal: %.2f\n", cart.getSubtotal());
		System.out.printf("Discount: %.2f\n", discount);
		System.out.printf("Total: %.2f\n", cart.getTotal());

		System.out.println("\nInvalid operations:");

		cart.addItem(mouse, 0);
		cart.updateQuantity("Mouse", -3);
		cart.updateQuantity("Laptop", 2);
		cart.removeItem("Laptop");
	}

}
