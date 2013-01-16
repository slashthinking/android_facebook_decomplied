package com.facebook.katana.abtest;

import com.facebook.abtest.qe.registry.QuickExperimentNameHolder;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class FbandroidQuickExperimentNameHolder
  implements QuickExperimentNameHolder
{
  private static final ImmutableSet<String> a = ImmutableSet.b("mustang_refresh_interval");

  public Set<String> a()
  {
    return a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.abtest.FbandroidQuickExperimentNameHolder
 * JD-Core Version:    0.6.0
 */