package com.facebook.orca.inject;

import com.google.common.collect.Lists;
import com.google.inject.Key;
import java.util.ArrayList;
import java.util.List;

class ProvisioningDebugStack
{
  private static ThreadLocal<List<Object>> a = new ProvisioningDebugStack.1();

  public static void a()
  {
    List localList = (List)a.get();
    localList.remove(-1 + localList.size());
    localList.remove(-1 + localList.size());
  }

  public static void a(ProvisioningDebugStack.StackType paramStackType, Key<?> paramKey)
  {
    List localList = (List)a.get();
    localList.add(paramStackType);
    localList.add(paramKey);
  }

  public static List<ProvisioningDebugStack.StackEntry> b()
  {
    List localList = (List)a.get();
    ArrayList localArrayList = Lists.a();
    for (int i = 0; i < localList.size(); i += 2)
      localArrayList.add(new ProvisioningDebugStack.StackEntry((ProvisioningDebugStack.StackType)localList.get(i), (Key)localList.get(i + 1)));
    return localArrayList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ProvisioningDebugStack
 * JD-Core Version:    0.6.0
 */