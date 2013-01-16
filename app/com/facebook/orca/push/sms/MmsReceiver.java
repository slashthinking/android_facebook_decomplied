package com.facebook.orca.push.sms;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android_src.mms.ClassesToUse;
import android_src.mms.MmsConfig;
import android_src.mms.MmsException;
import android_src.mms.pdu.DeliveryInd;
import android_src.mms.pdu.EncodedStringValue;
import android_src.mms.pdu.GenericPdu;
import android_src.mms.pdu.NotificationInd;
import android_src.mms.pdu.PduParser;
import android_src.mms.pdu.PduPersister;
import android_src.mms.pdu.ReadOrigInd;
import android_src.mms.util.SqliteWrapper;
import android_src.provider.Telephony.Mms;
import android_src.provider.Telephony.Mms.Inbox;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.cache.ReadThreadManager;
import com.facebook.orca.common.OrcaWakeLockManager.WakeLock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.sms.MmsReceiverWakeLockHolder;
import com.facebook.orca.sms.MmsSmsContentResolverHandler;
import com.facebook.orca.sms.MmsSmsLogger;
import com.facebook.orca.threads.MessagingIdUtil;
import java.util.Iterator;
import java.util.Set;

public class MmsReceiver extends IntentService
{
  private static final Class<?> a = MmsReceiver.class;
  private static final WtfToken b = new WtfToken();
  private MmsReceiverWakeLockHolder c;
  private OrcaSharedPreferences d;
  private MmsSmsLogger e;
  private MmsSmsContentResolverHandler f;
  private ReadThreadManager g;

  public MmsReceiver()
  {
    super("MmsReceiver");
  }

  private long a(GenericPdu paramGenericPdu, int paramInt)
  {
    String str;
    if (paramInt == 134)
      str = new String(((DeliveryInd)paramGenericPdu).b());
    while (true)
    {
      StringBuilder localStringBuilder = new StringBuilder(40);
      localStringBuilder.append("m_id");
      localStringBuilder.append('=');
      localStringBuilder.append(DatabaseUtils.sqlEscapeString(str));
      localStringBuilder.append(" AND ");
      localStringBuilder.append("m_type");
      localStringBuilder.append('=');
      localStringBuilder.append(128);
      Cursor localCursor = SqliteWrapper.a(this, getContentResolver(), Telephony.Mms.a, new String[] { "thread_id" }, localStringBuilder.toString(), null, null);
      if (localCursor != null);
      try
      {
        if ((localCursor.getCount() == 1) && (localCursor.moveToFirst()))
        {
          long l2 = localCursor.getLong(0);
          l1 = l2;
          return l1;
          str = new String(((ReadOrigInd)paramGenericPdu).b());
          continue;
        }
        localCursor.close();
        long l1 = -1L;
      }
      finally
      {
        localCursor.close();
      }
    }
  }

