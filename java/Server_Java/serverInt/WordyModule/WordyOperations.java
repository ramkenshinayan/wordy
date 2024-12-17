package serverInt.WordyModule;


/**
* serverInt/WordyModule/WordyOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public interface WordyOperations 
{
  void login (String username, String password) throws serverInt.WordyModule.InvalidLoginException;
  void logout (String username);
  void initiateGame (String username) throws serverInt.WordyModule.NotEnoughPlayers;
  void submitWord (String username, String word) throws serverInt.WordyModule.InvalidWordException;
  String getGameWinner (String username);
  serverInt.WordyModule.Player_[] getAllPlayers (String username);
  serverInt.WordyModule.RoundWinner_ getRoundWinner (String username) throws serverInt.WordyModule.NoWinnerException;
  char[] getLetters (String username);
  int getTime (String username);
  serverInt.WordyModule.TopLongestWord getLongestWord (int index);
  int getLongestWordsSize ();
  serverInt.WordyModule.TopPlayer getTopPlayers (int index);
  int getTopPlayersSize ();
  void disposeGame (String username);
  boolean gameStartFlag (String username);
  boolean gameEndFlag (String username);
  boolean roundEndFlag (String username);
} // interface WordyOperations
