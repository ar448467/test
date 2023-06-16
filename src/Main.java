public class Main {
    public static void main(String[] args){
        Program prog = new Program();
        Stos_instrukcji s = new Stos_instrukcji();
        Zmienna n = new Zmienna('n');
        s.dodaj(new Przypisanie_wartosci(n,new Literal_Calkowity(30)));
        Zmienna k = new Zmienna('k');
        Zmienna p = new Zmienna('p');
        Stos_instrukcji s1 = new Stos_instrukcji();
        s1.dodaj(new Przypisanie_wartosci(p,new Literal_Calkowity(1)));
        s1.dodaj(new Przypisanie_wartosci(k, new Suma(k, new Literal_Calkowity(2))));
        Stos_instrukcji s2 = new Stos_instrukcji();
        Zmienna i = new Zmienna('i');
        s2.dodaj(new Przypisanie_wartosci(i, new Suma(i, new Literal_Calkowity(2) )));
        Stos_instrukcji s3 = new Stos_instrukcji();
        Stos_instrukcji s4 = new Stos_instrukcji();
        s3.dodaj(new Przypisanie_wartosci(p, new Literal_Calkowity(0)));
        s4.dodaj(new Print(k));
        s2.dodaj(new Rowne(new Modulo(k, i),new Literal_Calkowity(0),s3));
        s1.dodaj(new For(i,new Odejmowanie(k, new Literal_Calkowity(2)),s2));
        s1.dodaj(new Rowne(p,new Literal_Calkowity(1),s4));
        Stos_instrukcji s5 = new Stos_instrukcji();
        s5.dodaj(new BeginBlock(s1, prog));
        s5.dodaj(new End_Block(prog));
        s.dodaj(new For(k, new Odejmowanie(n, new Literal_Calkowity(1)), s5));
        prog.dodaj(new BeginBlock(s, prog));
        prog.dodaj(new End_Block(prog));
        Debugger d = new Debugger(prog);
        prog.run();
        prog.run_with_debugger(d);
    }
}

