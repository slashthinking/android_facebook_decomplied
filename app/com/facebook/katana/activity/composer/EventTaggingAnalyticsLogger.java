package com.facebook.katana.activity.composer;

import android.net.Uri;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.ipc.katana.model.FacebookEvent;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import java.util.List;

class EventTaggingAnalyticsLogger
{
  private final InteractionLogger a;

  EventTaggingAnalyticsLogger(InteractionLogger paramInteractionLogger)
  {
    this.a = paramInteractionLogger;
  }

  void a(FacebookPlace paramFacebookPlace, boolean paramBoolean, List<MediaItem> paramList, Uri paramUri)
  {
    int i = 1;
    if (paramFacebookPlace == null);
    FacebookEvent localFacebookEvent;
    do
    {
      return;
      localFacebookEvent = paramFacebookPlace.c();
    }
    while (localFacebookEvent == null);
    String str1;
    label28: String str2;
    if (paramBoolean)
    {
      str1 = FB4A_AnalyticEntities.c;
      if ((paramList == null) || (paramList.isEmpty()))
        break label127;
      str2 = "photo";
      i = paramList.size();
    }
    while (true)
    {
      HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(str1);
      localHoneyClientEvent.b("target_type", str2);
      localHoneyClientEvent.a("target_count", i);
      localHoneyClientEvent.g(String.valueOf(localFacebookEvent.a()));
      localHoneyClientEvent.d(FB4A_AnalyticEntities.Modules.b);
      this.a.b(localHoneyClientEvent);
      break;
      str1 = FB4A_AnalyticEntities.d;
      break label28;
      label127: if (paramUri != null)
      {
        str2 = "video";
        continue;
      }
      str2 = "no_attachment";
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.EventTaggingAnalyticsLogger
 * JD-Core Version:    0.6.0
 */