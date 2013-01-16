package android_src.mms.pdu;

public class AcknowledgeInd extends GenericPdu
{
  public AcknowledgeInd(int paramInt, byte[] paramArrayOfByte)
  {
    a(133);
    b(paramInt);
    a(paramArrayOfByte);
  }

  AcknowledgeInd(PduHeaders paramPduHeaders)
  {
    super(paramPduHeaders);
  }

  public void a(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte, 152);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.AcknowledgeInd
 * JD-Core Version:    0.6.0
 */