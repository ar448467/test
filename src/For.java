public class For extends Instrukcja {
    private Zmienna z;
    private Wyrazenie w;
    private Stos_instrukcji s;
    For(Zmienna z, Wyrazenie w, Stos_instrukcji s) {
        this.z = z;
        this.w = w;
        this.s = s;
    }

    public void wykonaj() {
        int pom = 0;
        try{
            pom = w.wartosc();
        }catch(Exception e){
            return;
        }
        for (int i = 0; i < pom; i++) {
            z.set_wartosc(i);
            for (int j = 0; j < s.ile; j++) {
                s.instrukcje()[j].wykonaj();
            }
        }
    }
    public String toString(){
        String res = "For (" + z.toString() + " " + w.toString() + ")";
        return res;
    }
    public void wykonaj_debugger(Debugger d) {
        if (d.obecna_liczba_krokow >= d.liczba_krokow && !d.czy_continue) {
            d.s = this.toString();
            d.wykonaj();
        }
        if (!d.czy_koniec) {
            int pom = 0;
            try{
                pom = w.wartosc();
            }catch(Exception e){
                return;
            }
            for (int i = 0; i < pom; i++) {
                if (d.obecna_liczba_krokow >= d.liczba_krokow && !d.czy_continue) {
                    d.s = this.toString();
                    d.wykonaj();
                }
                if(!d.czy_koniec) {
                    d.obecna_liczba_krokow++;
                    z.set_wartosc(i);
                    //dodawanie do stosu zmiennych nowej zmiennej
                    Blok pom1 = d.p.bloki.top();
                    int licznik = 0;
                    for (int k = 0; k < pom1.z.ile; k++) {
                        if (z.nazwa() == pom1.z.zmienne()[k].nazwa()) {
                            licznik++;
                            if (licznik > 1) {
                                System.out.println("Nie moze być dwóch zmiennych o tej samej nazwie");
                                k = pom1.z.ile;
                            } else {
                                Zmienna pomoc = new Zmienna(z.nazwa());
                                pomoc.set_wartosc(i);
                                pom1.z.zmienne()[k] = pomoc;
                            }
                        }
                    }
                    if (licznik == 0) {
                        pom1.z.dodaj(z);
                    }
                    d.p.bloki.usun();
                    d.p.bloki.dodaj(pom1);
                    for (int j = 0; j < s.ile; j++) {
                        s.instrukcje()[j].wykonaj_debugger(d);
                    }
                }
            }
        }
    }
}
