package com.facebook.orca.activity;

import android.support.v4.app.NestedFragment;
import android.view.View;
import com.facebook.orca.inject.FbInjector;

public class FbNestedFragment extends NestedFragment
{
  public FbInjector a()
  {
    return FbInjector.a(p());
  }

  protected <T extends View> T f(int paramInt)
  {
    return A().findViewById(paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.FbNestedFragment
 * JD-Core Version:    0.6.2
 */