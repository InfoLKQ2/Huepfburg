
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

    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Spiel()
    {
        // Instanzvariable initialisieren
        
    }
    
    public static void main(String[] args){
      Spiel game = new Spiel();
      new Spielfeld("Spiel",SPIELFELD_WIDTH,SPIELFELD_HEIGHT);
      new Thread(game).start();
    }
    
    @Override
    public void run() {
        long timestamp;
        long oldTimestamp;
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
                        Thread.sleep(maxLoopTime - (timestamp-oldTimestamp) );
                   } catch (InterruptedException e) {
                        e.printStackTrace();
                   }
           }
        }
    }

    static void update() {
       try {
         Thread.sleep(14);
       } catch (InterruptedException e) {
         e.printStackTrace();
       }
    }
    
    void render(){}
}

