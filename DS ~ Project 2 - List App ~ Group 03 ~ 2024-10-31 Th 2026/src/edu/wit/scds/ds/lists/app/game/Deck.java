/* @formatter:off
 *
 * Dave Rosenberg
 * Comp 2000 - Data Structures
 * Lab: List application - card game
 * Fall, 2024
 * 
 * Usage restrictions:
 * 
 * You may use this code for exploration, experimentation, and furthering your
 * learning for this course. You may not use this code for any other
 * assignments, in my course or elsewhere, without explicit permission, in
 * advance, from myself (and the instructor of any other course).
 * 
 * Further, you may not post (including in a public repository such as on github)
 * nor otherwise share this code with anyone other than current students in my 
 * sections of this course. Violation of these usage restrictions will be considered 
 * a violation of the Wentworth Institute of Technology Academic Honesty Policy.
 *
 * Do not remove this notice.
 *
 * @formatter:on
 */


package edu.wit.scds.ds.lists.app.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Representation of a deck of cards
 *
 * @author Joshua J Solorzano
 *
 * @version 1.0 2024-10-31 Initial implementation
 */
public class Deck extends Pile
	{
	// TODO implement this

    private final Random random;
	int top = 0;
	
	public Deck() {
		this.random = new Random();
		cards = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				cards.add(new Card(Suit.values(i), Rank.values(j)));
				top++;
			}
		}
	}
	
	public Card deal() {
		return cards.remove(--top);
	}
	public void shuffle() {
		for (int i = top-1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
	}
	
	public void sort() {
		Collections.sort(cards);
	}
	
	public Card peek(int i) {
		return this.cards.get(i);
	}
	
	public String toString() {
		String retVal = "";
		
		for (int i = 0; i < top; i++) {
			retVal += "\n" + this.peek(i).rank + " of " + this.peek(i).suit;
		}
		
		return retVal;
	}
	
	/**
     * (optional) test driver
     * 
     * @param args
     *     -unused-
     */
	public static void main( String[] args )
		{
        // OPTIONAL for testing and debugging
			
		Deck deck = new Deck();

		deck.sort();
		deck.shuffle();
	    // Call methods on the instance
	    System.out.println(deck.toString());
	    Card temp = deck.deal();
	    System.out.println("\n\n" + temp.rank + " of " + temp.suit + "\n\n");

	    System.out.println(deck.toString());
		}	// end main()

	}	// end class Deck