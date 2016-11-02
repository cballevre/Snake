

public class Processus implements Runnable {

    private Serpent serpent;
    private Thread th;

    public Processus(Serpent serpent) {
        this.serpent = serpent;
        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        for (; ; ) {
            serpent.deplacer();
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            serpent.repaint();
        }

    }

}
