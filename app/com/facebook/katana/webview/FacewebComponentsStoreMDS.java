package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.common.util.Tuple;
import com.facebook.debug.Assert;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.Mode;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FacewebComponentsStoreMDS extends ManagedDataStore<FacewebComponentsStoreCache.Key, FacewebComponentsStoreCache.Value>
{
  protected Map<FacewebComponentsStoreCache.Key, List<FacewebComponentsStoreCache.Listener>> m = new HashMap();

  public FacewebComponentsStoreMDS(Context paramContext)
  {
    super(new FacewebComponentsStoreCacheClient(), ManagedDataStore.Mode.SINGLE_REQUEST_BY_KEY, paramContext);
  }

  public FacewebComponentsStoreCache.Value a(FacewebComponentsStoreCache.Key paramKey)
  {
    throw new UnsupportedOperationException("Don't call me directly");
  }

  // ERROR //
  public FacewebComponentsStoreCache.Value a(FacewebComponentsStoreCache.Key paramKey, FacewebComponentsStoreCache.Listener paramListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/facebook/katana/webview/FacewebComponentsStoreMDS:m	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 45 2 0
    //   12: checkcast 47	java/util/List
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +20 -> 39
    //   22: aload 4
    //   24: aload_2
    //   25: invokeinterface 51 2 0
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: aconst_null
    //   34: astore 8
    //   36: goto +104 -> 140
    //   39: new 53	java/util/ArrayList
    //   42: dup
    //   43: invokespecial 54	java/util/ArrayList:<init>	()V
    //   46: astore 5
    //   48: aload 5
    //   50: aload_2
    //   51: invokeinterface 51 2 0
    //   56: pop
    //   57: aload_0
    //   58: getfield 29	com/facebook/katana/webview/FacewebComponentsStoreMDS:m	Ljava/util/Map;
    //   61: aload_1
    //   62: aload 5
    //   64: invokeinterface 58 3 0
    //   69: pop
    //   70: aload_0
    //   71: aload_1
    //   72: invokespecial 60	com/facebook/katana/binding/ManagedDataStore:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 62	com/facebook/katana/webview/FacewebComponentsStoreCache$Value
    //   78: astore 8
    //   80: aload 8
    //   82: ifnull +53 -> 135
    //   85: aload_0
    //   86: getfield 29	com/facebook/katana/webview/FacewebComponentsStoreMDS:m	Ljava/util/Map;
    //   89: aload_1
    //   90: invokeinterface 65 2 0
    //   95: pop
    //   96: aload 8
    //   98: invokevirtual 69	com/facebook/katana/webview/FacewebComponentsStoreCache$Value:c	()Z
    //   101: ifeq +24 -> 125
    //   104: aload 8
    //   106: invokevirtual 72	com/facebook/katana/webview/FacewebComponentsStoreCache$Value:a	()Lcom/facebook/common/util/Tuple;
    //   109: getfield 77	com/facebook/common/util/Tuple:a	Ljava/lang/Object;
    //   112: getstatic 83	com/facebook/katana/webview/FacewebComponentsStoreCache$LoadError:DESERIALIZATION_ERROR	Lcom/facebook/katana/webview/FacewebComponentsStoreCache$LoadError;
    //   115: if_acmpne +10 -> 125
    //   118: aload_0
    //   119: getstatic 89	com/facebook/katana/binding/ManagedDataStore$ClearType:CLEAR_DISK	Lcom/facebook/katana/binding/ManagedDataStore$ClearType;
    //   122: invokespecial 92	com/facebook/katana/binding/ManagedDataStore:a	(Lcom/facebook/katana/binding/ManagedDataStore$ClearType;)V
    //   125: aload_0
    //   126: monitorexit
    //   127: goto +13 -> 140
    //   130: astore_3
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_3
    //   134: athrow
    //   135: aload_0
    //   136: monitorexit
    //   137: aconst_null
    //   138: astore 8
    //   140: aload 8
    //   142: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   2	133	130	finally
    //   135	137	130	finally
  }

  public void a(Context paramContext, boolean paramBoolean, FacewebComponentsStoreCache.Key paramKey, String paramString, FacewebComponentsStoreCache.Value paramValue)
  {
    FacewebComponentsStoreCache.Key localKey = null;
    if (paramBoolean)
    {
      Assert.a(paramValue);
      Assert.a(paramValue.b());
      localKey = new FacewebComponentsStoreCache.Key(paramKey.a(), paramValue.b().a());
      MFacewebVersion.a(paramContext, localKey.b());
    }
    super.a(paramContext, paramBoolean, localKey, paramString, paramValue);
    monitorenter;
    List localList;
    Iterator localIterator;
    try
    {
      localList = (List)this.m.remove(paramKey);
      monitorexit;
      if (localList != null);
    }
    finally
    {
      monitorexit;
    }
    while (localIterator.hasNext())
    {
      FacewebComponentsStoreCache.Listener localListener = (FacewebComponentsStoreCache.Listener)localIterator.next();
      if (paramBoolean)
      {
        localListener.a(paramValue.b());
        continue;
      }
      Tuple localTuple = paramValue.a();
      localListener.a((FacewebComponentsStoreCache.LoadError)localTuple.a, (String)localTuple.b);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebComponentsStoreMDS
 * JD-Core Version:    0.6.0
 */