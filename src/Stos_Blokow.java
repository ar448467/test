public class Stos_Blokow extends Stos{
    private Blok[] bloki;
    public Blok[] bloki(){
        return this.bloki;
    }
    Stos_Blokow(){
        this.bloki = new Blok[8];
        this.ile = 0;
        this.pierwszy_indeks = 0;
        this.rozmiar = 8;
    }
    public void dodaj(Blok t){
        if(czy_pelny()){
            powieksz();
        }
        bloki[ile + pierwszy_indeks] = t;
        ile++;
    }
    public void powieksz(){
        Blok[] pom = new Blok[2*bloki.length];
        for(int i = 0; i < ile; i++){
            pom[i] = bloki[i + pierwszy_indeks];
        }
        pierwszy_indeks = 0;
        bloki = pom;
        this.rozmiar = bloki.length;
    }
    public void usun(){
        if(ile != 0){
            ile--;
        }else{
            System.out.println("Nie można zakończyć bloku");
        }
    }
    public Blok top(){
        return bloki[ile - 1];
    }
}
