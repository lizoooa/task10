import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int maxSpeed;
    private int maxContainers;
    private int maxWeight;
    private List<Container> containers;

    public Ship(int maxSpeed, int maxContainers, int maxWeight) {
        this.maxSpeed = maxSpeed;
        this.maxContainers = maxContainers;
        this.maxWeight = maxWeight;
        this.containers = new ArrayList<>();
    }

    public void addContainer(Container container) throws Exception {
        if (containers.size() >= maxContainers) {
            throw new Exception("Too many containers.");
        }

        int total = container.getTotalWeight();
        for (Container c : containers) {
            total += c.getTotalWeight();
        }

        if (total > maxWeight) {
            throw new Exception("Ship overload.");
        }

        containers.add(container);
    }

    public List<Container> getContainers() {
        return containers;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxContainers() {
        return maxContainers;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}