package com.facebook.katana.features;

import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.Mode;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.method.FqlGetGatekeeperSettings;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Gatekeeper
{
  public static final Class<?> a = Gatekeeper.class;
  public static final Map<String, Gatekeeper.Settings> b = Collections.unmodifiableMap(new Gatekeeper.1());
  private static ManagedDataStore<String, Boolean> c;

  public static FqlGetGatekeeperSettings a(Context paramContext, AppSession paramAppSession)
  {
    return new FqlGetGatekeeperSettings(paramContext, null, paramAppSession.b().sessionKey, null, b.keySet(), b(paramContext));
  }

  public static Boolean a(Context paramContext, String paramString)
  {
    return (Boolean)b(paramContext).a(paramString);
  }

  public static void a()
  {
    c = null;
  }

  public static void a(Context paramContext, Map<String, Boolean> paramMap)
  {
    ManagedDataStore localManagedDataStore = b(paramContext);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localManagedDataStore.a(paramContext, true, localEntry.getKey(), ((Boolean)localEntry.getValue()).toString(), localEntry.getValue());
    }
  }

  private static ManagedDataStore<String, Boolean> b(Context paramContext)
  {
    if (c == null)
      c = new ManagedDataStore(Gatekeeper.GkManagedStoreClient.INSTANCE, ManagedDataStore.Mode.SINGLE_REQUEST_BY_KEY, paramContext);
    return c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.Gatekeeper
 * JD-Core Version:    0.6.0
 */