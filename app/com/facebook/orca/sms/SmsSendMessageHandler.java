package com.facebook.orca.sms;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android_src.provider.Telephony.Threads;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.Message.ChannelSource;
import com.facebook.orca.threads.MessageBuilder;
import com.facebook.orca.threads.MessagingIdUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SmsSendMessageHandler
{
  private static final Class<?> a = SmsSendMessageHandler.class;
  private final Context b;
  private final SmsContentResolverHandler c;
  private final MmsSmsLogger d;

  public SmsSendMessageHandler(Context paramContext, SmsContentResolverHandler paramSmsContentResolverHandler, MmsSmsLogger paramMmsSmsLogger)
  {
    this.b = paramContext;
    this.c = paramSmsContentResolverHandler;
    this.d = paramMmsSmsLogger;
  }

  Message a(Message paramMessage, String paramString)
  {
    Semaphore localSemaphore = new Semaphore(0);
    SmsSendMessageHandler.SendResultCode localSendResultCode = new SmsSendMessageHandler.SendResultCode(null);
    PendingIntent localPendingIntent1 = PendingIntent.getBroadcast(this.b, 0, new Intent("SMS_SENT"), 0);
    PendingIntent localPendingIntent2 = PendingIntent.getBroadcast(this.b, 0, new Intent("SMS_DELIVERED"), 0);
    String str1 = paramMessage.b();
    if (str1 == null);
    for (String str2 = MessagingIdUtil.a(Telephony.Threads.a(this.b, Sets.a(new String[] { paramString }))); ; str2 = str1)
    {
      SmsSendMessageHandler.1 local1 = new SmsSendMessageHandler.1(this, localSendResultCode, localSemaphore);
      this.b.registerReceiver(local1, new IntentFilter("SMS_SENT"));
      SmsSendMessageHandler.2 local2 = new SmsSendMessageHandler.2(this, str2);
      this.b.registerReceiver(local2, new IntentFilter("SMS_DELIVERED"));
      SmsManager localSmsManager = SmsManager.getDefault();
      ArrayList localArrayList1 = localSmsManager.divideMessage(paramMessage.h());
      ArrayList localArrayList2 = Lists.a();
      ArrayList localArrayList3 = Lists.a();
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        localArrayList2.add(localPendingIntent1);
        localArrayList3.add(localPendingIntent2);
      }
      localSmsManager.sendMultipartTextMessage(paramString, null, localArrayList1, localArrayList2, localArrayList3);
      if (!localSemaphore.tryAcquire(localArrayList1.size(), 120L, TimeUnit.SECONDS))
      {
        this.d.a(paramMessage.b());
        throw new Exception("Semaphore could not acquire requested permits");
      }
      if (SmsSendMessageHandler.SendResultCode.a(localSendResultCode) != -1)
      {
        this.d.a(paramMessage.b(), false, SmsSendMessageHandler.SendResultCode.a(localSendResultCode));
        throw new Exception("SMS send failed with code: " + SmsSendMessageHandler.SendResultCode.a(localSendResultCode));
      }
      this.b.unregisterReceiver(local1);
      this.b.unregisterReceiver(local2);
      long l = System.currentTimeMillis();
      String str3 = MessagingIdUtil.b(this.c.a(paramString, paramMessage.h(), l, l, 2));
      Message localMessage = new MessageBuilder().a(paramMessage).a(false).f("sms").a(Message.ChannelSource.SMS).a(0).a(str3).b(str2).a(null).d(System.currentTimeMillis()).v();
      this.d.a(paramMessage.b(), true, SmsSendMessageHandler.SendResultCode.a(localSendResultCode));
      return localMessage;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.SmsSendMessageHandler
 * JD-Core Version:    0.6.0
 */