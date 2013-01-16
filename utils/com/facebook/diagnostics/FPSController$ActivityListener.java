package com.facebook.diagnostics;

import android.app.Activity;
import com.facebook.orca.activity.AbstractFbActivityListener;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import javax.inject.Provider;

public class FPSController$ActivityListener extends AbstractFbActivityListener
{
  public FPSController$ActivityListener(FPSController paramFPSController)
  {
  }

  public void b(Activity paramActivity)
  {
    if (paramActivity.isChild())
      return;
    FPSController.a(this.a, paramActivity);
    FPSController.b(this.a, paramActivity);
    if (paramActivity.getClass().getAnnotation(FPSSupport.class) != null)
      FPSController.a(this.a, ImmutableSet.a((Collection)FPSController.a(this.a).b()));
    while (true)
    {
      if ((FPSController.b(this.a) instanceof FpsCustomizingActivity))
        FPSController.a(this.a, ((FpsCustomizingActivity)FPSController.b(this.a)).a(FPSController.c(this.a)));
      FPSController.d(this.a);
      break;
      FPSController.a(this.a, ImmutableSet.d());
    }
  }

  public void c(Activity paramActivity)
  {
    if (paramActivity.isChild());
    while (true)
    {
      return;
      if (FPSController.e(this.a).contains(FpsEnableFlag.ENABLE_FLUSH_DATA_ON_PAUSE))
        this.a.b();
      FPSController.a(this.a, null);
      FPSController.d(this.a);
      FPSController.b(this.a, null);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.diagnostics.FPSController.ActivityListener
 * JD-Core Version:    0.6.2
 */