import java.util.Objects;

public final class Drink implements Item{
    private final double cost;
    private final String drinkName;
    private final String description;

    public Drink(String drinkName, String description) throws IllegalArgumentException{
        if (Objects.equals(drinkName, ""))
            throw new IllegalArgumentException("The name cannot be empty");
        if (Objects.equals(description, ""))
            throw new IllegalArgumentException("The description cannot be empty");

        this.cost = 0;
        this.drinkName = drinkName;
        this.description = description;
    }

    public Drink(double cost, String drinkName, String description) {
        if (cost < 0) {
            throw new IllegalArgumentException("The price cannot be negative");
        }
        if (Objects.equals(drinkName, "")) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (Objects.equals(description, "")) {
            throw new IllegalArgumentException("The description cannot be empty");
        }

        this.cost = cost;
        this.drinkName = drinkName;
        this.description = description;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return drinkName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "cost=" + cost +
                ", drinkName='" + drinkName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

