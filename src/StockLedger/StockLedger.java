public class StockLedger {
    private DequeInterface<StockPurchase> ledger;

    public StockLedger() {
        ledger = new LinkedDeque<>();
    } //end default constructor

    public void buy(int sharesBought, double pricePerShare) {

        StockPurchase purchase = new StockPurchase(sharesBought, pricePerShare);
        ledger.addToBack(purchase);

    } // end buy

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
