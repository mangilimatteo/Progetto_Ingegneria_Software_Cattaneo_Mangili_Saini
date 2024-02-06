package personale_sanitario;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	public SchermataMedico(String matricolaMedico) {
		
		dataService = new DataService();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SchermataMedico.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale [inserire nome ospedale]");
		
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
		//ATTENZIONE inserire modo per associare nome+cognome del medico all'accesso della pagina!!!
		textNomeMedico.setText(dataService.getNomeDipendente(matricolaMedico) + " " + dataService.getCognomeDipendente(matricolaMedico));
		textNomeMedico.setFont(new Font("Arial", Font.BOLD, 16));
		textNomeMedico.setBounds(77, 11, 477, 42);
		contentPane.add(textNomeMedico);
		
		JButton bottoneRegistraPaziente = new JButton("Registra Paziente");
		bottoneRegistraPaziente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//si apre la pagina anagrafica già modificabile
				ModificaPaginaAnagrafica paginaanagraficapaziente= new ModificaPaginaAnagrafica("", matricolaMedico);
				paginaanagraficapaziente.setVisible(true);
			}
		});
		bottoneRegistraPaziente.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneRegistraPaziente.setBounds(10, 79, 221, 42);
		contentPane.add(bottoneRegistraPaziente);
		
		JButton bottoneVisualizzaDatiPazienti = new JButton("Visualizza Pazienti");
		bottoneVisualizzaDatiPazienti.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneVisualizzaDatiPazienti.setBounds(266, 79, 221, 42);
		contentPane.add(bottoneVisualizzaDatiPazienti);
		
		JButton bottoneCreaListaOperatoria = new JButton("Crea Lista Operatoria");
		bottoneCreaListaOperatoria.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneCreaListaOperatoria.setBounds(10, 155, 221, 42);
		contentPane.add(bottoneCreaListaOperatoria);
		
		JButton bottoneVisualizzaListeOperatorie = new JButton("Visualizza Liste Operatorie");
		bottoneVisualizzaListeOperatorie.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneVisualizzaListeOperatorie.setBounds(266, 155, 221, 42);
		contentPane.add(bottoneVisualizzaListeOperatorie);
		
		JButton bottoneCreaVerbale = new JButton("Crea Verbale");
		bottoneCreaVerbale.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneCreaVerbale.setBounds(10, 237, 221, 42);
		contentPane.add(bottoneCreaVerbale);
		
		JButton bottoneVisualizzaVerbali = new JButton("Visualizza Verbali");
		bottoneVisualizzaVerbali.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneVisualizzaVerbali.setBounds(266, 237, 221, 42);
		contentPane.add(bottoneVisualizzaVerbali);
	}
}
