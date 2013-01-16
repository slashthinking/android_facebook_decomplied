package com.facebook.katana.activity.media.detection.barcode;

 enum QRCodeActivity$Mode
{
  static
  {
    SCAN = new Mode("SCAN", 1);
    Mode[] arrayOfMode = new Mode[2];
    arrayOfMode[0] = SHOW;
    arrayOfMode[1] = SCAN;
    $VALUES = arrayOfMode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.detection.barcode.QRCodeActivity.Mode
 * JD-Core Version:    0.6.0
 */