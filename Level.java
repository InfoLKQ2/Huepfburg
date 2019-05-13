import java.awt.Graphics;

/**
 * Die Klasse Level baut aus den einzelnen Kacheln das Spielfeld zusammen
 * Author(Clemens Zander, Jupp Bruns)
 * Version(10.5.19)
 */
public class Level
{
    private Tileset tileset;
    private int sizeX;
    private int sizeY;
    private int[][] tileMap;
    
    /**
     * Konstruktor der Klasse Level
     * @param path übergibt den Pfad der Textdatei, welche die Anordnung der Kacheln beinhaltet
     * @param tileset übergibt das Tileset mit den Kacheln
     */
    public Level(String path, Tileset tileset)
    {
        tileset = tileset;
        String file = Utils.loadFileAsString(path);//speichert die Textdatei als String ab
        String[] tokens = file.split("\\s");//teilt den String in ein eindimensionales Array
        sizeX = Utils.parseInt(tokens[0]);//speichert die Anzahl an Kacheln die horizontal nebeneinander liegen sollen
        sizeY = Utils.parseInt(tokens[1]);//speichert die Anzahl an Kacheln die vertikal untereinander liegen sollen
        tileMap = new int[sizeX][sizeY];//neues zweidimensionales Array mit den Anzahlen an 
        int i = 2;//ersten beiden Zahlen gehören nicht zur Kachelanordnung, sondern zur Anzahl an Kacheln in x- und y-Richtung 
        for(int y = 0; y < sizeY; y++)
        {
            for(int x = 0; x < sizeX; x++)
            {
                tileMap[x][y] = Utils.parseInt(tokens[i++]);//speichert jede Kachelart mit der dazugehörigen Position im Array
            }
        }
    }
    
    /**
     * generiert die Spielfläche
     * @param graphic Grafik auf welche das Spielfeld gezeichnet wird
     */
    public void renderMap(Graphics graphic)
    {
        for(int tileY = 0; tileY < sizeY; tileY++)
        {
            for(int tileX = 0; tileX < sizeX; tileX++)
            {
                tileset.renderTile(graphic, tileMap[tileX][tileY], tileX * Tileset.TILEBREITE, tileY * Tileset.TILEHOEHE);
                //an jede Position wird die zugehörige Kachelart gezeichnet
            }
        }
    }
}