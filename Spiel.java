import java.awt.Canvas;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Cihan M. Karahan, Gideon J. Schafroth, Shium M. Rahmman, Jupp Bruns, Clemens Zander) 
 * @version (13.05.2019 8.55)
 */
public class Spiel implements Runnable
{
    // Instanzvariablen - Klassenkonstanten
    private boolean running = true;
    private static final int FPS = 60;
    private static final long maxLoopTime = 1000 / FPS;
    private static final int SPIELFELD_WIDTH = 640;
    private static final int SPIELFELD_HEIGHT = 640;
    
    // Instanzvariablen - Attribute
    private Spielfeld screen;
    private Player player;
    private Level level;
    private KeyManager keyManager;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    
    // KeyManager keyManager = new KeyManager();
    // spielfeld.getFrame().addKeyListener(keyManager);
    /**
     * Die Main-Methode, die das Spiel als jar-Datei ausführbar macht
     */
    public static void main(String[] args)
    {
        Spiel game = new Spiel();
        Spielfeld spielfeld = new Spielfeld("Spiel",SPIELFELD_WIDTH,SPIELFELD_HEIGHT);
        new Thread(game).start();
    }
    
    /**
     * Die run-Methode, die beim Start des Spiels ausgeführt wird
     */
    @Override
    public void run()
    {
        long timestamp;
        long oldTimestamp;

        //das Spielfeld, sowie der Keymanager werden erstellt und verknüpft
        screen = new Spielfeld("Game", SPIELFELD_WIDTH, SPIELFELD_HEIGHT);
        keyManager = new KeyManager();
        screen.getFrame().addKeyListener(keyManager);
        //das Spritesheet und der Spieler werden erstellt und verknüpft
        SpriteSheet playerSprite = new SpriteSheet("/player/player.png", 3 /*moves*/, 4 /*directions*/, 64 /*width*/, 64 /*height*/);
        player = new Player(320, 320, playerSprite.getSpriteElement(1, 0));
        
        BufferedImage playerImages;
        //Das Level wird erstellt und mit dem Tileset verbunden 
        Tileset tileSet = new Tileset("/tiles/raum_tileSet_64_536.png", 8, 8);
        level = new Level("/level/level1.txt", tileSet);
        //Der bzw. Die GameLoop, das Herzstück des Spiels
        while(true)
        {
            //Die Anfangszeit des Loopdurchlaufs wird gespeichert
            oldTimestamp = System.currentTimeMillis();
            //Die Eingabefunktion des Spiels wird überprüft
            update();
            //Die neue Systemzeit wird gespeichert
            timestamp = System.currentTimeMillis();
            //wenn noch Zeit im Loop übrig ist
            if(timestamp-oldTimestamp <= maxLoopTime)
            {
                //Zeichne den Spieler neu
                render();
                //Die neue Systemzeit wird gespeichert
                timestamp = System.currentTimeMillis();
                //Eine Kontrollzeile, muss später weg
                System.out.println(maxLoopTime + " : " + (timestamp-oldTimestamp));
                //wenn immer noch Zeit im Loop übrig ist
                if(timestamp-oldTimestamp <= maxLoopTime)
                {
                    try
                    {
                        //warte bis zum Ende
                        Thread.sleep(maxLoopTime - (timestamp-oldTimestamp) );
                    }
                    catch (InterruptedException e)
                    {
                        
                        e.printStackTrace();
                    }
                }
            }
            else
            {
                //Eine Kontrollzeile, muss später weg
                System.out.println("Wir zu spät!");
            }
        }
    }
    
    /**
     * Eine Methode, die die Eingaben des Benutzers und Positionen des Spielers abruft und ggf. ändert
     */
    void update()
    {
        keyManager.update();
        player.setMove(getInput());
        player.update();
    }
    
    /**
     * Eine Methode, die die Spielfigur neuzeichnet, wenn nötig
     */
    void render() 
    {
        //kein Plan was hier abgeht - Jupp, bitte irgendwer ändern wenn möglich
        Canvas canvas = screen.getCanvas();
        bufferStrategy = canvas.getBufferStrategy();
        if(bufferStrategy == null){
            screen.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, SPIELFELD_WIDTH, SPIELFELD_HEIGHT);
        level.renderMap(graphics);
        player.render(graphics);
        bufferStrategy.show();
        graphics.dispose();
    }
    
    /**
     * Input for controls
     */
    private Point getInput()
    { 
        int xMove = 0;
        int yMove = 0;
        if(keyManager.up)yMove = -1;
        if(keyManager.left)xMove = -1;
        if(keyManager.right)xMove = 1;
        return new Point(xMove, yMove);
    }
}

