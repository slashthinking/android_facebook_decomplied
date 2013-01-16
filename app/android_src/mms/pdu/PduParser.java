package android_src.mms.pdu;

import android.content.res.Resources;
import com.facebook.orca.debug.BLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;

public class PduParser
{
  private static byte[] e;
  private static byte[] f;
  private ByteArrayInputStream b = null;
  private PduHeaders c = null;
  private PduBody d = null;

  static
  {
    if (!PduParser.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      e = null;
      f = null;
      return;
    }
  }

  public PduParser(byte[] paramArrayOfByte)
  {
    this.b = new ByteArrayInputStream(paramArrayOfByte);
  }

  private static int a(PduPart paramPduPart)
  {
    int i = 1;
    if ((!a) && (paramPduPart == null))
      throw new AssertionError();
    if ((e == null) && (f == null));
    while (true)
    {
      return i;
      if (f != null)
      {
        byte[] arrayOfByte2 = paramPduPart.c();
        if ((arrayOfByte2 != null) && (i == Arrays.equals(f, arrayOfByte2)))
        {
          i = 0;
          continue;
        }
      }
      if (e == null)
        continue;
      byte[] arrayOfByte1 = paramPduPart.g();
      if ((arrayOfByte1 == null) || (i != Arrays.equals(e, arrayOfByte1)))
        continue;
      i = 0;
    }
  }

