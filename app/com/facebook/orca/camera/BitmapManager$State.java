package com.facebook.orca.camera;

 enum BitmapManager$State
{
  static
  {
    ALLOW = new State("ALLOW", 1);
    State[] arrayOfState = new State[2];
    arrayOfState[0] = CANCEL;
    arrayOfState[1] = ALLOW;
    $VALUES = arrayOfState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.BitmapManager.State
 * JD-Core Version:    0.6.0
 */