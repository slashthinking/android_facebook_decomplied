package com.facebook.orca.module;

import com.facebook.common.util.DiskUsageUtil;
import com.facebook.common.util.StatFsHelper;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class UiModule$DiskUsageUtilProvider extends AbstractProvider<DiskUsageUtil>
{
  private UiModule$DiskUsageUtilProvider(UiModule paramUiModule)
  {
  }

  public DiskUsageUtil a()
  {
    return new DiskUsageUtil(UiModule.a(this.a), (AndroidThreadUtil)b(AndroidThreadUtil.class), (StatFsHelper)b(StatFsHelper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.module.UiModule.DiskUsageUtilProvider
 * JD-Core Version:    0.6.2
 */