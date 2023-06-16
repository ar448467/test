public class Print extends Instrukcja{
    private Wyrazenie w;
    Print(Wyrazenie w){
        this.w = w;
    }
    public void wykonaj(){
        int i = 0;
        try{
            i = w.wartosc();
        }catch(Exception e){
            return;
        }
        System.out.println(i);
    }
    public String toString(){
        String res = "Print " + w.toString();
        return res;
    }
    public void wykonaj_debugger(Debugger d) {
        if (!d.czy_continue && d.obecna_liczba_krokow >= d.liczba_krokow) {
            d.s = this.toString();
            d.wykonaj();
        }
        if (!d.czy_koniec) {
            d.obecna_liczba_krokow++;
            int i = 0;
            try{
                i = w.wartosc();
            }catch(Exception e){
                return;
            }
            System.out.println(i);
        }
    }
}
