public abstract class Stos {
    Stos(){
        this.ile = 0;
        this.pierwszy_indeks = 0;
        this.rozmiar = 16;
    }

    public int pierwszy_indeks;

    public int ile;
    public int rozmiar;
    public boolean czy_pelny(){
        if ((pierwszy_indeks + ile) == rozmiar){
            return true;
        }
        return false;
    }
        public abstract void powieksz();
}
