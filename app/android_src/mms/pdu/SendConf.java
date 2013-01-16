package android_src.mms.pdu;

public class SendConf extends GenericPdu
{
  public SendConf()
  {
    a(129);
  }

  SendConf(PduHeaders paramPduHeaders)
  {
    super(paramPduHeaders);
  }

  public byte[] a()
  {
    return this.a.b(139);
  }

  public int b()
  {
    return this.a.a(146);
  }

  public byte[] c()
  {
    return this.a.b(152);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.SendConf
 * JD-Core Version:    0.6.0
 */