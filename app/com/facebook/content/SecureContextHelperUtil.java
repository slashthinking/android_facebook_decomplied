package com.facebook.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecureContextHelperUtil
{
  public List<ActivityInfo> a(Intent paramIntent, Context paramContext)
  {
    int i = paramContext.getApplicationInfo().uid;
    PackageManager localPackageManager = paramContext.getPackageManager();
    List localList = localPackageManager.queryIntentActivities(paramIntent, 64);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ActivityInfo localActivityInfo = ((ResolveInfo)localIterator.next()).activityInfo;
      int j = localActivityInfo.applicationInfo.uid;
      if ((i != j) && (localPackageManager.checkSignatures(i, j) != 0))
        continue;
      localArrayList.add(localActivityInfo);
    }
    return localArrayList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.content.SecureContextHelperUtil
 * JD-Core Version:    0.6.0
 */