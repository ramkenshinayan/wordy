package clientInt.WordyModule;


/**
* clientInt/WordyModule/PlayerListHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Sunday, July 2, 2023 2:41:05 PM CST
*/

abstract public class PlayerListHelper
{
  private static String  _id = "IDL:WordyModule/PlayerList:1.0";

  public static void insert (org.omg.CORBA.Any a, clientInt.WordyModule.Player_[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static clientInt.WordyModule.Player_[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = clientInt.WordyModule.Player_Helper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (clientInt.WordyModule.PlayerListHelper.id (), "PlayerList", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static clientInt.WordyModule.Player_[] read (org.omg.CORBA.portable.InputStream istream)
  {
    clientInt.WordyModule.Player_ value[] = null;
    int _len0 = istream.read_long ();
    value = new clientInt.WordyModule.Player_[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = clientInt.WordyModule.Player_Helper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, clientInt.WordyModule.Player_[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      clientInt.WordyModule.Player_Helper.write (ostream, value[_i0]);
  }

}
