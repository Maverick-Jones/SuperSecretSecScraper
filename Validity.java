import java.util.ArrayList;

public class Validity {
	// class variables
	String companyName;
	public boolean valid = true;
	int points = 0;
	int i;

	// two lists to containing words of interest
	ArrayList<String> buzzWord = new ArrayList<>();
	ArrayList<String> badWord = new ArrayList<>();

	public void addWords() {
		buzzWord.add("health");
		buzzWord.add("happiness");

		badWord.add("LLC");
		badWord.add("CORP");
		badWord.add("INC");
	}

	// object constructor
	public Validity(String str) {
		this.companyName = str;
	}

	// envokes all following methods for points and valididity
	public void checkValidName() {
		for (i = 0; i < badWord.size() && valid == true; i++) {
			if (companyName.contains(badWord.get(i)))
				valid = false;
		}
	}

	// checking for buzzWord, adds a "point" if there is one
	public void checkBuzzwords() {
		for (i = 0; i < buzzWord.size(); i++) {
			if (companyName.contains(buzzWord.get(i)))
				points++;
		}
	}

	// returns amount processed in the sale
	public void findAmountSold() {

	}

}
