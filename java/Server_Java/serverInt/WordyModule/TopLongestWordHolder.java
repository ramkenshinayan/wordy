package serverInt.WordyModule;

/**
* serverInt/WordyModule/TopLongestWordHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public final class TopLongestWordHolder implements org.omg.CORBA.portable.Streamable
{
  public serverInt.WordyModule.TopLongestWord value = null;

  public TopLongestWordHolder ()
  {
  }

  public TopLongestWordHolder (serverInt.WordyModule.TopLongestWord initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = serverInt.WordyModule.TopLongestWordHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    serverInt.WordyModule.TopLongestWordHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return serverInt.WordyModule.TopLongestWordHelper.type ();
  }

}
