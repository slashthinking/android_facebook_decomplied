package com.facebook.orca.camera;

 enum HighlightView$ModifyMode
{
  static
  {
    Move = new ModifyMode("Move", 1);
    Grow = new ModifyMode("Grow", 2);
    ModifyMode[] arrayOfModifyMode = new ModifyMode[3];
    arrayOfModifyMode[0] = None;
    arrayOfModifyMode[1] = Move;
    arrayOfModifyMode[2] = Grow;
    $VALUES = arrayOfModifyMode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.HighlightView.ModifyMode
 * JD-Core Version:    0.6.0
 */