package com.facebook.orca.push.sms;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import com.facebook.orca.annotations.IsSmsNotifyEnabled;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.common.OrcaWakeLockManager.WakeLock;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.push.PushHandler;
import com.facebook.orca.push.common.PushDeserialization;
import com.facebook.orca.sms.MmsSmsContentResolverHandler;
import com.facebook.orca.sms.MmsSmsLogger;
import com.facebook.orca.sms.SmsContentResolverHandler;
import com.facebook.orca.sms.SmsReceiverWakeLockHolder;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

public class SmsReceiver extends IntentService
{
  private static final Class<?> a = SmsReceiver.class;
  private static final WtfToken b = new WtfToken();
  private SmsReceiverWakeLockHolder c;
  private PushDeserialization d;
  private Set<PushHandler> e;
  private OrcaSharedPreferences f;
  private SmsContentResolverHandler g;
  private MmsSmsContentResolverHandler h;
  private boolean i;
  private MmsSmsLogger j;

  public SmsReceiver()
  {
    super("SmsReceiver");
  }

  private long a(SmsMessage paramSmsMessage, long paramLong)
  {
    long l = paramSmsMessage.getTimestampMillis();
    return this.g.a(paramSmsMessage.getOriginatingAddress(), paramSmsMessage.getMessageBody(), paramLong, l, 1);
  }

  private String a(SmsMessage paramSmsMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n  Display Originating Address: ").append(paramSmsMessage.getDisplayOriginatingAddress());
    localStringBuilder.append("\n                 Message Body: ").append(paramSmsMessage.getMessageBody());
    localStringBuilder.append("\n         Display Message Body: ").append(paramSmsMessage.getDisplayMessageBody());
    localStringBuilder.append("\n                    Timestamp: ").append(paramSmsMessage.getTimestampMillis());
    localStringBuilder.append("\n                Message Class: ").append(paramSmsMessage.getMessageClass());
    localStringBuilder.append("\n          Originating Address: ").append(paramSmsMessage.getOriginatingAddress());
    localStringBuilder.append("\n          Protocol Identifier: ").append(paramSmsMessage.getProtocolIdentifier());
    localStringBuilder.append("\n                   Email Body: ").append(paramSmsMessage.getEmailBody());
    localStringBuilder.append("\n                   Email From: ").append(paramSmsMessage.getEmailFrom());
    localStringBuilder.append("\n               Pseudo Subject: ").append(paramSmsMessage.getPseudoSubject());
    localStringBuilder.append("\n                       Status: ").append(paramSmsMessage.getStatus());
    localStringBuilder.append("\n                Status on Icc: ").append(paramSmsMessage.getStatusOnIcc());
    localStringBuilder.append("\n                 Index On Icc: ").append(paramSmsMessage.getIndexOnIcc());
    localStringBuilder.append("\n                 Index on Sim: ").append(paramSmsMessage.getIndexOnSim());
    localStringBuilder.append("\n                Status on Sim: ").append(paramSmsMessage.getStatusOnSim());
    localStringBuilder.append("\n       Service Center Address: ").append(paramSmsMessage.getServiceCenterAddress());
    localStringBuilder.append("\n                    User Data: ").append(paramSmsMessage.getUserData().length);
    return localStringBuilder.toString();
  }

  static void a(Context paramContext, Intent paramIntent)
  {
    ((SmsReceiverWakeLockHolder)FbInjector.a(paramContext).a(SmsReceiverWakeLockHolder.class)).a.a();
    paramIntent.setClassName(paramContext, SmsReceiver.class.getName());
    paramContext.startService(paramIntent);
  }

