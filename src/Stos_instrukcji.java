public class Stos_instrukcji extends Stos{
     private Instrukcja[] instrukcje;
    public Instrukcja[] instrukcje(){
      return this.instrukcje;
     }
     Stos_instrukcji(){
          this.instrukcje = new Instrukcja[16];
         this.ile = 0;
         this.pierwszy_indeks = 0;
         this.rozmiar = 16;
     }
     public void dodaj(Instrukcja t){
         if(czy_pelny()){
             powieksz();
         }
         instrukcje[ile + pierwszy_indeks] = t;
         ile++;
     }
     public void powieksz(){
         Instrukcja[] pom = new Instrukcja[2*instrukcje.length];
         for(int i = 0; i < ile; i++){
             pom[i] = instrukcje[i + pierwszy_indeks];
         }
         pierwszy_indeks = 0;
         instrukcje = pom;
         this.rozmiar = instrukcje.length;
     }
     }

