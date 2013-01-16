package android_src.mms.pdu;

import android_src.mms.InvalidHeaderValueException;
import com.facebook.orca.debug.BLog;

public class SendReq extends MultimediaMessagePdu
{
  public SendReq()
  {
    try
    {
      a(128);
      b(18);
      a("application/vnd.wap.multipart.related".getBytes());
      a(new EncodedStringValue("insert-address-token".getBytes()));
      c(c());
      return;
    }
    catch (InvalidHeaderValueException localInvalidHeaderValueException)
    {
      BLog.d("SendReq", "Unexpected InvalidHeaderValueException.", localInvalidHeaderValueException);
    }
    throw new RuntimeException(localInvalidHeaderValueException);
  }

  SendReq(PduHeaders paramPduHeaders, PduBody paramPduBody)
  {
    super(paramPduHeaders, paramPduBody);
  }

  private byte[] c()
  {
    return ("T" + Long.toHexString(System.currentTimeMillis())).getBytes();
  }

  public void a(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte, 132);
  }

  public void a(EncodedStringValue[] paramArrayOfEncodedStringValue)
  {
    this.a.a(paramArrayOfEncodedStringValue, 151);
  }

  public void b(long paramLong)
  {
    this.a.a(paramLong, 136);
  }

  public void b(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte, 138);
  }

  public byte[] b()
  {
    return this.a.b(152);
  }

  public void c(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte, 152);
  }

  public void d(int paramInt)
  {
    this.a.a(paramInt, 134);
  }

  public void e(int paramInt)
  {
    this.a.a(paramInt, 144);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.SendReq
 * JD-Core Version:    0.6.0
 */