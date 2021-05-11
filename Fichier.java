import java.io.File;
import java.util.Scanner;


public class Fichier extends Element{

	private String nom;
	private int taille;
	
	public Fichier() {	}
	
	
	public void afficher(String dir) {
		File repertoire = new File(dir);
		File[] list = repertoire.listFiles();
		for (File file:list) {
			if(!file.isDirectory()) {
				System.out.println("- "+ file.getName()+", taille : "+getTaille(file) + " octets");
			}
		}
	}
	
	public long getTaille(File file) {
		long fileSize = file.length();
		return fileSize;
	}
	
	Scanner clavier= new Scanner(System.in);
	
	public void rename(String dir) {
		System.out.println("Entrez le nom du fichier à renommer :");
		String old_name = clavier.next();
		String old_dir = dir + old_name;
		
		System.out.println("Entrez le nouveau nom :");
		String new_name = clavier.next();
		String new_dir = dir + new_name;
		
        File old_file = new File(old_dir);
        File new_file = new File(new_dir);
        
        if (old_file.renameTo(new_file)) {
            System.out.println("Nom du fichier est modifié avec succès !");
        } else {
            System.out.println("Échec de la modification du fichier!");
        }
	}
	
	public void delete(String dir) {
		System.out.println("Entrez le nom du dossier ou du fichier à supprimer :");
		String fold_name = clavier.next();
		
		String direc = dir + fold_name;

        File file = new File(direc);
        
        file.delete();
        System.out.println("fichier supprimé avec succès !");
	}

}
