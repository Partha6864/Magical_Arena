public class MagicalArena {
    private Player playerA;
    private Player playerB;
    private Dice attackingDice;
    private Dice defendingDice;

    public MagicalArena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.attackingDice = new Dice();
        this.defendingDice = new Dice();
    }

    public void fight() {
        while (playerA.getHealth() > 0 && playerB.getHealth() > 0) {
            // Player A attacks first
            int attackRollA = attackingDice.roll();
            int defenseRollB = defendingDice.roll();
            int damageA = playerA.getAttack() * attackRollA;
            int defenseB = playerB.getStrength() * defenseRollB;
            int damageDealtA = Math.max(0, damageA - defenseB);
            playerB.reduceHealth(damageDealtA);

            if (playerB.getHealth() <= 0) {
                System.out.println("Player A wins!");
                break;
            }

            // Player B attacks
            int attackRollB = attackingDice.roll();
            int defenseRollA = defendingDice.roll();
            int damageB = playerB.getAttack() * attackRollB;
            int defenseA = playerA.getStrength() * defenseRollA;
            int damageDealtB = Math.max(0, damageB - defenseA);
            playerA.reduceHealth(damageDealtB);

            if (playerA.getHealth() <= 0) {
                System.out.println("Player B wins!");
                break;
            }
        }
    }
}
