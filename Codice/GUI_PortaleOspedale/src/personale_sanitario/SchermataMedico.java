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
		contentPane.setLayout(null);
		
		JLabel textNomeMedico = new JLabel("Medico: " +
				dataService.getNomeDipendente(matricolaDipendente) + " " +
				dataService.getCognomeDipendente(matricolaDipendente));
		textNomeMedico.setHorizontalAlignment(SwingConstants.CENTER);
		textNomeMedico.setFont(new Font("Arial", Font.BOLD, 16));
		textNomeMedico.setBounds(125, 10, 280, 42);
		contentPane.add(textNomeMedico);
		
		JButton bottoneRegistraPaziente = new JButton("Registra anagrafica");
		bottoneRegistraPaziente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//si apre la pagina anagrafica già modificabile
				ModificaPaginaAnagrafica paginaanagraficapaziente= new ModificaPaginaAnagrafica("", matricolaDipendente,true);
				paginaanagraficapaziente.setVisible(true);
			}
		});
		bottoneRegistraPaziente.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneRegistraPaziente.setBounds(10, 79, 221, 42);
		contentPane.add(bottoneRegistraPaziente);
		
		JButton bottoneVisualizzaDatiPazienti = new JButton("Visualizza anagrafiche");
		bottoneVisualizzaDatiPazienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPagineAnagrafiche listaAnagrafiche= new ListaPagineAnagrafiche(matricolaDipendente);
				listaAnagrafiche.setVisible(true);
			}
		});
		bottoneVisualizzaDatiPazienti.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneVisualizzaDatiPazienti.setBounds(302, 79, 221, 42);
		contentPane.add(bottoneVisualizzaDatiPazienti);
		
		JButton bottoneCreaOperazione = new JButton("Crea Lista Operatoria");
		bottoneCreaOperazione.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneCreaOperazione.setBounds(10, 155, 221, 42);
		bottoneCreaOperazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelezionePaginaAnagrafica selezione = new SelezionePaginaAnagrafica(matricolaDipendente);
				selezione.setVisible(true);	
			}
		});
		contentPane.add(bottoneCreaOperazione);
		
		JButton bottoneVisualizzaOperazioni = new JButton("Visualizza Liste Operatorie");
		bottoneVisualizzaOperazioni.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneVisualizzaOperazioni.setBounds(302, 155, 221, 42);
		bottoneVisualizzaOperazioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaOperazioni listaOperazioni = new ListaOperazioni(matricolaDipendente);
				listaOperazioni.setVisible(true);
			}
		});
		contentPane.add(bottoneVisualizzaOperazioni);
		
		JButton bottoneCreaVerbale = new JButton("Crea Verbale");
		bottoneCreaVerbale.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneCreaVerbale.setBounds(10, 237, 221, 42);
		bottoneCreaVerbale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelezioneOperazione selezione = new SelezioneOperazione(matricolaDipendente);
				selezione.setVisible(true);	
			}
		});
		contentPane.add(bottoneCreaVerbale);
		
		JButton bottoneVisualizzaVerbali = new JButton("Visualizza Verbali");
		bottoneVisualizzaVerbali.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneVisualizzaVerbali.setBounds(302, 237, 221, 42);
		bottoneVisualizzaVerbali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaVerbali listaVerbali = new ListaVerbali(matricolaDipendente);
				listaVerbali.setVisible(true);
			}
		});
		contentPane.add(bottoneVisualizzaVerbali);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLogout.setBounds(155, 319, 221, 42);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		contentPane.add(btnLogout);
	}

	protected void logout() {
		int scelta = JOptionPane.showConfirmDialog(
                null, 
                "Confermi di voler uscire dal sistema?", 
                "Conferma logout", 
                JOptionPane.YES_NO_OPTION 
        );
		 if (scelta == JOptionPane.YES_OPTION) {
			 dispose();
		 }
		
	}
}
