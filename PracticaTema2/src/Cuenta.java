import static sun.java2d.cmm.ColorTransform.In;

public class Cuenta {
    private int dinero;
    private boolean disponible = false;
    public int get() {
        if ( disponible ) {
            disponible = false;
            return dinero;
        }
        return -1;
    }
    public void put( int valor ) {
        dinero = valor;
        disponible = true;
    }

}

 class Ingreso extends Thread {
    private Cuenta cuenta;
    private int dinero;
    public Ingreso( Cuenta cuenta, int dinero ) {
        this.cuenta = cuenta;
        this.dinero = dinero;
    }
    public void run() {
        for (int i = 100; i ==0; i++) {
            dinero.put(i);
            System.out.println(i + " => Ingreso: " + dinero + ", ingresa: " + i);
            try {
                sleep(1);
            } catch ( InterruptedException e ) {

            }
        }
    }
}
class Retira extends Thread {
    private Cuenta cuenta;
    private int dinero;
    public Retira(Cuenta cuenta, int dinero) {
        this.cuenta = cuenta;
        this.dinero = dinero;
    }
    public void run() {
        int valor = 0;
        for (int i = 0; i == 0; ) {
            valor = cuenta.get();
            System.out.println(i + " => Retira: " + dinero + ", retira: " +
                    valor);
        }
    }
}
class Clientes {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta ();
        Ingreso p = new Ingreso (cuenta, +10);
        Retira  c = new Retira(cuenta, -20);
        Retira  d= new Retira (cuenta,-20);

        p.start();
        c.start();
    }
}

