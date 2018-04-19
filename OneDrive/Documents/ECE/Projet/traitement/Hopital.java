package traitement;
import Graphique.*;

public class Hopital {
	private static graph fen = new graph();
	private String col1, col2, col3, col4, col5, col6, SQL;
	private Requete req = new Requete();
	public Hopital(){
	}//constructeur

	public void ajouter() {
		fen.ajout(fen.table());
		
		//on fait freeze le programme le temps de rentrer les valeurs
		while(fen.ok() == 0) {
			System.out.print(" ");
		}
		
		//on traite la requete avec la class adaptée
		req.ajouter(fen.table(), fen.col1(), fen.col2(), fen.col3(), fen.col4(), fen.col5(), fen.col6());
	}
		
		
	
	public void supprimer() {
		
	}
	
	public void rechercher() {
		
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
