package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.Mode;
import java.util.Collections;
import java.util.Set;

public class PostLoginSyncRequest
{
  private static final Set<String> a = Collections.unmodifiableSet(new PostLoginSyncRequest.1());
  private static ManagedDataStore<PostLoginSyncRequest.None, PostLoginSyncRequest.None> b;

  public static void a(Context paramContext)
  {
    b(paramContext).a(PostLoginSyncRequest.None.INSTANCE);
    b(paramContext).a(paramContext, true, PostLoginSyncRequest.None.INSTANCE, PostLoginSyncRequest.None.INSTANCE.name(), PostLoginSyncRequest.None.INSTANCE);
  }

  private static ManagedDataStore<PostLoginSyncRequest.None, PostLoginSyncRequest.None> b(Context paramContext)
  {
    if (b == null)
      b = new ManagedDataStore(PostLoginSyncRequest.DataStoreClient.INSTANCE, ManagedDataStore.Mode.SINGLE_REQUEST_BY_KEY, paramContext);
    return b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PostLoginSyncRequest
 * JD-Core Version:    0.6.0
 */