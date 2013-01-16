package com.facebook.orca.common.ui.widgets.text;

import android.text.style.URLSpan;
import android.view.View;

public class CustomUrlLikeSpan extends URLSpan
{
  private CustomUrlLikeSpan.OnUrlClickHandler a;

  public CustomUrlLikeSpan()
  {
    super("about:blank");
  }

  public void a(CustomUrlLikeSpan.OnUrlClickHandler paramOnUrlClickHandler)
  {
    this.a = paramOnUrlClickHandler;
  }

  public void onClick(View paramView)
  {
    if (this.a != null)
      this.a.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan
 * JD-Core Version:    0.6.2
 */