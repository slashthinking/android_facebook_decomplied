package com.google.zxing;

public enum BarcodeFormat
{
  static
  {
    CODE_128 = new BarcodeFormat("CODE_128", 4);
    DATA_MATRIX = new BarcodeFormat("DATA_MATRIX", 5);
    EAN_8 = new BarcodeFormat("EAN_8", 6);
    EAN_13 = new BarcodeFormat("EAN_13", 7);
    ITF = new BarcodeFormat("ITF", 8);
    MAXICODE = new BarcodeFormat("MAXICODE", 9);
    PDF_417 = new BarcodeFormat("PDF_417", 10);
    QR_CODE = new BarcodeFormat("QR_CODE", 11);
    RSS_14 = new BarcodeFormat("RSS_14", 12);
    RSS_EXPANDED = new BarcodeFormat("RSS_EXPANDED", 13);
    UPC_A = new BarcodeFormat("UPC_A", 14);
    UPC_E = new BarcodeFormat("UPC_E", 15);
    UPC_EAN_EXTENSION = new BarcodeFormat("UPC_EAN_EXTENSION", 16);
    BarcodeFormat[] arrayOfBarcodeFormat = new BarcodeFormat[17];
    arrayOfBarcodeFormat[0] = AZTEC;
    arrayOfBarcodeFormat[1] = CODABAR;
    arrayOfBarcodeFormat[2] = CODE_39;
    arrayOfBarcodeFormat[3] = CODE_93;
    arrayOfBarcodeFormat[4] = CODE_128;
    arrayOfBarcodeFormat[5] = DATA_MATRIX;
    arrayOfBarcodeFormat[6] = EAN_8;
    arrayOfBarcodeFormat[7] = EAN_13;
    arrayOfBarcodeFormat[8] = ITF;
    arrayOfBarcodeFormat[9] = MAXICODE;
    arrayOfBarcodeFormat[10] = PDF_417;
    arrayOfBarcodeFormat[11] = QR_CODE;
    arrayOfBarcodeFormat[12] = RSS_14;
    arrayOfBarcodeFormat[13] = RSS_EXPANDED;
    arrayOfBarcodeFormat[14] = UPC_A;
    arrayOfBarcodeFormat[15] = UPC_E;
    arrayOfBarcodeFormat[16] = UPC_EAN_EXTENSION;
    $VALUES = arrayOfBarcodeFormat;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.BarcodeFormat
 * JD-Core Version:    0.6.0
 */