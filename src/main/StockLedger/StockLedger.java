/**
 * Manages a ledger of stock purchases
 */

public class StockLedger {
    private DequeInterface<StockPurchase> ledger;

    /**
     * Contructs a new empty stockledger instance.
     */

    public StockLedger() {
        ledger = new LinkedDeque<>();
    } //end default constructor

    /**
     * Records the users share purchases
     * @param sharesBought the number of shares purchased
     * @param pricePerShare the price per share
     */

    public void buy(int sharesBought, double pricePerShare) {

        StockPurchase purchase = new StockPurchase(sharesBought, pricePerShare);
        ledger.addToBack(purchase);

    } // end buy

    /**
     * Sells a speciic number of shares and does the math for
     * the loss or profit from the sale
     * @param sharesSold number of shares to be sold
     * @param pricePerShare the price per share that the stick is sold at
     * @return the profit or loss from the sale
     */

    public double sell(int sharesSold, double pricePerShare) {
        double saleAmount = sharesSold * pricePerShare;
        double totalCost = 0;

        while (sharesSold > 0) {
            StockPurchase transaction = ledger.removeFront();
            double shareCost = transaction.getCostPerShare();
            int numberOfShares = transaction.getNumberOfShares();

            if (numberOfShares > sharesSold) {
                totalCost = totalCost + sharesSold * shareCost;
                int numberToPutBack = numberOfShares - sharesSold;
                StockPurchase leftover = new StockPurchase(numberToPutBack, shareCost);

                ledger.addToFront(leftover); //return left over shares
            } else {
                totalCost = totalCost + numberOfShares * shareCost;
            sharesSold = sharesSold - numberOfShares;
            }
        }
        return saleAmount - totalCost;
    } // end sell

} // end stockledger
