package liste;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.DataService;
import paziente.ModificaOperazione;
import paziente.VisualizzazioneOperazione;

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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;

public class ListaOperazioni extends JFrame {

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
					ListaOperazioni frame = new ListaOperazioni("m001a");
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
	public ListaOperazioni(String matricolaDipendente) {
		this.matricolaDipendente = matricolaDipendente;
		dataService = new DataService();
		
		
		int contatoreOperazione = dataService.getContatoreCodice("Operazione");
		int posY = 2;
		setTitle("Portale digitale Personale Sanitario dell'ospedale Giovanni XIII");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaOperazioni.class.getResource("/resources/LogoOspedale.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		for(int i = 1; i <= contatoreOperazione; i++) {
			
			final String codiceOperazione = String.valueOf(i);
			
			if(dataService.esisteOperazione(codiceOperazione)) {
				
				JButton bottoneOperazione = new JButton("Operazione N. " + i);
				bottoneOperazione.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						visualizzaOperazione(codiceOperazione);
					}
				});
				GridBagConstraints gbc_btnListaOperazioni_1 = new GridBagConstraints();
				gbc_btnListaOperazioni_1.anchor = GridBagConstraints.NORTH;
				gbc_btnListaOperazioni_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnListaOperazioni_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnListaOperazioni_1.gridx = 0;
				gbc_btnListaOperazioni_1.gridy = posY;
				contentPane.add(bottoneOperazione, gbc_btnListaOperazioni_1);
				
				JButton bottoneModifica = new JButton("Modifica");
				bottoneModifica.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificaOperazione(codiceOperazione);
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
						eliminaOperazione(codiceOperazione);
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
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{130, 64, 145, 0};
		gbl_panel.rowHeights = new int[]{19, 69, 24, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel textListeOperatoria = new JLabel("Lista Operazioni:");
		textListeOperatoria.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_textListeOperatoria = new GridBagConstraints();
		gbc_textListeOperatoria.gridwidth = 2;
		gbc_textListeOperatoria.anchor = GridBagConstraints.NORTHWEST;
		gbc_textListeOperatoria.insets = new Insets(0, 0, 5, 5);
		gbc_textListeOperatoria.gridx = 0;
		gbc_textListeOperatoria.gridy = 1;
		panel.add(textListeOperatoria, gbc_textListeOperatoria);
		GridBagConstraints gbc_btnChiudi = new GridBagConstraints();
		gbc_btnChiudi.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnChiudi.insets = new Insets(0, 0, 0, 5);
		gbc_btnChiudi.gridx = 0;
		gbc_btnChiudi.gridy = 2;
		panel.add(btnChiudi, gbc_btnChiudi);
		
		JButton btnAggiungiLista = new JButton("Crea nuova operazione");
		btnAggiungiLista.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_btnAggiungiLista = new GridBagConstraints();
		gbc_btnAggiungiLista.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAggiungiLista.gridx = 2;
		gbc_btnAggiungiLista.gridy = 2;
		panel.add(btnAggiungiLista, gbc_btnAggiungiLista);
		btnAggiungiLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aggiungiOperazione();
			}
		});
		
	}
	
	protected void eliminaOperazione(String codiceOperazione) {
		int scelta = JOptionPane.showConfirmDialog(
                null, 
                "Confermi di voler eliminare l'operazione N. " + codiceOperazione + 
                "?\nEliminando l'operazione eliminerai possibili verbali associati ad essa", 
                "Conferma eliminazione", 
                JOptionPane.YES_NO_OPTION 
        );

        if (scelta == JOptionPane.YES_OPTION) {
            dataService.eliminaOperazione(codiceOperazione);
            JOptionPane.showMessageDialog(null,"Operazione N. " + codiceOperazione + " eliminata");
            refresh();
        } else {
        	JOptionPane.showMessageDialog(null,"Eliminazione annullata");
        }
	}
	
	public void refresh() {
		ListaOperazioni listaOperazioni= new ListaOperazioni(matricolaDipendente);
		listaOperazioni.setVisible(true);
		dispose();
	}

	protected void modificaOperazione(String codiceOperazione) {
		ModificaOperazione modificaOperazione= new ModificaOperazione(codiceOperazione,matricolaDipendente, "");
		modificaOperazione.setVisible(true);
		
	}

	protected void visualizzaOperazione(String codiceOperazione) {
		VisualizzazioneOperazione visualizzaOperazione= new VisualizzazioneOperazione(codiceOperazione, matricolaDipendente);
		visualizzaOperazione.setVisible(true);
		
	}

	protected void aggiungiOperazione() {
		SelezionePaginaAnagrafica selezione = new SelezionePaginaAnagrafica(matricolaDipendente);
		selezione.setUndecorated(true);
		selezione.setVisible(true);
		selezione.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
