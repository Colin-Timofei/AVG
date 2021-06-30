public class Main {
    public static void main(String[] args) {

        Token t = new Token("PewDiePie");

        t.fillALD(13);
        t.doStuff("meow","woof");
        System.out.println("\n" + t.getInspiration());

        for(int i = 0; i < 2; i++)
            t.getRickrolled('e');
    }
}
