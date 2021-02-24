import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

//Grabs from an RSS and converts to string for printing to txt
public class ReadRSS {
    //method to return the titles of Form D's (TODO divide the labour here)
    public static String readRSSFeed(String urlAddress) {
        try{
            URL rssUrl = new URL (urlAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            String sourceCode = "";
            String line;
						int n = 0;

						//Seperate this method from the while loops, make them its own method called findName or something

            //loop to add all titles and data
            while ((line = in.readLine()) != null) {
							  int endIndex = 0;
                int startIndex = 0;
                while (startIndex >= 0) {
                    startIndex = line.indexOf("<title>", endIndex);
										//used once to print heading
										if (startIndex >= 0 && n == 0) {
                        endIndex = line.indexOf("</title>", startIndex);
                        sourceCode += line.substring(startIndex + "<title>".length(), endIndex) + "\n";
												n++;
                    }
										//statement to grab form id and tite of company
                    else if (startIndex >= 0) {
                        endIndex = line.indexOf("</title>", startIndex);
                        sourceCode += "Entry #" + n + ": " + line.substring(startIndex + "<title>".length(), endIndex) + "\n";//parse and print the title (incld #)
												n++;
										//statement to grab the direct link for further research
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
        //exceptions if URL doesn't exist or can't find title tags
        } catch (MalformedURLException ue){
            System.out.println("Malformed URL");
        } catch (IOException ioe){
            System.out.println("Something went wrong reading the contents");
        }
        return null; //in such case, return nothing
    }
}