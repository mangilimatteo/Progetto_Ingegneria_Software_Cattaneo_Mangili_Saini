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

public class VerbalePaziente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spinnerOradiIngresso_1;

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
		setBounds(100, 100, 629, 843);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{148, 35, 408, 0};
		gbl_contentPane.rowHeights = new int[]{58, 35, 19, 23, 29, 19, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 0, 0, 0, 0, 0, 0, 0, 0, 62, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		JLabel textOradiIngresso = new JLabel("Ora di ingresso del blocco operatorio (opzionale)");
		textOradiIngresso.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiIngresso = new GridBagConstraints();
		gbc_textOradiIngresso.anchor = GridBagConstraints.WEST;
		gbc_textOradiIngresso.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiIngresso.gridx = 0;
		gbc_textOradiIngresso.gridy = 2;
		contentPane.add(textOradiIngresso, gbc_textOradiIngresso);
		
		JSpinner spinnerOradiIngresso = new JSpinner();
		spinnerOradiIngresso.setModel(new SpinnerDateModel(new Date(1707260400000L), null, null, Calendar.YEAR));
		spinnerOradiIngresso.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOradiIngresso.setEnabled(false);
		GridBagConstraints gbc_spinnerOradiIngresso = new GridBagConstraints();
		gbc_spinnerOradiIngresso.anchor = GridBagConstraints.WEST;
		gbc_spinnerOradiIngresso.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerOradiIngresso.gridx = 2;
		gbc_spinnerOradiIngresso.gridy = 2;
		contentPane.add(spinnerOradiIngresso, gbc_spinnerOradiIngresso);
		
		JLabel textOradiEntrata = new JLabel("Ora di entrata in sala operatoria (opzionale)");
		textOradiEntrata.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiEntrata = new GridBagConstraints();
		gbc_textOradiEntrata.anchor = GridBagConstraints.WEST;
		gbc_textOradiEntrata.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiEntrata.gridx = 0;
		gbc_textOradiEntrata.gridy = 3;
		contentPane.add(textOradiEntrata, gbc_textOradiEntrata);
		
		spinnerOradiIngresso_1 = new JSpinner();
		spinnerOradiIngresso_1.setModel(new SpinnerNumberModel(Integer.valueOf(7), null, null, Integer.valueOf(4)));
		spinnerOradiIngresso_1.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOradiIngresso_1.setEnabled(false);
		GridBagConstraints gbc_spinnerOradiIngresso_1 = new GridBagConstraints();
		gbc_spinnerOradiIngresso_1.anchor = GridBagConstraints.WEST;
		gbc_spinnerOradiIngresso_1.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerOradiIngresso_1.gridx = 2;
		gbc_spinnerOradiIngresso_1.gridy = 3;
		contentPane.add(spinnerOradiIngresso_1, gbc_spinnerOradiIngresso_1);
		
		JLabel OrariodelPosizionamento = new JLabel("Orario del posizionamento del paziente (opzionale)");
		OrariodelPosizionamento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_OrariodelPosizionamento = new GridBagConstraints();
		gbc_OrariodelPosizionamento.insets = new Insets(0, 0, 5, 5);
		gbc_OrariodelPosizionamento.gridx = 0;
		gbc_OrariodelPosizionamento.gridy = 4;
		contentPane.add(OrariodelPosizionamento, gbc_OrariodelPosizionamento);
		
		JSpinner spinnerOradiIngresso_2 = new JSpinner();
		spinnerOradiIngresso_2.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOradiIngresso_2.setEnabled(false);
		GridBagConstraints gbc_spinnerOradiIngresso_2 = new GridBagConstraints();
		gbc_spinnerOradiIngresso_2.anchor = GridBagConstraints.WEST;
		gbc_spinnerOradiIngresso_2.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerOradiIngresso_2.gridx = 2;
		gbc_spinnerOradiIngresso_2.gridy = 4;
		contentPane.add(spinnerOradiIngresso_2, gbc_spinnerOradiIngresso_2);
		
		JLabel textOradiInizioAnestesia = new JLabel("Ora inizio anestesia (opzionale)");
		textOradiInizioAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiInizioAnestesia = new GridBagConstraints();
		gbc_textOradiInizioAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textOradiInizioAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiInizioAnestesia.gridx = 0;
		gbc_textOradiInizioAnestesia.gridy = 5;
		contentPane.add(textOradiInizioAnestesia, gbc_textOradiInizioAnestesia);
		
		JSpinner spinnerOradiIngresso_3 = new JSpinner();
		spinnerOradiIngresso_3.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOradiIngresso_3.setEnabled(false);
		GridBagConstraints gbc_spinnerOradiIngresso_3 = new GridBagConstraints();
		gbc_spinnerOradiIngresso_3.anchor = GridBagConstraints.WEST;
		gbc_spinnerOradiIngresso_3.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerOradiIngresso_3.gridx = 2;
		gbc_spinnerOradiIngresso_3.gridy = 5;
		contentPane.add(spinnerOradiIngresso_3, gbc_spinnerOradiIngresso_3);
		
		JLabel textOradiFineAnestesia = new JLabel("Ora fine anestesia (opzionale)");
		textOradiFineAnestesia.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiFineAnestesia = new GridBagConstraints();
		gbc_textOradiFineAnestesia.anchor = GridBagConstraints.WEST;
		gbc_textOradiFineAnestesia.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiFineAnestesia.gridx = 0;
		gbc_textOradiFineAnestesia.gridy = 6;
		contentPane.add(textOradiFineAnestesia, gbc_textOradiFineAnestesia);
		
		JSpinner spinnerOradiIngresso_4 = new JSpinner();
		spinnerOradiIngresso_4.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOradiIngresso_4.setEnabled(false);
		GridBagConstraints gbc_spinnerOradiIngresso_4 = new GridBagConstraints();
		gbc_spinnerOradiIngresso_4.anchor = GridBagConstraints.WEST;
		gbc_spinnerOradiIngresso_4.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerOradiIngresso_4.gridx = 2;
		gbc_spinnerOradiIngresso_4.gridy = 6;
		contentPane.add(spinnerOradiIngresso_4, gbc_spinnerOradiIngresso_4);
		
		JLabel textOradiIntervento = new JLabel("Ora inizio intervento (obbligatorio)");
		textOradiIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiIntervento = new GridBagConstraints();
		gbc_textOradiIntervento.anchor = GridBagConstraints.WEST;
		gbc_textOradiIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiIntervento.gridx = 0;
		gbc_textOradiIntervento.gridy = 7;
		contentPane.add(textOradiIntervento, gbc_textOradiIntervento);
		
		JSpinner spinnerOradiIngresso_5 = new JSpinner();
		spinnerOradiIngresso_5.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOradiIngresso_5.setEnabled(false);
		GridBagConstraints gbc_spinnerOradiIngresso_5 = new GridBagConstraints();
		gbc_spinnerOradiIngresso_5.anchor = GridBagConstraints.WEST;
		gbc_spinnerOradiIngresso_5.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerOradiIngresso_5.gridx = 2;
		gbc_spinnerOradiIngresso_5.gridy = 7;
		contentPane.add(spinnerOradiIngresso_5, gbc_spinnerOradiIngresso_5);
		
		JLabel textOradiFineIntervento = new JLabel("Ora fine intervento (obbligatorio)");
		textOradiFineIntervento.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiFineIntervento = new GridBagConstraints();
		gbc_textOradiFineIntervento.anchor = GridBagConstraints.WEST;
		gbc_textOradiFineIntervento.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiFineIntervento.gridx = 0;
		gbc_textOradiFineIntervento.gridy = 8;
		contentPane.add(textOradiFineIntervento, gbc_textOradiFineIntervento);
		
		JSpinner spinnerOradiIngresso_6 = new JSpinner();
		spinnerOradiIngresso_6.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOradiIngresso_6.setEnabled(false);
		GridBagConstraints gbc_spinnerOradiIngresso_6 = new GridBagConstraints();
		gbc_spinnerOradiIngresso_6.anchor = GridBagConstraints.WEST;
		gbc_spinnerOradiIngresso_6.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerOradiIngresso_6.gridx = 2;
		gbc_spinnerOradiIngresso_6.gridy = 8;
		contentPane.add(spinnerOradiIngresso_6, gbc_spinnerOradiIngresso_6);
		
		JLabel textOradiRisveglio = new JLabel("Ora risveglio (opzionale)");
		textOradiRisveglio.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiRisveglio = new GridBagConstraints();
		gbc_textOradiRisveglio.anchor = GridBagConstraints.WEST;
		gbc_textOradiRisveglio.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiRisveglio.gridx = 0;
		gbc_textOradiRisveglio.gridy = 9;
		contentPane.add(textOradiRisveglio, gbc_textOradiRisveglio);
		
		JSpinner spinnerOradiIngresso_7 = new JSpinner();
		spinnerOradiIngresso_7.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOradiIngresso_7.setEnabled(false);
		GridBagConstraints gbc_spinnerOradiIngresso_7 = new GridBagConstraints();
		gbc_spinnerOradiIngresso_7.anchor = GridBagConstraints.WEST;
		gbc_spinnerOradiIngresso_7.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerOradiIngresso_7.gridx = 2;
		gbc_spinnerOradiIngresso_7.gridy = 9;
		contentPane.add(spinnerOradiIngresso_7, gbc_spinnerOradiIngresso_7);
		
		JLabel textOradiUscitaSala = new JLabel("Ora uscita sala operatoria (opzionale)");
		textOradiUscitaSala.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOradiUscitaSala = new GridBagConstraints();
		gbc_textOradiUscitaSala.anchor = GridBagConstraints.WEST;
		gbc_textOradiUscitaSala.insets = new Insets(0, 0, 5, 5);
		gbc_textOradiUscitaSala.gridx = 0;
		gbc_textOradiUscitaSala.gridy = 10;
		contentPane.add(textOradiUscitaSala, gbc_textOradiUscitaSala);
		
		JSpinner spinnerOradiIngresso_8 = new JSpinner();
		spinnerOradiIngresso_8.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOradiIngresso_8.setEnabled(false);
		GridBagConstraints gbc_spinnerOradiIngresso_8 = new GridBagConstraints();
		gbc_spinnerOradiIngresso_8.anchor = GridBagConstraints.WEST;
		gbc_spinnerOradiIngresso_8.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerOradiIngresso_8.gridx = 2;
		gbc_spinnerOradiIngresso_8.gridy = 10;
		contentPane.add(spinnerOradiIngresso_8, gbc_spinnerOradiIngresso_8);
		
		JLabel textOraduUscita = new JLabel("Ora uscita blocco operatorio (opzionale)");
		textOraduUscita.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textOraduUscita = new GridBagConstraints();
		gbc_textOraduUscita.anchor = GridBagConstraints.WEST;
		gbc_textOraduUscita.insets = new Insets(0, 0, 5, 5);
		gbc_textOraduUscita.gridx = 0;
		gbc_textOraduUscita.gridy = 11;
		contentPane.add(textOraduUscita, gbc_textOraduUscita);
		
		JSpinner spinnerOradiIngresso_9 = new JSpinner();
		spinnerOradiIngresso_9.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerOradiIngresso_9.setEnabled(false);
		GridBagConstraints gbc_spinnerOradiIngresso_9 = new GridBagConstraints();
		gbc_spinnerOradiIngresso_9.anchor = GridBagConstraints.WEST;
		gbc_spinnerOradiIngresso_9.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerOradiIngresso_9.gridx = 2;
		gbc_spinnerOradiIngresso_9.gridy = 11;
		contentPane.add(spinnerOradiIngresso_9, gbc_spinnerOradiIngresso_9);

	}

}
