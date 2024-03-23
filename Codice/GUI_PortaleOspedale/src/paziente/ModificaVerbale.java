package paziente;

import java.awt.Dimension;
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
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.DataService;

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
	private String codiceOperazioneAssociata;
	private String matricolaDipendente;
	private boolean nuovo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaVerbale frame = new ModificaVerbale("", "m001a", "1");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//codiceAnagrafica serve per collegare il verbale alla giusta anagrafica. Se si sta modificando
	//un verbale gia' esistente, questo e' gia' associato ad un'anagrafica e dunque codiceAnagrafica == ""
	public ModificaVerbale(String codiceVerbale, String matricolaDipendente, String codiceOperazioneAssociata) {
		
		dataService = new DataService();
		this.matricolaDipendente = matricolaDipendente;
		nuovo = !codiceOperazioneAssociata.equals("");
		String[] valori;
		
		//se il verbale � nuovo si genera un nuovo verbale e si prendono i valori di default,
		//altrimenti si considera il verbale esistente
		if(nuovo) {
			this.codiceVerbale = dataService.generaNuovoCodice("Verbale");
			valori = dataService.getValoriVerbale("0");
			this.codiceOperazioneAssociata = codiceOperazioneAssociata;
		}
		else {
			this.codiceVerbale = codiceVerbale;
			valori = dataService.getValoriVerbale(this.codiceVerbale);
			this.codiceOperazioneAssociata = valori[21];
		}
		
		String[] ore = generaOre();
		String[] minuti = generaMinuti();
		//si controlla dall'operazione se � prevista anestesia
		boolean anestesia = dataService.getAnestesiaOperazione(this.codiceOperazioneAssociata);
		int posY = 0;//variabile per il posizionamento degli oggetti nella gui
		Dimension dimensioneSpinner = new Dimension(40,22);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaVerbale.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale Papa Giovanni XIII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bottoneMostraAnagrafica = new JButton("Mostra Anagrafica");
		bottoneMostraAnagrafica.setBounds(482, 44, 161, 27);
		bottoneMostraAnagrafica.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneMostraAnagrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraAnagrafica();
			}
		});
		contentPane.add(bottoneMostraAnagrafica);
		
		JLabel textOradiIngresso = new JLabel("Ora di ingresso del blocco operatorio");
		textOradiIngresso.setBounds(5, 48, 282, 19);
		textOradiIngresso.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textOradiIngresso);
		
		JPanel panel = new JPanel();
		panel.setBounds(342, 76, 95, 32);
		contentPane.add(panel);
		
		spinnerOra1 = new JSpinner();
		spinnerOra1.setModel(new SpinnerListModel(ore));
		spinnerOra1.setValue(getOra(valori[0]));
		spinnerOra1.setFont(new Font("Arial", Font.PLAIN, 14));
		spinnerOra1.setPreferredSize(dimensioneSpinner);
		panel.add(spinnerOra1);
		
		spinnerMinuto1 = new JSpinner();
		spinnerMinuto1.setModel(new SpinnerListModel(minuti));
		spinnerMinuto1.setValue(getMinuto(valori[0]));
		spinnerMinuto1.setFont(new Font("Arial", Font.PLAIN, 14));
		spinnerMinuto1.setPreferredSize(dimensioneSpinner);
		panel.add(spinnerMinuto1);
	
		JLabel textOradiEntrata = new JLabel("Ora di entrata in sala operatoria");
		textOradiEntrata.setBounds(5, 82, 237, 19);
		textOradiEntrata.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textOradiEntrata);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(342, 113, 95, 32);
		contentPane.add(panel_1);
		
		spinnerOra2 = new JSpinner();
		spinnerOra2.setModel(new SpinnerListModel(ore));
		spinnerOra2.setValue(getOra(valori[1]));
		spinnerOra2.setFont(new Font("Arial", Font.PLAIN, 14));
		spinnerOra2.setPreferredSize(dimensioneSpinner);
		panel_1.add(spinnerOra2);
		
		spinnerMinuto2 = new JSpinner();
		spinnerMinuto2.setModel(new SpinnerListModel(minuti));
		spinnerMinuto2.setValue(getMinuto(valori[1]));
		spinnerMinuto2.setFont(new Font("Arial", Font.PLAIN, 14));
		spinnerMinuto2.setPreferredSize(dimensioneSpinner);
		panel_1.add(spinnerMinuto2);
		
		JLabel OrariodelPosizionamento = new JLabel("Orario del posizionamento del paziente");
		OrariodelPosizionamento.setBounds(5, 119, 297, 19);
		OrariodelPosizionamento.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(OrariodelPosizionamento);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(342, 150, 95, 32);
		contentPane.add(panel_1_1);
		
		spinnerOra3 = new JSpinner();
		spinnerOra3.setModel(new SpinnerListModel(ore));
		spinnerOra3.setValue(getMinuto(valori[2]));
		spinnerOra3.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra3.setPreferredSize(dimensioneSpinner);
		panel_1_1.add(spinnerOra3);
		
		spinnerMinuto3 = new JSpinner();
		spinnerMinuto3.setModel(new SpinnerListModel(minuti));
		spinnerMinuto3.setValue(getMinuto(valori[2]));
		spinnerMinuto3.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto3.setPreferredSize(dimensioneSpinner);
		panel_1_1.add(spinnerMinuto3);
		
		
		spinnerOra4 = new JSpinner();
		spinnerOra4.setModel(new SpinnerListModel(ore));
		spinnerOra4.setValue(getOra(valori[3]));
		
		spinnerMinuto4 = new JSpinner();
		spinnerMinuto4.setModel(new SpinnerListModel(minuti));
		spinnerMinuto4.setValue(getMinuto(valori[3]));
		
		spinnerOra5 = new JSpinner();
		spinnerOra5.setModel(new SpinnerListModel(ore));
		spinnerOra5.setValue(getMinuto(valori[4]));
		
		spinnerMinuto5 = new JSpinner();
		spinnerMinuto5.setModel(new SpinnerListModel(minuti));
		spinnerMinuto5.setValue(getMinuto(valori[4]));
		
		if(anestesia) {
			JLabel textOradiInizioAnestesia = new JLabel("Ora inizio anestesia");
			textOradiInizioAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textOradiInizioAnestesia = new GridBagConstraints();
			gbc_textOradiInizioAnestesia.anchor = GridBagConstraints.WEST;
			gbc_textOradiInizioAnestesia.insets = new Insets(0, 0, 5, 5);
			gbc_textOradiInizioAnestesia.gridx = 0;
			gbc_textOradiInizioAnestesia.gridy = posY;
			contentPane.add(textOradiInizioAnestesia, gbc_textOradiInizioAnestesia);
			
			JPanel panel_1_2 = new JPanel();
			GridBagConstraints gbc_panel_1_2 = new GridBagConstraints();
			gbc_panel_1_2.anchor = GridBagConstraints.WEST;
			gbc_panel_1_2.insets = new Insets(0, 0, 5, 0);
			gbc_panel_1_2.gridx = 2;
			gbc_panel_1_2.gridy = posY++;
			contentPane.add(panel_1_2, gbc_panel_1_2);
			
			
			spinnerOra4.setFont(new Font("Arial", Font.BOLD, 14));
			spinnerOra4.setPreferredSize(dimensioneSpinner);
			panel_1_2.add(spinnerOra4);
			
			
			spinnerMinuto4.setFont(new Font("Arial", Font.BOLD, 14));
			spinnerMinuto4.setPreferredSize(dimensioneSpinner);
			panel_1_2.add(spinnerMinuto4);
		
		
			JLabel textOradiFineAnestesia = new JLabel("Ora fine anestesia");
			textOradiFineAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textOradiFineAnestesia = new GridBagConstraints();
			gbc_textOradiFineAnestesia.anchor = GridBagConstraints.WEST;
			gbc_textOradiFineAnestesia.insets = new Insets(0, 0, 5, 5);
			gbc_textOradiFineAnestesia.gridx = 0;
			gbc_textOradiFineAnestesia.gridy = posY;
			contentPane.add(textOradiFineAnestesia, gbc_textOradiFineAnestesia);
			
			JPanel panel_1_3 = new JPanel();
			GridBagConstraints gbc_panel_1_3 = new GridBagConstraints();
			gbc_panel_1_3.anchor = GridBagConstraints.WEST;
			gbc_panel_1_3.insets = new Insets(0, 0, 5, 0);
			gbc_panel_1_3.gridx = 2;
			gbc_panel_1_3.gridy = posY++;
			contentPane.add(panel_1_3, gbc_panel_1_3);
			
			
			spinnerOra5.setFont(new Font("Arial", Font.BOLD, 14));
			spinnerOra5.setPreferredSize(dimensioneSpinner);
			panel_1_3.add(spinnerOra5);
			
			
			spinnerMinuto5.setFont(new Font("Arial", Font.BOLD, 14));
			spinnerMinuto5.setPreferredSize(dimensioneSpinner);
			panel_1_3.add(spinnerMinuto5);
		}
		
		
		JLabel textOradiIntervento = new JLabel("Ora inizio intervento*");
		textOradiIntervento.setBounds(5, 156, 159, 19);
		textOradiIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textOradiIntervento);
		
		JPanel panel_1_7 = new JPanel();
		panel_1_7.setBounds(342, 187, 95, 32);
		contentPane.add(panel_1_7);
		
		spinnerOra6 = new JSpinner();
		spinnerOra6.setModel(new SpinnerListModel(ore));
		spinnerOra6.setValue(getOra(valori[5]));
		spinnerOra6.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra6.setPreferredSize(dimensioneSpinner);
		panel_1_7.add(spinnerOra6);
		
		spinnerMinuto6 = new JSpinner();
		spinnerMinuto6.setModel(new SpinnerListModel(minuti));
		spinnerMinuto6.setValue(getMinuto(valori[5]));
		spinnerMinuto6.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto6.setPreferredSize(dimensioneSpinner);
		panel_1_7.add(spinnerMinuto6);
		
		JLabel textOradiFineIntervento = new JLabel("Ora fine intervento*");
		textOradiFineIntervento.setBounds(5, 193, 146, 19);
		textOradiFineIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textOradiFineIntervento);
		
		JPanel panel_1_8 = new JPanel();
		panel_1_8.setBounds(342, 224, 95, 32);
		contentPane.add(panel_1_8);
		
		spinnerOra7 = new JSpinner();
		spinnerOra7.setModel(new SpinnerListModel(ore));
		spinnerOra7.setValue(getOra(valori[6]));
		spinnerOra7.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra7.setPreferredSize(dimensioneSpinner);
		panel_1_8.add(spinnerOra7);
		
		spinnerMinuto7 = new JSpinner();
		spinnerMinuto7.setModel(new SpinnerListModel(minuti));
		spinnerMinuto7.setValue(getMinuto(valori[6]));
		spinnerMinuto7.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto7.setPreferredSize(dimensioneSpinner);
		panel_1_8.add(spinnerMinuto7);
		
		JLabel textOradiRisveglio = new JLabel("Ora risveglio");
		textOradiRisveglio.setBounds(5, 230, 96, 19);
		textOradiRisveglio.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textOradiRisveglio);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBounds(342, 261, 95, 32);
		contentPane.add(panel_1_4);
		
		spinnerOra8 = new JSpinner();
		spinnerOra8.setModel(new SpinnerListModel(ore));
		spinnerOra8.setValue(getOra(valori[7]));
		spinnerOra8.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra8.setPreferredSize(dimensioneSpinner);
		panel_1_4.add(spinnerOra8);
		
		spinnerMinuto8 = new JSpinner();
		spinnerMinuto8.setModel(new SpinnerListModel(minuti));
		spinnerMinuto8.setValue(getMinuto(valori[7]));
		spinnerMinuto8.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto8.setPreferredSize(dimensioneSpinner);
		panel_1_4.add(spinnerMinuto8);
		
		JLabel textOradiUscitaSala = new JLabel("Ora uscita sala operatoria");
		textOradiUscitaSala.setBounds(5, 267, 194, 19);
		textOradiUscitaSala.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textOradiUscitaSala);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBounds(342, 298, 95, 32);
		contentPane.add(panel_1_5);
		
		spinnerOra9 = new JSpinner();
		spinnerOra9.setModel(new SpinnerListModel(ore));
		spinnerOra9.setValue(getOra(valori[8]));
		spinnerOra9.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra9.setPreferredSize(dimensioneSpinner);
		panel_1_5.add(spinnerOra9);
		
		spinnerMinuto9 = new JSpinner();
		spinnerMinuto9.setModel(new SpinnerListModel(minuti));
		spinnerMinuto9.setValue(getMinuto(valori[8]));
		spinnerMinuto9.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto9.setPreferredSize(dimensioneSpinner);
		panel_1_5.add(spinnerMinuto9);
		
		JLabel textOraduUscita = new JLabel("Ora uscita blocco operatorio");
		textOraduUscita.setBounds(5, 304, 216, 19);
		textOraduUscita.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textOraduUscita);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setBounds(342, 335, 95, 32);
		contentPane.add(panel_1_6);
		
		spinnerOra10 = new JSpinner();
		spinnerOra10.setModel(new SpinnerListModel(ore));
		spinnerOra10.setValue(getOra(valori[9]));
		spinnerOra10.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra10.setPreferredSize(dimensioneSpinner);
		panel_1_6.add(spinnerOra10);
		
		spinnerMinuto10 = new JSpinner();
		spinnerMinuto10.setModel(new SpinnerListModel(minuti));
		spinnerMinuto10.setValue(getMinuto(valori[9]));
		spinnerMinuto10.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto10.setPreferredSize(dimensioneSpinner);
		panel_1_6.add(spinnerMinuto10);
		
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"", "Generale", "Locoregionale", "Locale", "Spinale"}));
		spinner.setValue(valori[10]);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerListModel(new String[] {"", "Asa1", "Asa2", "Asa3", "Asa4", "Asa5"}));
		spinner_1.setValue(valori[11]);		
		
		if(anestesia) {
		
			JLabel textTipodiAnestesia = new JLabel("Tipo di anestesia: ");
			textTipodiAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textTipodiAnestesia = new GridBagConstraints();
			gbc_textTipodiAnestesia.anchor = GridBagConstraints.WEST;
			gbc_textTipodiAnestesia.insets = new Insets(0, 0, 5, 5);
			gbc_textTipodiAnestesia.gridx = 0;
			gbc_textTipodiAnestesia.gridy = posY;
			contentPane.add(textTipodiAnestesia, gbc_textTipodiAnestesia);
			
			
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
			gbc_spinner.insets = new Insets(0, 0, 5, 0);
			gbc_spinner.gridx = 2;
			gbc_spinner.gridy = posY++;
			contentPane.add(spinner, gbc_spinner);
			
			JLabel textRischioAnestesiologico = new JLabel("Rischio anestesiologico:");
			textRischioAnestesiologico.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textRischioAnestesiologico = new GridBagConstraints();
			gbc_textRischioAnestesiologico.anchor = GridBagConstraints.WEST;
			gbc_textRischioAnestesiologico.insets = new Insets(0, 0, 5, 5);
			gbc_textRischioAnestesiologico.gridx = 0;
			gbc_textRischioAnestesiologico.gridy = posY;
			contentPane.add(textRischioAnestesiologico, gbc_textRischioAnestesiologico);
			
			
			GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
			gbc_spinner_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_spinner_1.insets = new Insets(0, 0, 5, 0);
			gbc_spinner_1.gridx = 2;
			gbc_spinner_1.gridy = posY++;
			contentPane.add(spinner_1, gbc_spinner_1);
		}
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(342, 372, 442, 23);
		contentPane.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		textPrimoOperatoreVerbale = new JTextField();
		textPrimoOperatoreVerbale.setText(valori[12]);
		textPrimoOperatoreVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textPrimoOperatoreVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textPrimoOperatoreVerbale.setColumns(10);
		panel_4.add(textPrimoOperatoreVerbale);
		
		JLabel textSecondoOperatore = new JLabel("Secondo Operatore*:");
		textSecondoOperatore.setBounds(5, 374, 161, 19);
		textSecondoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textSecondoOperatore);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(342, 400, 442, 23);
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		textSecondoOperatoreVerbale = new JTextField();
		if(valori[13].equals("")) {
			valori[13] = "nessun operatore";
		}
		textSecondoOperatoreVerbale.setText(valori[13]);
		textSecondoOperatoreVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textSecondoOperatoreVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textSecondoOperatoreVerbale.setColumns(10);
		panel_2.add(textSecondoOperatoreVerbale);
		
		JLabel textTerzoOperatore = new JLabel("Terzo Operatore:");
		textTerzoOperatore.setBounds(5, 402, 130, 19);
		textTerzoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textTerzoOperatore);
		
		JPanel panel_1_9 = new JPanel();
		panel_1_9.setBounds(342, 428, 442, 23);
		contentPane.add(panel_1_9);
		panel_1_9.setLayout(new BoxLayout(panel_1_9, BoxLayout.X_AXIS));
		
		textTerzoOperatoreVerbale = new JTextField();
		textTerzoOperatoreVerbale.setText(valori[14]);
		textTerzoOperatoreVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textTerzoOperatoreVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textTerzoOperatoreVerbale.setColumns(10);
		panel_1_9.add(textTerzoOperatoreVerbale);
		
		textAnestesistaVerbale = new JTextField();
		textAnestesistaVerbale.setText(valori[15]);
		
		if(anestesia) {
			JLabel textAnestesita = new JLabel("Anestesita:");
			textAnestesita.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textAnestesita = new GridBagConstraints();
			gbc_textAnestesita.anchor = GridBagConstraints.WEST;
			gbc_textAnestesita.insets = new Insets(0, 0, 5, 5);
			gbc_textAnestesita.gridx = 0;
			gbc_textAnestesita.gridy = posY;
			contentPane.add(textAnestesita, gbc_textAnestesita);
			
			JPanel panel_5 = new JPanel();
			GridBagConstraints gbc_panel_5 = new GridBagConstraints();
			gbc_panel_5.insets = new Insets(0, 0, 5, 0);
			gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
			gbc_panel_5.gridx = 2;
			gbc_panel_5.gridy = posY++;
			contentPane.add(panel_5, gbc_panel_5);
			panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
			
			textAnestesistaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
			textAnestesistaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
			textAnestesistaVerbale.setColumns(10);
			panel_5.add(textAnestesistaVerbale);
		}
		
		
		JLabel textStrumentista = new JLabel("Strumentista:");
		textStrumentista.setBounds(5, 430, 103, 19);
		textStrumentista.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textStrumentista);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(342, 457, 442, 23);
		contentPane.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		textStrumentistaVerbale = new JTextField();
		textStrumentistaVerbale.setText(valori[16]);
		textStrumentistaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textStrumentistaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textStrumentistaVerbale.setColumns(10);
		panel_6.add(textStrumentistaVerbale);
		
		JLabel textInfermierediSala = new JLabel("Infermiere di sala*:");
		textInfermierediSala.setBounds(5, 459, 141, 19);
		textInfermierediSala.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textInfermierediSala);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(342, 486, 442, 23);
		contentPane.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		textInfermierediSalaVerbale = new JTextField();
		textInfermierediSalaVerbale.setText(valori[17]);
		textInfermierediSalaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textInfermierediSalaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textInfermierediSalaVerbale.setColumns(10);
		panel_7.add(textInfermierediSalaVerbale);
		
		textAiutoanestetistaVerbale = new JTextField();
		textAiutoanestetistaVerbale.setText(valori[18]);
		
		if(anestesia) {
			JLabel textAiutoanestesista = new JLabel("Aiutoanestesista:");
			textAiutoanestesista.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textAiutoanestesista = new GridBagConstraints();
			gbc_textAiutoanestesista.anchor = GridBagConstraints.WEST;
			gbc_textAiutoanestesista.insets = new Insets(0, 0, 5, 5);
			gbc_textAiutoanestesista.gridx = 0;
			gbc_textAiutoanestesista.gridy = posY;
			contentPane.add(textAiutoanestesista, gbc_textAiutoanestesista);
			
			JPanel panel_8 = new JPanel();
			GridBagConstraints gbc_panel_8 = new GridBagConstraints();
			gbc_panel_8.insets = new Insets(0, 0, 5, 0);
			gbc_panel_8.fill = GridBagConstraints.HORIZONTAL;
			gbc_panel_8.gridx = 2;
			gbc_panel_8.gridy = posY++;
			contentPane.add(panel_8, gbc_panel_8);
			panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
			
			
			textAiutoanestetistaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
			textAiutoanestetistaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
			textAiutoanestetistaVerbale.setColumns(10);
			panel_8.add(textAiutoanestetistaVerbale);
		}
		
		
		JLabel textTecnicodiRadiologia = new JLabel("Tecnico di radiologia:");
		textTecnicodiRadiologia.setBounds(5, 488, 165, 19);
		textTecnicodiRadiologia.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textTecnicodiRadiologia);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(342, 514, 442, 23);
		contentPane.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		textTecnicodiRadiologiaVerbale = new JTextField();
		textTecnicodiRadiologiaVerbale.setText(valori[19]);
		textTecnicodiRadiologiaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textTecnicodiRadiologiaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textTecnicodiRadiologiaVerbale.setColumns(10);
		panel_3.add(textTecnicodiRadiologiaVerbale);
		
		JLabel textDiagnosi = new JLabel("Diagnosi:");
		textDiagnosi.setBounds(5, 13, 74, 19);
		textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textDiagnosi);

		JLabel textDiagnosiVerbale = new JLabel();
		textDiagnosiVerbale.setBounds(342, 542, 442, 19);
		textDiagnosiVerbale.setText(dataService.getDiagnosiOperazione(this.codiceOperazioneAssociata));
		contentPane.add(textDiagnosiVerbale);
		
		JLabel textIntervento = new JLabel("Intervento:");
		textIntervento.setBounds(5, 542, 83, 19);
		textIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textIntervento);

		JLabel textInterventoVerbale = new JLabel();
		textInterventoVerbale.setBounds(342, 566, 442, 19);
		textDiagnosiVerbale.setText(dataService.getInterventoOperazione(this.codiceOperazioneAssociata));
		contentPane.add(textInterventoVerbale);

		JLabel textProcedura = new JLabel("Procedura*:");
		textProcedura.setBounds(5, 566, 92, 19);
		textProcedura.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textProcedura);

		textProceduraVerbale = new JTextArea();
		textProceduraVerbale.setBounds(342, 590, 442, 22);
		textProceduraVerbale.setText(valori[20]);
		contentPane.add(textProceduraVerbale);

		
		JButton bottoneSalva = new JButton("Salva");
		bottoneSalva.setBounds(120, 12, 67, 25);
		bottoneSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salva();
			}
		});
		bottoneSalva.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(bottoneSalva);
		
		JButton bottoneConferma = new JButton("Chiudi senza salvare");
		bottoneConferma.setBounds(481, 591, 163, 25);
		bottoneConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chiudi();
			}
		});
		bottoneConferma.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(bottoneConferma);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(5, 0, 779, 821);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel textNomeEquipe = new JLabel("Membri dell�equipe");
		textNomeEquipe.setBounds(332, 700, 177, 22);
		panel_5.add(textNomeEquipe);
		textNomeEquipe.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel textVerbalePaziente = new JLabel("Verbale Operazione:");
		textVerbalePaziente.setBounds(105, 657, 143, 17);
		panel_5.add(textVerbalePaziente);
		textVerbalePaziente.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel textPrimoOperatore = new JLabel("Primo Operatore*:");
		textPrimoOperatore.setBounds(111, 684, 137, 19);
		panel_5.add(textPrimoOperatore);
		textPrimoOperatore.setFont(new Font("Arial", Font.BOLD, 16));

	}
	
	protected void mostraAnagrafica() {
		String codiceAnagraficaAssociata = dataService.getCodiceAnagraficaOperazione(codiceOperazioneAssociata);
		VisualizzazionePaginaAnagrafica visualizzaAnagrafica= new VisualizzazionePaginaAnagrafica(codiceAnagraficaAssociata, matricolaDipendente);
		visualizzaAnagrafica.setVisible(true);
				
		
	}


	//se si sta chiudento un verbale non salvato si decrementa l'indice dei codici dei verbali,
	//altrimenti si mostra il verbale salvato
	protected void chiudi() {
		if(nuovo) {
			dataService.decrementaCodice(codiceVerbale, "Verbale");
		}
		dispose();
		
	}


	protected void salva() {
		
		if(textSecondoOperatoreVerbale.getText().trim().equals("")) {
			textSecondoOperatoreVerbale.setText("nessun operatore");
		}
		
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
				textPrimoOperatoreVerbale.getText().toLowerCase().trim(),
				textSecondoOperatoreVerbale.getText().toLowerCase().trim(),
				textTerzoOperatoreVerbale.getText().toLowerCase().trim(),
				textAnestesistaVerbale.getText().toLowerCase().trim(),
				textStrumentistaVerbale.getText().toLowerCase(),
				textInfermierediSalaVerbale.getText().toLowerCase().trim(),
				textAiutoanestetistaVerbale.getText().toLowerCase().trim(),
				textTecnicodiRadiologiaVerbale.getText().toLowerCase().trim(),
				textProceduraVerbale.getText(),
				codiceOperazioneAssociata
		};
		
		switch(dataService.salvaVerbale(codiceVerbale, valori, nuovo)) {
			
			case "-1": 
				JOptionPane.showMessageDialog(null,
						"Errore, tutti i campi contrassseganti con * devono essere compilati");
				break;
			case "-2":
				JOptionPane.showMessageDialog(null,
						"Errore, non esiste nessun medico con matricola \"" + valori[12] + "\" (campo \"Primo operatore\")" );
				break;
			case "-3":
				JOptionPane.showMessageDialog(null,
						"Errore, non esiste nessun medico con matricola \"" + valori[13] + "\" (campo \"Secondo operatore\")" );
				break;
			case "-4":
				JOptionPane.showMessageDialog(null,
						"Errore, non esiste nessun medico con matricola \"" + valori[14] + "\" (campo \"Terzo operatore\")" );
				break;
			case "-5":
				JOptionPane.showMessageDialog(null,
						"Errore, non esiste nessun medico con matricola \"" + valori[15] + "\" (campo \"Anestesista\")" );
				break;
			case "-6":
				JOptionPane.showMessageDialog(null,
						"Errore, non esiste nessun infermiere con matricola \"" + valori[16] + "\" (campo \"Strumentista\")" );
				break;
			case "-7":
				JOptionPane.showMessageDialog(null,
						"Errore, non esiste nessun infermiere con matricola \"" + valori[17] + "\" (campo \"Inferiere di sala\")" );
				break;
			case "-8":
				JOptionPane.showMessageDialog(null,
						"Errore, non esiste nessun infermiere con matricola \"" + valori[18] + "\" (campo \"Aiuto anestesista\")" );
				break;
			case "-9":
			default :
				nuovo = false;
				chiudi();
				break;
		}		
	}
	
	//si genera un array di numeri (che in realt� sono stringhe) da 00 a 23 e con un elemento ""
	private String[] generaOre() {
		String[] ore = new String[25];
		ore[0] = "";
		for(int i = 1; i <= 24; i++) {
			ore[i] = "" + (i - 1);
			if(i-1 < 10) {
				ore[i] = "0" + ore[i];
			}
		}
		return ore;
	}
	
	//si genera un array di numeri (che in realt� sono stringhe) da 00 a 59 e con un elemento ""
	private String[] generaMinuti() {
		String[] minuti = new String[61];
		minuti[0] = "";
		for(int i = 1; i <= 60; i++) {
			minuti[i] = "" + (i - 1);
			if(i-1 < 10) {
				minuti[i] = "0" + minuti[i];
			}
		}
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
	
	public String getMinuto(String orario) {
		if(orario.equals("")) {
			return "";
		}
		else {
			int posizioneIniziale = orario.indexOf(":") + 1;
			return orario.substring(posizioneIniziale);
		}
	}
	
	public String getOra(String orario) {
		if(orario.equals("")) {
			return "";
		}
		else {
			int posizioneFinale = orario.indexOf(":");
			return orario.substring(0, posizioneFinale);
		}
		
	}
	
	
}
