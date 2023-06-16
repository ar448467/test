public class Program {
    private Stos_instrukcji lista_instrukcji;
    public Stos_Blokow bloki;
  //  private Debugger d;
    Program(){
        this.lista_instrukcji = new Stos_instrukcji();
        this.bloki = new Stos_Blokow();
    }
    public void dodaj(Instrukcja t){
        lista_instrukcji.dodaj(t);
    }
    public void run(){
        for(int i = 0; i < lista_instrukcji.ile;i++){
            lista_instrukcji.instrukcje()[i].wykonaj();
        }
    }
    public void run_with_debugger(Debugger d){
        for(int i = 0; i < lista_instrukcji.ile;i++){
            if(!d.czy_continue && d.obecna_liczba_krokow >= d.liczba_krokow){
                d.s = lista_instrukcji.instrukcje()[i].toString();
                d.wykonaj();
            }
            if(!d.czy_koniec) {
                lista_instrukcji.instrukcje()[i].wykonaj_debugger(d);
            }
        }
       if(d.czy_continue) {
           System.out.println("Program zakończył się");
       }else if(!d.czy_koniec){
           System.out.println("Program zakończył się, przed wykonaniem podaniej liczby kroków");
       }
    }
}
