public class BeginBlock extends Instrukcja{
    private Program p;
    private Stos_instrukcji i;
    BeginBlock(Stos_instrukcji i, Program p){
        this.i = i;
        this.p = p;
    }
    public void wykonaj(){
        Stos_zmiennych z = new Stos_zmiennych();
        Blok a = new Blok(i, z);
        p.bloki.dodaj(a);
        a.wykonaj();
    }
    public String toString(){
        return "Begin Block";
    }
    public void wykonaj_debugger(Debugger d){
        if(!d.czy_continue && d.obecna_liczba_krokow == d.liczba_krokow){
            d.s = this.toString();
            d.wykonaj();
        }
        if(!d.czy_koniec) {
            d.obecna_liczba_krokow++;
            Stos_zmiennych z = new Stos_zmiennych();
            Blok a = new Blok(i, z);
            if (p.bloki.ile != 0) {
                // kopiowanie stosu zmiennych
                Blok pom = p.bloki.top();
                for (int i = 0; i < pom.z.ile; i++) {
                    Zmienna pomi = new Zmienna(pom.z.zmienne()[i].nazwa());
                    pomi.set_wartosc(pom.z.zmienne()[i].wartosc());
                    a.z.dodaj(pomi);
                    pom.z.zmienneset(i, pomi);
                }
            }
            p.bloki.dodaj(a);
            a.wykonaj_debugger(d);
        }
    }
}
