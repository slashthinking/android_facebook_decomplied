package com.facebook.orca.sms;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android_src.mms.ClassesToUse;
import android_src.provider.Telephony.Mms.Outbox;
import android_src.provider.Telephony.Threads;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.Message.ChannelSource;
import com.facebook.orca.threads.MessageBuilder;
import com.facebook.orca.threads.MessagingIdUtil;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MmsSendMessageHandler
{
  private static final Class<?> a = MmsSendMessageHandler.class;
  private static final WtfToken b = new WtfToken();
  private final Context c;
  private final MmsContentResolverHandler d;
  private final ConnectivityManager e;

  public MmsSendMessageHandler(Context paramContext, MmsContentResolverHandler paramMmsContentResolverHandler, ConnectivityManager paramConnectivityManager)
  {
    this.c = paramContext;
    this.d = paramMmsContentResolverHandler;
    this.e = paramConnectivityManager;
  }

  private void a(long paramLong)
  {
    this.d.b(paramLong);
  }

  private boolean a()
  {
    NetworkInfo localNetworkInfo = this.e.getNetworkInfo(2);
    if (localNetworkInfo == null);
    for (boolean bool = false; ; bool = localNetworkInfo.isAvailable())
      return bool;
  }

  Message a(Message paramMessage, Set<String> paramSet)
  {
    long l = this.d.a(paramMessage, paramSet);
    Semaphore localSemaphore = new Semaphore(0);
    MmsSendMessageHandler.SendTransactionState localSendTransactionState = new MmsSendMessageHandler.SendTransactionState(null);
    MmsSendMessageHandler.1 local1 = new MmsSendMessageHandler.1(this, l, localSendTransactionState, localSemaphore);
    this.c.registerReceiver(local1, new IntentFilter("android.intent.action.TRANSACTION_COMPLETED_ACTION"));
    Uri localUri = ContentUris.withAppendedId(Telephony.Mms.Outbox.a, l);
    Intent localIntent = new Intent(this.c, ClassesToUse.a);
    localIntent.putExtra("uri", localUri.toString());
    localIntent.putExtra("type", 2);
    if (!a())
    {
      a(l);
      throw new Exception("Network isn't availible to send Mms");
    }
    this.c.startService(localIntent);
    if (!localSemaphore.tryAcquire(120L, TimeUnit.SECONDS))
    {
      a(l);
      Exception localException = new Exception("Semaphore could not acquire requested permits");
      BLog.a(b, a, "Send message timed out", localException);
      throw localException;
    }
    if (MmsSendMessageHandler.SendTransactionState.a(localSendTransactionState) != 1)
    {
      a(l);
      throw new Exception("Mms send failed");
    }
    String str1 = MessagingIdUtil.c(l);
    String str2 = paramMessage.b();
    if (str2 == null)
      str2 = MessagingIdUtil.a(Telephony.Threads.a(this.c, paramSet));
    return new MessageBuilder().a(paramMessage).a(false).f("mms").a(Message.ChannelSource.MMS).a(0).a(str1).b(str2).a(null).d(System.currentTimeMillis()).v();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSendMessageHandler
 * JD-Core Version:    0.6.0
 */