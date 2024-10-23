import java.util.ArrayList;
import java.util.List;

public class LedgerEntry {
    private String stockSymbol;
    private int totalShares;
    private List<StockPurchase> purchases;

    //contructor
    public LedgerEntry(String stockSymbol) {
        this.stockSymbol = stockSymbol;
        this.totalShares = 0;
        this.purchases = new ArrayList<>();
    }

    //Adds a stock purchase to the ledger entry
    public void addPurchase(StockPurchase purchase) {
        purchases.add(purchase);
        totalShares += purchase.getNumberOfShares();
    }

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
    public int getTotalShares() {
        return totalShares;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }
}
