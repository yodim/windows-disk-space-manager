import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Dossier extends Element {

	public Dossier() {	}
	
	public void afficher(String dir) {
		File repertoire = new File(dir);
		File[] list = repertoire.listFiles();
		for (File folder:list) {
			if(folder.isDirectory()) {
				System.out.println("- "+ folder.getName()+", taille : "+getTaille(folder) + " octets");
			}
		}
	}
	
	//private Vector <Element> listeElement = new Vector<Element>();
	
	public int getTaille(File file) {
		int taille = 0;
		for (File elt:file.listFiles()) {
			if (elt.isFile()) {
				taille += elt.length(); 
			}
			else if (elt.isDirectory()) {
				getTaille(elt);
			}			
		}
		return taille;
	}
	
	Scanner clavier= new Scanner(System.in);
	
	public void createFolder(String dir) {
		System.out.println("Entrez le nom du nouveau dossier à créer :");
		String fold_name = clavier.next();
		
		String direc = dir+fold_name;
        File file = new File(direc);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Dossier est crée avec succès !");
        } else {
            System.out.println("Échec de la création du dossier!");
        }
	}
	
	public void rename(String dir) {
		System.out.println("Entrez le nom du dossier à renommer :");
		String old_name = clavier.next();
		String old_dir = dir + old_name;
		
		System.out.println("Entrez le nouveau nom :");
		String new_name = clavier.next();
		String new_dir = dir + new_name;
		
        File old_file = new File(old_dir);
        File new_file = new File(new_dir);
        
        if (old_file.renameTo(new_file)) {
            System.out.println("Nom du dossier est modifié avec succès !");
        } else {
            System.out.println("Échec de la modification du dossier!");
        }
	}
	
	
	public void delete(String dir, String fold_name) {
		
		String direc = dir + fold_name+"/";

        File file = new File(direc);
        delete_rec(file);
        System.out.println("Dossier supprimé avec succès !");
	}
	
	public void delete_rec(File file) {
        for (File subFile : file.listFiles()) {
            if(subFile.isDirectory()) {
               delete_rec(subFile);
            } else {
               subFile.delete();
            }
         }
        file.delete();
	}

}
