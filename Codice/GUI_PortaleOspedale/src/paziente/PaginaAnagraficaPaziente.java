package paziente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.DataService;

public class PaginaAnagraficaPaziente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomePaziente;
	private JTextField textCognomePaziente;
	private JTextField textCodiceFiscalePaziente;
	private JTextField textLuogodiNascitaPaziente;
	private JTextField textResidenzaPaziente;
	private JTextField textNumeroTelefonoPaziente;
	private JTextField textEmailPaziente;
	private JTextField textNomeMedico;
	private JTextField textCognomeMedico;
	private JTextField textMatricolaMedico;
	private JSpinner spinnerTempodiAttesaPaziente;
	private JTextArea textAnamnesiProssimaPaziente;
	private JTextArea textAnamnesiPregressaPaziente;
	private JTextArea textInterventoPaziente;
	private JTextArea textDiagnosiPaziente;
	private JSpinner spinnerGiorno;
	private JSpinner spinnerMese;
	private JSpinner spinnerAnno;
	private JButton bottoneSalva;
	private JButton bottoneModifica;
	private JTextArea textNotePaziente;
	
	private DataService dataService;
	private String matricolaMedico;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaAnagraficaPaziente frame = new PaginaAnagraficaPaziente("m001a", false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PaginaAnagraficaPaziente(String matricolaMedico, boolean modifica) {
		
		dataService = new DataService();
		this.matricolaMedico = matricolaMedico;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaginaAnagraficaPaziente.class.getResource("/resources/LogoOspedale.png")));
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
		
		JLabel textPaginaAnagrafica = new JLabel("Pagaina anagrafica paziente");
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
		textNomePaziente = new JTextField();
		textNomePaziente.setText("aaa");
		textNomePaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textNomePaziente.setEditable(false);
		textNomePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNomePaziente = new GridBagConstraints();
		gbc_textNomePaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomePaziente.anchor = GridBagConstraints.NORTH;
		gbc_textNomePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textNomePaziente.gridx = 2;
		gbc_textNomePaziente.gridy = 2;
		contentPane.add(textNomePaziente, gbc_textNomePaziente);
		textNomePaziente.setColumns(10);
		
		JLabel textCognome = new JLabel("Cognome:");
		textCognome.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textCognome = new GridBagConstraints();
		gbc_textCognome.anchor = GridBagConstraints.NORTHWEST;
		gbc_textCognome.insets = new Insets(0, 0, 5, 5);
		gbc_textCognome.gridx = 0;
		gbc_textCognome.gridy = 3;
		contentPane.add(textCognome, gbc_textCognome);
		
		textCognomePaziente = new JTextField();
		textCognomePaziente.setText("aaa");
		textCognomePaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomePaziente.setEditable(false);
		textCognomePaziente.setColumns(10);
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
		
		textCodiceFiscalePaziente = new JTextField();
		textCodiceFiscalePaziente.setText("aaa");
		textCodiceFiscalePaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textCodiceFiscalePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textCodiceFiscalePaziente.setEditable(false);
		textCodiceFiscalePaziente.setColumns(10);
		GridBagConstraints gbc_textCodiceFiscalePaziente = new GridBagConstraints();
		gbc_textCodiceFiscalePaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCodiceFiscalePaziente.anchor = GridBagConstraints.NORTH;
		gbc_textCodiceFiscalePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textCodiceFiscalePaziente.gridx = 2;
		gbc_textCodiceFiscalePaziente.gridy = 4;
		contentPane.add(textCodiceFiscalePaziente, gbc_textCodiceFiscalePaziente);
		
		JLabel textDatadiNascita = new JLabel("Data di Nascita (gg/mm/aa):");
		textDatadiNascita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDatadiNascita = new GridBagConstraints();
		gbc_textDatadiNascita.anchor = GridBagConstraints.WEST;
		gbc_textDatadiNascita.insets = new Insets(0, 0, 5, 5);
		gbc_textDatadiNascita.gridx = 0;
		gbc_textDatadiNascita.gridy = 5;
		contentPane.add(textDatadiNascita, gbc_textDatadiNascita);
		
		JPanel Data = new JPanel();
		GridBagConstraints gbc_Data = new GridBagConstraints();
		gbc_Data.anchor = GridBagConstraints.WEST;
		gbc_Data.insets = new Insets(0, 0, 5, 5);
		gbc_Data.gridx = 2;
		gbc_Data.gridy = 5;
		contentPane.add(Data, gbc_Data);
		Data.setLayout(new BoxLayout(Data, BoxLayout.X_AXIS));
		
		spinnerGiorno = new JSpinner();
		Data.add(spinnerGiorno);
		spinnerGiorno.setEnabled(false);
		spinnerGiorno.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerGiorno.setFont(new Font("Arial", Font.BOLD, 14));
		
		spinnerMese = new JSpinner();
		spinnerMese.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMese.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMese.setEnabled(false);
		Data.add(spinnerMese);
		
		spinnerAnno = new JSpinner();
		spinnerAnno.setModel(new SpinnerNumberModel(Integer.valueOf(1800), Integer.valueOf(1800), null, Integer.valueOf(1)));
		spinnerAnno.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerAnno.setEnabled(false);
		Data.add(spinnerAnno);
		
		JLabel textLuogodiNascita = new JLabel("Luogo di Nascita:");
		textLuogodiNascita.setHorizontalAlignment(SwingConstants.LEFT);
		textLuogodiNascita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textLuogodiNascita = new GridBagConstraints();
		gbc_textLuogodiNascita.anchor = GridBagConstraints.WEST;
		gbc_textLuogodiNascita.insets = new Insets(0, 0, 5, 5);
		gbc_textLuogodiNascita.gridx = 0;
		gbc_textLuogodiNascita.gridy = 6;
		contentPane.add(textLuogodiNascita, gbc_textLuogodiNascita);
		
		textLuogodiNascitaPaziente = new JTextField();
		textLuogodiNascitaPaziente.setText("(paese)");
		textLuogodiNascitaPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textLuogodiNascitaPaziente.setForeground(Color.BLACK);
		textLuogodiNascitaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textLuogodiNascitaPaziente.setEditable(false);
		textLuogodiNascitaPaziente.setColumns(10);
		GridBagConstraints gbc_textLuogodiNascitaPaziente = new GridBagConstraints();
		gbc_textLuogodiNascitaPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLuogodiNascitaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textLuogodiNascitaPaziente.gridx = 2;
		gbc_textLuogodiNascitaPaziente.gridy = 6;
		contentPane.add(textLuogodiNascitaPaziente, gbc_textLuogodiNascitaPaziente);
		
		JLabel textResidenza = new JLabel("Residenza:");
		textResidenza.setHorizontalAlignment(SwingConstants.LEFT);
		textResidenza.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textResidenza = new GridBagConstraints();
		gbc_textResidenza.anchor = GridBagConstraints.WEST;
		gbc_textResidenza.insets = new Insets(0, 0, 5, 5);
		gbc_textResidenza.gridx = 0;
		gbc_textResidenza.gridy = 7;
		contentPane.add(textResidenza, gbc_textResidenza);
		
		textResidenzaPaziente = new JTextField();
		textResidenzaPaziente.setText("(paese)");
		textResidenzaPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textResidenzaPaziente.setForeground(Color.BLACK);
		textResidenzaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textResidenzaPaziente.setEditable(false);
		textResidenzaPaziente.setColumns(10);
		GridBagConstraints gbc_textResidenzaPaziente = new GridBagConstraints();
		gbc_textResidenzaPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textResidenzaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textResidenzaPaziente.gridx = 2;
		gbc_textResidenzaPaziente.gridy = 7;
		contentPane.add(textResidenzaPaziente, gbc_textResidenzaPaziente);
		
		JLabel textNumerodiTelefono = new JLabel("Telefono:");
		textNumerodiTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		textNumerodiTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNumerodiTelefono = new GridBagConstraints();
		gbc_textNumerodiTelefono.anchor = GridBagConstraints.WEST;
		gbc_textNumerodiTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textNumerodiTelefono.gridx = 0;
		gbc_textNumerodiTelefono.gridy = 8;
		contentPane.add(textNumerodiTelefono, gbc_textNumerodiTelefono);
		
		textNumeroTelefonoPaziente = new JTextField();
		textNumeroTelefonoPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textNumeroTelefonoPaziente.setForeground(Color.BLACK);
		textNumeroTelefonoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textNumeroTelefonoPaziente.setEditable(false);
		textNumeroTelefonoPaziente.setColumns(10);
		GridBagConstraints gbc_textNumeroTelefonoPaziente = new GridBagConstraints();
		gbc_textNumeroTelefonoPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumeroTelefonoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textNumeroTelefonoPaziente.gridx = 2;
		gbc_textNumeroTelefonoPaziente.gridy = 8;
		contentPane.add(textNumeroTelefonoPaziente, gbc_textNumeroTelefonoPaziente);
		
		JLabel textEmail = new JLabel("e-Mail:");
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.anchor = GridBagConstraints.WEST;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.gridx = 0;
		gbc_textEmail.gridy = 9;
		contentPane.add(textEmail, gbc_textEmail);
		
		textEmailPaziente = new JTextField();
		textEmailPaziente.setHorizontalAlignment(SwingConstants.LEFT);
		textEmailPaziente.setForeground(Color.BLACK);
		textEmailPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textEmailPaziente.setEditable(false);
		textEmailPaziente.setColumns(10);
		GridBagConstraints gbc_textEmailPaziente = new GridBagConstraints();
		gbc_textEmailPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmailPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textEmailPaziente.gridx = 2;
		gbc_textEmailPaziente.gridy = 9;
		contentPane.add(textEmailPaziente, gbc_textEmailPaziente);
		
		JLabel textDiagnosi = new JLabel("Diagnosi:");
		textDiagnosi.setHorizontalAlignment(SwingConstants.LEFT);
		textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDiagnosi = new GridBagConstraints();
		gbc_textDiagnosi.anchor = GridBagConstraints.NORTHWEST;
		gbc_textDiagnosi.insets = new Insets(0, 0, 5, 5);
		gbc_textDiagnosi.gridx = 0;
		gbc_textDiagnosi.gridy = 10;
		contentPane.add(textDiagnosi, gbc_textDiagnosi);
		
		textDiagnosiPaziente = new JTextArea();
		textDiagnosiPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textDiagnosiPaziente.setEditable(false);
		GridBagConstraints gbc_textDiagnosiPaziente = new GridBagConstraints();
		gbc_textDiagnosiPaziente.gridheight = 2;
		gbc_textDiagnosiPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textDiagnosiPaziente.fill = GridBagConstraints.BOTH;
		gbc_textDiagnosiPaziente.gridx = 2;
		gbc_textDiagnosiPaziente.gridy = 10;
		contentPane.add(textDiagnosiPaziente, gbc_textDiagnosiPaziente);
		
		JLabel textIntervento = new JLabel("Intervento:");
		textIntervento.setHorizontalAlignment(SwingConstants.LEFT);
		textIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textIntervento = new GridBagConstraints();
		gbc_textIntervento.anchor = GridBagConstraints.NORTHWEST;
		gbc_textIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textIntervento.gridx = 0;
		gbc_textIntervento.gridy = 12;
		contentPane.add(textIntervento, gbc_textIntervento);
		
		textInterventoPaziente = new JTextArea();
		textInterventoPaziente.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				saveNomeMedico();
			}
		});
		textInterventoPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textInterventoPaziente.setEditable(false);
		GridBagConstraints gbc_textInterventoPaziente = new GridBagConstraints();
		gbc_textInterventoPaziente.gridheight = 2;
		gbc_textInterventoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textInterventoPaziente.fill = GridBagConstraints.BOTH;
		gbc_textInterventoPaziente.gridx = 2;
		gbc_textInterventoPaziente.gridy = 12;
		contentPane.add(textInterventoPaziente, gbc_textInterventoPaziente);
		
		JLabel textAnamnesiPregressa = new JLabel("Anamnesi pregressa:");
		textAnamnesiPregressa.setHorizontalAlignment(SwingConstants.LEFT);
		textAnamnesiPregressa.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textAnamnesiPregressa = new GridBagConstraints();
		gbc_textAnamnesiPregressa.anchor = GridBagConstraints.NORTHWEST;
		gbc_textAnamnesiPregressa.insets = new Insets(0, 0, 5, 5);
		gbc_textAnamnesiPregressa.gridx = 0;
		gbc_textAnamnesiPregressa.gridy = 14;
		contentPane.add(textAnamnesiPregressa, gbc_textAnamnesiPregressa);
		
		textAnamnesiPregressaPaziente = new JTextArea();
		textAnamnesiPregressaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textAnamnesiPregressaPaziente.setEditable(false);
		GridBagConstraints gbc_textAnamnesiPregressaPaziente = new GridBagConstraints();
		gbc_textAnamnesiPregressaPaziente.gridheight = 2;
		gbc_textAnamnesiPregressaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textAnamnesiPregressaPaziente.fill = GridBagConstraints.BOTH;
		gbc_textAnamnesiPregressaPaziente.gridx = 2;
		gbc_textAnamnesiPregressaPaziente.gridy = 14;
		contentPane.add(textAnamnesiPregressaPaziente, gbc_textAnamnesiPregressaPaziente);
		
		JLabel textAnamnesiPossima = new JLabel("Anamnesi prossima:");
		textAnamnesiPossima.setHorizontalAlignment(SwingConstants.LEFT);
		textAnamnesiPossima.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textAnamnesiPossima = new GridBagConstraints();
		gbc_textAnamnesiPossima.anchor = GridBagConstraints.NORTHWEST;
		gbc_textAnamnesiPossima.insets = new Insets(0, 0, 5, 5);
		gbc_textAnamnesiPossima.gridx = 0;
		gbc_textAnamnesiPossima.gridy = 16;
		contentPane.add(textAnamnesiPossima, gbc_textAnamnesiPossima);
		
		textAnamnesiProssimaPaziente = new JTextArea();
		textAnamnesiProssimaPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textAnamnesiProssimaPaziente.setEditable(false);
		GridBagConstraints gbc_textAnamnesiProssimaPaziente = new GridBagConstraints();
		gbc_textAnamnesiProssimaPaziente.gridheight = 2;
		gbc_textAnamnesiProssimaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textAnamnesiProssimaPaziente.fill = GridBagConstraints.BOTH;
		gbc_textAnamnesiProssimaPaziente.gridx = 2;
		gbc_textAnamnesiProssimaPaziente.gridy = 16;
		contentPane.add(textAnamnesiProssimaPaziente, gbc_textAnamnesiProssimaPaziente);
		
		JLabel textTempodiAttesa = new JLabel("Tempo di attesa:");
		textTempodiAttesa.setHorizontalAlignment(SwingConstants.LEFT);
		textTempodiAttesa.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTempodiAttesa = new GridBagConstraints();
		gbc_textTempodiAttesa.anchor = GridBagConstraints.WEST;
		gbc_textTempodiAttesa.insets = new Insets(0, 0, 5, 5);
		gbc_textTempodiAttesa.gridx = 0;
		gbc_textTempodiAttesa.gridy = 18;
		contentPane.add(textTempodiAttesa, gbc_textTempodiAttesa);
		
		spinnerTempodiAttesaPaziente = new JSpinner();
		spinnerTempodiAttesaPaziente.setEnabled(false);
		spinnerTempodiAttesaPaziente.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerTempodiAttesaPaziente.setModel(new SpinnerListModel(new String[] {"-", "A", "B", "C", "D"}));
		GridBagConstraints gbc_spinnerTempodiAttesaPaziente = new GridBagConstraints();
		gbc_spinnerTempodiAttesaPaziente.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerTempodiAttesaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerTempodiAttesaPaziente.gridx = 2;
		gbc_spinnerTempodiAttesaPaziente.gridy = 18;
		contentPane.add(spinnerTempodiAttesaPaziente, gbc_spinnerTempodiAttesaPaziente);
		
		JLabel textDatiMedico = new JLabel("Dati medico che ha richiesto intervento");
		textDatiMedico.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDatiMedico = new GridBagConstraints();
		gbc_textDatiMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDatiMedico.gridwidth = 4;
		gbc_textDatiMedico.insets = new Insets(0, 0, 5, 0);
		gbc_textDatiMedico.gridx = 0;
		gbc_textDatiMedico.gridy = 20;
		contentPane.add(textDatiMedico, gbc_textDatiMedico);
		
		JLabel textNome_1 = new JLabel("Nome:");
		textNome_1.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNome_1 = new GridBagConstraints();
		gbc_textNome_1.anchor = GridBagConstraints.WEST;
		gbc_textNome_1.insets = new Insets(0, 0, 5, 5);
		gbc_textNome_1.gridx = 0;
		gbc_textNome_1.gridy = 22;
		contentPane.add(textNome_1, gbc_textNome_1);
		
		textNomeMedico = new JTextField();
		textNomeMedico.setText(dataService.getNomeDipendente(matricolaMedico));
		textNomeMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeMedico.setFont(new Font("Arial", Font.PLAIN, 14));
		textNomeMedico.setEditable(false);
		textNomeMedico.setColumns(10);
		GridBagConstraints gbc_textNomeMedico = new GridBagConstraints();
		gbc_textNomeMedico.insets = new Insets(0, 0, 5, 5);
		gbc_textNomeMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomeMedico.gridx = 2;
		gbc_textNomeMedico.gridy = 22;
		contentPane.add(textNomeMedico, gbc_textNomeMedico);
		
		JLabel textCognome_1 = new JLabel("Cognome:");
		textCognome_1.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textCognome_1 = new GridBagConstraints();
		gbc_textCognome_1.anchor = GridBagConstraints.WEST;
		gbc_textCognome_1.insets = new Insets(0, 0, 5, 5);
		gbc_textCognome_1.gridx = 0;
		gbc_textCognome_1.gridy = 23;
		contentPane.add(textCognome_1, gbc_textCognome_1);
		
		textCognomeMedico = new JTextField();
		textCognomeMedico.setText(dataService.getCognomeDipendente(matricolaMedico));
		textCognomeMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeMedico.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomeMedico.setEditable(false);
		textCognomeMedico.setColumns(10);
		GridBagConstraints gbc_textCognomeMedico = new GridBagConstraints();
		gbc_textCognomeMedico.insets = new Insets(0, 0, 5, 5);
		gbc_textCognomeMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCognomeMedico.gridx = 2;
		gbc_textCognomeMedico.gridy = 23;
		contentPane.add(textCognomeMedico, gbc_textCognomeMedico);
		
		JLabel textMatricola = new JLabel("Matrciola:");
		textMatricola.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textMatricola = new GridBagConstraints();
		gbc_textMatricola.anchor = GridBagConstraints.WEST;
		gbc_textMatricola.insets = new Insets(0, 0, 5, 5);
		gbc_textMatricola.gridx = 0;
		gbc_textMatricola.gridy = 24;
		contentPane.add(textMatricola, gbc_textMatricola);
		
		textMatricolaMedico = new JTextField();
		textMatricolaMedico.setText(matricolaMedico);
		textMatricolaMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textMatricolaMedico.setFont(new Font("Arial", Font.PLAIN, 14));
		textMatricolaMedico.setEditable(false);
		textMatricolaMedico.setColumns(10);
		GridBagConstraints gbc_textMatricolaMedico = new GridBagConstraints();
		gbc_textMatricolaMedico.insets = new Insets(0, 0, 5, 5);
		gbc_textMatricolaMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMatricolaMedico.gridx = 2;
		gbc_textMatricolaMedico.gridy = 24;
		contentPane.add(textMatricolaMedico, gbc_textMatricolaMedico);
		
		JLabel textNote = new JLabel("Note:");
		textNote.setHorizontalAlignment(SwingConstants.LEFT);
		textNote.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNote = new GridBagConstraints();
		gbc_textNote.anchor = GridBagConstraints.WEST;
		gbc_textNote.insets = new Insets(0, 0, 5, 5);
		gbc_textNote.gridx = 0;
		gbc_textNote.gridy = 25;
		contentPane.add(textNote, gbc_textNote);
		
		
		bottoneModifica = new JButton("Modifica");
		bottoneModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableModifica();
			}
		});
		
		textNotePaziente = new JTextArea();
		textNotePaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textNotePaziente.setEditable(false);
		GridBagConstraints gbc_textNotePaziente = new GridBagConstraints();
		gbc_textNotePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textNotePaziente.fill = GridBagConstraints.BOTH;
		gbc_textNotePaziente.gridx = 2;
		gbc_textNotePaziente.gridy = 25;
		contentPane.add(textNotePaziente, gbc_textNotePaziente);
		bottoneModifica.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneModifica = new GridBagConstraints();
		gbc_bottoneModifica.anchor = GridBagConstraints.WEST;
		gbc_bottoneModifica.insets = new Insets(0, 0, 5, 5);
		gbc_bottoneModifica.gridx = 0;
		gbc_bottoneModifica.gridy = 27;
		contentPane.add(bottoneModifica, gbc_bottoneModifica);
		
		
		bottoneSalva = new JButton("Salva");
		bottoneSalva.setVisible(false);
		bottoneSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveModifica();
			}
		});
		

		bottoneSalva.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneConferma = new GridBagConstraints();
		gbc_bottoneConferma.anchor = GridBagConstraints.WEST;
		gbc_bottoneConferma.gridwidth = 2;
		gbc_bottoneConferma.insets = new Insets(0, 0, 5, 5);
		gbc_bottoneConferma.gridx = 1;
		gbc_bottoneConferma.gridy = 27;
		contentPane.add(bottoneSalva, gbc_bottoneConferma);
		
		//se la pagina deve essere aperta per essere modificata viene richiamato il metodo per farlo
		if(modifica) { 
			enableModifica();
		}
		
		
		
	}
	
	//questo metodo salva conferma le modifiche
	void saveModifica() {
		
		int errore = dataService.salvaAnagrafica(
				textNomePaziente.getText(),
				textCognomePaziente.getText(),
				textCodiceFiscalePaziente.getText(),
				textLuogodiNascitaPaziente.getText(),
				textResidenzaPaziente.getText(),
				textNumeroTelefonoPaziente.getText(),
				textEmailPaziente.getText(),
				textMatricolaMedico.getText(),
				spinnerTempodiAttesaPaziente.getValue().toString(),
				textAnamnesiProssimaPaziente.getText(),
				textAnamnesiPregressaPaziente.getText(),
				textInterventoPaziente.getText(),
				textDiagnosiPaziente.getText(),
				spinnerGiorno.getValue().toString(),
				spinnerMese.getValue().toString(),
				spinnerAnno.getValue().toString(),
				textNotePaziente.getText()
				);
		
		if(errore == 0) {
			textNomePaziente.setEditable(false);
			textCognomePaziente.setEditable(false);
			textCodiceFiscalePaziente.setEditable(false);
			spinnerGiorno.setEnabled(false);
			spinnerMese.setEnabled(false);
			spinnerAnno.setEnabled(false);
			textNumeroTelefonoPaziente.setEditable(false);
			textResidenzaPaziente.setEditable(false);
			textEmailPaziente.setEditable(false);
			textDiagnosiPaziente.setEditable(false);
			textLuogodiNascitaPaziente.setEditable(false);
			textInterventoPaziente.setEditable(false);
			textAnamnesiPregressaPaziente.setEditable(false);
			textAnamnesiProssimaPaziente.setEditable(false);
			spinnerTempodiAttesaPaziente.setEnabled(false);
			bottoneSalva.setVisible(false);
			bottoneModifica.setEnabled(true);  
			textNotePaziente.setEditable(false);
		}
		
		
					
	}
	
	//questo metodo abilita alle modifiche
	void enableModifica() {
		textNomePaziente.setEditable(true);
		textCognomePaziente.setEditable(true);
		textCodiceFiscalePaziente.setEditable(true);
		spinnerGiorno.setEnabled(true);
		spinnerMese.setEnabled(true);
		spinnerAnno.setEnabled(true);
		textNumeroTelefonoPaziente.setEditable(true);
		textResidenzaPaziente.setEditable(true);
		textEmailPaziente.setEditable(true);
		textDiagnosiPaziente.setEditable(true);
		textLuogodiNascitaPaziente.setEditable(true);
		textInterventoPaziente.setEditable(true);
		textAnamnesiPregressaPaziente.setEditable(true);
		textAnamnesiProssimaPaziente.setEditable(true);
		spinnerTempodiAttesaPaziente.setEnabled(true);
		bottoneSalva.setVisible(true);
		bottoneModifica.setEnabled(false);
		textNotePaziente.setEditable(true);		
	}
	
	//ATTENZIONE!!!(collegare al DB)questo metodo modifica i dati del medico che ha modificato "intervento"
	void saveNomeMedico() {
		textNomeMedico.setText("ciao");
		textCognomeMedico.setText("ciao");
		textMatricolaMedico.setText("ciao");
	}
}
