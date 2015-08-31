import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.out;


public class Top60 {
	ArrayList<Word> wordList = new ArrayList<Word>();
	ArrayList<Word> top60Words = new ArrayList<Word>();
	boolean flag = false;

	public static void main(String[] args) {
		Top60 top60 = new Top60();
		top60.readTextFile();
		top60.findTop60Words();
		top60.printTop60Words();
	}
	
	private void readTextFile(){
		java.io.File file = new java.io.File("Artamenes.txt");
		try{
			Scanner input = new Scanner(file);
			while (input.hasNext()){
			String buffer = input.nextLine();
			buffer = buffer.toLowerCase();
			bufferParse(buffer);	 
			}
			input.close();
		}
		catch (Exception e){System.err.format("File does not exist\n");}
		
	}
	/**
	 * Parse string buffers to remove the following punctuation and characters:
	 * .,?!;:"
	 * @param buffer - String of words read from a text file that needs to be parsed.
	 */
	private void bufferParse(String buffer){
	String delimiters = "[ ,.;:()?!\\[\\]\t]+";
	String[] parsedBufferArray = buffer.split(delimiters);
	extractBufferArray(parsedBufferArray);
	}
	
	/**
	 * Extracts the words from an array of Strings and adds them to the list of words in a text file, while updating their total occurrences in the file.
	 * @param parsedBufferArray - Array of Strings
	 */
	void extractBufferArray(String[] parsedBufferArray){

		int length = parsedBufferArray.length;
		for(int i = 0; i < length ; i ++){
			if(parsedBufferArray[i] != null || parsedBufferArray[i] != ""){
				Word newWord = new Word(parsedBufferArray[i]);
			if(wordList.isEmpty()){
				wordList.add(newWord);}
			else{
				int index = wordList.indexOf(newWord);
				if(index == -1){	wordList.add(newWord);}
				else
				{wordList.get(index).updateOccurrence();}
				}}}}
	
	/**
	 * Takes an array list of type <Word> and finds the top 60 word occurrences and moves them to a new array list.
	 */
	private void findTop60Words(){
		java.util.Collections.sort(wordList);
		for(int i = 0; i<= 60; i++){
			top60Words.add(wordList.get(i));
		}
	}
	/**
	 * Prints out the top 60 most used words from the text file.
	 */
	private void printTop60Words(){
		out.println("Word" + '\t'+ '\t' + "Occurences" + '\t' + "Percentage of Occurrence");
		out.println("--------------------------------------------------------");
		for(Word printWord: top60Words){
			if(printWord.getName().length() > 7){
				out.print(printWord.getName() + "\t" + printWord.getOccurrence() + "\t\t");
				out.printf("%.2f%%\n",printWord.getPercentage());
			}
			else{
			out.print(printWord.getName() + "\t\t" + printWord.getOccurrence() + "\t\t");
			out.printf("%.2f%%\n",printWord.getPercentage());
			}
		}
	}
}
