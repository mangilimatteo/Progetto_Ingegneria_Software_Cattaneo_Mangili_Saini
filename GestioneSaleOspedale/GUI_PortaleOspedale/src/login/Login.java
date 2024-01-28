package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personale_sanitario.SchermataCabinadiregia;
import personale_sanitario.SchermataInfermiere;
import personale_sanitario.SchermataMedico;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMatricola;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Portale digitale Personale Sanitario dell'ospedale [inserire nome ospedale]");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel PannelloLogin = new JPanel();
		PannelloLogin.setBounds(5, 5, 531, 226);
		PannelloLogin.setLayout(null);
		
		JLabel Titolo = new JLabel("Salve inserire credenziali d'accesso");
		Titolo.setBounds(109, 24, 313, 22);
		PannelloLogin.add(Titolo);
		Titolo.setFont(new Font("Arial", Font.BOLD, 18));
		Titolo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel Matricola = new JLabel("Matricola:");
		Matricola.setBounds(0, 69, 61, 20);
		Matricola.setFont(new Font("Arial", Font.PLAIN, 14));
		PannelloLogin.add(Matricola);
		
		textMatricola = new JTextField();
		textMatricola.setBounds(70, 70, 451, 20);
		PannelloLogin.add(textMatricola);
		textMatricola.setColumns(10);
		
		JLabel Password = new JLabel("Password:");
		Password.setBounds(0, 97, 65, 27);
		Password.setFont(new Font("Arial", Font.PLAIN, 14));
		PannelloLogin.add(Password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(70, 101, 451, 20);
		PannelloLogin.add(passwordField);
		
		//bottone per accesso a medico, infermiere e cabina di regia
		JButton bottoneLogin = new JButton("Login");
		bottoneLogin.setBounds(131, 148, 269, 52);
		PannelloLogin.add(bottoneLogin);
		bottoneLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//inserire nello switch la condizione per l'accesso alle varie pagine!!!		
				switch(1){
					case 1:
						SchermataMedico schermatamedico= new SchermataMedico();
						schermatamedico.setVisible(true);
						dispose();
						break;
					case 2:
						SchermataInfermiere schermatainfermiere= new SchermataInfermiere();
						schermatainfermiere.setVisible(true);
						dispose();
						break;
					case 3:
						SchermataCabinadiregia schermatacabinadiregia= new SchermataCabinadiregia();
						schermatacabinadiregia.setVisible(true);
						dispose();
						break;
					default:
						passwordField.setText("");
						JOptionPane.showMessageDialog(null,"errore, credenziali errate riprova");
					}
			}
		});
		contentPane.setLayout(null);
		bottoneLogin.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(PannelloLogin);
	}
}
