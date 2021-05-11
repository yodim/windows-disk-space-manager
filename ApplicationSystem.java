import java.io.IOException;
import java.util.Scanner;

public class ApplicationSystem {

	public static void main(String[] args) throws IOException {
		Scanner clavier= new Scanner(System.in);
		Personne perso = new Personne();
		
		System.out.println("Bienvenue.\nVeuillez faire l'authentification. \n\n");
		
		System.out.println("username : ");
        String username =clavier.next();
      
        System.out.println("password : ");
        String password=clavier.next();
        
		perso.login(username, password);
        
        if (perso.login(username, password) == 0) {
        	User user = new User();
        	user.UserMenu(username);
        }
        else if (perso.login(username, password) == 1) {
        	Admin admin = new Admin();
        	admin.AdminMenu();
        }
        else if (perso.login(username, password) == -1) {
        	System.out.println("Accès non autorisé !!!\n\n");
        	main(args);
        }
	}

}
