package personale_sanitario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;

public class SchermataInfermiere extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchermataInfermiere frame = new SchermataInfermiere();
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
	public SchermataInfermiere() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SchermataInfermiere.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale Papa Giovanni XIII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textInfermiere = new JLabel("Infermiere:");
		textInfermiere.setFont(new Font("Arial", Font.BOLD, 16));
		textInfermiere.setBounds(10, 11, 82, 42);
		contentPane.add(textInfermiere);
		
		//ATTENZIONE inserire modo per associare nome+cognome dell'infermiere all'accesso della pagina!!!
		JLabel textNomeInfermiere = new JLabel("gabibbo");
		textNomeInfermiere.setFont(new Font("Arial", Font.BOLD, 16));
		textNomeInfermiere.setBounds(94, 11, 330, 42);
		contentPane.add(textNomeInfermiere);
	}

}
