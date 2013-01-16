package org.acra.util;

class Base64$Encoder extends Base64.Coder
{
  private static final byte[] ENCODE;
  private static final byte[] ENCODE_WEBSAFE;
  public static final int LINE_GROUPS = 19;
  private final byte[] alphabet;
  private int count;
  public final boolean do_cr;
  public final boolean do_newline;
  public final boolean do_padding;
  private final byte[] tail;
  int tailLen;

  static
  {
    if (!Base64.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      ENCODE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      ENCODE_WEBSAFE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      return;
    }
  }

  public Base64$Encoder(int paramInt, byte[] paramArrayOfByte)
  {
    this.output = paramArrayOfByte;
    boolean bool2;
    boolean bool3;
    label35: label47: byte[] arrayOfByte;
    if ((paramInt & 0x1) == 0)
    {
      bool2 = bool1;
      this.do_padding = bool2;
      if ((paramInt & 0x2) != 0)
        break label106;
      bool3 = bool1;
      this.do_newline = bool3;
      if ((paramInt & 0x4) == 0)
        break label112;
      this.do_cr = bool1;
      if ((paramInt & 0x8) != 0)
        break label117;
      arrayOfByte = ENCODE;
      label64: this.alphabet = arrayOfByte;
      this.tail = new byte[2];
      this.tailLen = 0;
      if (!this.do_newline)
        break label125;
    }
    label106: label112: label117: label125: for (int i = 19; ; i = -1)
    {
      this.count = i;
      return;
      bool2 = false;
      break;
      bool3 = false;
      break label35;
      bool1 = false;
      break label47;
      arrayOfByte = ENCODE_WEBSAFE;
      break label64;
    }
  }

  public int maxOutputSize(int paramInt)
  {
    return 10 + paramInt * 8 / 5;
  }

