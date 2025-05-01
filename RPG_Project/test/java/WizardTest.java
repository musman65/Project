import org.example.human_and_sub.Warrior;
import org.example.human_and_sub.Wizard;
import org.example.moves.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WizardTest {
    @Test
    public void takeDamage_test1() {
        Wizard w1 = new Wizard("Usman");
        w1.takeDamage(2, Move.Type.Physical);

        Assertions.assertEquals(96, w1.getHealth());
    }

    @Test
    public void takeDamage_test2() {
        Wizard w1 = new Wizard("Usman");
        w1.takeDamage(2, Move.Type.Ghost);

        Assertions.assertEquals(98, w1.getHealth());
    }
}
