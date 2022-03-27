package exceptionGenerator;


/**
* exceptionGenerator/GeneratorPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from exGen.idl
* 28 ����� 2022 �. 0:01:05 MSK
*/

public abstract class GeneratorPOA extends org.omg.PortableServer.Servant
 implements exceptionGenerator.GeneratorOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_Generate", new java.lang.Integer (0));
    _methods.put ("_set_Generate", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // exceptionGenerator/Generator/_get_Generate
       {
         String $result = null;
         $result = this.Generate ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // exceptionGenerator/Generator/_set_Generate
       {
         String newGenerate = in.read_string ();
         this.Generate (newGenerate);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:exceptionGenerator/Generator:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Generator _this() 
  {
    return GeneratorHelper.narrow(
    super._this_object());
  }

  public Generator _this(org.omg.CORBA.ORB orb) 
  {
    return GeneratorHelper.narrow(
    super._this_object(orb));
  }


} // class GeneratorPOA