  public boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte1 = this.alphabet;
    byte[] arrayOfByte2 = this.output;
    int i = this.count;
    int j = paramInt2 + paramInt1;
    int k = -1;
    int n;
    label59: int i1;
    int i35;
    switch (this.tailLen)
    {
    default:
      n = paramInt1;
      i1 = 0;
      if (k == -1)
        break;
      arrayOfByte2[0] = arrayOfByte1[(0x3F & k >> 18)];
      arrayOfByte2[1] = arrayOfByte1[(0x3F & k >> 12)];
      arrayOfByte2[2] = arrayOfByte1[(0x3F & k >> 6)];
      i1 = 4;
      arrayOfByte2[3] = arrayOfByte1[(k & 0x3F)];
      i--;
      if (i != 0)
        break;
      if (this.do_cr)
      {
        i35 = 5;
        arrayOfByte2[i1] = 13;
      }
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      int i36 = i35 + 1;
      arrayOfByte2[i35] = 10;
      int i2 = 19;
      int i3 = i36;
      while (true)
      {
        label174: int i33;
        if (n + 3 <= j)
        {
          int i32 = (0xFF & paramArrayOfByte[n]) << 16 | (0xFF & paramArrayOfByte[(n + 1)]) << 8 | 0xFF & paramArrayOfByte[(n + 2)];
          arrayOfByte2[i3] = arrayOfByte1[(0x3F & i32 >> 18)];
          arrayOfByte2[(i3 + 1)] = arrayOfByte1[(0x3F & i32 >> 12)];
          arrayOfByte2[(i3 + 2)] = arrayOfByte1[(0x3F & i32 >> 6)];
          arrayOfByte2[(i3 + 3)] = arrayOfByte1[(i32 & 0x3F)];
          n += 3;
          i1 = i3 + 4;
          i = i2 - 1;
          if (i != 0)
            break label1235;
          if (!this.do_cr)
            break label1228;
          i33 = i1 + 1;
          arrayOfByte2[i1] = 13;
        }
        while (true)
        {
          int i34 = i33 + 1;
          arrayOfByte2[i33] = 10;
          i2 = 19;
          i3 = i34;
          break label174;
          n = paramInt1;
          break label59;
          if (paramInt1 + 2 > j)
            break;
          int i37 = (0xFF & this.tail[0]) << 16;
          int i38 = paramInt1 + 1;
          int i39 = i37 | (0xFF & paramArrayOfByte[paramInt1]) << 8;
          int i40 = i38 + 1;
          k = i39 | 0xFF & paramArrayOfByte[i38];
          this.tailLen = 0;
          n = i40;
          break label59;
          if (paramInt1 + 1 > j)
            break;
          int m = (0xFF & this.tail[0]) << 16 | (0xFF & this.tail[1]) << 8;
          n = paramInt1 + 1;
          k = m | 0xFF & paramArrayOfByte[paramInt1];
          this.tailLen = 0;
          break label59;
          int i10;
          int i9;
          label770: int i13;
          label811: int i17;
          int i18;
          if (paramBoolean)
          {
            if (n - this.tailLen == j - 1)
            {
              int i25;
              int i23;
              int i24;
              if (this.tailLen > 0)
              {
                byte[] arrayOfByte8 = this.tail;
                i25 = 1;
                i23 = arrayOfByte8[0];
                i24 = n;
              }
              while (true)
              {
                int i26 = (i23 & 0xFF) << 4;
                this.tailLen -= i25;
                int i27 = i3 + 1;
                arrayOfByte2[i3] = arrayOfByte1[(0x3F & i26 >> 6)];
                int i28 = i27 + 1;
                arrayOfByte2[i27] = arrayOfByte1[(i26 & 0x3F)];
                if (this.do_padding)
                {
                  int i31 = i28 + 1;
                  arrayOfByte2[i28] = 61;
                  i28 = i31 + 1;
                  arrayOfByte2[i31] = 61;
                }
                if (this.do_newline)
                {
                  if (this.do_cr)
                  {
                    int i30 = i28 + 1;
                    arrayOfByte2[i28] = 13;
                    i28 = i30;
                  }
                  int i29 = i28 + 1;
                  arrayOfByte2[i28] = 10;
                  i28 = i29;
                }
                n = i24;
                i3 = i28;
                if (($assertionsDisabled) || (this.tailLen == 0))
                  break;
                throw new AssertionError();
                int i22 = n + 1;
                i23 = paramArrayOfByte[n];
                i24 = i22;
                i25 = 0;
              }
            }
            if (n - this.tailLen == j - 2)
              if (this.tailLen > 1)
              {
                byte[] arrayOfByte7 = this.tail;
                i10 = 1;
                i9 = arrayOfByte7[0];
                int i11 = (i9 & 0xFF) << 10;
                if (this.tailLen <= 0)
                  break label995;
                byte[] arrayOfByte6 = this.tail;
                int i21 = i10 + 1;
                i13 = arrayOfByte6[i10];
                i10 = i21;
                int i14 = i11 | (i13 & 0xFF) << 2;
                this.tailLen -= i10;
                int i15 = i3 + 1;
                arrayOfByte2[i3] = arrayOfByte1[(0x3F & i14 >> 12)];
                int i16 = i15 + 1;
                arrayOfByte2[i15] = arrayOfByte1[(0x3F & i14 >> 6)];
                i17 = i16 + 1;
                arrayOfByte2[i16] = arrayOfByte1[(i14 & 0x3F)];
                if (!this.do_padding)
                  break label1221;
                i18 = i17 + 1;
                arrayOfByte2[i17] = 61;
              }
          }
          while (true)
          {
            if (this.do_newline)
            {
              if (this.do_cr)
              {
                int i20 = i18 + 1;
                arrayOfByte2[i18] = 13;
                i18 = i20;
              }
              int i19 = i18 + 1;
              arrayOfByte2[i18] = 10;
              i18 = i19;
            }
            i3 = i18;
            break;
            int i8 = n + 1;
            i9 = paramArrayOfByte[n];
            n = i8;
            i10 = 0;
            break label770;
            label995: int i12 = n + 1;
            i13 = paramArrayOfByte[n];
            n = i12;
            break label811;
            if ((!this.do_newline) || (i3 <= 0) || (i2 == 19))
              break;
            int i7;
            if (this.do_cr)
            {
              i7 = i3 + 1;
              arrayOfByte2[i3] = 13;
            }
            while (true)
            {
              i3 = i7 + 1;
              arrayOfByte2[i7] = 10;
              break;
              if ((!$assertionsDisabled) && (n != j))
              {
                throw new AssertionError();
                if (n != j - 1)
                  break label1142;
                byte[] arrayOfByte5 = this.tail;
                int i6 = this.tailLen;
                this.tailLen = (i6 + 1);
                arrayOfByte5[i6] = paramArrayOfByte[n];
              }
              while (true)
              {
                this.op = i3;
                this.count = i2;
                return true;
                label1142: if (n != j - 2)
                  continue;
                byte[] arrayOfByte3 = this.tail;
                int i4 = this.tailLen;
                this.tailLen = (i4 + 1);
                arrayOfByte3[i4] = paramArrayOfByte[n];
                byte[] arrayOfByte4 = this.tail;
                int i5 = this.tailLen;
                this.tailLen = (i5 + 1);
                arrayOfByte4[i5] = paramArrayOfByte[(n + 1)];
              }
              i7 = i3;
            }
            label1221: i18 = i17;
          }
          label1228: i33 = i1;
        }
        label1235: i2 = i;
        i3 = i1;
      }
      i35 = i1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.Base64.Encoder
 * JD-Core Version:    0.6.0
 */