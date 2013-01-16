package com.facebook.orca.camera;

public enum ImageManager$DataLocation
{
  static
  {
    INTERNAL = new DataLocation("INTERNAL", 1);
    EXTERNAL = new DataLocation("EXTERNAL", 2);
    ALL = new DataLocation("ALL", 3);
    DataLocation[] arrayOfDataLocation = new DataLocation[4];
    arrayOfDataLocation[0] = NONE;
    arrayOfDataLocation[1] = INTERNAL;
    arrayOfDataLocation[2] = EXTERNAL;
    arrayOfDataLocation[3] = ALL;
    $VALUES = arrayOfDataLocation;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.ImageManager.DataLocation
 * JD-Core Version:    0.6.0
 */