package android_src.mms.pdu;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

public class PduComposer
{
  private static HashMap<String, Integer> h;
  protected ByteArrayOutputStream a = null;
  protected int b = 0;
  private GenericPdu d = null;
  private PduComposer.BufferStack e = null;
  private final ContentResolver f;
  private PduHeaders g = null;

  static
  {
    int i = 0;
    if (!PduComposer.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      c = bool;
      h = null;
      h = new HashMap();
      while (i < PduContentTypes.a.length)
      {
        h.put(PduContentTypes.a[i], Integer.valueOf(i));
        i++;
      }
    }
  }

  public PduComposer(Context paramContext, GenericPdu paramGenericPdu)
  {
    this.d = paramGenericPdu;
    this.f = paramContext.getContentResolver();
    this.g = paramGenericPdu.e();
    this.e = new PduComposer.BufferStack(this, null);
    this.a = new ByteArrayOutputStream();
    this.b = 0;
  }

  private int b()
  {
    int i = 1;
    if (this.a == null)
    {
      this.a = new ByteArrayOutputStream();
      this.b = 0;
    }
    c(140);
    c(135);
    if (e(141) != 0);
    while (true)
    {
      return i;
      if ((e(139) != 0) || (e(151) != 0) || (e(137) != 0))
        continue;
      e(133);
      if (e(155) != 0)
        continue;
      i = 0;
    }
  }

  private EncodedStringValue b(EncodedStringValue paramEncodedStringValue)
  {
    try
    {
      int i = c(paramEncodedStringValue.c());
      localEncodedStringValue = EncodedStringValue.a(paramEncodedStringValue);
      if (1 == i)
        localEncodedStringValue.b("/TYPE=PLMN".getBytes());
      else if (3 == i)
        localEncodedStringValue.b("/TYPE=IPV4".getBytes());
      else if (4 == i)
        localEncodedStringValue.b("/TYPE=IPV6".getBytes());
      return localEncodedStringValue;
    }
    catch (NullPointerException localNullPointerException)
    {
      while (true)
        EncodedStringValue localEncodedStringValue = null;
    }
  }

  private int c()
  {
    int i = 1;
    if (this.a == null)
    {
      this.a = new ByteArrayOutputStream();
      this.b = 0;
    }
    c(140);
    c(131);
    if (e(152) != 0);
    while (true)
    {
      return i;
      if ((e(141) != 0) || (e(149) != 0))
        continue;
      i = 0;
    }
  }

  protected static int c(String paramString)
  {
    int i = 5;
    if (paramString == null);
    while (true)
    {
      return i;
      if (paramString.matches("[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}"))
      {
        i = 3;
        continue;
      }
      if (paramString.matches("\\+?[0-9|\\.|\\-]+"))
      {
        i = 1;
        continue;
      }
      if (paramString.matches("[a-zA-Z| ]*\\<{0,1}[a-zA-Z| ]+@{1}[a-zA-Z| ]+\\.{1}[a-zA-Z| ]+\\>{0,1}"))
      {
        i = 2;
        continue;
      }
      if (!paramString.matches("[a-fA-F]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}"))
        continue;
      i = 4;
    }
  }

  private int d()
  {
    int i = 1;
    if (this.a == null)
    {
      this.a = new ByteArrayOutputStream();
      this.b = 0;
    }
    c(140);
    c(133);
    if (e(152) != 0);
    while (true)
    {
      return i;
      if (e(141) != 0)
        continue;
      e(145);
      i = 0;
    }
  }

  private int e()
  {
    int i = 1;
    if (this.a == null)
    {
      this.a = new ByteArrayOutputStream();
      this.b = 0;
    }
    c(140);
    c(128);
    c(152);
    byte[] arrayOfByte = this.g.b(152);
    if (arrayOfByte == null)
      throw new IllegalArgumentException("Transaction-ID is null.");
    a(arrayOfByte);
    if (e(141) != 0);
    do
    {
      return i;
      e(133);
    }
    while (e(137) != 0);
    if (e(151) != i);
    for (int j = i; ; j = 0)
    {
      if (e(130) != i)
        j = i;
      if (e(129) != i)
        j = i;
      if (j == 0)
        break;
      e(150);
      e(138);
      e(136);
      e(143);
      e(134);
      e(144);
      c(132);
      f();
      i = 0;
      break;
    }
  }

