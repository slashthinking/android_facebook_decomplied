package com.facebook.orca.notify;

import android.app.Notification;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Vibrator;
import com.facebook.orca.debug.BLog;

public class MessagingNotificationFeedback
{
  private static final Class<?> a = MessagingNotificationFeedback.class;
  private static final long[] b = { 0L, 100L };
  private static final long[] c = { 0L, 250L, 200L, 250L };
  private final Context d;
  private final Vibrator e;
  private final MessagingNotificationPreferences f;

  public MessagingNotificationFeedback(Context paramContext, Vibrator paramVibrator, MessagingNotificationPreferences paramMessagingNotificationPreferences)
  {
    this.d = paramContext;
    this.e = paramVibrator;
    this.f = paramMessagingNotificationPreferences;
  }

  private void a()
  {
    try
    {
      Uri localUri = b();
      Object localObject;
      if (localUri != null)
      {
        localObject = new MediaPlayer();
        ((MediaPlayer)localObject).setDataSource(this.d, localUri);
      }
      while (true)
      {
        ((MediaPlayer)localObject).setAudioStreamType(2);
        ((MediaPlayer)localObject).setOnCompletionListener(new MessagingNotificationFeedback.1(this));
        ((MediaPlayer)localObject).prepare();
        ((MediaPlayer)localObject).start();
        break;
        MediaPlayer localMediaPlayer = MediaPlayer.create(this.d, 1);
        localObject = localMediaPlayer;
      }
    }
    catch (Throwable localThrowable)
    {
      BLog.b(a, "MediaPlayer create failed: ", localThrowable);
    }
  }

  private void a(boolean paramBoolean)
  {
    if (this.f.a())
    {
      if (paramBoolean)
        break label36;
      BLog.b(a, "Vibrating short");
      this.e.vibrate(b, -1);
    }
    while (true)
    {
      return;
      label36: BLog.b(a, "Vibrating normal");
      this.e.vibrate(c, -1);
    }
  }

