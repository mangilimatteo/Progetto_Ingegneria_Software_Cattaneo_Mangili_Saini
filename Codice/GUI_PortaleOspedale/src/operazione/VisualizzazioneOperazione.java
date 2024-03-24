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
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		setBounds(100, 100, 586, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textListaOperatoria = new JLabel("Operazione N." + this.codiceOperazione);
		textListaOperatoria.setBounds(5, 11, 165, 37);
		textListaOperatoria.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textListaOperatoria);
		
		
		JButton bottoneMostraAnagrafica = new JButton("Mostra Anagrafica");
		bottoneMostraAnagrafica.setBounds(315, 11, 177, 25);
		bottoneMostraAnagrafica.setFont(new Font("Arial", Font.PLAIN, 14));
		bottoneMostraAnagrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostraAnagrafica();
			}
		});
		contentPane.add(bottoneMostraAnagrafica);
		
		JLabel textNumeroBloccoOperatorio = new JLabel("Numero del Blocco Operatorio:");
		textNumeroBloccoOperatorio.setBounds(5, 77, 237, 19);
		textNumeroBloccoOperatorio.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textNumeroBloccoOperatorio);
		
		JLabel spinnerBloccoOperatorio = new JLabel();
		spinnerBloccoOperatorio.setBounds(247, 79, 283, 17);
		spinnerBloccoOperatorio.setText(valori[1]);
		spinnerBloccoOperatorio.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(spinnerBloccoOperatorio);
		
		JLabel textNumerodellaSala = new JLabel("Numero della sala:");
		textNumerodellaSala.setBounds(5, 101, 142, 19);
		textNumerodellaSala.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textNumerodellaSala);
		
		JLabel spinnerNumeroSala = new JLabel();
		spinnerNumeroSala.setBounds(247, 102, 68, 17);
		spinnerNumeroSala.setText(valori[2]);
		spinnerNumeroSala.setFont(new Font("Arial", Font.PLAIN, 14));
				contentPane.add(spinnerNumeroSala);
		
		JLabel textNomePaziente = new JLabel("Nome Paziente:");
		textNomePaziente.setBounds(5, 125, 121, 19);
		textNomePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textNomePaziente);
		
		JLabel textNomeOperazione = new JLabel();
		textNomeOperazione.setBounds(247, 126, 283, 17);
		textNomeOperazione.setText(dataService.getNomeAnagrafica(valori[0]));
		textNomeOperazione.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(textNomeOperazione);
		
		JLabel textCognomePaziente = new JLabel("Cognome Paziente:");
		textCognomePaziente.setBounds(5, 149, 151, 19);
		textCognomePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textCognomePaziente);
		
		JLabel textCognomeOperazione = new JLabel();
		textCognomeOperazione.setBounds(247, 150, 283, 17);
		textCognomeOperazione.setText(dataService.getCognomeAnagrafica(valori[0]));
		textCognomeOperazione.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(textCognomeOperazione);
		
		JLabel textDatadiNascita = new JLabel("Data di Nascita:");
		textDatadiNascita.setBounds(5, 173, 120, 19);
		textDatadiNascita.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textDatadiNascita);
		
		JLabel textNascita = new JLabel();
		textNascita.setBounds(247, 174, 283, 17);
		textNascita.setText(dataService.getNascitaAnagrafica(valori[0]));
		textNascita.setHorizontalAlignment(SwingConstants.LEFT);
		textNascita.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(textNascita);
		
		JLabel textDiagnosi = new JLabel("Diagnosi:");
		textDiagnosi.setBounds(5, 227, 74, 19);
		textDiagnosi.setHorizontalAlignment(SwingConstants.LEFT);
		textDiagnosi.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textDiagnosi);
		
		JLabel textDiagnosiPaziente = new JLabel();
		textDiagnosiPaziente.setBounds(247, 213, 283, 49);
		textDiagnosiPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textDiagnosiPaziente.setText(dataService.getDiagnosiAnagrafica(valori[0]));
		contentPane.add(textDiagnosiPaziente);
		
		JLabel textIntervento = new JLabel("Intervento:");
		textIntervento.setBounds(5, 281, 83, 19);
		textIntervento.setHorizontalAlignment(SwingConstants.LEFT);
		textIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textIntervento);
		
		JLabel textInterventoOperazione = new JLabel();
		textInterventoOperazione.setBounds(247, 267, 283, 49);
		textInterventoOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		textInterventoOperazione.setText(dataService.getInterventoAnagrafica(valori[0]));
		contentPane.add(textInterventoOperazione);
		
		
		JLabel textPresenzaAnestesia = new JLabel("Presenza Anestesia:");
		textPresenzaAnestesia.setBounds(5, 335, 157, 19);
		textPresenzaAnestesia.setHorizontalAlignment(SwingConstants.LEFT);
		textPresenzaAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textPresenzaAnestesia);
		
		JLabel Anestesia = new JLabel();
		Anestesia.setText("<dynamic>");
		Anestesia.setBounds(247, 322, 113, 32);
		if(Boolean.valueOf(valori[3])) {
			Anestesia.setText("Si");
		}
		else {
			Anestesia.setText("No");
		}		
		Anestesia.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(Anestesia);
		
		JLabel textDatiMedico = new JLabel("Dati medico che ha richiesto intervento");
		textDatiMedico.setBounds(5, 389, 560, 19);
		textDatiMedico.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textDatiMedico);
		
		JLabel textNomeMedico = new JLabel("Nome:");
		textNomeMedico.setBounds(5, 413, 51, 19);
		textNomeMedico.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textNomeMedico);
		
		JLabel textNomeMedicoOperazione = new JLabel();
		textNomeMedicoOperazione.setBounds(247, 414, 283, 17);
		textNomeMedicoOperazione.setText(dataService.getNomeDipendente(valori[4]));
		textNomeMedicoOperazione.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeMedicoOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(textNomeMedicoOperazione);
		
		JLabel textCognomeMedico = new JLabel("Cognome:");
		textCognomeMedico.setBounds(5, 437, 81, 19);
		textCognomeMedico.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textCognomeMedico);
		
		JLabel textCognomeMedicoOperazione = new JLabel();
		textCognomeMedicoOperazione.setBounds(247, 438, 283, 17);
		textCognomeMedicoOperazione.setText(dataService.getCognomeDipendente(valori[4]));
		textCognomeMedicoOperazione.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeMedicoOperazione.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(textCognomeMedicoOperazione);
		
		JLabel textMatricola = new JLabel("Matricola:");
		textMatricola.setBounds(5, 461, 75, 19);
		textMatricola.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(textMatricola);
		
		JLabel textMatricolaMedico = new JLabel();
		textMatricolaMedico.setBounds(247, 462, 283, 17);
		textMatricolaMedico.setText(valori[4]);
		textMatricolaMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textMatricolaMedico.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(textMatricolaMedico);
		
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
		bottoneChiudi.setBounds(352, 485, 83, 25);
		bottoneChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bottoneChiudi.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(bottoneChiudi);
		
	}
	
	protected void MostraAnagrafica() {
		VisualizzazionePaginaAnagrafica visualizzaAnagrafica= new VisualizzazionePaginaAnagrafica(codiceAnagraficaAssociata, matricolaDipendente);
		visualizzaAnagrafica.setUndecorated(true);
		visualizzaAnagrafica.setVisible(true);
		visualizzaAnagrafica.setExtendedState(JFrame.MAXIMIZED_BOTH);		
	}
	
	protected void modifica() {
		ModificaOperazione modificaOperazione= new ModificaOperazione(codiceOperazione, matricolaDipendente, "");
		modificaOperazione.setUndecorated(true);
		modificaOperazione.setVisible(true);
		modificaOperazione.setExtendedState(JFrame.MAXIMIZED_BOTH);
		dispose();				
	}
}
