
/**
 * Beschreiben Sie hier die Klasse Utils.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Utils {
  public static int parseInt(String number){
    try {
      return Integer.parseInt(number);
    } catch(NumberFormatException e){
      e.printStackTrace();
      return -1;
    }
  }
}