  private int e(int paramInt)
  {
    int j;
    switch (paramInt)
    {
    case 131:
    case 132:
    case 135:
    case 140:
    case 142:
    case 146:
    case 147:
    case 148:
    case 153:
    case 154:
    default:
      j = 3;
    case 141:
    case 139:
    case 152:
    case 129:
    case 130:
    case 151:
    case 137:
    case 134:
    case 143:
    case 144:
    case 145:
    case 149:
    case 155:
    case 133:
    case 150:
    case 138:
    case 136:
    }
    while (true)
    {
      return j;
      c(paramInt);
      int i2 = this.g.a(paramInt);
      if (i2 == 0)
      {
        b(18);
        j = 0;
        continue;
      }
      b(i2);
      j = 0;
      continue;
      byte[] arrayOfByte2 = this.g.b(paramInt);
      if (arrayOfByte2 == null)
      {
        j = 2;
        continue;
      }
      c(paramInt);
      a(arrayOfByte2);
      j = 0;
      continue;
      EncodedStringValue[] arrayOfEncodedStringValue = this.g.d(paramInt);
      if (arrayOfEncodedStringValue == null)
      {
        j = 2;
        continue;
      }
      for (int n = 0; ; n++)
      {
        int i1 = arrayOfEncodedStringValue.length;
        j = 0;
        if (n >= i1)
          break;
        EncodedStringValue localEncodedStringValue4 = b(arrayOfEncodedStringValue[n]);
        if (localEncodedStringValue4 == null)
        {
          j = 1;
          break;
        }
        c(paramInt);
        a(localEncodedStringValue4);
      }
      c(paramInt);
      EncodedStringValue localEncodedStringValue2 = this.g.c(paramInt);
      if ((localEncodedStringValue2 == null) || (TextUtils.isEmpty(localEncodedStringValue2.c())) || (new String(localEncodedStringValue2.b()).equals("insert-address-token")))
      {
        a(1);
        a(129);
        j = 0;
        continue;
      }
      this.e.a();
      PduComposer.PositionMarker localPositionMarker2 = this.e.d();
      a(128);
      EncodedStringValue localEncodedStringValue3 = b(localEncodedStringValue2);
      if (localEncodedStringValue3 == null)
      {
        j = 1;
        continue;
      }
      a(localEncodedStringValue3);
      int m = localPositionMarker2.a();
      this.e.b();
      d(m);
      this.e.c();
      j = 0;
      continue;
      int k = this.g.a(paramInt);
      if (k == 0)
      {
        j = 2;
        continue;
      }
      c(paramInt);
      c(k);
      j = 0;
      continue;
      long l2 = this.g.e(paramInt);
      if (-1L == l2)
      {
        j = 2;
        continue;
      }
      c(paramInt);
      c(l2);
      j = 0;
      continue;
      EncodedStringValue localEncodedStringValue1 = this.g.c(paramInt);
      if (localEncodedStringValue1 == null)
      {
        j = 2;
        continue;
      }
      c(paramInt);
      a(localEncodedStringValue1);
      j = 0;
      continue;
      byte[] arrayOfByte1 = this.g.b(paramInt);
      if (arrayOfByte1 == null)
      {
        j = 2;
        continue;
      }
      c(paramInt);
      if (Arrays.equals(arrayOfByte1, "advertisement".getBytes()))
      {
        c(129);
        j = 0;
        continue;
      }
      if (Arrays.equals(arrayOfByte1, "auto".getBytes()))
      {
        c(131);
        j = 0;
        continue;
      }
      if (Arrays.equals(arrayOfByte1, "personal".getBytes()))
      {
        c(128);
        j = 0;
        continue;
      }
      if (Arrays.equals(arrayOfByte1, "informational".getBytes()))
      {
        c(130);
        j = 0;
        continue;
      }
      a(arrayOfByte1);
      j = 0;
      continue;
      long l1 = this.g.e(paramInt);
      if (-1L == l1)
      {
        j = 2;
        continue;
      }
      c(paramInt);
      this.e.a();
      PduComposer.PositionMarker localPositionMarker1 = this.e.d();
      a(129);
      a(l1);
      int i = localPositionMarker1.a();
      this.e.b();
      d(i);
      this.e.c();
      j = 0;
    }
  }

