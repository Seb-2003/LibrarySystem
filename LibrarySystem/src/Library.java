import java.util.ArrayList;

public class Library {
	private ArrayList<String> Book;
    private ArrayList<String> Author;
    private ArrayList<Integer> Year;
    private ArrayList<Integer> Copies;
    
    public Library() {
    	Book = new ArrayList<String>();
    	Author = new ArrayList<String>();
    	Year = new ArrayList<Integer>();
    	Copies = new ArrayList<Integer>();
    	
    	// Book 1
    	Book.add("System Analysis and Design");
    	Author.add("Gary B. Shelly");
    	Year.add(1991);
    	Copies.add(2);
    	// Book 2
    	Book.add("Android Application");
    	Author.add("Corinne Hoisington");
    	Year.add(2012);
    	Copies.add(3);
    	// Book 3
    	Book.add("Programming Concepts and Logic Formulation");
    	Author.add("Rosauro E. Manuel");
    	Year.add(2016);
    	Copies.add(4);
    	
    }
    public ArrayList<String> getBook() {
        return Book;
    }

    public ArrayList<String> getAuthor() {
        return Author;
    }
    
    public ArrayList<Integer> getYear() {
        return Year;
    }

    public ArrayList<Integer> getCopies() {
        return Copies;
    }
}
