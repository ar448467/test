public class Mniejsze_rowne extends If{
    Mniejsze_rowne(Wyrazenie w1, Wyrazenie w2, Stos_instrukcji s){
        super(w1,w2,"<=",s);
    }
    public boolean wartosc_If(){
        int i = 1 ,j = 0;
        try{
            i = this.wyr1.wartosc();
            j = this.wyr2.wartosc();
        }catch(Exception e){
            return false;
        }
        return(i <= j);
    }
}
