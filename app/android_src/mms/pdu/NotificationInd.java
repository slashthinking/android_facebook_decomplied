package android_src.mms.pdu;

public class NotificationInd extends GenericPdu
{
  public NotificationInd()
  {
    a(130);
  }

  NotificationInd(PduHeaders paramPduHeaders)
  {
    super(paramPduHeaders);
  }

  public int a()
  {
    return this.a.a(186);
  }

  public void a(EncodedStringValue paramEncodedStringValue)
  {
    this.a.a(paramEncodedStringValue, 137);
  }

  public void a(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte, 131);
  }

  public byte[] b()
  {
    return this.a.b(131);
  }

  public long c()
  {
    return this.a.e(136);
  }

  public byte[] d()
  {
    return this.a.b(138);
  }

  public EncodedStringValue h()
  {
    return this.a.c(137);
  }

  public long i()
  {
    return this.a.e(142);
  }

  public EncodedStringValue j()
  {
    return this.a.c(150);
  }

  public byte[] k()
  {
    return this.a.b(152);
  }

  public int l()
  {
    return this.a.a(134);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.NotificationInd
 * JD-Core Version:    0.6.0
 */