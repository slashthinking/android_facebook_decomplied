package com.facebook.orca.app;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

public class OrcaActivityBroadcaster extends ActivityBroadcaster
{
  public OrcaActivityBroadcaster(Context paramContext)
  {
    super(paramContext);
  }

  private void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, -1L);
  }

  private void a(String paramString1, String paramString2, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramString1);
    localIntent.putExtra("threadid", paramString2);
    if (paramLong != -1L)
      localIntent.putExtra("actionid", paramLong);
    LocalBroadcastManager.a(this.a).a(localIntent);
  }

  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.facebook.orca.ACTION_SMS_ENABLED_CHANGED");
    LocalBroadcastManager.a(this.a).a(localIntent);
  }

  public void a(String paramString, long paramLong)
  {
    a("com.facebook.orca.ACTION_THREAD_UPDATED_FOR_UI", paramString, paramLong);
  }

  public void a(String paramString, ImmutableSet<String> paramImmutableSet)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.facebook.orca.ACTION_DELETED_MESSAGES_FOR_UI");
    localIntent.putExtra("threadid", paramString);
    localIntent.putStringArrayListExtra("message_ids", Lists.a(paramImmutableSet.h()));
    LocalBroadcastManager.a(this.a).a(localIntent);
  }

  public void b(String paramString)
  {
    a("com.facebook.orca.ACTION_THREAD_UPDATED_FOR_UI", paramString);
  }

  public void c(String paramString)
  {
    a("com.facebook.orca.ACTION_READ_THREAD_FOR_UI", paramString);
  }

  public void d(String paramString)
  {
    a("com.facebook.orca.ACTION_REMOVED_THREAD_FOR_UI", paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.OrcaActivityBroadcaster
 * JD-Core Version:    0.6.0
 */