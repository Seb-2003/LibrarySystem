import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class Login extends JFrame {
	String loginType;
	boolean userVerified;
	boolean passVerified;
	int x;

	private JPanel MainPanel;
	private JTextField LoginInput_UserField;
	private JPasswordField LoginInput_PassField;
	
	Accounts account = new Accounts();
	ArrayList<String> librarianUser = account.getlibrarianUser();
	ArrayList<String> librarianPass = account.getlibrarianPass();
	ArrayList<String> adminUser = account.getadminUser();
	ArrayList<String> adminPass = account.getadminPass();
	
// Method for opening the next Frame depending what login type was used
	public void nextFrame() {
		dispose();
		if ("admin".equals(loginType)) {
			AdminPage.run();
		} else {
			LibrarianPage.run();
		}
	}
	
// Creates the Jframe
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 339);
		setLocationRelativeTo(null);
		MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(MainPanel);
		MainPanel.setLayout(null);
		
		JTabbedPane Tabs = new JTabbedPane(JTabbedPane.TOP);
		Tabs.setBounds(-16, -40, 557, 354);
		MainPanel.add(Tabs);
		
		JPanel Panel_LoginTypes = new JPanel();
		Tabs.addTab("New tab", null, Panel_LoginTypes, null);
		Panel_LoginTypes.setLayout(null);
		
		JLabel LoginTypes_Title = new JLabel("Library Management - JavaTpoint");
		LoginTypes_Title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LoginTypes_Title.setBounds(154, 46, 244, 43);
		Panel_LoginTypes.add(LoginTypes_Title);
		
		JButton LoginTypes_AdminButton = new JButton("Admin Login");
		LoginTypes_AdminButton.setFocusable(false);
		LoginTypes_AdminButton.setBounds(202, 134, 148, 36);
		Panel_LoginTypes.add(LoginTypes_AdminButton);
		
		JButton LoginTypes_LibrarianButton = new JButton("Librarian Login");
		LoginTypes_LibrarianButton.setFocusable(false);
		LoginTypes_LibrarianButton.setBounds(202, 196, 148, 36);
		Panel_LoginTypes.add(LoginTypes_LibrarianButton);
		
		JPanel Panel_LoginInput = new JPanel();
		Tabs.addTab("New tab", null, Panel_LoginInput, null);
		Panel_LoginInput.setLayout(null);
		
		JLabel LoginInput_Title = new JLabel("Admin");
		LoginInput_Title.setFont(new Font("Calibri", Font.BOLD, 20));
		LoginInput_Title.setHorizontalAlignment(SwingConstants.CENTER);
		LoginInput_Title.setBounds(10, 43, 532, 45);
		Panel_LoginInput.add(LoginInput_Title);
		
		LoginInput_UserField = new JTextField();
		LoginInput_UserField.setBounds(167, 126, 228, 30);
		Panel_LoginInput.add(LoginInput_UserField);
		LoginInput_UserField.setColumns(10);
		
		JLabel LoginInput_UserTitle = new JLabel("Username:");
		LoginInput_UserTitle.setBounds(94, 134, 80, 14);
		Panel_LoginInput.add(LoginInput_UserTitle);
		
		JLabel LoginInput_PassTitle = new JLabel("Password:");
		LoginInput_PassTitle.setBounds(94, 186, 80, 14);
		Panel_LoginInput.add(LoginInput_PassTitle);
		
		LoginInput_PassField = new JPasswordField();
		LoginInput_PassField.setBounds(167, 178, 228, 30);
		Panel_LoginInput.add(LoginInput_PassField);
		
		JLabel LoginInput_BackButton = new JLabel("<");
		LoginInput_BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LoginInput_BackButton.setForeground(new Color(51, 51, 51));
		LoginInput_BackButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		LoginInput_BackButton.setBounds(24, 11, 19, 14);
		Panel_LoginInput.add(LoginInput_BackButton);
		
		JButton LoginInput_LoginButton = new JButton("Login");
		LoginInput_LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
