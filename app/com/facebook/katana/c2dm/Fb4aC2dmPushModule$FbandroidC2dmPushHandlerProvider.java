package com.facebook.katana.c2dm;

import android.content.Context;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.push.c2dm.PushTokenHolder;
import com.facebook.orca.push.common.PushDeserialization;
import com.fasterxml.jackson.databind.ObjectMapper;

class Fb4aC2dmPushModule$FbandroidC2dmPushHandlerProvider extends AbstractProvider<FbandroidC2dmPushHandler>
{
  private Fb4aC2dmPushModule$FbandroidC2dmPushHandlerProvider(Fb4aC2dmPushModule paramFb4aC2dmPushModule)
  {
  }

  public FbandroidC2dmPushHandler a()
  {
    Context localContext = (Context)b(Context.class, FromApplication.class);
    return new FbandroidC2dmPushHandler(localContext, PreferenceManager.getDefaultSharedPreferences(localContext), (ObjectMapper)b(ObjectMapper.class), (PushDeserialization)b(PushDeserialization.class), (OrcaNotificationManager)b(OrcaNotificationManager.class), (ReliabilityAnalyticsLogger)b(ReliabilityAnalyticsLogger.class), (PushTokenHolder)b(PushTokenHolder.class), (Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.c2dm.Fb4aC2dmPushModule.FbandroidC2dmPushHandlerProvider
 * JD-Core Version:    0.6.0
 */