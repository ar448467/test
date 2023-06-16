public class Modulo extends Dwuargumentowe{
    Modulo(Wyrazenie w1, Wyrazenie w2){
        super(w1, w2, "%");
    }
    public int wartosc() throws Exception{
        if(this.wyr2.wartosc() == 0) {
            throw new Exception();
        }else {
            this.set_wartosc(this.wyr1.wartosc() % this.wyr2.wartosc());
        }
        return this.getwartosc();
    }
    }