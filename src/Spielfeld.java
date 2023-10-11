/**
 * Diese Klasse implementiert das Spielfeld.
 * @author Praderm NAFACK
 *
 */
public class Spielfeld{
	
	private String  pin = "#";
	private int anzahlZeilen = 6;
	private int anzahlSpalten = 6;
	private String[][] field;

	/**
	 * Der Konstruktor initialisiert das Spielfeld.
	 */
	public Spielfeld() {
		
		this.field = new String[anzahlZeilen][anzahlSpalten];
		}
		
	/**
	 * Die Methode stellt dar, wie das Spielfeld am Anfang aussieht.
	 */
	public void starteSpiel(){
		int wert1 = 0, wert2 = 0;
		// Hier wird das Spieldfeld mit Pins gefuellt.
		for(int i=0; i<field.length; i++) {
			for(int j=0; j<field.length; j++) {
				field[i][j]  = pin;
			}
		}
		// Hier schreiben wir die Zahlen oben des Spielfelds.
		for(int j=0; j<field.length; j++) {
			field[0][j]	= wert2 + " ";
			wert2++;
		}
		// Hier schreiben wir die Zahlen links des Spielfeld und dazu die |.
		for(int i=0; i<field.length; i++) {
			field[i][0]	= wert1 + "|";
			wert1++;
		}
		
	    // Das erste Kaetschen oben links wird leer gemacht.
		field[0][0] = " ";
		// Das Kaetschen, wo der Spieler anfangen muss, wird leer gemacht.
		field[4][3] = " ";
		
		System.out.println("Das Spiel fängt gleich an! und so sieht das Spieldfeld aus.");
	}
	
	/**
	 * Die Methode gibt das Spielfeld aus der Konsole.
	 */
	public void ausgabeSpielfeld() {
		
		System.out.print("  ");
		for(int j=0; j<field.length; j++) {
			System.out.print(field[0][j]);
		}
		
		System.out.println();
		System.out.print("   - - - - - ");
		System.out.println();
		
		for(int i=1; i<field.length; i++) {
			
			for(int j=0; j<field.length; j++) {
				
				System.out.print(field[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Die Methode erklaert die Logik des Spiels.
	 * @param zeile1 Zeile des kaetschen, wo der Spieler anfangen moechte.
	 * @param spalte1 spalte des kaetschen, wo der Spieler anfangen moechte.
	 * @param zeile2 Zeile des kaetschen, wo der Spieler ueberspringen moechte.
	 * @param spalte2 spalte des kaetschen, wo der Spieler ueberspringen moechte.
	 * @return true oder false abhaengig von den Angaben des Spielers.
	 */
	public boolean zug(int zeile1, int spalte1, int zeile2, int spalte2) {
		
		boolean result = true;
		
		if(zeile1>5 || zeile2>5 || spalte1>5 || spalte2>5 || zeile1<0 || zeile2<0 || spalte1<0 || spalte2<0) {
			
			result = false;
			System.out.println("Diese Eingaben sind ungültig! Versuchen Sie es nochmal.");
		}
		
		else if(field[zeile1][spalte1].equals("#")) {
			
			result = false;
			System.out.println("Das Feld, wo Sie sind ist nicht leer!");
		}
		
		else if(field[zeile2][spalte2].equals(" ")) {
			
			result = false;
			System.out.println("Das Feld, wo sie überspringen möchten ist leer!");
		}
		
		else if((zeile1-zeile2==0 && spalte1-spalte2==-2) || (zeile1-zeile2==0 && spalte1-spalte2==2)||
				(zeile1-zeile2==2 && spalte1-spalte2==0) || (zeile1-zeile2==-2 && spalte1-spalte2==0)) {
			
			field[zeile1][spalte1] = " ";
			field[zeile2][spalte2] = pin;
			
			if(zeile1 - zeile2 == 0) {
				if(spalte1 - spalte2 == 2) {
					field[zeile2][spalte2+1] = " ";
				}
				else {
					field[zeile2][spalte2-1] = " ";
				}
			}
			
			else if(spalte1 - spalte2 == 0) {
				if(zeile1 - zeile2 == 2) {
					field[zeile2+1][spalte2] = " ";
				}
				else {
					field[zeile2-1][spalte2] = " ";
				}
			}
		}
		
		else {
			result = false;
			System.out.println("Das ist unmöglich! Versuchen Sie es nochmal.");
		}
		
		return result;
	}
	
	/**
	 * Die Methode gib an, ob der Spieler bereit gewonnen hat oder nicht.
	 * @return true, wenn der Spieler gewonnen hat und false im Gegensatz.
	 */
	public boolean gewinnSpiel() {
		int anzahlPin = 0;
		for(int i=0; i<field.length; i++) {
			
			for(int j=0; j<field.length; j++) {
				
				if(field[i][j].equals(pin)) {
					anzahlPin++;
				}
			}
		}
		if(anzahlPin== 16) {
			System.out.println("Sie haben gewonnen!!!");
			return true;
		}
		else {
			return false;
		}
	}
}
