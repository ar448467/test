public class Stos_zmiennych extends Stos {
    private Zmienna[] zmienne;
    public Zmienna[] zmienne(){
        return this.zmienne;
    }
    public void zmienneset(int i, Zmienna z){
        zmienne[i] = z;
    }
    Stos_zmiennych(){
        this.zmienne = new Zmienna[8];
        this.ile = 0;
        this.pierwszy_indeks = 0;
        this.rozmiar = 8;
    }
    public void dodaj(Zmienna t){
        if(czy_pelny()){
            powieksz();
        }
        zmienne[ile + pierwszy_indeks] = t;
        ile++;
    }
    public void powieksz(){
        Zmienna[] pom = new Zmienna[2*zmienne.length];
        for(int i = 0; i < ile; i++){
            pom[i] = zmienne[i + pierwszy_indeks];
        }
        pierwszy_indeks = 0;
        zmienne = pom;
        this.rozmiar = zmienne.length;
    }
}
