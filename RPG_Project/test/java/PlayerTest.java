import org.example.human_and_sub.Warrior;
import org.example.moves.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void isAlive_test1() {
        Warrior w1 = new Warrior("Usman");
        w1.takeDamage(100, Move.Type.Physical);
        Assertions.assertFalse(w1.isAlive());
    }

    @Test
    public void isAlive_test2() {
        Warrior w1 = new Warrior("Usman");
        w1.takeDamage(10, Move.Type.Physical);
        Assertions.assertTrue(w1.isAlive());
    }
}
