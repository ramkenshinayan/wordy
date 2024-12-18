package serverInt.WordyModule;


/**
* serverInt/WordyModule/WordyHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

abstract public class WordyHelper
{
  private static String  _id = "IDL:WordyModule/Wordy:1.0";

  public static void insert (org.omg.CORBA.Any a, serverInt.WordyModule.Wordy that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static serverInt.WordyModule.Wordy extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (serverInt.WordyModule.WordyHelper.id (), "Wordy");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static serverInt.WordyModule.Wordy read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_WordyStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, serverInt.WordyModule.Wordy value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static serverInt.WordyModule.Wordy narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof serverInt.WordyModule.Wordy)
      return (serverInt.WordyModule.Wordy)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      serverInt.WordyModule._WordyStub stub = new serverInt.WordyModule._WordyStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static serverInt.WordyModule.Wordy unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof serverInt.WordyModule.Wordy)
      return (serverInt.WordyModule.Wordy)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      serverInt.WordyModule._WordyStub stub = new serverInt.WordyModule._WordyStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