  private String a(GenericPdu paramGenericPdu)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n     Message Type: ").append(paramGenericPdu.f());
    localStringBuilder.append("\n      Mms Version: ").append(paramGenericPdu.g());
    localStringBuilder.append("\n             From: ").append(paramGenericPdu.h().c());
    switch (paramGenericPdu.f())
    {
    default:
    case 134:
    case 136:
    case 130:
    }
    while (true)
    {
      return localStringBuilder.toString();
      a((DeliveryInd)paramGenericPdu, localStringBuilder);
      continue;
      a((ReadOrigInd)paramGenericPdu, localStringBuilder);
      continue;
      a((NotificationInd)paramGenericPdu, localStringBuilder);
    }
  }

  private StringBuilder a(DeliveryInd paramDeliveryInd, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("\n             Date:").append(paramDeliveryInd.a());
    paramStringBuilder.append("\n       Message Id:").append(new String(paramDeliveryInd.b()));
    paramStringBuilder.append("\n           Status:").append(paramDeliveryInd.c());
    for (EncodedStringValue localEncodedStringValue : paramDeliveryInd.d())
    {
      if (localEncodedStringValue == null)
        continue;
      paramStringBuilder.append("\n               To:").append(localEncodedStringValue.c());
    }
    return paramStringBuilder;
  }

  private StringBuilder a(NotificationInd paramNotificationInd, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("\n    Content Class: ").append(paramNotificationInd.a());
    paramStringBuilder.append("\n Content Location: ").append(new String(paramNotificationInd.b()));
    paramStringBuilder.append("\n           Expiry: ").append(paramNotificationInd.c());
    paramStringBuilder.append("\n    Message Class: ").append(new String(paramNotificationInd.d()));
    paramStringBuilder.append("\n     Message Size: ").append(paramNotificationInd.i());
    paramStringBuilder.append("\n          Subject: ").append(paramNotificationInd.j());
    paramStringBuilder.append("\n   Transaction Id: ").append(new String(paramNotificationInd.k()));
    paramStringBuilder.append("\n  Delivery Report: ").append(paramNotificationInd.l());
    return paramStringBuilder;
  }

  private StringBuilder a(ReadOrigInd paramReadOrigInd, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("\n             Date: ").append(paramReadOrigInd.a());
    paramStringBuilder.append("\n       Message Id: ").append(new String(paramReadOrigInd.b()));
    paramStringBuilder.append("\n      Read Status: ").append(paramReadOrigInd.c());
    for (EncodedStringValue localEncodedStringValue : paramReadOrigInd.d())
    {
      if (localEncodedStringValue == null)
        continue;
      paramStringBuilder.append("\n               To:").append(localEncodedStringValue.c());
    }
    return paramStringBuilder;
  }

  static void a(Context paramContext, Intent paramIntent)
  {
    ((MmsReceiverWakeLockHolder)FbInjector.a(paramContext).a(MmsReceiverWakeLockHolder.class)).a.a();
    paramIntent.setClassName(paramContext, MmsReceiver.class.getName());
    paramContext.startService(paramIntent);
  }

  private void a(Intent paramIntent)
  {
    GenericPdu localGenericPdu = new PduParser(paramIntent.getByteArrayExtra("data")).a();
    if (localGenericPdu == null)
      BLog.e(a, "Invalid PUSH data");
    while (true)
    {
      return;
      if (BLog.b(2))
      {
        Class localClass = a;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = a(localGenericPdu);
        BLog.a(localClass, "Received MMS msg: \n%s", arrayOfObject);
      }
      PduPersister localPduPersister = PduPersister.a(this);
      ContentResolver localContentResolver = getContentResolver();
      int i = localGenericPdu.f();
      switch (i)
      {
      default:
      case 134:
      case 136:
      case 130:
      }
      try
      {
        BLog.e(a, "Received unrecognized PDU.");
        while (true)
        {
          BLog.a(a, "PUSH Intent processed.");
          break;
          long l = a(localGenericPdu, i);
          if (l == -1L)
            continue;
          Uri localUri2 = localPduPersister.a(localGenericPdu, Telephony.Mms.Inbox.a);
          ContentValues localContentValues = new ContentValues(1);
          localContentValues.put("thread_id", Long.valueOf(l));
          SqliteWrapper.a(this, localContentResolver, localUri2, localContentValues, null, null);
        }
      }
      catch (MmsException localMmsException)
      {
        while (true)
          BLog.e(a, "Failed to save the data from PUSH: type=" + i, localMmsException);
        this.e.a();
        localNotificationInd = (NotificationInd)localGenericPdu;
        if (MmsConfig.b())
        {
          byte[] arrayOfByte1 = localNotificationInd.b();
          if (61 == arrayOfByte1[(-1 + arrayOfByte1.length)])
          {
            byte[] arrayOfByte2 = localNotificationInd.k();
            byte[] arrayOfByte3 = new byte[arrayOfByte1.length + arrayOfByte2.length];
            System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, arrayOfByte1.length);
            System.arraycopy(arrayOfByte2, 0, arrayOfByte3, arrayOfByte1.length, arrayOfByte2.length);
            localNotificationInd.a(arrayOfByte3);
          }
        }
        if (!a(localNotificationInd))
        {
          Iterator localIterator = this.f.b().iterator();
          while (localIterator.hasNext())
          {
            String str = MessagingIdUtil.a(((Long)localIterator.next()).longValue());
            this.g.a(str, -1L);
          }
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          NotificationInd localNotificationInd;
          BLog.e(a, "Unexpected Exception.", localException);
          continue;
          Uri localUri1 = localPduPersister.a(localGenericPdu, Telephony.Mms.Inbox.a);
          Intent localIntent = new Intent(this, ClassesToUse.a);
          localIntent.putExtra("uri", localUri1.toString());
          localIntent.putExtra("type", 0);
          startService(localIntent);
          continue;
          BLog.a(a, "Skip downloading duplicate message: " + new String(localNotificationInd.b()));
        }
      }
    }
  }

  private boolean a(NotificationInd paramNotificationInd)
  {
    byte[] arrayOfByte = paramNotificationInd.b();
    Cursor localCursor;
    if (arrayOfByte != null)
    {
      String[] arrayOfString = { new String(arrayOfByte) };
      localCursor = SqliteWrapper.a(this, getContentResolver(), Telephony.Mms.a, new String[] { "_id" }, "ct_l = ?", arrayOfString, null);
      if (localCursor == null);
    }
    try
    {
      int j = localCursor.getCount();
      if (j > 0)
      {
        localCursor.close();
        return i;
      }
      localCursor.close();
      int i = 0;
    }
    finally
    {
      localCursor.close();
    }
  }

  private void b(Context paramContext, Intent paramIntent)
  {
    BLog.b(a, "Received onMessage");
    a(paramIntent);
    OrcaSharedPreferences.Editor localEditor = this.d.b();
    localEditor.a(MessagesPrefKeys.d, System.currentTimeMillis());
    localEditor.a();
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    this.c = ((MmsReceiverWakeLockHolder)localFbInjector.a(MmsReceiverWakeLockHolder.class));
    this.d = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.e = ((MmsSmsLogger)localFbInjector.a(MmsSmsLogger.class));
    this.f = ((MmsSmsContentResolverHandler)localFbInjector.a(MmsSmsContentResolverHandler.class));
    this.g = ((ReadThreadManager)localFbInjector.a(ReadThreadManager.class));
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
 * Qualified Name:     com.facebook.orca.push.sms.MmsReceiver
 * JD-Core Version:    0.6.0
 */