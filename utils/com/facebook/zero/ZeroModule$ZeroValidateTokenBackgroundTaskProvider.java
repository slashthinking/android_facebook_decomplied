package com.facebook.zero;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.zero.annotations.IsZeroRatingFeatureEnabled;

class ZeroModule$ZeroValidateTokenBackgroundTaskProvider extends AbstractProvider<ZeroValidateTokenBackgroundTask>
{
  private ZeroModule$ZeroValidateTokenBackgroundTaskProvider(ZeroModule paramZeroModule)
  {
  }

  public ZeroValidateTokenBackgroundTask a()
  {
    return new ZeroValidateTokenBackgroundTask((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), (Clock)b(Clock.class), (ZeroTokenManager)b(ZeroTokenManager.class), a(Boolean.class, IsZeroRatingFeatureEnabled.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.ZeroModule.ZeroValidateTokenBackgroundTaskProvider
 * JD-Core Version:    0.6.2
 */