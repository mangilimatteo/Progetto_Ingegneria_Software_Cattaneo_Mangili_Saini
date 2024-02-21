package personale_sanitario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;

public class SchermataCabinadiregia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchermataCabinadiregia frame = new SchermataCabinadiregia();
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
	public SchermataCabinadiregia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SchermataCabinadiregia.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale [inserire nome ospedale]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textCabinadiRegia = new JLabel("Cabina di Regia:");
		textCabinadiRegia.setFont(new Font("Arial", Font.BOLD, 16));
		textCabinadiRegia.setBounds(10, 11, 126, 42);
		contentPane.add(textCabinadiRegia);
		
		//ATTENZIONE inserire modo per associare nome+cognome della cabina di regia all'accesso della pagina!!!
		JLabel textNomeCabinadiRegia = new JLabel("OCA");
		textNomeCabinadiRegia.setFont(new Font("Arial", Font.BOLD, 16));
		textNomeCabinadiRegia.setBounds(139, 11, 285, 42);
		contentPane.add(textNomeCabinadiRegia);
		
		JButton bottoneCreaListaPersonePronteIntervento = new JButton("Crea Lista Persone Pronte Intervento");
		bottoneCreaListaPersonePronteIntervento.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneCreaListaPersonePronteIntervento.setBounds(10, 64, 414, 42);
		contentPane.add(bottoneCreaListaPersonePronteIntervento);
		
		JButton bottoneVisualizzaListaPersonePronteIntervento = new JButton("Visualizza Lista Persone Pronte Intervento");
		bottoneVisualizzaListaPersonePronteIntervento.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneVisualizzaListaPersonePronteIntervento.setBounds(10, 117, 414, 42);
		contentPane.add(bottoneVisualizzaListaPersonePronteIntervento);
		
		JButton bottoneCreaEsami = new JButton("Crea Esami");
		bottoneCreaEsami.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneCreaEsami.setBounds(10, 170, 414, 42);
		contentPane.add(bottoneCreaEsami);
		
		JButton bottoneVisualizzaEsami = new JButton("VisualizzaEsami");
		bottoneVisualizzaEsami.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneVisualizzaEsami.setBounds(10, 223, 414, 42);
		contentPane.add(bottoneVisualizzaEsami);
		
		JButton bottoneVisualizzaPazienti = new JButton("VisualizzaPazienti");
		bottoneVisualizzaPazienti.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneVisualizzaPazienti.setBounds(10, 276, 414, 42);
		contentPane.add(bottoneVisualizzaPazienti);
	}
}
