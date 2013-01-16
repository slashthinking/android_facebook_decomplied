package com.facebook.orca.rollout;

import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OrcaRolloutManager
{
  public static Set<Class<? extends Enum<?>>> a;
  private static final Class<?> b = OrcaRolloutManager.class;
  private static int e = -1;
  private final OrcaSharedPreferences c;
  private final OrcaAppType d;

  static
  {
    a = new OrcaRolloutManager.1();
  }

  public OrcaRolloutManager(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaAppType paramOrcaAppType)
  {
    this.c = paramOrcaSharedPreferences;
    this.d = paramOrcaAppType;
  }

  public List<String> a()
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
      localBuilder.b(((Class)localIterator.next()).getSimpleName());
    return localBuilder.b();
  }

  public int b()
  {
    return e;
  }

  public boolean c()
  {
    if (a.size() > 0);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.rollout.OrcaRolloutManager
 * JD-Core Version:    0.6.0
 */