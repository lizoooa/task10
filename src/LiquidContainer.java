public class LiquidContainer extends Container implements IHazardNotifier {
    private boolean hazardous;

    public LiquidContainer(int loadWeight, int height, int tareWeight, int depth, int maxLoad, boolean hazardous) {
        super(loadWeight, height, tareWeight, depth, maxLoad, "L");
        this.hazardous = hazardous;
    }

    @Override
    public void load(int weight) throws Exception {
        int limit = hazardous ? (int)(maxLoad * 0.5) : (int)(maxLoad * 0.9);
        if (weight > limit) {
            notifyHazard("Hazardous overfill in " + serialNumber);
            throw new Exception("OverfillException");
        }
        loadWeight = weight;
    }

    @Override
    public void notifyHazard(String message) {
        System.out.println("[ALERT - LIQUID] " + message);
    }
}