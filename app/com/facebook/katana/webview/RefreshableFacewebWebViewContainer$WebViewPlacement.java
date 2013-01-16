package com.facebook.katana.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.util.MemoryInfo;

class RefreshableFacewebWebViewContainer$WebViewPlacement extends View
{
  private boolean b;
  private Bitmap c;

  public RefreshableFacewebWebViewContainer$WebViewPlacement(RefreshableFacewebWebViewContainer paramRefreshableFacewebWebViewContainer, Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    int i = RefreshableFacewebWebViewContainer.c(this.a).getWidth();
    int j = RefreshableFacewebWebViewContainer.c(this.a).getHeight();
    c();
    if (!RefreshableFacewebWebViewContainer.c(this.a).isShown())
      ErrorReporting.a(" WebViewPlacement", "Error: snapshotting a webview which is not visible! This will result in a blank screen. Please fix!", false);
    while (true)
    {
      return;
      if ((i != 0) && (j != 0))
      {
        MemoryInfo localMemoryInfo = new MemoryInfo();
        if (localMemoryInfo.a >= localMemoryInfo.c)
        {
          ErrorReporting.a("WebViewPlacement", "Out of Memory", true);
          continue;
        }
        this.c = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
        this.a.draw(new Canvas(this.c));
        this.b = true;
        continue;
      }
    }
  }

  public boolean b()
  {
    return this.b;
  }

  public void c()
  {
    if (this.c != null)
    {
      this.c.recycle();
      this.c = null;
    }
    this.b = false;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.c != null) && (isShown()))
    {
      RefreshableFacewebWebViewContainer.c(this.a).setVisibility(8);
      paramCanvas.drawBitmap(this.c, 0.0F, 0.0F, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.RefreshableFacewebWebViewContainer.WebViewPlacement
 * JD-Core Version:    0.6.0
 */