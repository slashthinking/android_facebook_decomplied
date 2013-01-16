package android_src.mms.pdu;

public class GenericPdu
{
  PduHeaders a = null;

  public GenericPdu()
  {
    this.a = new PduHeaders();
  }

  GenericPdu(PduHeaders paramPduHeaders)
  {
    this.a = paramPduHeaders;
  }

  public void a(int paramInt)
  {
    this.a.a(paramInt, 140);
  }

  public void a(EncodedStringValue paramEncodedStringValue)
  {
    this.a.a(paramEncodedStringValue, 137);
  }

  public void b(int paramInt)
  {
    this.a.a(paramInt, 141);
  }

  PduHeaders e()
  {
    return this.a;
  }

  public int f()
  {
    return this.a.a(140);
  }

  public int g()
  {
    return this.a.a(141);
  }

  public EncodedStringValue h()
  {
    return this.a.c(137);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.GenericPdu
 * JD-Core Version:    0.6.0
 */