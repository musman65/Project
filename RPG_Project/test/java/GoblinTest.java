import org.example.enemy_and_sub.Goblin;
import org.example.human_and_sub.Wizard;
import org.example.moves.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoblinTest {
    @Test
    public void takeDamage_test1() {
        Goblin w1 = new Goblin("Goblin1", 100, 100);
        w1.takeDamage(2, Move.Type.Physical);

        Assertions.assertEquals(96, w1.getHealth());
    }

    @Test
    public void takeDamage_test2() {
        Goblin w1 = new Goblin("Goblin2", 100, 100);
        w1.takeDamage(2, Move.Type.Ghost);

        Assertions.assertEquals(98, w1.getHealth());
    }
}
