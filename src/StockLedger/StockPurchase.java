public class StockPurchase {
//getCostPerShare
//cost
    private int numberOfShares;
    private double costPerShare;

    public StockPurchase(int numberOfShares, double costPerShare) {
        this.numberOfShares = numberOfShares;
        this.costPerShare = costPerShare;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public double getCostPerShare() {
        return costPerShare;
    }
}
