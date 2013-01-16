package com.facebook.katana.service.vault.methods;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.facebook.katana.service.method.ApiMethod;
import com.facebook.katana.service.method.ApiMethodCallback;
import com.facebook.katana.service.method.ServiceOperationListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VaultBlacklistedSyncPathsGet extends ApiMethod
  implements ApiMethodCallback
{
  private static final String a = VaultBlacklistedSyncPathsGet.class.getSimpleName();
  private static boolean b = false;
  private static List<VaultBlacklistedSyncPathsGet.Callback> f = new ArrayList();
  private static VaultBlacklistedSyncPathsGet.VaultBlacklistedSyncPathsStoreClient g;
  private static ManagedDataStore<String, List<String>> h;

  public VaultBlacklistedSyncPathsGet(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "vault.androidBlacklistedSyncPaths", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("call_id", String.valueOf(System.currentTimeMillis()));
    if (paramString != null)
      this.e.put("session_key", paramString);
  }

  public static String a(Context paramContext)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession != null)
    {
      boolean bool = h();
      str = null;
      if (!bool)
        break label24;
    }
    while (true)
    {
      return str;
      label24: b(true);
      str = localAppSession.a(paramContext, new VaultBlacklistedSyncPathsGet(paramContext, null, localAppSession.b().sessionKey, null), 1001, 1020, null);
    }
  }

  public static List<String> a(Context paramContext, VaultBlacklistedSyncPathsGet.Callback paramCallback)
  {
    List localList = (List)c(paramContext).a("blacklisted_sync_paths");
    if ((localList == null) && (paramCallback != null))
      a(paramCallback);
    return localList;
  }

  public static void a(VaultBlacklistedSyncPathsGet.Callback paramCallback)
  {
    synchronized (f)
    {
      f.add(paramCallback);
      return;
    }
  }

  public static List<String> b(Context paramContext)
  {
    return a(paramContext, null);
  }

  private static void b(boolean paramBoolean)
  {
    b = paramBoolean;
  }

  private static ManagedDataStore<String, List<String>> c(Context paramContext)
  {
    monitorenter;
    try
    {
      if (h == null)
      {
        g = new VaultBlacklistedSyncPathsGet.VaultBlacklistedSyncPathsStoreClient();
        h = new ManagedDataStore(g, paramContext);
      }
      ManagedDataStore localManagedDataStore = h;
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

  private static List<String> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    VaultSyncPathsData localVaultSyncPathsData = (VaultSyncPathsData)JMParser.a(FBJsonFactory.a.createJsonParser(paramString), VaultSyncPathsData.class);
    if (localVaultSyncPathsData != null)
    {
      Iterator localIterator = localVaultSyncPathsData.paths.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((VaultSyncPathObject)localIterator.next()).path);
    }
    return localArrayList;
  }

  private static boolean h()
  {
    return b;
  }

  // ERROR //
  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, java.lang.Exception paramException)
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 87	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet:b	(Z)V
    //   4: iload 5
    //   6: sipush 200
    //   9: if_icmpne +75 -> 84
    //   12: aload_2
    //   13: invokestatic 178	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet:b	(Landroid/content/Context;)Ljava/util/List;
    //   16: astore 11
    //   18: getstatic 37	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet:f	Ljava/util/List;
    //   21: astore 12
    //   23: aload 12
    //   25: monitorenter
    //   26: getstatic 37	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet:f	Ljava/util/List;
    //   29: invokeinterface 161 1 0
    //   34: astore 14
    //   36: aload 14
    //   38: invokeinterface 166 1 0
    //   43: ifeq +29 -> 72
    //   46: aload 14
    //   48: invokeinterface 170 1 0
    //   53: checkcast 180	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet$Callback
    //   56: aload 11
    //   58: invokevirtual 183	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet$Callback:a	(Ljava/util/List;)V
    //   61: goto -25 -> 36
    //   64: astore 13
    //   66: aload 12
    //   68: monitorexit
    //   69: aload 13
    //   71: athrow
    //   72: getstatic 37	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet:f	Ljava/util/List;
    //   75: invokeinterface 186 1 0
    //   80: aload 12
    //   82: monitorexit
    //   83: return
    //   84: getstatic 37	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet:f	Ljava/util/List;
    //   87: astore 8
    //   89: aload 8
    //   91: monitorenter
    //   92: getstatic 37	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet:f	Ljava/util/List;
    //   95: invokeinterface 161 1 0
    //   100: astore 10
    //   102: aload 10
    //   104: invokeinterface 166 1 0
    //   109: ifeq +29 -> 138
    //   112: aload 10
    //   114: invokeinterface 170 1 0
    //   119: checkcast 180	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet$Callback
    //   122: iload 5
    //   124: invokevirtual 189	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet$Callback:a	(I)V
    //   127: goto -25 -> 102
    //   130: astore 9
    //   132: aload 8
    //   134: monitorexit
    //   135: aload 9
    //   137: athrow
    //   138: getstatic 37	com/facebook/katana/service/vault/methods/VaultBlacklistedSyncPathsGet:f	Ljava/util/List;
    //   141: invokeinterface 186 1 0
    //   146: aload 8
    //   148: monitorexit
    //   149: goto -66 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   26	69	64	finally
    //   72	83	64	finally
    //   92	135	130	finally
    //   138	149	130	finally
  }

  protected void a(HttpOperation.ResponseInputStream paramResponseInputStream)
  {
    String str = paramResponseInputStream.b();
    List localList = d(str);
    c(this.o).a(this.o, true, "blacklisted_sync_paths", str, localList);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultBlacklistedSyncPathsGet
 * JD-Core Version:    0.6.0
 */