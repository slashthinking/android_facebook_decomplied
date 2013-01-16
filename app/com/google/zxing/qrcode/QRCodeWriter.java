package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

public final class QRCodeWriter
{
  private static BitMatrix a(QRCode paramQRCode, int paramInt1, int paramInt2, int paramInt3)
  {
    ByteMatrix localByteMatrix = paramQRCode.a();
    if (localByteMatrix == null)
      throw new IllegalStateException();
    int i = localByteMatrix.b();
    int j = localByteMatrix.a();
    int k = i + (paramInt3 << 1);
    int m = j + (paramInt3 << 1);
    int n = Math.max(paramInt1, k);
    int i1 = Math.max(paramInt2, m);
    int i2 = Math.min(n / k, i1 / m);
    int i3 = (n - i * i2) / 2;
    int i4 = (i1 - j * i2) / 2;
    BitMatrix localBitMatrix = new BitMatrix(n, i1);
    int i5 = i4;
    int i9;
    for (int i6 = 0; i6 < j; i6 = i9)
    {
      int i7 = 0;
      int i8 = i3;
      while (i7 < i)
      {
        if (localByteMatrix.a(i7, i6) == 1)
          localBitMatrix.a(i8, i5, i2, i2);
        i7++;
        i8 += i2;
      }
      i9 = i6 + 1;
      i5 += i2;
    }
    return localBitMatrix;
  }

  public BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramString.length() == 0)
      throw new IllegalArgumentException("Found empty contents");
    if (paramBarcodeFormat != BarcodeFormat.QR_CODE)
      throw new IllegalArgumentException("Can only encode QR_CODE, but got " + paramBarcodeFormat);
    if ((paramInt1 < 0) || (paramInt2 < 0))
      throw new IllegalArgumentException("Requested dimensions are too small: " + paramInt1 + 'x' + paramInt2);
    Object localObject = ErrorCorrectionLevel.L;
    Integer localInteger;
    if (paramMap != null)
    {
      ErrorCorrectionLevel localErrorCorrectionLevel = (ErrorCorrectionLevel)paramMap.get(EncodeHintType.ERROR_CORRECTION);
      if (localErrorCorrectionLevel != null)
        localObject = localErrorCorrectionLevel;
      localInteger = (Integer)paramMap.get(EncodeHintType.MARGIN);
      if (localInteger == null);
    }
    for (int i = localInteger.intValue(); ; i = 4)
      return a(Encoder.a(paramString, (ErrorCorrectionLevel)localObject, paramMap), paramInt1, paramInt2, i);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.QRCodeWriter
 * JD-Core Version:    0.6.0
 */