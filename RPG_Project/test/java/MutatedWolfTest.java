import org.example.enemy_and_sub.MutatedWolf;
import org.example.enemy_and_sub.ThePhantomKing;
import org.example.moves.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MutatedWolfTest {
    @Test
    public void takeDamage_test1() {
        MutatedWolf w1 = new MutatedWolf("MutatedWolf", 100, 100);
        w1.takeDamage(2, Move.Type.Physical);

        Assertions.assertEquals(96, w1.getHealth());
    }

    @Test
    public void takeDamage_test2() {
        MutatedWolf w1 = new MutatedWolf("MutatedWolf2", 100, 100);
        w1.takeDamage(2, Move.Type.Ghost);

        Assertions.assertEquals(98, w1.getHealth());
    }
}
