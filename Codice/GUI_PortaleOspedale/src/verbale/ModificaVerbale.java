package verbale;

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
import paginaAnagrafica.VisualizzazionePaginaAnagrafica;

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
					ModificaVerbale frame = new ModificaVerbale("", "m001a", "3");
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
		
		//se il verbale è nuovo si genera un nuovo verbale e si prendono i valori di default,
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
		//si controlla dall'operazione se è prevista anestesia
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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{148, 35, 442, 0};
		gbl_contentPane.rowHeights = new int[]{38, 24, 24, 24, 19, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 62, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textVerbalePaziente = new JLabel("Verbale Operazione N. " + this.codiceVerbale + ":");
		textVerbalePaziente.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_textVerbalePaziente = new GridBagConstraints();
		gbc_textVerbalePaziente.anchor = GridBagConstraints.WEST;
		gbc_textVerbalePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textVerbalePaziente.gridx = 0;
		gbc_textVerbalePaziente.gridy = posY;
		contentPane.add(textVerbalePaziente, gbc_textVerbalePaziente);
		
		JButton bottoneMostraAnagrafica = new JButton("Mostra Anagrafica");
		bottoneMostraAnagrafica.setFont(new Font("Arial", Font.PLAIN, 16));
		bottoneMostraAnagrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraAnagrafica();
			}
		});
		GridBagConstraints gbc_mostraAnagrafica = new GridBagConstraints();
		gbc_mostraAnagrafica.insets = new Insets(0, 0, 5, 0);
		gbc_mostraAnagrafica.gridx = 2;
		gbc_mostraAnagrafica.gridy = posY++;
		contentPane.add(bottoneMostraAnagrafica, gbc_mostraAnagrafica);
		
		JLabel textOradiIngresso = new JLabel("Ora di ingresso del blocco operatorio");
		textOradiIngresso.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiIngresso = new GridBagConstraints();
		gbc_textOradiIngresso.anchor = GridBagConstraints.WEST;
		gbc_textOradiIngresso.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiIngresso.gridx = 0;
		gbc_textOradiIngresso.gridy = posY;
		contentPane.add(textOradiIngresso, gbc_textOradiIngresso);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = posY++;
		contentPane.add(panel, gbc_panel);
		
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
		textOradiEntrata.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiEntrata = new GridBagConstraints();
		gbc_textOradiEntrata.anchor = GridBagConstraints.WEST;
		gbc_textOradiEntrata.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiEntrata.gridx = 0;
		gbc_textOradiEntrata.gridy = posY;
		contentPane.add(textOradiEntrata, gbc_textOradiEntrata);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = posY++;
		contentPane.add(panel_1, gbc_panel_1);
		
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
		OrariodelPosizionamento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_OrariodelPosizionamento = new GridBagConstraints();
		gbc_OrariodelPosizionamento.anchor = GridBagConstraints.WEST;
		gbc_OrariodelPosizionamento.insets = new Insets(0, 0, 5, 5);
		gbc_OrariodelPosizionamento.gridx = 0;
		gbc_OrariodelPosizionamento.gridy = posY;
		contentPane.add(OrariodelPosizionamento, gbc_OrariodelPosizionamento);
		
		JPanel panel_1_1 = new JPanel();
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_1.gridx = 2;
		gbc_panel_1_1.gridy = posY++;
		contentPane.add(panel_1_1, gbc_panel_1_1);
		
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
		textOradiIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiIntervento = new GridBagConstraints();
		gbc_textOradiIntervento.anchor = GridBagConstraints.WEST;
		gbc_textOradiIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiIntervento.gridx = 0;
		gbc_textOradiIntervento.gridy = posY;
		contentPane.add(textOradiIntervento, gbc_textOradiIntervento);
		
		JPanel panel_1_7 = new JPanel();
		GridBagConstraints gbc_panel_1_7 = new GridBagConstraints();
		gbc_panel_1_7.anchor = GridBagConstraints.WEST;
		gbc_panel_1_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_7.gridx = 2;
		gbc_panel_1_7.gridy = posY++;
		contentPane.add(panel_1_7, gbc_panel_1_7);
		
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
		textOradiFineIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiFineIntervento = new GridBagConstraints();
		gbc_textOradiFineIntervento.anchor = GridBagConstraints.WEST;
		gbc_textOradiFineIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiFineIntervento.gridx = 0;
		gbc_textOradiFineIntervento.gridy = posY;
		contentPane.add(textOradiFineIntervento, gbc_textOradiFineIntervento);
		
		JPanel panel_1_8 = new JPanel();
		GridBagConstraints gbc_panel_1_8 = new GridBagConstraints();
		gbc_panel_1_8.anchor = GridBagConstraints.WEST;
		gbc_panel_1_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_8.gridx = 2;
		gbc_panel_1_8.gridy = posY++;
		contentPane.add(panel_1_8, gbc_panel_1_8);
		
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
		textOradiRisveglio.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiRisveglio = new GridBagConstraints();
		gbc_textOradiRisveglio.anchor = GridBagConstraints.WEST;
		gbc_textOradiRisveglio.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiRisveglio.gridx = 0;
		gbc_textOradiRisveglio.gridy = posY;
		contentPane.add(textOradiRisveglio, gbc_textOradiRisveglio);
		
		JPanel panel_1_4 = new JPanel();
		GridBagConstraints gbc_panel_1_4 = new GridBagConstraints();
		gbc_panel_1_4.anchor = GridBagConstraints.WEST;
		gbc_panel_1_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_4.gridx = 2;
		gbc_panel_1_4.gridy = posY++;
		contentPane.add(panel_1_4, gbc_panel_1_4);
		
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
		textOradiUscitaSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiUscitaSala = new GridBagConstraints();
		gbc_textOradiUscitaSala.anchor = GridBagConstraints.WEST;
		gbc_textOradiUscitaSala.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiUscitaSala.gridx = 0;
		gbc_textOradiUscitaSala.gridy = posY;
		contentPane.add(textOradiUscitaSala, gbc_textOradiUscitaSala);
		
		JPanel panel_1_5 = new JPanel();
		GridBagConstraints gbc_panel_1_5 = new GridBagConstraints();
		gbc_panel_1_5.anchor = GridBagConstraints.WEST;
		gbc_panel_1_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_5.gridx = 2;
		gbc_panel_1_5.gridy = posY++;
		contentPane.add(panel_1_5, gbc_panel_1_5);
		
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
		textOraduUscita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOraduUscita = new GridBagConstraints();
		gbc_textOraduUscita.anchor = GridBagConstraints.WEST;
		gbc_textOraduUscita.insets = new Insets(0, 0, 5, 5);
		gbc_textOraduUscita.gridx = 0;
		gbc_textOraduUscita.gridy = posY;
		contentPane.add(textOraduUscita, gbc_textOraduUscita);
		
		JPanel panel_1_6 = new JPanel();
		GridBagConstraints gbc_panel_1_6 = new GridBagConstraints();
		gbc_panel_1_6.anchor = GridBagConstraints.WEST;
		gbc_panel_1_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_6.gridx = 2;
		gbc_panel_1_6.gridy = posY++;
		contentPane.add(panel_1_6, gbc_panel_1_6);
		
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
		
		JLabel textNomeEquipe = new JLabel("Membri dell’equipe");
		textNomeEquipe.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_textNomeEquipe = new GridBagConstraints();
		gbc_textNomeEquipe.anchor = GridBagConstraints.WEST;
		gbc_textNomeEquipe.insets = new Insets(0, 0, 5, 5);
		gbc_textNomeEquipe.gridx = 0;
		gbc_textNomeEquipe.gridy = ++posY;
		contentPane.add(textNomeEquipe, gbc_textNomeEquipe);
		
		JLabel textPrimoOperatore = new JLabel("Primo Operatore*:");
		textPrimoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textPrimoOperatore = new GridBagConstraints();
		gbc_textPrimoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textPrimoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textPrimoOperatore.gridx = 0;
		gbc_textPrimoOperatore.gridy = ++posY;
		contentPane.add(textPrimoOperatore, gbc_textPrimoOperatore);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = posY++;
		contentPane.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		textPrimoOperatoreVerbale = new JTextField();
		textPrimoOperatoreVerbale.setText(valori[12]);
		textPrimoOperatoreVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textPrimoOperatoreVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textPrimoOperatoreVerbale.setColumns(10);
		panel_4.add(textPrimoOperatoreVerbale);
		
		JLabel textSecondoOperatore = new JLabel("Secondo Operatore*:");
		textSecondoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textSecondoOperatore = new GridBagConstraints();
		gbc_textSecondoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textSecondoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textSecondoOperatore.gridx = 0;
		gbc_textSecondoOperatore.gridy = posY;
		contentPane.add(textSecondoOperatore, gbc_textSecondoOperatore);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = posY++;
		contentPane.add(panel_2, gbc_panel_2);
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
		textTerzoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTerzoOperatore = new GridBagConstraints();
		gbc_textTerzoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textTerzoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textTerzoOperatore.gridx = 0;
		gbc_textTerzoOperatore.gridy = posY;
		contentPane.add(textTerzoOperatore, gbc_textTerzoOperatore);
		
		JPanel panel_1_9 = new JPanel();
		GridBagConstraints gbc_panel_1_9 = new GridBagConstraints();
		gbc_panel_1_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1_9.gridx = 2;
		gbc_panel_1_9.gridy = posY++;
		contentPane.add(panel_1_9, gbc_panel_1_9);
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
		textStrumentista.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textStrumentista = new GridBagConstraints();
		gbc_textStrumentista.anchor = GridBagConstraints.WEST;
		gbc_textStrumentista.insets = new Insets(0, 0, 5, 5);
		gbc_textStrumentista.gridx = 0;
		gbc_textStrumentista.gridy = posY;
		contentPane.add(textStrumentista, gbc_textStrumentista);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_6.gridx = 2;
		gbc_panel_6.gridy = posY++;
		contentPane.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		textStrumentistaVerbale = new JTextField();
		textStrumentistaVerbale.setText(valori[16]);
		textStrumentistaVerbale.setHorizontalAlignment(SwingConstants.LEFT);
		textStrumentistaVerbale.setFont(new Font("Arial", Font.PLAIN, 14));
		textStrumentistaVerbale.setColumns(10);
		panel_6.add(textStrumentistaVerbale);
		
		JLabel textInfermierediSala = new JLabel("Infermiere di sala*:");
		textInfermierediSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textInfermierediSala = new GridBagConstraints();
		gbc_textInfermierediSala.anchor = GridBagConstraints.WEST;
		gbc_textInfermierediSala.insets = new Insets(0, 0, 5, 5);
		gbc_textInfermierediSala.gridx = 0;
		gbc_textInfermierediSala.gridy = posY;
		contentPane.add(textInfermierediSala, gbc_textInfermierediSala);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_7.gridx = 2;
		gbc_panel_7.gridy = posY++;
		contentPane.add(panel_7, gbc_panel_7);
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
		textTecnicodiRadiologia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTecnicodiRadiologia = new GridBagConstraints();
		gbc_textTecnicodiRadiologia.anchor = GridBagConstraints.WEST;
		gbc_textTecnicodiRadiologia.insets = new Insets(0, 0, 5, 5);
		gbc_textTecnicodiRadiologia.gridx = 0;
		gbc_textTecnicodiRadiologia.gridy = posY;
		contentPane.add(textTecnicodiRadiologia, gbc_textTecnicodiRadiologia);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy =posY++;
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
		gbc_textDiagnosi.gridy = ++posY;
		contentPane.add(textDiagnosi, gbc_textDiagnosi);

		JLabel textDiagnosiVerbale = new JLabel();
		textDiagnosiVerbale.setText(dataService.getDiagnosiOperazione(this.codiceOperazioneAssociata));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = posY++;
		contentPane.add(textDiagnosiVerbale, gbc_textArea);
		
		JLabel textIntervento = new JLabel("Intervento:");
		textIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textIntervento = new GridBagConstraints();
		gbc_textIntervento.anchor = GridBagConstraints.WEST;
		gbc_textIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textIntervento.gridx = 0;
		gbc_textIntervento.gridy = posY;
		contentPane.add(textIntervento, gbc_textIntervento);

		JLabel textInterventoVerbale = new JLabel();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		textDiagnosiVerbale.setText(dataService.getInterventoOperazione(this.codiceOperazioneAssociata));
		gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 2;
		gbc_textArea_1.gridy = posY++;
		contentPane.add(textInterventoVerbale, gbc_textArea_1);

		JLabel textProcedura = new JLabel("Procedura*:");
		textProcedura.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textProcedura = new GridBagConstraints();
		gbc_textProcedura.anchor = GridBagConstraints.WEST;
		gbc_textProcedura.insets = new Insets(0, 0, 5, 5);
		gbc_textProcedura.gridx = 0;
		gbc_textProcedura.gridy = posY;
		contentPane.add(textProcedura, gbc_textProcedura);

		textProceduraVerbale = new JTextArea();
		textProceduraVerbale.setText(valori[20]);
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.gridx = 2;
		gbc_textArea_2.gridy = posY++;
		contentPane.add(textProceduraVerbale, gbc_textArea_2);

		
		JButton bottoneSalva = new JButton("Salva");
		bottoneSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salva();
			}
		});
		bottoneSalva.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneSalva = new GridBagConstraints();
		gbc_bottoneSalva.insets = new Insets(0, 0, 0, 5);
		gbc_bottoneSalva.gridx = 0;
		gbc_bottoneSalva.gridy = ++posY;
		contentPane.add(bottoneSalva, gbc_bottoneSalva);
		
		JButton bottoneConferma = new JButton("Chiudi senza salvare");
		bottoneConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chiudi();
			}
		});
		bottoneConferma.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneConferma = new GridBagConstraints();
		gbc_bottoneConferma.gridx = 2;
		gbc_bottoneConferma.gridy = posY;
		contentPane.add(bottoneConferma, gbc_bottoneConferma);

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
	
	//si genera un array di numeri (che in realtà sono stringhe) da 00 a 23 e con un elemento ""
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
	
	//si genera un array di numeri (che in realtà sono stringhe) da 00 a 59 e con un elemento ""
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
