import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Token {
    String obj_name;
    ArrayList <LocalDateTime> ald;
    Random rand;
    boolean visible;

    Token(String nm) {
        obj_name = nm;
        ald = new ArrayList<LocalDateTime>();
        visible = true;
    }

    int fillALD(int m) {

        if (m > 0) {
            rand = new Random();

            for(int i = 0; i < m; i++)
            {
                long x = rand.nextInt(256)*1000;
                for(long j = 0; j < x; j++);
                ald.add(LocalDateTime.now());
            }
        }

        return 0;
    }

    void doStuff(String s1, String s2) {

        for(int i = 0; i < 10; i++)
            fillALD(12);

        System.out.println("Take what you can, give nothing back");

        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        ald.forEach(date -> System.out.println(date));

        System.out.println();
        getRickrolled('a');
    }

    String getInspiration() {
        String[] q = {
                "The purpose of our lives is to be happy",
                "Life is what happens when you’re busy making other plans",
                "Get busy living or get busy dying",
                "You only live once, but if you do it right, once is enough",
                "Many of life’s failures are people who did not realize how close they were to success when they gave up",
                "If you want to live a happy life, tie it to a goal, not to people or things",
                "Never let the fear of striking out keep you from playing the game",
                "Money and success don’t change people; they merely amplify what is already there",
                "Your time is limited, so don’t waste it living someone else’s life. Don’t be trapped by dogma – which is living with the results of other people’s thinking",
                "Not how long, but how well you have lived is the main thing"
        };

        return q[rand.nextInt(10)];
    }

    int getRickrolled(char s) {
        System.out.println("Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you");

        visible = false;

        return ((int)s + 8);
    }
}