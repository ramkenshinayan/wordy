package serverInt.WordyModule;

/**
* serverInt/WordyModule/NoWinnerExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public final class NoWinnerExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public serverInt.WordyModule.NoWinnerException value = null;

  public NoWinnerExceptionHolder ()
  {
  }

  public NoWinnerExceptionHolder (serverInt.WordyModule.NoWinnerException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = serverInt.WordyModule.NoWinnerExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    serverInt.WordyModule.NoWinnerExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return serverInt.WordyModule.NoWinnerExceptionHelper.type ();
  }

}
