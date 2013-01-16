package com.facebook.orca.module;

import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.TimeFormatUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.inject.AbstractProvider;

class UiModule$TimeFormatUtilProvider extends AbstractProvider<TimeFormatUtil>
{
  private UiModule$TimeFormatUtilProvider(UiModule paramUiModule)
  {
  }

  public TimeFormatUtil a()
  {
    return new DefaultTimeFormatUtil(UiModule.a(this.a), (Clock)b(SystemClock.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.module.UiModule.TimeFormatUtilProvider
 * JD-Core Version:    0.6.2
 */