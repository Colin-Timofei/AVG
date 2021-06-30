import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap <Integer, Integer> ns;
    static HashMap <Integer, String> even;
    static HashMap <Integer, String> uneven;
    static int mss;

    static {
        ns = new HashMap<Integer, Integer>();
        fillNS(ns);

        even = new HashMap <Integer, String>();
        buildEven(even);

        uneven = new HashMap <Integer, String>();
        buildUneven(uneven);

        mss = cTOi('d') + 900;
    }

    public static void main(String args[]) {

        int ch;

        do {
            showMenu();

            try {
                ch = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                ch = 0;
            }

            switch(ch) {
                case 1 : showSumN(); waitAbit(mss); break;
                case 2 : showEven(); waitAbit(mss); break;
                case 3 : showUneven(); waitAbit(mss); break;
                case 4 : showMessage(); waitAbit(mss); break;
                case 5 : break;
                default : defMsg("Nu ati ales o optiune valida","");
            }
        } while (ch != 5);
    }

    public static void showMenu() {
            System.out.println("Alege o optiune : ");
            System.out.println("1. Afiseaza suma tuturor numerelor piina la n");
            System.out.println("2. Afiseaza toate cifrele pare piina la n");
            System.out.println("3. Afiseaza toate cifrele impare piina la n");
            System.out.println("4. Afiseaza mesajul X de n ori");
            System.out.println("5. Iesire din program");
    }

    public static void showSumN() {
        System.out.println();
        System.out.println("Dati un numar intreg de la 0 piina la 65536 :");

        try {
            int n = new Scanner(System.in).nextInt();
            System.out.println();
            if(n <= 65535 && n >= 0)
                System.out.println("Suma numerelor piina la " + n + " este " + ns.get(n));
            else System.out.println("Nu ati introdus un numar acceptabil");
        } catch(Exception e) {
            System.out.println(errMsg1());
        }
    }

    public static void showEven() {
        System.out.println();
        System.out.println("Introduceti un numar intreg de la 0 la 128 :");

        try {
            int n = new Scanner(System.in).nextInt();
            System.out.println();
            if(n <= 127 && n >=0) {
                System.out.println("Toate numerele pare piina la " + n + " sunt :");
                System.out.println(even.get(n));
            }
            else System.out.println("Numarul nu este acceptabil");
        } catch(Exception e) {
            System.out.println(errMsg1());
        }
    }

    public static void showUneven() {
        System.out.println();
        System.out.println("Dati un numar intreg de la 0 piina la 128 :");

        try {
            int n = new Scanner(System.in).nextInt();
            System.out.println();
            if(n <= 127 && n >= 0) {
                System.out.println("Toate numerele impare piina la " + n + " sunt :");
                System.out.println(uneven.get(n));
            }
            else System.out.println("Numarul este acceptabil");
        } catch(Exception e) {
            System.out.println(errMsg1());
        }
    }

    public static void showMessage() {

        String msg;
        int rep;

        System.out.println();
        System.out.println("Introduceti mesajul :");

        try {
            msg = new Scanner(System.in).nextLine();
        } catch (Error e) {
            msg = "Data viitoare am sa introduc un mesaj valid";
        }

        System.out.println();
        System.out.println("Dati numarul de repetari (de la 1 la 10) :");

        try {
            rep = new Scanner(System.in).nextInt();
            if(rep < 1 || rep > 10) throw new Exception();
        } catch (Exception e) {
            msg = "Nu te juca cu focul !!!";
            rep = 3;
        }

        justSpamIt(msg,rep);
    }

    public static void fillNS(HashMap<Integer, Integer> hm) {
        for(int i = 0, s = 0; i < 65536; i++) {
            s += i;
            hm.put(i,s);
        }
    }

    public static void buildEven(HashMap <Integer, String> hm) {
        String res = "";
        String tmp;

        hm.put(0,"");

        for(int i = 0; i < 128; i++)
        {
            if(i % 2 == 0) {
                tmp = res;
                res = tmp + i + ", ";
            }

            hm.put(i+1, res.substring(0,res.length()-2));
        }
    }

    public static void buildUneven(HashMap <Integer, String> hm) {
        String res = "";
        String tmp;

        hm.put(0,"");
        hm.put(1,"");

        for(int i = 0; i < 128; i++)
        {
            if(i % 2 == 0) {
                tmp = res;
                res = tmp + (i + 1) + ", ";
            }
            hm.put(i+2, res.substring(0,res.length()-2));
        }
    }

    public static void justSpamIt(String s, int n) {
        System.out.println();
        for(int i = 0; i < n; i++)
            System.out.println(s);
    }

    public static int waitAbit(int ms) {

        System.out.println();

        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        return 0;
    }

    public static void defMsg(String s1, String s2){
        System.out.println(s1);
        System.out.println(s2);
    }

    public static String errMsg1() {
        return "Nu ati introdus un numar valid";
    }

    public static int cTOi(char a) {
        return (int) a;
    }
}