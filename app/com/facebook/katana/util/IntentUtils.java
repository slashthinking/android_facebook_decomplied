package com.facebook.katana.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.IntentUriHandler;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IntentUtils
{
  public static Intent a(Context paramContext, long paramLong)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    return IntentUriHandler.a(paramContext, StringLocaleUtil.a("fb://profile/%s", arrayOfObject));
  }

  public static List<FacebookProfile> a(Parcelable[] paramArrayOfParcelable)
  {
    if (paramArrayOfParcelable == null);
    ArrayList localArrayList;
    for (Object localObject = null; ; localObject = localArrayList)
    {
      return localObject;
      localArrayList = new ArrayList();
      int i = paramArrayOfParcelable.length;
      for (int j = 0; j < i; j++)
        localArrayList.add((FacebookProfile)paramArrayOfParcelable[j]);
    }
  }

  public static Set<Long> a(long[] paramArrayOfLong)
  {
    HashSet localHashSet;
    if (paramArrayOfLong == null)
      localHashSet = null;
    while (true)
    {
      return localHashSet;
      localHashSet = new HashSet();
      int i = paramArrayOfLong.length;
      for (int j = 0; j < i; j++)
        localHashSet.add(Long.valueOf(paramArrayOfLong[j]));
    }
  }

  public static boolean a(Intent paramIntent1, Intent paramIntent2, String[] paramArrayOfString)
  {
    int i = 1;
    int j;
    int k;
    if ((paramIntent1 == null) || (paramIntent2 == null))
      if ((paramIntent1 == null) && (paramIntent2 == null))
      {
        j = i;
        k = j;
      }
    boolean bool1;
    do
    {
      return k;
      j = 0;
      break;
      bool1 = paramIntent1.filterEquals(paramIntent2);
      k = 0;
    }
    while (!bool1);
    Bundle localBundle1 = paramIntent1.getExtras();
    Object localObject1 = paramIntent2.getExtras();
    if ((localBundle1 == null) || (localObject1 == null))
    {
      if ((localBundle1 == null) && (localObject1 == null));
      while (true)
      {
        k = i;
        break;
        i = 0;
      }
    }
    Bundle localBundle2;
    if (paramArrayOfString.length > 0)
    {
      localBundle2 = new Bundle(localBundle1);
      Bundle localBundle3 = new Bundle((Bundle)localObject1);
      int m = paramArrayOfString.length;
      for (int n = 0; n < m; n++)
      {
        String str2 = paramArrayOfString[n];
        localBundle2.remove(str2);
        localBundle3.remove(str2);
      }
      localObject1 = localBundle3;
    }
    while (true)
    {
      boolean bool2 = localBundle2.keySet().equals(((Bundle)localObject1).keySet());
      k = 0;
      if (!bool2)
        break;
      Iterator localIterator = localBundle2.keySet().iterator();
      Object localObject2;
      Object localObject3;
      do
        while (true)
        {
          if (!localIterator.hasNext())
            break label270;
          String str1 = (String)localIterator.next();
          localObject2 = localBundle2.get(str1);
          localObject3 = ((Bundle)localObject1).get(str1);
          if (localObject2 == null)
          {
            if (localObject3 == null)
              continue;
            k = 0;
            break;
          }
        }
      while (localObject2.equals(localObject3));
      k = 0;
      break;
      label270: k = i;
      break;
      localBundle2 = localBundle1;
    }
  }

  public static long[] a(Set<Long> paramSet)
  {
    if (paramSet == null);
    long[] arrayOfLong;
    for (Object localObject = null; ; localObject = arrayOfLong)
    {
      return localObject;
      ArrayList localArrayList = new ArrayList(paramSet);
      arrayOfLong = new long[localArrayList.size()];
      for (int i = 0; i < arrayOfLong.length; i++)
        arrayOfLong[i] = ((Long)localArrayList.get(i)).longValue();
    }
  }

  public static Parcelable[] a(List<FacebookProfile> paramList)
  {
    if (paramList == null);
    FacebookProfile[] arrayOfFacebookProfile;
    for (Object localObject = null; ; localObject = arrayOfFacebookProfile)
    {
      return localObject;
      arrayOfFacebookProfile = new FacebookProfile[paramList.size()];
      for (int i = 0; i < arrayOfFacebookProfile.length; i++)
        arrayOfFacebookProfile[i] = ((Parcelable)paramList.get(i));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.IntentUtils
 * JD-Core Version:    0.6.0
 */