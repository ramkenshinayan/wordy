package serverInt.WordyModule;


/**
* serverInt/WordyModule/RoundWinner_.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public final class RoundWinner_ implements org.omg.CORBA.portable.IDLEntity
{
  public String name = null;
  public String winningWord = null;
  public int roundWins = (int)0;

  public RoundWinner_ ()
  {
  } // ctor

  public RoundWinner_ (String _name, String _winningWord, int _roundWins)
  {
    name = _name;
    winningWord = _winningWord;
    roundWins = _roundWins;
  } // ctor

} // class RoundWinner_
