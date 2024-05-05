import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MagicalArenaTest {
    @Test
    public void testFight() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        MagicalArena arena = new MagicalArena(playerA, playerB);
        arena.fight();
        assertTrue(playerA.getHealth() <= 0 || playerB.getHealth() <= 0);
    }
}
