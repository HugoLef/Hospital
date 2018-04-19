package traitement;


public class Requete {
	private String SQL;
	
	public Requete() {
		SQL = " ";
	}
	
	public void ajouter(String fen, String col1, String col2, String col3, String col4, String col5, String col6) {
		switch(fen) {
		case "Chambre" :
			System.out.println();
			SQL = "INSERT INTO chambre (code_service, no_chambre, surveillant, nb_lits) VALUES ('"+col1+"',"+col2+","+col3+","+col4+")";
			System.out.println(SQL);
			break;
		case "Docteur" :
			System.out.println();
			SQL = "INSERT INTO docteur (numero, specialite) VALUES ("+col1+",'"+col2+"')";
			System.out.println(SQL);
			break;
		case "Employe" :
			System.out.println();
			SQL = "INSERT INTO employe (numero, nom, prenom, adresse, tel) VALUES ("+col1+",'"+col2+"','"+col3+"','"+col4+"','"+col5+"')";
			System.out.println(SQL);
			break;
		case "Hospitalisation" :
			System.out.println();
			SQL = "INSERT INTO hospitalisation (no_malade, code_service, no_chambre, lit) VALUES ("+col1+",'"+col2+"',"+col3+","+col4+")";
			System.out.println(SQL);
			break;
		case "Infirmier" :
			System.out.println();
			SQL = "INSERT INTO infirmier (numero, code_service, rotation, salaire) VALUES ("+col1+",'"+col2+"','"+col3+"',"+col4+")";
			System.out.println(SQL);
			break;
		case "Malade" :
			System.out.println();
			SQL = "INSERT INTO malade (numero, nom, prenom, adresse, tel, mutuelle) VALUES ("+col1+",'"+col2+"','"+col3+"','"+col4+"','"+col5+"','"+col6+"')";
			System.out.println(SQL);
			break;
		case "Service" :
			System.out.println();
			SQL = "INSERT INTO Service (code, nom, batiment, directeur) VALUES ('"+col1+"','"+col2+"','"+col3+"',"+col4+")";
			System.out.println(SQL);
			break;
		case "Soigne" :
			System.out.println();
			SQL = "INSERT INTO soigne (no_docteur, no_malade) VALUES ("+col1+","+col2+")";
			System.out.println(SQL);
			break;
		}
	}
}
