package liste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paziente.ModificaVerbale;
import paziente.VisualizzazioneOperazione;

import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import model.DataService;

public class SelezioneOperazione extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String matricolaDipendente;
	private DataService dataService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelezioneOperazione frame = new SelezioneOperazione("m001a");
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
	public SelezioneOperazione(String codiceDipendente) {
		this.matricolaDipendente = codiceDipendente;
		dataService = new DataService();
		
		int contatoreOperazione = dataService.getContatoreCodice("Operazione");
		int posY = 2;
		
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelezioneOperazione.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{340, 178, 0};
		gbl_contentPane.rowHeights = new int[]{19, 33, 23, 23, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textListeOperazioni = new JLabel("Seleziona l'operazione di cui vuoi redigere il verbale:");
		textListeOperazioni.setHorizontalAlignment(SwingConstants.CENTER);
		textListeOperazioni.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textListeOperazioni = new GridBagConstraints();
		gbc_textListeOperazioni.gridwidth = 2;
		gbc_textListeOperazioni.anchor = GridBagConstraints.NORTHWEST;
		gbc_textListeOperazioni.insets = new Insets(0, 0, 5, 0);
		gbc_textListeOperazioni.gridx = 0;
		gbc_textListeOperazioni.gridy = 0;
		contentPane.add(textListeOperazioni, gbc_textListeOperazioni);
		
		for(int i = 1; i <= contatoreOperazione; i++) {
			
			final String codiceOperazione = String.valueOf(i);
			
			if(dataService.esisteOperazione(codiceOperazione) &&
					dataService.getVerbaleAssociato(codiceOperazione).equals("")) {
				
				JButton bottoneOperazione = new JButton("Operazione N. " + i);
				bottoneOperazione.addActionListener(
					new ActionListener() {
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
				contentPane.add(bottoneOperazione, gbc_btnListaOperazione_1);
				
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
				contentPane.add(bottoneSelezione, gbc_btnSelezione);
				
				posY++;
			}
		}
		
		
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnChiudi = new GridBagConstraints();
		gbc_btnChiudi.insets = new Insets(0, 0, 5, 5);
		gbc_btnChiudi.gridx = 0;
		gbc_btnChiudi.gridy = posY+1;
		contentPane.add(btnChiudi, gbc_btnChiudi);
	}

	

	protected void SelezionaOperazione(String codiceAnagrafica) {
		ModificaVerbale modifica = new ModificaVerbale("", matricolaDipendente, codiceAnagrafica);
		modifica.setVisible(true);
		dispose();
	}

	protected void visualizzaOperazione(String codiceAnagrafica) {
		VisualizzazioneOperazione visualizzaOperazione = new VisualizzazioneOperazione(codiceAnagrafica, matricolaDipendente);
		visualizzaOperazione.setVisible(true);
		
	}

}
