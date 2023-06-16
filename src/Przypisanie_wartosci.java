public class Przypisanie_wartosci extends Instrukcja{
    private Zmienna z;
    private Wyrazenie w;
    Przypisanie_wartosci(Zmienna z, Wyrazenie i){
        this.z = z;
        this.w = i;
    }
    public void wykonaj(){
        int i = 0;
        try {
            i = w.wartosc();
        }catch(Exception e){
            System.out.println("nie można przypisać wartości");
            return;
        }
        z.set_wartosc(i);
    }
    public String toString(){
        String res = z.toString() + " = " + w.toString();
        return res;
    }
    public void wykonaj_debugger(Debugger d) {
        if (d.obecna_liczba_krokow >= d.liczba_krokow && !d.czy_continue) {
            d.s = this.toString();
            d.wykonaj();
        }
        if (!d.czy_koniec) {
            d.obecna_liczba_krokow++;
            int h = 0;
            try {
                h = w.wartosc();
            }catch(Exception e){
                System.out.println("nie można przypisać wartości");
                return;
            }
            z.set_wartosc(h);
            //dodajemy zmienna do stosu zmiennych w aktualnym bloku
            Blok pom = d.p.bloki.top();
            int licznik = 0;
            for (int i = 0; i < pom.z.ile; i++) {
                if (z.nazwa() == pom.z.zmienne()[i].nazwa()) {
                    licznik++;
                    if (licznik > 1) {
                        System.out.println("Nie moze być dwóch zmiennych o tej samej nazwie");
                        i = pom.z.ile;
                    } else {
                        Zmienna pomoc = new Zmienna(z.nazwa());
                        pomoc.set_wartosc(z.wartosc());
                        pom.z.zmienne()[i] = pomoc;
                    }
                }
            }
            if (licznik == 0) {
                pom.z.dodaj(z);
            }
            d.p.bloki.usun();
            d.p.bloki.dodaj(pom);
        }
    }
}
