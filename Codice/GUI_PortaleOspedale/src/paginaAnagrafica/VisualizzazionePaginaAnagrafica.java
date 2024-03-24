package paginaAnagrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.DataService;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;

public class VisualizzazionePaginaAnagrafica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private DataService dataService;
	private String codiceAnagrafica;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzazionePaginaAnagrafica frame = new VisualizzazionePaginaAnagrafica("1", "m001a");
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VisualizzazionePaginaAnagrafica(String codiceAnagrafica, String matricolaMedico) {

		dataService = new DataService();
		this.codiceAnagrafica = codiceAnagrafica;

		String[] valori = dataService.getValoriAnagrafica(codiceAnagrafica, matricolaMedico);

		boolean modificabile = dataService.anagraficaModificabile(codiceAnagrafica, matricolaMedico);

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VisualizzazionePaginaAnagrafica.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale Papa Giovanni XIII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 843);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		if (modificabile) {
			JButton bottoneModifica = new JButton("Modifica");
			bottoneModifica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					enableModifica();
				}
			});
			bottoneModifica.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_bottoneModifica = new GridBagConstraints();
			gbc_bottoneModifica.anchor = GridBagConstraints.WEST;
			gbc_bottoneModifica.insets = new Insets(0, 0, 0, 5);
			gbc_bottoneModifica.gridx = 0;
			gbc_bottoneModifica.gridy = 28;
			contentPane.add(bottoneModifica, gbc_bottoneModifica);
		}

		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 81, 403, 0 };
		gbl_panel.rowHeights = new int[] { 53, 36, 19, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel textPaginaAnagrafica = new JLabel("Pagina anagrafica N. " + codiceAnagrafica);
		GridBagConstraints gbc_textPaginaAnagrafica = new GridBagConstraints();
		gbc_textPaginaAnagrafica.anchor = GridBagConstraints.WEST;
		gbc_textPaginaAnagrafica.fill = GridBagConstraints.VERTICAL;
		gbc_textPaginaAnagrafica.insets = new Insets(0, 0, 5, 0);
		gbc_textPaginaAnagrafica.gridwidth = 2;
		gbc_textPaginaAnagrafica.gridx = 0;
		gbc_textPaginaAnagrafica.gridy = 0;
		panel.add(textPaginaAnagrafica, gbc_textPaginaAnagrafica);
		textPaginaAnagrafica.setFont(new Font("Arial", Font.BOLD, 18));

		JLabel textNome = new JLabel("Nome:");
		GridBagConstraints gbc_textNome = new GridBagConstraints();
		gbc_textNome.anchor = GridBagConstraints.NORTHWEST;
		gbc_textNome.insets = new Insets(0, 0, 5, 5);
		gbc_textNome.gridx = 0;
		gbc_textNome.gridy = 2;
		panel.add(textNome, gbc_textNome);
		textNome.setFont(new Font("Arial", Font.BOLD, 16));

		// ATTENZIONE creare un metodo per settare il nome del paziente all'accesso se
		// proviene da buttone di visualizza e non di crea pagina anagrafica e cosi per
		// ogni dato!!!
		JLabel textNomePaziente = new JLabel();
		GridBagConstraints gbc_textNomePaziente = new GridBagConstraints();
		gbc_textNomePaziente.anchor = GridBagConstraints.SOUTH;
		gbc_textNomePaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomePaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textNomePaziente.gridx = 1;
		gbc_textNomePaziente.gridy = 2;
		panel.add(textNomePaziente, gbc_textNomePaziente);
		textNomePaziente.setText(valori[0]);
		textNomePaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textNomePaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textCognome = new JLabel("Cognome:");
		GridBagConstraints gbc_textCognome = new GridBagConstraints();
		gbc_textCognome.anchor = GridBagConstraints.NORTHWEST;
		gbc_textCognome.insets = new Insets(0, 0, 5, 5);
		gbc_textCognome.gridx = 0;
		gbc_textCognome.gridy = 3;
		panel.add(textCognome, gbc_textCognome);
		textCognome.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textCognomePaziente = new JLabel();
		GridBagConstraints gbc_textCognomePaziente = new GridBagConstraints();
		gbc_textCognomePaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textCognomePaziente.anchor = GridBagConstraints.SOUTH;
		gbc_textCognomePaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCognomePaziente.gridx = 1;
		gbc_textCognomePaziente.gridy = 3;
		panel.add(textCognomePaziente, gbc_textCognomePaziente);
		textCognomePaziente.setText(valori[1]);
		textCognomePaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomePaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textCodiceFiscale = new JLabel("CodiceFiscale:");
		GridBagConstraints gbc_textCodiceFiscale = new GridBagConstraints();
		gbc_textCodiceFiscale.anchor = GridBagConstraints.WEST;
		gbc_textCodiceFiscale.insets = new Insets(0, 0, 5, 5);
		gbc_textCodiceFiscale.gridx = 0;
		gbc_textCodiceFiscale.gridy = 4;
		panel.add(textCodiceFiscale, gbc_textCodiceFiscale);
		textCodiceFiscale.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textCodiceFiscalePaziente = new JLabel();
		GridBagConstraints gbc_textCodiceFiscalePaziente = new GridBagConstraints();
		gbc_textCodiceFiscalePaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textCodiceFiscalePaziente.anchor = GridBagConstraints.WEST;
		gbc_textCodiceFiscalePaziente.gridx = 1;
		gbc_textCodiceFiscalePaziente.gridy = 4;
		panel.add(textCodiceFiscalePaziente, gbc_textCodiceFiscalePaziente);
		textCodiceFiscalePaziente.setText(valori[2]);
		textCodiceFiscalePaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textCodiceFiscalePaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textDataNascita = new JLabel("Data di Nascita (gg/mm/aa):");
		GridBagConstraints gbc_textDataNascita = new GridBagConstraints();
		gbc_textDataNascita.anchor = GridBagConstraints.WEST;
		gbc_textDataNascita.insets = new Insets(0, 0, 5, 5);
		gbc_textDataNascita.gridx = 0;
		gbc_textDataNascita.gridy = 5;
		panel.add(textDataNascita, gbc_textDataNascita);
		textDataNascita.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textDataNascitaPaziente = new JLabel();
		GridBagConstraints gbc_textDataNascitaPaziente = new GridBagConstraints();
		gbc_textDataNascitaPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textDataNascitaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textDataNascitaPaziente.gridx = 1;
		gbc_textDataNascitaPaziente.gridy = 5;
		panel.add(textDataNascitaPaziente, gbc_textDataNascitaPaziente);
		textDataNascitaPaziente.setText(valori[3] + "/" + valori[4] + "/" + valori[5]);
		textDataNascitaPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textDataNascitaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textLuogodiNascita = new JLabel("Luogo di Nascita:");
		GridBagConstraints gbc_textLuogodiNascita = new GridBagConstraints();
		gbc_textLuogodiNascita.anchor = GridBagConstraints.WEST;
		gbc_textLuogodiNascita.insets = new Insets(0, 0, 5, 5);
		gbc_textLuogodiNascita.gridx = 0;
		gbc_textLuogodiNascita.gridy = 6;
		panel.add(textLuogodiNascita, gbc_textLuogodiNascita);
		textLuogodiNascita.setHorizontalAlignment(SwingConstants.LEFT);
		textLuogodiNascita.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textLuogodiNascitaPaziente = new JLabel();
		GridBagConstraints gbc_textLuogodiNascitaPaziente = new GridBagConstraints();
		gbc_textLuogodiNascitaPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textLuogodiNascitaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textLuogodiNascitaPaziente.gridx = 1;
		gbc_textLuogodiNascitaPaziente.gridy = 6;
		panel.add(textLuogodiNascitaPaziente, gbc_textLuogodiNascitaPaziente);
		textLuogodiNascitaPaziente.setText(valori[6]);
		textLuogodiNascitaPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textLuogodiNascitaPaziente.setForeground(Color.BLACK);
		textLuogodiNascitaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textCitta = new JLabel("Citta' di residenza:");
		GridBagConstraints gbc_textCitta = new GridBagConstraints();
		gbc_textCitta.anchor = GridBagConstraints.WEST;
		gbc_textCitta.insets = new Insets(0, 0, 5, 5);
		gbc_textCitta.gridx = 0;
		gbc_textCitta.gridy = 7;
		panel.add(textCitta, gbc_textCitta);
		textCitta.setHorizontalAlignment(SwingConstants.LEFT);
		textCitta.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textCittaPaziente = new JLabel();
		GridBagConstraints gbc_textCittaPaziente = new GridBagConstraints();
		gbc_textCittaPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textCittaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textCittaPaziente.gridx = 1;
		gbc_textCittaPaziente.gridy = 7;
		panel.add(textCittaPaziente, gbc_textCittaPaziente);
		textCittaPaziente.setText(valori[7]);
		textCittaPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textCittaPaziente.setForeground(Color.BLACK);
		textCittaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textIndirizzo = new JLabel("Indirizzo di residenza:");
		GridBagConstraints gbc_textIndirizzo = new GridBagConstraints();
		gbc_textIndirizzo.anchor = GridBagConstraints.WEST;
		gbc_textIndirizzo.insets = new Insets(0, 0, 5, 5);
		gbc_textIndirizzo.gridx = 0;
		gbc_textIndirizzo.gridy = 8;
		panel.add(textIndirizzo, gbc_textIndirizzo);
		textIndirizzo.setHorizontalAlignment(SwingConstants.LEFT);
		textIndirizzo.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textIndirizzoPaziente = new JLabel();
		GridBagConstraints gbc_textIndirizzoPaziente = new GridBagConstraints();
		gbc_textIndirizzoPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textIndirizzoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textIndirizzoPaziente.gridx = 1;
		gbc_textIndirizzoPaziente.gridy = 8;
		panel.add(textIndirizzoPaziente, gbc_textIndirizzoPaziente);
		textIndirizzoPaziente.setText(valori[8]);
		textIndirizzoPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textIndirizzoPaziente.setForeground(Color.BLACK);
		textIndirizzoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textNumerodiTelefono = new JLabel("Telefono:");
		GridBagConstraints gbc_textNumerodiTelefono = new GridBagConstraints();
		gbc_textNumerodiTelefono.anchor = GridBagConstraints.WEST;
		gbc_textNumerodiTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textNumerodiTelefono.gridx = 0;
		gbc_textNumerodiTelefono.gridy = 9;
		panel.add(textNumerodiTelefono, gbc_textNumerodiTelefono);
		textNumerodiTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		textNumerodiTelefono.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textNumeroTelefonoPaziente = new JLabel();
		GridBagConstraints gbc_textNumeroTelefonoPaziente = new GridBagConstraints();
		gbc_textNumeroTelefonoPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textNumeroTelefonoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textNumeroTelefonoPaziente.gridx = 1;
		gbc_textNumeroTelefonoPaziente.gridy = 9;
		panel.add(textNumeroTelefonoPaziente, gbc_textNumeroTelefonoPaziente);
		textNumeroTelefonoPaziente.setText(valori[9]);
		textNumeroTelefonoPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textNumeroTelefonoPaziente.setForeground(Color.BLACK);
		textNumeroTelefonoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textEmail = new JLabel("e-Mail:");
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.anchor = GridBagConstraints.WEST;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.gridx = 0;
		gbc_textEmail.gridy = 10;
		panel.add(textEmail, gbc_textEmail);
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textEmailPaziente = new JLabel();
		GridBagConstraints gbc_textEmailPaziente = new GridBagConstraints();
		gbc_textEmailPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textEmailPaziente.anchor = GridBagConstraints.WEST;
		gbc_textEmailPaziente.gridx = 1;
		gbc_textEmailPaziente.gridy = 10;
		panel.add(textEmailPaziente, gbc_textEmailPaziente);
		textEmailPaziente.setText(valori[10]);
		textEmailPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textEmailPaziente.setForeground(Color.BLACK);
		textEmailPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textDiagnosi = new JLabel("Diagnosi:");
		GridBagConstraints gbc_textDiagnosi = new GridBagConstraints();
		gbc_textDiagnosi.anchor = GridBagConstraints.WEST;
		gbc_textDiagnosi.insets = new Insets(0, 0, 5, 5);
		gbc_textDiagnosi.gridx = 0;
		gbc_textDiagnosi.gridy = 11;
		panel.add(textDiagnosi, gbc_textDiagnosi);
		textDiagnosi.setHorizontalAlignment(SwingConstants.LEFT);
		textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textDiagnosiPaziente = new JLabel();
		GridBagConstraints gbc_textDiagnosiPaziente = new GridBagConstraints();
		gbc_textDiagnosiPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textDiagnosiPaziente.anchor = GridBagConstraints.WEST;
		gbc_textDiagnosiPaziente.gridx = 1;
		gbc_textDiagnosiPaziente.gridy = 11;
		panel.add(textDiagnosiPaziente, gbc_textDiagnosiPaziente);
		textDiagnosiPaziente.setText(valori[11]);
		textDiagnosiPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textIntervento = new JLabel("Intervento:");
		GridBagConstraints gbc_textIntervento = new GridBagConstraints();
		gbc_textIntervento.anchor = GridBagConstraints.WEST;
		gbc_textIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textIntervento.gridx = 0;
		gbc_textIntervento.gridy = 12;
		panel.add(textIntervento, gbc_textIntervento);
		textIntervento.setHorizontalAlignment(SwingConstants.LEFT);
		textIntervento.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textInterventoPaziente = new JLabel();
		GridBagConstraints gbc_textInterventoPaziente = new GridBagConstraints();
		gbc_textInterventoPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textInterventoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textInterventoPaziente.gridx = 1;
		gbc_textInterventoPaziente.gridy = 12;
		panel.add(textInterventoPaziente, gbc_textInterventoPaziente);
		textInterventoPaziente.setText(valori[12]);
		textInterventoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textAnamnesiPregressa = new JLabel("Anamnesi pregressa:");
		GridBagConstraints gbc_textAnamnesiPregressa = new GridBagConstraints();
		gbc_textAnamnesiPregressa.anchor = GridBagConstraints.WEST;
		gbc_textAnamnesiPregressa.insets = new Insets(0, 0, 5, 5);
		gbc_textAnamnesiPregressa.gridx = 0;
		gbc_textAnamnesiPregressa.gridy = 13;
		panel.add(textAnamnesiPregressa, gbc_textAnamnesiPregressa);
		textAnamnesiPregressa.setHorizontalAlignment(SwingConstants.LEFT);
		textAnamnesiPregressa.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textAnamnesiPregressaPaziente = new JLabel();
		GridBagConstraints gbc_textAnamnesiPregressaPaziente = new GridBagConstraints();
		gbc_textAnamnesiPregressaPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textAnamnesiPregressaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textAnamnesiPregressaPaziente.gridx = 1;
		gbc_textAnamnesiPregressaPaziente.gridy = 13;
		panel.add(textAnamnesiPregressaPaziente, gbc_textAnamnesiPregressaPaziente);
		textAnamnesiPregressaPaziente.setText(valori[13]);
		textAnamnesiPregressaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textAnamnesiPossima = new JLabel("Anamnesi prossima:");
		GridBagConstraints gbc_textAnamnesiPossima = new GridBagConstraints();
		gbc_textAnamnesiPossima.anchor = GridBagConstraints.WEST;
		gbc_textAnamnesiPossima.insets = new Insets(0, 0, 5, 5);
		gbc_textAnamnesiPossima.gridx = 0;
		gbc_textAnamnesiPossima.gridy = 14;
		panel.add(textAnamnesiPossima, gbc_textAnamnesiPossima);
		textAnamnesiPossima.setHorizontalAlignment(SwingConstants.LEFT);
		textAnamnesiPossima.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textAnamnesiProssimaPaziente = new JLabel();
		GridBagConstraints gbc_textAnamnesiProssimaPaziente = new GridBagConstraints();
		gbc_textAnamnesiProssimaPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textAnamnesiProssimaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textAnamnesiProssimaPaziente.gridx = 1;
		gbc_textAnamnesiProssimaPaziente.gridy = 14;
		panel.add(textAnamnesiProssimaPaziente, gbc_textAnamnesiProssimaPaziente);
		textAnamnesiProssimaPaziente.setText(valori[14]);
		textAnamnesiProssimaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textTempodiAttesa = new JLabel("Tempo di attesa:");
		GridBagConstraints gbc_textTempodiAttesa = new GridBagConstraints();
		gbc_textTempodiAttesa.anchor = GridBagConstraints.WEST;
		gbc_textTempodiAttesa.insets = new Insets(0, 0, 5, 5);
		gbc_textTempodiAttesa.gridx = 0;
		gbc_textTempodiAttesa.gridy = 15;
		panel.add(textTempodiAttesa, gbc_textTempodiAttesa);
		textTempodiAttesa.setHorizontalAlignment(SwingConstants.LEFT);
		textTempodiAttesa.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textTempodiAttesaPaziente = new JLabel();
		GridBagConstraints gbc_textTempodiAttesaPaziente = new GridBagConstraints();
		gbc_textTempodiAttesaPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textTempodiAttesaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textTempodiAttesaPaziente.gridx = 1;
		gbc_textTempodiAttesaPaziente.gridy = 15;
		panel.add(textTempodiAttesaPaziente, gbc_textTempodiAttesaPaziente);
		textTempodiAttesaPaziente.setText(valori[15]);
		textTempodiAttesaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textDatiMedico = new JLabel("Dati medico che ha richiesto intervento");
		GridBagConstraints gbc_textDatiMedico = new GridBagConstraints();
		gbc_textDatiMedico.insets = new Insets(0, 0, 5, 0);
		gbc_textDatiMedico.anchor = GridBagConstraints.WEST;
		gbc_textDatiMedico.gridwidth = 2;
		gbc_textDatiMedico.gridx = 0;
		gbc_textDatiMedico.gridy = 17;
		panel.add(textDatiMedico, gbc_textDatiMedico);
		textDatiMedico.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textNome_1 = new JLabel("Nome:");
		GridBagConstraints gbc_textNome_1 = new GridBagConstraints();
		gbc_textNome_1.anchor = GridBagConstraints.WEST;
		gbc_textNome_1.insets = new Insets(0, 0, 5, 5);
		gbc_textNome_1.gridx = 0;
		gbc_textNome_1.gridy = 18;
		panel.add(textNome_1, gbc_textNome_1);
		textNome_1.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textNomeMedico = new JLabel();
		GridBagConstraints gbc_textNomeMedico = new GridBagConstraints();
		gbc_textNomeMedico.anchor = GridBagConstraints.WEST;
		gbc_textNomeMedico.insets = new Insets(0, 0, 5, 0);
		gbc_textNomeMedico.gridx = 1;
		gbc_textNomeMedico.gridy = 18;
		panel.add(textNomeMedico, gbc_textNomeMedico);
		textNomeMedico.setText(dataService.getNomeDipendente(valori[16]));
		textNomeMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeMedico.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textCognome_1 = new JLabel("Cognome:");
		GridBagConstraints gbc_textCognome_1 = new GridBagConstraints();
		gbc_textCognome_1.anchor = GridBagConstraints.WEST;
		gbc_textCognome_1.insets = new Insets(0, 0, 5, 5);
		gbc_textCognome_1.gridx = 0;
		gbc_textCognome_1.gridy = 19;
		panel.add(textCognome_1, gbc_textCognome_1);
		textCognome_1.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textCognomeMedico = new JLabel();
		GridBagConstraints gbc_textCognomeMedico = new GridBagConstraints();
		gbc_textCognomeMedico.anchor = GridBagConstraints.WEST;
		gbc_textCognomeMedico.insets = new Insets(0, 0, 5, 0);
		gbc_textCognomeMedico.gridx = 1;
		gbc_textCognomeMedico.gridy = 19;
		panel.add(textCognomeMedico, gbc_textCognomeMedico);
		textCognomeMedico.setText(dataService.getCognomeDipendente(valori[16]));
		textCognomeMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeMedico.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textMatricola = new JLabel("Matricola:");
		GridBagConstraints gbc_textMatricola = new GridBagConstraints();
		gbc_textMatricola.anchor = GridBagConstraints.WEST;
		gbc_textMatricola.insets = new Insets(0, 0, 5, 5);
		gbc_textMatricola.gridx = 0;
		gbc_textMatricola.gridy = 20;
		panel.add(textMatricola, gbc_textMatricola);
		textMatricola.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textMatricolaMedico = new JLabel();
		GridBagConstraints gbc_textMatricolaMedico = new GridBagConstraints();
		gbc_textMatricolaMedico.anchor = GridBagConstraints.WEST;
		gbc_textMatricolaMedico.insets = new Insets(0, 0, 5, 0);
		gbc_textMatricolaMedico.gridx = 1;
		gbc_textMatricolaMedico.gridy = 20;
		panel.add(textMatricolaMedico, gbc_textMatricolaMedico);
		textMatricolaMedico.setText(valori[16]);
		textMatricolaMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textMatricolaMedico.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel textNote = new JLabel("Note:");
		GridBagConstraints gbc_textNote = new GridBagConstraints();
		gbc_textNote.anchor = GridBagConstraints.WEST;
		gbc_textNote.insets = new Insets(0, 0, 5, 5);
		gbc_textNote.gridx = 0;
		gbc_textNote.gridy = 21;
		panel.add(textNote, gbc_textNote);
		textNote.setHorizontalAlignment(SwingConstants.LEFT);
		textNote.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel textNotePaziente = new JLabel();
		GridBagConstraints gbc_textNotePaziente = new GridBagConstraints();
		gbc_textNotePaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textNotePaziente.anchor = GridBagConstraints.WEST;
		gbc_textNotePaziente.gridx = 1;
		gbc_textNotePaziente.gridy = 21;
		panel.add(textNotePaziente, gbc_textNotePaziente);
		textNotePaziente.setText(valori[17]);
		textNotePaziente.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton bottoneChiudi = new JButton("Chiudi");
		bottoneChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 23;
		panel.add(bottoneChiudi, gbc_btnNewButton);

	}

	protected void enableModifica() {
		ModificaPaginaAnagrafica modificaAnagrafica = new ModificaPaginaAnagrafica(codiceAnagrafica, "", false);
		modificaAnagrafica.setUndecorated(true);
		modificaAnagrafica.setVisible(true);
		modificaAnagrafica.setExtendedState(JFrame.MAXIMIZED_BOTH);
		dispose();

	}
}