  private int f()
  {
    this.e.a();
    PduComposer.PositionMarker localPositionMarker1 = this.e.d();
    String str = new String(this.g.b(132));
    Integer localInteger1 = (Integer)h.get(str);
    int i;
    if (localInteger1 == null)
      i = 1;
    while (true)
    {
      return i;
      b(localInteger1.intValue());
      PduBody localPduBody = ((SendReq)this.d).a();
      if ((localPduBody == null) || (localPduBody.b() == 0))
      {
        b(0L);
        this.e.b();
        this.e.c();
        i = 0;
        continue;
      }
      while (true)
      {
        int m;
        label429: int i2;
        int i3;
        try
        {
          PduPart localPduPart2 = localPduBody.a(0);
          byte[] arrayOfByte7 = localPduPart2.c();
          if (arrayOfByte7 == null)
            continue;
          c(138);
          if ((60 != arrayOfByte7[0]) || (62 != arrayOfByte7[(-1 + arrayOfByte7.length)]))
            continue;
          a(arrayOfByte7);
          c(137);
          a(localPduPart2.g());
          int j = localPositionMarker1.a();
          this.e.b();
          d(j);
          this.e.c();
          int k = localPduBody.b();
          b(k);
          m = 0;
          if (m >= k)
            break label796;
          localPduPart1 = localPduBody.a(m);
          this.e.a();
          localPositionMarker2 = this.e.d();
          this.e.a();
          localPositionMarker3 = this.e.d();
          arrayOfByte1 = localPduPart1.g();
          if (arrayOfByte1 != null)
            continue;
          i = 1;
          break;
          a("<" + new String(arrayOfByte7) + ">");
          continue;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          while (true)
          {
            PduPart localPduPart1;
            PduComposer.PositionMarker localPositionMarker2;
            PduComposer.PositionMarker localPositionMarker3;
            byte[] arrayOfByte1;
            localArrayIndexOutOfBoundsException.printStackTrace();
            continue;
            Integer localInteger2 = (Integer)h.get(new String(arrayOfByte1));
            if (localInteger2 == null)
              a(arrayOfByte1);
            byte[] arrayOfByte2;
            while (true)
            {
              arrayOfByte2 = localPduPart1.i();
              if (arrayOfByte2 != null)
                break label429;
              arrayOfByte2 = localPduPart1.j();
              if (arrayOfByte2 != null)
                break label429;
              arrayOfByte2 = localPduPart1.e();
              if (arrayOfByte2 != null)
                break label429;
              i = 1;
              break;
              b(localInteger2.intValue());
            }
            c(133);
            a(arrayOfByte2);
            int n = localPduPart1.d();
            if (n != 0)
            {
              c(129);
              b(n);
            }
            int i1 = localPositionMarker3.a();
            this.e.b();
            d(i1);
            this.e.c();
            byte[] arrayOfByte3 = localPduPart1.c();
            if (arrayOfByte3 != null)
            {
              c(192);
              if ((60 != arrayOfByte3[0]) || (62 != arrayOfByte3[(-1 + arrayOfByte3.length)]))
                break label625;
              b(arrayOfByte3);
            }
            while (true)
            {
              byte[] arrayOfByte4 = localPduPart1.e();
              if (arrayOfByte4 != null)
              {
                c(142);
                a(arrayOfByte4);
              }
              i2 = localPositionMarker2.a();
              byte[] arrayOfByte5 = localPduPart1.a();
              if (arrayOfByte5 == null)
                break;
              a(arrayOfByte5, 0, arrayOfByte5.length);
              i3 = arrayOfByte5.length;
              if (i3 == localPositionMarker2.a() - i2)
                break label762;
              throw new RuntimeException("BUG: Length sanity check failed");
              label625: b("<" + new String(arrayOfByte3) + ">");
            }
            try
            {
              byte[] arrayOfByte6 = new byte[1024];
              InputStream localInputStream = this.f.openInputStream(localPduPart1.b());
              i3 = 0;
              while (true)
              {
                int i4 = localInputStream.read(arrayOfByte6);
                if (i4 == -1)
                  break;
                this.a.write(arrayOfByte6, 0, i4);
                this.b = (i4 + this.b);
                i3 += i4;
              }
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              i = 1;
            }
            catch (IOException localIOException)
            {
              i = 1;
            }
            catch (RuntimeException localRuntimeException)
            {
              i = 1;
            }
          }
        }
        break;
        label762: this.e.b();
        b(i2);
        b(i3);
        this.e.c();
        m++;
      }
      label796: i = 0;
    }
  }

