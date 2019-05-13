import java.awt.Point;
import java.awt.image.BufferedImage;
/**
 * Beschreiben Sie hier die Klasse Spieler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class Creature extends Entity
{
    public static final int DEFAULT_HEALTH = 10;
    public static final int DEFAULT_SPEED = 3;

    protected int health;
    protected int speed;
    protected int xMove;
    protected int yMove;
    
    public Creature(String name, BufferedImage image, int x, int y, int width, int height, int health, int speed)
    {
        super(name, image, x, y, width, height);
        this.health = health;
        this.speed = speed;
        xMove = 0;
        yMove = 0;
    } 
    
    public void move(){
        entityX += xMove * speed;
        entityY += yMove * speed;
    } 
  
    public void setMove(Point p) 
    {
        xMove = p.x;
        yMove = p.y;
    }
}
