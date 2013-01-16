package com.karmascience.gifts.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.facebook.common.util.Log;
import com.karmascience.gifts.views.KSViewController;

public abstract class ViewHandler extends Handler
{
  private static final String a = ViewHandler.class.getName();
  final IViewManager b;

  public ViewHandler(IViewManager paramIViewManager)
  {
    this.b = paramIViewManager;
  }

  public void handleMessage(Message paramMessage)
  {
    if (this.b.b());
    while (true)
    {
      return;
      boolean bool = paramMessage.obj instanceof Bundle;
      Bundle localBundle = null;
      if (bool)
        localBundle = (Bundle)paramMessage.obj;
      switch (paramMessage.what)
      {
      case 3:
      case 4:
      case 5:
      default:
        super.handleMessage(paramMessage);
        Log.a(a, "unknown command was submitted: " + paramMessage.what, new RuntimeException());
        break;
      case 1:
        int j = localBundle.getInt("view_type");
        this.b.a(j, localBundle);
        break;
      case 2:
        String str2 = localBundle.getString("breadcrumb");
        this.b.a(str2, localBundle);
        break;
      case 6:
        this.b.a(localBundle);
        break;
      case 7:
        int i = localBundle.getInt("view_type");
        if (localBundle.getBoolean("start_search_from_end", false));
        for (String str1 = this.b.b(i); ; str1 = this.b.a(i))
        {
          if (str1 != null)
            break label252;
          this.b.a(localBundle);
          break;
        }
        this.b.a(str1, localBundle);
        break;
      case 8:
        label252: KSViewController localKSViewController = this.b.a();
        if (localKSViewController == null)
          continue;
        localKSViewController.a(localBundle);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.ui.ViewHandler
 * JD-Core Version:    0.6.0
 */