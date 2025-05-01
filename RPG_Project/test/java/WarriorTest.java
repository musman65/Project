import org.example.human_and_sub.Warrior;
import org.example.moves.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WarriorTest {
    @Test
    public void takeDamage_test1() {
        Warrior w1 = new Warrior("Usman");
        w1.takeDamage(2, Move.Type.Physical);

        Assertions.assertEquals(98, w1.getHealth());
    }

    @Test
    public void takeDamage_test2() {
        Warrior w1 = new Warrior("Usman");
        w1.takeDamage(2, Move.Type.Ghost);

        Assertions.assertEquals(96, w1.getHealth());
    }
}
