package serverInt.WordyModule;

/**
* serverInt/WordyModule/InvalidLoginExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public final class InvalidLoginExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public serverInt.WordyModule.InvalidLoginException value = null;

  public InvalidLoginExceptionHolder ()
  {
  }

  public InvalidLoginExceptionHolder (serverInt.WordyModule.InvalidLoginException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = serverInt.WordyModule.InvalidLoginExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    serverInt.WordyModule.InvalidLoginExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return serverInt.WordyModule.InvalidLoginExceptionHelper.type ();
  }

}
