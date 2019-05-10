import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**
 * Write a description of class Spieler here.
 *
 * @author (Cihan M. Karahan, Gideon J. Schafroth, Shium M. Rahmman)
 * @version (10.05.2019,10:00)
 */


public abstract class Entity {
  public static final int DEFAULT_WIDTH = 64;
  public static final int DEFAULT_HEIGHT = 64;

  protected String name;
  protected int entityX;
  protected int entityY;
  protected int width;
  protected int height;
  protected BufferedImage image;

  public Entity(String name, BufferedImage image, int x, int y, int width, int height) {
    this.name = name;
    this.image = image;
    this.entityX = x;
    this.entityY = y;
    this.width = width;
    this.height = height;
  }
  
  protected abstract void update();
  
  protected void render(Graphics g) {
    g.drawImage(image, entityX, entityY, null);
  }

}
