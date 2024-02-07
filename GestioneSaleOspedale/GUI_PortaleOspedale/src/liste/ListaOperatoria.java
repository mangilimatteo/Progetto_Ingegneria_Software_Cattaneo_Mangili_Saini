package liste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class ListaOperatoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCognome;
	private JTextField textNomeMedico;
	private JTextField textCognomeMedico;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaOperatoria frame = new ListaOperatoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListaOperatoria() {
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaOperatoria.class.getResource("/resources/LogoOspedale.png")));
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
		
		JLabel textListaOperatoria = new JLabel("Lista Operatoria:");
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
		
		int[] sala_min= {1};
		int[] sala_max= {6};
		JSpinner spinnerNumeroSala = new JSpinner();
		JSpinner spinnerBloccoOperatorio = new JSpinner();
		spinnerBloccoOperatorio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				IntervalloSala(spinnerBloccoOperatorio, sala_min, sala_max);
				spinnerNumeroSala.setModel(new SpinnerNumberModel(sala_min[0] ,sala_min[0], sala_max[0], 1));
			}
		});
		spinnerBloccoOperatorio.setModel(new SpinnerListModel(new String[] {"Giallo", "Verde", "Blu", "Azzurro"}));
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
		
		spinnerNumeroSala.setModel(new SpinnerNumberModel(sala_min[0], sala_min[0], sala_max[0], 1));
		GridBagConstraints gbc_spinnerNumeroSala = new GridBagConstraints();
		gbc_spinnerNumeroSala.anchor = GridBagConstraints.WEST;
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
		
		textNome = new JTextField();
		textNome.setText("aaa");
		textNome.setHorizontalAlignment(SwingConstants.LEFT);
		textNome.setFont(new Font("Arial", Font.PLAIN, 14));
		textNome.setEditable(false);
		textNome.setColumns(10);
		GridBagConstraints gbc_textNome = new GridBagConstraints();
		gbc_textNome.insets = new Insets(0, 0, 5, 0);
		gbc_textNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNome.gridx = 2;
		gbc_textNome.gridy = 3;
		contentPane.add(textNome, gbc_textNome);
		
		JLabel textCognomePaziente = new JLabel("Cognome Paziente:");
		textCognomePaziente.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textCognomePaziente = new GridBagConstraints();
		gbc_textCognomePaziente.anchor = GridBagConstraints.WEST;
		gbc_textCognomePaziente.insets = new Insets(0, 0, 5, 5);
		gbc_textCognomePaziente.gridx = 0;
		gbc_textCognomePaziente.gridy = 4;
		contentPane.add(textCognomePaziente, gbc_textCognomePaziente);
		
		textCognome = new JTextField();
		textCognome.setText("aaa");
		textCognome.setHorizontalAlignment(SwingConstants.LEFT);
		textCognome.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognome.setEditable(false);
		textCognome.setColumns(10);
		GridBagConstraints gbc_textCognome = new GridBagConstraints();
		gbc_textCognome.insets = new Insets(0, 0, 5, 0);
		gbc_textCognome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCognome.gridx = 2;
		gbc_textCognome.gridy = 4;
		contentPane.add(textCognome, gbc_textCognome);
		
		JLabel textDatadiNascita = new JLabel("Datadi Nascita:");
		textDatadiNascita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textDatadiNascita = new GridBagConstraints();
		gbc_textDatadiNascita.anchor = GridBagConstraints.WEST;
		gbc_textDatadiNascita.insets = new Insets(0, 0, 5, 5);
		gbc_textDatadiNascita.gridx = 0;
		gbc_textDatadiNascita.gridy = 5;
		contentPane.add(textDatadiNascita, gbc_textDatadiNascita);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
		
		JSpinner spinnerGiorno = new JSpinner();
		spinnerGiorno.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		panel.add(spinnerGiorno);
		spinnerGiorno.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerGiorno.setEnabled(false);
		
		JSpinner spinnerMese = new JSpinner();
		spinnerMese.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMese.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerMese.setEnabled(false);
		panel.add(spinnerMese);
		
		JSpinner spinnerAnno = new JSpinner();
		spinnerAnno.setModel(new SpinnerNumberModel(Integer.valueOf(1800), Integer.valueOf(1800), null, Integer.valueOf(1)));
		spinnerAnno.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerAnno.setEnabled(false);
		panel.add(spinnerAnno);
		
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
		
		JTextArea textDiagnosiPaziente = new JTextArea();
		textDiagnosiPaziente.setFont(new Font("Arial", Font.PLAIN, 14));
		textDiagnosiPaziente.setEditable(false);
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
		
		JTextArea textDiagnosiPaziente_1 = new JTextArea();
		textDiagnosiPaziente_1.setFont(new Font("Arial", Font.PLAIN, 14));
		textDiagnosiPaziente_1.setEditable(false);
		GridBagConstraints gbc_textDiagnosiPaziente_1 = new GridBagConstraints();
		gbc_textDiagnosiPaziente_1.gridheight = 2;
		gbc_textDiagnosiPaziente_1.insets = new Insets(0, 0, 5, 0);
		gbc_textDiagnosiPaziente_1.fill = GridBagConstraints.BOTH;
		gbc_textDiagnosiPaziente_1.gridx = 2;
		gbc_textDiagnosiPaziente_1.gridy = 9;
		contentPane.add(textDiagnosiPaziente_1, gbc_textDiagnosiPaziente_1);
		
		JLabel textPresenzaAnestesia = new JLabel("Presenza Anestesia:");
		textPresenzaAnestesia.setHorizontalAlignment(SwingConstants.LEFT);
		textPresenzaAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textPresenzaAnestesia = new GridBagConstraints();
		gbc_textPresenzaAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textPresenzaAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textPresenzaAnestesia.gridx = 0;
		gbc_textPresenzaAnestesia.gridy = 11;
		contentPane.add(textPresenzaAnestesia, gbc_textPresenzaAnestesia);
		
		JRadioButton rdbtnAnestesiaY = new JRadioButton("Si");
		GridBagConstraints gbc_rdbtnAnestesiaY = new GridBagConstraints();
		gbc_rdbtnAnestesiaY.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAnestesiaY.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAnestesiaY.gridx = 2;
		gbc_rdbtnAnestesiaY.gridy = 11;
		contentPane.add(rdbtnAnestesiaY, gbc_rdbtnAnestesiaY);
		
		JLabel textNomePrimoOperatore = new JLabel("Nome Primo Operatore:");
		textNomePrimoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textNomePrimoOperatore = new GridBagConstraints();
		gbc_textNomePrimoOperatore.anchor = GridBagConstraints.WEST;
		gbc_textNomePrimoOperatore.insets = new Insets(0, 0, 5, 5);
		gbc_textNomePrimoOperatore.gridx = 0;
		gbc_textNomePrimoOperatore.gridy = 13;
		contentPane.add(textNomePrimoOperatore, gbc_textNomePrimoOperatore);
		
		textNomeMedico = new JTextField();
		textNomeMedico.setText("aaa");
		textNomeMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeMedico.setFont(new Font("Arial", Font.PLAIN, 14));
		textNomeMedico.setEditable(false);
		textNomeMedico.setColumns(10);
		GridBagConstraints gbc_textNomeMedico = new GridBagConstraints();
		gbc_textNomeMedico.insets = new Insets(0, 0, 5, 0);
		gbc_textNomeMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNomeMedico.gridx = 2;
		gbc_textNomeMedico.gridy = 13;
		contentPane.add(textNomeMedico, gbc_textNomeMedico);
		
		JLabel lblCognomePrimoOperatore = new JLabel("Cognome Primo Operatore:");
		lblCognomePrimoOperatore.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblCognomePrimoOperatore = new GridBagConstraints();
		gbc_lblCognomePrimoOperatore.anchor = GridBagConstraints.WEST;
		gbc_lblCognomePrimoOperatore.insets = new Insets(0, 0, 0, 5);
		gbc_lblCognomePrimoOperatore.gridx = 0;
		gbc_lblCognomePrimoOperatore.gridy = 14;
		contentPane.add(lblCognomePrimoOperatore, gbc_lblCognomePrimoOperatore);
		
		textCognomeMedico = new JTextField();
		textCognomeMedico.setText("aaa");
		textCognomeMedico.setHorizontalAlignment(SwingConstants.LEFT);
		textCognomeMedico.setFont(new Font("Arial", Font.PLAIN, 14));
		textCognomeMedico.setEditable(false);
		textCognomeMedico.setColumns(10);
		GridBagConstraints gbc_textCognomeMedico = new GridBagConstraints();
		gbc_textCognomeMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCognomeMedico.gridx = 2;
		gbc_textCognomeMedico.gridy = 14;
		contentPane.add(textCognomeMedico, gbc_textCognomeMedico);
	}
	
	//regola il numero sale in base al blocco operatorio
	void IntervalloSala(JSpinner spinner, int[] sala_min, int[] sala_max) {
		if(spinner.getValue()=="Giallo") {
			sala_min[0]=1;
			sala_max[0]=6;
		}
		if(spinner.getValue()=="Verde") {
			sala_min[0]=7;
			sala_max[0]=12;
		}
		if(spinner.getValue()=="Blu") {
			sala_min[0]=13;
			sala_max[0]=18;
		}
		if(spinner.getValue()=="Azzurro") {
			sala_min[0]=19;
			sala_max[0]=24;
		}
	}
	
}
