package personale_sanitario;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;

import model.DataService;

public class SchermataCabinadiregia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String matricolaRegia;
	private DataService dataService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchermataCabinadiregia frame = new SchermataCabinadiregia("c001a");
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
	 * @param matricolaRegia 
	 */
	public SchermataCabinadiregia(String matricolaRegia) {
		
		dataService = new DataService();
		this.matricolaRegia = matricolaRegia;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SchermataCabinadiregia.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale Papa Giovanni XIII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textCabinadiRegia = new JLabel("Cabina di Regia:");
		textCabinadiRegia.setFont(new Font("Arial", Font.BOLD, 16));
		textCabinadiRegia.setBounds(10, 11, 126, 42);
		contentPane.add(textCabinadiRegia);
		
		//ATTENZIONE inserire modo per associare nome+cognome della cabina di regia all'accesso della pagina!!!
		JLabel textNomeCabinadiRegia = new JLabel(dataService.getNomeDipendente(matricolaRegia) + " " + dataService.getCognomeDipendente(matricolaRegia));
		textNomeCabinadiRegia.setFont(new Font("Arial", Font.BOLD, 16));
		textNomeCabinadiRegia.setBounds(139, 11, 285, 42);
		contentPane.add(textNomeCabinadiRegia);
	}

}