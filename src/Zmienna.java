public class Zmienna extends Wyrazenie{
    private char nazwa;
    Zmienna(char t){
        this.nazwa = t;
    }
    public void nadaj_wartosc(int i){
        this.set_wartosc(i);
    }
    public int wartosc(){
        return getwartosc();
    }
    public char nazwa(){
        return this.nazwa;
    }
    public String toString(){
        return String.valueOf(nazwa);
    }
}
