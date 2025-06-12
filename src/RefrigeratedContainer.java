public class RefrigeratedContainer extends Container {
    private String productType;
    private double temperature;

    public RefrigeratedContainer(int loadWeight, int height, int tareWeight, int depth, int maxLoad,
                                 String productType, double temperature) {
        super(loadWeight, height, tareWeight, depth, maxLoad, "C");
        this.productType = productType;
        this.temperature = temperature;
    }
}