package paziente;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.DataService;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;

public class ModificaPaginaAnagrafica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomePaziente;
	private JTextField textCognomePaziente;
	private JTextField textCodiceFiscalePaziente;
	private JTextField textLuogodiNascitaPaziente;
	private JTextField textCittaPaziente;
	private JTextField textIndirizzoPaziente;
	private JTextField textNumeroTelefonoPaziente;
	private JTextField textEmailPaziente;
	private JLabel textMatricolaMedico;
	private JSpinner spinnerTempodiAttesaPaziente;
	private JTextArea textAnamnesiProssimaPaziente;
	private JTextArea textAnamnesiPregressaPaziente;
	private JTextArea textInterventoPaziente;
	private JTextArea textDiagnosiPaziente;
	private JSpinner spinnerGiorno;
	private JSpinner spinnerMese;
	private JSpinner spinnerAnno;
	private JButton bottoneChiudi;
	private JButton bottoneSalva;
	private JTextArea textNotePaziente;
	
	private DataService dataService;
	private String codiceAnagrafica;
	private String matricolaMedico;
	private boolean nuova;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaPaginaAnagrafica frame = new ModificaPaginaAnagrafica("1", "m001a", false);
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ModificaPaginaAnagrafica(String codiceAnagrafica, String matricolaMedico, boolean nuova) {
		
		dataService = new DataService();
		this.matricolaMedico = matricolaMedico;
		this.nuova = nuova;
		String[] valori;
		if(nuova) {
			this.codiceAnagrafica= dataService.generaNuovoCodice("Anagrafica");
			valori = dataService.getValoriAnagrafica("0", matricolaMedico);
		}
		else {
			this.codiceAnagrafica = codiceAnagrafica;
			valori = dataService.getValoriAnagrafica(this.codiceAnagrafica, matricolaMedico);
		}
		
		
		
		 
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaPaginaAnagrafica.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale Papa Giovanni XIII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 843);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				
				JPanel panel = new JPanel();
				scrollPane.setViewportView(panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{208, 36, 403, 0};
				gbl_panel.rowHeights = new int[]{53, 39, 23, 19, 19, 19, 19, 19, 19, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				
				JLabel textPaginaAnagrafica = new JLabel("Pagina anagrafica N. " + this.codiceAnagrafica);
				GridBagConstraints gbc_textPaginaAnagrafica = new GridBagConstraints();
				gbc_textPaginaAnagrafica.anchor = GridBagConstraints.WEST;
				gbc_textPaginaAnagrafica.fill = GridBagConstraints.VERTICAL;
				gbc_textPaginaAnagrafica.insets = new Insets(0, 0, 5, 5);
				gbc_textPaginaAnagrafica.gridx = 0;
				gbc_textPaginaAnagrafica.gridy = 0;
				panel.add(textPaginaAnagrafica, gbc_textPaginaAnagrafica);
				textPaginaAnagrafica.setFont(new Font("Arial", Font.BOLD, 16));
				
				JLabel textNome = new JLabel("Nome:");
				GridBagConstraints gbc_textNome = new GridBagConstraints();
				gbc_textNome.anchor = GridBagConstraints.WEST;
				gbc_textNome.insets = new Insets(0, 0, 5, 5);
				gbc_textNome.gridx = 0;
				gbc_textNome.gridy = 2;
				panel.add(textNome, gbc_textNome);
				textNome.setFont(new Font("Arial", Font.BOLD, 16));
				
				//ATTENZIONE creare un metodo per settare il nome del paziente all'accesso se proviene da buttone di visualizza e non di crea pagina anagrafica e cosi per ogni dato!!!
				textNomePaziente = new JTextField();
				GridBagConstraints gbc_textNomePaziente = new GridBagConstraints();
				gbc_textNomePaziente.anchor = GridBagConstraints.NORTH;
				gbc_textNomePaziente.fill = GridBagConstraints.HORIZONTAL;
				gbc_textNomePaziente.insets = new Insets(0, 0, 5, 0);
				gbc_textNomePaziente.gridx = 2;
				gbc_textNomePaziente.gridy = 2;
				panel.add(textNomePaziente, gbc_textNomePaziente);
				textNomePaziente.setText(valori[0]);
				textNomePaziente.setHorizontalAlignment(SwingConstants.LEFT);
				textNomePaziente.setEditable(true);
				textNomePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
				textNomePaziente.setColumns(10);
				
				JLabel textCognome = new JLabel("Cognome:");
				GridBagConstraints gbc_textCognome = new GridBagConstraints();
				gbc_textCognome.anchor = GridBagConstraints.NORTHWEST;
				gbc_textCognome.insets = new Insets(0, 0, 5, 5);
				gbc_textCognome.gridx = 0;
				gbc_textCognome.gridy = 3;
				panel.add(textCognome, gbc_textCognome);
				textCognome.setFont(new Font("Arial", Font.BOLD, 16));
				
				textCognomePaziente = new JTextField();
				GridBagConstraints gbc_textCognomePaziente = new GridBagConstraints();
				gbc_textCognomePaziente.fill = GridBagConstraints.HORIZONTAL;
				gbc_textCognomePaziente.insets = new Insets(0, 0, 5, 0);
				gbc_textCognomePaziente.gridx = 2;
				gbc_textCognomePaziente.gridy = 3;
				panel.add(textCognomePaziente, gbc_textCognomePaziente);
				textCognomePaziente.setText(valori[1]);
				textCognomePaziente.setHorizontalAlignment(SwingConstants.LEFT);
				textCognomePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
				textCognomePaziente.setEditable(true);
				textCognomePaziente.setColumns(10);
				
				JLabel textCodiceFiscale = new JLabel("CodiceFiscale:");
				GridBagConstraints gbc_textCodiceFiscale = new GridBagConstraints();
				gbc_textCodiceFiscale.anchor = GridBagConstraints.NORTHWEST;
				gbc_textCodiceFiscale.insets = new Insets(0, 0, 5, 5);
				gbc_textCodiceFiscale.gridx = 0;
				gbc_textCodiceFiscale.gridy = 4;
				panel.add(textCodiceFiscale, gbc_textCodiceFiscale);
				textCodiceFiscale.setFont(new Font("Arial", Font.BOLD, 16));
				
				textCodiceFiscalePaziente = new JTextField();
				GridBagConstraints gbc_textCodiceFiscalePaziente = new GridBagConstraints();
				gbc_textCodiceFiscalePaziente.fill = GridBagConstraints.HORIZONTAL;
				gbc_textCodiceFiscalePaziente.insets = new Insets(0, 0, 5, 0);
				gbc_textCodiceFiscalePaziente.gridx = 2;
				gbc_textCodiceFiscalePaziente.gridy = 4;
				panel.add(textCodiceFiscalePaziente, gbc_textCodiceFiscalePaziente);
				textCodiceFiscalePaziente.setText(valori[2]);
				textCodiceFiscalePaziente.setHorizontalAlignment(SwingConstants.LEFT);
				textCodiceFiscalePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
				textCodiceFiscalePaziente.setEditable(true);
				textCodiceFiscalePaziente.setColumns(10);
				
				JLabel textDataNascita = new JLabel("Data di Nascita (gg/mm/aa):");
				GridBagConstraints gbc_textDataNascita = new GridBagConstraints();
				gbc_textDataNascita.anchor = GridBagConstraints.NORTHWEST;
				gbc_textDataNascita.insets = new Insets(0, 0, 5, 5);
				gbc_textDataNascita.gridx = 0;
				gbc_textDataNascita.gridy = 5;
				panel.add(textDataNascita, gbc_textDataNascita);
				textDataNascita.setFont(new Font("Arial", Font.BOLD, 16));
				
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.anchor = GridBagConstraints.WEST;
				gbc_panel_1.insets = new Insets(0, 0, 5, 0);
				gbc_panel_1.fill = GridBagConstraints.VERTICAL;
				gbc_panel_1.gridx = 2;
				gbc_panel_1.gridy = 5;
				panel.add(panel_1, gbc_panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
				
				spinnerGiorno = new JSpinner();
				panel_1.add(spinnerGiorno);
				spinnerGiorno.setEnabled(true);
				spinnerGiorno.setValue(Integer.parseInt(valori[3]));
				spinnerGiorno.setModel(new SpinnerNumberModel(1, 1, 31, 1));
				spinnerGiorno.setFont(new Font("Arial", Font.BOLD, 14));
				
				spinnerMese = new JSpinner();
				panel_1.add(spinnerMese);
				spinnerMese.setValue(Integer.parseInt(valori[4]));
				spinnerMese.setModel(new SpinnerNumberModel(1, 1, 12, 1));
				spinnerMese.setFont(new Font("Arial", Font.BOLD, 14));
				spinnerMese.setEnabled(true);
				
				spinnerAnno = new JSpinner();
				panel_1.add(spinnerAnno);
				spinnerAnno.setValue(Integer.parseInt(valori[5]));
				spinnerAnno.setModel(new SpinnerNumberModel(Integer.valueOf(1800), Integer.valueOf(1800), null, Integer.valueOf(1)));
				spinnerAnno.setFont(new Font("Arial", Font.BOLD, 14));
				spinnerAnno.setEnabled(true);
				
				JLabel textLuogodiNascita = new JLabel("Luogo di Nascita:");
				GridBagConstraints gbc_textLuogodiNascita = new GridBagConstraints();
				gbc_textLuogodiNascita.anchor = GridBagConstraints.NORTHWEST;
				gbc_textLuogodiNascita.insets = new Insets(0, 0, 5, 5);
				gbc_textLuogodiNascita.gridx = 0;
				gbc_textLuogodiNascita.gridy = 6;
				panel.add(textLuogodiNascita, gbc_textLuogodiNascita);
				textLuogodiNascita.setHorizontalAlignment(SwingConstants.LEFT);
				textLuogodiNascita.setFont(new Font("Arial", Font.BOLD, 16));
				
				textLuogodiNascitaPaziente = new JTextField();
				GridBagConstraints gbc_textLuogodiNascitaPaziente = new GridBagConstraints();
				gbc_textLuogodiNascitaPaziente.fill = GridBagConstraints.HORIZONTAL;
				gbc_textLuogodiNascitaPaziente.insets = new Insets(0, 0, 5, 0);
				gbc_textLuogodiNascitaPaziente.gridx = 2;
				gbc_textLuogodiNascitaPaziente.gridy = 6;
				panel.add(textLuogodiNascitaPaziente, gbc_textLuogodiNascitaPaziente);
				textLuogodiNascitaPaziente.setText(valori[6]);
				textLuogodiNascitaPaziente.setHorizontalAlignment(SwingConstants.LEFT);
				textLuogodiNascitaPaziente.setForeground(Color.BLACK);
				textLuogodiNascitaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
				textLuogodiNascitaPaziente.setEditable(true);
				textLuogodiNascitaPaziente.setColumns(10);
				
				JLabel textCitta = new JLabel("Citta' di residenza:");
				GridBagConstraints gbc_textCitta = new GridBagConstraints();
				gbc_textCitta.anchor = GridBagConstraints.NORTHWEST;
				gbc_textCitta.insets = new Insets(0, 0, 5, 5);
				gbc_textCitta.gridx = 0;
				gbc_textCitta.gridy = 7;
				panel.add(textCitta, gbc_textCitta);
				textCitta.setHorizontalAlignment(SwingConstants.LEFT);
				textCitta.setFont(new Font("Arial", Font.BOLD, 16));
				
				textCittaPaziente = new JTextField();
				GridBagConstraints gbc_textCittaPaziente = new GridBagConstraints();
				gbc_textCittaPaziente.fill = GridBagConstraints.HORIZONTAL;
				gbc_textCittaPaziente.insets = new Insets(0, 0, 5, 0);
				gbc_textCittaPaziente.gridx = 2;
				gbc_textCittaPaziente.gridy = 7;
				panel.add(textCittaPaziente, gbc_textCittaPaziente);
				textCittaPaziente.setText(valori[7]);
				textCittaPaziente.setHorizontalAlignment(SwingConstants.LEFT);
				textCittaPaziente.setForeground(Color.BLACK);
				textCittaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
				textCittaPaziente.setEditable(true);
				textCittaPaziente.setColumns(10);
				
						JLabel textIndirizzo = new JLabel("Indirizzo di residenza:");
						GridBagConstraints gbc_textIndirizzo = new GridBagConstraints();
						gbc_textIndirizzo.anchor = GridBagConstraints.NORTHWEST;
						gbc_textIndirizzo.insets = new Insets(0, 0, 5, 5);
						gbc_textIndirizzo.gridx = 0;
						gbc_textIndirizzo.gridy = 8;
						panel.add(textIndirizzo, gbc_textIndirizzo);
						textIndirizzo.setHorizontalAlignment(SwingConstants.LEFT);
						textIndirizzo.setFont(new Font("Arial", Font.BOLD, 16));
						
						textIndirizzoPaziente = new JTextField();
						GridBagConstraints gbc_textIndirizzoPaziente = new GridBagConstraints();
						gbc_textIndirizzoPaziente.fill = GridBagConstraints.HORIZONTAL;
						gbc_textIndirizzoPaziente.insets = new Insets(0, 0, 5, 0);
						gbc_textIndirizzoPaziente.gridx = 2;
						gbc_textIndirizzoPaziente.gridy = 8;
						panel.add(textIndirizzoPaziente, gbc_textIndirizzoPaziente);
						textIndirizzoPaziente.setText(valori[8]);
						textIndirizzoPaziente.setHorizontalAlignment(SwingConstants.LEFT);
						textIndirizzoPaziente.setForeground(Color.BLACK);
						textIndirizzoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
						textIndirizzoPaziente.setEditable(true);
						textIndirizzoPaziente.setColumns(10);
						
								
								JLabel textNumerodiTelefono = new JLabel("Telefono:");
								GridBagConstraints gbc_textNumerodiTelefono = new GridBagConstraints();
								gbc_textNumerodiTelefono.anchor = GridBagConstraints.NORTHWEST;
								gbc_textNumerodiTelefono.insets = new Insets(0, 0, 5, 5);
								gbc_textNumerodiTelefono.gridx = 0;
								gbc_textNumerodiTelefono.gridy = 9;
								panel.add(textNumerodiTelefono, gbc_textNumerodiTelefono);
								textNumerodiTelefono.setHorizontalAlignment(SwingConstants.LEFT);
								textNumerodiTelefono.setFont(new Font("Arial", Font.BOLD, 16));
								
								textNumeroTelefonoPaziente = new JTextField();
								GridBagConstraints gbc_textNumeroTelefonoPaziente = new GridBagConstraints();
								gbc_textNumeroTelefonoPaziente.insets = new Insets(0, 0, 5, 0);
								gbc_textNumeroTelefonoPaziente.fill = GridBagConstraints.HORIZONTAL;
								gbc_textNumeroTelefonoPaziente.gridx = 2;
								gbc_textNumeroTelefonoPaziente.gridy = 9;
								panel.add(textNumeroTelefonoPaziente, gbc_textNumeroTelefonoPaziente);
								textNumeroTelefonoPaziente.setText(valori[9]);
								textNumeroTelefonoPaziente.setHorizontalAlignment(SwingConstants.LEFT);
								textNumeroTelefonoPaziente.setForeground(Color.BLACK);
								textNumeroTelefonoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
								textNumeroTelefonoPaziente.setEditable(true);
								textNumeroTelefonoPaziente.setColumns(10);
								
								JLabel textEmail = new JLabel("e-Mail:");
								GridBagConstraints gbc_textEmail = new GridBagConstraints();
								gbc_textEmail.anchor = GridBagConstraints.WEST;
								gbc_textEmail.insets = new Insets(0, 0, 5, 5);
								gbc_textEmail.gridx = 0;
								gbc_textEmail.gridy = 10;
								panel.add(textEmail, gbc_textEmail);
								textEmail.setHorizontalAlignment(SwingConstants.LEFT);
								textEmail.setFont(new Font("Arial", Font.BOLD, 16));
								
								textEmailPaziente = new JTextField();
								GridBagConstraints gbc_textEmailPaziente = new GridBagConstraints();
								gbc_textEmailPaziente.insets = new Insets(0, 0, 5, 0);
								gbc_textEmailPaziente.fill = GridBagConstraints.HORIZONTAL;
								gbc_textEmailPaziente.gridx = 2;
								gbc_textEmailPaziente.gridy = 10;
								panel.add(textEmailPaziente, gbc_textEmailPaziente);
								textEmailPaziente.setText(valori[10]);
								textEmailPaziente.setHorizontalAlignment(SwingConstants.LEFT);
								textEmailPaziente.setForeground(Color.BLACK);
								textEmailPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
								textEmailPaziente.setEditable(true);
								textEmailPaziente.setColumns(10);
								
								textDiagnosiPaziente = new JTextArea();
								GridBagConstraints gbc_textDiagnosiPaziente = new GridBagConstraints();
								gbc_textDiagnosiPaziente.gridheight = 2;
								gbc_textDiagnosiPaziente.insets = new Insets(0, 0, 5, 0);
								gbc_textDiagnosiPaziente.fill = GridBagConstraints.BOTH;
								gbc_textDiagnosiPaziente.gridx = 2;
								gbc_textDiagnosiPaziente.gridy = 11;
								panel.add(textDiagnosiPaziente, gbc_textDiagnosiPaziente);
								textDiagnosiPaziente.setText(valori[11]);
								textDiagnosiPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
								textDiagnosiPaziente.setEditable(true);
								
								JLabel textDiagnosi = new JLabel("Diagnosi:");
								GridBagConstraints gbc_textDiagnosi = new GridBagConstraints();
								gbc_textDiagnosi.anchor = GridBagConstraints.WEST;
								gbc_textDiagnosi.insets = new Insets(0, 0, 5, 5);
								gbc_textDiagnosi.gridx = 0;
								gbc_textDiagnosi.gridy = 11;
								panel.add(textDiagnosi, gbc_textDiagnosi);
								textDiagnosi.setHorizontalAlignment(SwingConstants.LEFT);
								textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));
								
								JLabel textIntervento = new JLabel("Intervento:");
								GridBagConstraints gbc_textIntervento = new GridBagConstraints();
								gbc_textIntervento.anchor = GridBagConstraints.WEST;
								gbc_textIntervento.insets = new Insets(0, 0, 5, 5);
								gbc_textIntervento.gridx = 0;
								gbc_textIntervento.gridy = 13;
								panel.add(textIntervento, gbc_textIntervento);
								textIntervento.setHorizontalAlignment(SwingConstants.LEFT);
								textIntervento.setFont(new Font("Arial", Font.BOLD, 16));
								
								textInterventoPaziente = new JTextArea();
								GridBagConstraints gbc_textInterventoPaziente = new GridBagConstraints();
								gbc_textInterventoPaziente.gridheight = 2;
								gbc_textInterventoPaziente.insets = new Insets(0, 0, 5, 0);
								gbc_textInterventoPaziente.fill = GridBagConstraints.BOTH;
								gbc_textInterventoPaziente.gridx = 2;
								gbc_textInterventoPaziente.gridy = 13;
								panel.add(textInterventoPaziente, gbc_textInterventoPaziente);
								textInterventoPaziente.setText(valori[12]);
								textInterventoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
								textInterventoPaziente.setEditable(true);
								
								JLabel textAnamnesiPregressa = new JLabel("Anamnesi pregressa:");
								GridBagConstraints gbc_textAnamnesiPregressa = new GridBagConstraints();
								gbc_textAnamnesiPregressa.anchor = GridBagConstraints.WEST;
								gbc_textAnamnesiPregressa.insets = new Insets(0, 0, 5, 5);
								gbc_textAnamnesiPregressa.gridx = 0;
								gbc_textAnamnesiPregressa.gridy = 15;
								panel.add(textAnamnesiPregressa, gbc_textAnamnesiPregressa);
								textAnamnesiPregressa.setHorizontalAlignment(SwingConstants.LEFT);
								textAnamnesiPregressa.setFont(new Font("Arial", Font.BOLD, 16));
								
								textAnamnesiPregressaPaziente = new JTextArea();
								GridBagConstraints gbc_textAnamnesiPregressaPaziente = new GridBagConstraints();
								gbc_textAnamnesiPregressaPaziente.gridheight = 2;
								gbc_textAnamnesiPregressaPaziente.insets = new Insets(0, 0, 5, 0);
								gbc_textAnamnesiPregressaPaziente.fill = GridBagConstraints.BOTH;
								gbc_textAnamnesiPregressaPaziente.gridx = 2;
								gbc_textAnamnesiPregressaPaziente.gridy = 15;
								panel.add(textAnamnesiPregressaPaziente, gbc_textAnamnesiPregressaPaziente);
								textAnamnesiPregressaPaziente.setText(valori[13]);
								textAnamnesiPregressaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
								textAnamnesiPregressaPaziente.setEditable(true);
								
								JLabel textAnamnesiPossima = new JLabel("Anamnesi prossima:");
								GridBagConstraints gbc_textAnamnesiPossima = new GridBagConstraints();
								gbc_textAnamnesiPossima.anchor = GridBagConstraints.WEST;
								gbc_textAnamnesiPossima.insets = new Insets(0, 0, 5, 5);
								gbc_textAnamnesiPossima.gridx = 0;
								gbc_textAnamnesiPossima.gridy = 17;
								panel.add(textAnamnesiPossima, gbc_textAnamnesiPossima);
								textAnamnesiPossima.setHorizontalAlignment(SwingConstants.LEFT);
								textAnamnesiPossima.setFont(new Font("Arial", Font.BOLD, 16));
								
								textAnamnesiProssimaPaziente = new JTextArea();
								GridBagConstraints gbc_textAnamnesiProssimaPaziente = new GridBagConstraints();
								gbc_textAnamnesiProssimaPaziente.insets = new Insets(0, 0, 5, 0);
								gbc_textAnamnesiProssimaPaziente.fill = GridBagConstraints.BOTH;
								gbc_textAnamnesiProssimaPaziente.gridx = 2;
								gbc_textAnamnesiProssimaPaziente.gridy = 17;
								panel.add(textAnamnesiProssimaPaziente, gbc_textAnamnesiProssimaPaziente);
								textAnamnesiProssimaPaziente.setText(valori[14]);
								textAnamnesiProssimaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
								textAnamnesiProssimaPaziente.setEditable(true);
								
								JLabel textTempodiAttesa = new JLabel("Tempo di attesa:");
								GridBagConstraints gbc_textTempodiAttesa = new GridBagConstraints();
								gbc_textTempodiAttesa.anchor = GridBagConstraints.WEST;
								gbc_textTempodiAttesa.insets = new Insets(0, 0, 5, 5);
								gbc_textTempodiAttesa.gridx = 0;
								gbc_textTempodiAttesa.gridy = 19;
								panel.add(textTempodiAttesa, gbc_textTempodiAttesa);
								textTempodiAttesa.setHorizontalAlignment(SwingConstants.LEFT);
								textTempodiAttesa.setFont(new Font("Arial", Font.BOLD, 16));
								
								spinnerTempodiAttesaPaziente = new JSpinner();
								GridBagConstraints gbc_spinnerTempodiAttesaPaziente = new GridBagConstraints();
								gbc_spinnerTempodiAttesaPaziente.anchor = GridBagConstraints.WEST;
								gbc_spinnerTempodiAttesaPaziente.insets = new Insets(0, 0, 5, 0);
								gbc_spinnerTempodiAttesaPaziente.gridx = 2;
								gbc_spinnerTempodiAttesaPaziente.gridy = 19;
								panel.add(spinnerTempodiAttesaPaziente, gbc_spinnerTempodiAttesaPaziente);
								spinnerTempodiAttesaPaziente.setModel(new SpinnerListModel(new String[] {"","Classe A", "Classe B", "Classe C", "Classe D"}));
								spinnerTempodiAttesaPaziente.setValue(valori[15]);
								spinnerTempodiAttesaPaziente.setEnabled(true);
								spinnerTempodiAttesaPaziente.setFont(new Font("Arial", Font.BOLD, 14));
								
								JLabel textDatiMedico = new JLabel("Dati medico che ha richiesto intervento:");
								GridBagConstraints gbc_textDatiMedico = new GridBagConstraints();
								gbc_textDatiMedico.anchor = GridBagConstraints.WEST;
								gbc_textDatiMedico.insets = new Insets(0, 0, 5, 0);
								gbc_textDatiMedico.gridwidth = 3;
								gbc_textDatiMedico.gridx = 0;
								gbc_textDatiMedico.gridy = 21;
								panel.add(textDatiMedico, gbc_textDatiMedico);
								textDatiMedico.setFont(new Font("Arial", Font.BOLD, 15));
								
								JLabel textNome_1 = new JLabel("Nome:");
								GridBagConstraints gbc_textNome_1 = new GridBagConstraints();
								gbc_textNome_1.anchor = GridBagConstraints.WEST;
								gbc_textNome_1.insets = new Insets(0, 0, 5, 5);
								gbc_textNome_1.gridx = 0;
								gbc_textNome_1.gridy = 22;
								panel.add(textNome_1, gbc_textNome_1);
								textNome_1.setFont(new Font("Arial", Font.BOLD, 16));
								
								JLabel textNomeMedico = new JLabel();
								GridBagConstraints gbc_textNomeMedico = new GridBagConstraints();
								gbc_textNomeMedico.fill = GridBagConstraints.HORIZONTAL;
								gbc_textNomeMedico.insets = new Insets(0, 0, 5, 0);
								gbc_textNomeMedico.gridx = 2;
								gbc_textNomeMedico.gridy = 22;
								panel.add(textNomeMedico, gbc_textNomeMedico);
								textNomeMedico.setText(dataService.getNomeDipendente(valori[16]));
								textNomeMedico.setHorizontalAlignment(SwingConstants.LEFT);
								textNomeMedico.setFont(new Font("Arial", Font.PLAIN, 14));
								
								JLabel textCognome_1 = new JLabel("Cognome:");
								GridBagConstraints gbc_textCognome_1 = new GridBagConstraints();
								gbc_textCognome_1.anchor = GridBagConstraints.WEST;
								gbc_textCognome_1.insets = new Insets(0, 0, 5, 5);
								gbc_textCognome_1.gridx = 0;
								gbc_textCognome_1.gridy = 23;
								panel.add(textCognome_1, gbc_textCognome_1);
								textCognome_1.setFont(new Font("Arial", Font.BOLD, 16));
								
								JLabel textCognomeMedico = new JLabel();
								GridBagConstraints gbc_textCognomeMedico = new GridBagConstraints();
								gbc_textCognomeMedico.fill = GridBagConstraints.HORIZONTAL;
								gbc_textCognomeMedico.insets = new Insets(0, 0, 5, 0);
								gbc_textCognomeMedico.gridx = 2;
								gbc_textCognomeMedico.gridy = 23;
								panel.add(textCognomeMedico, gbc_textCognomeMedico);
								textCognomeMedico.setText(dataService.getCognomeDipendente(valori[16]));
								textCognomeMedico.setHorizontalAlignment(SwingConstants.LEFT);
								textCognomeMedico.setFont(new Font("Arial", Font.PLAIN, 14));
								
								JLabel textMatricola = new JLabel("Matrciola:");
								GridBagConstraints gbc_textMatricola = new GridBagConstraints();
								gbc_textMatricola.anchor = GridBagConstraints.WEST;
								gbc_textMatricola.insets = new Insets(0, 0, 5, 5);
								gbc_textMatricola.gridx = 0;
								gbc_textMatricola.gridy = 24;
								panel.add(textMatricola, gbc_textMatricola);
								textMatricola.setFont(new Font("Arial", Font.BOLD, 16));
								
								textMatricolaMedico = new JLabel();
								GridBagConstraints gbc_textMatricolaMedico = new GridBagConstraints();
								gbc_textMatricolaMedico.fill = GridBagConstraints.HORIZONTAL;
								gbc_textMatricolaMedico.insets = new Insets(0, 0, 5, 0);
								gbc_textMatricolaMedico.gridx = 2;
								gbc_textMatricolaMedico.gridy = 24;
								panel.add(textMatricolaMedico, gbc_textMatricolaMedico);
								textMatricolaMedico.setText(valori[16]);
								textMatricolaMedico.setHorizontalAlignment(SwingConstants.LEFT);
								textMatricolaMedico.setFont(new Font("Arial", Font.PLAIN, 14));
								
								JLabel textNote = new JLabel("Note:");
								GridBagConstraints gbc_textNote = new GridBagConstraints();
								gbc_textNote.anchor = GridBagConstraints.WEST;
								gbc_textNote.insets = new Insets(0, 0, 5, 5);
								gbc_textNote.gridx = 0;
								gbc_textNote.gridy = 25;
								panel.add(textNote, gbc_textNote);
								textNote.setHorizontalAlignment(SwingConstants.LEFT);
								textNote.setFont(new Font("Arial", Font.BOLD, 16));
								
								
								textNotePaziente = new JTextArea();
								GridBagConstraints gbc_textNotePaziente = new GridBagConstraints();
								gbc_textNotePaziente.fill = GridBagConstraints.HORIZONTAL;
								gbc_textNotePaziente.insets = new Insets(0, 0, 5, 0);
								gbc_textNotePaziente.gridx = 2;
								gbc_textNotePaziente.gridy = 25;
								panel.add(textNotePaziente, gbc_textNotePaziente);
								textNotePaziente.setText(valori[17]);
								textNotePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
								textNotePaziente.setEditable(true);
								
								
								bottoneSalva = new JButton("Salva");
								GridBagConstraints gbc_bottoneSalva = new GridBagConstraints();
								gbc_bottoneSalva.insets = new Insets(0, 0, 0, 5);
								gbc_bottoneSalva.gridx = 0;
								gbc_bottoneSalva.gridy = 27;
								panel.add(bottoneSalva, gbc_bottoneSalva);
								bottoneSalva.setVisible(true);
								bottoneSalva.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										salva();
									}
								});
								bottoneSalva.setFont(new Font("Arial", Font.PLAIN, 14));
								
								
								bottoneChiudi = new JButton("Chiudi senza salvare");
								GridBagConstraints gbc_bottoneChiudi = new GridBagConstraints();
								gbc_bottoneChiudi.anchor = GridBagConstraints.WEST;
								gbc_bottoneChiudi.gridx = 2;
								gbc_bottoneChiudi.gridy = 27;
								panel.add(bottoneChiudi, gbc_bottoneChiudi);
								bottoneChiudi.setVisible(true);
								bottoneChiudi.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										chiudi();
									}
								});
								contentPane.setLayout(new BorderLayout(0, 0));
								bottoneChiudi.setFont(new Font("Arial", Font.PLAIN, 14));
								contentPane.add(scrollPane);
				
		
	}



	protected void salva(){
		
		String[] valori = {
				textNomePaziente.getText(),
				textCognomePaziente.getText(),
				textCodiceFiscalePaziente.getText(),
				spinnerGiorno.getValue().toString(),
				spinnerMese.getValue().toString(),
				spinnerAnno.getValue().toString(),
				textLuogodiNascitaPaziente.getText(),
				textCittaPaziente.getText(),
				textIndirizzoPaziente.getText(),
				textNumeroTelefonoPaziente.getText(),
				textEmailPaziente.getText(),
				textDiagnosiPaziente.getText(),
				textInterventoPaziente.getText(),
				textAnamnesiPregressaPaziente.getText(),
				textAnamnesiProssimaPaziente.getText(),
				spinnerTempodiAttesaPaziente.getValue().toString(),
				textMatricolaMedico.getText(),
				textNotePaziente.getText()
		};
		if(dataService.salvaAnagrafica(codiceAnagrafica, valori, nuova).equals("-1")) {
			JOptionPane.showMessageDialog(null,"Errore, tutti i campi, tranne \"Note\", devono essere compilati");
		}
		else {
			nuova = false;
			chiudi();
		}
		
	}
	
	
	protected void chiudi() {
		if(nuova) {
			dataService.decrementaCodice(codiceAnagrafica, "Anagrafica");
		}
		dispose();
	}
}
