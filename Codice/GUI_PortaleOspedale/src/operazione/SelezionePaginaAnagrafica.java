package operazione;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import model.DataService;
import paginaAnagrafica.VisualizzazionePaginaAnagrafica;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;

public class SelezionePaginaAnagrafica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String matricolaDipendente;
	private DataService dataService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelezionePaginaAnagrafica frame = new SelezionePaginaAnagrafica("m001a");
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelezionePaginaAnagrafica(String codiceDipendente) {
		this.matricolaDipendente = codiceDipendente;
		dataService = new DataService();
		
		int contatoreAnagrafica = dataService.getContatoreCodice("Anagrafica");
		int posY = 2;
		
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelezionePaginaAnagrafica.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		for(int i = 1; i <= contatoreAnagrafica; i++) {
			
			final String codiceAnagrafica = String.valueOf(i);
			
			if(dataService.esisteAnagrafica(codiceAnagrafica) &&
					dataService.getOperazioneAssociata(codiceAnagrafica).equals("")) {
				
				JButton bottoneAnagrafica = new JButton("Pagina Anagrafica N. " + i);
				bottoneAnagrafica.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						visualizzaAnagrafica(codiceAnagrafica);
					}
				});
				GridBagConstraints gbc_btnListaAnagrafica_1 = new GridBagConstraints();
				gbc_btnListaAnagrafica_1.anchor = GridBagConstraints.NORTH;
				gbc_btnListaAnagrafica_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnListaAnagrafica_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnListaAnagrafica_1.gridx = 0;
				gbc_btnListaAnagrafica_1.gridy = posY;
				contentPane.add(bottoneAnagrafica, gbc_btnListaAnagrafica_1);
				
				JButton bottoneSelezione = new JButton("Seleziona");
				bottoneSelezione.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SelezionaAnagrafica(codiceAnagrafica);
					}
				});
				GridBagConstraints gbc_btnSelezione = new GridBagConstraints();
				gbc_btnSelezione.anchor = GridBagConstraints.NORTH;
				gbc_btnSelezione.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnSelezione.insets = new Insets(0, 0, 5, 5);
				gbc_btnSelezione.gridx = 1;
				gbc_btnSelezione.gridy = posY;
				contentPane.add(bottoneSelezione, gbc_btnSelezione);
				
				posY++;
			}
		}
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		JLabel textListeAnagrafiche = new JLabel("Seleziona la pagina anagrafica di cui vuoi registrare l'operazione:");
		textListeAnagrafiche.setHorizontalAlignment(SwingConstants.CENTER);
		textListeAnagrafiche.setFont(new Font("Arial", Font.BOLD, 18));
		
		
		
		JButton btnChiudi = new JButton("Chiudi");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(textListeAnagrafiche))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(227)
							.addComponent(btnChiudi)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textListeAnagrafiche)
					.addGap(70)
					.addComponent(btnChiudi)
					.addGap(214))
		);
		panel.setLayout(gl_panel);
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	

	protected void SelezionaAnagrafica(String codiceAnagrafica) {
		ModificaOperazione modifica = new ModificaOperazione("", matricolaDipendente, codiceAnagrafica);
		modifica.setVisible(true);
		dispose();
	}

	protected void visualizzaAnagrafica(String codiceAnagrafica) {
		VisualizzazionePaginaAnagrafica visualizzaAnagrafica= new VisualizzazionePaginaAnagrafica(codiceAnagrafica, matricolaDipendente);
		visualizzaAnagrafica.setVisible(true);
		
	}

}
