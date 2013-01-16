package com.facebook.katana;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.Widget;

public class FacebookControlWidgetProvider extends AppWidgetProvider
{
  public void onEnabled(Context paramContext)
  {
    AppSession.a(paramContext, false);
    Widget.a().h(paramContext);
  }

  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    AppSession.a(paramContext, false);
    Widget.a().h(paramContext);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FacebookControlWidgetProvider
 * JD-Core Version:    0.6.0
 */