package android_src.mms.pdu;

public class MultimediaMessagePdu extends GenericPdu
{
  private PduBody b;

  public MultimediaMessagePdu()
  {
  }

  public MultimediaMessagePdu(PduHeaders paramPduHeaders, PduBody paramPduBody)
  {
    super(paramPduHeaders);
    this.b = paramPduBody;
  }

  public PduBody a()
  {
    return this.b;
  }

  public void a(long paramLong)
  {
    this.a.a(paramLong, 133);
  }

  public void a(PduBody paramPduBody)
  {
    this.b = paramPduBody;
  }

  public void c(int paramInt)
  {
    this.a.a(paramInt, 143);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.MultimediaMessagePdu
 * JD-Core Version:    0.6.0
 */