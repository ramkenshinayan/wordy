package clientInt.WordyModule;


/**
* clientInt/WordyModule/LettersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public final class LettersHolder implements org.omg.CORBA.portable.Streamable
{
  public char value[] = null;

  public LettersHolder ()
  {
  }

  public LettersHolder (char[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = clientInt.WordyModule.LettersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    clientInt.WordyModule.LettersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return clientInt.WordyModule.LettersHelper.type ();
  }

}
