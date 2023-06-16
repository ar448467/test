public class Blok extends Instrukcja{
    private Stos_instrukcji instrukcje;
    public Stos_zmiennych z;
    public void wykonaj(){
        for (int i = 0; i < instrukcje.ile; i++){
            instrukcje.instrukcje()[i].wykonaj();
        }
    }
    Blok(Stos_instrukcji i, Stos_zmiennych z ){
        this.instrukcje = i;
        this.z = z;
    }
    @Override
    public String toString() {
        return null;
    }
    public void wartosciowanie(){
        for (int i = 0; i < z.ile; i++){
            System.out.print(z.zmienne()[i].nazwa() + " " + z.zmienne()[i].wartosc() +" ");
        }
        System.out.println();
    }
    public void wykonaj_debugger(Debugger d){
        for (int i = 0; i < instrukcje.ile; i++){
            instrukcje.instrukcje()[i].wykonaj_debugger(d);
        }
    }
}
