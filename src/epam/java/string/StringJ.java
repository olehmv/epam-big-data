package epam.java.string;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

//
public class StringJ {

	public static void main(String[] args) {
		StringJ s = new StringJ("War is 90% information. Napoleon Bonaparte. "
				+ "The temptation to form premature theories upon insufficient data is the bane of our profession. Sherlock Holmes, fictional detective. "
				+ "Data beats emotions. Sean Rad Founder of Tinder. "
				+ "The most valuable commodity I know of is information. Gordon Gekko, Wall Street. "
				+ "Processed data is information, Processed information is knowledge, Processed knowledge is Wisdom. Ankala Subbarao. ");
		String p = "Are you O.K.? Who, me?! Yes. Mr. & Mrs. Smith and Dr. John Doe. "
				+ "This is how I tried to split a paragraph into a sentence. " + "But, there is a problem."
				+ " My paragraph includes dates like Jan.13, 2014 , words like U.S and numbers like 2.2. "
				+ "They all got split by the above code.";
		System.out.println("\n"+breakTextToSentence(p));

	}

	private Map<String, Integer> map = new TreeMap<>();
	private String text;
	private StringBuffer b;
	private String[] strings;

	public StringJ(String text) {
		this.text = text;
		strings = text.split("\\.\\s");
		Arrays.stream(strings).forEach(x -> {
			System.out.println(x);
		});

		strings = text.split("\\s+");
		culculateWordAmount();
		outputFirstUniqueWord();
		outputWordsAndTheyAmount();
		changeShortestWordByLongestWord();

	}

	public void changeShortestWordByLongestWord() {
		String[] split = text.replaceAll("\\.\\s+", ".").split("\\.");
		for (int i = 0; i < split.length; i++) {
			String[] split2 = split[i].split("\\s+");
			int shortest = Integer.MAX_VALUE;
			int longest = Integer.MIN_VALUE;
			int shortestIndex = 0;
			int longestIndex = 0;
			for (int j = 0; j < split2.length; j++) {
				if (split2[j].length() > longest) {
					longest = split2[j].length();
					longestIndex = j;
				}
				if (split2[j].length() < shortest) {
					shortest = split2[j].length();
					shortestIndex = j;
				}

			}
			String temp = split2[longestIndex];
			split2[longestIndex] = split2[shortestIndex];
			split2[shortestIndex] = temp;
			StringBuilder b = new StringBuilder();
			Arrays.stream(split2).forEach(x -> {
				x = x + " ";
				b.append(x);
			});
			split[i] = b.toString();
			System.out.println(split[i] + ".");
		}
	}

	public void showText() {
		for (String string : strings) {
			System.out.println(string);
		}
	}

	public void outputFirstUniqueWord() {
		for (String string : strings) {
			if (map.get(string) < 2) {
				System.out.println("First Unique: " + string);
				return;
			}
		}
	}

	public void outputWordsAndTheyAmount() {
		getMap().forEach((x, y) -> {
			System.out.println("Word: " + x + " amount: " + y);
		});
	}

	public void culculateWordAmount() {

		for (String string : strings) {
			if (!map.containsKey(string)) {
				map.put(string, 1);
			} else {
				Integer integer = map.get(string);
				map.put(string, integer + 1);
			}

		}
	}

	public static String breakTextToSentence(String text) {
		StringBuilder builder = new StringBuilder();
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
		iterator.setText(text);
		int start = iterator.first();
		for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
			String string = text.substring(start, end);
			if (string.matches("([^.!?]|(?<=etc|Dr|Mr|Mrs|\\b[A-Za-z]|\\s)[.!?])+")) {
				builder.append(string);
			} else {
				builder.append(string + "\n");
			}
		}
		return builder.toString();
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public StringBuffer getB() {
		return b;
	}

	public void setB(StringBuffer b) {
		this.b = b;
	}

}
//("(?<!\\b\\p{Upper}\\w{0,4})(?=[.?!]\\s*\\p{Upper})[.?!]\\s*");
// replaceAll("[^a-zA-Z-. ]", "")
// \\s - matches single whitespace character
// \\s+ - matches sequence of one or more whitespace characters.
// for (String string2 : split2) {
// if(string2.length()>longestI){
// longest=string2;
// longestI=string2.length();
// }
// if(string2.length()<shortestI){
// shortest=string2;
// shortestI=string2.length();
// }
// }

// List<StringBuilder>list=new ArrayList<>();
// StringBuilder strb=new StringBuilder();
// list.add(strb);
// for (String string : strings) {
// if(string.contains(".")){
// strb.append(string);
// strb=new StringBuilder();
// list.add(strb);
// }else{
// strb.append(string);
// }
//
// }