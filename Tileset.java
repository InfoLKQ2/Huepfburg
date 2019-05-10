import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Author(Clemens Zander, Jupp Bruns)
 * Version(10.5.19 *dab*)
 */
public class Tileset
{
    public static final int TILEBREITE=64;
    public static final int TILEHOEHE=64;
    
    private BufferedImage[] tiles;
    
    public Tileset(String path, int sizeX, int sizeY) 
    {
        tiles = new BufferedImage[sizeX * sizeY];
        BufferedImage tileSet;
        try
        {
            tileSet = ImageIO.read(Tileset.class.getResource(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
        int i = 0;
        for(int y = 0; y < sizeY; y++) 
        {
            for(int x = 0; x < sizeX; x++) 
            {
                tiles[i++] = tileSet.getSubimage(x * (TILEBREITE + 3), y * (TILEHOEHE + 3),
                TILEBREITE, TILEHOEHE);
            }
        }
    }
    
    public void renderTile(Graphics g, int tileNum, int x, int y)
    {
        g.drawImage(tiles[tileNum], x, y, TILEBREITE, TILEHOEHE, null);
    }
}