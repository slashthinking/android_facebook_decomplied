package com.facebook.camera.activity;

 enum CameraActivity$Corner
{
  static
  {
    BOTTOM_LEFT = new Corner("BOTTOM_LEFT", 2);
    BOTTOM_RIGHT = new Corner("BOTTOM_RIGHT", 3);
    Corner[] arrayOfCorner = new Corner[4];
    arrayOfCorner[0] = TOP_LEFT;
    arrayOfCorner[1] = TOP_RIGHT;
    arrayOfCorner[2] = BOTTOM_LEFT;
    arrayOfCorner[3] = BOTTOM_RIGHT;
    $VALUES = arrayOfCorner;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.activity.CameraActivity.Corner
 * JD-Core Version:    0.6.0
 */