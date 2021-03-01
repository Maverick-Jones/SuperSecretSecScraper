import java.io.PrintWriter;
import java.io.IOException;

//runner class
public class Main {

  public static void main(String[] args) throws IOException {
    // print title
    System.out.println("----------------------------");
    System.out.println("The Super Secret SEC Scraper");
    System.out.println("   Ming DeMers | Feb 2021");
    System.out.println("----------------------------");
    System.out.println("Begin Test...");

    // URL that will be accessed
    String myURL = "https://www.sec.gov/cgi-bin/browse-edgar?action=getcurrent&CIK=&type=D&company=&dateb=&owner=include&start=0&count=100&output=atom";
    System.out.println("URL used: " + myURL);

    // Open the file.
    PrintWriter out = new PrintWriter("SECData.txt");

    // write title and url to .txt
    out.println("----------------------------");
    out.println("The Super Secret SEC Scraper");
    out.println("   Ming DeMers | Feb 2021");
    out.println("----------------------------");
    out.println("URL used: " + myURL + "\n");

    //create validity object; NOT USED
    Validity myCompany = new Validity(myURL);
    //not used atm
    myCompany.checkValidName();
    if (myCompany.valid==false)
      System.out.println("False");
    else
      System.out.println("True");
         
    // print RSS feed to txt file
    out.println(ReadRSS.getFormD(myURL));
    out.close(); // TODO ensure it prints properly
    System.out.println("File write done.");

    // console print the data, too
    System.out.println(ReadRSS.getFormD(myURL));


    //testing for now...
    String aRandomURL = "https://www.sec.gov/Archives/edgar/data/1848053/000090571821000329/primary_doc.xml";

    System.out.println(ReadRSS.getCompanyFile(ReadRSS.getFormURL(aRandomURL)));
    System.out.println(ReadRSS.getFormURL(aRandomURL));




  }
}
