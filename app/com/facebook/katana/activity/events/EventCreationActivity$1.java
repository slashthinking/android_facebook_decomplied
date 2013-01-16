package com.facebook.katana.activity.events;

import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;

class EventCreationActivity$1 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, long paramLong)
  {
    if ((paramString1 == null) || (!paramString1.equals(EventCreationActivity.a(this.a))));
    while (true)
    {
      return;
      if (paramInt == 200)
      {
        if ((EventCreationActivity.b(this.a) != null) && (EventCreationActivity.b(this.a).length > 0))
        {
          EventCreationActivity.a(this.a, paramLong);
          continue;
        }
        EventCreationActivity.c(this.a);
        EventCreationActivity.b(this.a, paramLong);
        continue;
      }
      EventCreationActivity.c(this.a);
      Toaster.a(this.a, 2131362919);
    }
  }

  public void b(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, long paramLong)
  {
    if ((paramString1 == null) || (!paramString1.equals(EventCreationActivity.d(this.a))));
    while (true)
    {
      return;
      EventCreationActivity.c(this.a);
      if (paramInt == 200)
      {
        EventCreationActivity.b(this.a, paramLong);
        continue;
      }
      Toaster.a(this.a, 2131362919);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.events.EventCreationActivity.1
 * JD-Core Version:    0.6.0
 */