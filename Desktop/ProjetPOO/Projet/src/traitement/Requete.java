package traitement;
import Graphique.graph;

public class Requete {
	private String SQL;
	
	public Requete() {
		SQL = " ";
	}
	
	public void ajouter(graph fen, String col1, String col2, String col3, String col4, String col5, String col6, String liste) {
		switch(fen.table()) {
		case "Chambre" :
			
			//on vérifie que tout les champs sont remplies
			if(col1.length() == 0 ||  col2.length() == 0 ||  col3.length() == 0 ||  col4.length() == 0) {
				fen.verifie(false);
				System.out.print(" : un des champs n'est pas remplie");
			}
			else {
				fen.verifie(true);
				//on met la requete dans une variable
				SQL = "INSERT INTO chambre (code_service, no_chambre, surveillant, nb_lits) VALUES ('"+col1+"',"+col2+","+col3+","+col4+")";
			}
			
			break;
		case "Docteur" :
			SQL = "INSERT INTO docteur (numero, specialite) VALUES ("+col1+",'"+liste+"')";;
			break;
		case "Employe" :
			SQL = "INSERT INTO employe (numero, nom, prenom, adresse, tel) VALUES ("+col1+",'"+col2+"','"+col3+"','"+col4+"','"+col5+"')";
			break;
		case "Hospitalisation" :
			SQL = "INSERT INTO hospitalisation (no_malade, code_service, no_chambre, lit) VALUES ("+col1+",'"+col2+"',"+col3+","+col4+")";
			break;
		case "Infirmier" :
			SQL = "INSERT INTO infirmier (numero, code_service, rotation, salaire) VALUES ("+col1+",'"+col2+"','"+liste+"',"+col4+")";
			break;
		case "Malade" :
			SQL = "INSERT INTO malade (numero, nom, prenom, adresse, tel, mutuelle) VALUES ("+col1+",'"+col2+"','"+col3+"','"+col4+"','"+col5+"','"+col6+"')";
			break;
		case "Service" :
			SQL = "INSERT INTO Service (code, nom, batiment, directeur) VALUES ('"+col1+"','"+col2+"','"+col3+"',"+col4+")";
			break;
		case "Soigne" :
			SQL = "INSERT INTO soigne (no_docteur, no_malade) VALUES ("+col1+","+col2+")";
			break;
		}
	}//fin ajouter
	
	public void rechercher(String fen, String col1, String col2, String col3, String col4, String col5, String col6, String liste) {
		
		/**
		 * PROBLEME :
		 * Pour l'instant les if ne marchent pas comme ils le devraient
		 * ils n'arrive pas à voir si un col(x) est vide ou non.
		 * Pourtant lorsque je verifie avec un system.out.print("["+col(x)+"]")
		 * il n'y a aucun espace entre les crochets.
		 * Cela prouve que les col(x) sont bien vide
		 * 
		 * REGLER :
		 * si je test la longueur du String plutot que son contenu, 
		 * le programme semble fonctionner
		 */
		
		switch(fen) {
		case "Chambre" :
			System.out.println();
			SQL = "SELECT * FROM chambre WHERE ";
			
			if(col1.length() != 0) {
				SQL += "code_service='"+col1+"' ";
			}
			
			if(col2.length() != 0) {
				if(col1.length() != 0) {
					SQL += "AND no_chambre="+col2+" ";
				}
				else SQL +="no_chambre="+col2+" ";
			}
			
			if(col3.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0) {
					SQL += "AND surveillant="+col3+" ";
				}
				else SQL += "suveillant="+col3+" ";
			}
			
			if (col4.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0 || col3.length() != 0) {
					SQL += "AND nb_lits="+col4;
				}
				else SQL += "nb_lits="+col4;
			}
			
			System.out.println(SQL);
			break;
		case "Docteur" :
			System.out.println();
			SQL = "SELECT * FROM docteur WHERE ";
			
			if(col1.length() != 0) {
				SQL += "numero="+col1+" ";
			}
			
			if(liste.length() != 0) {
				if(col1.length() != 0) {
					SQL += "AND specialite="+liste+"'";
				}
				else SQL +="specialite='"+liste+"'";
			}
			System.out.println(SQL);
			break;
		case "Employe" :
			System.out.println();
			SQL = "SELECT * FROM employe WHERE ";
			
			if(col1.length() != 0) {
				SQL += "numero="+col1+" ";
			}
			
			if(col2.length() != 0) {
				if(col1.length() != 0) {
					SQL += "AND nom='"+col2+"' ";
				}
				else SQL +="nom='"+col2+"' ";
			}
			
