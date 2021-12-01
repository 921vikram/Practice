package design;

public class CardGame {
  /**
   *
   * class Card {
   *     constructor(suit, rank, value) {
   *         this.suit = suit;
   *         this.rank = rank;
   *         this.value = value;
   *     }
   * }
   * class Deck {
   *     constructor() {
   *         this.cards = [];
   *     }
   *     createDeck() {
   *         let suits = ['clubs', 'diamonds', 'hearts', 'spades'];
   *         let ranks = ['ace', '2', '3', '4', '5', '6', '7', '8', '9',     '10', 'jack', 'queen', 'king'];
   *         let values = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];
   *         for (let i = 0; i < suits.length; i++) {
   *             for (let j = 0; j < ranks.length; j++) {
   *                 this.cards.push(new Card(suits[i], ranks[j], values[j]));
   *             }
   *         }
   *     }
   *     shuffleDeck() {
   *        let location1, location2, tmp;
   *        for (let i = 0; i < 1000; i++) {
   *            location1 = Math.floor((Math.random() * this.cards.length));
   *            location2 = Math.floor((Math.random() * this.cards.length));
   *            tmp = this.cards[location1];
   *            this.cards[location1] = this.cards[location2];
   *            this.cards[location2] = tmp;
   *         }
   *     }
   * }
   * class Player {
   *     constructor(name) {
   *         this.playerName = name;
   *         this.playerCards = [];
   *     }
   * }
   * class Board {
   *     constructor() {
   *         this.cardsInMiddle = [];
   *         this.players = [];
   *     }
   *     start(playerOneName, playerTwoName) {
   *         this.players.push(new Player(playerOneName));
   *         this.players.push(new Player(playerTwoName));
   *         let d = new Deck();
   *         d.createDeck();
   *         d.shuffleDeck();
   *         this.players[0].playerCards = d.cards.slice(0, 26);
   *         this.players[1].playerCards = d.cards.slice(26, 52);
   *     }
   * }
   * let gameBoard = new Board();
   * gameBoard.start('Mario', 'Luigi');
   * console.log(gameBoard.players);
   *
   *
   */
}
