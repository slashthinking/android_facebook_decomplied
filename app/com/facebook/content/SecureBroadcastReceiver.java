package com.facebook.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class SecureBroadcastReceiver extends BroadcastReceiver
  implements BroadcastReceiverLike
{
  private static final Class<?> a = SecureBroadcastReceiver.class;
  private final ImmutableMap<String, SecureBroadcastReceiver.ActionReceiver> b;

  public SecureBroadcastReceiver(String paramString, SecureBroadcastReceiver.ActionReceiver paramActionReceiver)
  {
    this.b = ImmutableMap.a(Preconditions.checkNotNull(paramString), Preconditions.checkNotNull(paramActionReceiver));
  }

  public SecureBroadcastReceiver(Map<String, SecureBroadcastReceiver.ActionReceiver> paramMap)
  {
    Preconditions.checkNotNull(paramMap);
    boolean bool2;
    if (!paramMap.isEmpty())
    {
      bool2 = bool1;
      Preconditions.checkState(bool2);
      if (paramMap.containsValue(null))
        break label57;
    }
    while (true)
    {
      Preconditions.checkState(bool1);
      this.b = ImmutableMap.a(paramMap);
      return;
      bool2 = false;
      break;
      label57: bool1 = false;
    }
  }

  protected FbInjector a(Context paramContext)
  {
    return FbInjector.a(paramContext);
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    SecureBroadcastReceiver.ActionReceiver localActionReceiver = null;
    if (str != null)
      localActionReceiver = (SecureBroadcastReceiver.ActionReceiver)this.b.get(str);
    if (localActionReceiver != null)
      localActionReceiver.a(paramContext, paramIntent, this);
    while (true)
    {
      return;
      ((FbErrorReporter)a(paramContext).a(FbErrorReporter.class)).a(a.getName(), "Rejected the intent for the receiver because it was not registered: " + paramIntent.getAction() + ":" + getClass().getName());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.content.SecureBroadcastReceiver
 * JD-Core Version:    0.6.0
 */