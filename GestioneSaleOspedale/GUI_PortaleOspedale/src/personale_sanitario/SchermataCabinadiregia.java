package personale_sanitario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;

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
		JLabel textNomeCabinadiRegia = new JLabel("OCA");
		textNomeCabinadiRegia.setFont(new Font("Arial", Font.BOLD, 16));
		textNomeCabinadiRegia.setBounds(139, 11, 285, 42);
		contentPane.add(textNomeCabinadiRegia);
	}

}
