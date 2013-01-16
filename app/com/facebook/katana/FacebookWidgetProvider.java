package com.facebook.katana;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.Widget;

public class FacebookWidgetProvider extends AppWidgetProvider
{
  public void onEnabled(Context paramContext)
  {
    AppSession localAppSession = AppSession.a(paramContext, false);
    Widget.a().a(paramContext, paramContext.getString(2131363278), "");
    if (localAppSession != null)
      localAppSession.a(paramContext, 0, 0);
  }

  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    if (AppSession.a(paramContext, false) != null)
      Widget.a().g(paramContext);
    while (true)
    {
      super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
      return;
      Widget.a().a(paramContext, paramContext.getString(2131363277), paramContext.getString(2131363276));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FacebookWidgetProvider
 * JD-Core Version:    0.6.0
 */