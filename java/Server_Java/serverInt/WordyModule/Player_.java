package serverInt.WordyModule;


/**
* serverInt/WordyModule/Player_.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public final class Player_ implements org.omg.CORBA.portable.IDLEntity
{
  public String username = null;
  public int roundWins = (int)0;

  public Player_ ()
  {
  } // ctor

  public Player_ (String _username, int _roundWins)
  {
    username = _username;
    roundWins = _roundWins;
  } // ctor

} // class Player_
