package clientInt.WordyModule;

/**
* clientInt/WordyModule/WordyHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public final class WordyHolder implements org.omg.CORBA.portable.Streamable
{
  public clientInt.WordyModule.Wordy value = null;

  public WordyHolder ()
  {
  }

  public WordyHolder (clientInt.WordyModule.Wordy initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = clientInt.WordyModule.WordyHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    clientInt.WordyModule.WordyHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return clientInt.WordyModule.WordyHelper.type ();
  }

}
