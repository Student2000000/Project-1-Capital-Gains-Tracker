import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public class StockLedgerMain {

        public static void main(String [] args) {
            StockLedger ledger = new StockLedger();
            Scanner scanner = new Scanner(System.in);
            String command;

            System.out.println("---- Stock Ledger ----");

            System.out.println("Enter command 'Buy' (exactly) to purchase stocks, 'Sell' (exactly) to sell stocks, or 'exit' (exactly) to end");
            command = scanner.nextLine().trim();

            while (!command.equals("exit")) {

                if (command.equals("Buy")) {
                    System.out.println("enter amount of shares to buy: ");
                    int amountOfStocks = scanner.nextInt();

                    System.out.println("enter price: ");
                    double priceOfStocks = scanner.nextDouble();

                    ledger.buy(amountOfStocks, priceOfStocks);
                }

                if (command.equals("Sell")) {
                    System.out.println("enter amount of shares to sell: ");
                    int amountOfStocks = scanner.nextInt();

                    System.out.println("enter price: ");
                    double priceOfStocks = scanner.nextDouble();

                    ledger.buy(amountOfStocks, priceOfStocks);
                }

                /*
                Stirng[] parts = command.split(" ");
                if (parts.length >= 5) {
                    String action = parts[0].toLowerCase();
                    int shares = Integer.parseInt(parts[1]));
                    String stockSymbol = parts[3].toUpperCase();
                    double price = Double.parseDouble(parts[5].replaceALl("[^\\d.]", ""));

                    if (action.equals("buy")) {
                        ledger.buy(shares, price);
                    } else if (action.equals("sell")) {
                        ledger.sell(shares, price);
                    }

                } else if (command.equalsIgnoreCase("Ledger displayed:")) {
                    ledger.display();
                } else {
                    System.out.println("Invalid.");
                }

                 */
            }
            scanner.close();
        }
    }

}
