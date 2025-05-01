import org.example.enemy_and_sub.Spectre;
import org.example.enemy_and_sub.ThePhantomKing;
import org.example.moves.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThePhantomKingTest {
    @Test
    public void takeDamage_test1() {
        ThePhantomKing w1 = new ThePhantomKing("ThePhantomKing1", 100, 100);
        w1.takeDamage(2, Move.Type.Physical);

        Assertions.assertEquals(98, w1.getHealth());
    }

    @Test
    public void takeDamage_test2() {
        ThePhantomKing w1 = new ThePhantomKing("ThePhantomKing2", 100, 100);
        w1.takeDamage(2, Move.Type.Ghost);

        Assertions.assertEquals(98, w1.getHealth());
    }
}
