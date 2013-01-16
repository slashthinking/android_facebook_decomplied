package android_src.mms.pdu;

public class RetrieveConf extends MultimediaMessagePdu
{
  public RetrieveConf()
  {
    a(132);
  }

  RetrieveConf(PduHeaders paramPduHeaders, PduBody paramPduBody)
  {
    super(paramPduHeaders, paramPduBody);
  }

  public void a(EncodedStringValue paramEncodedStringValue)
  {
    this.a.a(paramEncodedStringValue, 137);
  }

  public byte[] b()
  {
    return this.a.b(132);
  }

  public byte[] c()
  {
    return this.a.b(139);
  }

  public byte[] d()
  {
    return this.a.b(152);
  }

  public EncodedStringValue h()
  {
    return this.a.c(137);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.RetrieveConf
 * JD-Core Version:    0.6.0
 */