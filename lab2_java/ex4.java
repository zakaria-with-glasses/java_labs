import java.util.ArrayList;
class Book{
	private String title;
	private String author;
	private boolean avaliable = true;

	public Book(String _title, String _author){
		this.title = _title;
		this.author = _author;
	}
	public Book(String _title, String _author, boolean _avaliable){
		this.title = _title;
		this.author = _author;
		this.avaliable = _avaliable;
	}

	public void setAvaliable(boolean _avaliable){
		this.avaliable = _avaliable;
	}
	public boolean getAvaliable(){
		return this.avaliable;
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
		return this.title + "( Written by: " + this.author + " )" ;
	}

}	
public class Library{
	ArrayList<Book> books = new ArrayList<Book>();
	private Book _exists(String title){
		for(Book b : books){
			if(b.getTitle().equalsIgnoreCase(title)){
				return b;
			}
		}

		return null;
	}
	boolean addBooks(Book b){
		if(b == null) return false;
		// checking if exists uusing auxilary function
		if(this._exists(b.getTitle()) != null){
			return false;
		}
		books.add(b);
		return true;
	}
	boolean borrowBook(String title){
		Book exists = this._exists(title);
		if(exists == null){
			return false;
		}

		if(exists.getAvaliable()){
			exists.setAvaliable(false);
			return true;
		}
		return false;
	}
	//TODO: add a way to return a book after being borrowed ie reverse borrowBook  
	void returnBook(String title){
		Book exists = this._exists(title);
		if(exists == null){
			System.out.println("Cannot Return a book that doesn't exits !");
		}
		if(exists.getAvaliable()){
			System.out.println("Book is already avaliable");
			return;
		}

		exists.setAvaliable(true);

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

		cityLibrary.addBooks(b1);
		cityLibrary.addBooks(b2);
		cityLibrary.addBooks(b3);

		cityLibrary.listBooks();

		cityLibrary.borrowBook("1984");
		cityLibrary.listBooks();

		cityLibrary.borrowBook("1984");

		cityLibrary.returnBook("1984");
		cityLibrary.listBooks();
	}
}
