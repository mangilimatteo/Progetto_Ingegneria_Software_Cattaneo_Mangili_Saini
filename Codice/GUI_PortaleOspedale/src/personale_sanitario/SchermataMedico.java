package personale_sanitario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import liste.*;
import model.DataService;
import paziente.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textDottore = new JLabel("Dottore:");
		textDottore.setFont(new Font("Arial", Font.BOLD, 16));
		textDottore.setBounds(10, 11, 63, 42);
		contentPane.add(textDottore);
		
		JLabel textNomeMedico = new JLabel("Dottore:");
		textNomeMedico.setText(dataService.getNomeDipendente(matricolaDipendente) + " " + dataService.getCognomeDipendente(matricolaDipendente));
		textNomeMedico.setFont(new Font("Arial", Font.BOLD, 16));
		textNomeMedico.setBounds(77, 11, 477, 42);
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
		bottoneVisualizzaDatiPazienti.setBounds(266, 79, 221, 42);
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
		bottoneVisualizzaOperazioni.setBounds(266, 155, 221, 42);
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
		bottoneVisualizzaVerbali.setBounds(266, 237, 221, 42);
		bottoneVisualizzaVerbali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaVerbali listaVerbali = new ListaVerbali(matricolaDipendente);
				listaVerbali.setVisible(true);
			}
		});
		contentPane.add(bottoneVisualizzaVerbali);
	}
}
