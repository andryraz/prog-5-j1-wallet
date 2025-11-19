import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wallet {

    private String color;
    private List<String> cardHolder = new ArrayList<>();
    private String brand;
    private double weight;
    private double money;
    private boolean lost = false;

    public Wallet(String color, String brand, double weight) {
        this.color = color;
        this.brand = brand;
        this.weight = weight;
    }

    public void addMoney(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        this.money += amount;
    }

    public boolean checkMoney(double amount) {
        return this.money >= amount;
    }

    public void addCard(String card) {
        if (card != null && !card.trim().isEmpty()) {
            this.cardHolder.add(card);
        }
    }

    public void lose() {
        this.lost = true;
    }

    public List<String> getCards() {
        return Collections.unmodifiableList(cardHolder);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMoney() {
        return money;
    }

    public boolean isLost() {
        return lost;
    }

}
