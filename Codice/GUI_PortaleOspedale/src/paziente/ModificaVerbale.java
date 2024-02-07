package paziente;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import model.DataService;

import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SpinnerListModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ModificaVerbale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spinnerMinuto1;
	private JSpinner spinnerOra1;
	private JSpinner spinnerMinuto2;
	private JSpinner spinnerOra2;
	private JSpinner spinnerMinuto3;
	private JSpinner spinnerOra3;
	private JSpinner spinnerMinuto4;
	private JSpinner spinnerOra4;
	private JSpinner spinnerMinuto5;
	private JSpinner spinnerOra5;
	private JSpinner spinnerMinuto6;
	private JSpinner spinnerOra6;
	private JSpinner spinnerMinuto7;
	private JSpinner spinnerOra7;
	private JSpinner spinnerMinuto8;
	private JSpinner spinnerOra8;
	private JSpinner spinnerMinuto9;
	private JSpinner spinnerOra9;
	private JSpinner spinnerMinuto10;
	private JSpinner spinnerOra10;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JTextField textTecnicodiRadiologiaVerbale;
	private JTextField textPrimoOperatoreVerbale;
	private JTextField textSecondoOperatoreVerbale;
	private JTextField textTerzoOperatoreVerbale;
	private JTextField textAnestesistaVerbale;
	private JTextField textStrumentistaVerbale;
	private JTextField textInfermierediSalaVerbale;
	private JTextField textAiutoanestetistaVerbale;
	private JTextArea textProceduraVerbale;
	
	private DataService dataService;
	private String codiceVerbale;
	private String codiceAnagrafica;
	private String matricolaDipendente;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaVerbale frame = new ModificaVerbale("", "m001a", "0");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ModificaVerbale(String codiceVerbale, String matricolaDipendente, String codiceAnagrafica) {
		
		dataService = new DataService();
		this.codiceVerbale = dataService.getCodiceVerbale(codiceVerbale);
		this.matricolaDipendente = matricolaDipendente;

		String[] valori = dataService.getValoriVerbale(this.codiceVerbale);
		
		//se si è in fase di creazione del verbale non non è ancora stato registrata
		//l'anagrafica a cui corrisponde, dunque si tiene in considerazione il codice dell'anagrafica
		//passato come parametro.
		if(valori[21].equals("")) {
			valori[21] = codiceAnagrafica;
		}
		
		this.codiceAnagrafica = valori[21];
		
		String[] ore = ore();
		String[] minuti = minuti();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaVerbale.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale Papa Giovanni XIII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{148, 35, 408, 0};
		gbl_contentPane.rowHeights = new int[]{58, 35, 19, 23, 29, 19, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 62, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textVerbalePaziente = new JLabel("Verbale Paziente:");
		textVerbalePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textVerbalePaziente = new GridBagConstraints();
		gbc_textVerbalePaziente.anchor = GridBagConstraints.WEST;
		gbc_textVerbalePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textVerbalePaziente.gridx = 0;
		gbc_textVerbalePaziente.gridy = 0;
		contentPane.add(textVerbalePaziente, gbc_textVerbalePaziente);
		
		JLabel textNomePaziente = new JLabel(dataService.getPazienteAnagrafica(codiceAnagrafica));
		textNomePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNomePaziente = new GridBagConstraints();
		gbc_textNomePaziente.gridwidth = 2;
		gbc_textNomePaziente.anchor = GridBagConstraints.WEST;
		gbc_textNomePaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textNomePaziente.gridx = 1;
		gbc_textNomePaziente.gridy = 0;
		contentPane.add(textNomePaziente, gbc_textNomePaziente);
		
		JLabel textOradiIngresso = new JLabel("Ora di ingresso del blocco operatorio");
		textOradiIngresso.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiIngresso = new GridBagConstraints();
		gbc_textOradiIngresso.anchor = GridBagConstraints.WEST;
		gbc_textOradiIngresso.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiIngresso.gridx = 0;
		gbc_textOradiIngresso.gridy = 2;
		contentPane.add(textOradiIngresso, gbc_textOradiIngresso);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		
		spinnerOra1 = new JSpinner();
		spinnerOra1.setModel(new SpinnerListModel(ore));
		spinnerOra1.setValue(dataService.ora(valori[0]));
		spinnerOra1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(spinnerOra1);
		
		spinnerMinuto1 = new JSpinner();
		spinnerMinuto1.setModel(new SpinnerListModel(minuti));
		spinnerMinuto1.setValue(dataService.minuto(valori[0]));
		spinnerMinuto1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(spinnerMinuto1);
	
		JLabel textOradiEntrata = new JLabel("Ora di entrata in sala operatoria");
		textOradiEntrata.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiEntrata = new GridBagConstraints();
		gbc_textOradiEntrata.anchor = GridBagConstraints.WEST;
		gbc_textOradiEntrata.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiEntrata.gridx = 0;
		gbc_textOradiEntrata.gridy = 3;
		contentPane.add(textOradiEntrata, gbc_textOradiEntrata);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		
		spinnerOra2 = new JSpinner();
		spinnerOra2.setModel(new SpinnerListModel(ore));
		spinnerOra2.setValue(dataService.ora(valori[1]));
		spinnerOra2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(spinnerOra2);
		
		spinnerMinuto2 = new JSpinner();
		spinnerMinuto2.setModel(new SpinnerListModel(minuti));
		spinnerMinuto2.setValue(dataService.minuto(valori[1]));
		spinnerMinuto2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(spinnerMinuto2);
		
		JLabel OrariodelPosizionamento = new JLabel("Orario del posizionamento del paziente");
		OrariodelPosizionamento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_OrariodelPosizionamento = new GridBagConstraints();
		gbc_OrariodelPosizionamento.anchor = GridBagConstraints.WEST;
		gbc_OrariodelPosizionamento.insets = new Insets(0, 0, 5, 5);
		gbc_OrariodelPosizionamento.gridx = 0;
		gbc_OrariodelPosizionamento.gridy = 4;
		contentPane.add(OrariodelPosizionamento, gbc_OrariodelPosizionamento);
		
		JPanel panel_1_1 = new JPanel();
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_1.gridx = 2;
		gbc_panel_1_1.gridy = 4;
		contentPane.add(panel_1_1, gbc_panel_1_1);
		
		spinnerOra3 = new JSpinner();
		spinnerOra3.setModel(new SpinnerListModel(ore));
		spinnerOra3.setValue(dataService.minuto(valori[2]));
		spinnerOra3.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_1.add(spinnerOra3);
		
		spinnerMinuto3 = new JSpinner();
		spinnerMinuto3.setModel(new SpinnerListModel(minuti));
		spinnerMinuto3.setValue(dataService.minuto(valori[2]));
		spinnerMinuto3.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_1.add(spinnerMinuto3);
		
		JLabel textOradiInizioAnestesia = new JLabel("Ora inizio anestesia");
		textOradiInizioAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiInizioAnestesia = new GridBagConstraints();
		gbc_textOradiInizioAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textOradiInizioAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiInizioAnestesia.gridx = 0;
		gbc_textOradiInizioAnestesia.gridy = 5;
		contentPane.add(textOradiInizioAnestesia, gbc_textOradiInizioAnestesia);
		
		JPanel panel_1_2 = new JPanel();
		GridBagConstraints gbc_panel_1_2 = new GridBagConstraints();
		gbc_panel_1_2.anchor = GridBagConstraints.WEST;
		gbc_panel_1_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_2.gridx = 2;
		gbc_panel_1_2.gridy = 5;
		contentPane.add(panel_1_2, gbc_panel_1_2);
		
		spinnerOra4 = new JSpinner();
		spinnerOra4.setModel(new SpinnerListModel(ore));
		spinnerOra4.setValue(dataService.ora(valori[3]));
		spinnerOra4.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_2.add(spinnerOra4);
		
		spinnerMinuto4 = new JSpinner();
		spinnerMinuto4.setModel(new SpinnerListModel(minuti));
		spinnerMinuto4.setValue(dataService.minuto(valori[3]));
		spinnerMinuto4.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_2.add(spinnerMinuto4);
		
		JLabel textOradiFineAnestesia = new JLabel("Ora fine anestesia");
		textOradiFineAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiFineAnestesia = new GridBagConstraints();
		gbc_textOradiFineAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textOradiFineAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiFineAnestesia.gridx = 0;
		gbc_textOradiFineAnestesia.gridy = 6;
		contentPane.add(textOradiFineAnestesia, gbc_textOradiFineAnestesia);
		
		JPanel panel_1_3 = new JPanel();
		GridBagConstraints gbc_panel_1_3 = new GridBagConstraints();
		gbc_panel_1_3.anchor = GridBagConstraints.WEST;
		gbc_panel_1_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_3.gridx = 2;
		gbc_panel_1_3.gridy = 6;
		contentPane.add(panel_1_3, gbc_panel_1_3);
		
		spinnerOra5 = new JSpinner();
		spinnerOra5.setModel(new SpinnerListModel(ore));
		spinnerOra5.setValue(dataService.minuto(valori[4]));
		spinnerOra5.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_3.add(spinnerOra5);
		
		spinnerMinuto5 = new JSpinner();
		spinnerMinuto5.setModel(new SpinnerListModel(minuti));
		spinnerMinuto5.setValue(dataService.minuto(valori[4]));
		spinnerMinuto5.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_3.add(spinnerMinuto5);
		
		JLabel textOradiIntervento = new JLabel("Ora inizio intervento");
		textOradiIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiIntervento = new GridBagConstraints();
		gbc_textOradiIntervento.anchor = GridBagConstraints.WEST;
		gbc_textOradiIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiIntervento.gridx = 0;
		gbc_textOradiIntervento.gridy = 7;
		contentPane.add(textOradiIntervento, gbc_textOradiIntervento);
		
		JPanel panel_1_7 = new JPanel();
		GridBagConstraints gbc_panel_1_7 = new GridBagConstraints();
		gbc_panel_1_7.anchor = GridBagConstraints.WEST;
		gbc_panel_1_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_7.gridx = 2;
		gbc_panel_1_7.gridy = 7;
		contentPane.add(panel_1_7, gbc_panel_1_7);
		
		spinnerOra6 = new JSpinner();
		spinnerOra6.setModel(new SpinnerListModel(ore));
		spinnerOra6.setValue(dataService.ora(valori[5]));
		spinnerOra6.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_7.add(spinnerOra6);
		
		spinnerMinuto6 = new JSpinner();
		spinnerMinuto6.setModel(new SpinnerListModel(minuti));
		spinnerMinuto6.setValue(dataService.minuto(valori[5]));
		spinnerMinuto6.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_7.add(spinnerMinuto6);
		
		JLabel textOradiFineIntervento = new JLabel("Ora fine intervento");
		textOradiFineIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiFineIntervento = new GridBagConstraints();
		gbc_textOradiFineIntervento.anchor = GridBagConstraints.WEST;
		gbc_textOradiFineIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiFineIntervento.gridx = 0;
		gbc_textOradiFineIntervento.gridy = 8;
		contentPane.add(textOradiFineIntervento, gbc_textOradiFineIntervento);
		
		JPanel panel_1_8 = new JPanel();
		GridBagConstraints gbc_panel_1_8 = new GridBagConstraints();
		gbc_panel_1_8.anchor = GridBagConstraints.WEST;
		gbc_panel_1_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_8.gridx = 2;
		gbc_panel_1_8.gridy = 8;
		contentPane.add(panel_1_8, gbc_panel_1_8);
		
		spinnerOra7 = new JSpinner();
		spinnerOra7.setModel(new SpinnerListModel(ore));
		spinnerOra7.setValue(dataService.ora(valori[6]));
		spinnerOra7.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_8.add(spinnerOra7);
		
		spinnerMinuto7 = new JSpinner();
		spinnerMinuto7.setModel(new SpinnerListModel(minuti));
		spinnerMinuto7.setValue(dataService.minuto(valori[6]));
		spinnerMinuto7.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_8.add(spinnerMinuto7);
		
		JLabel textOradiRisveglio = new JLabel("Ora risveglio");
		textOradiRisveglio.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiRisveglio = new GridBagConstraints();
		gbc_textOradiRisveglio.anchor = GridBagConstraints.WEST;
		gbc_textOradiRisveglio.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiRisveglio.gridx = 0;
		gbc_textOradiRisveglio.gridy = 9;
		contentPane.add(textOradiRisveglio, gbc_textOradiRisveglio);
		
		JPanel panel_1_4 = new JPanel();
		GridBagConstraints gbc_panel_1_4 = new GridBagConstraints();
		gbc_panel_1_4.anchor = GridBagConstraints.WEST;
		gbc_panel_1_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_4.gridx = 2;
		gbc_panel_1_4.gridy = 9;
		contentPane.add(panel_1_4, gbc_panel_1_4);
		
		spinnerOra8 = new JSpinner();
		spinnerOra8.setModel(new SpinnerListModel(ore));
		spinnerOra8.setValue(dataService.ora(valori[7]));
		spinnerOra8.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_4.add(spinnerOra8);
		
		spinnerMinuto8 = new JSpinner();
		spinnerMinuto8.setModel(new SpinnerListModel(minuti));
		spinnerMinuto8.setValue(dataService.minuto(valori[7]));
		spinnerMinuto8.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_4.add(spinnerMinuto8);
		
		JLabel textOradiUscitaSala = new JLabel("Ora uscita sala operatoria");
		textOradiUscitaSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiUscitaSala = new GridBagConstraints();
		gbc_textOradiUscitaSala.anchor = GridBagConstraints.WEST;
		gbc_textOradiUscitaSala.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiUscitaSala.gridx = 0;
		gbc_textOradiUscitaSala.gridy = 10;
		contentPane.add(textOradiUscitaSala, gbc_textOradiUscitaSala);
		
		JPanel panel_1_5 = new JPanel();
		GridBagConstraints gbc_panel_1_5 = new GridBagConstraints();
		gbc_panel_1_5.anchor = GridBagConstraints.WEST;
		gbc_panel_1_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_5.gridx = 2;
		gbc_panel_1_5.gridy = 10;
		contentPane.add(panel_1_5, gbc_panel_1_5);
		
		spinnerOra9 = new JSpinner();
		spinnerOra9.setModel(new SpinnerListModel(ore));
		spinnerOra9.setValue(dataService.ora(valori[8]));
		spinnerOra9.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_5.add(spinnerOra9);
		
		spinnerMinuto9 = new JSpinner();
		spinnerMinuto9.setModel(new SpinnerListModel(minuti));
		spinnerMinuto9.setValue(dataService.minuto(valori[8]));
		spinnerMinuto9.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_5.add(spinnerMinuto9);
		
		JLabel textOraduUscita = new JLabel("Ora uscita blocco operatorio");
		textOraduUscita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOraduUscita = new GridBagConstraints();
		gbc_textOraduUscita.anchor = GridBagConstraints.WEST;
		gbc_textOraduUscita.insets = new Insets(0, 0, 5, 5);
		gbc_textOraduUscita.gridx = 0;
		gbc_textOraduUscita.gridy = 11;
		contentPane.add(textOraduUscita, gbc_textOraduUscita);
		
		JPanel panel_1_6 = new JPanel();
		GridBagConstraints gbc_panel_1_6 = new GridBagConstraints();
		gbc_panel_1_6.anchor = GridBagConstraints.WEST;
		gbc_panel_1_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_6.gridx = 2;
		gbc_panel_1_6.gridy = 11;
		contentPane.add(panel_1_6, gbc_panel_1_6);
		
		spinnerOra10 = new JSpinner();
		spinnerOra10.setModel(new SpinnerListModel(ore));
		spinnerOra10.setValue(dataService.ora(valori[9]));
		spinnerOra10.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_6.add(spinnerOra10);
		
		spinnerMinuto10 = new JSpinner();
		spinnerMinuto10.setModel(new SpinnerListModel(minuti));
		spinnerMinuto10.setValue(dataService.minuto(valori[9]));
		spinnerMinuto10.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1_6.add(spinnerMinuto10);
		
		JLabel textTipodiAnestesia = new JLabel("Tipo di anestesia: ");
		textTipodiAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTipodiAnestesia = new GridBagConstraints();
		gbc_textTipodiAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textTipodiAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textTipodiAnestesia.gridx = 0;
		gbc_textTipodiAnestesia.gridy = 12;
		contentPane.add(textTipodiAnestesia, gbc_textTipodiAnestesia);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"", "Generale", "Locoregionale", "Locale", "Spinale"}));
		spinner.setValue(valori[10]);
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 0);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 12;
		contentPane.add(spinner, gbc_spinner);
		
		JLabel textRischioAnestesiologico = new JLabel("Rischio anestesiologico:");
		textRischioAnestesiologico.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textRischioAnestesiologico = new GridBagConstraints();
		gbc_textRischioAnestesiologico.anchor = GridBagConstraints.WEST;
		gbc_textRischioAnestesiologico.insets = new Insets(0, 0, 5, 5);
		gbc_textRischioAnestesiologico.gridx = 0;
		gbc_textRischioAnestesiologico.gridy = 13;
		contentPane.add(textRischioAnestesiologico, gbc_textRischioAnestesiologico);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerListModel(new String[] {"", "Asa1", "Asa2", "Asa3", "Asa4", "Asa5"}));
		spinner_1.setValue(valori[11]);
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_1.gridx = 2;
		gbc_spinner_1.gridy = 13;
		contentPane.add(spinner_1, gbc_spinner_1);
		
		JLabel textNomeEquipe = new JLabel("Membri dell’equipe");
		textNomeEquipe.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_textNomeEquipe = new GridBagConstraints();
		gbc_textNomeEquipe.anchor = GridBagConstraints.WEST;
		gbc_textNomeEquipe.insets = new Insets(0, 0, 5, 5);
		gbc_textNomeEquipe.gridx = 0;
		gbc_textNomeEquipe.gridy = 15;
		contentPane.add(textNomeEquipe, gbc_textNomeEquipe);
		
		JLabel textPrimoOperatore = new JLabel("Primo Operatore:");
		textPrimoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textPrimoOperatore = new GridBagConstraints();
		gbc_textPrimoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textPrimoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textPrimoOperatore.gridx = 0;
		gbc_textPrimoOperatore.gridy = 16;
		contentPane.add(textPrimoOperatore, gbc_textPrimoOperatore);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 16;
		contentPane.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		textPrimoOperatoreVerbale = new JTextField();
		textPrimoOperatoreVerbale.setText(valori[12]);
		textPrimoOperatoreVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textPrimoOperatoreVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textPrimoOperatoreVerbale.setColumns(10);
		panel_4.add(textPrimoOperatoreVerbale);
		
		JLabel textSecondoOperatore = new JLabel("Secondo Operatore:");
		textSecondoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textSecondoOperatore = new GridBagConstraints();
		gbc_textSecondoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textSecondoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textSecondoOperatore.gridx = 0;
		gbc_textSecondoOperatore.gridy = 17;
		contentPane.add(textSecondoOperatore, gbc_textSecondoOperatore);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 17;
		contentPane.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		textSecondoOperatoreVerbale = new JTextField();
		textSecondoOperatoreVerbale.setText(valori[13]);
		textSecondoOperatoreVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textSecondoOperatoreVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textSecondoOperatoreVerbale.setColumns(10);
		panel_2.add(textSecondoOperatoreVerbale);
		
		JLabel textTerzoOperatore = new JLabel("Terzo Operatore:");
		textTerzoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTerzoOperatore = new GridBagConstraints();
		gbc_textTerzoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textTerzoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textTerzoOperatore.gridx = 0;
		gbc_textTerzoOperatore.gridy = 18;
		contentPane.add(textTerzoOperatore, gbc_textTerzoOperatore);
		
		JPanel panel_1_9 = new JPanel();
		GridBagConstraints gbc_panel_1_9 = new GridBagConstraints();
		gbc_panel_1_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1_9.gridx = 2;
		gbc_panel_1_9.gridy = 18;
		contentPane.add(panel_1_9, gbc_panel_1_9);
		panel_1_9.setLayout(new BoxLayout(panel_1_9, BoxLayout.X_AXIS));
		
		textTerzoOperatoreVerbale = new JTextField();
		textTerzoOperatoreVerbale.setText(valori[14]);
		textTerzoOperatoreVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textTerzoOperatoreVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textTerzoOperatoreVerbale.setColumns(10);
		panel_1_9.add(textTerzoOperatoreVerbale);
		
		JLabel textAnestesita = new JLabel("Anestesita:");
		textAnestesita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textAnestesita = new GridBagConstraints();
		gbc_textAnestesita.anchor = GridBagConstraints.WEST;
		gbc_textAnestesita.insets = new Insets(0, 0, 5, 5);
		gbc_textAnestesita.gridx = 0;
		gbc_textAnestesita.gridy = 19;
		contentPane.add(textAnestesita, gbc_textAnestesita);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 19;
		contentPane.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		textAnestesistaVerbale = new JTextField();
		textAnestesistaVerbale.setText(valori[15]);
		textAnestesistaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textAnestesistaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textAnestesistaVerbale.setColumns(10);
		panel_5.add(textAnestesistaVerbale);
		
		JLabel textStrumentista = new JLabel("Strumentista:");
		textStrumentista.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textStrumentista = new GridBagConstraints();
		gbc_textStrumentista.anchor = GridBagConstraints.WEST;
		gbc_textStrumentista.insets = new Insets(0, 0, 5, 5);
		gbc_textStrumentista.gridx = 0;
		gbc_textStrumentista.gridy = 20;
		contentPane.add(textStrumentista, gbc_textStrumentista);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_6.gridx = 2;
		gbc_panel_6.gridy = 20;
		contentPane.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		textStrumentistaVerbale = new JTextField();
		textStrumentistaVerbale.setText(valori[16]);
		textStrumentistaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textStrumentistaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textStrumentistaVerbale.setColumns(10);
		panel_6.add(textStrumentistaVerbale);
		
		JLabel textInfermierediSala = new JLabel("Infermiere di sala:");
		textInfermierediSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textInfermierediSala = new GridBagConstraints();
		gbc_textInfermierediSala.anchor = GridBagConstraints.WEST;
		gbc_textInfermierediSala.insets = new Insets(0, 0, 5, 5);
		gbc_textInfermierediSala.gridx = 0;
		gbc_textInfermierediSala.gridy = 21;
		contentPane.add(textInfermierediSala, gbc_textInfermierediSala);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_7.gridx = 2;
		gbc_panel_7.gridy = 21;
		contentPane.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		textInfermierediSalaVerbale = new JTextField();
		textInfermierediSalaVerbale.setText(valori[17]);
		textInfermierediSalaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textInfermierediSalaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textInfermierediSalaVerbale.setColumns(10);
		panel_7.add(textInfermierediSalaVerbale);
		
		JLabel textAiutoanestesista = new JLabel("Aiutoanestesista:");
		textAiutoanestesista.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textAiutoanestesista = new GridBagConstraints();
		gbc_textAiutoanestesista.anchor = GridBagConstraints.WEST;
		gbc_textAiutoanestesista.insets = new Insets(0, 0, 5, 5);
		gbc_textAiutoanestesista.gridx = 0;
		gbc_textAiutoanestesista.gridy = 22;
		contentPane.add(textAiutoanestesista, gbc_textAiutoanestesista);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_8.gridx = 2;
		gbc_panel_8.gridy = 22;
		contentPane.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		textAiutoanestetistaVerbale = new JTextField();
		textAiutoanestetistaVerbale.setText(valori[18]);
		textAiutoanestetistaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textAiutoanestetistaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textAiutoanestetistaVerbale.setColumns(10);
		panel_8.add(textAiutoanestetistaVerbale);
		
		JLabel textTecnicodiRadiologia = new JLabel("Tecnico di radiologia:");
		textTecnicodiRadiologia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTecnicodiRadiologia = new GridBagConstraints();
		gbc_textTecnicodiRadiologia.anchor = GridBagConstraints.WEST;
		gbc_textTecnicodiRadiologia.insets = new Insets(0, 0, 5, 5);
		gbc_textTecnicodiRadiologia.gridx = 0;
		gbc_textTecnicodiRadiologia.gridy = 23;
		contentPane.add(textTecnicodiRadiologia, gbc_textTecnicodiRadiologia);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 23;
		contentPane.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		textTecnicodiRadiologiaVerbale = new JTextField();
		textTecnicodiRadiologiaVerbale.setText(valori[19]);
		textTecnicodiRadiologiaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textTecnicodiRadiologiaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textTecnicodiRadiologiaVerbale.setColumns(10);
		panel_3.add(textTecnicodiRadiologiaVerbale);
		
		JLabel textDiagnosi = new JLabel("Diagnosi:");
		textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDiagnosi = new GridBagConstraints();
		gbc_textDiagnosi.anchor = GridBagConstraints.WEST;
		gbc_textDiagnosi.insets = new Insets(0, 0, 5, 5);
		gbc_textDiagnosi.gridx = 0;
		gbc_textDiagnosi.gridy = 25;
		contentPane.add(textDiagnosi, gbc_textDiagnosi);

		JLabel textDiagnosiVerbale = new JLabel();
		textDiagnosiVerbale.setText(dataService.getDiagnosiAnagrafica(valori[21]));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 25;
		contentPane.add(textDiagnosiVerbale, gbc_textArea);
		
		JLabel textIntervento = new JLabel("Intervento:");
		textIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textIntervento = new GridBagConstraints();
		gbc_textIntervento.anchor = GridBagConstraints.WEST;
		gbc_textIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textIntervento.gridx = 0;
		gbc_textIntervento.gridy = 26;
		contentPane.add(textIntervento, gbc_textIntervento);

		JLabel textInterventoVerbale = new JLabel();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		textDiagnosiVerbale.setText(dataService.getInterventoAnagrafica(valori[21]));
		gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 2;
		gbc_textArea_1.gridy = 26;
		contentPane.add(textInterventoVerbale, gbc_textArea_1);

		JLabel textProcedura = new JLabel("Procedura:");
		textProcedura.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textProcedura = new GridBagConstraints();
		gbc_textProcedura.anchor = GridBagConstraints.WEST;
		gbc_textProcedura.insets = new Insets(0, 0, 5, 5);
		gbc_textProcedura.gridx = 0;
		gbc_textProcedura.gridy = 27;
		contentPane.add(textProcedura, gbc_textProcedura);

		textProceduraVerbale = new JTextArea();
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.gridx = 2;
		gbc_textArea_2.gridy = 27;
		contentPane.add(textProceduraVerbale, gbc_textArea_2);

		
		JButton bottoneModifica = new JButton("Salva");
		bottoneModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salva();
			}
		});
		bottoneModifica.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneModifica = new GridBagConstraints();
		gbc_bottoneModifica.insets = new Insets(0, 0, 0, 5);
		gbc_bottoneModifica.gridx = 0;
		gbc_bottoneModifica.gridy = 29;
		contentPane.add(bottoneModifica, gbc_bottoneModifica);
		
		JButton bottoneConferma = new JButton("Chiudi senza salvare");
		bottoneConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chiudi();
			}
		});
		bottoneConferma.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneConferma = new GridBagConstraints();
		gbc_bottoneConferma.gridx = 2;
		gbc_bottoneConferma.gridy = 29;
		contentPane.add(bottoneConferma, gbc_bottoneConferma);

	}


	protected void chiudi() {
		VisualizzazioneVerbale visualizzaVerbale= new VisualizzazioneVerbale(codiceAnagrafica, matricolaDipendente);
		visualizzaVerbale.setVisible(true);
		dispose();
		
	}


	protected void salva() {
		
		String[] valori = {
				convertiOrario(spinnerOra1.getValue().toString(), spinnerMinuto1.getValue().toString()),
				convertiOrario(spinnerOra2.getValue().toString(), spinnerMinuto2.getValue().toString()),
				convertiOrario(spinnerOra3.getValue().toString(), spinnerMinuto3.getValue().toString()),
				convertiOrario(spinnerOra4.getValue().toString(), spinnerMinuto4.getValue().toString()),
				convertiOrario(spinnerOra5.getValue().toString(), spinnerMinuto5.getValue().toString()),
				convertiOrario(spinnerOra6.getValue().toString(), spinnerMinuto6.getValue().toString()),
				convertiOrario(spinnerOra7.getValue().toString(), spinnerMinuto7.getValue().toString()),
				convertiOrario(spinnerOra8.getValue().toString(), spinnerMinuto8.getValue().toString()),
				convertiOrario(spinnerOra9.getValue().toString(), spinnerMinuto9.getValue().toString()),
				convertiOrario(spinnerOra10.getValue().toString(), spinnerMinuto10.getValue().toString()),
				spinner.getValue().toString(),
				spinner_1.getValue().toString(),
				textPrimoOperatoreVerbale.getText(),
				textSecondoOperatoreVerbale.getText(),
				textTerzoOperatoreVerbale.getText(),
				textAnestesistaVerbale.getText(),
				textStrumentistaVerbale.getText(),
				textInfermierediSalaVerbale.getText(),
				textAiutoanestetistaVerbale.getText(),
				textTecnicodiRadiologiaVerbale.getText(),
				textProceduraVerbale.getText(),
				codiceAnagrafica
		};
		
		if(dataService.salvaVerbale(codiceVerbale, valori)) {
			chiudi();
		}
		else {
			JOptionPane.showMessageDialog(null,"Errore, tutti i campi contrassseganti con \"*\" devono essere compilati");
		}		
	}
	
	private String[] ore() {
		String[] ore = new String[25];
		ore[0] = "    ";
		for(int i = 1; i <= 24; i++)
			ore[i] = "" + (i - 1);
		return ore;
	}
	
	private String[] minuti() {
		String[] minuti = new String[61];
		minuti[0] = "    ";
		for(int i = 1; i <= 60; i++)
			minuti[i] = "" + (i - 1);
		return minuti;
	}
	
	private String convertiOrario(String ora, String minuto) {
		if(ora.equals("")) {
			return "";
		}
		if(minuto.equals("")) {
			return ora + ":00";
		}
		return ora + ":" + minuto;
	}
	
}
