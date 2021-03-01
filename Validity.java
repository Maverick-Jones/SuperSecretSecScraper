import java.util.ArrayList;

// class to check/assign points/disqualify companies
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
		for (i = 0; i < badWord.size() && (valid == true); i++) {
			if (companyName.contains(badWord.get(i)))
				valid = false;
		}
	}

	// checking for buzzWord, adds a "point" if there is one
	public void checkBuzzwords() {
		for (i = 0; i < buzzWord.size() && (valid == true); i++) {
			if (companyName.contains(buzzWord.get(i)))
				points++;
		}
	}

	// returns amount processed in the sale
	public int getAmountSold() {
		int amountSold;

		return amountSold;
	}

	// return the years of incorporation
	public int getYearInc() {
		int year;

		return year;
	}

	// return place of est.
	public String getPlace() {
		String place;

		return place;
	}

	/* return CEO, etc. 
	public String[] getPeople() {
		String[] people = new String[3];

		people[1].toString();
		return people[1];
	}
	*/

	public String getIndustry() {
		String industry;

		return industry;
	}

	public boolean checkEquity() {
		boolean equity = false;

		return equity;
	}
}
