
public class TerminalTest {
//content
  //Tests
private final static String[] code = new String[]{
			
			" wrongCommandWithLeadingWhitespace","Error, whitespace",
			"wrongCommand","Error, unknown command",
			
			"all publications","#",
			"list invalid publications","#",
			
			"add author Eniola,Lowry","Ok",
			"add author Richard,Rhinelander", "Ok",
			"add author Eniola,Lowry","Error",
			"add author Shashi,Afolabi", "Ok",
			" add author Shashlik,Shams", "Error, whitespace command",
			"add author  Sams,Sams", "Error whitespace input",
			"add author Sams, Sams","Error whitespace input",
			"add author Sams,Sams ", "Error whitespace input",
			"add author Sams,Sams,Sams", "Error, invalid argument number",
			"add author Sams", "Error, invalid argument number",
			"add author Sams,Sams!", "Error wrong characters",
			
			"add journal TSE,IEEE","Ok",
			"add journal TSE,IEEE,wea", "Error invalid number of arguments",
			"add journal TSE,IEEE",  "Error already existing", 
			
			"add conference series ICSA","Ok",
			"add conference series ICSA", "Error already existing",
			"add conference series ALT", "Ok",
			" add conference series ALT", "Error leading whitespace",
			"add conference series AL T", "Error contains whitespace",
			"add conference series ALT", "Error contains whitespace",
			
			 "add conference ICSA,2017,Gothenburg","Ok",
			 "add conference ICSA,2016,Gothenburg","Ok",
			 "add conference ICSA,2017,Hardenhausen","Error conference in this year existing",
			 "add conference ICSA,adsf,Gothenburg","Error no valid year",
			 "add conference ALTA,2017,Gothenburg","Error element not existing",
			 
			 "add article to series ICSA:rr2017,2017,Components still have no interfaces","Ok",
			 "add article to journal TSE:mvp2015,2015,Model Consistency",  "Ok", 
			 "add article to journal TSE:mvp2016,2016,Better Model Consistency" ,"Ok",
			 "add article to journal TSE:nngrade,2014,Annoying programming exams" ,"Ok",
			
			"all publications","#rr2017 mvp2015 mvp2016",
			"list invalid publications","#rr2017 mvp2015 mvp2016",
			
			"written-by rr2017,Richard Rhinelander","Ok",
			"written-by nngrade,Eniola Lowry", "Ok",
			"written-by mvp2016,Shashi Afolabi;Eniola Lowry", "Ok", 
			
			"list invalid publications","#mvp2015",
			
			"written-by mvp2015,Shashi Afolabi;Richard Rhinelander", "Ok",
			"written-by mvp2013,Shashi Afolabi;Richard Rhinelander", "Error not existing",
			"written-by mvp2015,Shashi Aflosbi;Richard Rhinelander", "Error not existing",
			
			"all publications","#rr2017 mvp2015 mvp2016",
			"list invalid publications","#",
			 
			"quit", "Ok" };
	
	private static int count = 0;
	private static boolean output = true;
	private static int correctAnswers = 0;
	private static int wrongAnswers = 0;

	public static String readLine() {
		if ((count) < code.length) {
			if (output) {
				System.out.println("");
				System.out.println("-->" + code[count]);
				System.out.println("-->" + code[count+1]);
			}
			count+=2;
			return code[count - 2];
		}
		return null;
	}

	public static void printError(final String message) {
		if (output) {
			System.out.println("Error, " + message);
		}
		if (code[count-1].startsWith("Error")) {
			correctAnswers++;
		} else {
			wrongAnswers++;
		}
	}

	public static void printLine(final Object object) {
		if (output) {
			System.out.println(object);
		}
		if (code[count-1].equals("Ok")) {
			correctAnswers++;
		} else if(code[count-1].startsWith("#")) {
			//System.out.print("############### Output not automatically tested! ###################   ");
		}else {
			wrongAnswers++;
		}
		if (count == code.length) {
			System.out.println("Correct: " + correctAnswers + " Incorrect: " + wrongAnswers);
		}

	}
}
