package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class DecodedBitStreamParser
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 32, 36, 37, 42, 43, 45, 46, 47, 58 };

  private static char a(int paramInt)
  {
    if (paramInt >= a.length)
      throw FormatException.a();
    return a[paramInt];
  }

  private static int a(BitSource paramBitSource)
  {
    int i = paramBitSource.a(8);
    int j;
    if ((i & 0x80) == 0)
      j = i & 0x7F;
    while (true)
    {
      return j;
      if ((i & 0xC0) == 128)
      {
        j = paramBitSource.a(8) | (i & 0x3F) << 8;
        continue;
      }
      if ((i & 0xE0) != 192)
        break;
      j = paramBitSource.a(16) | (i & 0x1F) << 16;
    }
    throw FormatException.a();
  }

  static DecoderResult a(byte[] paramArrayOfByte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<DecodeHintType, ?> paramMap)
  {
    BitSource localBitSource = new BitSource(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder(50);
    boolean bool1 = false;
    ArrayList localArrayList = new ArrayList(1);
    CharacterSetECI localCharacterSetECI = null;
    while (true)
    {
      Object localObject;
      boolean bool2;
      if (localBitSource.a() < 4)
      {
        localObject = Mode.TERMINATOR;
        if (localObject == Mode.TERMINATOR)
          break label403;
        if ((localObject != Mode.FNC1_FIRST_POSITION) && (localObject != Mode.FNC1_SECOND_POSITION))
          break label152;
        bool2 = true;
      }
      while (true)
      {
        label78: if (localObject != Mode.TERMINATOR)
          break label410;
        String str1 = localStringBuilder.toString();
        if (localArrayList.isEmpty())
          localArrayList = null;
        String str2 = null;
        if (paramErrorCorrectionLevel == null);
        while (true)
        {
          while (true)
          {
            return new DecoderResult(paramArrayOfByte, str1, localArrayList, str2);
            try
            {
              Mode localMode = Mode.forBits(localBitSource.a(4));
              localObject = localMode;
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              throw FormatException.a();
            }
          }
          label152: if (localObject == Mode.STRUCTURED_APPEND)
          {
            if (localBitSource.a() < 16)
              throw FormatException.a();
            localBitSource.a(16);
            bool2 = bool1;
            break label78;
          }
          if (localObject == Mode.ECI)
          {
            localCharacterSetECI = CharacterSetECI.getCharacterSetECIByValue(a(localBitSource));
            if (localCharacterSetECI == null)
              throw FormatException.a();
            bool2 = bool1;
            break label78;
          }
          if (localObject == Mode.HANZI)
          {
            int j = localBitSource.a(4);
            int k = localBitSource.a(((Mode)localObject).getCharacterCountBits(paramVersion));
            if (j == 1)
              a(localBitSource, localStringBuilder, k);
            bool2 = bool1;
            break label78;
          }
          int i = localBitSource.a(((Mode)localObject).getCharacterCountBits(paramVersion));
          if (localObject == Mode.NUMERIC)
          {
            c(localBitSource, localStringBuilder, i);
            bool2 = bool1;
            break label78;
          }
          if (localObject == Mode.ALPHANUMERIC)
          {
            a(localBitSource, localStringBuilder, i, bool1);
            bool2 = bool1;
            break label78;
          }
          if (localObject == Mode.BYTE)
          {
            a(localBitSource, localStringBuilder, i, localCharacterSetECI, localArrayList, paramMap);
            bool2 = bool1;
            break label78;
          }
          if (localObject == Mode.KANJI)
          {
            b(localBitSource, localStringBuilder, i);
            bool2 = bool1;
            break label78;
          }
          throw FormatException.a();
          str2 = paramErrorCorrectionLevel.toString();
        }
        label403: bool2 = bool1;
      }
      label410: bool1 = bool2;
    }
  }

  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt * 13 > paramBitSource.a())
      throw FormatException.a();
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    if (paramInt > 0)
    {
      int j = paramBitSource.a(13);
      int k = j / 96 << 8 | j % 96;
      if (k < 959);
      for (int m = k + 41377; ; m = k + 42657)
      {
        arrayOfByte[i] = (byte)(0xFF & m >> 8);
        arrayOfByte[(i + 1)] = (byte)(m & 0xFF);
        int n = i + 2;
        paramInt--;
        i = n;
        break;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "GB2312"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw FormatException.a();
  }

  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, CharacterSetECI paramCharacterSetECI, Collection<byte[]> paramCollection, Map<DecodeHintType, ?> paramMap)
  {
    if (paramInt << 3 > paramBitSource.a())
      throw FormatException.a();
    byte[] arrayOfByte = new byte[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfByte[i] = (byte)paramBitSource.a(8);
    String str;
    if (paramCharacterSetECI == null)
      str = StringUtils.a(arrayOfByte, paramMap);
    try
    {
      while (true)
      {
        paramStringBuilder.append(new String(arrayOfByte, str));
        paramCollection.add(arrayOfByte);
        return;
        str = paramCharacterSetECI.name();
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw FormatException.a();
  }

  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean)
  {
    int i = paramStringBuilder.length();
    while (paramInt > 1)
    {
      if (paramBitSource.a() < 11)
        throw FormatException.a();
      int j = paramBitSource.a(11);
      paramStringBuilder.append(a(j / 45));
      paramStringBuilder.append(a(j % 45));
      paramInt -= 2;
    }
    if (paramInt == 1)
    {
      if (paramBitSource.a() < 6)
        throw FormatException.a();
      paramStringBuilder.append(a(paramBitSource.a(6)));
    }
    if (paramBoolean)
      if (i < paramStringBuilder.length())
      {
        if (paramStringBuilder.charAt(i) == '%')
        {
          if ((i >= -1 + paramStringBuilder.length()) || (paramStringBuilder.charAt(i + 1) != '%'))
            break label159;
          paramStringBuilder.deleteCharAt(i + 1);
        }
        while (true)
        {
          i++;
          break;
          label159: paramStringBuilder.setCharAt(i, '\035');
        }
      }
  }

  private static void b(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt * 13 > paramBitSource.a())
      throw FormatException.a();
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    if (paramInt > 0)
    {
      int j = paramBitSource.a(13);
      int k = j / 192 << 8 | j % 192;
      if (k < 7936);
      for (int m = k + 33088; ; m = k + 49472)
      {
        arrayOfByte[i] = (byte)(m >> 8);
        arrayOfByte[(i + 1)] = (byte)m;
        int n = i + 2;
        paramInt--;
        i = n;
        break;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "SJIS"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw FormatException.a();
  }

  private static void c(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    while (paramInt >= 3)
    {
      if (paramBitSource.a() < 10)
        throw FormatException.a();
      int k = paramBitSource.a(10);
      if (k >= 1000)
        throw FormatException.a();
      paramStringBuilder.append(a(k / 100));
      paramStringBuilder.append(a(k / 10 % 10));
      paramStringBuilder.append(a(k % 10));
      paramInt -= 3;
    }
    if (paramInt == 2)
    {
      if (paramBitSource.a() < 7)
        throw FormatException.a();
      int j = paramBitSource.a(7);
      if (j >= 100)
        throw FormatException.a();
      paramStringBuilder.append(a(j / 10));
      paramStringBuilder.append(a(j % 10));
    }
    while (true)
    {
      return;
      if (paramInt == 1)
      {
        if (paramBitSource.a() < 4)
          throw FormatException.a();
        int i = paramBitSource.a(4);
        if (i >= 10)
          throw FormatException.a();
        paramStringBuilder.append(a(i));
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.DecodedBitStreamParser
 * JD-Core Version:    0.6.0
 */