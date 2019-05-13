import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Die KeyManager Klasse realisiert einen Tastendruck und gibt diese Information an das Spiel weiter 
 * 
 * @author (Cihan Karahan, Shium Rahman, Gideon Schafroth) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class KeyManager implements KeyListener {

  private boolean[] keys;
  public boolean up, left, right;

  public KeyManager(){
    keys = new boolean[256];
  }
  public void update(){
    up = keys[KeyEvent.VK_W];
    left = keys[KeyEvent.VK_A];
    right = keys[KeyEvent.VK_D];
  }
  @Override
  public void keyPressed(KeyEvent e) {
    keys[e.getKeyCode()] = true;
  }
  @Override
  public void keyReleased(KeyEvent e) {
    keys[e.getKeyCode()] = false;
  }
  @Override
  public void keyTyped(KeyEvent e) {
  }
}
