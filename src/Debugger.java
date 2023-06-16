import java.util.Scanner;
public class Debugger {
    public Program p;
    public int liczba_krokow; // liczba podana przez uzytkownika
    public boolean czy_continue;// true gdy użytkownik dał polecenie c
    public boolean czy_koniec;// true gdy użytkownik dał polecenie e
    public String s; // nastepna instrukcja do wykonania
    public int obecna_liczba_krokow; // ile krokow zostalo wykonanych od ostatniego polecenia s
    Debugger(Program p){
        this.p =p;
        this.czy_koniec = false;
        this.liczba_krokow = 0;
        this.czy_continue = false;
        this.obecna_liczba_krokow = 0;
        s = "";
    }
    public void wykonaj(){
        if(liczba_krokow != 0) System.out.println(s.toString());
        obecna_liczba_krokow = 0;
        Scanner scan = new Scanner(System.in);
        char a;
        int l = -1;
        while(!czy_koniec){
             a = scan.next().charAt(0);
             if (a == 's' || a == 'd'){
                 l = scan.nextInt();
             }
             if(a == 'e'){
                 czy_koniec = true;
             }
             if(a == 'd'){
                 display(l);
             }
             if(a == 'c'){
                 czy_continue = true;
                 break;
             }
             if(a == 's'){
                 if(l == 0){
                     System.out.println(s.toString());
                 }
                 if(l > 0) {
                     liczba_krokow = l;
                     break;
                 }
             }
        }
    }
    public void display(int l) {
        if (l >= 0) {
            if (p.bloki.ile <= l) {
                System.out.println("podana liczba jest większa niż poziom zagnieżdżenia bieżącej instrukcji programu ");
            } else {
                p.bloki.bloki()[p.bloki.ile - l - 1].wartosciowanie();
            }
        }
    }
}
