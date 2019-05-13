import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Die Klasse Tileset liest ein Tileset aus einer Datei in ein Array ein und ist in der Lage, jede einzelne Kachel
 * dieses Tilesets an eine bestimmte Stelle auf dem Spielfeld zu zeichnen.
 * Author(Clemens Zander, Jupp Bruns)
 * Version(10.5.19)
 */
public class Tileset
{
    public static final int TILEBREITE=64;//Breite einer Kachel
    public static final int TILEHOEHE=64;//Höhe eine Kachel
    
    private BufferedImage[] tiles;//Array in welches die einzelnen Kacheln eingespeichert werden
    /**
     * Konstruktor der Klasse Tileset
     * @param path gibt den Pfad zur Datei des Tilesets an
     * @param sizeX ist die Anzahl an Tiles in horizontaler Richtung im Tileset 
     * @param sizeY ist die Anzahl an Tiles in vertikaler Richtung im Tileset  
     */
    public Tileset(String path, int sizeX, int sizeY)
    {
        tiles = new BufferedImage[sizeX * sizeY];
        BufferedImage tileSet;
        try//Versuch die Datei zu finden nach dem angegebenen Pfad
        {
            tileSet = ImageIO.read(Tileset.class.getResource(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
        int i = 0;//Tile 0;0 ist das erste(nicht 1;1)
        for(int y = 0; y < sizeY; y++)//Beginn bei 0 bis kleiner sizeY, da bei 0 begonnen wird (nicht 1)
        {
            for(int x = 0; x < sizeX; x++)//Beginn bei 0 bis kleiner sizeX, da bei 0 begonnen wird (nicht 1)
            {
                tiles[i++] = tileSet.getSubimage(x * (TILEBREITE + 3), y * (TILEHOEHE + 3),TILEBREITE, TILEHOEHE);
                //jede Kachel wird von rechts nach links und oben nach unten durchgegangen und im BufferedImage-Array gespeichert
                //Funktion getSubimage schneidet rechteckige Stücke aus dem Tileset heraus
            }
        }
    }
    
    /**
     * Methode zeichnet eine Kachel
     * @param g übergibt die Grafiken auf welche die Kachel gezeichnet werden soll
     * @param tileNum übergibt die Nummer eines Tiles, welche zur Identifikation einer bestimmten Kachel dient
     * @param x x-Koordinate an welche die Kachel gezeichnet werden soll
     * @param y y-Koordinate an welche die Kachel gezeichnet werden soll
     */
    public void renderTile(Graphics g, int tileNum, int x, int y)
    {
        g.drawImage(tiles[tileNum], x, y, TILEBREITE, TILEHOEHE, null);
    }
}