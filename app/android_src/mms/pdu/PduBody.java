package android_src.mms.pdu;

import java.util.Map;
import java.util.Vector;

public class PduBody
{
  private Vector<PduPart> a = null;
  private Map<String, PduPart> b = null;
  private Map<String, PduPart> c = null;
  private Map<String, PduPart> d = null;
  private Map<String, PduPart> e = null;

  private void b(PduPart paramPduPart)
  {
    byte[] arrayOfByte1 = paramPduPart.c();
    if (arrayOfByte1 != null)
      this.b.put(new String(arrayOfByte1), paramPduPart);
    byte[] arrayOfByte2 = paramPduPart.e();
    if (arrayOfByte2 != null)
    {
      String str1 = new String(arrayOfByte2);
      this.c.put(str1, paramPduPart);
    }
    byte[] arrayOfByte3 = paramPduPart.i();
    if (arrayOfByte3 != null)
    {
      String str2 = new String(arrayOfByte3);
      this.d.put(str2, paramPduPart);
    }
    byte[] arrayOfByte4 = paramPduPart.j();
    if (arrayOfByte4 != null)
    {
      String str3 = new String(arrayOfByte4);
      this.e.put(str3, paramPduPart);
    }
  }

  public PduPart a(int paramInt)
  {
    return (PduPart)this.a.get(paramInt);
  }

  public void a()
  {
    this.a.clear();
  }

  public void a(int paramInt, PduPart paramPduPart)
  {
    if (paramPduPart == null)
      throw new NullPointerException();
    b(paramPduPart);
    this.a.add(paramInt, paramPduPart);
  }

  public boolean a(PduPart paramPduPart)
  {
    if (paramPduPart == null)
      throw new NullPointerException();
    b(paramPduPart);
    return this.a.add(paramPduPart);
  }

  public int b()
  {
    return this.a.size();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.PduBody
 * JD-Core Version:    0.6.0
 */