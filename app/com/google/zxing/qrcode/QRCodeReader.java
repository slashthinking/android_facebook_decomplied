package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

public class QRCodeReader
{
  private static final ResultPoint[] a = new ResultPoint[0];
  private final Decoder b = new Decoder();

  private static float a(int[] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i = paramBitMatrix.d();
    int j = paramBitMatrix.c();
    int k = paramArrayOfInt[0];
    int m = paramArrayOfInt[1];
    int n = 1;
    int i1 = m;
    int i2 = k;
    int i3 = 0;
    int i5;
    if ((i2 < j) && (i1 < i))
    {
      if (n == paramBitMatrix.a(i2, i1))
        break label133;
      i5 = i3 + 1;
      if (i5 != 5);
    }
    else
    {
      if ((i2 != j) && (i1 != i))
        break label122;
      throw NotFoundException.a();
    }
    int i6;
    label95: int i4;
    if (n == 0)
    {
      i6 = 1;
      i4 = i6;
      i3 = i5;
    }
    while (true)
    {
      i2++;
      i1++;
      n = i4;
      break;
      i6 = 0;
      break label95;
      label122: return (i2 - paramArrayOfInt[0]) / 7.0F;
      label133: i4 = n;
    }
  }

  private static BitMatrix a(BitMatrix paramBitMatrix)
  {
    int[] arrayOfInt1 = paramBitMatrix.a();
    int[] arrayOfInt2 = paramBitMatrix.b();
    if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
      throw NotFoundException.a();
    float f = a(arrayOfInt1, paramBitMatrix);
    int i = arrayOfInt1[1];
    int j = arrayOfInt2[1];
    int k = arrayOfInt1[0];
    int m = arrayOfInt2[0];
    if (j - i != m - k)
      m = k + (j - i);
    int n = Math.round((1 + (m - k)) / f);
    int i1 = Math.round((1 + (j - i)) / f);
    if ((n <= 0) || (i1 <= 0))
      throw NotFoundException.a();
    if (i1 != n)
      throw NotFoundException.a();
    int i2 = (int)(f / 2.0F);
    int i3 = i + i2;
    int i4 = k + i2;
    BitMatrix localBitMatrix = new BitMatrix(n, i1);
    for (int i5 = 0; i5 < i1; i5++)
    {
      int i6 = i3 + (int)(f * i5);
      for (int i7 = 0; i7 < n; i7++)
      {
        if (!paramBitMatrix.a(i4 + (int)(f * i7), i6))
          continue;
        localBitMatrix.b(i7, i5);
      }
    }
    return localBitMatrix;
  }

  public Result a(BinaryBitmap paramBinaryBitmap)
  {
    return a(paramBinaryBitmap, null);
  }

  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    DecoderResult localDecoderResult;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.PURE_BARCODE)))
    {
      BitMatrix localBitMatrix = a(paramBinaryBitmap.a());
      localDecoderResult = this.b.a(localBitMatrix, paramMap);
    }
    DetectorResult localDetectorResult;
    for (ResultPoint[] arrayOfResultPoint = a; ; arrayOfResultPoint = localDetectorResult.b())
    {
      Result localResult = new Result(localDecoderResult.b(), localDecoderResult.a(), arrayOfResultPoint, BarcodeFormat.QR_CODE);
      List localList = localDecoderResult.c();
      if (localList != null)
        localResult.a(ResultMetadataType.BYTE_SEGMENTS, localList);
      String str = localDecoderResult.d();
      if (str != null)
        localResult.a(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
      return localResult;
      localDetectorResult = new Detector(paramBinaryBitmap.a()).a(paramMap);
      localDecoderResult = this.b.a(localDetectorResult.a(), paramMap);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.QRCodeReader
 * JD-Core Version:    0.6.0
 */