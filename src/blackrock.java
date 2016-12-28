import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class portfolio {
    String ticker;
    String name;
    int quantity;
    String balance;
    String type;
    double price;
    double percentNav;
}

class benchmark {
    String ticker;
    String name;
    int quantity;
    double price;
    double percentNav;
}

class transactions {
    portfolio[] portfolioArray;
    benchmark[] benchmarkArray;
    int length = 0;

    transactions(int a, int b) {
        this.portfolioArray = new portfolio[a];
        this.benchmarkArray = new benchmark[b];
        this.length = a;
        for (int i = 0; i < length; i++) {
            this.portfolioArray[i] = new portfolio();
            this.benchmarkArray[i] = new benchmark();
        }
    }

    portfolio getPortfolio(int i) {
        return this.portfolioArray[i];
    }

    benchmark getBenchmark(int i) {
        return this.benchmarkArray[i];
    }
}

public class blackrock {
    public static String SEPARATOR = "@";
    public static final String COLON = ":";

    /*
     * Complete the function below.
     *
 	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */

    static String prettyPrint() {
        String input = "RIO,RIO TINTO PLC,746@AAL,ANGLO AMERICAN PLC,271:RIO,RIO TINTO PLC,688,13.9@AAL,ANGLO AMERICAN PLC,293,49.7";
        String[] str = input.split(COLON);
        String res = "";
        String[] portfolioArray = str[0].split(SEPARATOR);
        Arrays.sort(portfolioArray, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.split(",")[0].compareTo(s2.split(",")[0]);
            }
        });

        String[] benchmarkArray = str[1].split(SEPARATOR);
        Arrays.sort(benchmarkArray, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.split(",")[0].compareTo(s2.split(",")[0]);
            }
        });

        transactions ts = new transactions(portfolioArray.length, benchmarkArray.length);

        DecimalFormat df = new DecimalFormat("##.00");
        double pNavP = 0, pNavB = 0;
        // Setting all transactions
        for (int i = 0; i < ts.length; i++) {
            String[] temp = portfolioArray[i].split(",");
            ts.getPortfolio(i).ticker = temp[0];
            ts.getPortfolio(i).name = temp[1];
            ts.getPortfolio(i).quantity = Integer.parseInt(temp[2]);


            String[] temp2 = benchmarkArray[i].split(",");
            ts.getBenchmark(i).ticker = temp2[0];
            ts.getBenchmark(i).name = temp2[1];
            ts.getBenchmark(i).quantity = Integer.parseInt(temp2[2]);
            ts.getBenchmark(i).price = Double.parseDouble(temp2[3]);

            pNavP += ts.getBenchmark(i).price * ts.getPortfolio(i).quantity;
            pNavB += ts.getBenchmark(i).price * ts.getBenchmark(i).quantity;

            int diff = ts.getPortfolio(i).quantity - ts.getBenchmark(i).quantity;
            if (diff < 0) {
                ts.getPortfolio(i).type = "BUY";
                diff *= (-1);
            } else
                ts.getPortfolio(i).type = "SELL";
            ts.getPortfolio(i).balance = df.format(diff);
        }

        for (int i = 0; i < ts.length; i++) {
            ts.getPortfolio(i).percentNav = (ts.getPortfolio(i).quantity * ts.getBenchmark(i).price) / pNavP;
            ts.getBenchmark(i).percentNav = (ts.getBenchmark(i).quantity * ts.getBenchmark(i).price) / pNavB;
        }

        // Getting all transactions
        for (int i = 0; i < ts.length; i++) {
            if (i != 0)
                res += ", ";
            res += "[" + ts.getPortfolio(i).type + ", " + ts.getPortfolio(i).ticker + ", " + ts.getPortfolio(i).balance + "]";
        }
        System.out.println(res);

        return res;
    }
}
//[BUY, AAL, 18.51]
//[SELL, RIO, 66.19]
