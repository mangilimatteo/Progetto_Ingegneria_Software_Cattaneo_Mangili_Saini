package liste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class ListaPersoneProntoIntervento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPersoneProntoIntervento frame = new ListaPersoneProntoIntervento();
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
	public ListaPersoneProntoIntervento() {
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaPersoneProntoIntervento.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{307, 0};
		gbl_contentPane.rowHeights = new int[]{42, 0, 42, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textListaPersoneProntoIntervento = new JLabel("Lista Persone Pronto Intervento:");
		textListaPersoneProntoIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textListaPersoneProntoIntervento = new GridBagConstraints();
		gbc_textListaPersoneProntoIntervento.fill = GridBagConstraints.BOTH;
		gbc_textListaPersoneProntoIntervento.insets = new Insets(0, 0, 5, 0);
		gbc_textListaPersoneProntoIntervento.gridx = 0;
		gbc_textListaPersoneProntoIntervento.gridy = 0;
		contentPane.add(textListaPersoneProntoIntervento, gbc_textListaPersoneProntoIntervento);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel textListaPersoneProntoIntervento_1 = new JLabel("Lista Persone Pronto Intervento:");
		textListaPersoneProntoIntervento_1.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textListaPersoneProntoIntervento_1 = new GridBagConstraints();
		gbc_textListaPersoneProntoIntervento_1.fill = GridBagConstraints.BOTH;
		gbc_textListaPersoneProntoIntervento_1.gridx = 0;
		gbc_textListaPersoneProntoIntervento_1.gridy = 2;
		contentPane.add(textListaPersoneProntoIntervento_1, gbc_textListaPersoneProntoIntervento_1);
	}
}
