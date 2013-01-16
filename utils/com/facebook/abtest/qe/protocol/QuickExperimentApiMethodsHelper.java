package com.facebook.abtest.qe.protocol;

import com.facebook.orca.common.util.StringLocaleUtil;

public class QuickExperimentApiMethodsHelper
{
  public static String a(SyncQuickExperimentParams paramSyncQuickExperimentParams)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramSyncQuickExperimentParams.a();
    arrayOfObject[1] = paramSyncQuickExperimentParams.b();
    return StringLocaleUtil.a("/testexpt:qe:%s/members/%s", arrayOfObject);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.protocol.QuickExperimentApiMethodsHelper
 * JD-Core Version:    0.6.2
 */