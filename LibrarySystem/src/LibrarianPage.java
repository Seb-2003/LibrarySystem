import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Class for initializing certain book informations
class Books {
    String 	title, author;
    int 	year, copies;

    public Books(String title, String author, int year, int copies) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.copies = copies;
    }

// Action when renting
    public void rent() {
    	// If function for checking if copies is still available
        if (copies > 0) {
        	// Subtract the copies on a specific book
            copies--;
            JOptionPane.showMessageDialog(null, "You Rented " + title);
        } else {
            JOptionPane.showMessageDialog(null, "No Copies Available");
        }
    }
}

// JFrames Components
@SuppressWarnings("serial")
public class LibrarianPage extends JFrame {
    private JComboBox<String> List;
    private JButton RentButton;
    private Books[] books;
    private JLabel lblNewLabel;
    private JLabel BackButton;

    public LibrarianPage() {
        setResizable(false);
        setTitle("Rental System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(649, 230);
        setLocationRelativeTo(null);

        // Arrays of Books
        books = new Books[]{
                new Books("System Analysis and Design", "Gary B. Shelly", 1991, 2),
                new Books("Android Application", "Corinne Hoisington", 2012, 3),
                new Books("Programming Concepts and Logic Formulation", "Rosauro E. Manuel", 2016, 4)
        };

        JPanel MainPanel = new JPanel();
        setContentPane(MainPanel);

        List = new JComboBox<>();
        List.setFocusTraversalKeysEnabled(false);
        List.setBounds(45, 62, 543, 35);
// For Loop to add all books the arrays of books
        for (Books book : books) {
            List.addItem(book.title +" "+book.year + " by: " + book.author + " (Copies: " + book.copies + ")");
        }
        MainPanel.setLayout(null);
        MainPanel.add(List);

        RentButton = new JButton("Rent");
        RentButton.setBounds(255, 122, 122, 35);
        RentButton.addActionListener(new ActionListener() {
            @Override
// Action when ComboBox (list) is selected
            public void actionPerformed(ActionEvent e) {
            	// Get the selected index of the ComboBox to access the book array index
                int selectedIndex = List.getSelectedIndex();
                // Prevents ArrayIndexOutOfBoundsException error
                if (selectedIndex >= 0 && selectedIndex < books.length) {
                    int option = JOptionPane.showConfirmDialog(null, "Confirm renting the book?", "Rent Confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        Books selectedBook = books[selectedIndex];
                        // Run the method with the selected book index
                        selectedBook.rent();
                        // Update Book availability
                        List.removeItemAt(selectedIndex);
                        List.insertItemAt(selectedBook.title +" "+selectedBook.year + " by: " + selectedBook.author + " (Copies: " + selectedBook.copies + ")", selectedIndex);
                        List.setSelectedIndex(selectedIndex);
                    }
                }
            }
        });
        MainPanel.add(RentButton);
        
        lblNewLabel = new JLabel("Books:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(292, 26, 48, 14);
        MainPanel.add(lblNewLabel);
        
        BackButton = new JLabel("<");
        BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BackButton.addMouseListener(new MouseAdapter() {
        	@Override
// Action when back button is clicked
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        		Login.main(null);
        	}
        });
        BackButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        BackButton.setBounds(10, 11, 31, 17);
        MainPanel.add(BackButton);
    }
    
	public static void run() {
		try {
			LibrarianPage frame = new LibrarianPage();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
