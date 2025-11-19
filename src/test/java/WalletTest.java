import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

class WalletTest {

    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new Wallet("Noir", "Gucci", 0.25);
    }

    @Test
    void testAddMoneyAndCheckMoney() {
        wallet.addMoney(100);
        assertEquals(100, wallet.getMoney(), 0.001);

        assertTrue(wallet.checkMoney(50));   // Suffisamment d'argent
        assertFalse(wallet.checkMoney(150)); // Pas assez
    }

    @Test
    void testAddMoneyNegativeAmountThrows() {
        assertThrows(IllegalArgumentException.class, () -> wallet.addMoney(0));
        assertThrows(IllegalArgumentException.class, () -> wallet.addMoney(-50));
    }

    @Test
    void testAddCardAndGetCards() {
        wallet.addCard("Visa");
        wallet.addCard("MasterCard");

        List<String> cards = wallet.getCards();
        assertEquals(2, cards.size());
        assertTrue(cards.contains("Visa"));
        assertTrue(cards.contains("MasterCard"));
    }

    @Test
    void testLoseWallet() {
        assertFalse(wallet.isLost());
        wallet.lose();
        assertTrue(wallet.isLost());
    }

    @Test
    void testUnmodifiableCardsList() {
        wallet.addCard("Visa");
        List<String> cards = wallet.getCards();
        assertThrows(UnsupportedOperationException.class, () -> cards.add("MasterCard"));
    }
}
