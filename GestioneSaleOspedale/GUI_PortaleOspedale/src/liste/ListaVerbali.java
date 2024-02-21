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

public class ListaVerbali extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaVerbali frame = new ListaVerbali();
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
	public ListaVerbali() {
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaVerbali.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{135, 117, 127, 0};
		gbl_contentPane.rowHeights = new int[]{19, 23, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textListeVerbali = new JLabel("Liste Verbali;");
		textListeVerbali.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textListeVerbali = new GridBagConstraints();
		gbc_textListeVerbali.anchor = GridBagConstraints.NORTH;
		gbc_textListeVerbali.fill = GridBagConstraints.HORIZONTAL;
		gbc_textListeVerbali.insets = new Insets(0, 0, 5, 5);
		gbc_textListeVerbali.gridwidth = 2;
		gbc_textListeVerbali.gridx = 0;
		gbc_textListeVerbali.gridy = 0;
		contentPane.add(textListeVerbali, gbc_textListeVerbali);
		
		JButton btnListaVerbali_1 = new JButton("Lista Verbale_1");
		GridBagConstraints gbc_btnListaVerbali_1 = new GridBagConstraints();
		gbc_btnListaVerbali_1.anchor = GridBagConstraints.NORTH;
		gbc_btnListaVerbali_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnListaVerbali_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnListaVerbali_1.gridx = 0;
		gbc_btnListaVerbali_1.gridy = 1;
		contentPane.add(btnListaVerbali_1, gbc_btnListaVerbali_1);
		
		JButton btnModifica = new JButton("Modifica");
		GridBagConstraints gbc_btnModifica = new GridBagConstraints();
		gbc_btnModifica.anchor = GridBagConstraints.NORTH;
		gbc_btnModifica.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifica.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifica.gridx = 1;
		gbc_btnModifica.gridy = 1;
		contentPane.add(btnModifica, gbc_btnModifica);
		
		JButton btnElimina = new JButton("Elimina");
		GridBagConstraints gbc_btnElimina = new GridBagConstraints();
		gbc_btnElimina.insets = new Insets(0, 0, 5, 0);
		gbc_btnElimina.anchor = GridBagConstraints.NORTH;
		gbc_btnElimina.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnElimina.gridx = 2;
		gbc_btnElimina.gridy = 1;
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
		gbc_btnChiudi.gridy = 8;
		contentPane.add(btnChiudi, gbc_btnChiudi);
	}

}
