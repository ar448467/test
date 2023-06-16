public class Mnozenie extends Dwuargumentowe{
    Mnozenie(Wyrazenie w1, Wyrazenie w2){
        super(w1, w2, "*");
    }
    public int wartosc() throws Exception{
        this.set_wartosc(this.wyr1.wartosc() * this.wyr2.wartosc());
        return getwartosc();
    }
}
