import java.util.Objects;

public final class Dish implements Item {
    private final double cost;
    private final String name;
    private final String description;

    public Dish(String name, String description) throws IllegalArgumentException {
        if (Objects.equals(name, "")) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (Objects.equals(description, "")) {
            throw new IllegalArgumentException("The description cannot be empty");
        }
        this.cost = 0;
        this.name = name;
        this.description = description;
    }

    public Dish(double cost, String name, String description) throws IllegalArgumentException {
        if (cost < 0) {
            throw new IllegalArgumentException("The price cannot be negative");
        }
        if (Objects.equals(name, "")) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (Objects.equals(description, "")) {
            throw new IllegalArgumentException("The description cannot be empty");
        }

        this.cost = cost;
        this.name = name;
        this.description = description;
    }


    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Dish setCost(double cost) {
        return new Dish(cost, this.name, this.description);
    }

    public Dish setName(String name) {
        return new Dish(this.cost, name, this.description);
    }

    public Dish setDescription(String description) {
        return new Dish(this.cost, this.name, description);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