			if(col3.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0) {
					SQL += "AND prenom='"+col3+"' ";
				}
				else SQL += "prenom="+col3+" ";
			}
			
			if (col4.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0 || col3.length() != 0) {
					SQL += "AND adresse='"+col4+"' ";
				}
				else SQL += "adresse="+col4+"' ";
			}
			if (col5.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0 || col3.length() != 0 || col4.length() != 0) {
					SQL += "AND tel='"+col5+"'";
				}
				else SQL += "tel="+col5+"'";
			}
			System.out.println(SQL);
			break;
			
		case "Hospitalisation" :
			System.out.println();
			SQL = "SELECT * FROM hospitalisation WHERE ";
			
			if(col1.length() != 0) {
				SQL += "no_malade="+col1+" ";
			}
			
			if(col2.length() != 0) {
				if(col1.length() != 0) {
					SQL += "AND code_service='"+col2+"' ";
				}
				else SQL +="code_service='"+col2+"' ";
			}
			
			if(col3.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0) {
					SQL += "AND no_chambre="+col3+" ";
				}
				else SQL += "no_chambre="+col3+" ";
			}
			
			if (col4.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0 || col3.length() != 0) {
					SQL += "AND lit="+col4;
				}
				else SQL += "lit="+col4;
			}
			System.out.println(SQL);
			break;
		case "Infirmier" :
			System.out.println();
			SQL = "SELECT * FROM infirmier WHERE ";
			
			if(col1.length() != 0) {
				SQL += "numero="+col1+" ";
			}
			
			if(col2.length() != 0) {
				if(col1.length() != 0) {
					SQL += "AND code service='"+col2+"' ";
				}
				else SQL +="code_service='"+col2+"' ";
			}
			
			if(liste.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0) {
					SQL += "AND rotation='"+liste+"' ";
				}
				else SQL += "rotation='"+liste+"' ";
			}
			
			if (col4.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0 || liste.length() != 0) {
					SQL += "AND salaire="+col4;
				}
				else SQL += "salaire="+col4;
			}
			System.out.println(SQL);
			break;
		case "Malade" :
			System.out.println();
			SQL = "SELECT * FROM Malade WHERE ";
			
			if(col1.length() != 0) {
				SQL += "numero="+col1+" ";
			}
			
			if(col2.length() != 0) {
				if(col1.length() != 0) {
					SQL += "AND nom='"+col2+"' ";
				}
				else SQL +="nom='"+col2+"' ";
			}
			
			if(col3.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0) {
					SQL += "AND prenom='"+col3+"' ";
				}
				else SQL += "prenom="+col3+" ";
			}
			
			if (col4.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0 || col3.length() != 0) {
					SQL += "AND adresse='"+col4+"' ";
				}
				else SQL += "adresse="+col4+"' ";
			}
			if (col5.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0 || col3.length() != 0 || col4.length() != 0) {
					SQL += "AND tel='"+col5+"'";
				}
				else SQL += "tel="+col5+"'";
			}
			if (col6.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0 || col3.length() != 0 || col4.length() != 0 || col5.length() != 0) {
					SQL += "AND mutuelle='"+col6+"'";
				}
				else SQL += "mutuelle="+col6+"'";
			}
			System.out.println(SQL);
			break;
		case "Service" :
			System.out.println();
			SQL = "SELECT * FROM service WHERE ";
			
			if(col1.length() != 0) {
				SQL += "code='"+col1+"' ";
			}
			
			if(col2.length() != 0) {
				if(col1.length() != 0) {
					SQL += "AND nom='"+col2+"' ";
				}
				else SQL +="nom='"+col2+"' ";
			}
			
			if(col3.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0) {
					SQL += "AND batiment='"+col3+"' ";
				}
				else SQL += "batiment="+col3+" ";
			}
			
			if (col4.length() != 0) {
				if(col1.length() != 0 || col2.length() != 0 || col3.length() != 0) {
					SQL += "AND directeur="+col4;
				}
				else SQL += "directeur="+col4;
			}
			System.out.println(SQL);
			break;
		case "Soigne" :
			System.out.println();
			SQL = "SELECT * FROM soigne WHERE ";
			
			if(col1.length() != 0) {
				SQL += "no_docteur="+col1+" ";
			}
			
			if(col2.length() != 0) {
				if(col1.length() != 0) {
					SQL += "AND no_malade="+col2+"'";
				}
				else SQL +="no_malade='"+col2+"'";
			}
			System.out.println(SQL);
			break;
		}
	}//fin rechercher 
	
	public void supprimer(String tableau, String col1, String col2) {
		switch(tableau) {
		case "Chambre" :
			SQL = "DELETE FROM chambre WHERE code_service ='"+col1+"' AND no_chambre="+col2;
			break;
		case "Docteur" :
			SQL = "DELETE FROM docteur WHERE numero="+col1;
			break;
		case "Employe" :
			SQL = "DELETE FROM docteur WHERE numero="+col1;
			break;
		case "Hospitalisation" :
			SQL = "DELETE FROM docteur WHERE no_malade="+col1;
			break;
		case "Infirmier" :
			SQL = "DELETE FROM docteur WHERE numero="+col1;
			break;
		case "Malade" :
			SQL = "DELETE FROM docteur WHERE numero="+col1;
			break;
		case "Service" :
			SQL = "DELETE FROM docteur WHERE code='"+col1+"'";
			break;
		case "Soigne" :
			SQL = "DELETE FROM chambre WHERE no_docteur ='"+col1+"' AND no_malade="+col2;
			break;
		}
	}
	
	public String SQL() {
		return SQL;
	}
	
	
}
