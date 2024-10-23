/**
 * Represents a stock purchase with the number of shares and its
 * cost.
 */

public class StockPurchase {
//getCostPerShare
//cost
    private int numberOfShares;
    private double costPerShare;

    /**
     * Contructs a StockPurchase object with the number of shares and cost
     * @param numberOfShares the number of shares being purchased
     * @param costPerShare the cost per share
     */

    public StockPurchase(int numberOfShares, double costPerShare) {
        this.numberOfShares = numberOfShares;
        this.costPerShare = costPerShare;
    }

    /**
     * Returns the number of shares purchased.
     * @return the number of shares
     */

    public int getNumberOfShares() {
        return numberOfShares;
    }

    /**
     * Returns the cost per share
     * @return the cost per share
     */

    public double getCostPerShare() {
        return costPerShare;
    }
}
