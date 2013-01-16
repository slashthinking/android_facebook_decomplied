package com.facebook.katana.binding;

public enum AppSession$PreloadStep
{
  static
  {
    FETCH_FACEWEB_URI_MAP = new PreloadStep("FETCH_FACEWEB_URI_MAP", 2);
    PreloadStep[] arrayOfPreloadStep = new PreloadStep[3];
    arrayOfPreloadStep[0] = FETCH_GATEKEEPERS;
    arrayOfPreloadStep[1] = FETCH_SKELETON;
    arrayOfPreloadStep[2] = FETCH_FACEWEB_URI_MAP;
    $VALUES = arrayOfPreloadStep;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.AppSession.PreloadStep
 * JD-Core Version:    0.6.0
 */