  protected static void a(ByteArrayInputStream paramByteArrayInputStream, HashMap<Integer, Object> paramHashMap, Integer paramInteger)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    if ((!a) && (paramInteger.intValue() <= 0))
      throw new AssertionError();
    int i = paramByteArrayInputStream.available();
    int j = paramInteger.intValue();
    while (j > 0)
    {
      int k = paramByteArrayInputStream.read();
      if ((!a) && (-1 == k))
        throw new AssertionError();
      j--;
      switch (k)
      {
      default:
        if (-1 == c(paramByteArrayInputStream, j))
          BLog.e("PduParser", "Corrupt Content-Type");
        break;
      case 131:
      case 137:
        paramByteArrayInputStream.mark(1);
        int i5 = f(paramByteArrayInputStream);
        paramByteArrayInputStream.reset();
        if (i5 > 127)
        {
          int i7 = g(paramByteArrayInputStream);
          if (i7 < PduContentTypes.a.length)
          {
            byte[] arrayOfByte5 = PduContentTypes.a[i7].getBytes();
            paramHashMap.put(Integer.valueOf(131), arrayOfByte5);
          }
        }
        while (true)
        {
          int i6 = paramByteArrayInputStream.available();
          j = paramInteger.intValue() - (i - i6);
          break;
          byte[] arrayOfByte4 = a(paramByteArrayInputStream, 0);
          if ((arrayOfByte4 == null) || (paramHashMap == null))
            continue;
          paramHashMap.put(Integer.valueOf(131), arrayOfByte4);
        }
      case 138:
      case 153:
        byte[] arrayOfByte3 = a(paramByteArrayInputStream, 0);
        if ((arrayOfByte3 != null) && (paramHashMap != null))
          paramHashMap.put(Integer.valueOf(153), arrayOfByte3);
        int i4 = paramByteArrayInputStream.available();
        j = paramInteger.intValue() - (i - i4);
        break;
      case 129:
        paramByteArrayInputStream.mark(1);
        int n = f(paramByteArrayInputStream);
        paramByteArrayInputStream.reset();
        byte[] arrayOfByte2;
        if (((n > 32) && (n < 127)) || (n == 0))
          arrayOfByte2 = a(paramByteArrayInputStream, 0);
        while (true)
        {
          try
          {
            int i3 = CharacterSets.a(new String(arrayOfByte2));
            paramHashMap.put(Integer.valueOf(129), Integer.valueOf(i3));
            int i2 = paramByteArrayInputStream.available();
            j = paramInteger.intValue() - (i - i2);
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            BLog.d("PduParser", Arrays.toString(arrayOfByte2), localUnsupportedEncodingException);
            paramHashMap.put(Integer.valueOf(129), Integer.valueOf(0));
            continue;
          }
          int i1 = (int)i(paramByteArrayInputStream);
          if (paramHashMap == null)
            continue;
          paramHashMap.put(Integer.valueOf(129), Integer.valueOf(i1));
        }
      case 133:
      case 151:
        byte[] arrayOfByte1 = a(paramByteArrayInputStream, 0);
        if ((arrayOfByte1 != null) && (paramHashMap != null))
          paramHashMap.put(Integer.valueOf(151), arrayOfByte1);
        int m = paramByteArrayInputStream.available();
        j = paramInteger.intValue() - (i - m);
        continue;
        j = 0;
      }
    }
    if (j != 0)
      BLog.e("PduParser", "Corrupt Content-Type");
  }

  private static void a(String paramString)
  {
  }

  protected static boolean a(int paramInt)
  {
    int i = 0;
    if (paramInt >= 33)
    {
      i = 0;
      if (paramInt <= 126)
        break label18;
    }
    while (true)
    {
      return i;
      label18: i = 0;
      switch (paramInt)
      {
      case 34:
      case 40:
      case 41:
      case 44:
      case 47:
      case 58:
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 91:
      case 92:
      case 93:
      case 123:
      case 125:
      }
      i = 1;
    }
  }

  protected static boolean a(PduHeaders paramPduHeaders)
  {
    int i = 0;
    if (paramPduHeaders == null);
    while (true)
    {
      return i;
      int j = paramPduHeaders.a(140);
      int k = paramPduHeaders.a(141);
      i = 0;
      if (k == 0)
        continue;
      switch (j)
      {
      default:
        i = 0;
        break;
      case 128:
        byte[] arrayOfByte7 = paramPduHeaders.b(132);
        i = 0;
        if (arrayOfByte7 == null)
          continue;
        EncodedStringValue localEncodedStringValue3 = paramPduHeaders.c(137);
        i = 0;
        if (localEncodedStringValue3 == null)
          continue;
        byte[] arrayOfByte8 = paramPduHeaders.b(152);
        i = 0;
        if (arrayOfByte8 == null)
          continue;
      case 129:
      case 130:
      case 131:
      case 132:
      case 134:
      case 133:
      case 136:
      case 135:
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        i = 1;
                        break;
                        int i3 = paramPduHeaders.a(146);
                        i = 0;
                        if (i3 == 0)
                          break;
                      }
                      while (paramPduHeaders.b(152) != null);
                      i = 0;
                      break;
                      byte[] arrayOfByte5 = paramPduHeaders.b(131);
                      i = 0;
                      if (arrayOfByte5 == null)
                        break;
                      boolean bool3 = -1L < paramPduHeaders.e(136);
                      i = 0;
                      if (!bool3)
                        break;
                      byte[] arrayOfByte6 = paramPduHeaders.b(138);
                      i = 0;
                      if (arrayOfByte6 == null)
                        break;
                      boolean bool4 = -1L < paramPduHeaders.e(142);
                      i = 0;
                      if (!bool4)
                        break;
                    }
                    while (paramPduHeaders.b(152) != null);
                    i = 0;
                    break;
                    int i2 = paramPduHeaders.a(149);
                    i = 0;
                    if (i2 == 0)
                      break;
                  }
                  while (paramPduHeaders.b(152) != null);
                  i = 0;
                  break;
                  byte[] arrayOfByte4 = paramPduHeaders.b(132);
                  i = 0;
                  if (arrayOfByte4 == null)
                    break;
                }
                while (-1L != paramPduHeaders.e(133));
                i = 0;
                break;
                boolean bool2 = -1L < paramPduHeaders.e(133);
                i = 0;
                if (!bool2)
                  break;
                byte[] arrayOfByte3 = paramPduHeaders.b(139);
                i = 0;
                if (arrayOfByte3 == null)
                  break;
                int i1 = paramPduHeaders.a(149);
                i = 0;
                if (i1 == 0)
                  break;
              }
              while (paramPduHeaders.d(151) != null);
              i = 0;
              break;
            }
            while (paramPduHeaders.b(152) != null);
            i = 0;
            break;
            boolean bool1 = -1L < paramPduHeaders.e(133);
            i = 0;
            if (!bool1)
              break;
            EncodedStringValue localEncodedStringValue2 = paramPduHeaders.c(137);
            i = 0;
            if (localEncodedStringValue2 == null)
              break;
            byte[] arrayOfByte2 = paramPduHeaders.b(139);
            i = 0;
            if (arrayOfByte2 == null)
              break;
            int n = paramPduHeaders.a(155);
            i = 0;
            if (n == 0)
              break;
          }
          while (paramPduHeaders.d(151) != null);
          i = 0;
          break;
          EncodedStringValue localEncodedStringValue1 = paramPduHeaders.c(137);
          i = 0;
          if (localEncodedStringValue1 == null)
            break;
          byte[] arrayOfByte1 = paramPduHeaders.b(139);
          i = 0;
          if (arrayOfByte1 == null)
            break;
          int m = paramPduHeaders.a(155);
          i = 0;
          if (m == 0)
            break;
        }
        while (paramPduHeaders.d(151) != null);
        i = 0;
      }
    }
  }

  protected static boolean a(ByteArrayInputStream paramByteArrayInputStream, PduPart paramPduPart, int paramInt)
  {
    int i = 0;
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    if ((!a) && (paramPduPart == null))
      throw new AssertionError();
    if ((!a) && (paramInt <= 0))
      throw new AssertionError();
    int j = paramByteArrayInputStream.available();
    int k = paramInt;
    int m;
    if (k > 0)
    {
      m = paramByteArrayInputStream.read();
      if ((!a) && (-1 == m))
        throw new AssertionError();
      k--;
      if (m > 127)
        switch (m)
        {
        default:
          if (-1 != c(paramByteArrayInputStream, k))
            break;
          BLog.e("PduParser", "Corrupt Part headers");
        case 142:
        case 192:
        case 174:
        case 197:
        }
    }
    while (true)
    {
      return i;
      byte[] arrayOfByte4 = a(paramByteArrayInputStream, 0);
      if (arrayOfByte4 != null)
        paramPduPart.c(arrayOfByte4);
      k = paramInt - (j - paramByteArrayInputStream.available());
      break;
      byte[] arrayOfByte3 = a(paramByteArrayInputStream, 1);
      if (arrayOfByte3 != null)
        paramPduPart.b(arrayOfByte3);
      k = paramInt - (j - paramByteArrayInputStream.available());
      break;
      int n = Resources.getSystem().getIdentifier("config_mms_content_disposition_support", "bool", "android");
      if (!Resources.getSystem().getBoolean(n))
        break;
      int i1 = d(paramByteArrayInputStream);
      paramByteArrayInputStream.mark(1);
      int i2 = paramByteArrayInputStream.available();
      int i3 = paramByteArrayInputStream.read();
      if (i3 == 128)
        paramPduPart.d(PduPart.a);
      while (true)
      {
        if (i2 - paramByteArrayInputStream.available() < i1)
        {
          if (paramByteArrayInputStream.read() == 152)
            paramPduPart.h(a(paramByteArrayInputStream, 0));
          int i4 = paramByteArrayInputStream.available();
          if (i2 - i4 < i1)
          {
            int i5 = i1 - (i2 - i4);
            paramByteArrayInputStream.read(new byte[i5], 0, i5);
          }
        }
        k = paramInt - (j - paramByteArrayInputStream.available());
        break;
        if (i3 == 129)
        {
          paramPduPart.d(PduPart.b);
          continue;
        }
        if (i3 == 130)
        {
          paramPduPart.d(PduPart.c);
          continue;
        }
        paramByteArrayInputStream.reset();
        paramPduPart.d(a(paramByteArrayInputStream, 0));
      }
      k = 0;
      break;
      if ((m >= 32) && (m <= 127))
      {
        byte[] arrayOfByte1 = a(paramByteArrayInputStream, 0);
        byte[] arrayOfByte2 = a(paramByteArrayInputStream, 0);
        if (true == "Content-Transfer-Encoding".equalsIgnoreCase(new String(arrayOfByte1)))
          paramPduPart.f(arrayOfByte2);
        k = paramInt - (j - paramByteArrayInputStream.available());
        break;
      }
      if (-1 == c(paramByteArrayInputStream, k))
      {
        BLog.e("PduParser", "Corrupt Part headers");
        i = 0;
        continue;
      }
      k = 0;
      break;
      if (k != 0)
      {
        BLog.e("PduParser", "Corrupt Part headers");
        i = 0;
        continue;
      }
      i = 1;
    }
  }

  protected static byte[] a(ByteArrayInputStream paramByteArrayInputStream, int paramInt)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    paramByteArrayInputStream.mark(1);
    int i = paramByteArrayInputStream.read();
    if ((!a) && (-1 == i))
      throw new AssertionError();
    if ((1 == paramInt) && (34 == i))
      paramByteArrayInputStream.mark(1);
    while (true)
    {
      return b(paramByteArrayInputStream, paramInt);
      if ((paramInt == 0) && (127 == i))
      {
        paramByteArrayInputStream.mark(1);
        continue;
      }
      paramByteArrayInputStream.reset();
    }
  }

  protected static byte[] a(ByteArrayInputStream paramByteArrayInputStream, HashMap<Integer, Object> paramHashMap)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    paramByteArrayInputStream.mark(1);
    int i = paramByteArrayInputStream.read();
    if ((!a) && (-1 == i))
      throw new AssertionError();
    paramByteArrayInputStream.reset();
    int j = i & 0xFF;
    int i1;
    byte[] arrayOfByte;
    if (j < 32)
    {
      int k = d(paramByteArrayInputStream);
      int m = paramByteArrayInputStream.available();
      paramByteArrayInputStream.mark(1);
      int n = paramByteArrayInputStream.read();
      if ((!a) && (-1 == n))
        throw new AssertionError();
      paramByteArrayInputStream.reset();
      i1 = n & 0xFF;
      if ((i1 >= 32) && (i1 <= 127))
      {
        arrayOfByte = a(paramByteArrayInputStream, 0);
        int i3 = k - (m - paramByteArrayInputStream.available());
        if (i3 > 0)
          a(paramByteArrayInputStream, paramHashMap, Integer.valueOf(i3));
        if (i3 < 0)
        {
          BLog.e("PduParser", "Corrupt MMS message");
          arrayOfByte = PduContentTypes.a[0].getBytes();
        }
      }
    }
    while (true)
    {
      return arrayOfByte;
      if (i1 > 127)
      {
        int i2 = g(paramByteArrayInputStream);
        if (i2 < PduContentTypes.a.length)
        {
          arrayOfByte = PduContentTypes.a[i2].getBytes();
          break;
        }
        paramByteArrayInputStream.reset();
        arrayOfByte = a(paramByteArrayInputStream, 0);
        break;
      }
      BLog.e("PduParser", "Corrupt content-type");
      arrayOfByte = PduContentTypes.a[0].getBytes();
      continue;
      if (j <= 127)
      {
        arrayOfByte = a(paramByteArrayInputStream, 0);
        continue;
      }
      arrayOfByte = PduContentTypes.a[g(paramByteArrayInputStream)].getBytes();
    }
  }

  protected static PduBody b(ByteArrayInputStream paramByteArrayInputStream)
  {
    Object localObject;
    if (paramByteArrayInputStream == null)
      localObject = null;
    while (true)
    {
      return localObject;
      int i = c(paramByteArrayInputStream);
      PduBody localPduBody = new PduBody();
      int j = 0;
      label25: if (j < i)
      {
        int k = c(paramByteArrayInputStream);
        int m = c(paramByteArrayInputStream);
        PduPart localPduPart1 = new PduPart();
        int n = paramByteArrayInputStream.available();
        if (n <= 0)
        {
          localObject = null;
          continue;
        }
        HashMap localHashMap = new HashMap();
        byte[] arrayOfByte1 = a(paramByteArrayInputStream, localHashMap);
        if (arrayOfByte1 != null)
          localPduPart1.e(arrayOfByte1);
        int i1;
        while (true)
        {
          byte[] arrayOfByte2 = (byte[])(byte[])localHashMap.get(Integer.valueOf(151));
          if (arrayOfByte2 != null)
            localPduPart1.g(arrayOfByte2);
          Integer localInteger = (Integer)localHashMap.get(Integer.valueOf(129));
          if (localInteger != null)
            localPduPart1.a(localInteger.intValue());
          i1 = k - (n - paramByteArrayInputStream.available());
          if (i1 <= 0)
            break label209;
          if (a(paramByteArrayInputStream, localPduPart1, i1))
            break label220;
          localObject = null;
          break;
          localPduPart1.e(PduContentTypes.a[0].getBytes());
        }
        label209: if (i1 < 0)
        {
          localObject = null;
          continue;
        }
        label220: if ((localPduPart1.e() == null) && (localPduPart1.i() == null) && (localPduPart1.j() == null) && (localPduPart1.c() == null))
          localPduPart1.c(Long.toOctalString(System.currentTimeMillis()).getBytes());
        byte[] arrayOfByte3;
        PduPart localPduPart2;
        if (m > 0)
        {
          arrayOfByte3 = new byte[m];
          String str1 = new String(localPduPart1.g());
          paramByteArrayInputStream.read(arrayOfByte3, 0, m);
          if (str1.equalsIgnoreCase("application/vnd.wap.multipart.alternative"))
          {
            localPduPart2 = b(new ByteArrayInputStream(arrayOfByte3)).a(0);
            label330: if (a(localPduPart2) != 0)
              break label444;
            localPduBody.a(0, localPduPart2);
          }
        }
        while (true)
        {
          j++;
          break label25;
          byte[] arrayOfByte4 = localPduPart1.h();
          String str2;
          if (arrayOfByte4 != null)
          {
            str2 = new String(arrayOfByte4);
            if (!str2.equalsIgnoreCase("base64"))
              break label409;
            arrayOfByte3 = Base64.a(arrayOfByte3);
          }
          while (true)
          {
            if (arrayOfByte3 != null)
              break label430;
            a("Decode part data error!");
            localObject = null;
            break;
            label409: if (!str2.equalsIgnoreCase("quoted-printable"))
              continue;
            arrayOfByte3 = QuotedPrintable.a(arrayOfByte3);
          }
          label430: localPduPart1.a(arrayOfByte3);
          localPduPart2 = localPduPart1;
          break label330;
          label444: localPduBody.a(localPduPart2);
        }
      }
      localObject = localPduBody;
    }
  }

  protected static boolean b(int paramInt)
  {
    int i = 1;
    if (((paramInt >= 32) && (paramInt <= 126)) || ((paramInt >= 128) && (paramInt <= 255)));
    while (true)
    {
      return i;
      switch (paramInt)
      {
      case 9:
      case 10:
      case 13:
      case 11:
      case 12:
      }
      i = 0;
    }
  }

  protected static byte[] b(ByteArrayInputStream paramByteArrayInputStream, int paramInt)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = paramByteArrayInputStream.read();
    if ((!a) && (-1 == i))
      throw new AssertionError();
    if ((-1 != i) && (i != 0))
    {
      if (paramInt == 2)
        if (a(i))
          localByteArrayOutputStream.write(i);
      while (true)
      {
        i = paramByteArrayInputStream.read();
        if ((a) || (-1 != i))
          break;
        throw new AssertionError();
        if (!b(i))
          continue;
        localByteArrayOutputStream.write(i);
      }
    }
    if (localByteArrayOutputStream.size() > 0);
    for (byte[] arrayOfByte = localByteArrayOutputStream.toByteArray(); ; arrayOfByte = null)
      return arrayOfByte;
  }

  protected static int c(ByteArrayInputStream paramByteArrayInputStream)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    int i = paramByteArrayInputStream.read();
    int j = 0;
    if (i == -1);
    while (true)
    {
      return i;
      while (true)
        if ((i & 0x80) != 0)
        {
          j = j << 7 | i & 0x7F;
          i = paramByteArrayInputStream.read();
          if (i != -1)
            continue;
          break;
        }
      i = j << 7 | i & 0x7F;
    }
  }

  protected static int c(ByteArrayInputStream paramByteArrayInputStream, int paramInt)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    int i = paramByteArrayInputStream.read(new byte[paramInt], 0, paramInt);
    if (i < paramInt)
      i = -1;
    return i;
  }

  protected static int d(ByteArrayInputStream paramByteArrayInputStream)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    int i = paramByteArrayInputStream.read();
    if ((!a) && (-1 == i))
      throw new AssertionError();
    int j = i & 0xFF;
    if (j <= 30);
    while (true)
    {
      return j;
      if (j != 31)
        break;
      j = c(paramByteArrayInputStream);
    }
    throw new RuntimeException("Value length > LENGTH_QUOTE!");
  }

  protected static EncodedStringValue e(ByteArrayInputStream paramByteArrayInputStream)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    paramByteArrayInputStream.mark(1);
    int i = paramByteArrayInputStream.read();
    if ((!a) && (-1 == i))
      throw new AssertionError();
    int j = i & 0xFF;
    paramByteArrayInputStream.reset();
    if (j < 32)
      d(paramByteArrayInputStream);
    EncodedStringValue localEncodedStringValue;
    for (int k = g(paramByteArrayInputStream); ; k = 0)
    {
      byte[] arrayOfByte = a(paramByteArrayInputStream, 0);
      if (k != 0);
      try
      {
        localEncodedStringValue = new EncodedStringValue(k, arrayOfByte);
        break;
        localEncodedStringValue = new EncodedStringValue(arrayOfByte);
      }
      catch (Exception localException)
      {
        localEncodedStringValue = null;
      }
    }
    return localEncodedStringValue;
  }

  protected static int f(ByteArrayInputStream paramByteArrayInputStream)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    int i = paramByteArrayInputStream.read();
    if ((!a) && (-1 == i))
      throw new AssertionError();
    return i & 0xFF;
  }

  protected static int g(ByteArrayInputStream paramByteArrayInputStream)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    int i = paramByteArrayInputStream.read();
    if ((!a) && (-1 == i))
      throw new AssertionError();
    return i & 0x7F;
  }

  protected static long h(ByteArrayInputStream paramByteArrayInputStream)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    int i = paramByteArrayInputStream.read();
    if ((!a) && (-1 == i))
      throw new AssertionError();
    int j = i & 0xFF;
    if (j > 8)
      throw new RuntimeException("Octet count greater than 8 and I can't represent that!");
    long l = 0L;
    for (int k = 0; k < j; k++)
    {
      int m = paramByteArrayInputStream.read();
      if ((!a) && (-1 == m))
        throw new AssertionError();
      l = (l << 8) + (m & 0xFF);
    }
    return l;
  }

  protected static long i(ByteArrayInputStream paramByteArrayInputStream)
  {
    if ((!a) && (paramByteArrayInputStream == null))
      throw new AssertionError();
    paramByteArrayInputStream.mark(1);
    int i = paramByteArrayInputStream.read();
    if ((!a) && (-1 == i))
      throw new AssertionError();
    paramByteArrayInputStream.reset();
    long l;
    if (i > 127)
      l = g(paramByteArrayInputStream);
    while (true)
    {
      return l;
      l = h(paramByteArrayInputStream);
    }
  }

  public GenericPdu a()
  {
    ByteArrayInputStream localByteArrayInputStream = this.b;
    Object localObject = null;
    if (localByteArrayInputStream == null);
    while (true)
    {
      return localObject;
      this.c = a(this.b);
      PduHeaders localPduHeaders = this.c;
      localObject = null;
      if (localPduHeaders == null)
        continue;
      int i = this.c.a(140);
      if (!a(this.c))
      {
        a("check mandatory headers failed!");
        localObject = null;
        continue;
      }
      if ((128 == i) || (132 == i))
      {
        this.d = b(this.b);
        PduBody localPduBody = this.d;
        localObject = null;
        if (localPduBody == null)
          continue;
      }
      switch (i)
      {
      default:
        a("Parser doesn't support this message type in this version!");
        localObject = null;
        break;
      case 128:
        localObject = new SendReq(this.c, this.d);
        break;
      case 129:
        localObject = new SendConf(this.c);
        break;
      case 130:
        localObject = new NotificationInd(this.c);
        break;
      case 131:
        localObject = new NotifyRespInd(this.c);
        break;
      case 132:
        RetrieveConf localRetrieveConf = new RetrieveConf(this.c, this.d);
        byte[] arrayOfByte = localRetrieveConf.b();
        localObject = null;
        if (arrayOfByte == null)
          continue;
        String str = new String(arrayOfByte);
        if ((str.equals("application/vnd.wap.multipart.mixed")) || (str.equals("application/vnd.wap.multipart.related")) || (str.equals("application/vnd.wap.multipart.alternative")))
        {
          localObject = localRetrieveConf;
          continue;
        }
        boolean bool = str.equals("application/vnd.wap.multipart.alternative");
        localObject = null;
        if (!bool)
          continue;
        PduPart localPduPart = this.d.a(0);
        this.d.a();
        this.d.a(0, localPduPart);
        localObject = localRetrieveConf;
        break;
      case 134:
        localObject = new DeliveryInd(this.c);
        break;
      case 133:
        localObject = new AcknowledgeInd(this.c);
        break;
      case 136:
        localObject = new ReadOrigInd(this.c);
        break;
      case 135:
        localObject = new ReadRecInd(this.c);
      }
    }
  }

  // ERROR //
  protected PduHeaders a(ByteArrayInputStream paramByteArrayInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +9 -> 10
    //   4: aconst_null
    //   5: astore 4
    //   7: aload 4
    //   9: areturn
    //   10: new 145	android_src/mms/pdu/PduHeaders
    //   13: dup
    //   14: invokespecial 390	android_src/mms/pdu/PduHeaders:<init>	()V
    //   17: astore_2
    //   18: iconst_1
    //   19: istore_3
    //   20: iload_3
    //   21: ifeq +1982 -> 2003
    //   24: aload_1
    //   25: invokevirtual 73	java/io/ByteArrayInputStream:available	()I
    //   28: ifle +1975 -> 2003
    //   31: aload_1
    //   32: iconst_1
    //   33: invokevirtual 92	java/io/ByteArrayInputStream:mark	(I)V
    //   36: aload_1
    //   37: invokestatic 95	android_src/mms/pdu/PduParser:f	(Ljava/io/ByteArrayInputStream;)I
    //   40: istore 5
    //   42: iload 5
    //   44: bipush 32
    //   46: if_icmplt +23 -> 69
    //   49: iload 5
    //   51: bipush 127
    //   53: if_icmpgt +16 -> 69
    //   56: aload_1
    //   57: invokevirtual 98	java/io/ByteArrayInputStream:reset	()V
    //   60: aload_1
    //   61: iconst_0
    //   62: invokestatic 123	android_src/mms/pdu/PduParser:a	(Ljava/io/ByteArrayInputStream;I)[B
    //   65: pop
    //   66: goto -46 -> 20
    //   69: iload 5
    //   71: tableswitch	default:+265 -> 336, 129:+762->833, 130:+762->833, 131:+631->702, 132:+1813->1884, 133:+541->612, 134:+449->520, 135:+899->970, 136:+899->970, 137:+1015->1086, 138:+1218->1289, 139:+631->702, 140:+274->345, 141:+1447->1518, 142:+541->612, 143:+449->520, 144:+449->520, 145:+449->520, 146:+449->520, 147:+697->768, 148:+449->520, 149:+449->520, 150:+697->768, 151:+762->833, 152:+631->702, 153:+449->520, 154:+697->768, 155:+449->520, 156:+449->520, 157:+899->970, 158:+631->702, 159:+541->612, 160:+1540->1611, 161:+1648->1719, 162:+449->520, 163:+449->520, 164:+1736->1807, 165:+449->520, 166:+697->768, 167:+449->520, 168:+265->336, 169:+449->520, 170:+1754->1825, 171:+449->520, 172:+1754->1825, 173:+586->657, 174:+265->336, 175:+586->657, 176:+265->336, 177:+449->520, 178:+1804->1875, 179:+586->657, 180:+449->520, 181:+697->768, 182:+697->768, 183:+631->702, 184:+631->702, 185:+631->702, 186:+449->520, 187:+449->520, 188:+449->520, 189:+631->702, 190:+631->702, 191:+449->520
    //   337: aconst_null
    //   338: l2i
    //   339: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   342: goto -322 -> 20
    //   345: aload_1
    //   346: invokestatic 95	android_src/mms/pdu/PduParser:f	(Ljava/io/ByteArrayInputStream;)I
    //   349: istore 75
    //   351: iload 75
    //   353: tableswitch	default:+75 -> 428, 137:+129->482, 138:+129->482, 139:+129->482, 140:+129->482, 141:+129->482, 142:+129->482, 143:+129->482, 144:+129->482, 145:+129->482, 146:+129->482, 147:+129->482, 148:+129->482, 149:+129->482, 150:+129->482, 151:+129->482
    //   429: iload 75
    //   431: iload 5
    //   433: invokevirtual 395	android_src/mms/pdu/PduHeaders:a	(II)V
    //   436: goto -416 -> 20
    //   439: astore 77
    //   441: new 397	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   448: ldc_w 400
    //   451: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: iload 75
    //   456: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: ldc_w 409
    //   462: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: iload 5
    //   467: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   476: aconst_null
    //   477: astore 4
    //   479: goto -472 -> 7
    //   482: aconst_null
    //   483: astore 4
    //   485: goto -478 -> 7
    //   488: astore 76
    //   490: new 397	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   497: iload 5
    //   499: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: ldc_w 414
    //   505: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   514: aconst_null
    //   515: astore 4
    //   517: goto -510 -> 7
    //   520: aload_1
    //   521: invokestatic 95	android_src/mms/pdu/PduParser:f	(Ljava/io/ByteArrayInputStream;)I
    //   524: istore 72
    //   526: aload_2
    //   527: iload 72
    //   529: iload 5
    //   531: invokevirtual 395	android_src/mms/pdu/PduHeaders:a	(II)V
    //   534: goto -514 -> 20
    //   537: astore 74
    //   539: new 397	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 400
    //   549: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: iload 72
    //   554: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: ldc_w 409
    //   560: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: iload 5
    //   565: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   574: aconst_null
    //   575: astore 4
    //   577: goto -570 -> 7
    //   580: astore 73
    //   582: new 397	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   589: iload 5
    //   591: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: ldc_w 414
    //   597: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   606: aconst_null
    //   607: astore 4
    //   609: goto -602 -> 7
    //   612: aload_2
    //   613: aload_1
    //   614: invokestatic 333	android_src/mms/pdu/PduParser:h	(Ljava/io/ByteArrayInputStream;)J
    //   617: iload 5
    //   619: invokevirtual 417	android_src/mms/pdu/PduHeaders:a	(JI)V
    //   622: goto -602 -> 20
    //   625: astore 71
    //   627: new 397	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   634: iload 5
    //   636: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   639: ldc_w 419
    //   642: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   651: aconst_null
    //   652: astore 4
    //   654: goto -647 -> 7
    //   657: aload_2
    //   658: aload_1
    //   659: invokestatic 140	android_src/mms/pdu/PduParser:i	(Ljava/io/ByteArrayInputStream;)J
    //   662: iload 5
    //   664: invokevirtual 417	android_src/mms/pdu/PduHeaders:a	(JI)V
    //   667: goto -647 -> 20
    //   670: astore 70
    //   672: new 397	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   679: iload 5
    //   681: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   684: ldc_w 419
    //   687: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   696: aconst_null
    //   697: astore 4
    //   699: goto -692 -> 7
    //   702: aload_1
    //   703: iconst_0
    //   704: invokestatic 123	android_src/mms/pdu/PduParser:a	(Ljava/io/ByteArrayInputStream;I)[B
    //   707: astore 67
    //   709: aload 67
    //   711: ifnull -691 -> 20
    //   714: aload_2
    //   715: aload 67
    //   717: iload 5
    //   719: invokevirtual 422	android_src/mms/pdu/PduHeaders:a	([BI)V
    //   722: goto -702 -> 20
    //   725: astore 69
    //   727: ldc_w 424
    //   730: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   733: goto -713 -> 20
    //   736: astore 68
    //   738: new 397	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   745: iload 5
    //   747: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: ldc_w 426
    //   753: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   762: aconst_null
    //   763: astore 4
    //   765: goto -758 -> 7
    //   768: aload_1
    //   769: invokestatic 428	android_src/mms/pdu/PduParser:e	(Ljava/io/ByteArrayInputStream;)Landroid_src/mms/pdu/EncodedStringValue;
    //   772: astore 64
    //   774: aload 64
    //   776: ifnull -756 -> 20
    //   779: aload_2
    //   780: aload 64
    //   782: iload 5
    //   784: invokevirtual 431	android_src/mms/pdu/PduHeaders:a	(Landroid_src/mms/pdu/EncodedStringValue;I)V
    //   787: goto -767 -> 20
    //   790: astore 66
    //   792: ldc_w 424
    //   795: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   798: goto -778 -> 20
    //   801: astore 65
    //   803: new 397	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   810: iload 5
    //   812: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   815: ldc_w 433
    //   818: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   827: aconst_null
    //   828: astore 4
    //   830: goto -823 -> 7
    //   833: aload_1
    //   834: invokestatic 428	android_src/mms/pdu/PduParser:e	(Ljava/io/ByteArrayInputStream;)Landroid_src/mms/pdu/EncodedStringValue;
    //   837: astore 57
    //   839: aload 57
    //   841: ifnull -821 -> 20
    //   844: aload 57
    //   846: invokevirtual 434	android_src/mms/pdu/EncodedStringValue:b	()[B
    //   849: astore 58
    //   851: aload 58
    //   853: ifnull +49 -> 902
    //   856: new 107	java/lang/String
    //   859: dup
    //   860: aload 58
    //   862: invokespecial 124	java/lang/String:<init>	([B)V
    //   865: astore 59
    //   867: aload 59
    //   869: ldc_w 436
    //   872: invokevirtual 439	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   875: istore 60
    //   877: iload 60
    //   879: ifle +13 -> 892
    //   882: aload 59
    //   884: iconst_0
    //   885: iload 60
    //   887: invokevirtual 443	java/lang/String:substring	(II)Ljava/lang/String;
    //   890: astore 59
    //   892: aload 57
    //   894: aload 59
    //   896: invokevirtual 110	java/lang/String:getBytes	()[B
    //   899: invokevirtual 444	android_src/mms/pdu/EncodedStringValue:a	([B)V
    //   902: aload_2
    //   903: aload 57
    //   905: iload 5
    //   907: invokevirtual 446	android_src/mms/pdu/PduHeaders:b	(Landroid_src/mms/pdu/EncodedStringValue;I)V
    //   910: goto -890 -> 20
    //   913: astore 63
    //   915: ldc_w 424
    //   918: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   921: goto -901 -> 20
    //   924: astore 61
    //   926: ldc_w 424
    //   929: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   932: aconst_null
    //   933: astore 4
    //   935: goto -928 -> 7
    //   938: astore 62
    //   940: new 397	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   947: iload 5
    //   949: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   952: ldc_w 433
    //   955: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   964: aconst_null
    //   965: astore 4
    //   967: goto -960 -> 7
    //   970: aload_1
    //   971: invokestatic 190	android_src/mms/pdu/PduParser:d	(Ljava/io/ByteArrayInputStream;)I
    //   974: pop
    //   975: aload_1
    //   976: invokestatic 95	android_src/mms/pdu/PduParser:f	(Ljava/io/ByteArrayInputStream;)I
    //   979: istore 50
    //   981: aload_1
    //   982: invokestatic 333	android_src/mms/pdu/PduParser:h	(Ljava/io/ByteArrayInputStream;)J
    //   985: lstore 52
    //   987: lload 52
    //   989: lstore 54
    //   991: sipush 129
    //   994: iload 50
    //   996: if_icmpne +15 -> 1011
    //   999: lload 54
    //   1001: invokestatic 257	java/lang/System:currentTimeMillis	()J
    //   1004: ldc2_w 447
    //   1007: ldiv
    //   1008: ladd
    //   1009: lstore 54
    //   1011: aload_2
    //   1012: lload 54
    //   1014: iload 5
    //   1016: invokevirtual 417	android_src/mms/pdu/PduHeaders:a	(JI)V
    //   1019: goto -999 -> 20
    //   1022: astore 56
    //   1024: new 397	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1031: iload 5
    //   1033: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1036: ldc_w 419
    //   1039: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1048: aconst_null
    //   1049: astore 4
    //   1051: goto -1044 -> 7
    //   1054: astore 51
    //   1056: new 397	java/lang/StringBuilder
    //   1059: dup
    //   1060: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1063: iload 5
    //   1065: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1068: ldc_w 419
    //   1071: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1077: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1080: aconst_null
    //   1081: astore 4
    //   1083: goto -1076 -> 7
    //   1086: aload_1
    //   1087: invokestatic 190	android_src/mms/pdu/PduParser:d	(Ljava/io/ByteArrayInputStream;)I
    //   1090: pop
    //   1091: sipush 128
    //   1094: aload_1
    //   1095: invokestatic 95	android_src/mms/pdu/PduParser:f	(Ljava/io/ByteArrayInputStream;)I
    //   1098: if_icmpne +109 -> 1207
    //   1101: aload_1
    //   1102: invokestatic 428	android_src/mms/pdu/PduParser:e	(Ljava/io/ByteArrayInputStream;)Landroid_src/mms/pdu/EncodedStringValue;
    //   1105: astore 41
    //   1107: aload 41
    //   1109: ifnull +61 -> 1170
    //   1112: aload 41
    //   1114: invokevirtual 434	android_src/mms/pdu/EncodedStringValue:b	()[B
    //   1117: astore 45
    //   1119: aload 45
    //   1121: ifnull +49 -> 1170
    //   1124: new 107	java/lang/String
    //   1127: dup
    //   1128: aload 45
    //   1130: invokespecial 124	java/lang/String:<init>	([B)V
    //   1133: astore 46
    //   1135: aload 46
    //   1137: ldc_w 436
    //   1140: invokevirtual 439	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1143: istore 47
    //   1145: iload 47
    //   1147: ifle +13 -> 1160
    //   1150: aload 46
    //   1152: iconst_0
    //   1153: iload 47
    //   1155: invokevirtual 443	java/lang/String:substring	(II)Ljava/lang/String;
    //   1158: astore 46
    //   1160: aload 41
    //   1162: aload 46
    //   1164: invokevirtual 110	java/lang/String:getBytes	()[B
    //   1167: invokevirtual 444	android_src/mms/pdu/EncodedStringValue:a	([B)V
    //   1170: aload_2
    //   1171: aload 41
    //   1173: sipush 137
    //   1176: invokevirtual 431	android_src/mms/pdu/PduHeaders:a	(Landroid_src/mms/pdu/EncodedStringValue;I)V
    //   1179: goto -1159 -> 20
    //   1182: astore 43
    //   1184: ldc_w 424
    //   1187: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1190: goto -1170 -> 20
    //   1193: astore 48
    //   1195: ldc_w 424
    //   1198: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1201: aconst_null
    //   1202: astore 4
    //   1204: goto -1197 -> 7
    //   1207: new 325	android_src/mms/pdu/EncodedStringValue
    //   1210: dup
    //   1211: ldc_w 450
    //   1214: invokevirtual 110	java/lang/String:getBytes	()[B
    //   1217: invokespecial 329	android_src/mms/pdu/EncodedStringValue:<init>	([B)V
    //   1220: astore 41
    //   1222: goto -52 -> 1170
    //   1225: astore 44
    //   1227: new 397	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1234: iload 5
    //   1236: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1239: ldc_w 433
    //   1242: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1248: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1251: aconst_null
    //   1252: astore 4
    //   1254: goto -1247 -> 7
    //   1257: astore 42
    //   1259: new 397	java/lang/StringBuilder
    //   1262: dup
    //   1263: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1266: iload 5
    //   1268: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1271: ldc_w 433
    //   1274: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1283: aconst_null
    //   1284: astore 4
    //   1286: goto -1279 -> 7
    //   1289: aload_1
    //   1290: iconst_1
    //   1291: invokevirtual 92	java/io/ByteArrayInputStream:mark	(I)V
    //   1294: aload_1
    //   1295: invokestatic 95	android_src/mms/pdu/PduParser:f	(Ljava/io/ByteArrayInputStream;)I
    //   1298: istore 34
    //   1300: iload 34
    //   1302: sipush 128
    //   1305: if_icmplt +142 -> 1447
    //   1308: sipush 128
    //   1311: iload 34
    //   1313: if_icmpne +30 -> 1343
    //   1316: aload_2
    //   1317: ldc_w 452
    //   1320: invokevirtual 110	java/lang/String:getBytes	()[B
    //   1323: sipush 138
    //   1326: invokevirtual 422	android_src/mms/pdu/PduHeaders:a	([BI)V
    //   1329: goto -1309 -> 20
    //   1332: astore 39
    //   1334: ldc_w 424
    //   1337: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1340: goto -1320 -> 20
    //   1343: sipush 129
    //   1346: iload 34
    //   1348: if_icmpne +51 -> 1399
    //   1351: aload_2
    //   1352: ldc_w 454
    //   1355: invokevirtual 110	java/lang/String:getBytes	()[B
    //   1358: sipush 138
    //   1361: invokevirtual 422	android_src/mms/pdu/PduHeaders:a	([BI)V
    //   1364: goto -1344 -> 20
    //   1367: astore 38
    //   1369: new 397	java/lang/StringBuilder
    //   1372: dup
    //   1373: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1376: iload 5
    //   1378: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1381: ldc_w 426
    //   1384: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1390: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1393: aconst_null
    //   1394: astore 4
    //   1396: goto -1389 -> 7
    //   1399: sipush 130
    //   1402: iload 34
    //   1404: if_icmpne +19 -> 1423
    //   1407: aload_2
    //   1408: ldc_w 456
    //   1411: invokevirtual 110	java/lang/String:getBytes	()[B
    //   1414: sipush 138
    //   1417: invokevirtual 422	android_src/mms/pdu/PduHeaders:a	([BI)V
    //   1420: goto -1400 -> 20
    //   1423: sipush 131
    //   1426: iload 34
    //   1428: if_icmpne -1408 -> 20
    //   1431: aload_2
    //   1432: ldc_w 458
    //   1435: invokevirtual 110	java/lang/String:getBytes	()[B
    //   1438: sipush 138
    //   1441: invokevirtual 422	android_src/mms/pdu/PduHeaders:a	([BI)V
    //   1444: goto -1424 -> 20
    //   1447: aload_1
    //   1448: invokevirtual 98	java/io/ByteArrayInputStream:reset	()V
    //   1451: aload_1
    //   1452: iconst_0
    //   1453: invokestatic 123	android_src/mms/pdu/PduParser:a	(Ljava/io/ByteArrayInputStream;I)[B
    //   1456: astore 35
    //   1458: aload 35
    //   1460: ifnull -1440 -> 20
    //   1463: aload_2
    //   1464: aload 35
    //   1466: sipush 138
    //   1469: invokevirtual 422	android_src/mms/pdu/PduHeaders:a	([BI)V
    //   1472: goto -1452 -> 20
    //   1475: astore 37
    //   1477: ldc_w 424
    //   1480: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1483: goto -1463 -> 20
    //   1486: astore 36
    //   1488: new 397	java/lang/StringBuilder
    //   1491: dup
    //   1492: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1495: iload 5
    //   1497: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1500: ldc_w 426
    //   1503: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1509: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1512: aconst_null
    //   1513: astore 4
    //   1515: goto -1508 -> 7
    //   1518: aload_1
    //   1519: invokestatic 100	android_src/mms/pdu/PduParser:g	(Ljava/io/ByteArrayInputStream;)I
    //   1522: istore 31
    //   1524: aload_2
    //   1525: iload 31
    //   1527: sipush 141
    //   1530: invokevirtual 395	android_src/mms/pdu/PduHeaders:a	(II)V
    //   1533: goto -1513 -> 20
    //   1536: astore 33
    //   1538: new 397	java/lang/StringBuilder
    //   1541: dup
    //   1542: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1545: ldc_w 400
    //   1548: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: iload 31
    //   1553: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1556: ldc_w 409
    //   1559: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: iload 5
    //   1564: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1567: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1570: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1573: aconst_null
    //   1574: astore 4
    //   1576: goto -1569 -> 7
    //   1579: astore 32
    //   1581: new 397	java/lang/StringBuilder
    //   1584: dup
    //   1585: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1588: iload 5
    //   1590: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1593: ldc_w 414
    //   1596: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1602: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1605: aconst_null
    //   1606: astore 4
    //   1608: goto -1601 -> 7
    //   1611: aload_1
    //   1612: invokestatic 190	android_src/mms/pdu/PduParser:d	(Ljava/io/ByteArrayInputStream;)I
    //   1615: pop
    //   1616: aload_1
    //   1617: invokestatic 140	android_src/mms/pdu/PduParser:i	(Ljava/io/ByteArrayInputStream;)J
    //   1620: pop2
    //   1621: aload_1
    //   1622: invokestatic 428	android_src/mms/pdu/PduParser:e	(Ljava/io/ByteArrayInputStream;)Landroid_src/mms/pdu/EncodedStringValue;
    //   1625: astore 28
    //   1627: aload 28
    //   1629: ifnull -1609 -> 20
    //   1632: aload_2
    //   1633: aload 28
    //   1635: sipush 160
    //   1638: invokevirtual 431	android_src/mms/pdu/PduHeaders:a	(Landroid_src/mms/pdu/EncodedStringValue;I)V
    //   1641: goto -1621 -> 20
    //   1644: astore 30
    //   1646: ldc_w 424
    //   1649: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1652: goto -1632 -> 20
    //   1655: astore 25
    //   1657: new 397	java/lang/StringBuilder
    //   1660: dup
    //   1661: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1664: iload 5
    //   1666: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1669: ldc_w 460
    //   1672: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1675: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1678: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1681: aconst_null
    //   1682: astore 4
    //   1684: goto -1677 -> 7
    //   1687: astore 29
    //   1689: new 397	java/lang/StringBuilder
    //   1692: dup
    //   1693: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1696: iload 5
    //   1698: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1701: ldc_w 433
    //   1704: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1710: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1713: aconst_null
    //   1714: astore 4
    //   1716: goto -1709 -> 7
    //   1719: aload_1
    //   1720: invokestatic 190	android_src/mms/pdu/PduParser:d	(Ljava/io/ByteArrayInputStream;)I
    //   1723: pop
    //   1724: aload_1
    //   1725: invokestatic 140	android_src/mms/pdu/PduParser:i	(Ljava/io/ByteArrayInputStream;)J
    //   1728: pop2
    //   1729: aload_2
    //   1730: aload_1
    //   1731: invokestatic 333	android_src/mms/pdu/PduParser:h	(Ljava/io/ByteArrayInputStream;)J
    //   1734: sipush 161
    //   1737: invokevirtual 417	android_src/mms/pdu/PduHeaders:a	(JI)V
    //   1740: goto -1720 -> 20
    //   1743: astore 23
    //   1745: new 397	java/lang/StringBuilder
    //   1748: dup
    //   1749: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1752: iload 5
    //   1754: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1757: ldc_w 419
    //   1760: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1766: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1769: aconst_null
    //   1770: astore 4
    //   1772: goto -1765 -> 7
    //   1775: astore 20
    //   1777: new 397	java/lang/StringBuilder
    //   1780: dup
    //   1781: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1784: iload 5
    //   1786: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1789: ldc_w 460
    //   1792: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1798: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1801: aconst_null
    //   1802: astore 4
    //   1804: goto -1797 -> 7
    //   1807: aload_1
    //   1808: invokestatic 190	android_src/mms/pdu/PduParser:d	(Ljava/io/ByteArrayInputStream;)I
    //   1811: pop
    //   1812: aload_1
    //   1813: invokestatic 95	android_src/mms/pdu/PduParser:f	(Ljava/io/ByteArrayInputStream;)I
    //   1816: pop
    //   1817: aload_1
    //   1818: invokestatic 428	android_src/mms/pdu/PduParser:e	(Ljava/io/ByteArrayInputStream;)Landroid_src/mms/pdu/EncodedStringValue;
    //   1821: pop
    //   1822: goto -1802 -> 20
    //   1825: aload_1
    //   1826: invokestatic 190	android_src/mms/pdu/PduParser:d	(Ljava/io/ByteArrayInputStream;)I
    //   1829: pop
    //   1830: aload_1
    //   1831: invokestatic 95	android_src/mms/pdu/PduParser:f	(Ljava/io/ByteArrayInputStream;)I
    //   1834: pop
    //   1835: aload_1
    //   1836: invokestatic 140	android_src/mms/pdu/PduParser:i	(Ljava/io/ByteArrayInputStream;)J
    //   1839: pop2
    //   1840: goto -1820 -> 20
    //   1843: astore 13
    //   1845: new 397	java/lang/StringBuilder
    //   1848: dup
    //   1849: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1852: iload 5
    //   1854: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1857: ldc_w 460
    //   1860: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1863: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1866: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1869: aconst_null
    //   1870: astore 4
    //   1872: goto -1865 -> 7
    //   1875: aload_1
    //   1876: aconst_null
    //   1877: invokestatic 231	android_src/mms/pdu/PduParser:a	(Ljava/io/ByteArrayInputStream;Ljava/util/HashMap;)[B
    //   1880: pop
    //   1881: goto -1861 -> 20
    //   1884: new 116	java/util/HashMap
    //   1887: dup
    //   1888: invokespecial 229	java/util/HashMap:<init>	()V
    //   1891: astore 6
    //   1893: aload_1
    //   1894: aload 6
    //   1896: invokestatic 231	android_src/mms/pdu/PduParser:a	(Ljava/io/ByteArrayInputStream;Ljava/util/HashMap;)[B
    //   1899: astore 7
    //   1901: aload 7
    //   1903: ifnull +12 -> 1915
    //   1906: aload_2
    //   1907: aload 7
    //   1909: sipush 132
    //   1912: invokevirtual 422	android_src/mms/pdu/PduHeaders:a	([BI)V
    //   1915: aload 6
    //   1917: sipush 153
    //   1920: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1923: invokevirtual 237	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1926: checkcast 238	[B
    //   1929: checkcast 238	[B
    //   1932: putstatic 29	android_src/mms/pdu/PduParser:f	[B
    //   1935: aload 6
    //   1937: sipush 131
    //   1940: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1943: invokevirtual 237	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1946: checkcast 238	[B
    //   1949: checkcast 238	[B
    //   1952: putstatic 27	android_src/mms/pdu/PduParser:e	[B
    //   1955: iconst_0
    //   1956: istore_3
    //   1957: goto -1937 -> 20
    //   1960: astore 9
    //   1962: ldc_w 424
    //   1965: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1968: goto -53 -> 1915
    //   1971: astore 8
    //   1973: new 397	java/lang/StringBuilder
    //   1976: dup
    //   1977: invokespecial 398	java/lang/StringBuilder:<init>	()V
    //   1980: iload 5
    //   1982: invokevirtual 407	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1985: ldc_w 426
    //   1988: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1991: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1994: invokestatic 288	android_src/mms/pdu/PduParser:a	(Ljava/lang/String;)V
    //   1997: aconst_null
    //   1998: astore 4
    //   2000: goto -1993 -> 7
    //   2003: aload_2
    //   2004: astore 4
    //   2006: goto -1999 -> 7
    //
    // Exception table:
    //   from	to	target	type
    //   428	436	439	android_src/mms/InvalidHeaderValueException
    //   428	436	488	java/lang/RuntimeException
    //   526	534	537	android_src/mms/InvalidHeaderValueException
    //   526	534	580	java/lang/RuntimeException
    //   612	622	625	java/lang/RuntimeException
    //   657	667	670	java/lang/RuntimeException
    //   714	722	725	java/lang/NullPointerException
    //   714	722	736	java/lang/RuntimeException
    //   779	787	790	java/lang/NullPointerException
    //   779	787	801	java/lang/RuntimeException
    //   902	910	913	java/lang/NullPointerException
    //   892	902	924	java/lang/NullPointerException
    //   902	910	938	java/lang/RuntimeException
    //   1011	1019	1022	java/lang/RuntimeException
    //   981	987	1054	java/lang/RuntimeException
    //   1170	1179	1182	java/lang/NullPointerException
    //   1160	1170	1193	java/lang/NullPointerException
    //   1207	1222	1225	java/lang/NullPointerException
    //   1170	1179	1257	java/lang/RuntimeException
    //   1316	1329	1332	java/lang/NullPointerException
    //   1351	1364	1332	java/lang/NullPointerException
    //   1407	1444	1332	java/lang/NullPointerException
    //   1316	1329	1367	java/lang/RuntimeException
    //   1351	1364	1367	java/lang/RuntimeException
    //   1407	1444	1367	java/lang/RuntimeException
    //   1463	1472	1475	java/lang/NullPointerException
    //   1463	1472	1486	java/lang/RuntimeException
    //   1524	1533	1536	android_src/mms/InvalidHeaderValueException
    //   1524	1533	1579	java/lang/RuntimeException
    //   1632	1641	1644	java/lang/NullPointerException
    //   1616	1621	1655	java/lang/RuntimeException
    //   1632	1641	1687	java/lang/RuntimeException
    //   1729	1740	1743	java/lang/RuntimeException
    //   1724	1729	1775	java/lang/RuntimeException
    //   1835	1840	1843	java/lang/RuntimeException
    //   1906	1915	1960	java/lang/NullPointerException
    //   1906	1915	1971	java/lang/RuntimeException
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.PduParser
 * JD-Core Version:    0.6.0
 */