import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        addFile();
    }
    static int lineCounteer() throws FileNotFoundException {
        Scanner scanner1 = new Scanner(new File("data.csv"));
        int i = 0;
        while (scanner1.hasNext()) {
            scanner1.nextLine();
            i++;
        }
        scanner1.close();
        return i;
    }

    static void addFile() throws FileNotFoundException{
        Scanner scanner2 = new Scanner(new File("data.csv"));
        int j = 0;
        String[] products = new String[lineCounteer()];
        String[] producers = new String[lineCounteer()];
        double[] prices = new double[lineCounteer()];
        while (scanner2.hasNext()) {
            String[] wyrazy = scanner2.nextLine().split(";");
            products[j] = wyrazy[0];
            producers[j] = wyrazy[1];
            prices[j] = Double.parseDouble(wyrazy[2]);
            j++;
        }
        sumprices(prices);
        maxprice(prices);
    }

    static void sumprices(double[] prices){
        double sum = 0;
        for (int k = 0; k < prices.length; k++) {
            sum = sum + prices[k];
        }
        System.out.println(Math.round(sum));
    }

    static void maxprice(double[] prices){
        double max = 0;
        for (int l = 0; l < prices.length; l++) {
            if (prices[l] > max)
                max = prices[l];
        }
        System.out.println(max);
    }
}
