
public class Word implements Comparable<Word>{
	private String name = "";
	private int occurrence;
	static private int count = 0;

	public Word(){
		name = "";
		occurrence = 0;
	}
	/**
	 * Create a new word object to store all the words and their occurrence totals in a text file.
	 * @param name - The name of a single word in the text file.
	 * @param occurence - The occurrence of the word in the text file.
	 */
	public Word(String name, int occurrence){
		this.name = name;
		this.occurrence = occurrence;
		count++;
	}
	
	public Word(String name){
		this.name = name;
		occurrence = 1;
		count++;
	}
	
	public String getName(){
		return name;
	}
	
	public int getOccurrence(){
		return occurrence;
	}
	
	public void updateOccurrence(){
		occurrence++;
		count++;
	}
	public boolean equals(Object obj)
	{
		return name.equals(((Word)obj).name);
	}
	@Override
	public int compareTo(Word o) {
		if(((Integer)occurrence).compareTo(o.occurrence) == 0){
			return 1*name.compareTo(o.name);
		}
		else {return -1*((Integer)occurrence).compareTo(o.occurrence);} //for descending order
	}
	
	public double getPercentage(){
		return 100*((double)occurrence/(double)count);
	}
}
