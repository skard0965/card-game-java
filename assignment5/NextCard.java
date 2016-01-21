/** 
COMP1006/1406 - Summer 2014
Assignment 5, Problem 2
Name: Shadi Kardan
  Id: 100734177
Date: 25/07/2014
This NextCard class has crazy-eights card rules
Preconditions: Hand consists of 1 or more cards (your hand) and 
               topCard is the (face up) card on the discard pile
Postconditions: returns a card that is a valid play based on the topCard
Side Effects: using pickup() method to pick up a card when you don't have a valid card,
              You can repeatedly pick up cards until you can play a card.
Usage: run CardTest
According to crazy-eight rules searches if any of hand cards are valid to return it
Example: > Card[] hand = new Card[]{ new Card(2, "Spade"), new Card(8, "Heart")};
           nextCard(hand, new Card(7, "Diamond")));
           Output: 8H
*/
public class NextCard{

   /*
   * nextCard method searches cards in hand array to look for valid card to return
   * Valid card: any card that has the same suit or same rank as top or any card with rank 8.
   * If not a valid card in hand , uses pickUpCard method to add a new card to hand 
   * It adds new card repeatedly until It finds a valid card to return
   */
  public static Card nextCard(Card[] hand, Card topCard){
    for (int i = 0; i < hand.length; i++) {    //to search for valid card to play
      if (hand[i].getSuit().equals(topCard.getSuit()) || hand[i].getRank() == topCard.getRank() || 8 == hand[i].getRank()) {
        return hand[i];
      }
    }
    return nextCard(pickUpCard(hand), topCard);    //adding another card into hand and repeats
  }
  
  /*
   * pickUpCard method uses pickUp method of PickUp class to 
   * add a new card in hand and returns hand
   */
  private static Card[] pickUpCard(Card[] hand) {
    Card card = PickUp.pickUp();    //selecting a new card using pickUp method
    Card[] newHand = new Card[hand.length+1]; 
    for (int i=0; i<hand.length; i++) {    //adding all previous cards into new hand array
      newHand[i] = hand[i];
    }
    newHand[hand.length] = card;    //adding new selected card into hand   
    return newHand;
  }
}