package Graphique;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class graph extends JFrame implements ActionListener {
	int menu;
	private JPanel pan;
	private JButton aj, supp, rech;
	private JButton soummettre;
	private JTextField col1, col2, col3, col4, col5, col6;
	private JLabel tcol1, tcol2, tcol3, tcol4, tcol5, tcol6;
	private JLabel tabl;
	private String chx, colo1, colo2, colo3, colo4, colo5, colo6, tliste;
	private Choice liste;
	int ok = 0;
	
	public graph() {//constructeur
		
		//parametre de la fenetre
		setVisible(true);
		setTitle("Hopital");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//on ajoute le pan
		pan = new JPanel();
		getContentPane().add(pan);
	}
	
	public void menu() {
		
		//instanciation des boutons du menu
		aj = new JButton("ajouter");
		supp = new JButton("supprimer");
		rech = new JButton("rechercher");
		liste = new Choice();
		tabl = new JLabel("Dans quelle table chercher :");
		
		//on ajoute les choix dans la liste
		liste.addItem("Chambre");
		liste.addItem("Docteur");
		liste.addItem("Employe");
		liste.addItem("Hospitalisation");
		liste.addItem("Infirmier");
		liste.addItem("Malade");
		liste.addItem("Service");
		liste.addItem("Soigne");
		
		//on place les boutons/liste
		pan.setLayout(null);
		aj.setBounds(200, 50, 100, 50);
		supp.setBounds(200, 150, 100, 50);
		rech.setBounds(200, 250, 100, 50);
		tabl.setBounds(170, 310, 200, 30);
		liste.setBounds(150, 340, 200, 50);
		
		
		//on les rends visible dans le pan
		pan.add(aj);
		pan.add(supp);
		pan.add(rech);
		pan.add(tabl);
		pan.add(liste);
		
		//on ajoute 
		aj.addActionListener(this);
		supp.addActionListener(this);
		rech.addActionListener(this);
	}
	
//************************************************Fin Menu*************************************************************
//******************************************Debut Ajout/supp/rech******************************************************
	
	public void ajout(graph fen) {
		
		//on efface le menu
		pan.removeAll();
		pan.repaint();
		
		pan.setLayout(null);
		soummettre = new JButton("ajouter");
		
		fen.dessin(fen.table(), soummettre);
		
		//ajout de l'action listener sur le bouton
		soummettre.addActionListener(this);
		
		pan.repaint();
		
	}

	public void rechercher(graph fen) {
		
		//on efface le menu
		pan.removeAll();
		pan.repaint();
			
		pan.setLayout(null);
		soummettre = new JButton("rechercher");
		
		//on dessine selon la table choisie
		fen.dessin(fen.table(), soummettre);
		
		//action listener sur le bouton
		soummettre.addActionListener(this);
		
		pan.repaint();
	}
	
	public void supprimer(String tableau) {
		//on efface tout
		pan.removeAll();
		pan.repaint();
		
		pan.setLayout(null);
		soummettre = new JButton("Supprimer");
		
		//on ne dessine pas pareil car on ne supprimera qu'avec les clef primaires
		switch(tableau) {
		case "Chambre" :
			col1 = new JTextField();
			col2 = new JTextField();
			tcol1 = new JLabel("Code Service:");
			tcol2 = new JLabel("n° chambre :");
			
			tcol1.setBounds(20, 10, 80, 20);
			tcol2.setBounds(20, 50, 80, 20);
			col1.setBounds(100, 10, 300, 20);
			col2.setBounds(100, 50, 300, 20);
			
			pan.add(col1);
			pan.add(col2);
			pan.add(tcol1);
			pan.add(tcol2);
			
			break;
		case "Docteur" :
			col1 = new JTextField();
			tcol1 = new JLabel("numero:");
			
			tcol1.setBounds(20, 10, 50, 20);
			col1.setBounds(100, 10, 300, 20);
			
			pan.add(col1);
			pan.add(tcol1);
			break;
		case "Employe" :
			col1 = new JTextField();
			tcol1 = new JLabel("numero:");
			
			tcol1.setBounds(20, 10, 50, 20);
			col1.setBounds(100, 10, 300, 20);
			
			pan.add(col1);
			pan.add(tcol1);
			break;
		case "Hospitalisation" :
			col1 = new JTextField();
			tcol1 = new JLabel("N° Malade :");
			
			tcol1.setBounds(20, 10, 50, 20);
			col1.setBounds(100, 10, 300, 20);
			
			pan.add(col1);
			pan.add(tcol1);
			break;
		case "Infirmier" :
			col1 = new JTextField();
			tcol1 = new JLabel("numero:");
			
			tcol1.setBounds(20, 10, 50, 20);
			col1.setBounds(100, 10, 300, 20);
			
			pan.add(col1);
			pan.add(tcol1);
			break;
		case "Malade" :
			col1 = new JTextField();
			tcol1 = new JLabel("numero:");
			
			tcol1.setBounds(20, 10, 50, 20);
			col1.setBounds(100, 10, 300, 20);
			
			pan.add(col1);
			pan.add(tcol1);
			break;
		case "Service" :
			col1 = new JTextField();
			tcol1 = new JLabel("code:");
			
			tcol1.setBounds(20, 10, 50, 20);
			col1.setBounds(100, 10, 300, 20);
			
			pan.add(col1);
			pan.add(tcol1);
			break;
		case "Soigne" :
			col1 = new JTextField();
			col2 = new JTextField();
			tcol1 = new JLabel("N° Docteur:");
			tcol2 = new JLabel("N° Malade :");
			
			tcol1.setBounds(20, 10, 50, 20);
			tcol1.setBounds(20, 10, 80, 20);
			col1.setBounds(100, 10, 300, 20);
			col2.setBounds(100, 50, 300, 20);
			
			pan.add(col1);
			pan.add(col2);
			pan.add(tcol1);
			pan.add(tcol2);
			break;
		}
		pan.add(soummettre);
		pan.repaint();
	}
	
	public void dessin(String tableau, JButton bouton) {
		switch(tableau){
		case "Chambre":
			//instanciation des textes
			col1 = new JTextField();
			col2 = new JTextField();
			col3 = new JTextField();
			col4 = new JTextField();
			col5 = new JTextField();
			col6 = new JTextField();
			tcol1 = new JLabel("Code Service:");
			tcol2 = new JLabel("n° chambre :");
			tcol3 = new JLabel("surveillant :");
			tcol4 = new JLabel("nb lits :");
			
			//on place les bouton/textes
			tcol1.setBounds(20, 10, 50, 20);
			tcol1.setBounds(20, 10, 80, 20);
			tcol2.setBounds(20, 50, 80, 20);
			tcol3.setBounds(20, 90, 80, 20);
			tcol4.setBounds(20, 130, 80, 20);
			col1.setBounds(100, 10, 300, 20);
			col2.setBounds(100, 50, 300, 20);
			col3.setBounds(100, 90, 300, 20);
			col4.setBounds(100, 130, 300, 20);
			bouton.setBounds(150, 160, 120, 30);
			
			
			//on affiche les bouton/textes
			pan.add(col1);
			pan.add(col2);
			pan.add(col3);
			pan.add(col4);
			pan.add(tcol1);
			pan.add(tcol2);
			pan.add(tcol3);
			pan.add(tcol4);
			pan.add(bouton);
			break;
			
		case "Docteur":
			//instanciation des textes
			col1 = new JTextField();
			liste = new Choice();
			col2 = new JTextField(" ");
			col3 = new JTextField(" ");
			col4 = new JTextField(" ");
			col5 = new JTextField(" ");
			col6 = new JTextField(" ");
			tcol1 = new JLabel("n° :");
			tcol2 = new JLabel("Spécialité :");
			
			liste.addItem("Anesthesiste");
			liste.addItem("Cardiologue");
			liste.addItem("Generaliste");
			liste.addItem("Orthopediste");
			liste.addItem("Chirurgien");
			
			//on place les bouton/textes
			pan.setLayout(null);
			tcol1.setBounds(20, 10, 80, 20);
			tcol2.setBounds(20, 50, 80, 20);
			col1.setBounds(100, 10, 300, 20);
			liste.setBounds(100, 50, 300, 20);
			bouton.setBounds(150, 80, 120, 30);
			
			
			//on affiche les bouton/textes
			pan.add(col1);
			pan.add(liste);
			pan.add(tcol1);
			pan.add(tcol2);
			pan.add(bouton);
			break;
			
		case "Employe":
			//instanciation des textes
			col1 = new JTextField();
			col2 = new JTextField();
			col3 = new JTextField();
			col4 = new JTextField();
			col5 = new JTextField();
			col6 = new JTextField(" ");
			tcol1 = new JLabel("N°:");
			tcol2 = new JLabel("Nom :");
			tcol3 = new JLabel("Prenom :");
			tcol4 = new JLabel("Adresse :");
			tcol5 = new JLabel("Tel");
			
			//on place les bouton/textes
			tcol1.setBounds(20, 10, 50, 20);
			tcol1.setBounds(20, 10, 80, 20);
			tcol2.setBounds(20, 50, 80, 20);
			tcol3.setBounds(20, 90, 80, 20);
			tcol4.setBounds(20, 130, 80, 20);
			tcol5.setBounds(20, 170, 80, 20);
			col1.setBounds(100, 10, 300, 20);
			col2.setBounds(100, 50, 300, 20);
			col3.setBounds(100, 90, 300, 20);
			col4.setBounds(100, 130, 300, 20);
			col5.setBounds(100, 170, 300, 20);
			bouton.setBounds(150, 200, 120, 30);
			
			
			//on affiche les bouton/textes
			pan.add(col1);
			pan.add(col2);
			pan.add(col3);
			pan.add(col4);
			pan.add(col5);
			pan.add(tcol1);
			pan.add(tcol2);
			pan.add(tcol3);
			pan.add(tcol4);
			pan.add(tcol5);
			pan.add(bouton);
			break;
			
		case "Hospitalisation":
			//instanciation des textes
			col1 = new JTextField();
			col2 = new JTextField();
			col3 = new JTextField();
			col4 = new JTextField();
			col5 = new JTextField(" ");
			col6 = new JTextField(" ");
			tcol1 = new JLabel("N° malade:");
			tcol2 = new JLabel("Code Service :");
			tcol3 = new JLabel("n° chambre :");
			tcol4 = new JLabel("lit :");
			
			//on place les bouton/textes
			tcol1.setBounds(20, 10, 50, 20);
			tcol1.setBounds(20, 10, 80, 20);
			tcol2.setBounds(20, 50, 80, 20);
			tcol3.setBounds(20, 90, 80, 20);
			tcol4.setBounds(20, 130, 80, 20);
			col1.setBounds(100, 10, 300, 20);
			col2.setBounds(100, 50, 300, 20);
			col3.setBounds(100, 90, 300, 20);
			col4.setBounds(100, 130, 300, 20);
			bouton.setBounds(150, 160, 120, 30);
			
			
			//on affiche les bouton/textes
			pan.add(col1);
			pan.add(col2);
			pan.add(col3);
			pan.add(col4);
			pan.add(tcol1);
			pan.add(tcol2);
			pan.add(tcol3);
			pan.add(tcol4);
			pan.add(bouton);
			break;
			
		case "Infirmier":
			//instanciation des textes
			col1 = new JTextField();
			col2 = new JTextField();
			liste = new Choice();
			col4 = new JTextField();
			col3 = new JTextField(" ");
			col5 = new JTextField(" ");
			col6 = new JTextField(" ");
			tcol1 = new JLabel("N°:");
			tcol2 = new JLabel("Code Service :");
			tcol3 = new JLabel("Rotation :");
			tcol4 = new JLabel("Salaire :");
			
			liste.addItem("JOURS");
			liste.addItem("NUIT");
			
			//on place les bouton/textes
			tcol1.setBounds(20, 10, 50, 20);
			tcol1.setBounds(20, 10, 80, 20);
			tcol2.setBounds(20, 50, 80, 20);
			tcol3.setBounds(20, 90, 80, 20);
			tcol4.setBounds(20, 130, 80, 20);
			col1.setBounds(100, 10, 300, 20);
			col2.setBounds(100, 50, 300, 20);
			liste.setBounds(100, 90, 300, 20);
			col4.setBounds(100, 130, 300, 20);
			bouton.setBounds(150, 160, 120, 30);
			
			
			//on affiche les bouton/textes
			pan.add(col1);
			pan.add(col2);
			pan.add(liste);
			pan.add(col4);
			pan.add(tcol1);
			pan.add(tcol2);
			pan.add(tcol3);
			pan.add(tcol4);
			pan.add(bouton);
			break;
			
		case "Malade":
			//instanciation des textes
			col1 = new JTextField();
			col2 = new JTextField();
			col3 = new JTextField();
			col4 = new JTextField();
			col5 = new JTextField();
			col6 = new JTextField();
			tcol1 = new JLabel("N°:");
			tcol2 = new JLabel("Nom :");
			tcol3 = new JLabel("Prenom :");
			tcol4 = new JLabel("Adresse :");
			tcol5 = new JLabel("Tel");
			tcol6 = new JLabel("Mutuelle");
			
			//on place les bouton/textes
			tcol1.setBounds(20, 10, 50, 20);
			tcol1.setBounds(20, 10, 80, 20);
			tcol2.setBounds(20, 50, 80, 20);
			tcol3.setBounds(20, 90, 80, 20);
			tcol4.setBounds(20, 130, 80, 20);
			tcol5.setBounds(20, 170, 80, 20);
			tcol6.setBounds(20, 210, 80, 20);
			col1.setBounds(100, 10, 300, 20);
			col2.setBounds(100, 50, 300, 20);
			col3.setBounds(100, 90, 300, 20);
			col4.setBounds(100, 130, 300, 20);
			col5.setBounds(100, 170, 300, 20);
			col6.setBounds(100, 210, 300, 20);
			bouton.setBounds(150, 240, 120, 30);
			
			
			//on affiche les bouton/textes
			pan.add(col1);
			pan.add(col2);
			pan.add(col3);
			pan.add(col4);
			pan.add(col5);
			pan.add(col6);
			pan.add(tcol1);
			pan.add(tcol2);
			pan.add(tcol3);
			pan.add(tcol4);
			pan.add(tcol5);
			pan.add(tcol6);
			pan.add(bouton);
			break;
			
		case "Service":
			//instanciation des textes
			col1 = new JTextField();
			col2 = new JTextField();
			col3 = new JTextField();
			col4 = new JTextField();
			col5 = new JTextField(" ");
			col6 = new JTextField(" ");
			tcol1 = new JLabel("Code :");
			tcol2 = new JLabel("Nom :");
			tcol3 = new JLabel("Batiment :");
			tcol4 = new JLabel("Directeur :");
			
			//on place les bouton/textes
			tcol1.setBounds(20, 10, 50, 20);
			tcol1.setBounds(20, 10, 80, 20);
			tcol2.setBounds(20, 50, 80, 20);
			tcol3.setBounds(20, 90, 80, 20);
			tcol4.setBounds(20, 130, 80, 20);
			col1.setBounds(100, 10, 300, 20);
			col2.setBounds(100, 50, 300, 20);
			col3.setBounds(100, 90, 300, 20);
			col4.setBounds(100, 130, 300, 20);
			bouton.setBounds(150, 160, 120, 30);
			
			
			//on affiche les bouton/textes
			pan.add(col1);
			pan.add(col2);
			pan.add(col3);
			pan.add(col4);
			pan.add(tcol1);
			pan.add(tcol2);
			pan.add(tcol3);
			pan.add(tcol4);
			pan.add(bouton);
			break;
			
		case "Soigne":
			//instanciation des textes
			col1 = new JTextField();
			col2 = new JTextField();
			col3 = new JTextField(" ");
			col4 = new JTextField(" ");
			col5 = new JTextField(" ");
			col6 = new JTextField(" ");
			tcol1 = new JLabel("N° Docteur :");
			tcol2 = new JLabel("N° Malade :");
			
			//on place les bouton/textes
			pan.setLayout(null);
			tcol1.setBounds(20, 10, 80, 20);
			tcol2.setBounds(20, 50, 80, 20);
			col1.setBounds(100, 10, 300, 20);
			col2.setBounds(100, 50, 300, 20);
			bouton.setBounds(150, 80, 120, 30);
			
			
			//on affiche les bouton/textes
			pan.add(col1);
			pan.add(col2);
			pan.add(tcol1);
			pan.add(tcol2);
			pan.add(bouton);
			break;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		
		//listener du menu
		if (source == this.aj) {
			this.menu = 1;
			this.chx = liste.getSelectedItem();
		}
		if (source == this.supp) {
			this.menu = 2;
			this.chx = liste.getSelectedItem();
		}
		if (source == this.rech) {
			this.menu = 3;
			this.chx = liste.getSelectedItem();
		}
		
		//listener du programme 
		if(source == soummettre) {
			
			//on renvoie les valeurs texte
			this.colo1 = col1.getText();
			this.colo2 = col2.getText();
			this.colo3 = col3.getText();
			this.colo4 = col4.getText();
			this.colo5 = col5.getText();
			this.colo6 = col6.getText();
			this.tliste = liste.getSelectedItem();
			this.ok = 1;
		}
	}//fin listener
	
	public void verifie(boolean verif) {
		JLabel txt;
		if(verif == true) txt = new JLabel("operation réussie");
		else txt = new JLabel("Erreur");
		
		pan.setLayout(null);
		txt.setBounds(160, 190, 100, 30);
		pan.add(txt);
		pan.repaint();
	}
	
// ******************************************Methodes de renvoie de valeur************************************************************
	public int choix() {
		return menu;
	}
	
	public String table() {
		return chx;
	}
	
	public String col1() {
		return colo1;
	}
	
	public String col2() {
		return colo2;
	}
	
	public String col3() {
		return colo3;
	}
	
	public String col4() {
		return colo4;
	}
	
	public String col5() {
		return colo5;
	}
	
	public String col6() {
		return colo6;
	}
	
	public int ok() {
		return ok;
	}
	
	public String liste() {
		return tliste;
	}
}
