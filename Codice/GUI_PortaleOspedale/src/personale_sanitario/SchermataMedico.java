package personale_sanitario;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DataService;
import operazione.ListaOperazioni;
import operazione.SelezionePaginaAnagrafica;
import paginaAnagrafica.ListaPagineAnagrafiche;
import paginaAnagrafica.ModificaPaginaAnagrafica;
import verbale.ListaVerbali;
import verbale.SelezioneOperazione;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class SchermataMedico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane; 
	private DataService dataService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchermataMedico frame = new SchermataMedico("m001a");
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SchermataMedico(String matricolaDipendente) {
		
		dataService = new DataService();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SchermataMedico.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale Papa Giovanni XXIII");
		setUndecorated(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel textNomeMedico = new JLabel("Medico: " +
				dataService.getNomeDipendente(matricolaDipendente) + " " +
				dataService.getCognomeDipendente(matricolaDipendente));
		textNomeMedico.setBounds(146, 5, 235, 19);
		panel.add(textNomeMedico);
		textNomeMedico.setHorizontalAlignment(SwingConstants.CENTER);
		textNomeMedico.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton bottoneRegistraPaziente = new JButton("Registra anagrafica");
		bottoneRegistraPaziente.setBounds(10, 66, 221, 42);
		panel.add(bottoneRegistraPaziente);
		bottoneRegistraPaziente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//si apre la pagina anagrafica gi� modificabile
				ModificaPaginaAnagrafica paginaanagraficapaziente= new ModificaPaginaAnagrafica("", matricolaDipendente,true);
				paginaanagraficapaziente.setUndecorated(true);
				paginaanagraficapaziente.setVisible(true);
				paginaanagraficapaziente.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		bottoneRegistraPaziente.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton bottoneCreaOperazione = new JButton("Crea Lista Operatoria");
		bottoneCreaOperazione.setBounds(10, 145, 221, 42);
		panel.add(bottoneCreaOperazione);
		bottoneCreaOperazione.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton bottoneCreaVerbale = new JButton("Crea Verbale");
		bottoneCreaVerbale.setBounds(10, 227, 221, 42);
		panel.add(bottoneCreaVerbale);
		bottoneCreaVerbale.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(146, 308, 221, 42);
		panel.add(btnLogout);
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton bottoneVisualizzaVerbali = new JButton("Visualizza Verbali");
		bottoneVisualizzaVerbali.setBounds(296, 227, 221, 42);
		panel.add(bottoneVisualizzaVerbali);
		bottoneVisualizzaVerbali.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton bottoneVisualizzaOperazioni = new JButton("Visualizza Liste Operatorie");
		bottoneVisualizzaOperazioni.setBounds(296, 145, 221, 42);
		panel.add(bottoneVisualizzaOperazioni);
		bottoneVisualizzaOperazioni.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton bottoneVisualizzaDatiPazienti = new JButton("Visualizza anagrafiche");
		bottoneVisualizzaDatiPazienti.setBounds(296, 66, 221, 42);
		panel.add(bottoneVisualizzaDatiPazienti);
		bottoneVisualizzaDatiPazienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPagineAnagrafiche listaAnagrafiche= new ListaPagineAnagrafiche(matricolaDipendente);
				listaAnagrafiche.setUndecorated(true);
				listaAnagrafiche.setVisible(true);
				listaAnagrafiche.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		bottoneVisualizzaDatiPazienti.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneVisualizzaOperazioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaOperazioni listaOperazioni = new ListaOperazioni(matricolaDipendente);
				listaOperazioni.setUndecorated(true);
				listaOperazioni.setVisible(true);
				listaOperazioni.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		bottoneVisualizzaVerbali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaVerbali listaVerbali = new ListaVerbali(matricolaDipendente);
				listaVerbali.setUndecorated(true);
				listaVerbali.setVisible(true);
				listaVerbali.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		bottoneCreaVerbale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelezioneOperazione selezione = new SelezioneOperazione(matricolaDipendente);
				selezione.setUndecorated(true);
				selezione.setVisible(true);
				selezione.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		bottoneCreaOperazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelezionePaginaAnagrafica selezione = new SelezionePaginaAnagrafica(matricolaDipendente);
				selezione.setUndecorated(true);
				selezione.setVisible(true);
				selezione.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
	}

	protected void logout() {
		int scelta = JOptionPane.showConfirmDialog(
                null, 
                "Confermi di voler uscire dal sistema?", 
                "Conferma logout", 
                JOptionPane.YES_NO_OPTION 
        );
		 if (scelta == JOptionPane.YES_OPTION) {
			 System.exit(0);
		 }
		
	}
}
