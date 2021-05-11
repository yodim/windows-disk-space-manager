import java.io.File;

public class User extends Personne {

	public User() { }

	public void UserMenu(String username) {
		int choix;
		String dir;
		
		System.out.println("Bienvenue "+username +" !");
		System.out.println("Donnez le chemin du répertoire que vous voulez gérer \n"
							+ "par exemple : C://Users/username/Desktop/");
		
		dir = clavier.next();
		File directory = new File(dir);
		
		if (directory.isDirectory()) {
			do
	        {  System.out.println("\n\n1: Afficher les dossiers (nom + taille)");
	           System.out.println("2: Afficher les fichiers (nom + taille)");
	           System.out.println("3: Créer un dossier");
	           System.out.println("4: Modifier fichier ou dossier");
	           System.out.println("5: Supprimer dossier ou fichier");
	           System.out.println("6: Quitter l'application");
	           System.out.println("\n\nEntrer le numéro de l'opération de votre choix");
	           
	           choix=clavier.nextInt();
	           Dossier dossier = new Dossier();
	           Fichier fich = new Fichier();
	           int valeur;
	           
	           switch(choix)
	           {  case 1:
	        	      dossier.afficher(dir);
	                 break;
	                 
	              case 2:
	            	  fich.afficher(dir);
	                 break;
	                 
	              case 3:
	            	  dossier.createFolder(dir);
	                 break;
	                 
	              case 4:
	            	  System.out.println("1: Modifier fichier");
	            	  System.out.println("2: Modifier dossier");
	            	  valeur = clavier.nextInt();
	            	  switch(valeur)
	            	  {
	            	  case 1:
	            		  fich.rename(dir);
	            		 break;
	            	  case 2:
	            		  dossier.rename(dir);
	            		 break;            		 
	            	  }
	                 break;
	                 
	              case 5: 
	            	  System.out.println("1: Supprimer fichier");
	            	  System.out.println("2: Supprimer dossier");
	            	  valeur = clavier.nextInt();
	            	  switch(valeur)
	            	  {
	            	  case 1:
	            		  fich.delete(dir);
	            		 break;
	            	  case 2:
	            		  System.out.println("Entrez le nom du dossier à supprimer :");
	            		  String fold_name = clavier.next();
	            		  dossier.delete(dir, fold_name);
	            		 break;            		 
	            	  }
	                 break;
	                 
	              case 6 : System.out.println("FIN");
	                 break;
	              default : System.out.println("Choix erroné");
	           }
	        }while(choix !=6);
	        clavier.close();            
		}
		
		else {
			System.out.println("Chemin fourni invalid !");
		}
		
		
	}
}
