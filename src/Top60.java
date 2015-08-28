import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

import java.util.ArrayList;

public class Top60 {
	ArrayList<Word> wordList = new ArrayList<Word>();
	ArrayList<Word> top60Words = new ArrayList<Word>();
	boolean flag = false;

	public static void main(String[] args) {
		
		Top60 top60 = new Top60();
		top60.readTextFile();
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
		catch (Exception e){
			System.err.format("File does not exist\n");
		}
		findTop60Words();
	}
	/**
	 * Parse string buffers to remove the following punctuation and characters:
	 * .,?!;:"
	 * @param buffer - String of words read from a text file that needs to be parsed.
	 */
	private void bufferParse(String buffer){
	String delimiters = "[ ,.;:()?!\\[\\]]+";
	String[] parsedBufferArray = buffer.split(delimiters);
	extractBufferArray(parsedBufferArray);
	}
	
	/**
	 * Extracts the words from an array of Strings and adds them to the list of words in a text file, while updating their total occurrences in the file.
	 * @param parsedBufferArray - Array of Strings
	 */
	void extractBufferArray(String[] parsedBufferArray){

		int length = parsedBufferArray.length;
		boolean contains = false;
		for(int i = 0; i < length ; i ++){
			//if (flag == false) {out.println("1"); flag = true;}
			if(parsedBufferArray[i] != null || parsedBufferArray[i] != ""){
				Word newWord = new Word(parsedBufferArray[i]);
				//out.println(newWord.getName() + " || " + parsedBufferArray[i]);
			if(wordList.isEmpty()){
				//out.println(newWord.getName());
				wordList.add(newWord);
				}
			else{
			//Iterator<Word> itr = wordList.iterator();
			//while(itr.hasNext()){
				//Word searchWord = itr.next();
				/*
				for(Word searchWord: wordList){
					if(searchWord.getName() !=null && searchWord.getName().contains(newWord.getName()));{
						searchWord.updateOccurrence();
						//out.println(searchWord.getName());
						contains = true;}
					//if(flag == true){out.println("2");flag = false;}
					}
				if(contains == false){
					wordList.add(newWord);
					contains = false;
				}
				*/
				int index = wordList.indexOf(newWord);
				if(index == -1)
				{
					wordList.add(newWord);
				}
				else
				{
					wordList.get(index).updateOccurrence();
				}
				}}}}
	
	/**
	 * Takes an array list of type <Word> and finds the top 60 word occurrences and moves them to a new array list.
	 */
	private void findTop60Words(){
		/*
		int count = 0;
		for(int i = 0; i <= 60 ; i++){
			for(Word topWordCount: wordList){
				if(topWordCount.getOccurrence() > count){
					out.println(topWordCount.getName());
					count = topWordCount.getOccurrence();
					//if(flag == false){out.println("3");flag = true;}
				}
			}
			for(Word topWord: wordList){
				if(topWord.getOccurrence() == count){
					top60Words.add(topWord);
					wordList.remove(topWord);
					break;
				}
			}
		count = 0;}
		*/
		
		java.util.Collections.sort(wordList);
		for(int i = 0; i<= 60; i++){
			top60Words.add(wordList.get(i));
		}
		printTop60Words();
	}
	
	private void printTop60Words(){
		
		out.println("Word" + '\t'+ '\t' + "Occurences" + '\t' + "Percentage of Occurrence");
		out.println("--------------------------------------------------------");
		for(Word printWord: top60Words){
			out.print(printWord.getName() + "\t\t" + printWord.getOccurrence() + "\t\t");
			out.printf("%.2f%%\n",printWord.getPercentage());
		
		}
	}
	
	
	
	
	

}