  // ERROR //
  private Uri b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/facebook/orca/notify/MessagingNotificationFeedback:f	Lcom/facebook/orca/notify/MessagingNotificationPreferences;
    //   4: invokeinterface 109 1 0
    //   9: astore_1
    //   10: aconst_null
    //   11: astore_2
    //   12: aload_1
    //   13: ifnonnull +5 -> 18
    //   16: aload_2
    //   17: areturn
    //   18: aload_1
    //   19: invokevirtual 115	android/net/Uri:getScheme	()Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull +12 -> 36
    //   27: aload_3
    //   28: ldc 117
    //   30: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +30 -> 63
    //   36: new 125	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: invokevirtual 128	android/net/Uri:getPath	()Ljava/lang/String;
    //   44: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 134	java/io/File:exists	()Z
    //   50: ifeq +8 -> 58
    //   53: aload_1
    //   54: astore_2
    //   55: goto -39 -> 16
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -7 -> 53
    //   63: aload_0
    //   64: getfield 36	com/facebook/orca/notify/MessagingNotificationFeedback:d	Landroid/content/Context;
    //   67: invokevirtual 140	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   70: aload_1
    //   71: ldc 142
    //   73: invokevirtual 148	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   76: astore 12
    //   78: aload 12
    //   80: ifnonnull +27 -> 107
    //   83: aconst_null
    //   84: astore_2
    //   85: aload 12
    //   87: ifnull -71 -> 16
    //   90: aload 12
    //   92: invokevirtual 153	android/content/res/AssetFileDescriptor:close	()V
    //   95: aconst_null
    //   96: astore_2
    //   97: goto -81 -> 16
    //   100: astore 13
    //   102: aconst_null
    //   103: astore_2
    //   104: goto -88 -> 16
    //   107: aload 12
    //   109: ifnull +8 -> 117
    //   112: aload 12
    //   114: invokevirtual 153	android/content/res/AssetFileDescriptor:close	()V
    //   117: aload_1
    //   118: astore_2
    //   119: goto -103 -> 16
    //   122: astore 10
    //   124: aconst_null
    //   125: astore_2
    //   126: iconst_0
    //   127: ifeq -111 -> 16
    //   130: aconst_null
    //   131: invokevirtual 153	android/content/res/AssetFileDescriptor:close	()V
    //   134: aconst_null
    //   135: astore_2
    //   136: goto -120 -> 16
    //   139: astore 11
    //   141: aconst_null
    //   142: astore_2
    //   143: goto -127 -> 16
    //   146: astore 8
    //   148: aconst_null
    //   149: astore_2
    //   150: iconst_0
    //   151: ifeq -135 -> 16
    //   154: aconst_null
    //   155: invokevirtual 153	android/content/res/AssetFileDescriptor:close	()V
    //   158: aconst_null
    //   159: astore_2
    //   160: goto -144 -> 16
    //   163: astore 9
    //   165: aconst_null
    //   166: astore_2
    //   167: goto -151 -> 16
    //   170: astore 6
    //   172: aconst_null
    //   173: astore_2
    //   174: iconst_0
    //   175: ifeq -159 -> 16
    //   178: aconst_null
    //   179: invokevirtual 153	android/content/res/AssetFileDescriptor:close	()V
    //   182: aconst_null
    //   183: astore_2
    //   184: goto -168 -> 16
    //   187: astore 7
    //   189: aconst_null
    //   190: astore_2
    //   191: goto -175 -> 16
    //   194: astore 4
    //   196: iconst_0
    //   197: ifeq +7 -> 204
    //   200: aconst_null
    //   201: invokevirtual 153	android/content/res/AssetFileDescriptor:close	()V
    //   204: aload 4
    //   206: athrow
    //   207: astore 14
    //   209: goto -92 -> 117
    //   212: astore 5
    //   214: goto -10 -> 204
    //
    // Exception table:
    //   from	to	target	type
    //   90	95	100	java/io/IOException
    //   63	78	122	java/lang/SecurityException
    //   130	134	139	java/io/IOException
    //   63	78	146	java/io/FileNotFoundException
    //   154	158	163	java/io/IOException
    //   63	78	170	java/lang/Throwable
    //   178	182	187	java/io/IOException
    //   63	78	194	finally
    //   112	117	207	java/io/IOException
    //   200	204	212	java/io/IOException
  }

  public void a(Notification paramNotification, AlertDisposition paramAlertDisposition)
  {
    boolean bool1 = this.f.b();
    boolean bool2 = this.f.a();
    boolean bool3 = this.f.c();
    if ((bool1) && (!paramAlertDisposition.b()))
    {
      Uri localUri = b();
      if (localUri == null)
        break label156;
      paramNotification.sound = localUri;
    }
    while (true)
    {
      paramAlertDisposition.c();
      if ((bool2) && (!paramAlertDisposition.d()))
      {
        paramNotification.vibrate = new long[] { 0L, 200L, 200L, 200L };
        paramAlertDisposition.e();
      }
      if ((bool3) && (!paramAlertDisposition.j()))
      {
        paramNotification.ledARGB = -16711936;
        paramNotification.ledOnMS = 300;
        paramNotification.ledOffMS = 1000;
        paramNotification.flags = (0x1 | paramNotification.flags);
        paramAlertDisposition.k();
      }
      return;
      label156: paramNotification.defaults = (0x1 | paramNotification.defaults);
    }
  }

  public void a(AlertDisposition paramAlertDisposition)
  {
    if (this.f.b())
    {
      a();
      paramAlertDisposition.c();
    }
  }

  public void b(AlertDisposition paramAlertDisposition)
  {
    a(false);
    paramAlertDisposition.e();
  }

  public void c(AlertDisposition paramAlertDisposition)
  {
    a(true);
    paramAlertDisposition.e();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.MessagingNotificationFeedback
 * JD-Core Version:    0.6.0
 */