// Action when Login Button was pressed
				boolean userVerified = false;
				boolean passVerified = false;
				int x;
				
				// If Functions for what type of login was chosen (Librarian or Administer)
				if ("librarian".equals(loginType)) {
					// For loop to loop all username and password arrays
				    for (x = 0; x < librarianUser.size(); x++) {
				    	// When a Username is matched to the input, a userVerified will be set to true
					        if (librarianUser.get(x).equals(LoginInput_UserField.getText().trim())) {
					            userVerified = true;
					        }
					    // When a Password is matched to the input, a passVerified will be set to true
					        if (librarianPass.get(x).equals(new String(LoginInput_PassField.getPassword()))) {
				                passVerified = true;
				            }
					        if (userVerified || passVerified) {
					        	break;
					        }
				    }
				// Same functions as the above, difference is this is for admin login
				} else if ("admin".equals(loginType)) {
				    for (x = 0; x < adminUser.size(); x++) {
				        if (adminUser.get(x).equals(LoginInput_UserField.getText().trim())) {
				            userVerified = true;
				        }
				        if (adminPass.get(x).equals(new String(LoginInput_PassField.getPassword()))) {
			                passVerified = true;
			            }
				        if (userVerified || passVerified) {
				        	break;
				        }
				    }
				}

				// Warn no inputs, wrong usernames and passwords.
				if (!userVerified && !passVerified) {
					JOptionPane.showMessageDialog(null, "INCORRECT USERNAME and PASSWORD");
				} else if (!userVerified) {
					JOptionPane.showMessageDialog(null, "INCORRECT USERNAME");
				} else if (!passVerified) {
					JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD");
				} else {
					nextFrame();
				}
				
			}

		});
		LoginInput_LoginButton.setBounds(231, 249, 89, 23);
		Panel_LoginInput.add(LoginInput_LoginButton);
		
		JCheckBox LoginInput_ShowPass = new JCheckBox("Show");
		LoginInput_ShowPass.addMouseListener(new MouseAdapter() {
// Action when show password button is checked
			@Override
			public void mouseClicked(MouseEvent e) {
				if (LoginInput_ShowPass.isSelected()) {
					LoginInput_PassField.setEchoChar((char)0);
				} else {
					LoginInput_PassField.setEchoChar('•');
				}
			}
		});
		LoginInput_ShowPass.setBounds(401, 182, 97, 23);
		Panel_LoginInput.add(LoginInput_ShowPass);
		
		LoginTypes_LibrarianButton.addMouseListener(new MouseAdapter() {
// Action when Librarian login button is clicked
			@Override
			public void mouseClicked(MouseEvent e) {
				// Set logintype to librarian to use for login forms
				loginType = "librarian";
				
				// Sets the login form title
				LoginInput_Title.setText("Librarian");
				Tabs.setSelectedIndex(1);
			}
		});
		
		LoginTypes_AdminButton.addMouseListener(new MouseAdapter() {
// Action when Admin login button is clicked
			@Override
			public void mouseClicked(MouseEvent e) {
				// Set logintype to admin to use for login forms
				loginType = "admin";
				
				// Sets the login form title
				LoginInput_Title.setText("Admin");
				Tabs.setSelectedIndex(1);
			}
		});
		
		LoginInput_BackButton.addMouseListener(new MouseAdapter() {
// Action for clicking the back button
			@Override
			public void mouseClicked(MouseEvent e) {
				// Resets all values in the form when going back
				Tabs.setSelectedIndex(0);
				LoginInput_ShowPass.setSelected(false);
				LoginInput_PassField.setEchoChar('•');
				LoginInput_UserField.setText(null);
				LoginInput_PassField.setText(null);
			}
		});
	}
	
// Run the Page
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
					Login frame = new Login();
					frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
