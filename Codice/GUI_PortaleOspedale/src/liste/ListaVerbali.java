package liste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paziente.ModificaPaginaAnagrafica;
import paziente.ModificaVerbale;
import paziente.VisualizzazionePaginaAnagrafica;
import paziente.VisualizzazioneVerbale;

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

public class ListaVerbali extends JFrame {

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
					ListaVerbali frame = new ListaVerbali("m001a");
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
	public ListaVerbali(String codiceDipendente) {
		this.matricolaDipendente = codiceDipendente;
		dataService = new DataService();
		
		int contatoreVerbale = dataService.getContatoreCodice("Verbale");
		int posY = 2;
		
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaVerbali.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{140, 122, 127, 0};
		gbl_contentPane.rowHeights = new int[]{19, 33, 23, 23, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel textListeVerbali = new JLabel("Verbali registrati:");
		textListeVerbali.setHorizontalAlignment(SwingConstants.CENTER);
		textListeVerbali.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_textListeVerbali = new GridBagConstraints();
		gbc_textListeVerbali.gridwidth = 3;
		gbc_textListeVerbali.anchor = GridBagConstraints.NORTHWEST;
		gbc_textListeVerbali.insets = new Insets(0, 0, 5, 0);
		gbc_textListeVerbali.gridx = 0;
		gbc_textListeVerbali.gridy = 0;
		contentPane.add(textListeVerbali, gbc_textListeVerbali);
		
		for(int i = 1; i <= contatoreVerbale; i++) {
			
			final String codiceVerbale = String.valueOf(i);
			
			if(dataService.esisteVerbale(codiceVerbale)) {
				
				JButton bottoneVerbale = new JButton("Verbale N. " + i);
				bottoneVerbale.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						visualizzaVerbale(codiceVerbale);
					}
				});
				GridBagConstraints gbc_btnListaVerbale_1 = new GridBagConstraints();
				gbc_btnListaVerbale_1.anchor = GridBagConstraints.NORTH;
				gbc_btnListaVerbale_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnListaVerbale_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnListaVerbale_1.gridx = 0;
				gbc_btnListaVerbale_1.gridy = posY;
				contentPane.add(bottoneVerbale, gbc_btnListaVerbale_1);
				
				JButton bottoneModifica = new JButton("Modifica");
				bottoneModifica.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificaVerbale(codiceVerbale);
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
						eliminaVerbale(codiceVerbale);
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
		
		JButton btnAggiungiLista = new JButton("Crea nuovo verbale");
		btnAggiungiLista.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAggiungiLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aggiungiVerbale();
			}
		});
		GridBagConstraints gbc_btnAggiungiLista = new GridBagConstraints();
		gbc_btnAggiungiLista.insets = new Insets(0, 0, 5, 5);
		gbc_btnAggiungiLista.gridx = 1;
		gbc_btnAggiungiLista.gridy = posY+1;
		contentPane.add(btnAggiungiLista, gbc_btnAggiungiLista);	
		
		
		JButton btnRicarica = new JButton("Ricarica verbali");
		btnRicarica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		GridBagConstraints gbc_btnRicarica = new GridBagConstraints();
		gbc_btnRicarica.insets = new Insets(0, 0, 0, 5);
		gbc_btnRicarica.gridx = 2;
		gbc_btnRicarica.gridy = posY+1;
		contentPane.add(btnRicarica, gbc_btnRicarica);
	}
	
	public void refresh() {
		ListaVerbali listaVerbali= new ListaVerbali(matricolaDipendente);
		listaVerbali.setVisible(true);
		dispose();
	}

	protected void eliminaVerbale(String codiceVerbale) {
		int scelta = JOptionPane.showConfirmDialog(
                null, 
                "Confermi di voler eliminare il verbale N. " + codiceVerbale, 
                "Conferma eliminazione", 
                JOptionPane.YES_NO_OPTION 
        );

        if (scelta == JOptionPane.YES_OPTION) {
            dataService.eliminaVerbale(codiceVerbale);
            JOptionPane.showMessageDialog(null,"Verbale N. " + codiceVerbale + " eliminato");
        } else {
        	JOptionPane.showMessageDialog(null,"Eliminazione annullata");
        }
	}

	protected void modificaVerbale(String codiceVerbale) {
		ModificaVerbale modificaVerbale= new ModificaVerbale(codiceVerbale, matricolaDipendente,"");
		modificaVerbale.setVisible(true);
		
	}

	protected void visualizzaVerbale(String codiceVerbale) {
		VisualizzazioneVerbale visualizzaVerbale= new VisualizzazioneVerbale(codiceVerbale, matricolaDipendente);
		visualizzaVerbale.setVisible(true);
		
	}

	protected void aggiungiVerbale() {
		SelezioneOperazione selezione = new SelezioneOperazione(matricolaDipendente);
		selezione.setVisible(true);		
	}

}
