public abstract class Dwuargumentowe extends Wyrazenie{
    public Wyrazenie wyr1;
    public Wyrazenie wyr2;

    private String znak;
    Dwuargumentowe(Wyrazenie w1, Wyrazenie w2, String znak){
        this.wyr1 = w1;
        this.wyr2 = w2;
        this.znak = znak;
    }
    public String toString(){
        String res = wyr1.toString() + znak + wyr2.toString();
        return res;
    }

}
