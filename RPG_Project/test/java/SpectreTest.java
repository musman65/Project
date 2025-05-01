import org.example.enemy_and_sub.Goblin;
import org.example.enemy_and_sub.Spectre;
import org.example.moves.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpectreTest {
    @Test
    public void takeDamage_test1() {
        Spectre w1 = new Spectre("Spectre1", 100, 100);
        w1.takeDamage(2, Move.Type.Physical);

        Assertions.assertEquals(98, w1.getHealth());
    }

    @Test
    public void takeDamage_test2() {
        Spectre w1 = new Spectre("Spectre2", 100, 100);
        w1.takeDamage(2, Move.Type.Ghost);

        Assertions.assertEquals(96, w1.getHealth());
    }
}
