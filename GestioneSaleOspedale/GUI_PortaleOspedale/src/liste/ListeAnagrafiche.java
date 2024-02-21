package liste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListeAnagrafiche extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeAnagrafiche frame = new ListeAnagrafiche();
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
	public ListeAnagrafiche() {
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListeAnagrafiche.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{140, 122, 127, 0};
		gbl_contentPane.rowHeights = new int[]{19, 33, 23, 23, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textListeAnagrafiche = new JLabel("Liste Anagrafiche Pazienti:");
		textListeAnagrafiche.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textListeAnagrafiche = new GridBagConstraints();
		gbc_textListeAnagrafiche.anchor = GridBagConstraints.NORTHWEST;
		gbc_textListeAnagrafiche.insets = new Insets(0, 0, 5, 5);
		gbc_textListeAnagrafiche.gridwidth = 2;
		gbc_textListeAnagrafiche.gridx = 0;
		gbc_textListeAnagrafiche.gridy = 0;
		contentPane.add(textListeAnagrafiche, gbc_textListeAnagrafiche);
		
		JButton btnAggiungiLista = new JButton("Aggiungi Lista");
		GridBagConstraints gbc_btnAggiungiLista = new GridBagConstraints();
		gbc_btnAggiungiLista.insets = new Insets(0, 0, 5, 0);
		gbc_btnAggiungiLista.anchor = GridBagConstraints.NORTH;
		gbc_btnAggiungiLista.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAggiungiLista.gridx = 2;
		gbc_btnAggiungiLista.gridy = 0;
		contentPane.add(btnAggiungiLista, gbc_btnAggiungiLista);
		
		JButton btnListaAnagrafica_1 = new JButton("Lista Anagrafica 1");
		GridBagConstraints gbc_btnListaAnagrafica_1 = new GridBagConstraints();
		gbc_btnListaAnagrafica_1.anchor = GridBagConstraints.NORTH;
		gbc_btnListaAnagrafica_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnListaAnagrafica_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnListaAnagrafica_1.gridx = 0;
		gbc_btnListaAnagrafica_1.gridy = 2;
		contentPane.add(btnListaAnagrafica_1, gbc_btnListaAnagrafica_1);
		
		JButton btnModifica = new JButton("Modifica");
		GridBagConstraints gbc_btnModifica = new GridBagConstraints();
		gbc_btnModifica.anchor = GridBagConstraints.NORTH;
		gbc_btnModifica.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifica.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifica.gridx = 1;
		gbc_btnModifica.gridy = 2;
		contentPane.add(btnModifica, gbc_btnModifica);
		
		JButton btnElimina = new JButton("Elimina");
		GridBagConstraints gbc_btnElimina = new GridBagConstraints();
		gbc_btnElimina.anchor = GridBagConstraints.NORTH;
		gbc_btnElimina.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnElimina.insets = new Insets(0, 0, 5, 0);
		gbc_btnElimina.gridx = 2;
		gbc_btnElimina.gridy = 2;
		contentPane.add(btnElimina, gbc_btnElimina);
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnChiudi = new GridBagConstraints();
		gbc_btnChiudi.insets = new Insets(0, 0, 0, 5);
		gbc_btnChiudi.gridx = 1;
		gbc_btnChiudi.gridy = 7;
		contentPane.add(btnChiudi, gbc_btnChiudi);
	}

}
