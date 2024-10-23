import java.util.ArrayList;
import java.util.List;

/**
 * One ledger entry for a specific stock symbol, tracks owned and stock purchases.
 */

public class LedgerEntry {
    private String stockSymbol;
    private int totalShares;
    private List<StockPurchase> purchases;

    /**
     * Creates a new LedgerEntry, with a stock symbol.
     * @param stockSymbol the symbol for the stock entry
     */

    public LedgerEntry(String stockSymbol) {
        this.stockSymbol = stockSymbol;
        this.totalShares = 0;
        this.purchases = new ArrayList<>();
    } //contructor

    /**
     * Adds a stock purchase to the ledger entry.
     * Updates the total number of shares owned.
     * @param purchase the stock purchase that will be added
     */

    //Adds a stock purchase to the ledger entry
    public void addPurchase(StockPurchase purchase) {
        purchases.add(purchase);
        totalShares += purchase.getNumberOfShares();
    }

    /**
     * Removes shares from the ledger entry.
     * Removes shares until they're all accounted for or there
     * aren't purchases left.
     * @param sharesSold number of shares to remove
     */

    //removes shares from the ledger entry
    public void removeShares(int sharesSold) {
        while (sharesSold > 0 && !purchases.isEmpty()) {
            StockPurchase purchase = purchases.get(0); //gets first purchase
            int sharesAvailable = purchase.getNumberOfShares();

            if (sharesAvailable > sharesSold) {
                purchase = new StockPurchase(sharesAvailable - sharesSold, purchase.getCostPerShare());
                purchases.set(0, purchase); // update the existing purchase
                sharesSold = 0; // All shares sold
            } else {
                sharesSold -= sharesAvailable; //deduct sold shares
                purchases.remove(0);
            }
        }
        totalShares -= (sharesSold < 0) ? 0 : sharesSold;

    }

    /**
     * returns the total number of shares owned
     * @return the total number of shares
     */

    public int getTotalShares() {
        return totalShares;
    }

    /**
     * Returns the stock symbol associates with the entry.
     * @return stock symbol
     */

    public String getStockSymbol() {
        return stockSymbol;
    }
}
