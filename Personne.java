import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Personne {

	public Personne() {	}
	
	Scanner clavier= new Scanner(System.in);
	
	public int login(String username, String password) throws IOException {
		int id = -1;
        
        String record = null;
        FileReader in = null;
        in = new FileReader("login.id.txt");
        BufferedReader br = new BufferedReader(in);
        
        while ((record = br.readLine()) !=null) {

            // Split line by a :
            // split[0] <- username
            // split[1] <- password
            String[] split = record.split(":");

            if (username.equals(split[0]) && password.equals(split[1])) {
            	id=0;
            	break;
            }
            else if (username.equals("admin") && password.equals("admin")) {
            	id=1;
            	break;
            }
        }
        return id;

	}

}