  private long b(SmsMessage paramSmsMessage)
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar(2011, 8, 18);
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    long l = System.currentTimeMillis();
    localGregorianCalendar2.setTimeInMillis(l);
    if (localGregorianCalendar2.before(localGregorianCalendar1))
      l = paramSmsMessage.getTimestampMillis();
    return l;
  }

  // ERROR //
  private void b(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: getstatic 30	com/facebook/orca/push/sms/SmsReceiver:a	Ljava/lang/Class;
    //   3: ldc 223
    //   5: invokestatic 228	com/facebook/orca/debug/BLog:b	(Ljava/lang/Class;Ljava/lang/String;)V
    //   8: aload_2
    //   9: invokevirtual 232	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   12: ifnull +428 -> 440
    //   15: aload_0
    //   16: getfield 234	com/facebook/orca/push/sms/SmsReceiver:f	Lcom/facebook/orca/prefs/OrcaSharedPreferences;
    //   19: invokeinterface 239 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: getstatic 244	com/facebook/orca/prefs/MessagesPrefKeys:d	Lcom/facebook/orca/prefs/PrefKey;
    //   29: invokestatic 209	java/lang/System:currentTimeMillis	()J
    //   32: invokeinterface 249 4 0
    //   37: pop
    //   38: aload_3
    //   39: invokeinterface 250 1 0
    //   44: aload_2
    //   45: invokevirtual 232	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +388 -> 440
    //   55: aload 5
    //   57: ldc 252
    //   59: invokevirtual 258	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   62: checkcast 260	[Ljava/lang/Object;
    //   65: checkcast 260	[Ljava/lang/Object;
    //   68: astore 6
    //   70: aload 6
    //   72: arraylength
    //   73: anewarray 45	android/telephony/SmsMessage
    //   76: astore 7
    //   78: iconst_0
    //   79: istore 8
    //   81: iload 8
    //   83: aload 7
    //   85: arraylength
    //   86: if_icmpge +354 -> 440
    //   89: aload 7
    //   91: iload 8
    //   93: aload 6
    //   95: iload 8
    //   97: aaload
    //   98: checkcast 262	[B
    //   101: checkcast 262	[B
    //   104: invokestatic 266	android/telephony/SmsMessage:createFromPdu	([B)Landroid/telephony/SmsMessage;
    //   107: aastore
    //   108: iconst_2
    //   109: invokestatic 269	com/facebook/orca/debug/BLog:b	(I)Z
    //   112: ifeq +37 -> 149
    //   115: getstatic 30	com/facebook/orca/push/sms/SmsReceiver:a	Ljava/lang/Class;
    //   118: astore 27
    //   120: iconst_1
    //   121: anewarray 271	java/lang/Object
    //   124: astore 28
    //   126: aload 28
    //   128: iconst_0
    //   129: aload_0
    //   130: aload 7
    //   132: iload 8
    //   134: aaload
    //   135: invokespecial 273	com/facebook/orca/push/sms/SmsReceiver:a	(Landroid/telephony/SmsMessage;)Ljava/lang/String;
    //   138: aastore
    //   139: aload 27
    //   141: ldc_w 275
    //   144: aload 28
    //   146: invokestatic 278	com/facebook/orca/debug/BLog:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_0
    //   150: aload 7
    //   152: iload 8
    //   154: aaload
    //   155: invokespecial 280	com/facebook/orca/push/sms/SmsReceiver:b	(Landroid/telephony/SmsMessage;)J
    //   158: lstore 14
    //   160: aload_0
    //   161: getfield 282	com/facebook/orca/push/sms/SmsReceiver:i	Z
    //   164: ifeq +179 -> 343
    //   167: aload_0
    //   168: aload 7
    //   170: iload 8
    //   172: aaload
    //   173: lload 14
    //   175: invokespecial 284	com/facebook/orca/push/sms/SmsReceiver:a	(Landroid/telephony/SmsMessage;J)J
    //   178: lstore 24
    //   180: aload_0
    //   181: getfield 286	com/facebook/orca/push/sms/SmsReceiver:d	Lcom/facebook/orca/push/common/PushDeserialization;
    //   184: aload 7
    //   186: iload 8
    //   188: aaload
    //   189: lload 24
    //   191: lload 14
    //   193: invokevirtual 291	com/facebook/orca/push/common/PushDeserialization:a	(Landroid/telephony/SmsMessage;JJ)Lcom/facebook/orca/threads/Message;
    //   196: astore 26
    //   198: aload 26
    //   200: astore 10
    //   202: aload 10
    //   204: ifnull +178 -> 382
    //   207: aload 10
    //   209: invokevirtual 295	com/facebook/orca/threads/Message:b	()Ljava/lang/String;
    //   212: astore 21
    //   214: new 66	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   221: aload 10
    //   223: invokevirtual 298	com/facebook/orca/threads/Message:f	()Lcom/facebook/orca/threads/ParticipantInfo;
    //   226: invokevirtual 302	com/facebook/orca/threads/ParticipantInfo:d	()Ljava/lang/String;
    //   229: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 304
    //   235: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 7
    //   240: iload 8
    //   242: aaload
    //   243: invokevirtual 83	android/telephony/SmsMessage:getDisplayMessageBody	()Ljava/lang/String;
    //   246: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: astore 22
    //   254: aload_0
    //   255: getfield 306	com/facebook/orca/push/sms/SmsReceiver:e	Ljava/util/Set;
    //   258: invokeinterface 312 1 0
    //   263: astore 23
    //   265: aload 23
    //   267: invokeinterface 318 1 0
    //   272: ifeq +110 -> 382
    //   275: aload 23
    //   277: invokeinterface 322 1 0
    //   282: checkcast 324	com/facebook/orca/push/PushHandler
    //   285: aload 22
    //   287: aload 21
    //   289: aload 10
    //   291: getstatic 330	com/facebook/orca/push/PushSource:SMS	Lcom/facebook/orca/push/PushSource;
    //   294: invokeinterface 333 5 0
    //   299: goto -34 -> 265
    //   302: astore 9
    //   304: getstatic 37	com/facebook/orca/push/sms/SmsReceiver:b	Lcom/facebook/orca/debug/WtfToken;
    //   307: getstatic 30	com/facebook/orca/push/sms/SmsReceiver:a	Ljava/lang/Class;
    //   310: aload 9
    //   312: invokestatic 336	com/facebook/orca/debug/BLog:a	(Lcom/facebook/orca/debug/WtfToken;Ljava/lang/Class;Ljava/lang/Throwable;)V
    //   315: aload 10
    //   317: ifnull +137 -> 454
    //   320: aload 10
    //   322: invokevirtual 295	com/facebook/orca/threads/Message:b	()Ljava/lang/String;
    //   325: astore 13
    //   327: aload_0
    //   328: getfield 338	com/facebook/orca/push/sms/SmsReceiver:j	Lcom/facebook/orca/sms/MmsSmsLogger;
    //   331: aload 13
    //   333: iconst_0
    //   334: invokevirtual 343	com/facebook/orca/sms/MmsSmsLogger:a	(Ljava/lang/String;Z)V
    //   337: iinc 8 1
    //   340: goto -259 -> 81
    //   343: aload 7
    //   345: iload 8
    //   347: aaload
    //   348: invokevirtual 55	android/telephony/SmsMessage:getOriginatingAddress	()Ljava/lang/String;
    //   351: astore 16
    //   353: aload_0
    //   354: getfield 345	com/facebook/orca/push/sms/SmsReceiver:h	Lcom/facebook/orca/sms/MmsSmsContentResolverHandler;
    //   357: aload 16
    //   359: invokevirtual 350	com/facebook/orca/sms/MmsSmsContentResolverHandler:b	(Ljava/lang/String;)J
    //   362: lstore 17
    //   364: aload_0
    //   365: getfield 345	com/facebook/orca/push/sms/SmsReceiver:h	Lcom/facebook/orca/sms/MmsSmsContentResolverHandler;
    //   368: lload 17
    //   370: invokevirtual 353	com/facebook/orca/sms/MmsSmsContentResolverHandler:b	(J)Lcom/facebook/orca/threads/Message;
    //   373: astore 19
    //   375: aload 19
    //   377: astore 10
    //   379: goto -177 -> 202
    //   382: aload 10
    //   384: ifnull +76 -> 460
    //   387: aload 10
    //   389: invokevirtual 295	com/facebook/orca/threads/Message:b	()Ljava/lang/String;
    //   392: astore 20
    //   394: aload_0
    //   395: getfield 338	com/facebook/orca/push/sms/SmsReceiver:j	Lcom/facebook/orca/sms/MmsSmsLogger;
    //   398: aload 20
    //   400: iconst_1
    //   401: invokevirtual 343	com/facebook/orca/sms/MmsSmsLogger:a	(Ljava/lang/String;Z)V
    //   404: goto -67 -> 337
    //   407: astore 11
    //   409: aconst_null
    //   410: astore 10
    //   412: aconst_null
    //   413: astore 12
    //   415: aload 10
    //   417: ifnull +10 -> 427
    //   420: aload 10
    //   422: invokevirtual 295	com/facebook/orca/threads/Message:b	()Ljava/lang/String;
    //   425: astore 12
    //   427: aload_0
    //   428: getfield 338	com/facebook/orca/push/sms/SmsReceiver:j	Lcom/facebook/orca/sms/MmsSmsLogger;
    //   431: aload 12
    //   433: iconst_1
    //   434: invokevirtual 343	com/facebook/orca/sms/MmsSmsLogger:a	(Ljava/lang/String;Z)V
    //   437: aload 11
    //   439: athrow
    //   440: return
    //   441: astore 11
    //   443: goto -31 -> 412
    //   446: astore 9
    //   448: aconst_null
    //   449: astore 10
    //   451: goto -147 -> 304
    //   454: aconst_null
    //   455: astore 13
    //   457: goto -130 -> 327
    //   460: aconst_null
    //   461: astore 20
    //   463: goto -69 -> 394
    //
    // Exception table:
    //   from	to	target	type
    //   207	299	302	java/lang/Exception
    //   149	198	407	finally
    //   343	375	407	finally
    //   207	299	441	finally
    //   304	315	441	finally
    //   149	198	446	java/lang/Exception
    //   343	375	446	java/lang/Exception
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    this.e = localFbInjector.c(PushHandler.class);
    this.c = ((SmsReceiverWakeLockHolder)localFbInjector.a(SmsReceiverWakeLockHolder.class));
    this.d = ((PushDeserialization)localFbInjector.a(PushDeserialization.class));
    this.f = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.g = ((SmsContentResolverHandler)localFbInjector.a(SmsContentResolverHandler.class));
    this.h = ((MmsSmsContentResolverHandler)localFbInjector.a(MmsSmsContentResolverHandler.class));
    this.i = ((Boolean)localFbInjector.a(Boolean.class, IsSmsNotifyEnabled.class)).booleanValue();
    this.j = ((MmsSmsLogger)localFbInjector.a(MmsSmsLogger.class));
  }

  public final void onHandleIntent(Intent paramIntent)
  {
    try
    {
      b(this, paramIntent);
      return;
    }
    finally
    {
      this.c.a.b();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.sms.SmsReceiver
 * JD-Core Version:    0.6.0
 */