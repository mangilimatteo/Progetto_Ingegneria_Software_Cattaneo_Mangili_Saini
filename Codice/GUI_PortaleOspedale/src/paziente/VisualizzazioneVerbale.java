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
import javax.swing.JButton;
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

import model.DataService;

public class VisualizzazioneVerbale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private DataService dataService;
	private String codiceVerbale;
	private String matricolaDipendente;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzazioneVerbale frame = new VisualizzazioneVerbale("6", "m00a1");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VisualizzazioneVerbale(String codiceVerbale, String matricolaDipendente) {
		
		dataService = new DataService();
		this.codiceVerbale = codiceVerbale;
		this.matricolaDipendente = matricolaDipendente;
		
		String[] valori = dataService.getValoriVerbale(this.codiceVerbale);
		valori[21] = "0";
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzazioneVerbale.class.getResource("/resources/LogoOspedale.png")));
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
		
		JLabel textNomePaziente = new JLabel(dataService.getPazienteAnagrafica(valori[21]));
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
		
		JLabel textOradiIngressoPaziente =new JLabel(valori[0]);
		textOradiIngressoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiIngressoPaziente = new GridBagConstraints();
		gbc_textOradiIngressoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textOradiIngressoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiIngressoPaziente.gridx = 2;
		gbc_textOradiIngressoPaziente.gridy = 2;
		contentPane.add(textOradiIngressoPaziente, gbc_textOradiIngressoPaziente);
		
		
		JLabel textOradiEntrata = new JLabel("Ora di entrata in sala operatoria");
		textOradiEntrata.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiEntrata = new GridBagConstraints();
		gbc_textOradiEntrata.anchor = GridBagConstraints.WEST;
		gbc_textOradiEntrata.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiEntrata.gridx = 0;
		gbc_textOradiEntrata.gridy = 3;
		contentPane.add(textOradiEntrata, gbc_textOradiEntrata);
		
		JLabel textOradiEntrataPaziente =new JLabel(valori[1]);
		textOradiEntrataPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiEntrataPaziente = new GridBagConstraints();
		gbc_textOradiEntrataPaziente.anchor = GridBagConstraints.WEST;
		gbc_textOradiEntrataPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiEntrataPaziente.gridx = 2;
		gbc_textOradiEntrataPaziente.gridy = 3;
		contentPane.add(textOradiEntrataPaziente, gbc_textOradiEntrataPaziente);
		
		JLabel OrariodelPosizionamento = new JLabel("Orario del posizionamento del paziente");
		OrariodelPosizionamento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_OrariodelPosizionamento = new GridBagConstraints();
		gbc_OrariodelPosizionamento.anchor = GridBagConstraints.WEST;
		gbc_OrariodelPosizionamento.insets = new Insets(0, 0, 5, 5);
		gbc_OrariodelPosizionamento.gridx = 0;
		gbc_OrariodelPosizionamento.gridy = 4;
		contentPane.add(OrariodelPosizionamento, gbc_OrariodelPosizionamento);
		
		JLabel textOraPosizionamentoPaziente =new JLabel(valori[2]);
		textOraPosizionamentoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOraPosizionamentoPaziente = new GridBagConstraints();
		gbc_textOraPosizionamentoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textOraPosizionamentoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textOraPosizionamentoPaziente.gridx = 2;
		gbc_textOraPosizionamentoPaziente.gridy = 4;
		contentPane.add(textOraPosizionamentoPaziente, gbc_textOraPosizionamentoPaziente);
		
		JLabel textOradiInizioAnestesia = new JLabel("Ora inizio anestesia");
		textOradiInizioAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiInizioAnestesia = new GridBagConstraints();
		gbc_textOradiInizioAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textOradiInizioAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiInizioAnestesia.gridx = 0;
		gbc_textOradiInizioAnestesia.gridy = 5;
		contentPane.add(textOradiInizioAnestesia, gbc_textOradiInizioAnestesia);
		
		JLabel textInizioAnestesiaPaziente =new JLabel(valori[3]);
		textInizioAnestesiaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textInizioAnestesiaPaziente = new GridBagConstraints();
		gbc_textInizioAnestesiaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textInizioAnestesiaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textInizioAnestesiaPaziente.gridx = 2;
		gbc_textInizioAnestesiaPaziente.gridy = 5;
		contentPane.add(textInizioAnestesiaPaziente, gbc_textInizioAnestesiaPaziente);
		
		JLabel textOradiFineAnestesia = new JLabel("Ora fine anestesia");
		textOradiFineAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiFineAnestesia = new GridBagConstraints();
		gbc_textOradiFineAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textOradiFineAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiFineAnestesia.gridx = 0;
		gbc_textOradiFineAnestesia.gridy = 6;
		contentPane.add(textOradiFineAnestesia, gbc_textOradiFineAnestesia);
		
		JLabel textFineAnestesiaPaziente =new JLabel(valori[4]);
		textFineAnestesiaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textFineAnestesiaPaziente = new GridBagConstraints();
		gbc_textFineAnestesiaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textFineAnestesiaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textFineAnestesiaPaziente.gridx = 2;
		gbc_textFineAnestesiaPaziente.gridy = 6;
		contentPane.add(textFineAnestesiaPaziente, gbc_textFineAnestesiaPaziente);
		
		JLabel textOradiIntervento = new JLabel("Ora inizio intervento");
		textOradiIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiIntervento = new GridBagConstraints();
		gbc_textOradiIntervento.anchor = GridBagConstraints.WEST;
		gbc_textOradiIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiIntervento.gridx = 0;
		gbc_textOradiIntervento.gridy = 7;
		contentPane.add(textOradiIntervento, gbc_textOradiIntervento);
		
		JLabel textInizioInterventoPaziente =new JLabel(valori[5]);
		textInizioInterventoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textInizioInterventoPaziente = new GridBagConstraints();
		gbc_textInizioInterventoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textInizioInterventoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textInizioInterventoPaziente.gridx = 2;
		gbc_textInizioInterventoPaziente.gridy = 7;
		contentPane.add(textInizioInterventoPaziente, gbc_textInizioInterventoPaziente);
		
		JLabel textOradiFineIntervento = new JLabel("Ora fine intervento");
		textOradiFineIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiFineIntervento = new GridBagConstraints();
		gbc_textOradiFineIntervento.anchor = GridBagConstraints.WEST;
		gbc_textOradiFineIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiFineIntervento.gridx = 0;
		gbc_textOradiFineIntervento.gridy = 8;
		contentPane.add(textOradiFineIntervento, gbc_textOradiFineIntervento);
		
		JLabel textFineInterventoPaziente =new JLabel(valori[6]);
		textFineInterventoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textFineInterventoPaziente = new GridBagConstraints();
		gbc_textFineInterventoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textFineInterventoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textFineInterventoPaziente.gridx = 2;
		gbc_textFineInterventoPaziente.gridy = 8;
		contentPane.add(textFineInterventoPaziente, gbc_textFineInterventoPaziente);
		
		JLabel textOradiRisveglio = new JLabel("Ora risveglio");
		textOradiRisveglio.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiRisveglio = new GridBagConstraints();
		gbc_textOradiRisveglio.anchor = GridBagConstraints.WEST;
		gbc_textOradiRisveglio.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiRisveglio.gridx = 0;
		gbc_textOradiRisveglio.gridy = 9;
		contentPane.add(textOradiRisveglio, gbc_textOradiRisveglio);
		
		JLabel textRisveglioPaziente =new JLabel(valori[7]);
		textRisveglioPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textRisveglioPaziente = new GridBagConstraints();
		gbc_textRisveglioPaziente.anchor = GridBagConstraints.WEST;
		gbc_textRisveglioPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textRisveglioPaziente.gridx = 2;
		gbc_textRisveglioPaziente.gridy = 9;
		contentPane.add(textRisveglioPaziente, gbc_textRisveglioPaziente);
		
		
		JLabel textOradiUscitaSala = new JLabel("Ora uscita sala operatoria");
		textOradiUscitaSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiUscitaSala = new GridBagConstraints();
		gbc_textOradiUscitaSala.anchor = GridBagConstraints.WEST;
		gbc_textOradiUscitaSala.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiUscitaSala.gridx = 0;
		gbc_textOradiUscitaSala.gridy = 10;
		contentPane.add(textOradiUscitaSala, gbc_textOradiUscitaSala);
		
		JLabel textUscitaSalaPaziente =new JLabel(valori[8]);
		textUscitaSalaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textUscitaSalaPaziente = new GridBagConstraints();
		gbc_textUscitaSalaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textUscitaSalaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textUscitaSalaPaziente.gridx = 2;
		gbc_textUscitaSalaPaziente.gridy = 10;
		contentPane.add(textUscitaSalaPaziente, gbc_textUscitaSalaPaziente);
		
		JLabel textOraUscitaBlocco = new JLabel("Ora uscita blocco operatorio");
		textOraUscitaBlocco.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOraUscitaBlocco = new GridBagConstraints();
		gbc_textOraUscitaBlocco.anchor = GridBagConstraints.WEST;
		gbc_textOraUscitaBlocco.insets = new Insets(0, 0, 5, 5);
		gbc_textOraUscitaBlocco.gridx = 0;
		gbc_textOraUscitaBlocco.gridy = 11;
		contentPane.add(textOraUscitaBlocco, gbc_textOraUscitaBlocco);
		
		JLabel textUscitaBloccoPaziente =new JLabel(valori[9]);
		textUscitaBloccoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textUscitaBloccoPaziente = new GridBagConstraints();
		gbc_textUscitaBloccoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textUscitaBloccoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textUscitaBloccoPaziente.gridx = 2;
		gbc_textUscitaBloccoPaziente.gridy = 11;
		contentPane.add(textUscitaBloccoPaziente, gbc_textUscitaBloccoPaziente);
		
		JLabel textTipodiAnestesia = new JLabel("Tipo di anestesia: ");
		textTipodiAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTipodiAnestesia = new GridBagConstraints();
		gbc_textTipodiAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textTipodiAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textTipodiAnestesia.gridx = 0;
		gbc_textTipodiAnestesia.gridy = 12;
		contentPane.add(textTipodiAnestesia, gbc_textTipodiAnestesia);
		
		JLabel textTipoAnestesiaPaziente =new JLabel(valori[10]);
		textTipoAnestesiaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTipoAnestesiaPaziente = new GridBagConstraints();
		gbc_textTipoAnestesiaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textTipoAnestesiaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textTipoAnestesiaPaziente.gridx = 2;
		gbc_textTipoAnestesiaPaziente.gridy = 12;
		contentPane.add(textTipoAnestesiaPaziente, gbc_textTipoAnestesiaPaziente);
		
		JLabel textRischioAnestesiologico = new JLabel("Rischio anestesiologico:");
		textRischioAnestesiologico.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textRischioAnestesiologico = new GridBagConstraints();
		gbc_textRischioAnestesiologico.anchor = GridBagConstraints.WEST;
		gbc_textRischioAnestesiologico.insets = new Insets(0, 0, 5, 5);
		gbc_textRischioAnestesiologico.gridx = 0;
		gbc_textRischioAnestesiologico.gridy = 13;
		contentPane.add(textRischioAnestesiologico, gbc_textRischioAnestesiologico);
		
		JLabel textRischioAnestesiologicoPaziente =new JLabel(valori[11]);
		textRischioAnestesiologicoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textRischioAnestesiologicoPaziente = new GridBagConstraints();
		gbc_textRischioAnestesiologicoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textRischioAnestesiologicoPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textRischioAnestesiologicoPaziente.gridx = 2;
		gbc_textRischioAnestesiologicoPaziente.gridy = 13;
		contentPane.add(textRischioAnestesiologicoPaziente, gbc_textRischioAnestesiologicoPaziente);
		
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
		
		JLabel textPrimoOperatorePaziente =new JLabel(valori[12]);
		textPrimoOperatorePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textPrimoOperatorePaziente = new GridBagConstraints();
		gbc_textPrimoOperatorePaziente.anchor = GridBagConstraints.WEST;
		gbc_textPrimoOperatorePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textPrimoOperatorePaziente.gridx = 2;
		gbc_textPrimoOperatorePaziente.gridy = 16;
		contentPane.add(textPrimoOperatorePaziente, gbc_textPrimoOperatorePaziente);
		
		JLabel textSecondoOperatore = new JLabel("Secondo Operatore:");
		textSecondoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textSecondoOperatore = new GridBagConstraints();
		gbc_textSecondoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textSecondoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textSecondoOperatore.gridx = 0;
		gbc_textSecondoOperatore.gridy = 17;
		contentPane.add(textSecondoOperatore, gbc_textSecondoOperatore);
		
		JLabel textSecondoOperatorePaziente =new JLabel(valori[13]);
		textSecondoOperatorePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textSecondoOperatorePaziente = new GridBagConstraints();
		gbc_textSecondoOperatorePaziente.anchor = GridBagConstraints.WEST;
		gbc_textSecondoOperatorePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textSecondoOperatorePaziente.gridx = 2;
		gbc_textSecondoOperatorePaziente.gridy = 17;
		contentPane.add(textSecondoOperatorePaziente, gbc_textSecondoOperatorePaziente);
		
		JLabel textTerzoOperatore = new JLabel("Terzo Operatore:");
		textTerzoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTerzoOperatore = new GridBagConstraints();
		gbc_textTerzoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textTerzoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textTerzoOperatore.gridx = 0;
		gbc_textTerzoOperatore.gridy = 18;
		contentPane.add(textTerzoOperatore, gbc_textTerzoOperatore);
		
		JLabel textTerzoOperatorePaziente =new JLabel(valori[14]);
		textTerzoOperatorePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTerzoOperatorePaziente = new GridBagConstraints();
		gbc_textTerzoOperatorePaziente.anchor = GridBagConstraints.WEST;
		gbc_textTerzoOperatorePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textTerzoOperatorePaziente.gridx = 2;
		gbc_textTerzoOperatorePaziente.gridy = 18;
		contentPane.add(textTerzoOperatorePaziente, gbc_textTerzoOperatorePaziente);
		
		JLabel textAnestesita = new JLabel("Anestesita:");
		textAnestesita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textAnestesita = new GridBagConstraints();
		gbc_textAnestesita.anchor = GridBagConstraints.WEST;
		gbc_textAnestesita.insets = new Insets(0, 0, 5, 5);
		gbc_textAnestesita.gridx = 0;
		gbc_textAnestesita.gridy = 19;
		contentPane.add(textAnestesita, gbc_textAnestesita);
		
		JLabel textAnestesistaPaziente =new JLabel(valori[15]);
		textAnestesistaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textAnestesistaPaziente = new GridBagConstraints();
		gbc_textAnestesistaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textAnestesistaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textAnestesistaPaziente.gridx = 2;
		gbc_textAnestesistaPaziente.gridy = 19;
		contentPane.add(textAnestesistaPaziente, gbc_textAnestesistaPaziente);
		
		JLabel textStrumentista = new JLabel("Strumentista:");
		textStrumentista.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textStrumentista = new GridBagConstraints();
		gbc_textStrumentista.anchor = GridBagConstraints.WEST;
		gbc_textStrumentista.insets = new Insets(0, 0, 5, 5);
		gbc_textStrumentista.gridx = 0;
		gbc_textStrumentista.gridy = 20;
		contentPane.add(textStrumentista, gbc_textStrumentista);
		
		JLabel textStrumentistaPaziente =new JLabel(valori[16]);
		textStrumentistaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textStrumentistaPaziente = new GridBagConstraints();
		gbc_textStrumentistaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textStrumentistaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textStrumentistaPaziente.gridx = 2;
		gbc_textStrumentistaPaziente.gridy = 20;
		contentPane.add(textStrumentistaPaziente, gbc_textStrumentistaPaziente);
		
		JLabel textInfermierediSala = new JLabel("Infermiere di sala:");
		textInfermierediSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textInfermierediSala = new GridBagConstraints();
		gbc_textInfermierediSala.anchor = GridBagConstraints.WEST;
		gbc_textInfermierediSala.insets = new Insets(0, 0, 5, 5);
		gbc_textInfermierediSala.gridx = 0;
		gbc_textInfermierediSala.gridy = 21;
		contentPane.add(textInfermierediSala, gbc_textInfermierediSala);
		
		JLabel textInfermierePaziente =new JLabel(valori[17]);
		textInfermierePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textInfermierePaziente = new GridBagConstraints();
		gbc_textInfermierePaziente.anchor = GridBagConstraints.WEST;
		gbc_textInfermierePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textInfermierePaziente.gridx = 2;
		gbc_textInfermierePaziente.gridy = 21;
		contentPane.add(textInfermierePaziente, gbc_textInfermierePaziente);
		
		JLabel textAiutoanestesista = new JLabel("Aiutoanestesista:");
		textAiutoanestesista.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textAiutoanestesista = new GridBagConstraints();
		gbc_textAiutoanestesista.anchor = GridBagConstraints.WEST;
		gbc_textAiutoanestesista.insets = new Insets(0, 0, 5, 5);
		gbc_textAiutoanestesista.gridx = 0;
		gbc_textAiutoanestesista.gridy = 22;
		contentPane.add(textAiutoanestesista, gbc_textAiutoanestesista);
		
		JLabel textAiutoAnestesistaPaziente =new JLabel(valori[18]);
		textAiutoAnestesistaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textAiutoAnestesistaPaziente = new GridBagConstraints();
		gbc_textAiutoAnestesistaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textAiutoAnestesistaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textAiutoAnestesistaPaziente.gridx = 2;
		gbc_textAiutoAnestesistaPaziente.gridy = 22;
		contentPane.add(textAiutoAnestesistaPaziente, gbc_textAiutoAnestesistaPaziente);
		
		JLabel textTecnicodiRadiologia = new JLabel("Tecnico di radiologia:");
		textTecnicodiRadiologia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTecnicodiRadiologia = new GridBagConstraints();
		gbc_textTecnicodiRadiologia.anchor = GridBagConstraints.WEST;
		gbc_textTecnicodiRadiologia.insets = new Insets(0, 0, 5, 5);
		gbc_textTecnicodiRadiologia.gridx = 0;
		gbc_textTecnicodiRadiologia.gridy = 23;
		contentPane.add(textTecnicodiRadiologia, gbc_textTecnicodiRadiologia);
		
		JLabel textTecnicoRadiologiaPaziente =new JLabel(valori[19]);
		textTecnicoRadiologiaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTecnicoRadiologiaPaziente = new GridBagConstraints();
		gbc_textTecnicoRadiologiaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textTecnicoRadiologiaPaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textTecnicoRadiologiaPaziente.gridx = 2;
		gbc_textTecnicoRadiologiaPaziente.gridy = 23;
		contentPane.add(textTecnicoRadiologiaPaziente, gbc_textAiutoAnestesistaPaziente);
		
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

		JLabel textProceduraVerbale = new JLabel();
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		textDiagnosiVerbale.setText(valori[20]);
		gbc_textArea_2.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.gridx = 2;
		gbc_textArea_2.gridy = 27;
		contentPane.add(textProceduraVerbale, gbc_textArea_2);
		
		JButton bottoneModifica = new JButton("Modifica");
		bottoneModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifica();
			}
		});
		bottoneModifica.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneModifica = new GridBagConstraints();
		gbc_bottoneModifica.insets = new Insets(0, 0, 0, 5);
		gbc_bottoneModifica.gridx = 0;
		gbc_bottoneModifica.gridy = 28;
		contentPane.add(bottoneModifica, gbc_bottoneModifica);
		
		JButton bottoneConferma = new JButton("Chiudi");
		bottoneConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bottoneConferma.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneConferma = new GridBagConstraints();
		gbc_bottoneConferma.gridx = 2;
		gbc_bottoneConferma.gridy = 28;
		contentPane.add(bottoneConferma, gbc_bottoneConferma);

	}


	protected void modifica() {
		ModificaVerbale modificaVerbale= new ModificaVerbale(codiceVerbale, matricolaDipendente, "");
		modificaVerbale.setVisible(true);
		dispose();
		
	}

}
