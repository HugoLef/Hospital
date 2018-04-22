package traitement;
import Graphique.*;

import java.sql.SQLException;

import Connexion.*;

public class Hopital {
	
	//Objets
	private static graph fen = new graph();
	private Requete req = new Requete();
	private Connexion co;
	
	public Hopital(){
	}//constructeur

	public void ajouter()  {
		fen.ajout(fen);
		
		//on fait freeze le programme le temps de rentrer les valeurs
		while(fen.ok() == 0) {
			System.out.print("");
		}
		
		//on traite la requete avec la class adaptée
		req.ajouter(fen, fen.col1(), fen.col2(), fen.col3(), fen.col4(), fen.col5(), fen.col6(), fen.liste());
		try {
			co = new Connexion("hopital", "root", "");
			co.ajouterRequete(req.SQL());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
		
	public void rechercher() {
		fen.rechercher(fen);
		
		//on fait freeze le programme le temps de rentrer les valeurs
		while(fen.ok() == 0) {
			System.out.print("");
		}
	
		//on traite la requete avec la class adaptée
		req.rechercher(fen.table(), fen.col1(), fen.col2(), fen.col3(), fen.col4(), fen.col5(), fen.col6(), fen.liste());
	}
		
	
	public void supprimer() {
		fen.supprimer(fen.table());
		
		while (fen.ok() == 0) {
			System.out.print("");
		}
		
		req.supprimer(fen.table(), fen.col1(), fen.col2());
	}
	
	
	public static void main(String[] args) {
		int a = 0;
		Hopital hopital = new Hopital();
		
		//on dessine le menu
		fen.menu();
		
		//tant qu'il n'y a pas eu d'action sur la fenetre
		while(a == 0) {
			switch(fen.choix()) {//selon le bouton appuyer on fait l'action souhaitée
			case 1:
				hopital.ajouter();
				a = 1;
				break;
			case 2:
				hopital.supprimer();
				a = 1;
				break;
			case 3:
				hopital.rechercher();
				a = 1;
				break;
			default :
				break;
			}//fin switch
		}//fin while

	}
}
