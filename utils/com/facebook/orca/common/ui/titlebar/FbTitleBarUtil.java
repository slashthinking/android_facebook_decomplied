package com.facebook.orca.common.ui.titlebar;

import android.app.Activity;
import android.view.View;

public class FbTitleBarUtil
{
  public static boolean a(Activity paramActivity)
  {
    View localView = paramActivity.findViewById(2131296298);
    if (localView != null)
      localView.setVisibility(0);
    boolean bool = false;
    if (localView != null)
      bool = true;
    return bool;
  }

  public static boolean a(View paramView)
  {
    View localView = paramView.findViewById(2131296298);
    if (localView != null)
      localView.setVisibility(0);
    boolean bool = false;
    if (localView != null)
      bool = true;
    return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.FbTitleBarUtil
 * JD-Core Version:    0.6.2
 */