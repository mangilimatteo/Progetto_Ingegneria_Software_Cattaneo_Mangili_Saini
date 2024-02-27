package login;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personale_sanitario.SchermataCabinadiregia;
import personale_sanitario.SchermataInfermiere;
import personale_sanitario.SchermataMedico;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import model.DataService;


public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMatricola;
	private JPasswordField passwordField;
	private DataService dataService;



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

	public Login() {
		
		dataService = new DataService();
		
		setTitle("Portale digitale Personale Sanitario dell'ospedale [inserire nome ospedale]");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel PannelloLogin = new JPanel();
		PannelloLogin.setBounds(5, 5, 581, 226);
		PannelloLogin.setLayout(null);
		
		JLabel Titolo = new JLabel("Inserire credenziali d'accesso");
		Titolo.setBounds(123, 24, 335, 22);
		PannelloLogin.add(Titolo);
		Titolo.setFont(new Font("Arial", Font.BOLD, 18));
		Titolo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel Matricola = new JLabel("Matricola:");
		Matricola.setBounds(10, 69, 84, 20);
		Matricola.setFont(new Font("Arial", Font.PLAIN, 14));
		PannelloLogin.add(Matricola);
		
		textMatricola = new JTextField();
		textMatricola.setBounds(99, 71, 451, 20);
		PannelloLogin.add(textMatricola);
		textMatricola.setColumns(10);
		
		JLabel Password = new JLabel("Password:");
		Password.setBounds(10, 97, 84, 27);
		Password.setFont(new Font("Arial", Font.PLAIN, 14));
		PannelloLogin.add(Password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(99, 102, 451, 20);
		PannelloLogin.add(passwordField);
		
		JButton bottoneLogin = new JButton("Login");
		bottoneLogin.setBounds(156, 150, 269, 52);
		PannelloLogin.add(bottoneLogin);
		bottoneLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				effettuaLogin();
				
			}
		});
		contentPane.setLayout(null);
		bottoneLogin.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(PannelloLogin);
	}
	
	
	void effettuaLogin(){
		String matricola = textMatricola.getText();
		if(dataService.credenzialiCorrette(matricola, passwordField.getPassword())) {
			String ruolo = dataService.getRuoloDipendente(textMatricola.getText().toLowerCase()); 
			switch(ruolo){
				case "Medico":
					SchermataMedico schermatamedico= new SchermataMedico(matricola);
					schermatamedico.setVisible(true);
					dispose();
					break;
				case "Infermiere":
					SchermataInfermiere schermatainfermiere= new SchermataInfermiere(matricola);
					schermatainfermiere.setVisible(true);
					dispose();
					break;
				case "Cabina di regia":
					SchermataCabinadiregia schermatacabinadiregia= new SchermataCabinadiregia(matricola);
					schermatacabinadiregia.setVisible(true);
					dispose();
				}
		}
		else {
			textMatricola.setText("");
			passwordField.setText("");
			JOptionPane.showMessageDialog(null,"errore, credenziali errate riprova");
		}
	
	}
	
}

