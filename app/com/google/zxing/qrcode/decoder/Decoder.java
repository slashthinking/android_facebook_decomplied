package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

public final class Decoder
{
  private final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.e);

  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    int[] arrayOfInt = new int[j];
    for (int k = 0; k < j; k++)
      arrayOfInt[k] = (0xFF & paramArrayOfByte[k]);
    int m = paramArrayOfByte.length - paramInt;
    try
    {
      this.a.a(arrayOfInt, m);
      while (i < paramInt)
      {
        paramArrayOfByte[i] = (byte)arrayOfInt[i];
        i++;
      }
    }
    catch (ReedSolomonException localReedSolomonException)
    {
      throw ChecksumException.a();
    }
  }

  public DecoderResult a(BitMatrix paramBitMatrix, Map<DecodeHintType, ?> paramMap)
  {
    BitMatrixParser localBitMatrixParser = new BitMatrixParser(paramBitMatrix);
    Version localVersion = localBitMatrixParser.b();
    ErrorCorrectionLevel localErrorCorrectionLevel = localBitMatrixParser.a().a();
    DataBlock[] arrayOfDataBlock = DataBlock.a(localBitMatrixParser.c(), localVersion, localErrorCorrectionLevel);
    int i = arrayOfDataBlock.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfDataBlock[j].a();
      j++;
    }
    byte[] arrayOfByte1 = new byte[k];
    int m = arrayOfDataBlock.length;
    int n = 0;
    int i3;
    for (int i1 = 0; n < m; i1 = i3)
    {
      DataBlock localDataBlock = arrayOfDataBlock[n];
      byte[] arrayOfByte2 = localDataBlock.b();
      int i2 = localDataBlock.a();
      a(arrayOfByte2, i2);
      i3 = i1;
      int i4 = 0;
      while (i4 < i2)
      {
        int i5 = i3 + 1;
        arrayOfByte1[i3] = arrayOfByte2[i4];
        i4++;
        i3 = i5;
      }
      n++;
    }
    return DecodedBitStreamParser.a(arrayOfByte1, localVersion, localErrorCorrectionLevel, paramMap);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.Decoder
 * JD-Core Version:    0.6.0
 */