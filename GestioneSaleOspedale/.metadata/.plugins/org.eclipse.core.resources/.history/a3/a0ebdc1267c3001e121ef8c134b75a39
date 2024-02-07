package paziente;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
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
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SpinnerListModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class VerbalePaziente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spinnerMinuto1;
	private JTextField textCognomeSecondoOperatore;
	private JTextField textCognomeTerzoOperatore;
	private JTextField textNomeTecnicodiRadiologia;
	private JTextField textCognomePrimoOperatore;
	private JTextField textNomePrimoOperatore;
	private JTextField textNomeSecondoOperatore;
	private JTextField textNomeTerzoOperatore;
	private JTextField textNomeAnestesista;
	private JTextField textCognomeAnestesista;
	private JTextField textNomeStrumentista;
	private JTextField textCognomeStrumentista;
	private JTextField textNomeInfermierediSala;
	private JTextField textCognomeInfermierediSala;
	private JTextField textNomeAiutoanestetista;
	private JTextField textCognomeAiutoanestetista;
	private JTextField textCognomeTecnicodiRadiologia;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerbalePaziente frame = new VerbalePaziente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VerbalePaziente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerbalePaziente.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale Papa Giovanni XIII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 843);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{148, 35, 408, 0};
		gbl_contentPane.rowHeights = new int[]{58, 35, 19, 23, 29, 19, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 0, 0, 0, 0, 0, 0, 0, 0, 62, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textVerbalePaziente = new JLabel("Verbale Paziente:");
		textVerbalePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textVerbalePaziente = new GridBagConstraints();
		gbc_textVerbalePaziente.anchor = GridBagConstraints.WEST;
		gbc_textVerbalePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textVerbalePaziente.gridx = 0;
		gbc_textVerbalePaziente.gridy = 0;
		contentPane.add(textVerbalePaziente, gbc_textVerbalePaziente);
		
		JLabel textNomePaziente = new JLabel("[nome paziente]");
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
		
		JSpinner spinnerOra1 = new JSpinner();
		spinnerOra1.setEnabled(false);
		spinnerOra1.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerOra1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(spinnerOra1);
		
		spinnerMinuto1 = new JSpinner();
		spinnerMinuto1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto1.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto1.setEnabled(false);
		panel.add(spinnerMinuto1);
		
		
		JRadioButton rdbtnOpzionale1 = new JRadioButton("Opzionale");
		int[] opzionale1= {1};
		rdbtnOpzionale1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setOpzionaleSpinner(opzionale1,spinnerOra1,spinnerMinuto1);
			}
		});
		panel.add(rdbtnOpzionale1);
	
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
		
		JSpinner spinnerOra2 = new JSpinner();
		spinnerOra2.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerOra2.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra2.setEnabled(false);
		panel_1.add(spinnerOra2);
		
		JSpinner spinnerMinuto2 = new JSpinner();
		spinnerMinuto2.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto2.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto2.setEnabled(false);
		panel_1.add(spinnerMinuto2);
		
		JRadioButton rdbtnOpzionale2 = new JRadioButton("Opzionale");
		int[] opzionale2= {1};
		rdbtnOpzionale2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setOpzionaleSpinner(opzionale2,spinnerOra2,spinnerMinuto2);
			}
		});
		panel_1.add(rdbtnOpzionale2);
		
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
		
		JSpinner spinnerOra3 = new JSpinner();
		spinnerOra3.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerOra3.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra3.setEnabled(false);
		panel_1_1.add(spinnerOra3);
		
		JSpinner spinnerMinuto3 = new JSpinner();
		spinnerMinuto3.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto3.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto3.setEnabled(false);
		panel_1_1.add(spinnerMinuto3);
		
		JRadioButton rdbtnOpzionale3 = new JRadioButton("Opzionale");
		int[] opzionale3= {1};
		rdbtnOpzionale3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setOpzionaleSpinner(opzionale3,spinnerOra3,spinnerMinuto3);
			}
		});
		panel_1_1.add(rdbtnOpzionale3);
		
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
		
		JSpinner spinnerOra4 = new JSpinner();
		spinnerOra4.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerOra4.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra4.setEnabled(false);
		panel_1_2.add(spinnerOra4);
		
		JSpinner spinnerMinuto4 = new JSpinner();
		spinnerMinuto4.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto4.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto4.setEnabled(false);
		panel_1_2.add(spinnerMinuto4);
		
		JRadioButton rdbtnOpzionale4 = new JRadioButton("Opzionale");
		int[] opzionale4= {1};
		rdbtnOpzionale4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setOpzionaleSpinner(opzionale4,spinnerOra4,spinnerMinuto4);
			}
		});
		panel_1_2.add(rdbtnOpzionale4);
		
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
		
		JSpinner spinnerOra5 = new JSpinner();
		spinnerOra5.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerOra5.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra5.setEnabled(false);
		panel_1_3.add(spinnerOra5);
		
		JSpinner spinnerMinuto5 = new JSpinner();
		spinnerMinuto5.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto5.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto5.setEnabled(false);
		panel_1_3.add(spinnerMinuto5);
		
		JRadioButton rdbtnOpzionale5 = new JRadioButton("Opzionale");
		int[] opzionale5= {1};
		rdbtnOpzionale5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setOpzionaleSpinner(opzionale5,spinnerOra5,spinnerMinuto5);
			}
		});
		panel_1_3.add(rdbtnOpzionale5);
		
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
		
		JSpinner spinnerOra6 = new JSpinner();
		spinnerOra6.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerOra6.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra6.setEnabled(false);
		panel_1_7.add(spinnerOra6);
		
		JSpinner spinnerMinuto6 = new JSpinner();
		spinnerMinuto6.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto6.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto6.setEnabled(false);
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
		
		JSpinner spinnerOra7 = new JSpinner();
		spinnerOra7.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerOra7.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra7.setEnabled(false);
		panel_1_8.add(spinnerOra7);
		
		JSpinner spinnerMinuto7 = new JSpinner();
		spinnerMinuto7.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto7.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto7.setEnabled(false);
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
		
		JSpinner spinnerOra8 = new JSpinner();
		spinnerOra8.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerOra8.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra8.setEnabled(false);
		panel_1_4.add(spinnerOra8);
		
		JSpinner spinnerMinuto8 = new JSpinner();
		spinnerMinuto8.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto8.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto8.setEnabled(false);
		panel_1_4.add(spinnerMinuto8);
		
		JRadioButton rdbtnOpzionale8 = new JRadioButton("Opzionale");
		int[] opzionale8= {1};
		rdbtnOpzionale8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setOpzionaleSpinner(opzionale8,spinnerOra8,spinnerMinuto8);
			}
		});
		panel_1_4.add(rdbtnOpzionale8);
		
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
		
		JSpinner spinnerOra9 = new JSpinner();
		spinnerOra9.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerOra9.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra9.setEnabled(false);
		panel_1_5.add(spinnerOra9);
		
		JSpinner spinnerMinuto9 = new JSpinner();
		spinnerMinuto9.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto9.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto9.setEnabled(false);
		panel_1_5.add(spinnerMinuto9);
		
		JRadioButton rdbtnOpzionale9 = new JRadioButton("Opzionale");
		int[] opzionale9= {1};
		rdbtnOpzionale9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setOpzionaleSpinner(opzionale9,spinnerOra9,spinnerMinuto9);
			}
		});
		panel_1_5.add(rdbtnOpzionale9);
		
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
		
		JSpinner spinnerOra10 = new JSpinner();
		spinnerOra10.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerOra10.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOra10.setEnabled(false);
		panel_1_6.add(spinnerOra10);
		
		JSpinner spinnerMinuto10 = new JSpinner();
		spinnerMinuto10.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto10.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMinuto10.setEnabled(false);
		panel_1_6.add(spinnerMinuto10);
		
		JRadioButton rdbtnOpzionale10 = new JRadioButton("Opzionale");
		int[] opzionale10= {1};
		rdbtnOpzionale10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setOpzionaleSpinner(opzionale10,spinnerOra10,spinnerMinuto10);
			}
		});
		panel_1_6.add(rdbtnOpzionale10);
		
		JLabel textTipodiAnestesia = new JLabel("Tipo di anestesia: ");
		textTipodiAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTipodiAnestesia = new GridBagConstraints();
		gbc_textTipodiAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textTipodiAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textTipodiAnestesia.gridx = 0;
		gbc_textTipodiAnestesia.gridy = 12;
		contentPane.add(textTipodiAnestesia, gbc_textTipodiAnestesia);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"-", "Generale", "Locoregionale", "Locale", "Spinale"}));
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
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerListModel(new String[] {"-", "Asa1", "Asa2", "Asa3", "Asa4", "Asa5"}));
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_1.gridx = 2;
		gbc_spinner_1.gridy = 13;
		contentPane.add(spinner_1, gbc_spinner_1);
		
		JLabel textNomeEquipe = new JLabel("Nomi dell’equipe");
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
		
		textNomePrimoOperatore = new JTextField();
		textNomePrimoOperatore.setText("aaa");
		textNomePrimoOperatore.setHorizontalAlignment(SwingConstants.LEFT);
		textNomePrimoOperatore.setFont(new Font("Arial", Font.PLAIN, 14));
		textNomePrimoOperatore.setEditable(false);
		textNomePrimoOperatore.setColumns(10);
		panel_4.add(textNomePrimoOperatore);
		
		textCognomePrimoOperatore = new JTextField();
		textCognomePrimoOperatore.setText("aaa");
		textCognomePrimoOperatore.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomePrimoOperatore.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomePrimoOperatore.setEditable(false);
		textCognomePrimoOperatore.setColumns(10);
		panel_4.add(textCognomePrimoOperatore);
		
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
		
		textNomeSecondoOperatore = new JTextField();
		textNomeSecondoOperatore.setText("aaa");
		textNomeSecondoOperatore.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeSecondoOperatore.setFont(new Font("Arial", Font.PLAIN, 14));
		textNomeSecondoOperatore.setEditable(false);
		textNomeSecondoOperatore.setColumns(10);
		panel_2.add(textNomeSecondoOperatore);
		
		textCognomeSecondoOperatore = new JTextField();
		textCognomeSecondoOperatore.setText("aaa");
		textCognomeSecondoOperatore.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeSecondoOperatore.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomeSecondoOperatore.setEditable(false);
		textCognomeSecondoOperatore.setColumns(10);
		panel_2.add(textCognomeSecondoOperatore);
		
		JRadioButton rdbtnNessunOperatore = new JRadioButton("Nessun Operatore");
		int[] nessunOperatore= {1};
		rdbtnNessunOperatore.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setOpzionaleTesto(nessunOperatore,textNomeSecondoOperatore,textCognomeSecondoOperatore);
			}
		});
		panel_2.add(rdbtnNessunOperatore);
		
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
		
		textNomeTerzoOperatore = new JTextField();
		textNomeTerzoOperatore.setText("aaa");
		textNomeTerzoOperatore.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeTerzoOperatore.setFont(new Font("Arial", Font.PLAIN, 14));
		textNomeTerzoOperatore.setEditable(false);
		textNomeTerzoOperatore.setColumns(10);
		panel_1_9.add(textNomeTerzoOperatore);
		
		textCognomeTerzoOperatore = new JTextField();
		textCognomeTerzoOperatore.setText("aaa");
		textCognomeTerzoOperatore.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeTerzoOperatore.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomeTerzoOperatore.setEditable(false);
		textCognomeTerzoOperatore.setColumns(10);
		panel_1_9.add(textCognomeTerzoOperatore);
		
		JRadioButton rdbtnOpzionale2_1 = new JRadioButton("Opzionale");
		panel_1_9.add(rdbtnOpzionale2_1);
		
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
		
		textNomeAnestesista = new JTextField();
		textNomeAnestesista.setText("aaa");
		textNomeAnestesista.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeAnestesista.setFont(new Font("Arial", Font.PLAIN, 14));
		textNomeAnestesista.setEditable(false);
		textNomeAnestesista.setColumns(10);
		panel_5.add(textNomeAnestesista);
		
		textCognomeAnestesista = new JTextField();
		textCognomeAnestesista.setText("aaa");
		textCognomeAnestesista.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeAnestesista.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomeAnestesista.setEditable(false);
		textCognomeAnestesista.setColumns(10);
		panel_5.add(textCognomeAnestesista);
		
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
		
		textNomeStrumentista = new JTextField();
		textNomeStrumentista.setText("aaa");
		textNomeStrumentista.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeStrumentista.setFont(new Font("Arial", Font.PLAIN, 14));
		textNomeStrumentista.setEditable(false);
		textNomeStrumentista.setColumns(10);
		panel_6.add(textNomeStrumentista);
		
		textCognomeStrumentista = new JTextField();
		textCognomeStrumentista.setText("aaa");
		textCognomeStrumentista.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeStrumentista.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomeStrumentista.setEditable(false);
		textCognomeStrumentista.setColumns(10);
		panel_6.add(textCognomeStrumentista);
		
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
		
		textNomeInfermierediSala = new JTextField();
		textNomeInfermierediSala.setText("aaa");
		textNomeInfermierediSala.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeInfermierediSala.setFont(new Font("Arial", Font.PLAIN, 14));
		textNomeInfermierediSala.setEditable(false);
		textNomeInfermierediSala.setColumns(10);
		panel_7.add(textNomeInfermierediSala);
		
		textCognomeInfermierediSala = new JTextField();
		textCognomeInfermierediSala.setText("aaa");
		textCognomeInfermierediSala.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeInfermierediSala.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomeInfermierediSala.setEditable(false);
		textCognomeInfermierediSala.setColumns(10);
		panel_7.add(textCognomeInfermierediSala);
		
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
		
		textNomeAiutoanestetista = new JTextField();
		textNomeAiutoanestetista.setText("aaa");
		textNomeAiutoanestetista.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeAiutoanestetista.setFont(new Font("Arial", Font.PLAIN, 14));
		textNomeAiutoanestetista.setEditable(false);
		textNomeAiutoanestetista.setColumns(10);
		panel_8.add(textNomeAiutoanestetista);
		
		textCognomeAiutoanestetista = new JTextField();
		textCognomeAiutoanestetista.setText("aaa");
		textCognomeAiutoanestetista.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeAiutoanestetista.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomeAiutoanestetista.setEditable(false);
		textCognomeAiutoanestetista.setColumns(10);
		panel_8.add(textCognomeAiutoanestetista);
		
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
		
		textNomeTecnicodiRadiologia = new JTextField();
		textNomeTecnicodiRadiologia.setText("aaa");
		textNomeTecnicodiRadiologia.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeTecnicodiRadiologia.setFont(new Font("Arial", Font.PLAIN, 14));
		textNomeTecnicodiRadiologia.setEditable(false);
		textNomeTecnicodiRadiologia.setColumns(10);
		panel_3.add(textNomeTecnicodiRadiologia);
		
		textCognomeTecnicodiRadiologia = new JTextField();
		textCognomeTecnicodiRadiologia.setText("aaa");
		textCognomeTecnicodiRadiologia.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeTecnicodiRadiologia.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomeTecnicodiRadiologia.setEditable(false);
		textCognomeTecnicodiRadiologia.setColumns(10);
		panel_3.add(textCognomeTecnicodiRadiologia);
		
		JRadioButton rdbtnOpzionale2_1_1 = new JRadioButton("Opzionale");
		panel_3.add(rdbtnOpzionale2_1_1);
		
		JLabel textDiagnosi = new JLabel("Diagnosi:");
		textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDiagnosi = new GridBagConstraints();
		gbc_textDiagnosi.anchor = GridBagConstraints.WEST;
		gbc_textDiagnosi.insets = new Insets(0, 0, 5, 5);
		gbc_textDiagnosi.gridx = 0;
		gbc_textDiagnosi.gridy = 25;
		contentPane.add(textDiagnosi, gbc_textDiagnosi);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 25;
		contentPane.add(textArea, gbc_textArea);
		
		JLabel textIntervento = new JLabel("Intervento:");
		textIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textIntervento = new GridBagConstraints();
		gbc_textIntervento.anchor = GridBagConstraints.WEST;
		gbc_textIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textIntervento.gridx = 0;
		gbc_textIntervento.gridy = 26;
		contentPane.add(textIntervento, gbc_textIntervento);
		
		JTextArea textArea_1 = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 2;
		gbc_textArea_1.gridy = 26;
		contentPane.add(textArea_1, gbc_textArea_1);
		
		JLabel textProcedura = new JLabel("Procedura:");
		textProcedura.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textProcedura = new GridBagConstraints();
		gbc_textProcedura.anchor = GridBagConstraints.WEST;
		gbc_textProcedura.insets = new Insets(0, 0, 5, 5);
		gbc_textProcedura.gridx = 0;
		gbc_textProcedura.gridy = 27;
		contentPane.add(textProcedura, gbc_textProcedura);
		
		JTextArea textArea_2 = new JTextArea();
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.gridx = 2;
		gbc_textArea_2.gridy = 27;
		contentPane.add(textArea_2, gbc_textArea_2);

	}

	//setOpzionale cancella/riinserisce spinner ora e minuti in base al button
	void setOpzionaleSpinner(int[] x, JSpinner h , JSpinner m ) {
		if(x[0]==1) {
			h.setVisible(false);
			m.setVisible(false);
			x[0]=0;
		}
		else {
			h.setVisible(true);
			m.setVisible(true);
			x[0]=1;
		}
	}
	
	//setOpzionale cancella/riinserisce testo nome e cognome in base al button
	void setOpzionaleTesto(int[] x, JRadioButton nome , JRadioButton cognome ) {
		if(x[0]==1) {
			nome.setVisible(false);
			cognome.setVisible(false);
			x[0]=0;
		}
		else {
			nome.setVisible(true);
			cognome.setVisible(true);
			x[0]=1;
		}
	}
}
