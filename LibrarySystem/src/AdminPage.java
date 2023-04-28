import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class AdminPage extends JFrame {

	private JPanel MainPanel;

// Run the Page
	public static void run() {
		try {
			AdminPage frame = new AdminPage();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


// Creates the Jframe
	public AdminPage() {
		setResizable(false);
		setTitle("Welcome!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(MainPanel);
		MainPanel.setLayout(null);
		
		JLabel Title = new JLabel("Welcome to NU Library System");
		Title.setFont(new Font("Tahoma", Font.BOLD, 17));
		Title.setBounds(71, 108, 292, 44);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		MainPanel.add(Title);
		
		JLabel BackButton = new JLabel("<");
		BackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login.main(null);
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BackButton.setBounds(10, 11, 26, 14);
		MainPanel.add(BackButton);
	}

}
