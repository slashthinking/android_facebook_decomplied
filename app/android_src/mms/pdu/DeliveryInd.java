package android_src.mms.pdu;

public class DeliveryInd extends GenericPdu
{
  public DeliveryInd()
  {
    a(134);
  }

  DeliveryInd(PduHeaders paramPduHeaders)
  {
    super(paramPduHeaders);
  }

  public long a()
  {
    return this.a.e(133);
  }

  public byte[] b()
  {
    return this.a.b(139);
  }

  public int c()
  {
    return this.a.a(149);
  }

  public EncodedStringValue[] d()
  {
    return this.a.d(151);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.DeliveryInd
 * JD-Core Version:    0.6.0
 */