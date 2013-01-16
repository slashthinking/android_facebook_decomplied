package android_src.mms.pdu;

public class NotifyRespInd extends GenericPdu
{
  public NotifyRespInd(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    a(131);
    b(paramInt1);
    a(paramArrayOfByte);
    c(paramInt2);
  }

  NotifyRespInd(PduHeaders paramPduHeaders)
  {
    super(paramPduHeaders);
  }

  public void a(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte, 152);
  }

  public void c(int paramInt)
  {
    this.a.a(paramInt, 149);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.NotifyRespInd
 * JD-Core Version:    0.6.0
 */