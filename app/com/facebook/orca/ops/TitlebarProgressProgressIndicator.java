package com.facebook.orca.ops;

import com.facebook.orca.common.ui.titlebar.FbTitleBar;

public class TitlebarProgressProgressIndicator
  implements OperationProgressIndicator
{
  private final FbTitleBar a;

  public TitlebarProgressProgressIndicator(FbTitleBar paramFbTitleBar)
  {
    this.a = paramFbTitleBar;
  }

  public void a()
  {
    this.a.a(true);
  }

  public void b()
  {
    this.a.a(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.TitlebarProgressProgressIndicator
 * JD-Core Version:    0.6.0
 */