/* Risha Gokidi
 * 12/13/2024
 * Punctuation.java
 * Skills: String methodsl, loops, if-statements
 * Put in a string and will return the words that have punctuation in it or touching the word
 * 
 * Psuedocode:
 * Main: make instance and call searchit
 * Searchit: add text and call getPunctuation and printwords
 * 
 * getPunctuationWords(text): check for strings that have spaces before and after the characters(find the words)
 * 		add the word to a list of strings to collect all the seperate words
 * 		call check for punctuation
 * 
 * checkForPuncutation(word): Create string of punctuation
 * 		go through list for each index of the text to check for each punctuation character
 * 		return true or false to go into if-statement in getPunctuationWords
 * 
 * printWords(finalOutput): print words with punctuation
*/

public class Punctuation
{
	public static void main(String[] args)
	{
		Punctuation pt = new Punctuation(); //creating instance of class
		pt.searchIt(); //use instance of class to call method searchit
	}
	
	public void searchIt()
	{
		String text = "\"Blood, Sweat, and Tears by Winston Churchill May 13, 1940 Mr. Speaker: On Friday evening last I received His Majesty’s commission to form a new " 
		+ "Administration. It was the evident wish and will of Parliament and the nation that this should be conceived on the broadest possible basis and that it should " 
		+ "include all parties, both those who supported the late Government and also the parties of the Opposition. " 
		+ "I have completed the most important part of this task. A War Cabinet has been formed of five Members, representing, with the Liberal Opposition, the unity of the "
		+ "nation. The three party Leaders have agreed to serve, either in the War Cabinet or in high executive office. The three Fighting Services have been filled. It was necessary "
		+ "that this should be done in one single day, on account of the extreme urgency and rigour of events. A number of other key positions were filled yesterday, and I am "
		+ "submitting a further list to His Majesty tonight. I hope to complete the appointment of the principal Ministers during tomorrow. The appointment of the other Ministers usual "
		+ "takes a little longer, but I trust that, when Parliament meets again, this part of my task will be completed, and that the Administration will be complete in all respects. " 
		+ "Sir, I considered it in the public interest to suggest that the House should be summoned to meet today. Mr. Speaker agreed and took the necessary steps, in "
		+ "accordance with the powers conferred upon him by the Resolution of the House. At the end of the proceedings today, the Adjournment of the House will be proposed until "
		+ "Tuesday, the 21st May, with, of course, provision for earlier meeting, if need be. The business to be considered during that week will be notified to Members at the earliest "
		+ "opportunity. I now invite the House, by the Resolution which stands in my name, to record its approval of the steps taken and to declare its confidence in the new Government. " 
		+ "Sir, to form an Administration of this scale and complexity is a serious undertaking in itself, but it must be remembered that we are in the preliminary stage of "
        + "one of the greatest battles in history, that we are in action at many points in Norway and in Holland, that we have to be prepared in the Mediterranean, that the air battle is "
        + "continuous and that many preparations have to be made here at home. In this crisis I hope I may be pardoned if I do not address the House at any length today. I hope that "
        + "any of my friends and colleagues, or former colleagues, who are affected by the political reconstruction, will make all allowances for any lack of ceremony with which it has been "
        + "necessary to act. I would say to the House, as I said to those who’ve joined this government: \"I have nothing to offer but blood, toil, tears and sweat.\"" 
        + "We have before us an ordeal of the most grievous kind. We have before us many, many long months of struggle and of suffering. You ask, what is our policy? I "
        + "will say: It is to wage war, by sea, land and air, with all our might and with all the strength that God can give us; to wage war against a monstrous tyranny, never "        
        + "surpassed in the dark and lamentable catalogue of human crime. That is our policy. You ask, what is our aim? I can answer in one word: victory. Victory at all costs, victory in "
        + "spite of all terror, victory, however long and hard the road may be; for without victory, there is no survival. Let that be realised; no survival for the British Empire, no survival "
        + "for all that the British Empire has stood for, no survival for the urge and impulse of the ages, that mankind will move forward towards its goal. " 
        + "But I take up my task with buoyancy and hope. I feel sure that our cause will not be suffered to fail among men. At this time I feel entitled to claim the aid of all, "
        + "and I say, \"Come then, let us go forward together with our united strength.\""; //text is string with the variable name of text
		String output = getPunctuationWords(text); //calling getPunctuationWords (which will return string) and sending text in
		printWords(output); //calling printWords and sending output in
		
	}
	
	public String getPunctuationWords(String text) //parameter is text
	{
		int start = 0; //D&I start
		int end = -1; //D&I end
		String word = ""; //D&I word
		boolean check = false; //D&I check
		String output = ""; //D&I output

		for(int i = 0; i < text.length(); i++) //for loop is starting from index 0 to the length of the text. Will increment each time the loop ends
		{
			if(text.charAt(i) == ' ') //if index 0 is a space then...
			{
				end = i; //setting end equal to i
				word = text.substring(start, end); //from where the space starts and end is considered a word and is placed in the variable word
				check = checkForPunctuation(word); //sends the word into checkForPunctuation which will return a boolean
				start = end; //setting end as i to restart there insteading of checking the same word
				if(check == true) //if check is true(what is returned from checkForPunctuation)
				{
					output = output + word; //add word that has punctuation to the output(final string of words)
				}
			}
			
		}
		return output; //return the output as String to send to printWords(finalOutput)
	}
	
	public boolean checkForPunctuation(String word) //parameter is the word (one space before and after)
	{
		String punc = ".,;:!?'\"()"; //setting all the punctuation characters into a string
		boolean check = false; //D&I check
		int index = 0; //D&I index
		
		while((check == false) && (index < word.length())) //while loop will end if check equals true and the index exceeded the length of the word
		{
			for(int i=0; i<punc.length(); i++) //for loop starts from index 0 and will go until the end of the string punc, will increment each time
			{
				if(word.charAt(index) == punc.charAt(i)) //if the index 0 of the word equals any of the characters in the punctuation string (punc) then...
				{
					check = true; //then check equals true and the loop will end
				}
			}
			index++; //else it'll incremenet index by one to check the next letter in word
		}
		return check; //return check as false or true
	}
	
	public void printWords(String finalOutput) //parameter is the final string of the words that have punctuation
	{
		System.out.println(finalOutput); //will the print the String
	}
	
}

