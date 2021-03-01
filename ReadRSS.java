import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

//class that contains methods to work with the RSS feed
public class ReadRSS {
  // method to return the titles of Form D's
  public static String getFormD(String urlAddress) {
    try {
      URL rssUrl = new URL(urlAddress);
      BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
      String sourceCode = "";
      String line;
      int n = 0;
      // loop to add all titles and data
      while ((line = in.readLine()) != null) {
        int endIndex = 0;
        int startIndex = 0;
        while (startIndex >= 0) {
          startIndex = line.indexOf("<title>", endIndex);
          // used once to print heading
          if (startIndex >= 0 && n == 0) {
            endIndex = line.indexOf("</title>", startIndex);
            sourceCode += line.substring(startIndex + "<title>".length(), endIndex) + "\n";
            n++;
          }
          // statement to grab form id and title of company
          else if (startIndex >= 0) {
            endIndex = line.indexOf("</title>", startIndex);
            sourceCode += "Entry #" + n + ": " + line.substring(startIndex + "<title>".length(), endIndex) + "\n";
            n++;
            // statement to grab the direct link for further research
          }
          startIndex = line.indexOf("href=\"", endIndex);
          if (startIndex >= 0) {
            endIndex = line.indexOf("\"/>", startIndex);
            sourceCode += line.substring(startIndex + "href=\"".length(), endIndex) + "\n\n";
          }
        }
      }
      in.close();
      return sourceCode;
      // exceptions if URL doesn't exist or can't find title tags
    } catch (MalformedURLException ue) {
      System.out.println("Malformed URL");
    } catch (IOException ioe) {
      System.out.println("Something went wrong reading the contents");
    }
    return null; // in such case, return nothing
  }

  // small method to return the D form in HTML readable format
  public static String getFormURL(String URLAdress) {
    String formDURL = URLAdress.substring(0, (URLAdress.lastIndexOf("/"))) + "/primary_doc.xml";
    return formDURL; 
  }

  // method to return the file of a selected company
  public static String getCompanyFile(String myURL) {
      try {
        URL formURL = new URL(myURL);
        BufferedReader in = new BufferedReader(new InputStreamReader(formURL.openStream()));
        String formD = "";
        String line;
        int startIndex = 0;
        int endIndex = 0;
      
        while ((line = in.readLine()) != null) {
          System.out.println(line);
          startIndex = line.indexOf("<issuerAddress>", endIndex);
          if (startIndex >= 0) {
            endIndex = line.indexOf("</issuerAddress>", startIndex);
            formD += line.substring(startIndex + "<issuerAddress>".length(), endIndex) + "\n";

          }
        }
        in.close();
        return formD;

        //exceptions if URL doesn't exist or can't find title tags
    } catch (MalformedURLException ue){
        System.out.println("Malformed URL");
    } catch (IOException ioe){
        System.out.println("Something went wrong reading the contents");
    }
    return null; //in such case, return nothing
  }
  
}