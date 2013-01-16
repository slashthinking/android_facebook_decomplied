package com.facebook.analytics.util;

import android.content.Context;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;

public final class LoggerUtils
{
  public static AnalyticsLogger a(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    return (AnalyticsLogger)FbInjector.a(paramContext).a(AnalyticsLogger.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.util.LoggerUtils
 * JD-Core Version:    0.6.2
 */