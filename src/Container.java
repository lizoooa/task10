public abstract class Container {
    private static int counter = 1;

    protected String serialNumber;
    protected int loadWeight;
    protected int height;
    protected int tareWeight;
    protected int depth;
    protected int maxLoad;

    public Container(int loadWeight, int height, int tareWeight, int depth, int maxLoad, String typeCode) {
        this.loadWeight = loadWeight;
        this.height = height;
        this.tareWeight = tareWeight;
        this.depth = depth;
        this.maxLoad = maxLoad;
        this.serialNumber = "KON-" + typeCode + "-" + counter++;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getTotalWeight() {
        return loadWeight + tareWeight;
    }

    public void unload() {
        loadWeight = 0;
    }

    public void load(int weight) throws Exception {
        if (weight > maxLoad) {
            throw new Exception("OverfillException: too much load");
        }
        loadWeight = weight;
    }
}