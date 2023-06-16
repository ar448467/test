public abstract class Wyrazenie {
    private int wartosc;
    public void set_wartosc(int i){
        this.wartosc = i;
    }
    public abstract int wartosc() throws Exception;
    public int getwartosc(){
        return wartosc;
    }
    public abstract String toString();

}
