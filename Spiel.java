import java.awt.Canvas;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Cihan M. Karahan, Gideon J. Schafroth, Shium M. Rahmman) 
 * @version (08.05.2019 8.55)
 */
public class Spiel implements Runnable
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    public boolean running = true;
    public static final int FPS = 60;
    public static final long maxLoopTime = 1000 / FPS;
    public static final int SPIELFELD_WIDTH = 640;
    public static final int SPIELFELD_HEIGHT = 640;
    public Spielfeld screen;
    Player player;
    //Level level;
    KeyManager keyManager;
    BufferStrategy bs;
    Graphics g;
    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Spiel()
    {
        // Instanzvariable initialisieren
        
    }
     // KeyManager keyManager = new KeyManager();
      // spielfeld.getFrame().addKeyListener(keyManager);
      
    public static void main(String[] args){
      Spiel game = new Spiel();
      Spielfeld spielfeld = new Spielfeld("Spiel",SPIELFELD_WIDTH,SPIELFELD_HEIGHT);
      new Thread(game).start();
    }
    
    @Override
    public void run() {
        long timestamp;
        long oldTimestamp;
        
        screen = new Spielfeld("Game", SCREEN_WIDTH, SCREEN_HEIGHT);
        keyManager = new KeyManager();
        screen.getFrame().addKeyListener(keyManager);
        
       SpriteSheet playerSprite = new SpriteSheet("/sprites/player.png", 3 /*moves*/, 4 /*directions*/, 64 /*width*/, 64 /*height*/);
        player = new Player(320, 320, playerSprite.getSpriteElement(1, 0));
        
        while(running) 
        {
           oldTimestamp = System.currentTimeMillis();
           update();
           timestamp= System.currentTimeMillis();
           if(timestamp-oldTimestamp> maxLoopTime)
           {
               System.out.println("Wir sind zu spät!");
               continue;
           }
           render();
           timestamp= System.currentTimeMillis();
           System.out.println(maxLoopTime + " : " + (timestamp-oldTimestamp));
           if(timestamp-oldTimestamp <= maxLoopTime) {
               try {
                        //Der Thread schläft solange bis die maxLooptime erreicht ist. So dauert jeder Schleifendurchgang nur 1/60 sec.
                        Thread.sleep(maxLoopTime - (timestamp-oldTimestamp) );
                   } catch (InterruptedException e) {
                        e.printStackTrace();
                   }
           }
        }
    }

    void update() {
       keyManager.update();
       player.setMove(getInput());
       player.update();
    }
    
    void render() 
    {
        Canvas c = screen.getCanvas();
        bs = c.getBufferStrategy();
        if(bs == null){
            screen.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, SPIELFELD_WIDTH, SPIELFELD_HEIGHT);
        level.renderMap(g);
        player.render(g);

        bs.show();
        g.dispose();
    }
    
    /**
     * Input for controls
     */
    private Point getInput(){ 
      int xMove = 0;
      int yMove = 0;
      if(keyManager.up)
        yMove = -1;
      
      if(keyManager.left)
        xMove = -1;
      if(keyManager.right)
        xMove = 1;
      return new Point(xMove, yMove);
    }
}

