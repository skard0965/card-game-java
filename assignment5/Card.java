/** 
COMP1006/1406 - Summer 2014
Assignment 5, Problem 1
Name: Shadi Kardan
  Id: 100734177
Date: 25/07/2014
This Card class extends AbstractCard abstract class.
Card class contains 2 constructors and getter and setter and compareTo methods.
Usage: run CardTest
Searchs if new card is a valid card. It compares value of cards.
Example: > Card c = new Card("Queen", "Diamond");
           Output: 12D
           Card d = new Card("4","Spade"); 
           System.out.println(c.compareTo(d));
           output: -1
*/
public class Card extends AbstractCard {
  
  private String rank, suit;    //variables rank and suit for card identification usage
  private int value;    //variable value for card value usage
  
  /*
   * Constructor: takes Input string rank and string suit
   * searches validity of card and gives value to valid card
   */
  public Card(String rank, String suit) {
    String cardRank = "";                   
    String cardSuit = "";
    int cardValue = 0;           
    boolean rankFound = false;
    boolean suitFound = false;    
    if (null == rank || null == suit) {    //Considering null cases   
      rank = "";
      suit = "";
    }
    for (int i=0; i < RANKS.length; i++) {    //searches validity of card rank  
      if (rank.toLowerCase().equals(RANKS[i].toLowerCase())) {    //considering both uppercase and lowercase    
        cardRank = Integer.toString(i+1);           
        rankFound = true;
        if (i==0) {
          cardValue = 13;    //value of Ace card is higher than other cards (13)       
        } else {
          cardValue = i;     //value of cards are in order of their location in Ranks array except Ace
        }
      }
    } 
    for (int i=0; i < SUITS.length; i++) {    //searches validity of card suit
      if (suit.toLowerCase().equals(SUITS[i].toLowerCase())) {     //considering both uppercase and lowercase
        cardSuit = suit;
        suitFound = true;
        cardValue = cardValue + (i*13);    //value of diamond < club < heart < spade increases by 13 
      }
    }  
    if (rankFound && suitFound) {    //to search if validity of both suit and rank card to set it
      this.rank = cardRank;
      this.suit = cardSuit;
      this.value = cardValue;
    } else {    // if not a valid card , giving 2 Diamond 
      this.rank = "2";
      this.suit = "Diamond";
      this.value = 1; // 2 is 1, diamond is 0 so: 1+0=1.
    }
  }
  
  /*
   * Constructor: takes Input int rank and string suit
   * searches validity of card and gives value to valid card
   */  
  public Card(int rank, String suit) { 
    String cardRank = "";
    String cardSuit = "";
    int cardValue = 0;
    boolean rankFound = false;
    boolean suitFound = false;    
    if (null == suit) {    // //Considering null case for suit card   
      suit = "";
    }
    for (int i=0; i < RANKS.length; i++) {    //searches validity of card rank  
      if (i+1 == rank) {
        cardRank = Integer.toString(i+1);
        rankFound = true;
        if (i==0) {
          cardValue = 13;    //value of Ace card is higher than other cards (13)
        } else {
          cardValue = i;    //value of cards are in order of their location in Ranks array except Ace
        } 
      }
    }   
    for (int i=0; i < SUITS.length; i++) {    //searches validity of card suit
      if (suit.toLowerCase().equals(SUITS[i].toLowerCase())) {    //considering both uppercase and lowercase
        cardSuit = suit;
        suitFound = true;
        cardValue = i+1;
        cardValue = cardValue + (i*13);    //value of diamond < club < heart < spade increases by 13 
      }
    }    
    if (rankFound && suitFound) {    //to search if validity of both suit and rank card to set it    
      this.rank = cardRank;
      this.suit = cardSuit;
      this.value = cardValue;
    } else {    // if not a valid card , giving 2 Diamond
      this.rank = "1";     
      this.suit = "Spade";
      this.value = 52;    //Ace Spade value is highest value (52)
    }
  }

  /*
   * compareTo method overrides AbstractCard method class which compares value of 2 cards 
   * output when values are same would be 0
   * output when values of this card is less than other card would be -1; and when more than will be 1
   */  
  @Override
  public int compareTo(AbstractCard o) {
    Card that = (Card) o;    //identifying other card with o
    int compareValue = this.value - that.value;    
    if (compareValue > 0) return 1;    //output is 1 when values of this card is less than other card 
    if (compareValue < 0) return -1;    //output is -1 when values of this card is more than other card     
    return 0;    //outpur is 0 when both values are same
  }

  /*
   * getRank method overrides AbstractCard method class
   * It return rank of card in integer form
   */  
  @Override
  public int getRank() {
    return Integer.parseInt(this.rank);
  }

  /*
   * getSuit method overrides AbstractCard method class
   * It return suit of card
   */  
  @Override
  public String getSuit() {
    this.suit=this.suit.toUpperCase();
    return this.suit;
  }
}