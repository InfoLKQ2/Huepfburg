import java.awt.image.BufferedImage;
/**
 * Die Klasse Item, beschäftigt sich mit allen Geegenständen welche auf dem Spielfeld auftauchen
 * 
 * @author (Cihan M. Karahan, Gideon J. Schafroth, Shium M. Rahmman) 
 * @version (13.05.2019)
 */
public abstract class Item extends Entity {
  protected int weight;
  protected int value;
  protected boolean stackable;

  public Item(String name, BufferedImage image, int x, int y, int width, int height, int weight, int value, boolean stackable) {
     super(name, image, x, y, width, height);
     this.weight = weight;
     this.value = value;
     this.stackable = stackable;//Das Attribut stackable sagt aus, das dieses Item im Inventory unserer Spielfigur gestapelt werden kann.
  }
}
