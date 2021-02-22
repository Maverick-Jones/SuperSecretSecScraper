import java.util.ArrayList;

public class Validity { 
	//class variables
	String companyName;
	public boolean valid = true;
	int objPoints = 0;
	String registration;
	int amountSold = 0;
	int points = 0;
	int i;

	//two lists to containing words of interest
	ArrayList<String> buzzWord = new ArrayList<>();
	ArrayList<String> badWord = new ArrayList<>();

	public void addWords() {
		buzzWord.add("health");
		buzzWord.add("happiness");

		badWord.add("LLC");
		badWord.add("CORP");
		badWord.add("INC");
	}

	//object constructor
	public Validity(String name) {
		this.companyName = name;
	}

	//envokes all following methods for points and valididity
	public int checkCompany () {
		checkValid();
		checkBuzzwords();
		
		return points;
	}

	//check to see if the name involves badWords, which automatically DQ's the company
	public void checkValid() {
		for (i=0; i<badWord.size(); i++) {
			if (companyName.contains(badWord.get(i)))
				valid = false;
		}
	}

	//checking for buzzWord, adds a "point" if there is one
	public void checkBuzzwords () {
		for (i=0; i<buzzWord.size(); i++) {
			if (companyName.contains(buzzWord.get(i)))
				points++;
		}
	}

	//returns amount processed in the sale
	public void findAmountSold (){

	}

}
