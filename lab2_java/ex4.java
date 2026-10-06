import java.util.ArrayList;
class Book{
	private String title;
	private String author;
	private boolean available = true;

	public Book(String _title, String _author){
		this.title = _title;
		this.author = _author;
	}
	public Book(String _title, String _author, boolean _available){
		this.title = _title;
		this.author = _author;
		this.available = _available;
	}

	public void setAvailable(boolean _available){
		this.available = _available;
	}
	public boolean getAvailable(){
		return this.available;
	}
	public String getTitle(){
		return this.title;
	}

	public void setTitle(String _title){
		this.title = _title;
	}

	public String getAuthor(){
		return this.author;
	}

	public void setAuthor(String _author){
		this.author = _author;
	}

	@Override
	public String toString(){
		return this.title + "( Written by: " + this.author + " )" + " - " + (this.available ? "Available" : "Borrowed");
	}

}	
class Library{
	private ArrayList<Book> books = new ArrayList<Book>();
	private Book _exists(String title){
		for(Book b : books){
			if(b.getTitle().equalsIgnoreCase(title)){
				return b;
			}
		}

		return null;
	}
	// overloaded for the case of same author and same book name.
	private Book _exists(String title, String author){
		for(Book b : books){
			if(b.getTitle().equalsIgnoreCase(title) && 
			   b.getAuthor().equalsIgnoreCase(author)){
				return b;
			}
		}

		return null;
	}
	boolean addBook(Book b){
		if(b == null) return false;
		// checking if exists uusing auxilary function
		if(this._exists(b.getTitle(), b.getAuthor()) != null){
			System.out.println("Book already exists.");
			return false;
		}
		books.add(b);
		return true;
	}
	void borrowBook(String title){
		Book exists = this._exists(title);
		if(exists == null){
			System.out.println("Book not found : "+title);
			return;
		}

		if(exists.getAvailable()){
			exists.setAvailable(false);
			System.out.println("Successfully borrowed : " + title);
			return;
		}
		System.out.println("Book already borrowed : " + title);
		return;
	}
	//TODO: add a way to return a book after being borrowed ie reverse borrowBook  
	void returnBook(String title){
		Book exists = this._exists(title);
		if(exists == null){
			System.out.println("Cannot Return a book that doesn't exits !");
			return;
		}
		if(exists.getAvailable()){
			System.out.println("Book is already available");
			return;
		}


		exists.setAvailable(true);
		System.out.println("Book successfully returned!");
	}

	//DONE : IMPLEMENTED A WAY TO PRINT BOOKS USING THE OVERRIDDEN toString()
	void listBooks(){
		for(Book b: books){
			System.out.println(b.toString());
		}
	}
	public static void main(String[] args){
		Library cityLibrary = new Library();

		Book b1 = new Book("1984", "George Orwell");
		Book b2 = new Book("The Alchemist", "Paulo Coelho");
		Book b3 = new Book("Dune", "Frank Herbert");

		cityLibrary.addBook(b1);
		cityLibrary.addBook(b2);
		cityLibrary.addBook(b3);

		System.out.println("Initial library:");
		cityLibrary.listBooks();

		System.out.println("\nBorrowing 1984:");
		cityLibrary.borrowBook("1984");

		System.out.println("\nLibrary after borrowing:");
		cityLibrary.listBooks();

		System.out.println("\nTrying to borrow 1984 again:");
		cityLibrary.borrowBook("1984");

		System.out.println("\nReturning 1984:");
		cityLibrary.returnBook("1984");

		System.out.println("\nLibrary after returning:");
		cityLibrary.listBooks();
	}
}