  protected void a(int paramInt)
  {
    this.a.write(paramInt);
    this.b = (1 + this.b);
  }

  protected void a(long paramLong)
  {
    int i = 0;
    long l = paramLong;
    for (int j = 0; (l != 0L) && (j < 8); j++)
      l >>>= 8;
    d(j);
    int k = 8 * (j - 1);
    while (i < j)
    {
      a((int)(0xFF & paramLong >>> k));
      k -= 8;
      i++;
    }
  }

  protected void a(EncodedStringValue paramEncodedStringValue)
  {
    if ((!c) && (paramEncodedStringValue == null))
      throw new AssertionError();
    int i = paramEncodedStringValue.a();
    byte[] arrayOfByte = paramEncodedStringValue.b();
    if (arrayOfByte == null);
    while (true)
    {
      return;
      this.e.a();
      PduComposer.PositionMarker localPositionMarker = this.e.d();
      b(i);
      a(arrayOfByte);
      int j = localPositionMarker.a();
      this.e.b();
      d(j);
      this.e.c();
    }
  }

  protected void a(String paramString)
  {
    a(paramString.getBytes());
  }

  protected void a(byte[] paramArrayOfByte)
  {
    if ((0xFF & paramArrayOfByte[0]) > 127)
      a(127);
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
    a(0);
  }

  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
    this.b = (paramInt2 + this.b);
  }

  public byte[] a()
  {
    int i = this.d.f();
    byte[] arrayOfByte = null;
    switch (i)
    {
    case 129:
    case 130:
    case 132:
    case 134:
    default:
    case 128:
    case 131:
    case 133:
    case 135:
    }
    while (true)
    {
      return arrayOfByte;
      int j = e();
      arrayOfByte = null;
      if (j != 0)
        continue;
      do
      {
        do
        {
          do
          {
            arrayOfByte = this.a.toByteArray();
            break;
          }
          while (c() == 0);
          arrayOfByte = null;
          break;
        }
        while (d() == 0);
        arrayOfByte = null;
        break;
      }
      while (b() == 0);
      arrayOfByte = null;
    }
  }

  protected void b(int paramInt)
  {
    a(0xFF & (paramInt | 0x80));
  }

  protected void b(long paramLong)
  {
    int i = 0;
    long l = 127L;
    while (true)
    {
      if ((i >= 5) || (paramLong < l))
        while (i > 0)
        {
          a((int)(0xFF & (0x80 | 0x7F & paramLong >>> i * 7)));
          i--;
        }
      l = 0x7F | l << 7;
      i++;
    }
    a((int)(paramLong & 0x7F));
  }

  protected void b(String paramString)
  {
    b(paramString.getBytes());
  }

  protected void b(byte[] paramArrayOfByte)
  {
    a(34);
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
    a(0);
  }

  protected void c(int paramInt)
  {
    a(paramInt);
  }

  protected void c(long paramLong)
  {
    a(paramLong);
  }

  protected void d(int paramInt)
  {
    a(paramInt);
  }

  protected void d(long paramLong)
  {
    if (paramLong < 31L)
      d((int)paramLong);
    while (true)
    {
      return;
      a(31);
      b(paramLong);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.PduComposer
 * JD-Core Version:    0.6.0
 */