package clientInt.WordyModule;

/**
* clientInt/WordyModule/Player_Holder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public final class Player_Holder implements org.omg.CORBA.portable.Streamable
{
  public clientInt.WordyModule.Player_ value = null;

  public Player_Holder ()
  {
  }

  public Player_Holder (clientInt.WordyModule.Player_ initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = clientInt.WordyModule.Player_Helper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    clientInt.WordyModule.Player_Helper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return clientInt.WordyModule.Player_Helper.type ();
  }

}
