import java.io.PrintWriter;
import java.io.IOException;

//runner class
public class Main {

    public static void main(String[] args) throws IOException {
        //print title
        System.out.println("----------------------------");
        System.out.println("The Super Secret SEC Scraper");
        System.out.println("   Ming DeMers | Feb 2021");
        System.out.println("----------------------------");
        System.out.println("Begin Test...");
				//URL that will be accessed
        String myURL = "https://www.sec.gov/cgi-bin/browse-edgar?action=getcurrent&CIK=&type=D&company=&dateb=&owner=include&start=0&count=100&output=atom";
        System.out.println("URL used: " + myURL);
        // Open the file.
        PrintWriter out = new PrintWriter("SECData.txt"); //TODO make it so it appends!
        //write title and url
        out.println("----------------------------");
        out.println("The Super Secret SEC Scraper");
        out.println("   Ming DeMers | Feb 2021");
        out.println("----------------------------");
        out.println("URL used: " + myURL + "\n");

        //print RSS feed to txt file
        out.println(ReadRSS.readRSSFeed(myURL));
        out.close(); //TODO ensure it prints properly
				System.out.println("File write done.");

        //print out the data, too
        System.out.println(ReadRSS.readRSSFeed(myURL));

				Validity myCompany = new Validity("LLC");
				//System.out.println(Validity.checkCompany());

				
        //todo add a "points system" to ensure which is most helpful, etc.

    }
}
