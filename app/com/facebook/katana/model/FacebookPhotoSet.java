package com.facebook.katana.model;

import android.content.Context;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.ClearType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FacebookPhotoSet
{
  private static ManagedDataStore<String, FacebookPhotoSet> c;
  private final List<Long> a;
  private final String b;

  public FacebookPhotoSet(String paramString, List<Long> paramList)
  {
    this.b = paramString;
    this.a = paramList;
  }

  public static FacebookPhotoSet a(Context paramContext, String paramString)
  {
    return (FacebookPhotoSet)b(paramContext).a(paramString);
  }

  public static FacebookPhotoSet a(List<Long> paramList)
  {
    return new FacebookPhotoSet("gqlNoToken.", paramList);
  }

  public static Long a(String paramString)
  {
    boolean bool1 = paramString.startsWith("a.");
    Long localLong = null;
    if (bool1)
    {
      boolean bool2 = paramString.substring(2).contains(".");
      localLong = null;
      if (!bool2)
        localLong = b(paramString.substring(2));
    }
    return localLong;
  }

  public static String a(long paramLong)
  {
    return "t." + paramLong;
  }

  public static void a(Context paramContext)
  {
    b(paramContext).a(ManagedDataStore.ClearType.CLEAR_MEMORY);
  }

  private static ManagedDataStore<String, FacebookPhotoSet> b(Context paramContext)
  {
    monitorenter;
    try
    {
      if (c == null)
        c = new ManagedDataStore(new PhotoSetDataStoreClient(), paramContext);
      ManagedDataStore localManagedDataStore = c;
      monitorexit;
      return localManagedDataStore;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static Long b(String paramString)
  {
    try
    {
      Long localLong2 = Long.valueOf(Long.parseLong(paramString));
      localLong1 = localLong2;
      return localLong1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        ErrorReporting.a("NumberFormatException", "Converting from AlbumID " + paramString + " to long failed.", localNumberFormatException, true);
        Long localLong1 = null;
      }
    }
  }

  public static String b(long paramLong)
  {
    return "a." + paramLong;
  }

  public static void b(Context paramContext, String paramString)
  {
    b(paramContext).b(paramString);
  }

  public static FacebookPhotoSet c(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    return new FacebookPhotoSet("dummy." + paramLong, localArrayList);
  }

  public List<Long> a()
  {
    return Collections.unmodifiableList(this.a);
  }

  public boolean b()
  {
    return this.b.startsWith("a.");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPhotoSet
 * JD-Core Version:    0.6.0
 */