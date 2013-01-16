package com.facebook.katana.service.vault;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;

public class VaultNotificationManager
{
  private Map<String, VaultImageProviderRow> a = Maps.b();
  private int b = 0;
  private Context c;

  public VaultNotificationManager(Context paramContext)
  {
    this.c = paramContext;
    this.b = 0;
    this.a = Maps.b();
    b("end_vault_upload");
  }

  private Intent a(Intent paramIntent, String paramString, int paramInt)
  {
    paramIntent.putExtra("vault.row_upload_key", paramString);
    paramIntent.putExtra("vault.upload_percentage", paramInt);
    return paramIntent;
  }

  private void a(Intent paramIntent)
  {
    paramIntent.setAction("vault.intent.action.SyncStatus");
    LocalBroadcastManager.a(this.c).a(paramIntent);
  }

  private void b(String paramString)
  {
    UserValuesManager.a(this.c, "vault:upload_state", paramString);
  }

  private boolean c(VaultImageProviderRow paramVaultImageProviderRow)
  {
    if ((paramVaultImageProviderRow.b > 0L) && ((paramVaultImageProviderRow.f == 0) || (paramVaultImageProviderRow.f == 6)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean e()
  {
    if (this.b == this.a.size());
    for (int i = 1; ; i = 0)
      return i;
  }

  private void f()
  {
    monitorenter;
    try
    {
      b("end_vault_upload");
      Intent localIntent = new Intent();
      localIntent.putExtra("vault.sync_end", true);
      a(localIntent);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private void g()
  {
    Log.e("vault", "clearing vault upload map");
    monitorenter;
    try
    {
      if (!h())
      {
        this.a.clear();
        this.b = 0;
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private boolean h()
  {
    if (!d().equals("end_vault_upload"));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void a()
  {
    a(new Intent().putExtra("vault.table_refreshed_key", true));
  }

  public void a(VaultImageProviderRow paramVaultImageProviderRow)
  {
    if (c(paramVaultImageProviderRow));
    while (true)
    {
      return;
      monitorenter;
      try
      {
        this.a.put(paramVaultImageProviderRow.a, paramVaultImageProviderRow);
        monitorexit;
        b("vault_upload_start");
        a(a(new Intent(), paramVaultImageProviderRow.a, 0));
        continue;
      }
      finally
      {
        monitorexit;
      }
    }
    throw localObject;
  }

  public void a(VaultImageProviderRow paramVaultImageProviderRow, int paramInt)
  {
    if (c(paramVaultImageProviderRow));
    while (true)
    {
      return;
      a(a(new Intent(), paramVaultImageProviderRow.a, paramInt));
    }
  }

  public void a(String paramString)
  {
    monitorenter;
    try
    {
      this.a.remove(paramString);
      if (e())
        b();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  public void a(java.util.List<VaultImageProviderRow> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 106	com/facebook/katana/service/vault/VaultNotificationManager:h	()Z
    //   4: ifne +9 -> 13
    //   7: aload_0
    //   8: ldc 147
    //   10: invokespecial 32	com/facebook/katana/service/vault/VaultNotificationManager:b	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_1
    //   16: invokeinterface 153 1 0
    //   21: astore_3
    //   22: aload_3
    //   23: invokeinterface 158 1 0
    //   28: ifeq +48 -> 76
    //   31: aload_3
    //   32: invokeinterface 162 1 0
    //   37: checkcast 71	com/facebook/katana/provider/VaultImageProviderRow
    //   40: astore 6
    //   42: aload_0
    //   43: aload 6
    //   45: invokespecial 124	com/facebook/katana/service/vault/VaultNotificationManager:c	(Lcom/facebook/katana/provider/VaultImageProviderRow;)Z
    //   48: ifne -26 -> 22
    //   51: aload_0
    //   52: getfield 23	com/facebook/katana/service/vault/VaultNotificationManager:a	Ljava/util/Map;
    //   55: aload 6
    //   57: getfield 127	com/facebook/katana/provider/VaultImageProviderRow:a	Ljava/lang/String;
    //   60: aload 6
    //   62: invokeinterface 131 3 0
    //   67: pop
    //   68: goto -46 -> 22
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: aload_0
    //   77: monitorexit
    //   78: new 37	android/content/Intent
    //   81: dup
    //   82: invokespecial 86	android/content/Intent:<init>	()V
    //   85: astore 4
    //   87: aload 4
    //   89: ldc 164
    //   91: iconst_1
    //   92: invokevirtual 91	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   95: pop
    //   96: aload_0
    //   97: aload 4
    //   99: invokespecial 93	com/facebook/katana/service/vault/VaultNotificationManager:a	(Landroid/content/Intent;)V
    //   102: return
    //
    // Exception table:
    //   from	to	target	type
    //   15	74	71	finally
    //   76	78	71	finally
  }

  public void a(Set<String> paramSet)
  {
    if (paramSet.size() > 0)
      a(new Intent().putExtra("vault.table_refreshed_key", true));
  }

  public void b()
  {
    f();
    g();
  }

  public void b(VaultImageProviderRow paramVaultImageProviderRow)
  {
    monitorenter;
    try
    {
      if (this.a.containsKey(paramVaultImageProviderRow.a))
      {
        this.a.put(paramVaultImageProviderRow.a, paramVaultImageProviderRow);
        this.b = (1 + this.b);
      }
      Intent localIntent = a(new Intent(), paramVaultImageProviderRow.a, 100);
      localIntent.putExtra("vault.upload_completed", true);
      a(localIntent);
      if (e())
        b();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void c()
  {
    monitorenter;
    try
    {
      if (e())
        f();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public String d()
  {
    return UserValuesManager.a(this.c, "vault:upload_state", "end_vault_upload");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultNotificationManager
 * JD-Core Version:    0.6.0
 */