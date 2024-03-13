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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.DataService;

public class VisualizzazioneVerbale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private DataService dataService;
	private String codiceVerbale;
	private String matricolaDipendente;
	private String codiceOperazioneAssociata;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzazioneVerbale frame = new VisualizzazioneVerbale("28", "m001a");
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
		codiceOperazioneAssociata = valori[21];
		
		boolean anestesia = dataService.getAnestesiaOperazione(codiceOperazioneAssociata);
		int posY = 0;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzazioneVerbale.class.getResource("/resources/LogoOspedale.png")));
		setTitle("Portale digitale Personale Sanitario dell'ospedale Papa Giovanni XIII");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 843);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{148, 35, 408, 0};
		gbl_contentPane.rowHeights = new int[]{58, 24, 19, 29, 19, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 24, 24, 0, 0, 0, 0, 0, 0, 62, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textVerbalePaziente = new JLabel("Verbale Operazione N. " + codiceVerbale);
		textVerbalePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textVerbalePaziente = new GridBagConstraints();
		gbc_textVerbalePaziente.anchor = GridBagConstraints.WEST;
		gbc_textVerbalePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textVerbalePaziente.gridx = 0;
		gbc_textVerbalePaziente.gridy = posY;
		contentPane.add(textVerbalePaziente, gbc_textVerbalePaziente);
		
		JButton bottoneMostraAnagrafica = new JButton("Mostra Anagrafica");
		bottoneMostraAnagrafica.setFont(new Font("Arial", Font.PLAIN, 14));
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
		
		JLabel textOradiIngressoPaziente =new JLabel(valori[0]);
		textOradiIngressoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiIngressoPaziente = new GridBagConstraints();
		gbc_textOradiIngressoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textOradiIngressoPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textOradiIngressoPaziente.gridx = 2;
		gbc_textOradiIngressoPaziente.gridy = posY++;
		contentPane.add(textOradiIngressoPaziente, gbc_textOradiIngressoPaziente);
		
		
		JLabel textOradiEntrata = new JLabel("Ora di entrata in sala operatoria");
		textOradiEntrata.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiEntrata = new GridBagConstraints();
		gbc_textOradiEntrata.anchor = GridBagConstraints.WEST;
		gbc_textOradiEntrata.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiEntrata.gridx = 0;
		gbc_textOradiEntrata.gridy = posY;
		contentPane.add(textOradiEntrata, gbc_textOradiEntrata);
		
		JLabel textOradiEntrataPaziente =new JLabel(valori[1]);
		textOradiEntrataPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiEntrataPaziente = new GridBagConstraints();
		gbc_textOradiEntrataPaziente.anchor = GridBagConstraints.WEST;
		gbc_textOradiEntrataPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textOradiEntrataPaziente.gridx = 2;
		gbc_textOradiEntrataPaziente.gridy = posY++;
		contentPane.add(textOradiEntrataPaziente, gbc_textOradiEntrataPaziente);
		
		JLabel OrariodelPosizionamento = new JLabel("Orario del posizionamento del paziente");
		OrariodelPosizionamento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_OrariodelPosizionamento = new GridBagConstraints();
		gbc_OrariodelPosizionamento.anchor = GridBagConstraints.WEST;
		gbc_OrariodelPosizionamento.insets = new Insets(0, 0, 5, 5);
		gbc_OrariodelPosizionamento.gridx = 0;
		gbc_OrariodelPosizionamento.gridy = posY;
		contentPane.add(OrariodelPosizionamento, gbc_OrariodelPosizionamento);
		
		JLabel textOraPosizionamentoPaziente =new JLabel(valori[2]);
		textOraPosizionamentoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOraPosizionamentoPaziente = new GridBagConstraints();
		gbc_textOraPosizionamentoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textOraPosizionamentoPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textOraPosizionamentoPaziente.gridx = 2;
		gbc_textOraPosizionamentoPaziente.gridy = posY++;
		contentPane.add(textOraPosizionamentoPaziente, gbc_textOraPosizionamentoPaziente);
		
		if(anestesia) {
			JLabel textOradiInizioAnestesia = new JLabel("Ora inizio anestesia");
			textOradiInizioAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textOradiInizioAnestesia = new GridBagConstraints();
			gbc_textOradiInizioAnestesia.anchor = GridBagConstraints.WEST;
			gbc_textOradiInizioAnestesia.insets = new Insets(0, 0, 5, 5);
			gbc_textOradiInizioAnestesia.gridx = 0;
			gbc_textOradiInizioAnestesia.gridy = posY;
			contentPane.add(textOradiInizioAnestesia, gbc_textOradiInizioAnestesia);
			
			JLabel textInizioAnestesiaPaziente =new JLabel(valori[3]);
			textInizioAnestesiaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textInizioAnestesiaPaziente = new GridBagConstraints();
			gbc_textInizioAnestesiaPaziente.anchor = GridBagConstraints.WEST;
			gbc_textInizioAnestesiaPaziente.insets = new Insets(0, 0, 5, 0);
			gbc_textInizioAnestesiaPaziente.gridx = 2;
			gbc_textInizioAnestesiaPaziente.gridy = posY++;
			contentPane.add(textInizioAnestesiaPaziente, gbc_textInizioAnestesiaPaziente);
		}
		
		JLabel textOradiFineAnestesia = new JLabel("Ora fine anestesia");
		textOradiFineAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiFineAnestesia = new GridBagConstraints();
		gbc_textOradiFineAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textOradiFineAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiFineAnestesia.gridx = 0;
		gbc_textOradiFineAnestesia.gridy = posY;
		contentPane.add(textOradiFineAnestesia, gbc_textOradiFineAnestesia);
		
		JLabel textFineAnestesiaPaziente =new JLabel(valori[4]);
		textFineAnestesiaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textFineAnestesiaPaziente = new GridBagConstraints();
		gbc_textFineAnestesiaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textFineAnestesiaPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textFineAnestesiaPaziente.gridx = 2;
		gbc_textFineAnestesiaPaziente.gridy = posY++;
		contentPane.add(textFineAnestesiaPaziente, gbc_textFineAnestesiaPaziente);
		
		JLabel textOradiIntervento = new JLabel("Ora inizio intervento");
		textOradiIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiIntervento = new GridBagConstraints();
		gbc_textOradiIntervento.anchor = GridBagConstraints.WEST;
		gbc_textOradiIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiIntervento.gridx = 0;
		gbc_textOradiIntervento.gridy = posY;
		contentPane.add(textOradiIntervento, gbc_textOradiIntervento);
		
		JLabel textInizioInterventoPaziente =new JLabel(valori[5]);
		textInizioInterventoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textInizioInterventoPaziente = new GridBagConstraints();
		gbc_textInizioInterventoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textInizioInterventoPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textInizioInterventoPaziente.gridx = 2;
		gbc_textInizioInterventoPaziente.gridy = posY++;
		contentPane.add(textInizioInterventoPaziente, gbc_textInizioInterventoPaziente);
		
		JLabel textOradiFineIntervento = new JLabel("Ora fine intervento");
		textOradiFineIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiFineIntervento = new GridBagConstraints();
		gbc_textOradiFineIntervento.anchor = GridBagConstraints.WEST;
		gbc_textOradiFineIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiFineIntervento.gridx = 0;
		gbc_textOradiFineIntervento.gridy = posY;
		contentPane.add(textOradiFineIntervento, gbc_textOradiFineIntervento);
		
		JLabel textFineInterventoPaziente =new JLabel(valori[6]);
		textFineInterventoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textFineInterventoPaziente = new GridBagConstraints();
		gbc_textFineInterventoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textFineInterventoPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textFineInterventoPaziente.gridx = 2;
		gbc_textFineInterventoPaziente.gridy = posY++;
		contentPane.add(textFineInterventoPaziente, gbc_textFineInterventoPaziente);
		
		JLabel textOradiRisveglio = new JLabel("Ora risveglio");
		textOradiRisveglio.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiRisveglio = new GridBagConstraints();
		gbc_textOradiRisveglio.anchor = GridBagConstraints.WEST;
		gbc_textOradiRisveglio.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiRisveglio.gridx = 0;
		gbc_textOradiRisveglio.gridy = posY;
		contentPane.add(textOradiRisveglio, gbc_textOradiRisveglio);
		
		JLabel textRisveglioPaziente =new JLabel(valori[7]);
		textRisveglioPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textRisveglioPaziente = new GridBagConstraints();
		gbc_textRisveglioPaziente.anchor = GridBagConstraints.WEST;
		gbc_textRisveglioPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textRisveglioPaziente.gridx = 2;
		gbc_textRisveglioPaziente.gridy = posY++;
		contentPane.add(textRisveglioPaziente, gbc_textRisveglioPaziente);
		
		
		JLabel textOradiUscitaSala = new JLabel("Ora uscita sala operatoria");
		textOradiUscitaSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiUscitaSala = new GridBagConstraints();
		gbc_textOradiUscitaSala.anchor = GridBagConstraints.WEST;
		gbc_textOradiUscitaSala.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiUscitaSala.gridx = 0;
		gbc_textOradiUscitaSala.gridy = posY;
		contentPane.add(textOradiUscitaSala, gbc_textOradiUscitaSala);
		
		JLabel textUscitaSalaPaziente =new JLabel(valori[8]);
		textUscitaSalaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textUscitaSalaPaziente = new GridBagConstraints();
		gbc_textUscitaSalaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textUscitaSalaPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textUscitaSalaPaziente.gridx = 2;
		gbc_textUscitaSalaPaziente.gridy = posY++;
		contentPane.add(textUscitaSalaPaziente, gbc_textUscitaSalaPaziente);
		
		JLabel textOraUscitaBlocco = new JLabel("Ora uscita blocco operatorio");
		textOraUscitaBlocco.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOraUscitaBlocco = new GridBagConstraints();
		gbc_textOraUscitaBlocco.anchor = GridBagConstraints.WEST;
		gbc_textOraUscitaBlocco.insets = new Insets(0, 0, 5, 5);
		gbc_textOraUscitaBlocco.gridx = 0;
		gbc_textOraUscitaBlocco.gridy = posY;
		contentPane.add(textOraUscitaBlocco, gbc_textOraUscitaBlocco);
		
		JLabel textUscitaBloccoPaziente =new JLabel(valori[9]);
		textUscitaBloccoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textUscitaBloccoPaziente = new GridBagConstraints();
		gbc_textUscitaBloccoPaziente.anchor = GridBagConstraints.WEST;
		gbc_textUscitaBloccoPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textUscitaBloccoPaziente.gridx = 2;
		gbc_textUscitaBloccoPaziente.gridy = posY++;
		contentPane.add(textUscitaBloccoPaziente, gbc_textUscitaBloccoPaziente);
		
		if(anestesia) {
			JLabel textTipodiAnestesia = new JLabel("Tipo di anestesia: ");
			textTipodiAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textTipodiAnestesia = new GridBagConstraints();
			gbc_textTipodiAnestesia.anchor = GridBagConstraints.WEST;
			gbc_textTipodiAnestesia.insets = new Insets(0, 0, 5, 5);
			gbc_textTipodiAnestesia.gridx = 0;
			gbc_textTipodiAnestesia.gridy = posY;
			contentPane.add(textTipodiAnestesia, gbc_textTipodiAnestesia);
			
			JLabel textTipoAnestesiaPaziente =new JLabel(valori[10]);
			textTipoAnestesiaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textTipoAnestesiaPaziente = new GridBagConstraints();
			gbc_textTipoAnestesiaPaziente.anchor = GridBagConstraints.WEST;
			gbc_textTipoAnestesiaPaziente.insets = new Insets(0, 0, 5, 0);
			gbc_textTipoAnestesiaPaziente.gridx = 2;
			gbc_textTipoAnestesiaPaziente.gridy = posY++;
			contentPane.add(textTipoAnestesiaPaziente, gbc_textTipoAnestesiaPaziente);
			
			JLabel textRischioAnestesiologico = new JLabel("Rischio anestesiologico:");
			textRischioAnestesiologico.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textRischioAnestesiologico = new GridBagConstraints();
			gbc_textRischioAnestesiologico.anchor = GridBagConstraints.WEST;
			gbc_textRischioAnestesiologico.insets = new Insets(0, 0, 5, 5);
			gbc_textRischioAnestesiologico.gridx = 0;
			gbc_textRischioAnestesiologico.gridy = posY;
			contentPane.add(textRischioAnestesiologico, gbc_textRischioAnestesiologico);
			
			JLabel textRischioAnestesiologicoPaziente =new JLabel(valori[11]);
			textRischioAnestesiologicoPaziente.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textRischioAnestesiologicoPaziente = new GridBagConstraints();
			gbc_textRischioAnestesiologicoPaziente.anchor = GridBagConstraints.WEST;
			gbc_textRischioAnestesiologicoPaziente.insets = new Insets(0, 0, 5, 0);
			gbc_textRischioAnestesiologicoPaziente.gridx = 2;
			gbc_textRischioAnestesiologicoPaziente.gridy = posY++;
			contentPane.add(textRischioAnestesiologicoPaziente, gbc_textRischioAnestesiologicoPaziente);
		}
		
		JLabel textNomeEquipe = new JLabel("Nomi dell�equipe");
		textNomeEquipe.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_textNomeEquipe = new GridBagConstraints();
		gbc_textNomeEquipe.anchor = GridBagConstraints.WEST;
		gbc_textNomeEquipe.insets = new Insets(0, 0, 5, 5);
		gbc_textNomeEquipe.gridx = 0;
		gbc_textNomeEquipe.gridy = posY++;
		contentPane.add(textNomeEquipe, gbc_textNomeEquipe);
		
		JLabel textPrimoOperatore = new JLabel("Primo Operatore:");
		textPrimoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textPrimoOperatore = new GridBagConstraints();
		gbc_textPrimoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textPrimoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textPrimoOperatore.gridx = 0;
		gbc_textPrimoOperatore.gridy = posY;
		contentPane.add(textPrimoOperatore, gbc_textPrimoOperatore);
		
		JLabel textPrimoOperatorePaziente =new JLabel(valori[12]);
		textPrimoOperatorePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textPrimoOperatorePaziente = new GridBagConstraints();
		gbc_textPrimoOperatorePaziente.anchor = GridBagConstraints.WEST;
		gbc_textPrimoOperatorePaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textPrimoOperatorePaziente.gridx = 2;
		gbc_textPrimoOperatorePaziente.gridy = posY++;
		contentPane.add(textPrimoOperatorePaziente, gbc_textPrimoOperatorePaziente);
		
		JLabel textSecondoOperatore = new JLabel("Secondo Operatore:");
		textSecondoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textSecondoOperatore = new GridBagConstraints();
		gbc_textSecondoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textSecondoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textSecondoOperatore.gridx = 0;
		gbc_textSecondoOperatore.gridy = posY;
		contentPane.add(textSecondoOperatore, gbc_textSecondoOperatore);
		
		JLabel textSecondoOperatorePaziente =new JLabel(valori[13]);
		textSecondoOperatorePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textSecondoOperatorePaziente = new GridBagConstraints();
		gbc_textSecondoOperatorePaziente.anchor = GridBagConstraints.WEST;
		gbc_textSecondoOperatorePaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textSecondoOperatorePaziente.gridx = 2;
		gbc_textSecondoOperatorePaziente.gridy = posY++;
		contentPane.add(textSecondoOperatorePaziente, gbc_textSecondoOperatorePaziente);
		
		JLabel textTerzoOperatore = new JLabel("Terzo Operatore:");
		textTerzoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTerzoOperatore = new GridBagConstraints();
		gbc_textTerzoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textTerzoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textTerzoOperatore.gridx = 0;
		gbc_textTerzoOperatore.gridy = posY;
		contentPane.add(textTerzoOperatore, gbc_textTerzoOperatore);
		
		JLabel textTerzoOperatorePaziente =new JLabel(valori[14]);
		textTerzoOperatorePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTerzoOperatorePaziente = new GridBagConstraints();
		gbc_textTerzoOperatorePaziente.anchor = GridBagConstraints.WEST;
		gbc_textTerzoOperatorePaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textTerzoOperatorePaziente.gridx = 2;
		gbc_textTerzoOperatorePaziente.gridy = posY++;
		contentPane.add(textTerzoOperatorePaziente, gbc_textTerzoOperatorePaziente);
		
		if(anestesia) {
			JLabel textAnestesita = new JLabel("Anestesita:");
			textAnestesita.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textAnestesita = new GridBagConstraints();
			gbc_textAnestesita.fill = GridBagConstraints.VERTICAL;
			gbc_textAnestesita.anchor = GridBagConstraints.WEST;
			gbc_textAnestesita.insets = new Insets(0, 0, 5, 5);
			gbc_textAnestesita.gridx = 0;
			gbc_textAnestesita.gridy = posY;
			contentPane.add(textAnestesita, gbc_textAnestesita);
			
			JLabel textAnestesistaPaziente =new JLabel(valori[15]);
			textAnestesistaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textAnestesistaPaziente = new GridBagConstraints();
			gbc_textAnestesistaPaziente.fill = GridBagConstraints.VERTICAL;
			gbc_textAnestesistaPaziente.anchor = GridBagConstraints.WEST;
			gbc_textAnestesistaPaziente.insets = new Insets(0, 0, 5, 0);
			gbc_textAnestesistaPaziente.gridx = 2;
			gbc_textAnestesistaPaziente.gridy = posY++;
			contentPane.add(textAnestesistaPaziente, gbc_textAnestesistaPaziente);
		}
		
		JLabel textStrumentista = new JLabel("Strumentista:");
		textStrumentista.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textStrumentista = new GridBagConstraints();
		gbc_textStrumentista.anchor = GridBagConstraints.WEST;
		gbc_textStrumentista.insets = new Insets(0, 0, 5, 5);
		gbc_textStrumentista.gridx = 0;
		gbc_textStrumentista.gridy = posY;
		contentPane.add(textStrumentista, gbc_textStrumentista);
		
		JLabel textStrumentistaPaziente =new JLabel(valori[16]);
		textStrumentistaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textStrumentistaPaziente = new GridBagConstraints();
		gbc_textStrumentistaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textStrumentistaPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textStrumentistaPaziente.gridx = 2;
		gbc_textStrumentistaPaziente.gridy = posY++;
		contentPane.add(textStrumentistaPaziente, gbc_textStrumentistaPaziente);
		
		JLabel textInfermierediSala = new JLabel("Infermiere di sala:");
		textInfermierediSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textInfermierediSala = new GridBagConstraints();
		gbc_textInfermierediSala.anchor = GridBagConstraints.WEST;
		gbc_textInfermierediSala.insets = new Insets(0, 0, 5, 5);
		gbc_textInfermierediSala.gridx = 0;
		gbc_textInfermierediSala.gridy = posY;
		contentPane.add(textInfermierediSala, gbc_textInfermierediSala);
		
		JLabel textInfermierePaziente =new JLabel(valori[17]);
		textInfermierePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textInfermierePaziente = new GridBagConstraints();
		gbc_textInfermierePaziente.anchor = GridBagConstraints.WEST;
		gbc_textInfermierePaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textInfermierePaziente.gridx = 2;
		gbc_textInfermierePaziente.gridy = posY++;
		contentPane.add(textInfermierePaziente, gbc_textInfermierePaziente);
		
		if(anestesia) {
			JLabel textAiutoanestesista = new JLabel("Aiutoanestesista:");
			textAiutoanestesista.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textAiutoanestesista = new GridBagConstraints();
			gbc_textAiutoanestesista.anchor = GridBagConstraints.WEST;
			gbc_textAiutoanestesista.insets = new Insets(0, 0, 5, 5);
			gbc_textAiutoanestesista.gridx = 0;
			gbc_textAiutoanestesista.gridy = posY;
			contentPane.add(textAiutoanestesista, gbc_textAiutoanestesista);
			
			JLabel textAiutoAnestesistaPaziente =new JLabel(valori[18]);
			textAiutoAnestesistaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_textAiutoAnestesistaPaziente = new GridBagConstraints();
			gbc_textAiutoAnestesistaPaziente.anchor = GridBagConstraints.WEST;
			gbc_textAiutoAnestesistaPaziente.insets = new Insets(0, 0, 5, 0);
			gbc_textAiutoAnestesistaPaziente.gridx = 2;
			gbc_textAiutoAnestesistaPaziente.gridy = posY++;
			contentPane.add(textAiutoAnestesistaPaziente, gbc_textAiutoAnestesistaPaziente);
		}
		
		
		JLabel textTecnicodiRadiologia = new JLabel("Tecnico di radiologia:");
		textTecnicodiRadiologia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTecnicodiRadiologia = new GridBagConstraints();
		gbc_textTecnicodiRadiologia.anchor = GridBagConstraints.WEST;
		gbc_textTecnicodiRadiologia.insets = new Insets(0, 0, 5, 5);
		gbc_textTecnicodiRadiologia.gridx = 0;
		gbc_textTecnicodiRadiologia.gridy = posY;
		contentPane.add(textTecnicodiRadiologia, gbc_textTecnicodiRadiologia);
		
		JLabel textTecnicoRadiologiaPaziente =new JLabel(valori[19]);
		textTecnicoRadiologiaPaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textTecnicoRadiologiaPaziente = new GridBagConstraints();
		gbc_textTecnicoRadiologiaPaziente.anchor = GridBagConstraints.WEST;
		gbc_textTecnicoRadiologiaPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textTecnicoRadiologiaPaziente.gridx = 2;
		gbc_textTecnicoRadiologiaPaziente.gridy = posY++;
		contentPane.add(textTecnicoRadiologiaPaziente, gbc_textTecnicoRadiologiaPaziente);
		
		JLabel textDiagnosi = new JLabel("Diagnosi:");
		textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDiagnosi = new GridBagConstraints();
		gbc_textDiagnosi.anchor = GridBagConstraints.WEST;
		gbc_textDiagnosi.insets = new Insets(0, 0, 5, 5);
		gbc_textDiagnosi.gridx = 0;
		gbc_textDiagnosi.gridy = posY;
		contentPane.add(textDiagnosi, gbc_textDiagnosi);

		JLabel textDiagnosiVerbale = new JLabel();
		textDiagnosiVerbale.setText(dataService.getDiagnosiOperazione(valori[21]));
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
		textDiagnosiVerbale.setText(dataService.getInterventoOperazione(valori[21]));
		gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 2;
		gbc_textArea_1.gridy = posY++;
		contentPane.add(textInterventoVerbale, gbc_textArea_1);

		JLabel textProcedura = new JLabel("Procedura:");
		textProcedura.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textProcedura = new GridBagConstraints();
		gbc_textProcedura.anchor = GridBagConstraints.WEST;
		gbc_textProcedura.insets = new Insets(0, 0, 5, 5);
		gbc_textProcedura.gridx = 0;
		gbc_textProcedura.gridy = posY;
		contentPane.add(textProcedura, gbc_textProcedura);

		JLabel textProceduraVerbale = new JLabel();
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		textDiagnosiVerbale.setText(valori[20]);
		gbc_textArea_2.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.gridx = 2;
		gbc_textArea_2.gridy = posY++;
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
		gbc_bottoneModifica.gridy = posY;
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
		gbc_bottoneConferma.gridy = posY;
		contentPane.add(bottoneConferma, gbc_bottoneConferma);

	}


	protected void mostraAnagrafica() {
		String codiceAnagraficaAssociata = dataService.getCodiceAnagraficaOperazione(codiceOperazioneAssociata);
		VisualizzazionePaginaAnagrafica visualizzaAnagrafica= new VisualizzazionePaginaAnagrafica(codiceAnagraficaAssociata, matricolaDipendente, false);
		visualizzaAnagrafica.setVisible(true);		
	}


	protected void modifica() {
		ModificaVerbale modificaVerbale= new ModificaVerbale(codiceVerbale, matricolaDipendente, "");
		modificaVerbale.setVisible(true);
		dispose();
		
	}

}
