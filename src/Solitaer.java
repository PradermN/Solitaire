import java.util.Scanner;

public class Solitaer {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Spielfeld spielfeld = new Spielfeld();
		
		spielfeld.starteSpiel();
		spielfeld.ausgabeSpielfeld();
		
		do{
			System.out.println("Geben Sie die Zeile des Pins, wo sie anfangen möchten");
			int zeile1 = scanner.nextInt();
			System.out.println("Geben Sie die Spalte des Pins, wo sie anfangen möchten");
			int spalte1 = scanner.nextInt();
			System.out.println("Geben Sie die Zeile des Pins, wo sie Überspringen möchten");
			int zeile2 = scanner.nextInt();
			System.out.println("Geben Sie die Spalte des Pins, wo sie Überspringen möchten");
			int spalte2 = scanner.nextInt();
			spielfeld.zug(zeile1, spalte1, zeile2, spalte2);
			spielfeld.ausgabeSpielfeld();
		} 
		while(spielfeld.gewinnSpiel() == false);

	}

}
