package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

public final class Version
{
  private static final int[] a = { 31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017 };
  private static final Version[] b = f();
  private final int c;
  private final int[] d;
  private final Version.ECBlocks[] e;
  private final int f;

  private Version(int paramInt, int[] paramArrayOfInt, Version.ECBlocks[] paramArrayOfECBlocks)
  {
    this.c = paramInt;
    this.d = paramArrayOfInt;
    this.e = paramArrayOfECBlocks;
    int j = paramArrayOfECBlocks[0].a();
    Version.ECB[] arrayOfECB = paramArrayOfECBlocks[0].d();
    int k = arrayOfECB.length;
    int m = 0;
    while (i < k)
    {
      Version.ECB localECB = arrayOfECB[i];
      m += localECB.a() * (j + localECB.b());
      i++;
    }
    this.f = m;
  }

  public static Version a(int paramInt)
  {
    if (paramInt % 4 != 1)
      throw FormatException.a();
    int i = paramInt - 17 >> 2;
    try
    {
      Version localVersion = b(i);
      return localVersion;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    throw FormatException.a();
  }

  public static Version b(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 40))
      throw new IllegalArgumentException();
    return b[(paramInt - 1)];
  }

  static Version c(int paramInt)
  {
    int i = 0;
    int j = 2147483647;
    int k = 0;
    int m;
    Version localVersion;
    if (i < a.length)
    {
      m = a[i];
      if (m == paramInt)
        localVersion = b(i + 7);
    }
    while (true)
    {
      return localVersion;
      int n = FormatInformation.a(paramInt, m);
      if (n < j)
      {
        k = i + 7;
        j = n;
      }
      i++;
      break;
      if (j <= 3)
      {
        localVersion = b(k);
        continue;
      }
      localVersion = null;
    }
  }

  private static Version[] f()
  {
    Version[] arrayOfVersion = new Version[40];
    int[] arrayOfInt1 = new int[0];
    Version.ECBlocks[] arrayOfECBlocks1 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB1 = new Version.ECB[1];
    arrayOfECB1[0] = new Version.ECB(1, 19);
    arrayOfECBlocks1[0] = new Version.ECBlocks(7, arrayOfECB1);
    Version.ECB[] arrayOfECB2 = new Version.ECB[1];
    arrayOfECB2[0] = new Version.ECB(1, 16);
    arrayOfECBlocks1[1] = new Version.ECBlocks(10, arrayOfECB2);
    Version.ECB[] arrayOfECB3 = new Version.ECB[1];
    arrayOfECB3[0] = new Version.ECB(1, 13);
    arrayOfECBlocks1[2] = new Version.ECBlocks(13, arrayOfECB3);
    Version.ECB[] arrayOfECB4 = new Version.ECB[1];
    arrayOfECB4[0] = new Version.ECB(1, 9);
    arrayOfECBlocks1[3] = new Version.ECBlocks(17, arrayOfECB4);
    arrayOfVersion[0] = new Version(1, arrayOfInt1, arrayOfECBlocks1);
    int[] arrayOfInt2 = { 6, 18 };
    Version.ECBlocks[] arrayOfECBlocks2 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB5 = new Version.ECB[1];
    arrayOfECB5[0] = new Version.ECB(1, 34);
    arrayOfECBlocks2[0] = new Version.ECBlocks(10, arrayOfECB5);
    Version.ECB[] arrayOfECB6 = new Version.ECB[1];
    arrayOfECB6[0] = new Version.ECB(1, 28);
    arrayOfECBlocks2[1] = new Version.ECBlocks(16, arrayOfECB6);
    Version.ECB[] arrayOfECB7 = new Version.ECB[1];
    arrayOfECB7[0] = new Version.ECB(1, 22);
    arrayOfECBlocks2[2] = new Version.ECBlocks(22, arrayOfECB7);
    Version.ECB[] arrayOfECB8 = new Version.ECB[1];
    arrayOfECB8[0] = new Version.ECB(1, 16);
    arrayOfECBlocks2[3] = new Version.ECBlocks(28, arrayOfECB8);
    arrayOfVersion[1] = new Version(2, arrayOfInt2, arrayOfECBlocks2);
    int[] arrayOfInt3 = { 6, 22 };
    Version.ECBlocks[] arrayOfECBlocks3 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB9 = new Version.ECB[1];
    arrayOfECB9[0] = new Version.ECB(1, 55);
    arrayOfECBlocks3[0] = new Version.ECBlocks(15, arrayOfECB9);
    Version.ECB[] arrayOfECB10 = new Version.ECB[1];
    arrayOfECB10[0] = new Version.ECB(1, 44);
    arrayOfECBlocks3[1] = new Version.ECBlocks(26, arrayOfECB10);
    Version.ECB[] arrayOfECB11 = new Version.ECB[1];
    arrayOfECB11[0] = new Version.ECB(2, 17);
    arrayOfECBlocks3[2] = new Version.ECBlocks(18, arrayOfECB11);
    Version.ECB[] arrayOfECB12 = new Version.ECB[1];
    arrayOfECB12[0] = new Version.ECB(2, 13);
    arrayOfECBlocks3[3] = new Version.ECBlocks(22, arrayOfECB12);
    arrayOfVersion[2] = new Version(3, arrayOfInt3, arrayOfECBlocks3);
    int[] arrayOfInt4 = { 6, 26 };
    Version.ECBlocks[] arrayOfECBlocks4 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB13 = new Version.ECB[1];
    arrayOfECB13[0] = new Version.ECB(1, 80);
    arrayOfECBlocks4[0] = new Version.ECBlocks(20, arrayOfECB13);
    Version.ECB[] arrayOfECB14 = new Version.ECB[1];
    arrayOfECB14[0] = new Version.ECB(2, 32);
    arrayOfECBlocks4[1] = new Version.ECBlocks(18, arrayOfECB14);
    Version.ECB[] arrayOfECB15 = new Version.ECB[1];
    arrayOfECB15[0] = new Version.ECB(2, 24);
    arrayOfECBlocks4[2] = new Version.ECBlocks(26, arrayOfECB15);
    Version.ECB[] arrayOfECB16 = new Version.ECB[1];
    arrayOfECB16[0] = new Version.ECB(4, 9);
    arrayOfECBlocks4[3] = new Version.ECBlocks(16, arrayOfECB16);
    arrayOfVersion[3] = new Version(4, arrayOfInt4, arrayOfECBlocks4);
    int[] arrayOfInt5 = { 6, 30 };
    Version.ECBlocks[] arrayOfECBlocks5 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB17 = new Version.ECB[1];
    arrayOfECB17[0] = new Version.ECB(1, 108);
    arrayOfECBlocks5[0] = new Version.ECBlocks(26, arrayOfECB17);
    Version.ECB[] arrayOfECB18 = new Version.ECB[1];
    arrayOfECB18[0] = new Version.ECB(2, 43);
    arrayOfECBlocks5[1] = new Version.ECBlocks(24, arrayOfECB18);
    Version.ECB[] arrayOfECB19 = new Version.ECB[2];
    arrayOfECB19[0] = new Version.ECB(2, 15);
    arrayOfECB19[1] = new Version.ECB(2, 16);
    arrayOfECBlocks5[2] = new Version.ECBlocks(18, arrayOfECB19);
    Version.ECB[] arrayOfECB20 = new Version.ECB[2];
    arrayOfECB20[0] = new Version.ECB(2, 11);
    arrayOfECB20[1] = new Version.ECB(2, 12);
    arrayOfECBlocks5[3] = new Version.ECBlocks(22, arrayOfECB20);
    arrayOfVersion[4] = new Version(5, arrayOfInt5, arrayOfECBlocks5);
    int[] arrayOfInt6 = { 6, 34 };
    Version.ECBlocks[] arrayOfECBlocks6 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB21 = new Version.ECB[1];
    arrayOfECB21[0] = new Version.ECB(2, 68);
    arrayOfECBlocks6[0] = new Version.ECBlocks(18, arrayOfECB21);
    Version.ECB[] arrayOfECB22 = new Version.ECB[1];
    arrayOfECB22[0] = new Version.ECB(4, 27);
    arrayOfECBlocks6[1] = new Version.ECBlocks(16, arrayOfECB22);
    Version.ECB[] arrayOfECB23 = new Version.ECB[1];
    arrayOfECB23[0] = new Version.ECB(4, 19);
    arrayOfECBlocks6[2] = new Version.ECBlocks(24, arrayOfECB23);
    Version.ECB[] arrayOfECB24 = new Version.ECB[1];
    arrayOfECB24[0] = new Version.ECB(4, 15);
    arrayOfECBlocks6[3] = new Version.ECBlocks(28, arrayOfECB24);
    arrayOfVersion[5] = new Version(6, arrayOfInt6, arrayOfECBlocks6);
    int[] arrayOfInt7 = { 6, 22, 38 };
    Version.ECBlocks[] arrayOfECBlocks7 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB25 = new Version.ECB[1];
    arrayOfECB25[0] = new Version.ECB(2, 78);
    arrayOfECBlocks7[0] = new Version.ECBlocks(20, arrayOfECB25);
    Version.ECB[] arrayOfECB26 = new Version.ECB[1];
    arrayOfECB26[0] = new Version.ECB(4, 31);
    arrayOfECBlocks7[1] = new Version.ECBlocks(18, arrayOfECB26);
    Version.ECB[] arrayOfECB27 = new Version.ECB[2];
    arrayOfECB27[0] = new Version.ECB(2, 14);
    arrayOfECB27[1] = new Version.ECB(4, 15);
    arrayOfECBlocks7[2] = new Version.ECBlocks(18, arrayOfECB27);
    Version.ECB[] arrayOfECB28 = new Version.ECB[2];
    arrayOfECB28[0] = new Version.ECB(4, 13);
    arrayOfECB28[1] = new Version.ECB(1, 14);
    arrayOfECBlocks7[3] = new Version.ECBlocks(26, arrayOfECB28);
    arrayOfVersion[6] = new Version(7, arrayOfInt7, arrayOfECBlocks7);
    int[] arrayOfInt8 = { 6, 24, 42 };
    Version.ECBlocks[] arrayOfECBlocks8 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB29 = new Version.ECB[1];
    arrayOfECB29[0] = new Version.ECB(2, 97);
    arrayOfECBlocks8[0] = new Version.ECBlocks(24, arrayOfECB29);
    Version.ECB[] arrayOfECB30 = new Version.ECB[2];
    arrayOfECB30[0] = new Version.ECB(2, 38);
    arrayOfECB30[1] = new Version.ECB(2, 39);
    arrayOfECBlocks8[1] = new Version.ECBlocks(22, arrayOfECB30);
    Version.ECB[] arrayOfECB31 = new Version.ECB[2];
    arrayOfECB31[0] = new Version.ECB(4, 18);
    arrayOfECB31[1] = new Version.ECB(2, 19);
    arrayOfECBlocks8[2] = new Version.ECBlocks(22, arrayOfECB31);
    Version.ECB[] arrayOfECB32 = new Version.ECB[2];
    arrayOfECB32[0] = new Version.ECB(4, 14);
    arrayOfECB32[1] = new Version.ECB(2, 15);
    arrayOfECBlocks8[3] = new Version.ECBlocks(26, arrayOfECB32);
    arrayOfVersion[7] = new Version(8, arrayOfInt8, arrayOfECBlocks8);
    int[] arrayOfInt9 = { 6, 26, 46 };
    Version.ECBlocks[] arrayOfECBlocks9 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB33 = new Version.ECB[1];
    arrayOfECB33[0] = new Version.ECB(2, 116);
    arrayOfECBlocks9[0] = new Version.ECBlocks(30, arrayOfECB33);
    Version.ECB[] arrayOfECB34 = new Version.ECB[2];
    arrayOfECB34[0] = new Version.ECB(3, 36);
    arrayOfECB34[1] = new Version.ECB(2, 37);
    arrayOfECBlocks9[1] = new Version.ECBlocks(22, arrayOfECB34);
    Version.ECB[] arrayOfECB35 = new Version.ECB[2];
    arrayOfECB35[0] = new Version.ECB(4, 16);
    arrayOfECB35[1] = new Version.ECB(4, 17);
    arrayOfECBlocks9[2] = new Version.ECBlocks(20, arrayOfECB35);
    Version.ECB[] arrayOfECB36 = new Version.ECB[2];
    arrayOfECB36[0] = new Version.ECB(4, 12);
    arrayOfECB36[1] = new Version.ECB(4, 13);
    arrayOfECBlocks9[3] = new Version.ECBlocks(24, arrayOfECB36);
    arrayOfVersion[8] = new Version(9, arrayOfInt9, arrayOfECBlocks9);
    int[] arrayOfInt10 = { 6, 28, 50 };
    Version.ECBlocks[] arrayOfECBlocks10 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB37 = new Version.ECB[2];
    arrayOfECB37[0] = new Version.ECB(2, 68);
    arrayOfECB37[1] = new Version.ECB(2, 69);
    arrayOfECBlocks10[0] = new Version.ECBlocks(18, arrayOfECB37);
    Version.ECB[] arrayOfECB38 = new Version.ECB[2];
    arrayOfECB38[0] = new Version.ECB(4, 43);
    arrayOfECB38[1] = new Version.ECB(1, 44);
    arrayOfECBlocks10[1] = new Version.ECBlocks(26, arrayOfECB38);
    Version.ECB[] arrayOfECB39 = new Version.ECB[2];
    arrayOfECB39[0] = new Version.ECB(6, 19);
    arrayOfECB39[1] = new Version.ECB(2, 20);
    arrayOfECBlocks10[2] = new Version.ECBlocks(24, arrayOfECB39);
    Version.ECB[] arrayOfECB40 = new Version.ECB[2];
    arrayOfECB40[0] = new Version.ECB(6, 15);
    arrayOfECB40[1] = new Version.ECB(2, 16);
    arrayOfECBlocks10[3] = new Version.ECBlocks(28, arrayOfECB40);
    arrayOfVersion[9] = new Version(10, arrayOfInt10, arrayOfECBlocks10);
    int[] arrayOfInt11 = { 6, 30, 54 };
    Version.ECBlocks[] arrayOfECBlocks11 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB41 = new Version.ECB[1];
    arrayOfECB41[0] = new Version.ECB(4, 81);
    arrayOfECBlocks11[0] = new Version.ECBlocks(20, arrayOfECB41);
    Version.ECB[] arrayOfECB42 = new Version.ECB[2];
    arrayOfECB42[0] = new Version.ECB(1, 50);
    arrayOfECB42[1] = new Version.ECB(4, 51);
    arrayOfECBlocks11[1] = new Version.ECBlocks(30, arrayOfECB42);
    Version.ECB[] arrayOfECB43 = new Version.ECB[2];
    arrayOfECB43[0] = new Version.ECB(4, 22);
    arrayOfECB43[1] = new Version.ECB(4, 23);
    arrayOfECBlocks11[2] = new Version.ECBlocks(28, arrayOfECB43);
    Version.ECB[] arrayOfECB44 = new Version.ECB[2];
    arrayOfECB44[0] = new Version.ECB(3, 12);
    arrayOfECB44[1] = new Version.ECB(8, 13);
    arrayOfECBlocks11[3] = new Version.ECBlocks(24, arrayOfECB44);
    arrayOfVersion[10] = new Version(11, arrayOfInt11, arrayOfECBlocks11);
    int[] arrayOfInt12 = { 6, 32, 58 };
    Version.ECBlocks[] arrayOfECBlocks12 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB45 = new Version.ECB[2];
    arrayOfECB45[0] = new Version.ECB(2, 92);
    arrayOfECB45[1] = new Version.ECB(2, 93);
    arrayOfECBlocks12[0] = new Version.ECBlocks(24, arrayOfECB45);
    Version.ECB[] arrayOfECB46 = new Version.ECB[2];
    arrayOfECB46[0] = new Version.ECB(6, 36);
    arrayOfECB46[1] = new Version.ECB(2, 37);
    arrayOfECBlocks12[1] = new Version.ECBlocks(22, arrayOfECB46);
    Version.ECB[] arrayOfECB47 = new Version.ECB[2];
    arrayOfECB47[0] = new Version.ECB(4, 20);
    arrayOfECB47[1] = new Version.ECB(6, 21);
    arrayOfECBlocks12[2] = new Version.ECBlocks(26, arrayOfECB47);
    Version.ECB[] arrayOfECB48 = new Version.ECB[2];
    arrayOfECB48[0] = new Version.ECB(7, 14);
    arrayOfECB48[1] = new Version.ECB(4, 15);
    arrayOfECBlocks12[3] = new Version.ECBlocks(28, arrayOfECB48);
    arrayOfVersion[11] = new Version(12, arrayOfInt12, arrayOfECBlocks12);
    int[] arrayOfInt13 = { 6, 34, 62 };
    Version.ECBlocks[] arrayOfECBlocks13 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB49 = new Version.ECB[1];
    arrayOfECB49[0] = new Version.ECB(4, 107);
    arrayOfECBlocks13[0] = new Version.ECBlocks(26, arrayOfECB49);
    Version.ECB[] arrayOfECB50 = new Version.ECB[2];
    arrayOfECB50[0] = new Version.ECB(8, 37);
    arrayOfECB50[1] = new Version.ECB(1, 38);
    arrayOfECBlocks13[1] = new Version.ECBlocks(22, arrayOfECB50);
    Version.ECB[] arrayOfECB51 = new Version.ECB[2];
    arrayOfECB51[0] = new Version.ECB(8, 20);
    arrayOfECB51[1] = new Version.ECB(4, 21);
    arrayOfECBlocks13[2] = new Version.ECBlocks(24, arrayOfECB51);
    Version.ECB[] arrayOfECB52 = new Version.ECB[2];
    arrayOfECB52[0] = new Version.ECB(12, 11);
    arrayOfECB52[1] = new Version.ECB(4, 12);
    arrayOfECBlocks13[3] = new Version.ECBlocks(22, arrayOfECB52);
    arrayOfVersion[12] = new Version(13, arrayOfInt13, arrayOfECBlocks13);
    int[] arrayOfInt14 = { 6, 26, 46, 66 };
    Version.ECBlocks[] arrayOfECBlocks14 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB53 = new Version.ECB[2];
    arrayOfECB53[0] = new Version.ECB(3, 115);
    arrayOfECB53[1] = new Version.ECB(1, 116);
    arrayOfECBlocks14[0] = new Version.ECBlocks(30, arrayOfECB53);
    Version.ECB[] arrayOfECB54 = new Version.ECB[2];
    arrayOfECB54[0] = new Version.ECB(4, 40);
    arrayOfECB54[1] = new Version.ECB(5, 41);
    arrayOfECBlocks14[1] = new Version.ECBlocks(24, arrayOfECB54);
    Version.ECB[] arrayOfECB55 = new Version.ECB[2];
    arrayOfECB55[0] = new Version.ECB(11, 16);
    arrayOfECB55[1] = new Version.ECB(5, 17);
    arrayOfECBlocks14[2] = new Version.ECBlocks(20, arrayOfECB55);
    Version.ECB[] arrayOfECB56 = new Version.ECB[2];
    arrayOfECB56[0] = new Version.ECB(11, 12);
    arrayOfECB56[1] = new Version.ECB(5, 13);
    arrayOfECBlocks14[3] = new Version.ECBlocks(24, arrayOfECB56);
    arrayOfVersion[13] = new Version(14, arrayOfInt14, arrayOfECBlocks14);
    int[] arrayOfInt15 = { 6, 26, 48, 70 };
    Version.ECBlocks[] arrayOfECBlocks15 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB57 = new Version.ECB[2];
    arrayOfECB57[0] = new Version.ECB(5, 87);
    arrayOfECB57[1] = new Version.ECB(1, 88);
    arrayOfECBlocks15[0] = new Version.ECBlocks(22, arrayOfECB57);
    Version.ECB[] arrayOfECB58 = new Version.ECB[2];
    arrayOfECB58[0] = new Version.ECB(5, 41);
    arrayOfECB58[1] = new Version.ECB(5, 42);
    arrayOfECBlocks15[1] = new Version.ECBlocks(24, arrayOfECB58);
    Version.ECB[] arrayOfECB59 = new Version.ECB[2];
    arrayOfECB59[0] = new Version.ECB(5, 24);
    arrayOfECB59[1] = new Version.ECB(7, 25);
    arrayOfECBlocks15[2] = new Version.ECBlocks(30, arrayOfECB59);
    Version.ECB[] arrayOfECB60 = new Version.ECB[2];
    arrayOfECB60[0] = new Version.ECB(11, 12);
    arrayOfECB60[1] = new Version.ECB(7, 13);
    arrayOfECBlocks15[3] = new Version.ECBlocks(24, arrayOfECB60);
    arrayOfVersion[14] = new Version(15, arrayOfInt15, arrayOfECBlocks15);
    int[] arrayOfInt16 = { 6, 26, 50, 74 };
    Version.ECBlocks[] arrayOfECBlocks16 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB61 = new Version.ECB[2];
    arrayOfECB61[0] = new Version.ECB(5, 98);
    arrayOfECB61[1] = new Version.ECB(1, 99);
    arrayOfECBlocks16[0] = new Version.ECBlocks(24, arrayOfECB61);
    Version.ECB[] arrayOfECB62 = new Version.ECB[2];
    arrayOfECB62[0] = new Version.ECB(7, 45);
    arrayOfECB62[1] = new Version.ECB(3, 46);
    arrayOfECBlocks16[1] = new Version.ECBlocks(28, arrayOfECB62);
    Version.ECB[] arrayOfECB63 = new Version.ECB[2];
    arrayOfECB63[0] = new Version.ECB(15, 19);
    arrayOfECB63[1] = new Version.ECB(2, 20);
    arrayOfECBlocks16[2] = new Version.ECBlocks(24, arrayOfECB63);
    Version.ECB[] arrayOfECB64 = new Version.ECB[2];
    arrayOfECB64[0] = new Version.ECB(3, 15);
    arrayOfECB64[1] = new Version.ECB(13, 16);
    arrayOfECBlocks16[3] = new Version.ECBlocks(30, arrayOfECB64);
    arrayOfVersion[15] = new Version(16, arrayOfInt16, arrayOfECBlocks16);
    int[] arrayOfInt17 = { 6, 30, 54, 78 };
    Version.ECBlocks[] arrayOfECBlocks17 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB65 = new Version.ECB[2];
    arrayOfECB65[0] = new Version.ECB(1, 107);
    arrayOfECB65[1] = new Version.ECB(5, 108);
    arrayOfECBlocks17[0] = new Version.ECBlocks(28, arrayOfECB65);
    Version.ECB[] arrayOfECB66 = new Version.ECB[2];
    arrayOfECB66[0] = new Version.ECB(10, 46);
    arrayOfECB66[1] = new Version.ECB(1, 47);
    arrayOfECBlocks17[1] = new Version.ECBlocks(28, arrayOfECB66);
    Version.ECB[] arrayOfECB67 = new Version.ECB[2];
    arrayOfECB67[0] = new Version.ECB(1, 22);
    arrayOfECB67[1] = new Version.ECB(15, 23);
    arrayOfECBlocks17[2] = new Version.ECBlocks(28, arrayOfECB67);
    Version.ECB[] arrayOfECB68 = new Version.ECB[2];
    arrayOfECB68[0] = new Version.ECB(2, 14);
    arrayOfECB68[1] = new Version.ECB(17, 15);
    arrayOfECBlocks17[3] = new Version.ECBlocks(28, arrayOfECB68);
    arrayOfVersion[16] = new Version(17, arrayOfInt17, arrayOfECBlocks17);
    int[] arrayOfInt18 = { 6, 30, 56, 82 };
    Version.ECBlocks[] arrayOfECBlocks18 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB69 = new Version.ECB[2];
    arrayOfECB69[0] = new Version.ECB(5, 120);
    arrayOfECB69[1] = new Version.ECB(1, 121);
    arrayOfECBlocks18[0] = new Version.ECBlocks(30, arrayOfECB69);
    Version.ECB[] arrayOfECB70 = new Version.ECB[2];
    arrayOfECB70[0] = new Version.ECB(9, 43);
    arrayOfECB70[1] = new Version.ECB(4, 44);
    arrayOfECBlocks18[1] = new Version.ECBlocks(26, arrayOfECB70);
    Version.ECB[] arrayOfECB71 = new Version.ECB[2];
    arrayOfECB71[0] = new Version.ECB(17, 22);
    arrayOfECB71[1] = new Version.ECB(1, 23);
    arrayOfECBlocks18[2] = new Version.ECBlocks(28, arrayOfECB71);
    Version.ECB[] arrayOfECB72 = new Version.ECB[2];
    arrayOfECB72[0] = new Version.ECB(2, 14);
    arrayOfECB72[1] = new Version.ECB(19, 15);
    arrayOfECBlocks18[3] = new Version.ECBlocks(28, arrayOfECB72);
    arrayOfVersion[17] = new Version(18, arrayOfInt18, arrayOfECBlocks18);
    int[] arrayOfInt19 = { 6, 30, 58, 86 };
    Version.ECBlocks[] arrayOfECBlocks19 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB73 = new Version.ECB[2];
    arrayOfECB73[0] = new Version.ECB(3, 113);
    arrayOfECB73[1] = new Version.ECB(4, 114);
    arrayOfECBlocks19[0] = new Version.ECBlocks(28, arrayOfECB73);
    Version.ECB[] arrayOfECB74 = new Version.ECB[2];
    arrayOfECB74[0] = new Version.ECB(3, 44);
    arrayOfECB74[1] = new Version.ECB(11, 45);
    arrayOfECBlocks19[1] = new Version.ECBlocks(26, arrayOfECB74);
    Version.ECB[] arrayOfECB75 = new Version.ECB[2];
    arrayOfECB75[0] = new Version.ECB(17, 21);
    arrayOfECB75[1] = new Version.ECB(4, 22);
    arrayOfECBlocks19[2] = new Version.ECBlocks(26, arrayOfECB75);
    Version.ECB[] arrayOfECB76 = new Version.ECB[2];
    arrayOfECB76[0] = new Version.ECB(9, 13);
    arrayOfECB76[1] = new Version.ECB(16, 14);
    arrayOfECBlocks19[3] = new Version.ECBlocks(26, arrayOfECB76);
    arrayOfVersion[18] = new Version(19, arrayOfInt19, arrayOfECBlocks19);
    int[] arrayOfInt20 = { 6, 34, 62, 90 };
    Version.ECBlocks[] arrayOfECBlocks20 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB77 = new Version.ECB[2];
    arrayOfECB77[0] = new Version.ECB(3, 107);
    arrayOfECB77[1] = new Version.ECB(5, 108);
    arrayOfECBlocks20[0] = new Version.ECBlocks(28, arrayOfECB77);
    Version.ECB[] arrayOfECB78 = new Version.ECB[2];
    arrayOfECB78[0] = new Version.ECB(3, 41);
    arrayOfECB78[1] = new Version.ECB(13, 42);
    arrayOfECBlocks20[1] = new Version.ECBlocks(26, arrayOfECB78);
    Version.ECB[] arrayOfECB79 = new Version.ECB[2];
    arrayOfECB79[0] = new Version.ECB(15, 24);
    arrayOfECB79[1] = new Version.ECB(5, 25);
    arrayOfECBlocks20[2] = new Version.ECBlocks(30, arrayOfECB79);
    Version.ECB[] arrayOfECB80 = new Version.ECB[2];
    arrayOfECB80[0] = new Version.ECB(15, 15);
    arrayOfECB80[1] = new Version.ECB(10, 16);
    arrayOfECBlocks20[3] = new Version.ECBlocks(28, arrayOfECB80);
    arrayOfVersion[19] = new Version(20, arrayOfInt20, arrayOfECBlocks20);
    int[] arrayOfInt21 = { 6, 28, 50, 72, 94 };
    Version.ECBlocks[] arrayOfECBlocks21 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB81 = new Version.ECB[2];
    arrayOfECB81[0] = new Version.ECB(4, 116);
    arrayOfECB81[1] = new Version.ECB(4, 117);
    arrayOfECBlocks21[0] = new Version.ECBlocks(28, arrayOfECB81);
    Version.ECB[] arrayOfECB82 = new Version.ECB[1];
    arrayOfECB82[0] = new Version.ECB(17, 42);
    arrayOfECBlocks21[1] = new Version.ECBlocks(26, arrayOfECB82);
    Version.ECB[] arrayOfECB83 = new Version.ECB[2];
    arrayOfECB83[0] = new Version.ECB(17, 22);
    arrayOfECB83[1] = new Version.ECB(6, 23);
    arrayOfECBlocks21[2] = new Version.ECBlocks(28, arrayOfECB83);
    Version.ECB[] arrayOfECB84 = new Version.ECB[2];
    arrayOfECB84[0] = new Version.ECB(19, 16);
    arrayOfECB84[1] = new Version.ECB(6, 17);
    arrayOfECBlocks21[3] = new Version.ECBlocks(30, arrayOfECB84);
    arrayOfVersion[20] = new Version(21, arrayOfInt21, arrayOfECBlocks21);
    int[] arrayOfInt22 = { 6, 26, 50, 74, 98 };
    Version.ECBlocks[] arrayOfECBlocks22 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB85 = new Version.ECB[2];
    arrayOfECB85[0] = new Version.ECB(2, 111);
    arrayOfECB85[1] = new Version.ECB(7, 112);
    arrayOfECBlocks22[0] = new Version.ECBlocks(28, arrayOfECB85);
    Version.ECB[] arrayOfECB86 = new Version.ECB[1];
    arrayOfECB86[0] = new Version.ECB(17, 46);
    arrayOfECBlocks22[1] = new Version.ECBlocks(28, arrayOfECB86);
    Version.ECB[] arrayOfECB87 = new Version.ECB[2];
    arrayOfECB87[0] = new Version.ECB(7, 24);
    arrayOfECB87[1] = new Version.ECB(16, 25);
    arrayOfECBlocks22[2] = new Version.ECBlocks(30, arrayOfECB87);
    Version.ECB[] arrayOfECB88 = new Version.ECB[1];
    arrayOfECB88[0] = new Version.ECB(34, 13);
    arrayOfECBlocks22[3] = new Version.ECBlocks(24, arrayOfECB88);
    arrayOfVersion[21] = new Version(22, arrayOfInt22, arrayOfECBlocks22);
    int[] arrayOfInt23 = { 6, 30, 54, 78, 102 };
    Version.ECBlocks[] arrayOfECBlocks23 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB89 = new Version.ECB[2];
    arrayOfECB89[0] = new Version.ECB(4, 121);
    arrayOfECB89[1] = new Version.ECB(5, 122);
    arrayOfECBlocks23[0] = new Version.ECBlocks(30, arrayOfECB89);
    Version.ECB[] arrayOfECB90 = new Version.ECB[2];
    arrayOfECB90[0] = new Version.ECB(4, 47);
    arrayOfECB90[1] = new Version.ECB(14, 48);
    arrayOfECBlocks23[1] = new Version.ECBlocks(28, arrayOfECB90);
    Version.ECB[] arrayOfECB91 = new Version.ECB[2];
    arrayOfECB91[0] = new Version.ECB(11, 24);
    arrayOfECB91[1] = new Version.ECB(14, 25);
    arrayOfECBlocks23[2] = new Version.ECBlocks(30, arrayOfECB91);
    Version.ECB[] arrayOfECB92 = new Version.ECB[2];
    arrayOfECB92[0] = new Version.ECB(16, 15);
    arrayOfECB92[1] = new Version.ECB(14, 16);
    arrayOfECBlocks23[3] = new Version.ECBlocks(30, arrayOfECB92);
    arrayOfVersion[22] = new Version(23, arrayOfInt23, arrayOfECBlocks23);
    int[] arrayOfInt24 = { 6, 28, 54, 80, 106 };
    Version.ECBlocks[] arrayOfECBlocks24 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB93 = new Version.ECB[2];
    arrayOfECB93[0] = new Version.ECB(6, 117);
    arrayOfECB93[1] = new Version.ECB(4, 118);
    arrayOfECBlocks24[0] = new Version.ECBlocks(30, arrayOfECB93);
    Version.ECB[] arrayOfECB94 = new Version.ECB[2];
    arrayOfECB94[0] = new Version.ECB(6, 45);
    arrayOfECB94[1] = new Version.ECB(14, 46);
    arrayOfECBlocks24[1] = new Version.ECBlocks(28, arrayOfECB94);
    Version.ECB[] arrayOfECB95 = new Version.ECB[2];
    arrayOfECB95[0] = new Version.ECB(11, 24);
    arrayOfECB95[1] = new Version.ECB(16, 25);
    arrayOfECBlocks24[2] = new Version.ECBlocks(30, arrayOfECB95);
    Version.ECB[] arrayOfECB96 = new Version.ECB[2];
    arrayOfECB96[0] = new Version.ECB(30, 16);
    arrayOfECB96[1] = new Version.ECB(2, 17);
    arrayOfECBlocks24[3] = new Version.ECBlocks(30, arrayOfECB96);
    arrayOfVersion[23] = new Version(24, arrayOfInt24, arrayOfECBlocks24);
    int[] arrayOfInt25 = { 6, 32, 58, 84, 110 };
    Version.ECBlocks[] arrayOfECBlocks25 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB97 = new Version.ECB[2];
    arrayOfECB97[0] = new Version.ECB(8, 106);
    arrayOfECB97[1] = new Version.ECB(4, 107);
    arrayOfECBlocks25[0] = new Version.ECBlocks(26, arrayOfECB97);
    Version.ECB[] arrayOfECB98 = new Version.ECB[2];
    arrayOfECB98[0] = new Version.ECB(8, 47);
    arrayOfECB98[1] = new Version.ECB(13, 48);
    arrayOfECBlocks25[1] = new Version.ECBlocks(28, arrayOfECB98);
    Version.ECB[] arrayOfECB99 = new Version.ECB[2];
    arrayOfECB99[0] = new Version.ECB(7, 24);
    arrayOfECB99[1] = new Version.ECB(22, 25);
    arrayOfECBlocks25[2] = new Version.ECBlocks(30, arrayOfECB99);
    Version.ECB[] arrayOfECB100 = new Version.ECB[2];
    arrayOfECB100[0] = new Version.ECB(22, 15);
    arrayOfECB100[1] = new Version.ECB(13, 16);
    arrayOfECBlocks25[3] = new Version.ECBlocks(30, arrayOfECB100);
    arrayOfVersion[24] = new Version(25, arrayOfInt25, arrayOfECBlocks25);
    int[] arrayOfInt26 = { 6, 30, 58, 86, 114 };
    Version.ECBlocks[] arrayOfECBlocks26 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB101 = new Version.ECB[2];
    arrayOfECB101[0] = new Version.ECB(10, 114);
    arrayOfECB101[1] = new Version.ECB(2, 115);
    arrayOfECBlocks26[0] = new Version.ECBlocks(28, arrayOfECB101);
    Version.ECB[] arrayOfECB102 = new Version.ECB[2];
    arrayOfECB102[0] = new Version.ECB(19, 46);
    arrayOfECB102[1] = new Version.ECB(4, 47);
    arrayOfECBlocks26[1] = new Version.ECBlocks(28, arrayOfECB102);
    Version.ECB[] arrayOfECB103 = new Version.ECB[2];
    arrayOfECB103[0] = new Version.ECB(28, 22);
    arrayOfECB103[1] = new Version.ECB(6, 23);
    arrayOfECBlocks26[2] = new Version.ECBlocks(28, arrayOfECB103);
    Version.ECB[] arrayOfECB104 = new Version.ECB[2];
    arrayOfECB104[0] = new Version.ECB(33, 16);
    arrayOfECB104[1] = new Version.ECB(4, 17);
    arrayOfECBlocks26[3] = new Version.ECBlocks(30, arrayOfECB104);
    arrayOfVersion[25] = new Version(26, arrayOfInt26, arrayOfECBlocks26);
    int[] arrayOfInt27 = { 6, 34, 62, 90, 118 };
    Version.ECBlocks[] arrayOfECBlocks27 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB105 = new Version.ECB[2];
    arrayOfECB105[0] = new Version.ECB(8, 122);
    arrayOfECB105[1] = new Version.ECB(4, 123);
    arrayOfECBlocks27[0] = new Version.ECBlocks(30, arrayOfECB105);
    Version.ECB[] arrayOfECB106 = new Version.ECB[2];
    arrayOfECB106[0] = new Version.ECB(22, 45);
    arrayOfECB106[1] = new Version.ECB(3, 46);
    arrayOfECBlocks27[1] = new Version.ECBlocks(28, arrayOfECB106);
    Version.ECB[] arrayOfECB107 = new Version.ECB[2];
    arrayOfECB107[0] = new Version.ECB(8, 23);
    arrayOfECB107[1] = new Version.ECB(26, 24);
    arrayOfECBlocks27[2] = new Version.ECBlocks(30, arrayOfECB107);
    Version.ECB[] arrayOfECB108 = new Version.ECB[2];
    arrayOfECB108[0] = new Version.ECB(12, 15);
    arrayOfECB108[1] = new Version.ECB(28, 16);
    arrayOfECBlocks27[3] = new Version.ECBlocks(30, arrayOfECB108);
    arrayOfVersion[26] = new Version(27, arrayOfInt27, arrayOfECBlocks27);
    int[] arrayOfInt28 = { 6, 26, 50, 74, 98, 122 };
    Version.ECBlocks[] arrayOfECBlocks28 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB109 = new Version.ECB[2];
    arrayOfECB109[0] = new Version.ECB(3, 117);
    arrayOfECB109[1] = new Version.ECB(10, 118);
    arrayOfECBlocks28[0] = new Version.ECBlocks(30, arrayOfECB109);
    Version.ECB[] arrayOfECB110 = new Version.ECB[2];
    arrayOfECB110[0] = new Version.ECB(3, 45);
    arrayOfECB110[1] = new Version.ECB(23, 46);
    arrayOfECBlocks28[1] = new Version.ECBlocks(28, arrayOfECB110);
    Version.ECB[] arrayOfECB111 = new Version.ECB[2];
    arrayOfECB111[0] = new Version.ECB(4, 24);
    arrayOfECB111[1] = new Version.ECB(31, 25);
    arrayOfECBlocks28[2] = new Version.ECBlocks(30, arrayOfECB111);
    Version.ECB[] arrayOfECB112 = new Version.ECB[2];
    arrayOfECB112[0] = new Version.ECB(11, 15);
    arrayOfECB112[1] = new Version.ECB(31, 16);
    arrayOfECBlocks28[3] = new Version.ECBlocks(30, arrayOfECB112);
    arrayOfVersion[27] = new Version(28, arrayOfInt28, arrayOfECBlocks28);
    int[] arrayOfInt29 = { 6, 30, 54, 78, 102, 126 };
    Version.ECBlocks[] arrayOfECBlocks29 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB113 = new Version.ECB[2];
    arrayOfECB113[0] = new Version.ECB(7, 116);
    arrayOfECB113[1] = new Version.ECB(7, 117);
    arrayOfECBlocks29[0] = new Version.ECBlocks(30, arrayOfECB113);
    Version.ECB[] arrayOfECB114 = new Version.ECB[2];
    arrayOfECB114[0] = new Version.ECB(21, 45);
    arrayOfECB114[1] = new Version.ECB(7, 46);
    arrayOfECBlocks29[1] = new Version.ECBlocks(28, arrayOfECB114);
    Version.ECB[] arrayOfECB115 = new Version.ECB[2];
    arrayOfECB115[0] = new Version.ECB(1, 23);
    arrayOfECB115[1] = new Version.ECB(37, 24);
    arrayOfECBlocks29[2] = new Version.ECBlocks(30, arrayOfECB115);
    Version.ECB[] arrayOfECB116 = new Version.ECB[2];
    arrayOfECB116[0] = new Version.ECB(19, 15);
    arrayOfECB116[1] = new Version.ECB(26, 16);
    arrayOfECBlocks29[3] = new Version.ECBlocks(30, arrayOfECB116);
    arrayOfVersion[28] = new Version(29, arrayOfInt29, arrayOfECBlocks29);
    int[] arrayOfInt30 = { 6, 26, 52, 78, 104, 130 };
    Version.ECBlocks[] arrayOfECBlocks30 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB117 = new Version.ECB[2];
    arrayOfECB117[0] = new Version.ECB(5, 115);
    arrayOfECB117[1] = new Version.ECB(10, 116);
    arrayOfECBlocks30[0] = new Version.ECBlocks(30, arrayOfECB117);
    Version.ECB[] arrayOfECB118 = new Version.ECB[2];
    arrayOfECB118[0] = new Version.ECB(19, 47);
    arrayOfECB118[1] = new Version.ECB(10, 48);
    arrayOfECBlocks30[1] = new Version.ECBlocks(28, arrayOfECB118);
    Version.ECB[] arrayOfECB119 = new Version.ECB[2];
    arrayOfECB119[0] = new Version.ECB(15, 24);
    arrayOfECB119[1] = new Version.ECB(25, 25);
    arrayOfECBlocks30[2] = new Version.ECBlocks(30, arrayOfECB119);
    Version.ECB[] arrayOfECB120 = new Version.ECB[2];
    arrayOfECB120[0] = new Version.ECB(23, 15);
    arrayOfECB120[1] = new Version.ECB(25, 16);
    arrayOfECBlocks30[3] = new Version.ECBlocks(30, arrayOfECB120);
    arrayOfVersion[29] = new Version(30, arrayOfInt30, arrayOfECBlocks30);
    int[] arrayOfInt31 = { 6, 30, 56, 82, 108, 134 };
    Version.ECBlocks[] arrayOfECBlocks31 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB121 = new Version.ECB[2];
    arrayOfECB121[0] = new Version.ECB(13, 115);
    arrayOfECB121[1] = new Version.ECB(3, 116);
    arrayOfECBlocks31[0] = new Version.ECBlocks(30, arrayOfECB121);
    Version.ECB[] arrayOfECB122 = new Version.ECB[2];
    arrayOfECB122[0] = new Version.ECB(2, 46);
    arrayOfECB122[1] = new Version.ECB(29, 47);
    arrayOfECBlocks31[1] = new Version.ECBlocks(28, arrayOfECB122);
    Version.ECB[] arrayOfECB123 = new Version.ECB[2];
    arrayOfECB123[0] = new Version.ECB(42, 24);
    arrayOfECB123[1] = new Version.ECB(1, 25);
    arrayOfECBlocks31[2] = new Version.ECBlocks(30, arrayOfECB123);
    Version.ECB[] arrayOfECB124 = new Version.ECB[2];
    arrayOfECB124[0] = new Version.ECB(23, 15);
    arrayOfECB124[1] = new Version.ECB(28, 16);
    arrayOfECBlocks31[3] = new Version.ECBlocks(30, arrayOfECB124);
    arrayOfVersion[30] = new Version(31, arrayOfInt31, arrayOfECBlocks31);
    int[] arrayOfInt32 = { 6, 34, 60, 86, 112, 138 };
    Version.ECBlocks[] arrayOfECBlocks32 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB125 = new Version.ECB[1];
    arrayOfECB125[0] = new Version.ECB(17, 115);
    arrayOfECBlocks32[0] = new Version.ECBlocks(30, arrayOfECB125);
    Version.ECB[] arrayOfECB126 = new Version.ECB[2];
    arrayOfECB126[0] = new Version.ECB(10, 46);
    arrayOfECB126[1] = new Version.ECB(23, 47);
    arrayOfECBlocks32[1] = new Version.ECBlocks(28, arrayOfECB126);
    Version.ECB[] arrayOfECB127 = new Version.ECB[2];
    arrayOfECB127[0] = new Version.ECB(10, 24);
    arrayOfECB127[1] = new Version.ECB(35, 25);
    arrayOfECBlocks32[2] = new Version.ECBlocks(30, arrayOfECB127);
    Version.ECB[] arrayOfECB128 = new Version.ECB[2];
    arrayOfECB128[0] = new Version.ECB(19, 15);
    arrayOfECB128[1] = new Version.ECB(35, 16);
    arrayOfECBlocks32[3] = new Version.ECBlocks(30, arrayOfECB128);
    arrayOfVersion[31] = new Version(32, arrayOfInt32, arrayOfECBlocks32);
    int[] arrayOfInt33 = { 6, 30, 58, 86, 114, 142 };
    Version.ECBlocks[] arrayOfECBlocks33 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB129 = new Version.ECB[2];
    arrayOfECB129[0] = new Version.ECB(17, 115);
    arrayOfECB129[1] = new Version.ECB(1, 116);
    arrayOfECBlocks33[0] = new Version.ECBlocks(30, arrayOfECB129);
    Version.ECB[] arrayOfECB130 = new Version.ECB[2];
    arrayOfECB130[0] = new Version.ECB(14, 46);
    arrayOfECB130[1] = new Version.ECB(21, 47);
    arrayOfECBlocks33[1] = new Version.ECBlocks(28, arrayOfECB130);
    Version.ECB[] arrayOfECB131 = new Version.ECB[2];
    arrayOfECB131[0] = new Version.ECB(29, 24);
    arrayOfECB131[1] = new Version.ECB(19, 25);
    arrayOfECBlocks33[2] = new Version.ECBlocks(30, arrayOfECB131);
    Version.ECB[] arrayOfECB132 = new Version.ECB[2];
    arrayOfECB132[0] = new Version.ECB(11, 15);
    arrayOfECB132[1] = new Version.ECB(46, 16);
    arrayOfECBlocks33[3] = new Version.ECBlocks(30, arrayOfECB132);
    arrayOfVersion[32] = new Version(33, arrayOfInt33, arrayOfECBlocks33);
    int[] arrayOfInt34 = { 6, 34, 62, 90, 118, 146 };
    Version.ECBlocks[] arrayOfECBlocks34 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB133 = new Version.ECB[2];
    arrayOfECB133[0] = new Version.ECB(13, 115);
    arrayOfECB133[1] = new Version.ECB(6, 116);
    arrayOfECBlocks34[0] = new Version.ECBlocks(30, arrayOfECB133);
    Version.ECB[] arrayOfECB134 = new Version.ECB[2];
    arrayOfECB134[0] = new Version.ECB(14, 46);
    arrayOfECB134[1] = new Version.ECB(23, 47);
    arrayOfECBlocks34[1] = new Version.ECBlocks(28, arrayOfECB134);
    Version.ECB[] arrayOfECB135 = new Version.ECB[2];
    arrayOfECB135[0] = new Version.ECB(44, 24);
    arrayOfECB135[1] = new Version.ECB(7, 25);
    arrayOfECBlocks34[2] = new Version.ECBlocks(30, arrayOfECB135);
    Version.ECB[] arrayOfECB136 = new Version.ECB[2];
    arrayOfECB136[0] = new Version.ECB(59, 16);
    arrayOfECB136[1] = new Version.ECB(1, 17);
    arrayOfECBlocks34[3] = new Version.ECBlocks(30, arrayOfECB136);
    arrayOfVersion[33] = new Version(34, arrayOfInt34, arrayOfECBlocks34);
    int[] arrayOfInt35 = { 6, 30, 54, 78, 102, 126, 150 };
    Version.ECBlocks[] arrayOfECBlocks35 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB137 = new Version.ECB[2];
    arrayOfECB137[0] = new Version.ECB(12, 121);
    arrayOfECB137[1] = new Version.ECB(7, 122);
    arrayOfECBlocks35[0] = new Version.ECBlocks(30, arrayOfECB137);
    Version.ECB[] arrayOfECB138 = new Version.ECB[2];
    arrayOfECB138[0] = new Version.ECB(12, 47);
    arrayOfECB138[1] = new Version.ECB(26, 48);
    arrayOfECBlocks35[1] = new Version.ECBlocks(28, arrayOfECB138);
    Version.ECB[] arrayOfECB139 = new Version.ECB[2];
    arrayOfECB139[0] = new Version.ECB(39, 24);
    arrayOfECB139[1] = new Version.ECB(14, 25);
    arrayOfECBlocks35[2] = new Version.ECBlocks(30, arrayOfECB139);
    Version.ECB[] arrayOfECB140 = new Version.ECB[2];
    arrayOfECB140[0] = new Version.ECB(22, 15);
    arrayOfECB140[1] = new Version.ECB(41, 16);
    arrayOfECBlocks35[3] = new Version.ECBlocks(30, arrayOfECB140);
    arrayOfVersion[34] = new Version(35, arrayOfInt35, arrayOfECBlocks35);
    int[] arrayOfInt36 = { 6, 24, 50, 76, 102, 128, 154 };
    Version.ECBlocks[] arrayOfECBlocks36 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB141 = new Version.ECB[2];
    arrayOfECB141[0] = new Version.ECB(6, 121);
    arrayOfECB141[1] = new Version.ECB(14, 122);
    arrayOfECBlocks36[0] = new Version.ECBlocks(30, arrayOfECB141);
    Version.ECB[] arrayOfECB142 = new Version.ECB[2];
    arrayOfECB142[0] = new Version.ECB(6, 47);
    arrayOfECB142[1] = new Version.ECB(34, 48);
    arrayOfECBlocks36[1] = new Version.ECBlocks(28, arrayOfECB142);
    Version.ECB[] arrayOfECB143 = new Version.ECB[2];
    arrayOfECB143[0] = new Version.ECB(46, 24);
    arrayOfECB143[1] = new Version.ECB(10, 25);
    arrayOfECBlocks36[2] = new Version.ECBlocks(30, arrayOfECB143);
    Version.ECB[] arrayOfECB144 = new Version.ECB[2];
    arrayOfECB144[0] = new Version.ECB(2, 15);
    arrayOfECB144[1] = new Version.ECB(64, 16);
    arrayOfECBlocks36[3] = new Version.ECBlocks(30, arrayOfECB144);
    arrayOfVersion[35] = new Version(36, arrayOfInt36, arrayOfECBlocks36);
    int[] arrayOfInt37 = { 6, 28, 54, 80, 106, 132, 158 };
    Version.ECBlocks[] arrayOfECBlocks37 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB145 = new Version.ECB[2];
    arrayOfECB145[0] = new Version.ECB(17, 122);
    arrayOfECB145[1] = new Version.ECB(4, 123);
    arrayOfECBlocks37[0] = new Version.ECBlocks(30, arrayOfECB145);
    Version.ECB[] arrayOfECB146 = new Version.ECB[2];
    arrayOfECB146[0] = new Version.ECB(29, 46);
    arrayOfECB146[1] = new Version.ECB(14, 47);
    arrayOfECBlocks37[1] = new Version.ECBlocks(28, arrayOfECB146);
    Version.ECB[] arrayOfECB147 = new Version.ECB[2];
    arrayOfECB147[0] = new Version.ECB(49, 24);
    arrayOfECB147[1] = new Version.ECB(10, 25);
    arrayOfECBlocks37[2] = new Version.ECBlocks(30, arrayOfECB147);
    Version.ECB[] arrayOfECB148 = new Version.ECB[2];
    arrayOfECB148[0] = new Version.ECB(24, 15);
    arrayOfECB148[1] = new Version.ECB(46, 16);
    arrayOfECBlocks37[3] = new Version.ECBlocks(30, arrayOfECB148);
    arrayOfVersion[36] = new Version(37, arrayOfInt37, arrayOfECBlocks37);
    int[] arrayOfInt38 = { 6, 32, 58, 84, 110, 136, 162 };
    Version.ECBlocks[] arrayOfECBlocks38 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB149 = new Version.ECB[2];
    arrayOfECB149[0] = new Version.ECB(4, 122);
    arrayOfECB149[1] = new Version.ECB(18, 123);
    arrayOfECBlocks38[0] = new Version.ECBlocks(30, arrayOfECB149);
    Version.ECB[] arrayOfECB150 = new Version.ECB[2];
    arrayOfECB150[0] = new Version.ECB(13, 46);
    arrayOfECB150[1] = new Version.ECB(32, 47);
    arrayOfECBlocks38[1] = new Version.ECBlocks(28, arrayOfECB150);
    Version.ECB[] arrayOfECB151 = new Version.ECB[2];
    arrayOfECB151[0] = new Version.ECB(48, 24);
    arrayOfECB151[1] = new Version.ECB(14, 25);
    arrayOfECBlocks38[2] = new Version.ECBlocks(30, arrayOfECB151);
    Version.ECB[] arrayOfECB152 = new Version.ECB[2];
    arrayOfECB152[0] = new Version.ECB(42, 15);
    arrayOfECB152[1] = new Version.ECB(32, 16);
    arrayOfECBlocks38[3] = new Version.ECBlocks(30, arrayOfECB152);
    arrayOfVersion[37] = new Version(38, arrayOfInt38, arrayOfECBlocks38);
    int[] arrayOfInt39 = { 6, 26, 54, 82, 110, 138, 166 };
    Version.ECBlocks[] arrayOfECBlocks39 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB153 = new Version.ECB[2];
    arrayOfECB153[0] = new Version.ECB(20, 117);
    arrayOfECB153[1] = new Version.ECB(4, 118);
    arrayOfECBlocks39[0] = new Version.ECBlocks(30, arrayOfECB153);
    Version.ECB[] arrayOfECB154 = new Version.ECB[2];
    arrayOfECB154[0] = new Version.ECB(40, 47);
    arrayOfECB154[1] = new Version.ECB(7, 48);
    arrayOfECBlocks39[1] = new Version.ECBlocks(28, arrayOfECB154);
    Version.ECB[] arrayOfECB155 = new Version.ECB[2];
    arrayOfECB155[0] = new Version.ECB(43, 24);
    arrayOfECB155[1] = new Version.ECB(22, 25);
    arrayOfECBlocks39[2] = new Version.ECBlocks(30, arrayOfECB155);
    Version.ECB[] arrayOfECB156 = new Version.ECB[2];
    arrayOfECB156[0] = new Version.ECB(10, 15);
    arrayOfECB156[1] = new Version.ECB(67, 16);
    arrayOfECBlocks39[3] = new Version.ECBlocks(30, arrayOfECB156);
    arrayOfVersion[38] = new Version(39, arrayOfInt39, arrayOfECBlocks39);
    int[] arrayOfInt40 = { 6, 30, 58, 86, 114, 142, 170 };
    Version.ECBlocks[] arrayOfECBlocks40 = new Version.ECBlocks[4];
    Version.ECB[] arrayOfECB157 = new Version.ECB[2];
    arrayOfECB157[0] = new Version.ECB(19, 118);
    arrayOfECB157[1] = new Version.ECB(6, 119);
    arrayOfECBlocks40[0] = new Version.ECBlocks(30, arrayOfECB157);
    Version.ECB[] arrayOfECB158 = new Version.ECB[2];
    arrayOfECB158[0] = new Version.ECB(18, 47);
    arrayOfECB158[1] = new Version.ECB(31, 48);
    arrayOfECBlocks40[1] = new Version.ECBlocks(28, arrayOfECB158);
    Version.ECB[] arrayOfECB159 = new Version.ECB[2];
    arrayOfECB159[0] = new Version.ECB(34, 24);
    arrayOfECB159[1] = new Version.ECB(34, 25);
    arrayOfECBlocks40[2] = new Version.ECBlocks(30, arrayOfECB159);
    Version.ECB[] arrayOfECB160 = new Version.ECB[2];
    arrayOfECB160[0] = new Version.ECB(20, 15);
    arrayOfECB160[1] = new Version.ECB(61, 16);
    arrayOfECBlocks40[3] = new Version.ECBlocks(30, arrayOfECB160);
    arrayOfVersion[39] = new Version(40, arrayOfInt40, arrayOfECBlocks40);
    return arrayOfVersion;
  }

  public int a()
  {
    return this.c;
  }

  public Version.ECBlocks a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    return this.e[paramErrorCorrectionLevel.ordinal()];
  }

  public int[] b()
  {
    return this.d;
  }

  public int c()
  {
    return this.f;
  }

  public int d()
  {
    return 17 + 4 * this.c;
  }

  BitMatrix e()
  {
    int i = d();
    BitMatrix localBitMatrix = new BitMatrix(i);
    localBitMatrix.a(0, 0, 9, 9);
    localBitMatrix.a(i - 8, 0, 8, 9);
    localBitMatrix.a(0, i - 8, 9, 8);
    int j = this.d.length;
    for (int k = 0; k < j; k++)
    {
      int m = -2 + this.d[k];
      int n = 0;
      if (n >= j)
        continue;
      if (((k == 0) && ((n == 0) || (n == j - 1))) || ((k == j - 1) && (n == 0)));
      while (true)
      {
        n++;
        break;
        localBitMatrix.a(-2 + this.d[n], m, 5, 5);
      }
    }
    localBitMatrix.a(6, 9, 1, i - 17);
    localBitMatrix.a(9, 6, i - 17, 1);
    if (this.c > 6)
    {
      localBitMatrix.a(i - 11, 0, 3, 6);
      localBitMatrix.a(0, i - 11, 6, 3);
    }
    return localBitMatrix;
  }

  public String toString()
  {
    return String.valueOf(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.Version
 * JD-Core Version:    0.6.0
 */