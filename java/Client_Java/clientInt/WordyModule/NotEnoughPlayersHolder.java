package clientInt.WordyModule;

/**
* clientInt/WordyModule/NotEnoughPlayersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public final class NotEnoughPlayersHolder implements org.omg.CORBA.portable.Streamable
{
  public clientInt.WordyModule.NotEnoughPlayers value = null;

  public NotEnoughPlayersHolder ()
  {
  }

  public NotEnoughPlayersHolder (clientInt.WordyModule.NotEnoughPlayers initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = clientInt.WordyModule.NotEnoughPlayersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    clientInt.WordyModule.NotEnoughPlayersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return clientInt.WordyModule.NotEnoughPlayersHelper.type ();
  }

}