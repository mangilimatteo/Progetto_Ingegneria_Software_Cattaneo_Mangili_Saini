package operazione;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Font;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import model.DataService;
import paginaAnagrafica.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class VisualizzazioneOperazione extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private DataService dataService;
	private String codiceOperazione;
	private String matricolaDipendente;
	private String codiceAnagraficaAssociata;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzazioneOperazione frame = new VisualizzazioneOperazione("2", "m001b");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VisualizzazioneOperazione(String codiceOperazione, String matricolaMedico) {
		dataService = new DataService();
		this.matricolaDipendente = matricolaMedico;
		this.codiceOperazione = codiceOperazione;
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		
		String[] valori = dataService.getValoriOperazione(this.codiceOperazione);
		codiceAnagraficaAssociata = valori[0];
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzazioneOperazione.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{170, 70, 275, 0};
		gbl_contentPane.rowHeights = new int[]{42, 21, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textListaOperatoria = new JLabel("Operazione N." + this.codiceOperazione);
		textListaOperatoria.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textListaOperatoria = new GridBagConstraints();
		gbc_textListaOperatoria.fill = GridBagConstraints.BOTH;
		gbc_textListaOperatoria.insets = new Insets(0, 0, 5, 5);
		gbc_textListaOperatoria.gridx = 0;
		gbc_textListaOperatoria.gridy = 0;
		contentPane.add(textListaOperatoria, gbc_textListaOperatoria);
		
		
		JButton bottoneMostraAnagrafica = new JButton("Mostra Anagrafica");
		bottoneMostraAnagrafica.setFont(new Font("Arial", Font.PLAIN, 14));
		bottoneMostraAnagrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostraAnagrafica();
			}
		});
		GridBagConstraints gbc_mostraAnagrafica = new GridBagConstraints();
		gbc_mostraAnagrafica.insets = new Insets(0, 0, 5, 0);
		gbc_mostraAnagrafica.gridx = 2;
		gbc_mostraAnagrafica.gridy = 0;
		contentPane.add(bottoneMostraAnagrafica, gbc_mostraAnagrafica);
		
		JLabel textNumeroBloccoOperatorio = new JLabel("Numero del Blocco Operatorio:");
		textNumeroBloccoOperatorio.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNumeroBloccoOperatorio = new GridBagConstraints();
		gbc_textNumeroBloccoOperatorio.anchor = GridBagConstraints.NORTHWEST;
		gbc_textNumeroBloccoOperatorio.insets = new Insets(0, 0, 5, 5);
		gbc_textNumeroBloccoOperatorio.gridwidth = 2;
		gbc_textNumeroBloccoOperatorio.gridx = 0;
		gbc_textNumeroBloccoOperatorio.gridy = 2;
		contentPane.add(textNumeroBloccoOperatorio, gbc_textNumeroBloccoOperatorio);
		
		JLabel spinnerBloccoOperatorio = new JLabel();
		spinnerBloccoOperatorio.setText(valori[1]);
		spinnerBloccoOperatorio.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_spinnerBloccoOperatorio = new GridBagConstraints();
		gbc_spinnerBloccoOperatorio.anchor = GridBagConstraints.SOUTH;
		gbc_spinnerBloccoOperatorio.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerBloccoOperatorio.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerBloccoOperatorio.gridx = 2;
		gbc_spinnerBloccoOperatorio.gridy = 2;
		contentPane.add(spinnerBloccoOperatorio, gbc_spinnerBloccoOperatorio);
		gbc_spinnerBloccoOperatorio.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel textNumerodellaSala = new JLabel("Numero della sala:");
		textNumerodellaSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNumerodellaSala = new GridBagConstraints();
		gbc_textNumerodellaSala.insets = new Insets(0, 0, 5, 5);
		gbc_textNumerodellaSala.anchor = GridBagConstraints.NORTHWEST;
		gbc_textNumerodellaSala.gridwidth = 2;
		gbc_textNumerodellaSala.gridx = 0;
		gbc_textNumerodellaSala.gridy = 3;
		contentPane.add(textNumerodellaSala, gbc_textNumerodellaSala);
		
		JLabel spinnerNumeroSala = new JLabel();
		spinnerNumeroSala.setText(valori[2]);
		spinnerNumeroSala.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_spinnerNumeroSala = new GridBagConstraints();
		gbc_spinnerNumeroSala.anchor = GridBagConstraints.WEST;
		
				gbc_spinnerNumeroSala.insets = new Insets(0, 0, 5, 0);
				gbc_spinnerNumeroSala.gridx = 2;
				gbc_spinnerNumeroSala.gridy = 3;
				contentPane.add(spinnerNumeroSala, gbc_spinnerNumeroSala);
		
		JLabel textNomePaziente = new JLabel("Nome Paziente:");
		textNomePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNomePaziente = new GridBagConstraints();
		gbc_textNomePaziente.anchor = GridBagConstraints.WEST;
		gbc_textNomePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textNomePaziente.gridx = 0;
		gbc_textNomePaziente.gridy = 4;
		contentPane.add(textNomePaziente, gbc_textNomePaziente);
		
		JLabel textNomeOperazione = new JLabel();
		textNomeOperazione.setText(dataService.getNomeAnagrafica(valori[0]));
		textNomeOperazione.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNomeOperazione = new GridBagConstraints();
		gbc_textNomeOperazione.insets = new Insets(0, 0, 5, 0);
		gbc_textNomeOperazione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomeOperazione.gridx = 2;
		gbc_textNomeOperazione.gridy = 4;
		contentPane.add(textNomeOperazione, gbc_textNomeOperazione);
		
		JLabel textCognomePaziente = new JLabel("Cognome Paziente:");
		textCognomePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textCognomePaziente = new GridBagConstraints();
		gbc_textCognomePaziente.anchor = GridBagConstraints.WEST;
		gbc_textCognomePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textCognomePaziente.gridx = 0;
		gbc_textCognomePaziente.gridy = 5;
		contentPane.add(textCognomePaziente, gbc_textCognomePaziente);
		
		JLabel textCognomeOperazione = new JLabel();
		textCognomeOperazione.setText(dataService.getCognomeAnagrafica(valori[0]));
		textCognomeOperazione.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textCognomeOperazione = new GridBagConstraints();
		gbc_textCognomeOperazione.insets = new Insets(0, 0, 5, 0);
		gbc_textCognomeOperazione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCognomeOperazione.gridx = 2;
		gbc_textCognomeOperazione.gridy = 5;
		contentPane.add(textCognomeOperazione, gbc_textCognomeOperazione);
		
		JLabel textDatadiNascita = new JLabel("Data di Nascita:");
		textDatadiNascita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDatadiNascita = new GridBagConstraints();
		gbc_textDatadiNascita.anchor = GridBagConstraints.WEST;
		gbc_textDatadiNascita.insets = new Insets(0, 0, 5, 5);
		gbc_textDatadiNascita.gridx = 0;
		gbc_textDatadiNascita.gridy = 6;
		contentPane.add(textDatadiNascita, gbc_textDatadiNascita);
		
		JLabel textNascita = new JLabel();
		textNascita.setText(dataService.getNascitaAnagrafica(valori[0]));
		textNascita.setHorizontalAlignment(SwingConstants.LEFT);
		textNascita.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNascita = new GridBagConstraints();
		gbc_textNascita.insets = new Insets(0, 0, 5, 0);
		gbc_textNascita.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNascita.gridx = 2;
		gbc_textNascita.gridy = 6;
		contentPane.add(textNascita, gbc_textNascita);
		
		JLabel textDiagnosi = new JLabel("Diagnosi:");
		textDiagnosi.setHorizontalAlignment(SwingConstants.LEFT);
		textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDiagnosi = new GridBagConstraints();
		gbc_textDiagnosi.anchor = GridBagConstraints.WEST;
		gbc_textDiagnosi.insets = new Insets(0, 0, 5, 5);
		gbc_textDiagnosi.gridx = 0;
		gbc_textDiagnosi.gridy = 8;
		contentPane.add(textDiagnosi, gbc_textDiagnosi);
		
		JLabel textDiagnosiPaziente = new JLabel();
		textDiagnosiPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textDiagnosiPaziente.setText(dataService.getDiagnosiAnagrafica(valori[0]));
		GridBagConstraints gbc_textDiagnosiPaziente = new GridBagConstraints();
		gbc_textDiagnosiPaziente.gridheight = 2;
		gbc_textDiagnosiPaziente.insets = new Insets(0, 0, 5, 0);
		gbc_textDiagnosiPaziente.fill = GridBagConstraints.BOTH;
		gbc_textDiagnosiPaziente.gridx = 2;
		gbc_textDiagnosiPaziente.gridy = 8;
		contentPane.add(textDiagnosiPaziente, gbc_textDiagnosiPaziente);
		
		JLabel textIntervento = new JLabel("Intervento:");
		textIntervento.setHorizontalAlignment(SwingConstants.LEFT);
		textIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textIntervento = new GridBagConstraints();
		gbc_textIntervento.anchor = GridBagConstraints.WEST;
		gbc_textIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textIntervento.gridx = 0;
		gbc_textIntervento.gridy = 10;
		contentPane.add(textIntervento, gbc_textIntervento);
		
		JLabel textInterventoOperazione = new JLabel();
		textInterventoOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		textInterventoOperazione.setText(dataService.getInterventoAnagrafica(valori[0]));
		GridBagConstraints gbc_textInterventoOperazione = new GridBagConstraints();
		gbc_textInterventoOperazione.gridheight = 2;
		gbc_textInterventoOperazione.insets = new Insets(0, 0, 5, 0);
		gbc_textInterventoOperazione.fill = GridBagConstraints.BOTH;
		gbc_textInterventoOperazione.gridx = 2;
		gbc_textInterventoOperazione.gridy = 10;
		contentPane.add(textInterventoOperazione, gbc_textInterventoOperazione);
		
		
		JLabel textPresenzaAnestesia = new JLabel("Presenza Anestesia:");
		textPresenzaAnestesia.setHorizontalAlignment(SwingConstants.LEFT);
		textPresenzaAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textPresenzaAnestesia = new GridBagConstraints();
		gbc_textPresenzaAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textPresenzaAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textPresenzaAnestesia.gridx = 0;
		gbc_textPresenzaAnestesia.gridy = 12;
		contentPane.add(textPresenzaAnestesia, gbc_textPresenzaAnestesia);
		
		JLabel Anestesia = new JLabel();
		if(Boolean.valueOf(valori[3])) {
			Anestesia.setText("Si");
		}
		else {
			Anestesia.setText("No");
		}		
		Anestesia.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_rdbtnAnestesiaY = new GridBagConstraints();
		gbc_rdbtnAnestesiaY.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAnestesiaY.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAnestesiaY.gridx = 2;
		gbc_rdbtnAnestesiaY.gridy = 12;
		contentPane.add(Anestesia, gbc_rdbtnAnestesiaY);
		
		JLabel textDatiMedico = new JLabel("Dati medico che ha richiesto intervento");
		textDatiMedico.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDatiMedico = new GridBagConstraints();
		gbc_textDatiMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDatiMedico.gridwidth = 4;
		gbc_textDatiMedico.insets = new Insets(0, 0, 5, 0);
		gbc_textDatiMedico.gridx = 0;
		gbc_textDatiMedico.gridy = 14;
		contentPane.add(textDatiMedico, gbc_textDatiMedico);
		
		JLabel textNomeMedico = new JLabel("Nome:");
		textNomeMedico.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNomeMedico = new GridBagConstraints();
		gbc_textNomeMedico.anchor = GridBagConstraints.WEST;
		gbc_textNomeMedico.insets = new Insets(0, 0, 5, 5);
		gbc_textNomeMedico.gridx = 0;
		gbc_textNomeMedico.gridy = 15;
		contentPane.add(textNomeMedico, gbc_textNomeMedico);
		
		JLabel textNomeMedicoOperazione = new JLabel();
		textNomeMedicoOperazione.setText(dataService.getNomeDipendente(valori[4]));
		textNomeMedicoOperazione.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeMedicoOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textNomeMedicoOperazione = new GridBagConstraints();
		gbc_textNomeMedicoOperazione.insets = new Insets(0, 0, 5, 5);
		gbc_textNomeMedicoOperazione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomeMedicoOperazione.gridx = 2;
		gbc_textNomeMedicoOperazione.gridy = 15;
		contentPane.add(textNomeMedicoOperazione, gbc_textNomeMedicoOperazione);
		
		JLabel textCognomeMedico = new JLabel("Cognome:");
		textCognomeMedico.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textCognomeMedico = new GridBagConstraints();
		gbc_textCognomeMedico.anchor = GridBagConstraints.WEST;
		gbc_textCognomeMedico.insets = new Insets(0, 0, 5, 5);
		gbc_textCognomeMedico.gridx = 0;
		gbc_textCognomeMedico.gridy = 16;
		contentPane.add(textCognomeMedico, gbc_textCognomeMedico);
		
		JLabel textCognomeMedicoOperazione = new JLabel();
		textCognomeMedicoOperazione.setText(dataService.getCognomeDipendente(valori[4]));
		textCognomeMedicoOperazione.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeMedicoOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textCognomeMedicoOperazione = new GridBagConstraints();
		gbc_textCognomeMedicoOperazione.insets = new Insets(0, 0, 5, 5);
		gbc_textCognomeMedicoOperazione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCognomeMedicoOperazione.gridx = 2;
		gbc_textCognomeMedicoOperazione.gridy = 16;
		contentPane.add(textCognomeMedicoOperazione, gbc_textCognomeMedicoOperazione);
		
		JLabel textMatricola = new JLabel("Matricola:");
		textMatricola.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textMatricola = new GridBagConstraints();
		gbc_textMatricola.anchor = GridBagConstraints.WEST;
		gbc_textMatricola.insets = new Insets(0, 0, 5, 5);
		gbc_textMatricola.gridx = 0;
		gbc_textMatricola.gridy = 17;
		contentPane.add(textMatricola, gbc_textMatricola);
		
		JLabel textMatricolaMedico = new JLabel();
		textMatricolaMedico.setText(valori[4]);
		textMatricolaMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textMatricolaMedico.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_textMatricolaMedico = new GridBagConstraints();
		gbc_textMatricolaMedico.insets = new Insets(0, 0, 5, 5);
		gbc_textMatricolaMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMatricolaMedico.gridx = 2;
		gbc_textMatricolaMedico.gridy = 17;
		contentPane.add(textMatricolaMedico, gbc_textMatricolaMedico);
		
		if(dataService.operazioneModificabile(codiceOperazione, matricolaMedico)) {
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
			gbc_bottoneModifica.gridy = 19;
			contentPane.add(bottoneModifica, gbc_bottoneModifica);
		}
		
		JButton bottoneChiudi = new JButton("Chiudi");
		bottoneChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bottoneChiudi.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_bottoneChiudi = new GridBagConstraints();
		gbc_bottoneChiudi.gridx = 2;
		gbc_bottoneChiudi.gridy = 19;
		contentPane.add(bottoneChiudi, gbc_bottoneChiudi);
		
	}
	
	protected void MostraAnagrafica() {
		VisualizzazionePaginaAnagrafica visualizzaAnagrafica= new VisualizzazionePaginaAnagrafica(codiceAnagraficaAssociata, matricolaDipendente);
		visualizzaAnagrafica.setVisible(true);
				
	}
	
	protected void modifica() {
		ModificaOperazione modificaOperazione= new ModificaOperazione(codiceOperazione, matricolaDipendente, "");
		modificaOperazione.setVisible(true);
		dispose();				
	}

	
}
