package liste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paziente.ModificaPaginaAnagrafica;
import paziente.VisualizzazionePaginaAnagrafica;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import model.DataService;

public class ListaPagineAnagrafiche extends JFrame {

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
					ListaPagineAnagrafiche frame = new ListaPagineAnagrafiche("m001a");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaPagineAnagrafiche(String codiceDipendente) {
		this.matricolaDipendente = codiceDipendente;
		dataService = new DataService();
		
		int contatoreAnagrafica = dataService.getContatoreCodice("Anagrafica");
		int posY = 2;
		
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaPagineAnagrafiche.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{153, 199, 155, 0};
		gbl_contentPane.rowHeights = new int[]{19, 33, 23, 23, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textListeAnagrafiche = new JLabel("Pagine Anagrafiche registrate:");
		textListeAnagrafiche.setHorizontalAlignment(SwingConstants.CENTER);
		textListeAnagrafiche.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textListeAnagrafiche = new GridBagConstraints();
		gbc_textListeAnagrafiche.gridwidth = 3;
		gbc_textListeAnagrafiche.anchor = GridBagConstraints.NORTHWEST;
		gbc_textListeAnagrafiche.insets = new Insets(0, 0, 5, 0);
		gbc_textListeAnagrafiche.gridx = 0;
		gbc_textListeAnagrafiche.gridy = 0;
		contentPane.add(textListeAnagrafiche, gbc_textListeAnagrafiche);
		
		for(int i = 1; i <= contatoreAnagrafica; i++) {
			
			final String codiceAnagrafica = String.valueOf(i);
			
			if(dataService.esisteAnagrafica(codiceAnagrafica)) {
				
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
				
				JButton bottoneModifica = new JButton("Modifica");
				bottoneModifica.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificaAnagrafica(codiceAnagrafica);
					}
				});
				GridBagConstraints gbc_btnModifica = new GridBagConstraints();
				gbc_btnModifica.anchor = GridBagConstraints.NORTH;
				gbc_btnModifica.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnModifica.insets = new Insets(0, 0, 5, 5);
				gbc_btnModifica.gridx = 1;
				gbc_btnModifica.gridy = posY;
				contentPane.add(bottoneModifica, gbc_btnModifica);
				
				JButton bottoneElimina = new JButton("Elimina");
				bottoneElimina.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						eliminaAnagrafica(codiceAnagrafica);
					}
				});
				GridBagConstraints gbc_btnElimina = new GridBagConstraints();
				gbc_btnElimina.anchor = GridBagConstraints.NORTH;
				gbc_btnElimina.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnElimina.insets = new Insets(0, 0, 5, 0);
				gbc_btnElimina.gridx = 2;
				gbc_btnElimina.gridy = posY;
				contentPane.add(bottoneElimina, gbc_btnElimina);
				
				posY++;
			}
		}
		
		
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnChiudi = new GridBagConstraints();
		gbc_btnChiudi.insets = new Insets(0, 0, 0, 5);
		gbc_btnChiudi.gridx = 0;
		gbc_btnChiudi.gridy = posY+1;
		contentPane.add(btnChiudi, gbc_btnChiudi);
		
		JButton btnAggiungiLista = new JButton("Crea nuova pagina anagrafica");
		btnAggiungiLista.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAggiungiLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aggiungiAnagrafica();
			}
		});
		GridBagConstraints gbc_btnAggiungiLista = new GridBagConstraints();
		gbc_btnAggiungiLista.insets = new Insets(0, 0, 5, 5);
		gbc_btnAggiungiLista.gridx = 1;
		gbc_btnAggiungiLista.gridy = posY+1;
		contentPane.add(btnAggiungiLista, gbc_btnAggiungiLista);	
		
	}
	
	public void refresh() {
		ListaPagineAnagrafiche listaAnagrafiche= new ListaPagineAnagrafiche(matricolaDipendente);
		listaAnagrafiche.setVisible(true);
		dispose();
	}

	protected void eliminaAnagrafica(String codiceAnagrafica) {
		int scelta = JOptionPane.showConfirmDialog(
                null, 
                "Confermi di voler eliminare la pagina anagrafica N. " + codiceAnagrafica + 
                "?\nEliminando la pagina anagrafica eliminerai possibili operazioni e verbali associati ad essa", 
                "Conferma eliminazione", 
                JOptionPane.YES_NO_OPTION 
        );

        if (scelta == JOptionPane.YES_OPTION) {
            dataService.eliminaAnagrafica(codiceAnagrafica);
            JOptionPane.showMessageDialog(null,"Anagrafica N. " + codiceAnagrafica + " eliminata");
            refresh();
        } else {
        	JOptionPane.showMessageDialog(null,"Eliminazione annullata");
        }
	}

	protected void modificaAnagrafica(String codiceAnagrafica) {
		ModificaPaginaAnagrafica modificaAnagrafica= new ModificaPaginaAnagrafica(codiceAnagrafica, "",false);
		modificaAnagrafica.setVisible(true);
		
	}

	protected void visualizzaAnagrafica(String codiceAnagrafica) {
		VisualizzazionePaginaAnagrafica visualizzaAnagrafica= new VisualizzazionePaginaAnagrafica(codiceAnagrafica, matricolaDipendente, true);
		visualizzaAnagrafica.setVisible(true);
		
	}

	protected void aggiungiAnagrafica() {
		ModificaPaginaAnagrafica modificaAnagrafica= new ModificaPaginaAnagrafica("", matricolaDipendente ,true);
		modificaAnagrafica.setVisible(true);		
	}

}
