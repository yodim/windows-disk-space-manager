import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Admin extends Personne {

	public Admin() { }
	
	public void ajouter_user() throws IOException {
		Scanner clavier= new Scanner(System.in);
      		
 	   System.out.println("username à ajouter : ");
        String username =clavier.next();
      
        System.out.println("password à ajouter : ");
        String password=clavier.next();
        
        String dir = "login.id.txt";
        
        File file = new File(dir);
 	   FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
 	   fw.write("\n"+username+":"+password);
 	   fw.close();
 	   System.out.println("Utilisateur ajouté avec succès !");
	}
	
	public void AdminMenu() throws IOException {
		System.out.println("Bienvenue Monsieur l'Admin !");
		
		int choix;
		do
        {  System.out.println("\n\n1: Inscrire un nouvel utilisateur");
           System.out.println("2: Accèder au menu user");
           System.out.println("3: Quitter l'application");
           System.out.println("\n\nEntrer le numéro de l'opération de votre choix");
           
           choix=clavier.nextInt();
           
           switch(choix)
           {  case 1:
        	   		ajouter_user();
                 break;
                 
              case 2:
            	  	User user = new User();
              		user.UserMenu("Admin");
                 break;
                 
              case 3: System.out.println("FIN");
                 break;
              default : System.out.println("Choix erroné");
           }
        }while(choix !=3);
        clavier.close();
	}

}
