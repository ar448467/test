public class If_Else extends Instrukcja{
    private If If1;
    private Stos_instrukcji instrukcje_else;
    If_Else(If If1, Stos_instrukcji i){
        this.If1 = If1;
        this.instrukcje_else = i;
    }
    public void wykonaj(){
        if(If1.wartosc_If()){
            for(int i = 0; i < If1.instrukcje_if().ile; i++){
                If1.instrukcje_if().instrukcje()[i].wykonaj();
            }
        }
        else{
            for(int i = 0; i < instrukcje_else.ile; i++){
                instrukcje_else.instrukcje()[i].wykonaj();
            }
        }
    }
    public String toString(){
        String res = this.If1.toString() + " else ";
        return res;
    }
    public void wykonaj_debugger(Debugger d) {
        if (!d.czy_continue && d.obecna_liczba_krokow >= d.liczba_krokow) {
            d.s = this.toString();
            d.wykonaj();
        }
        if (!d.czy_koniec) {
            d.obecna_liczba_krokow++;
            if (If1.wartosc_If()) {
                for (int i = 0; i < If1.instrukcje_if().ile; i++) {
                    If1.instrukcje_if().instrukcje()[i].wykonaj_debugger(d);
                }
            } else {
                d.obecna_liczba_krokow++;
                for (int i = 0; i < instrukcje_else.ile; i++) {
                    instrukcje_else.instrukcje()[i].wykonaj_debugger(d);
                }
            }
        }
    }
}
