import org.example.human_and_sub.Warrior;
import org.example.items.Armor;
import org.example.items.Weapon;
import org.example.moves.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class HumanTest {
    @Test
    public void equipItem_test1() {
        Warrior w1 = new Warrior("Usman");
        Armor a1 = new Armor("Steel Armor", "description", "Rare", 0.90f);
        w1.addItemToInventory(a1);
        w1.equipItem(a1);

        Assertions.assertEquals(110, w1.getMaxHealth());
    }

    @Test
    public void equipItem_test2() {
        Warrior w1 = new Warrior("Usman");
        Armor a1 = null;
        w1.addItemToInventory(a1);
        w1.equipItem(a1);

        Assertions.assertEquals(100, w1.getMaxHealth());
    }

    @Test
    public void equipItem_test3() {
        Warrior w1 = new Warrior("Usman");
        Armor a1 = new Armor("Steel Armor", "description", "Rare", 0.90f);
        w1.equipItem(a1);

        Assertions.assertEquals(100, w1.getMaxHealth());
    }


}
