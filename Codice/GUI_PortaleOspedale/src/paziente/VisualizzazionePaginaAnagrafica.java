package paziente;

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

public class VisualizzazionePaginaAnagrafica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private DataService dataService;
	private String codiceAnagrafica;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzazionePaginaAnagrafica frame = new VisualizzazionePaginaAnagrafica("1", "m001a", false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VisualizzazionePaginaAnagrafica(String codiceAnagrafica, String matricolaMedico, boolean modifica) {
		
		dataService = new DataService();
		this.codiceAnagrafica = codiceAnagrafica;
		modifica = modifica && matricolaMedico.equals(dataService.getMatrMedicoAnagrafica(codiceAnagrafica));
		
		String[] valori = dataService.getValoriAnagrafica(codiceAnagrafica, matricolaMedico);
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzazionePaginaAnagrafica.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale Papa Giovanni XIII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 843);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{148, 35, 408, 0};
		gbl_contentPane.rowHeights = new int[]{58, 35, 19, 23, 29, 19, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 0, 0, 0, 0, 0, 0, 0, 0, 62, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textPaginaAnagrafica = new JLabel("Pagina anagrafica N. " + codiceAnagrafica);
		textPaginaAnagrafica.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textPaginaAnagrafica = new GridBagConstraints();
		gbc_textPaginaAnagrafica.gridwidth = 3;
		gbc_textPaginaAnagrafica.anchor = GridBagConstraints.WEST;
		gbc_textPaginaAnagrafica.fill = GridBagConstraints.VERTICAL;
		gbc_textPaginaAnagrafica.insets = new Insets(0, 0, 5, 5);
		gbc_textPaginaAnagrafica.gridx = 0;
		gbc_textPaginaAnagrafica.gridy = 0;
		contentPane.add(textPaginaAnagrafica, gbc_textPaginaAnagrafica);
		
		JLabel textNome = new JLabel("Nome:");
		textNome.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNome = new GridBagConstraints();
		gbc_textNome.anchor = GridBagConstraints.NORTHWEST;
		gbc_textNome.insets = new Insets(0, 0, 5, 5);
		gbc_textNome.gridx = 0;
		gbc_textNome.gridy = 2;
		contentPane.add(textNome, gbc_textNome);
		
		//ATTENZIONE creare un metodo per settare il nome del paziente all'accesso se proviene da buttone di visualizza e non di crea pagina anagrafica e cosi per ogni dato!!!
		JLabel textNomePaziente = new JLabel();
		textNomePaziente.setText(valori[0]);
		textNomePaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textNomePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNomePaziente = new GridBagConstraints();
		gbc_textNomePaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomePaziente.anchor = GridBagConstraints.NORTH;
		gbc_textNomePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textNomePaziente.gridx = 2;
		gbc_textNomePaziente.gridy = 2;
		contentPane.add(textNomePaziente, gbc_textNomePaziente);
		
		JLabel textCognome = new JLabel("Cognome:");
		textCognome.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textCognome = new GridBagConstraints();
		gbc_textCognome.anchor = GridBagConstraints.NORTHWEST;
		gbc_textCognome.insets = new Insets(0, 0, 5, 5);
		gbc_textCognome.gridx = 0;
		gbc_textCognome.gridy = 3;
		contentPane.add(textCognome, gbc_textCognome);
		
		JLabel textCognomePaziente = new JLabel();
		textCognomePaziente.setText(valori[1]);
		textCognomePaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textCognomePaziente = new GridBagConstraints();
		gbc_textCognomePaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCognomePaziente.anchor = GridBagConstraints.NORTH;
		gbc_textCognomePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textCognomePaziente.gridx = 2;
		gbc_textCognomePaziente.gridy = 3;
		contentPane.add(textCognomePaziente, gbc_textCognomePaziente);
		
		JLabel textCodiceFiscale = new JLabel("CodiceFiscale:");
		textCodiceFiscale.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textCodiceFiscale = new GridBagConstraints();
		gbc_textCodiceFiscale.anchor = GridBagConstraints.NORTHWEST;
		gbc_textCodiceFiscale.insets = new Insets(0, 0, 5, 5);
		gbc_textCodiceFiscale.gridx = 0;
		gbc_textCodiceFiscale.gridy = 4;
		contentPane.add(textCodiceFiscale, gbc_textCodiceFiscale);
		
		JLabel textCodiceFiscalePaziente = new JLabel();
		textCodiceFiscalePaziente.setText(valori[2]);
		textCodiceFiscalePaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textCodiceFiscalePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textCodiceFiscalePaziente = new GridBagConstraints();
		gbc_textCodiceFiscalePaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCodiceFiscalePaziente.anchor = GridBagConstraints.NORTH;
		gbc_textCodiceFiscalePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textCodiceFiscalePaziente.gridx = 2;
		gbc_textCodiceFiscalePaziente.gridy = 4;
		contentPane.add(textCodiceFiscalePaziente, gbc_textCodiceFiscalePaziente);
		
		JLabel textDataNascita = new JLabel("Data di Nascita (gg/mm/aa):");
		textDataNascita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDataNascita = new GridBagConstraints();
		gbc_textDataNascita.anchor = GridBagConstraints.WEST;
		gbc_textDataNascita.insets = new Insets(0, 0, 5, 5);
		gbc_textDataNascita.gridx = 0;
		gbc_textDataNascita.gridy = 5;
		contentPane.add(textDataNascita, gbc_textDataNascita);
		
		JLabel textDataNascitaPaziente = new JLabel();
		textDataNascitaPaziente.setText(valori[3] + "/" + valori[4] + "/" + valori[5]);
		textDataNascitaPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textDataNascitaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textDatadiNascitaPaziente = new GridBagConstraints();
		gbc_textDatadiNascitaPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDatadiNascitaPaziente.anchor = GridBagConstraints.NORTH;
		gbc_textDatadiNascitaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textDatadiNascitaPaziente.gridx = 2;
		gbc_textDatadiNascitaPaziente.gridy = 5;
		contentPane.add(textDataNascitaPaziente, gbc_textDatadiNascitaPaziente);
		
		JLabel textLuogodiNascita = new JLabel("Luogo di Nascita:");
		textLuogodiNascita.setHorizontalAlignment(SwingConstants.LEFT);
		textLuogodiNascita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textLuogodiNascita = new GridBagConstraints();
		gbc_textLuogodiNascita.anchor = GridBagConstraints.WEST;
		gbc_textLuogodiNascita.insets = new Insets(0, 0, 5, 5);
		gbc_textLuogodiNascita.gridx = 0;
		gbc_textLuogodiNascita.gridy = 6;
		contentPane.add(textLuogodiNascita, gbc_textLuogodiNascita);
		
		JLabel textLuogodiNascitaPaziente = new JLabel();
		textLuogodiNascitaPaziente.setText(valori[6]);
		textLuogodiNascitaPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textLuogodiNascitaPaziente.setForeground(Color.BLACK);
		textLuogodiNascitaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textLuogodiNascitaPaziente = new GridBagConstraints();
		gbc_textLuogodiNascitaPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLuogodiNascitaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textLuogodiNascitaPaziente.gridx = 2;
		gbc_textLuogodiNascitaPaziente.gridy = 6;
		contentPane.add(textLuogodiNascitaPaziente, gbc_textLuogodiNascitaPaziente);
		
		JLabel textCitta = new JLabel("Citta' di residenza:");
		textCitta.setHorizontalAlignment(SwingConstants.LEFT);
		textCitta.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textCitta = new GridBagConstraints();
		gbc_textCitta.anchor = GridBagConstraints.WEST;
		gbc_textCitta.insets = new Insets(0, 0, 5, 5);
		gbc_textCitta.gridx = 0;
		gbc_textCitta.gridy = 7;
		contentPane.add(textCitta, gbc_textCitta);
		
		JLabel textCittaPaziente = new JLabel();
		textCittaPaziente.setText(valori[7]);
		textCittaPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textCittaPaziente.setForeground(Color.BLACK);
		textCittaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textcittaPaziente = new GridBagConstraints();
		gbc_textcittaPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcittaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textcittaPaziente.gridx = 2;
		gbc_textcittaPaziente.gridy = 7;
		contentPane.add(textCittaPaziente, gbc_textcittaPaziente);

		JLabel textIndirizzo = new JLabel("Indirizzo di residenza:");
		textIndirizzo.setHorizontalAlignment(SwingConstants.LEFT);
		textIndirizzo.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textIndirizzo = new GridBagConstraints();
		gbc_textIndirizzo.anchor = GridBagConstraints.WEST;
		gbc_textIndirizzo.insets = new Insets(0, 0, 5, 5);
		gbc_textIndirizzo.gridx = 0;
		gbc_textIndirizzo.gridy = 8;
		contentPane.add(textIndirizzo, gbc_textIndirizzo);
		
		JLabel textIndirizzoPaziente = new JLabel();
		textIndirizzoPaziente.setText(valori[8]);
		textIndirizzoPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textIndirizzoPaziente.setForeground(Color.BLACK);
		textIndirizzoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textIndirizzoPaziente = new GridBagConstraints();
		gbc_textIndirizzoPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textIndirizzoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textIndirizzoPaziente.gridx = 2;
		gbc_textIndirizzoPaziente.gridy = 8;
		contentPane.add(textIndirizzoPaziente, gbc_textIndirizzoPaziente);

		
		JLabel textNumerodiTelefono = new JLabel("Telefono:");
		textNumerodiTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		textNumerodiTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNumerodiTelefono = new GridBagConstraints();
		gbc_textNumerodiTelefono.anchor = GridBagConstraints.WEST;
		gbc_textNumerodiTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textNumerodiTelefono.gridx = 0;
		gbc_textNumerodiTelefono.gridy = 9;
		contentPane.add(textNumerodiTelefono, gbc_textNumerodiTelefono);
		
		JLabel textNumeroTelefonoPaziente = new JLabel();
		textNumeroTelefonoPaziente.setText(valori[9]);
		textNumeroTelefonoPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textNumeroTelefonoPaziente.setForeground(Color.BLACK);
		textNumeroTelefonoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNumeroTelefonoPaziente = new GridBagConstraints();
		gbc_textNumeroTelefonoPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumeroTelefonoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textNumeroTelefonoPaziente.gridx = 2;
		gbc_textNumeroTelefonoPaziente.gridy = 9;
		contentPane.add(textNumeroTelefonoPaziente, gbc_textNumeroTelefonoPaziente);
		
		JLabel textEmail = new JLabel("e-Mail:");
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.anchor = GridBagConstraints.WEST;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.gridx = 0;
		gbc_textEmail.gridy = 10;
		contentPane.add(textEmail, gbc_textEmail);
		
		JLabel textEmailPaziente = new JLabel();
		textEmailPaziente.setText(valori[10]);
		textEmailPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textEmailPaziente.setForeground(Color.BLACK);
		textEmailPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textEmailPaziente = new GridBagConstraints();
		gbc_textEmailPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmailPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textEmailPaziente.gridx = 2;
		gbc_textEmailPaziente.gridy = 10;
		contentPane.add(textEmailPaziente, gbc_textEmailPaziente);
		
		JLabel textDiagnosi = new JLabel("Diagnosi:");
		textDiagnosi.setHorizontalAlignment(SwingConstants.LEFT);
		textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDiagnosi = new GridBagConstraints();
		gbc_textDiagnosi.anchor = GridBagConstraints.NORTHWEST;
		gbc_textDiagnosi.insets = new Insets(0, 0, 5, 5);
		gbc_textDiagnosi.gridx = 0;
		gbc_textDiagnosi.gridy = 11;
		contentPane.add(textDiagnosi, gbc_textDiagnosi);
		
		JLabel textDiagnosiPaziente = new JLabel();
		textDiagnosiPaziente.setText(valori[11]);
		textDiagnosiPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textDiagnosiPaziente = new GridBagConstraints();
		gbc_textDiagnosiPaziente.gridheight = 2;
		gbc_textDiagnosiPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textDiagnosiPaziente.fill = GridBagConstraints.BOTH;
		gbc_textDiagnosiPaziente.gridx = 2;
		gbc_textDiagnosiPaziente.gridy = 11;
		contentPane.add(textDiagnosiPaziente, gbc_textDiagnosiPaziente);
		
		JLabel textIntervento = new JLabel("Intervento:");
		textIntervento.setHorizontalAlignment(SwingConstants.LEFT);
		textIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textIntervento = new GridBagConstraints();
		gbc_textIntervento.anchor = GridBagConstraints.NORTHWEST;
		gbc_textIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textIntervento.gridx = 0;
		gbc_textIntervento.gridy = 13;
		contentPane.add(textIntervento, gbc_textIntervento);
		
		JLabel textInterventoPaziente = new JLabel();
		textInterventoPaziente.setText(valori[12]);
		textInterventoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textInterventoPaziente = new GridBagConstraints();
		gbc_textInterventoPaziente.gridheight = 2;
		gbc_textInterventoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textInterventoPaziente.fill = GridBagConstraints.BOTH;
		gbc_textInterventoPaziente.gridx = 2;
		gbc_textInterventoPaziente.gridy = 13;
		contentPane.add(textInterventoPaziente, gbc_textInterventoPaziente);
		
		JLabel textAnamnesiPregressa = new JLabel("Anamnesi pregressa:");
		textAnamnesiPregressa.setHorizontalAlignment(SwingConstants.LEFT);
		textAnamnesiPregressa.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textAnamnesiPregressa = new GridBagConstraints();
		gbc_textAnamnesiPregressa.anchor = GridBagConstraints.NORTHWEST;
		gbc_textAnamnesiPregressa.insets = new Insets(0, 0, 5, 5);
		gbc_textAnamnesiPregressa.gridx = 0;
		gbc_textAnamnesiPregressa.gridy = 15;
		contentPane.add(textAnamnesiPregressa, gbc_textAnamnesiPregressa);
		
		JLabel textAnamnesiPregressaPaziente = new JLabel();
		textAnamnesiPregressaPaziente.setText(valori[13]);
		textAnamnesiPregressaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textAnamnesiPregressaPaziente = new GridBagConstraints();
		gbc_textAnamnesiPregressaPaziente.gridheight = 2;
		gbc_textAnamnesiPregressaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textAnamnesiPregressaPaziente.fill = GridBagConstraints.BOTH;
		gbc_textAnamnesiPregressaPaziente.gridx = 2;
		gbc_textAnamnesiPregressaPaziente.gridy = 15;
		contentPane.add(textAnamnesiPregressaPaziente, gbc_textAnamnesiPregressaPaziente);
		
		JLabel textAnamnesiPossima = new JLabel("Anamnesi prossima:");
		textAnamnesiPossima.setHorizontalAlignment(SwingConstants.LEFT);
		textAnamnesiPossima.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textAnamnesiPossima = new GridBagConstraints();
		gbc_textAnamnesiPossima.anchor = GridBagConstraints.NORTHWEST;
		gbc_textAnamnesiPossima.insets = new Insets(0, 0, 5, 5);
		gbc_textAnamnesiPossima.gridx = 0;
		gbc_textAnamnesiPossima.gridy = 17;
		contentPane.add(textAnamnesiPossima, gbc_textAnamnesiPossima);
		
		JLabel textAnamnesiProssimaPaziente = new JLabel();
		textAnamnesiProssimaPaziente.setText(valori[14]);
		textAnamnesiProssimaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textAnamnesiProssimaPaziente = new GridBagConstraints();
		gbc_textAnamnesiProssimaPaziente.gridheight = 2;
		gbc_textAnamnesiProssimaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textAnamnesiProssimaPaziente.fill = GridBagConstraints.BOTH;
		gbc_textAnamnesiProssimaPaziente.gridx = 2;
		gbc_textAnamnesiProssimaPaziente.gridy = 17;
		contentPane.add(textAnamnesiProssimaPaziente, gbc_textAnamnesiProssimaPaziente);
		
		JLabel textTempodiAttesa = new JLabel("Tempo di attesa:");
		textTempodiAttesa.setHorizontalAlignment(SwingConstants.LEFT);
		textTempodiAttesa.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTempodiAttesa = new GridBagConstraints();
		gbc_textTempodiAttesa.anchor = GridBagConstraints.WEST;
		gbc_textTempodiAttesa.insets = new Insets(0, 0, 5, 5);
		gbc_textTempodiAttesa.gridx = 0;
		gbc_textTempodiAttesa.gridy = 19;
		contentPane.add(textTempodiAttesa, gbc_textTempodiAttesa);
		
		JLabel textTempodiAttesaPaziente = new JLabel();
		textTempodiAttesaPaziente.setText(valori[15]);
		textTempodiAttesaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textTempodiAttesaPaziente = new GridBagConstraints();
		gbc_textTempodiAttesaPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTempodiAttesaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textTempodiAttesaPaziente.gridx = 2;
		gbc_textTempodiAttesaPaziente.gridy = 19;
		contentPane.add(textTempodiAttesaPaziente, gbc_textTempodiAttesaPaziente);
		
		JLabel textDatiMedico = new JLabel("Dati medico che ha richiesto intervento");
		textDatiMedico.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDatiMedico = new GridBagConstraints();
		gbc_textDatiMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDatiMedico.gridwidth = 4;
		gbc_textDatiMedico.insets = new Insets(0, 0, 5, 0);
		gbc_textDatiMedico.gridx = 0;
		gbc_textDatiMedico.gridy = 21;
		contentPane.add(textDatiMedico, gbc_textDatiMedico);
		
		JLabel textNome_1 = new JLabel("Nome:");
		textNome_1.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNome_1 = new GridBagConstraints();
		gbc_textNome_1.anchor = GridBagConstraints.WEST;
		gbc_textNome_1.insets = new Insets(0, 0, 5, 5);
		gbc_textNome_1.gridx = 0;
		gbc_textNome_1.gridy = 23;
		contentPane.add(textNome_1, gbc_textNome_1);
		
		JLabel textNomeMedico = new JLabel();
		textNomeMedico.setText(dataService.getNomeDipendente(valori[16]));
		textNomeMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeMedico.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNomeMedico = new GridBagConstraints();
		gbc_textNomeMedico.insets = new Insets(0, 0, 5, 5);
		gbc_textNomeMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomeMedico.gridx = 2;
		gbc_textNomeMedico.gridy = 23;
		contentPane.add(textNomeMedico, gbc_textNomeMedico);
		
		JLabel textCognome_1 = new JLabel("Cognome:");
		textCognome_1.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textCognome_1 = new GridBagConstraints();
		gbc_textCognome_1.anchor = GridBagConstraints.WEST;
		gbc_textCognome_1.insets = new Insets(0, 0, 5, 5);
		gbc_textCognome_1.gridx = 0;
		gbc_textCognome_1.gridy = 24;
		contentPane.add(textCognome_1, gbc_textCognome_1);
		
		JLabel textCognomeMedico = new JLabel();
		textCognomeMedico.setText(dataService.getCognomeDipendente(valori[16]));
		textCognomeMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeMedico.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textCognomeMedico = new GridBagConstraints();
		gbc_textCognomeMedico.insets = new Insets(0, 0, 5, 5);
		gbc_textCognomeMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCognomeMedico.gridx = 2;
		gbc_textCognomeMedico.gridy = 24;
		contentPane.add(textCognomeMedico, gbc_textCognomeMedico);
		
		JLabel textMatricola = new JLabel("Matrciola:");
		textMatricola.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textMatricola = new GridBagConstraints();
		gbc_textMatricola.anchor = GridBagConstraints.WEST;
		gbc_textMatricola.insets = new Insets(0, 0, 5, 5);
		gbc_textMatricola.gridx = 0;
		gbc_textMatricola.gridy = 25;
		contentPane.add(textMatricola, gbc_textMatricola);
		
		JLabel textMatricolaMedico = new JLabel();
		textMatricolaMedico.setText(valori[16]);
		textMatricolaMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textMatricolaMedico.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textMatricolaMedico = new GridBagConstraints();
		gbc_textMatricolaMedico.insets = new Insets(0, 0, 5, 5);
		gbc_textMatricolaMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMatricolaMedico.gridx = 2;
		gbc_textMatricolaMedico.gridy = 25;
		contentPane.add(textMatricolaMedico, gbc_textMatricolaMedico);
		
		
		JButton bottoneModifica = new JButton("Modifica");
		bottoneModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableModifica();
			}
		});
		
		JLabel textNote = new JLabel("Note:");
		textNote.setHorizontalAlignment(SwingConstants.LEFT);
		textNote.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNote = new GridBagConstraints();
		gbc_textNote.anchor = GridBagConstraints.WEST;
		gbc_textNote.insets = new Insets(0, 0, 5, 5);
		gbc_textNote.gridx = 0;
		gbc_textNote.gridy = 27;
		contentPane.add(textNote, gbc_textNote);
		
		
		JLabel textNotePaziente = new JLabel();
		textNotePaziente.setText(valori[17]);
		textNotePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNotePaziente = new GridBagConstraints();
		gbc_textNotePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textNotePaziente.fill = GridBagConstraints.BOTH;
		gbc_textNotePaziente.gridx = 2;
		gbc_textNotePaziente.gridy = 27;
		contentPane.add(textNotePaziente, gbc_textNotePaziente);
		bottoneModifica.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneModifica = new GridBagConstraints();
		gbc_bottoneModifica.anchor = GridBagConstraints.WEST;
		gbc_bottoneModifica.insets = new Insets(0, 0, 0, 5);
		gbc_bottoneModifica.gridx = 0;
		gbc_bottoneModifica.gridy = 28;
		contentPane.add(bottoneModifica, gbc_bottoneModifica);		
		
		JButton bottoneChiudi = new JButton("Chiudi");
		bottoneChiudi.setVisible(true);
		bottoneChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bottoneChiudi.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneChiudi = new GridBagConstraints();
		gbc_bottoneChiudi.anchor = GridBagConstraints.WEST;
		gbc_bottoneChiudi.gridwidth = 2;
		gbc_bottoneChiudi.gridx = 2;
		gbc_bottoneChiudi.gridy = 28;
		contentPane.add(bottoneChiudi, gbc_bottoneChiudi);
				
		
	}
	

	protected void enableModifica() {
		ModificaPaginaAnagrafica modificaAnagrafica= new ModificaPaginaAnagrafica(codiceAnagrafica, "",false);
		modificaAnagrafica.setVisible(true);
		dispose();
		
	}
	
}
