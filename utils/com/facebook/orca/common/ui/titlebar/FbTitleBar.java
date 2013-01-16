package com.facebook.orca.common.ui.titlebar;

import android.view.View;
import java.util.List;

public abstract interface FbTitleBar
{
  public abstract void a(boolean paramBoolean);

  public abstract boolean a();

  public abstract void setButtonSpecs(List<TitleBarButtonSpec> paramList);

  public abstract void setCustomTitleView(View paramView);

  public abstract void setHasBackButton(boolean paramBoolean);

  public abstract void setHasProgressBar(boolean paramBoolean);

  public abstract void setOnToolbarButtonListener(FbTitleBar.OnToolbarButtonListener paramOnToolbarButtonListener);

  public abstract void setTitle(int paramInt);

  public abstract void setTitle(String paramString);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.FbTitleBar
 * JD-Core Version:    0.6.2
 */