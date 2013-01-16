package com.facebook.camera.utils;

public enum MediaUtil$Orientation
{
  public final int mReverseRotation;
  public final int mRotation;

  static
  {
    Orientation[] arrayOfOrientation = new Orientation[5];
    arrayOfOrientation[0] = LANDSCAPE;
    arrayOfOrientation[1] = PORTRAIT;
    arrayOfOrientation[2] = REVERSE_LANDSCAPE;
    arrayOfOrientation[3] = REVERSE_PORTRAIT;
    arrayOfOrientation[4] = UNINITIALIZED;
    $VALUES = arrayOfOrientation;
  }

  private MediaUtil$Orientation(int paramInt1, int paramInt2)
  {
    this.mRotation = paramInt1;
    this.mReverseRotation = paramInt2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.utils.MediaUtil.Orientation
 * JD-Core Version:    0.6.0
 */