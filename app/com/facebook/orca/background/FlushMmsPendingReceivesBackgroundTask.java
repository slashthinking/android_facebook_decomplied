package com.facebook.orca.background;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android_src.mms.ClassesToUse;
import android_src.mms.pdu.PduPersister;
import android_src.provider.Telephony.Mms;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.orca.cache.ReadThreadManager;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.sms.MmsSmsContentResolverHandler;
import com.facebook.orca.threads.MessagingIdUtil;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Provider;

public class FlushMmsPendingReceivesBackgroundTask extends AbstractBackgroundTask
{
  private static Class<?> a = FlushMmsPendingReceivesBackgroundTask.class;
  private final Context b;
  private final MmsSmsContentResolverHandler c;
  private final ReadThreadManager d;
  private final Provider<Boolean> e;

  public FlushMmsPendingReceivesBackgroundTask(Context paramContext, MmsSmsContentResolverHandler paramMmsSmsContentResolverHandler, ReadThreadManager paramReadThreadManager, Provider<Boolean> paramProvider)
  {
    super("FLUSH_MMS_PENDING_RECEIVES");
    this.b = paramContext;
    this.c = paramMmsSmsContentResolverHandler;
    this.d = paramReadThreadManager;
    this.e = paramProvider;
  }

  private int a(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default:
      BLog.d(a, "Unrecognized MESSAGE_TYPE: " + paramInt);
      i = -1;
    case 130:
    case 135:
    case 128:
    }
    while (true)
    {
      return i;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
    }
  }

  public boolean b()
  {
    boolean bool = ((Boolean)this.e.b()).booleanValue();
    int i = 0;
    if (!bool);
    while (true)
    {
      return i;
      Cursor localCursor = PduPersister.a(this.b).a(System.currentTimeMillis());
      try
      {
        int j = localCursor.getCount();
        if (j > 0)
        {
          k = 1;
          localCursor.close();
          i = k;
          continue;
        }
        int k = 0;
      }
      finally
      {
        localCursor.close();
      }
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    Cursor localCursor = PduPersister.a(this.b).a(System.currentTimeMillis());
    while (true)
    {
      Intent localIntent;
      try
      {
        int i = localCursor.getColumnIndexOrThrow("msg_id");
        int j = localCursor.getColumnIndexOrThrow("msg_type");
        if (!localCursor.moveToNext())
          break;
        a(localCursor.getInt(j));
        Uri localUri = ContentUris.withAppendedId(Telephony.Mms.a, localCursor.getLong(i));
        localIntent = new Intent(this.b, ClassesToUse.a);
        localIntent.putExtra("uri", localUri.toString());
        localIntent.putExtra("type", 1);
        Iterator localIterator = this.c.b().iterator();
        if (localIterator.hasNext())
        {
          String str = MessagingIdUtil.a(((Long)localIterator.next()).longValue());
          this.d.a(str, -1L);
          continue;
        }
      }
      finally
      {
        localCursor.close();
      }
      this.b.startService(localIntent);
    }
    localCursor.close();
    return Futures.a(new BackgroundResult(true));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.FlushMmsPendingReceivesBackgroundTask
 * JD-Core Version:    0.6.0
 */