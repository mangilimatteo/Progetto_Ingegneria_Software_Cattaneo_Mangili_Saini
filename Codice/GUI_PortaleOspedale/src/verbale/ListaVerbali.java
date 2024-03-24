package verbale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import model.DataService;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;

public class ListaVerbali extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String matricolaDipendente;
	private DataService dataService;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaVerbali frame = new ListaVerbali("m001a");
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
	 */
	public ListaVerbali(String matricolaDipendente) {
		this.matricolaDipendente = matricolaDipendente;
		dataService = new DataService();

		int contatoreVerbale = dataService.getContatoreCodice("Verbale");
		int posY = 2;

		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ListaVerbali.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);

		panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 130, 127, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 19, 47, 24, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		for (int i = 1; i <= contatoreVerbale; i++) {

			final String codiceVerbale = String.valueOf(i);

			if (dataService.esisteVerbale(codiceVerbale)) {

				JButton bottoneVerbale = new JButton("Verbale N. " + i);
				bottoneVerbale.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						visualizzaVerbale(codiceVerbale);
					}
				});
				GridBagConstraints gbc_btnListaVerbale_1 = new GridBagConstraints();
				gbc_btnListaVerbale_1.anchor = GridBagConstraints.NORTH;
				gbc_btnListaVerbale_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnListaVerbale_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnListaVerbale_1.gridx = 0;
				gbc_btnListaVerbale_1.gridy = posY;
				panel.add(bottoneVerbale, gbc_btnListaVerbale_1);

				if (dataService.verbaleModificabile(codiceVerbale, matricolaDipendente)) {
					JButton bottoneModifica = new JButton("Modifica");
					bottoneModifica.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							modificaVerbale(codiceVerbale);
						}
					});
					GridBagConstraints gbc_btnModifica = new GridBagConstraints();
					gbc_btnModifica.anchor = GridBagConstraints.NORTH;
					gbc_btnModifica.fill = GridBagConstraints.HORIZONTAL;
					gbc_btnModifica.insets = new Insets(0, 0, 5, 5);
					gbc_btnModifica.gridx = 1;
					gbc_btnModifica.gridy = posY;
					panel.add(bottoneModifica, gbc_btnModifica);

					JButton bottoneElimina = new JButton("Elimina");
					bottoneElimina.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							eliminaVerbale(codiceVerbale);
						}
					});
					GridBagConstraints gbc_btnElimina = new GridBagConstraints();
					gbc_btnElimina.anchor = GridBagConstraints.NORTH;
					gbc_btnElimina.fill = GridBagConstraints.HORIZONTAL;
					gbc_btnElimina.insets = new Insets(0, 0, 5, 0);
					gbc_btnElimina.gridx = 2;
					gbc_btnElimina.gridy = posY;
					panel.add(bottoneElimina, gbc_btnElimina);
				}

				posY++;
			}
		}

		JLabel textListeVerbali = new JLabel("Verbali registrati:");
		GridBagConstraints gbc_textListeVerbali = new GridBagConstraints();
		gbc_textListeVerbali.anchor = GridBagConstraints.WEST;
		gbc_textListeVerbali.fill = GridBagConstraints.VERTICAL;
		gbc_textListeVerbali.insets = new Insets(0, 0, 5, 5);
		gbc_textListeVerbali.gridwidth = 2;
		gbc_textListeVerbali.gridx = 0;
		gbc_textListeVerbali.gridy = 0;
		panel.add(textListeVerbali, gbc_textListeVerbali);
		textListeVerbali.setHorizontalAlignment(SwingConstants.CENTER);
		textListeVerbali.setFont(new Font("Arial", Font.BOLD, 18));

		JButton btnChiudi = new JButton("Chiudi");
		GridBagConstraints gbc_btnChiudi = new GridBagConstraints();
		gbc_btnChiudi.insets = new Insets(0, 0, 5, 5);
		gbc_btnChiudi.anchor = GridBagConstraints.WEST;
		gbc_btnChiudi.gridx = 0;
		gbc_btnChiudi.gridy = 1;
		panel.add(btnChiudi, gbc_btnChiudi);

		JButton btnAggiungiLista = new JButton("Crea nuovo verbale");
		GridBagConstraints gbc_btnAggiungiLista = new GridBagConstraints();
		gbc_btnAggiungiLista.insets = new Insets(0, 0, 5, 5);
		gbc_btnAggiungiLista.anchor = GridBagConstraints.WEST;
		gbc_btnAggiungiLista.gridx = 1;
		gbc_btnAggiungiLista.gridy = 1;
		panel.add(btnAggiungiLista, gbc_btnAggiungiLista);
		btnAggiungiLista.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAggiungiLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aggiungiVerbale();
			}
		});
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	public void refresh() {
		ListaVerbali listaVerbali = new ListaVerbali(matricolaDipendente);
		listaVerbali.setUndecorated(true);
		listaVerbali.setVisible(true);
		listaVerbali.setExtendedState(JFrame.MAXIMIZED_BOTH);

		dispose();
	}

	protected void eliminaVerbale(String codiceVerbale) {
		int scelta = JOptionPane.showConfirmDialog(null, "Confermi di voler eliminare il verbale N. " + codiceVerbale,
				"Conferma eliminazione", JOptionPane.YES_NO_OPTION);

		if (scelta == JOptionPane.YES_OPTION) {
			dataService.eliminaVerbale(codiceVerbale);
			JOptionPane.showMessageDialog(null, "Verbale N. " + codiceVerbale + " eliminato");
			refresh();
		} else {
			JOptionPane.showMessageDialog(null, "Eliminazione annullata");
		}
	}

	protected void modificaVerbale(String codiceVerbale) {
		ModificaVerbale modificaVerbale = new ModificaVerbale(codiceVerbale, matricolaDipendente, "");
		modificaVerbale.setUndecorated(true);
		modificaVerbale.setVisible(true);
		modificaVerbale.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	protected void visualizzaVerbale(String codiceVerbale) {
		VisualizzazioneVerbale visualizzaVerbale = new VisualizzazioneVerbale(codiceVerbale, matricolaDipendente);
		visualizzaVerbale.setUndecorated(true);
		visualizzaVerbale.setVisible(true);
		visualizzaVerbale.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	protected void aggiungiVerbale() {
		SelezioneOperazione selezione = new SelezioneOperazione(matricolaDipendente);
		selezione.setUndecorated(true);
		selezione.setVisible(true);
		selezione.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

}
