import java.util.ArrayList;

public class Points 
{
	String companyName;
	boolean valid = true;
	int objPoints = 0;
	String registration;
	int amountSold = 0;
	int points = 0;

	String buzzWord[] = new String[3];
		buzzWord[1] = ("health");
		buzzWord[2] = ("happiness");

	String badWord = new String[3];
		badWord[1] = ("LLC");
		badWord[2] = ("CORP");
		badWord[3] = ("INC");

	//object constructor
	public company(String name) {
		this.name = companyName;
	}

	//envokes all following methods for points and valididity
	public int checkCompany () {
		checkValid();
		checkBuzzwords();
		
		return points;
	}

	//check to see if the name involves badWords, which automatically DQ's the company
	public void checkValid() {
		for (i=0; i<badWord.length; i++) {
			if (companyName.contains(badWord[i]
				valid = false;
		}
	}

	//checking for buzzWord, adds a "point" if there is one
	public void checkBuzzwords () {
		for (i=0; i<buzzWord.length; i++) {
			if (companyName.contains(buzzWord[i]
				points++;
		}
	}

	//returns amount processed in the sale
	public void findAmountSold (){

	}

}