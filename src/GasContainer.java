public class GasContainer extends Container implements IHazardNotifier {
    private double pressure;

    public GasContainer(int loadWeight, int height, int tareWeight, int depth, int maxLoad, double pressure) {
        super(loadWeight, height, tareWeight, depth, maxLoad, "G");
        this.pressure = pressure;
    }

    @Override
    public void unload() {
        loadWeight = (int)(loadWeight * 0.05); // zostaje 5%
    }

    @Override
    public void load(int weight) throws Exception {
        if (weight > maxLoad) {
            notifyHazard("Overfill in gas container: " + serialNumber);
            throw new Exception("OverfillException");
        }
        loadWeight = weight;
    }

    @Override
    public void notifyHazard(String message) {
        System.out.println("[ALERT - GAS] " + message);
    }
}