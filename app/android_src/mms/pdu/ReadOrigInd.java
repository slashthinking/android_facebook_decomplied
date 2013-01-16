package android_src.mms.pdu;

public class ReadOrigInd extends GenericPdu
{
  public ReadOrigInd()
  {
    a(136);
  }

  ReadOrigInd(PduHeaders paramPduHeaders)
  {
    super(paramPduHeaders);
  }

  public long a()
  {
    return this.a.e(133);
  }

  public void a(EncodedStringValue paramEncodedStringValue)
  {
    this.a.a(paramEncodedStringValue, 137);
  }

  public byte[] b()
  {
    return this.a.b(139);
  }

  public int c()
  {
    return this.a.a(155);
  }

  public EncodedStringValue[] d()
  {
    return this.a.d(151);
  }

  public EncodedStringValue h()
  {
    return this.a.c(137);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.ReadOrigInd
 * JD-Core Version:    0.6.0
 */