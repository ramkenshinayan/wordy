package clientInt.WordyModule;


/**
* clientInt/WordyModule/InvalidWordException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

public final class InvalidWordException extends org.omg.CORBA.UserException
{

  //3) Letter/s used are not from in the given
  public String reason = null;

  public InvalidWordException ()
  {
    super(InvalidWordExceptionHelper.id());
  } // ctor

  public InvalidWordException (String _reason)
  {
    super(InvalidWordExceptionHelper.id());
    reason = _reason;
  } // ctor


  public InvalidWordException (String $reason, String _reason)
  {
    super(InvalidWordExceptionHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class InvalidWordException