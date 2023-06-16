public class Literal_Calkowity extends Wyrazenie{
    Literal_Calkowity(int i){
        this.set_wartosc(i);
    }
    public String toString(){
        return String.valueOf(this.wartosc());
    }

    @Override
    public int wartosc() {
        return this.getwartosc();
    }
}