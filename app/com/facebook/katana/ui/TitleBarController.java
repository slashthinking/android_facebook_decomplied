package com.facebook.katana.ui;

import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.orca.common.ui.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.timeline.ui.titlebar.ITitleBarController;
import com.google.common.base.Preconditions;

public class TitleBarController
  implements ITitleBarController
{
  private final FacebookActivityDelegate a;

  public TitleBarController(FacebookActivityDelegate paramFacebookActivityDelegate)
  {
    Preconditions.checkNotNull(paramFacebookActivityDelegate);
    this.a = paramFacebookActivityDelegate;
  }

  public void a(FbTitleBar.OnToolbarButtonListener paramOnToolbarButtonListener)
  {
    TitleBarController.1 local1 = new TitleBarController.1(this, paramOnToolbarButtonListener);
    this.a.a(local1);
  }

  public void a(TitleBarButtonSpec paramTitleBarButtonSpec)
  {
    this.a.a(paramTitleBarButtonSpec);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.TitleBarController
 * JD-Core Version:    0.6.0
 */