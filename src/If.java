public abstract class If extends Instrukcja{
    private Stos_instrukcji instrukcje_if;
    public Wyrazenie wyr1;
    public Wyrazenie wyr2;
    public String znak;
    If(Wyrazenie w1, Wyrazenie w2, String znak, Stos_instrukcji s){
        this.wyr1 = w1;
        this.wyr2 = w2;
        this.znak = znak;
        this.instrukcje_if = s;
    }
    public Stos_instrukcji instrukcje_if(){
        return this.instrukcje_if;
    }
    public abstract boolean wartosc_If();
    public void wykonaj(){
        if(wartosc_If()) {
            for (int i = 0; i < instrukcje_if.ile; i++) {
                instrukcje_if.instrukcje()[i].wykonaj();
            }
        }
    }
    public String toString(){
        String res = "If (";
        res = res + wyr1.toString() + znak + wyr2.toString() + ")";
        return res;
    }
    public void wykonaj_debugger(Debugger d) {
        if (!d.czy_continue && d.obecna_liczba_krokow >= d.liczba_krokow) {
            d.s = this.toString();
            d.wykonaj();
        }
        if (!d.czy_koniec) {
            d.obecna_liczba_krokow++;
            if (wartosc_If()) {
                for (int i = 0; i < instrukcje_if.ile; i++) {
                    instrukcje_if.instrukcje()[i].wykonaj_debugger(d);
                }
            }
        }
    }
}
