package paziente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import model.DataService;

import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class VisualizzazioneOperazione extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spinnerBloccoOperatorio;
	private JSpinner spinnerNumeroSala;
	private JRadioButton rdbtnAnestesia;
	private JTextField textPrimoOperatore;
	
	private DataService dataService;
	private String codiceOperazione;
	private String matricolaDipendente;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzazioneOperazione frame = new VisualizzazioneOperazione("0", "m001a");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VisualizzazioneOperazione(String codiceOperazione, String matricolaDipendente) {
		dataService = new DataService();
		this.matricolaDipendente = matricolaDipendente;
		this.codiceOperazione = dataService.getCodiceOperazione(codiceOperazione);
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		
		String[] valori = dataService.getValoriOperazione(this.codiceOperazione);
	
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzazioneOperazione.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{170, 70, 275, 0};
		gbl_contentPane.rowHeights = new int[]{42, 21, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textListaOperatoria = new JLabel("Operazione:");
		textListaOperatoria.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textListaOperatoria = new GridBagConstraints();
		gbc_textListaOperatoria.fill = GridBagConstraints.BOTH;
		gbc_textListaOperatoria.insets = new Insets(0, 0, 5, 5);
		gbc_textListaOperatoria.gridx = 0;
		gbc_textListaOperatoria.gridy = 0;
		contentPane.add(textListaOperatoria, gbc_textListaOperatoria);
		
		JLabel textNumeroBloccoOperatorio = new JLabel("Numero del Blocco Operatorio:");
		textNumeroBloccoOperatorio.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNumeroBloccoOperatorio = new GridBagConstraints();
		gbc_textNumeroBloccoOperatorio.anchor = GridBagConstraints.NORTHWEST;
		gbc_textNumeroBloccoOperatorio.insets = new Insets(0, 0, 5, 5);
		gbc_textNumeroBloccoOperatorio.gridwidth = 2;
		gbc_textNumeroBloccoOperatorio.gridx = 0;
		gbc_textNumeroBloccoOperatorio.gridy = 1;
		contentPane.add(textNumeroBloccoOperatorio, gbc_textNumeroBloccoOperatorio);
		
		JLabel spinnerBloccoOperatorio = new JLabel();
		spinnerBloccoOperatorio.setText(valori[1]);
		GridBagConstraints gbc_spinnerBloccoOperatorio = new GridBagConstraints();
		gbc_spinnerBloccoOperatorio.anchor = GridBagConstraints.SOUTH;
		gbc_spinnerBloccoOperatorio.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerBloccoOperatorio.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerBloccoOperatorio.gridx = 2;
		gbc_spinnerBloccoOperatorio.gridy = 1;
		contentPane.add(spinnerBloccoOperatorio, gbc_spinnerBloccoOperatorio);
		
		JLabel textNumerodellaSala = new JLabel("Numero della sala:");
		textNumerodellaSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNumerodellaSala = new GridBagConstraints();
		gbc_textNumerodellaSala.insets = new Insets(0, 0, 5, 5);
		gbc_textNumerodellaSala.anchor = GridBagConstraints.NORTHWEST;
		gbc_textNumerodellaSala.gridwidth = 2;
		gbc_textNumerodellaSala.gridx = 0;
		gbc_textNumerodellaSala.gridy = 2;
		contentPane.add(textNumerodellaSala, gbc_textNumerodellaSala);
		
		JLabel spinnerNumeroSala = new JLabel();
		spinnerNumeroSala.setText(valori[2]);
		GridBagConstraints gbc_spinnerNumeroSala = new GridBagConstraints();
		gbc_spinnerNumeroSala.anchor = GridBagConstraints.WEST;
		gbc_spinnerBloccoOperatorio.fill = GridBagConstraints.HORIZONTAL;

		gbc_spinnerNumeroSala.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerNumeroSala.gridx = 2;
		gbc_spinnerNumeroSala.gridy = 2;
		contentPane.add(spinnerNumeroSala, gbc_spinnerNumeroSala);
		
		JLabel textNomePaziente = new JLabel("Nome Paziente:");
		textNomePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNomePaziente = new GridBagConstraints();
		gbc_textNomePaziente.anchor = GridBagConstraints.WEST;
		gbc_textNomePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textNomePaziente.gridx = 0;
		gbc_textNomePaziente.gridy = 3;
		contentPane.add(textNomePaziente, gbc_textNomePaziente);
		
		JLabel textNomeOperazione = new JLabel();
		textNomeOperazione.setText(dataService.getNomeAnagrafica(valori[0]));
		textNomeOperazione.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNomeOperazione = new GridBagConstraints();
		gbc_textNomeOperazione.insets = new Insets(0, 0, 5, 0);
		gbc_textNomeOperazione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomeOperazione.gridx = 2;
		gbc_textNomeOperazione.gridy = 3;
		contentPane.add(textNomeOperazione, gbc_textNomeOperazione);
		
		JLabel textCognomePaziente = new JLabel("Cognome Paziente:");
		textCognomePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textCognomePaziente = new GridBagConstraints();
		gbc_textCognomePaziente.anchor = GridBagConstraints.WEST;
		gbc_textCognomePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textCognomePaziente.gridx = 0;
		gbc_textCognomePaziente.gridy = 4;
		contentPane.add(textCognomePaziente, gbc_textCognomePaziente);
		
		JLabel textCognomeOperazione = new JLabel();
		textCognomeOperazione.setText(dataService.getCognomeAnagrafica(valori[0]));
		textCognomeOperazione.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textCognomeOperazione = new GridBagConstraints();
		gbc_textCognomeOperazione.insets = new Insets(0, 0, 5, 0);
		gbc_textCognomeOperazione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCognomeOperazione.gridx = 2;
		gbc_textCognomeOperazione.gridy = 4;
		contentPane.add(textCognomeOperazione, gbc_textCognomeOperazione);
		
		JLabel textDatadiNascita = new JLabel("Data di Nascita:");
		textDatadiNascita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDatadiNascita = new GridBagConstraints();
		gbc_textDatadiNascita.anchor = GridBagConstraints.WEST;
		gbc_textDatadiNascita.insets = new Insets(0, 0, 5, 5);
		gbc_textDatadiNascita.gridx = 0;
		gbc_textDatadiNascita.gridy = 5;
		contentPane.add(textDatadiNascita, gbc_textDatadiNascita);
		
		JLabel textNascita = new JLabel();
		textNascita.setText(dataService.getNascitaAnagrafica(valori[0]));
		textNascita.setHorizontalAlignment(SwingConstants.LEFT);
		textNascita.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNascita = new GridBagConstraints();
		gbc_textNascita.insets = new Insets(0, 0, 5, 0);
		gbc_textNascita.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNascita.gridx = 2;
		gbc_textNascita.gridy = 5;
		contentPane.add(textNascita, gbc_textNascita);
		
		JLabel textRI = new JLabel("RI:");
		textRI.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textRI = new GridBagConstraints();
		gbc_textRI.anchor = GridBagConstraints.WEST;
		gbc_textRI.insets = new Insets(0, 0, 5, 5);
		gbc_textRI.gridx = 0;
		gbc_textRI.gridy = 6;
		contentPane.add(textRI, gbc_textRI);
		
		JLabel textDiagnosi = new JLabel("Diagnosi:");
		textDiagnosi.setHorizontalAlignment(SwingConstants.LEFT);
		textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDiagnosi = new GridBagConstraints();
		gbc_textDiagnosi.anchor = GridBagConstraints.WEST;
		gbc_textDiagnosi.insets = new Insets(0, 0, 5, 5);
		gbc_textDiagnosi.gridx = 0;
		gbc_textDiagnosi.gridy = 7;
		contentPane.add(textDiagnosi, gbc_textDiagnosi);
		
		JLabel textDiagnosiPaziente = new JLabel();
		textDiagnosiPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textDiagnosiPaziente.setText(dataService.getDiagnosiAnagrafica(valori[0]));
		GridBagConstraints gbc_textDiagnosiPaziente = new GridBagConstraints();
		gbc_textDiagnosiPaziente.gridheight = 2;
		gbc_textDiagnosiPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textDiagnosiPaziente.fill = GridBagConstraints.BOTH;
		gbc_textDiagnosiPaziente.gridx = 2;
		gbc_textDiagnosiPaziente.gridy = 7;
		contentPane.add(textDiagnosiPaziente, gbc_textDiagnosiPaziente);
		
		JLabel textIntervento = new JLabel("Intervento:");
		textIntervento.setHorizontalAlignment(SwingConstants.LEFT);
		textIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textIntervento = new GridBagConstraints();
		gbc_textIntervento.anchor = GridBagConstraints.WEST;
		gbc_textIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textIntervento.gridx = 0;
		gbc_textIntervento.gridy = 9;
		contentPane.add(textIntervento, gbc_textIntervento);
		
		JLabel textInterventoOperazione = new JLabel();
		textInterventoOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		textInterventoOperazione.setText(dataService.getInterventoAnagrafica(valori[0]));
		GridBagConstraints gbc_textInterventoOperazione = new GridBagConstraints();
		gbc_textInterventoOperazione.gridheight = 2;
		gbc_textInterventoOperazione.insets = new Insets(0, 0, 5, 0);
		gbc_textInterventoOperazione.fill = GridBagConstraints.BOTH;
		gbc_textInterventoOperazione.gridx = 2;
		gbc_textInterventoOperazione.gridy = 9;
		contentPane.add(textInterventoOperazione, gbc_textInterventoOperazione);
		
		JLabel textPresenzaAnestesia = new JLabel("Presenza Anestesia:");
		textPresenzaAnestesia.setHorizontalAlignment(SwingConstants.LEFT);
		textPresenzaAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textPresenzaAnestesia = new GridBagConstraints();
		gbc_textPresenzaAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textPresenzaAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textPresenzaAnestesia.gridx = 0;
		gbc_textPresenzaAnestesia.gridy = 11;
		contentPane.add(textPresenzaAnestesia, gbc_textPresenzaAnestesia);
		
		JLabel Anestesia = new JLabel();
		if(Boolean.valueOf(valori[3])) {
			Anestesia.setText("Sì");
		}
		else {
			Anestesia.setText("No");
		}
		GridBagConstraints gbc_rdbtnAnestesiaY = new GridBagConstraints();
		gbc_rdbtnAnestesiaY.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAnestesiaY.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAnestesiaY.gridx = 2;
		gbc_rdbtnAnestesiaY.gridy = 11;
		contentPane.add(Anestesia, gbc_rdbtnAnestesiaY);
		
		JLabel textNomePrimoOperatore = new JLabel("Nome Primo Operatore:");
		textNomePrimoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNomePrimoOperatore = new GridBagConstraints();
		gbc_textNomePrimoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textNomePrimoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textNomePrimoOperatore.gridx = 0;
		gbc_textNomePrimoOperatore.gridy = 13;
		contentPane.add(textNomePrimoOperatore, gbc_textNomePrimoOperatore);
		
		JLabel textPrimoOperatore = new JLabel();
		textPrimoOperatore.setText(valori[4]);
		textPrimoOperatore.setHorizontalAlignment(SwingConstants.LEFT);
		textPrimoOperatore.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNomeMedico = new GridBagConstraints();
		gbc_textNomeMedico.insets = new Insets(0, 0, 5, 0);
		gbc_textNomeMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomeMedico.gridx = 2;
		gbc_textNomeMedico.gridy = 13;
		contentPane.add(textPrimoOperatore, gbc_textNomeMedico);
		
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
		gbc_bottoneModifica.gridy = 14;
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
		gbc_bottoneConferma.gridy = 14;
		contentPane.add(bottoneConferma, gbc_bottoneConferma);
		
	}
	
	protected void modifica() {
		if(dataService.getRuoloDipendente(matricolaDipendente).equals("Medico")) {
			ModificaOperazione modificaOperazione= new ModificaOperazione(codiceOperazione, matricolaDipendente, "");
			modificaOperazione.setVisible(true);
			dispose();
		}
		
		else {
			JOptionPane.showMessageDialog(null,"Errore, solo i medici possono modificare le operazioni");
		}
				
	}

	
}
