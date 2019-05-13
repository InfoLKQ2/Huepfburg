import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


/**
 * Beschreiben Sie hier die Klasse Utils.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Utils
{
    /**
     * wandelt einen String in eine Zahl um
     * @param number gibt die Zahl als String weiter
     */
    public static int parseInt(String number)
    {
        try
        {
            return Integer.parseInt(number);
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    
    /**
     * konvertiert die Textdatei, welche die Anordnung der Kacheln beinhaltet in einen lange String
     * @param path gibt dem Pfad zur Textdatei an
     */
    public static String loadFileAsString(String path)
    {
        StringBuilder builder = new StringBuilder();
        
        //Get file from resources folder
        FileReader file = null;
        try //Versuch die Textdatei durch den Pfad zu finden
        {
            file = new FileReader(Utils.class.getClass().getResource(path).getFile());
        } 
        catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
        }
        if(file != null)//wenn Datei gefunden wurden
        {
            try//Versuch jede einzelne Zeile einer Textdatei einzulesen
            {
                BufferedReader br = new BufferedReader(file);
                String line;
                while((line = br.readLine()) != null)//solange etwas in einer Zeile steht
                {
                    builder.append(line + "\n");//fügt den Inhalt dieser Zeile dem Builder-Objekt hinzu
                }
                br.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return builder.toString();//wandelt Builder Objekt in String um und gibt diesen zurück
    }   
}   
