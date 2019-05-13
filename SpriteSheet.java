
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Die SpriteSheet Klasse liest die einzelnen Spielfiguransichten (vom Spritesheet) ein.
 * @authors(Gideon S., Shium R., Cihan K.)
 * @version(13.5.19)
 */
public class SpriteSheet
{
    private BufferedImage sheet;
    private BufferedImage[][] sprite;
    
    /**
     * Konstruktor der Klasse Spritesheet
     * 
     * @param path - der Ort an dem das Spritesheet gespeichert ist
     *        moves - die Anzahl and horizontalen Animationsansichten
     *        directions - die Anzahl der Bewegungsrichtung, für die es eine Grafik gibt
     *        width - die Breite des Sprites
     *        height - die Höhe des Sprites
     */
    public SpriteSheet(String path, int moves, int directions, int width, int height)
    {
        sprite = new BufferedImage[moves][directions];
        try
        {
            sheet = ImageIO.read(Spiel.class.getResource(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
        
        for(int horiz = 0; horiz < moves; horiz++)
        {
            for(int vert = 0; vert < directions; vert++)
            {
                sprite[horiz][vert] = sheet.getSubimage(horiz * width, vert * height, width, height);
            }
        }
    }
    
    public BufferedImage getSpriteElement(int x, int y)
    {
        return sprite[x][y];
    }
}
