package verbale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import model.DataService;
import operazione.VisualizzazioneOperazione;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;

public class SelezioneOperazione extends JFrame {

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
					SelezioneOperazione frame = new SelezioneOperazione("m001a");
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
	public SelezioneOperazione(String codiceDipendente) {
		this.matricolaDipendente = codiceDipendente;
		dataService = new DataService();

		int contatoreOperazione = dataService.getContatoreCodice("Operazione");
		int posY = 2;

		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(SelezioneOperazione.class.getResource("/resources/LogoOspedale.png")));
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
		gbl_panel.columnWidths = new int[] { 89, 86, 158, 0, 0 };
		gbl_panel.rowHeights = new int[] { 22, 43, 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		for (int i = 1; i <= contatoreOperazione; i++) {

			final String codiceOperazione = String.valueOf(i);

			if (dataService.esisteOperazione(codiceOperazione)
					&& dataService.getVerbaleAssociato(codiceOperazione).equals("")) {

				JButton bottoneOperazione = new JButton("Operazione N. " + i);
				bottoneOperazione.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						visualizzaOperazione(codiceOperazione);
					}
				});
				GridBagConstraints gbc_btnListaOperazione_1 = new GridBagConstraints();
				gbc_btnListaOperazione_1.anchor = GridBagConstraints.NORTH;
				gbc_btnListaOperazione_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnListaOperazione_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnListaOperazione_1.gridx = 0;
				gbc_btnListaOperazione_1.gridy = posY;
				panel.add(bottoneOperazione, gbc_btnListaOperazione_1);

				JButton bottoneSelezione = new JButton("Seleziona");
				bottoneSelezione.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SelezionaOperazione(codiceOperazione);
					}
				});
				GridBagConstraints gbc_btnSelezione = new GridBagConstraints();
				gbc_btnSelezione.anchor = GridBagConstraints.NORTH;
				gbc_btnSelezione.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnSelezione.insets = new Insets(0, 0, 5, 5);
				gbc_btnSelezione.gridx = 1;
				gbc_btnSelezione.gridy = posY;
				panel.add(bottoneSelezione, gbc_btnSelezione);

				posY++;
			}
		}

		JLabel textListeOperazioni = new JLabel("Seleziona l'operazione di cui vuoi redigere il verbale:");
		textListeOperazioni.setHorizontalAlignment(SwingConstants.CENTER);
		textListeOperazioni.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_textListeOperazioni = new GridBagConstraints();
		gbc_textListeOperazioni.gridwidth = 3;
		gbc_textListeOperazioni.anchor = GridBagConstraints.NORTHWEST;
		gbc_textListeOperazioni.insets = new Insets(0, 0, 5, 5);
		gbc_textListeOperazioni.gridx = 0;
		gbc_textListeOperazioni.gridy = 0;
		panel.add(textListeOperazioni, gbc_textListeOperazioni);
		
				JButton btnChiudi = new JButton("Chiudi");
				GridBagConstraints gbc_btnChiudi = new GridBagConstraints();
				gbc_btnChiudi.anchor = GridBagConstraints.WEST;
				gbc_btnChiudi.insets = new Insets(0, 0, 5, 5);
				gbc_btnChiudi.gridx = 0;
				gbc_btnChiudi.gridy = 1;
				panel.add(btnChiudi, gbc_btnChiudi);
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	protected void SelezionaOperazione(String codiceAnagrafica) {
		ModificaVerbale modifica = new ModificaVerbale("", matricolaDipendente, codiceAnagrafica);
		modifica.setUndecorated(true);
		modifica.setVisible(true);
		modifica.setExtendedState(JFrame.MAXIMIZED_BOTH);
		dispose();
	}

	protected void visualizzaOperazione(String codiceAnagrafica) {
		VisualizzazioneOperazione visualizzaOperazione = new VisualizzazioneOperazione(codiceAnagrafica,
				matricolaDipendente);
		visualizzaOperazione.setUndecorated(true);
		visualizzaOperazione.setVisible(true);
		visualizzaOperazione.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

}
