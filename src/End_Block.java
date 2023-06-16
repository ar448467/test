public class End_Block extends Instrukcja{
    private Program p;
    End_Block(Program p){
        this.p = p;
    }
    public void wykonaj(){
        p.bloki.usun();
    }
    public String toString(){
        return "End Block";
    }
    public void wykonaj_debugger(Debugger d){
        if(!d.czy_continue && d.obecna_liczba_krokow >= d.liczba_krokow){
            d.s = this.toString();
            d.wykonaj();
        }
        if(!d.czy_koniec) {
            d.obecna_liczba_krokow++;
            p.bloki.usun();
        }
    }
}
