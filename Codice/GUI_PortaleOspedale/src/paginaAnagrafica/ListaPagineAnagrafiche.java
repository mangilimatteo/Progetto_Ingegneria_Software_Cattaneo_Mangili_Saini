package paginaAnagrafica;

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

public class ListaPagineAnagrafiche extends JFrame {

	private static final long serialVersionUID = 1L;
	private String matricolaMedico;
	private DataService dataService;
	private JPanel panel;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPagineAnagrafiche frame = new ListaPagineAnagrafiche("m001a");
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
	public ListaPagineAnagrafiche(String matricolaMedico) {
		this.matricolaMedico = matricolaMedico;
		dataService = new DataService();

		int contatoreAnagrafica = dataService.getContatoreCodice("Anagrafica");
		int posY = 2;
		boolean modificabile;

		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ListaPagineAnagrafiche.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);

		panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 61, 177, 69, 0, 0 };
		gbl_panel.rowHeights = new int[] { 22, 0, 34, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		for (int i = 1; i <= contatoreAnagrafica; i++) {

			final String codiceAnagrafica = String.valueOf(i);

			if (dataService.esisteAnagrafica(codiceAnagrafica)) {

				modificabile = dataService.anagraficaModificabile(codiceAnagrafica, matricolaMedico);

				JButton bottoneAnagrafica = new JButton("Pagina Anagrafica N. " + i);
				bottoneAnagrafica.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						visualizzaAnagrafica(codiceAnagrafica);
					}
				});
				GridBagConstraints gbc_btnListaAnagrafica_1 = new GridBagConstraints();
				gbc_btnListaAnagrafica_1.anchor = GridBagConstraints.NORTH;
				gbc_btnListaAnagrafica_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnListaAnagrafica_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnListaAnagrafica_1.gridx = 3;
				gbc_btnListaAnagrafica_1.gridy = posY;
				panel.add(bottoneAnagrafica, gbc_btnListaAnagrafica_1);

				if (modificabile) {
					JButton bottoneModifica = new JButton("Modifica");
					bottoneModifica.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							modificaAnagrafica(codiceAnagrafica);
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
							eliminaAnagrafica(codiceAnagrafica);
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

		JLabel textListeAnagrafiche = new JLabel("Pagine Anagrafiche registrate:");
		GridBagConstraints gbc_textListeAnagrafiche = new GridBagConstraints();
		gbc_textListeAnagrafiche.anchor = GridBagConstraints.NORTHWEST;
		gbc_textListeAnagrafiche.insets = new Insets(0, 0, 5, 5);
		gbc_textListeAnagrafiche.gridwidth = 2;
		gbc_textListeAnagrafiche.gridx = 0;
		gbc_textListeAnagrafiche.gridy = 0;
		panel.add(textListeAnagrafiche, gbc_textListeAnagrafiche);
		textListeAnagrafiche.setHorizontalAlignment(SwingConstants.CENTER);
		textListeAnagrafiche.setFont(new Font("Arial", Font.BOLD, 18));

		JButton btnChiudi = new JButton("Chiudi");
		GridBagConstraints gbc_btnChiudi = new GridBagConstraints();
		gbc_btnChiudi.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnChiudi.insets = new Insets(0, 0, 5, 5);
		gbc_btnChiudi.gridx = 0;
		gbc_btnChiudi.gridy = 1;
		panel.add(btnChiudi, gbc_btnChiudi);
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnAggiungiLista = new JButton("Crea nuova pagina anagrafica");
		GridBagConstraints gbc_btnAggiungiLista = new GridBagConstraints();
		gbc_btnAggiungiLista.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAggiungiLista.insets = new Insets(0, 0, 5, 5);
		gbc_btnAggiungiLista.gridx = 1;
		gbc_btnAggiungiLista.gridy = 1;
		panel.add(btnAggiungiLista, gbc_btnAggiungiLista);
		btnAggiungiLista.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAggiungiLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aggiungiAnagrafica();
			}
		});

		JButton buttonRicarica = new JButton("Ricarica");
		buttonRicarica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		GridBagConstraints gbc_buttonRicarica = new GridBagConstraints();
		gbc_buttonRicarica.anchor = GridBagConstraints.NORTH;
		gbc_buttonRicarica.insets = new Insets(0, 0, 5, 5);
		gbc_buttonRicarica.gridx = 2;
		gbc_buttonRicarica.gridy = 1;
		panel.add(buttonRicarica, gbc_buttonRicarica);

	}

	public void refresh() {
		ListaPagineAnagrafiche listaAnagrafiche = new ListaPagineAnagrafiche(matricolaMedico);
		listaAnagrafiche.setUndecorated(true);
		listaAnagrafiche.setVisible(true);
		listaAnagrafiche.setExtendedState(JFrame.MAXIMIZED_BOTH);

		dispose();
	}

	protected void eliminaAnagrafica(String codiceAnagrafica) {
		int scelta = JOptionPane.showConfirmDialog(null, "Confermi di voler eliminare la pagina anagrafica N. "
				+ codiceAnagrafica
				+ "?\nEliminando la pagina anagrafica eliminerai possibili operazioni e verbali associati ad essa",
				"Conferma eliminazione", JOptionPane.YES_NO_OPTION);

		if (scelta == JOptionPane.YES_OPTION) {
			dataService.eliminaAnagrafica(codiceAnagrafica);
			JOptionPane.showMessageDialog(null, "Anagrafica N. " + codiceAnagrafica + " eliminata");
			refresh();
		} else {
			JOptionPane.showMessageDialog(null, "Eliminazione annullata");
		}
	}

	protected void modificaAnagrafica(String codiceAnagrafica) {
		ModificaPaginaAnagrafica modificaAnagrafica = new ModificaPaginaAnagrafica(codiceAnagrafica, "", false);
		modificaAnagrafica.setUndecorated(true);
		modificaAnagrafica.setVisible(true);
		modificaAnagrafica.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	protected void visualizzaAnagrafica(String codiceAnagrafica) {
		VisualizzazionePaginaAnagrafica visualizzaAnagrafica = new VisualizzazionePaginaAnagrafica(codiceAnagrafica,
				matricolaMedico);
		visualizzaAnagrafica.setUndecorated(true);
		visualizzaAnagrafica.setVisible(true);
		visualizzaAnagrafica.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	protected void aggiungiAnagrafica() {
		ModificaPaginaAnagrafica modificaAnagrafica = new ModificaPaginaAnagrafica("", matricolaMedico, true);
		modificaAnagrafica.setUndecorated(true);
		modificaAnagrafica.setVisible(true);
		modificaAnagrafica.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
}
