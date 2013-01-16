package com.facebook.content;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionInfo;
import android.os.Binder;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PermissionChecks
{
  public static final void a()
  {
    throw new SecurityException("Component access not allowed.");
  }

  public static boolean a(Context paramContext)
  {
    int i = Binder.getCallingUid();
    int j = paramContext.getApplicationInfo().uid;
    if ((i == j) || (paramContext.getPackageManager().checkSignatures(j, i) == 0));
    for (int k = 1; ; k = 0)
      return k;
  }

  public static Set<String> b(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str = paramContext.getPackageName();
    try
    {
      PermissionInfo[] arrayOfPermissionInfo = localPackageManager.getPackageInfo(str, 4096).permissions;
      ImmutableSet.Builder localBuilder = new ImmutableSet.Builder();
      int i = arrayOfPermissionInfo.length;
      for (int j = 0; j < i; j++)
        localBuilder.b(arrayOfPermissionInfo[j].name);
      ImmutableSet localImmutableSet2 = localBuilder.b();
      localImmutableSet1 = localImmutableSet2;
      return localImmutableSet1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        ((FbErrorReporter)FbInjector.a(paramContext).a(FbErrorReporter.class)).a("PermissionChecks", "Package name not found: " + str);
        ImmutableSet localImmutableSet1 = null;
      }
    }
  }

  public static List<PackageInfo> c(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    int i = paramContext.getApplicationInfo().uid;
    ArrayList localArrayList = new ArrayList();
    Set localSet = b(paramContext);
    if ((localSet != null) && (!localSet.isEmpty()))
    {
      Iterator localIterator = localPackageManager.getInstalledPackages(4096).iterator();
      label163: 
      while (localIterator.hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
        int j = localPackageInfo.applicationInfo.uid;
        if ((i == j) || (localPackageManager.checkSignatures(i, j) == 0))
          continue;
        PermissionInfo[] arrayOfPermissionInfo = localPackageInfo.permissions;
        if (arrayOfPermissionInfo == null)
          continue;
        int k = arrayOfPermissionInfo.length;
        for (int m = 0; ; m++)
        {
          if (m >= k)
            break label163;
          if (!localSet.contains(arrayOfPermissionInfo[m].name))
            continue;
          localArrayList.add(localPackageInfo);
          break;
        }
      }
    }
    return localArrayList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.content.PermissionChecks
 * JD-Core Version:    0.6.0
 */