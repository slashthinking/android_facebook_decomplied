package android_src.mms.transaction;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android_src.mms.MmsConfig;
import android_src.mms.MmsException;
import android_src.mms.pdu.GenericPdu;
import android_src.mms.pdu.NotificationInd;
import android_src.mms.pdu.NotifyRespInd;
import android_src.mms.pdu.PduComposer;
import android_src.mms.pdu.PduParser;
import android_src.mms.pdu.PduPersister;
import android_src.mms.util.DownloadManager;
import android_src.mms.util.SqliteWrapper;
import android_src.provider.Telephony.Mms.Inbox;
import com.facebook.orca.debug.BLog;
import java.io.IOException;

public class NotificationTransaction extends Transaction
  implements Runnable
{
  private Uri a;
  private NotificationInd f;
  private String g;

  public NotificationTransaction(Context paramContext, int paramInt, TransactionSettings paramTransactionSettings, NotificationInd paramNotificationInd)
  {
    super(paramContext, paramInt, paramTransactionSettings);
    try
    {
      this.a = PduPersister.a(paramContext).a(paramNotificationInd, Telephony.Mms.Inbox.a);
      this.f = paramNotificationInd;
      this.c = new String(paramNotificationInd.k());
      return;
    }
    catch (MmsException localMmsException)
    {
      BLog.d("fb-mms:NotificationTransaction", "Failed to save NotificationInd in constructor.", localMmsException);
    }
    throw new IllegalArgumentException();
  }

  public NotificationTransaction(Context paramContext, int paramInt, TransactionSettings paramTransactionSettings, String paramString)
  {
    super(paramContext, paramInt, paramTransactionSettings);
    this.a = Uri.parse(paramString);
    try
    {
      this.f = ((NotificationInd)PduPersister.a(paramContext).a(this.a));
      this.c = new String(this.f.k());
      this.g = new String(this.f.b());
      a(RetryScheduler.a(paramContext));
      return;
    }
    catch (MmsException localMmsException)
    {
      BLog.d("fb-mms:NotificationTransaction", "Failed to load NotificationInd from: " + paramString, localMmsException);
    }
    throw new IllegalArgumentException();
  }

  private void a(int paramInt)
  {
    NotifyRespInd localNotifyRespInd = new NotifyRespInd(18, this.f.k(), paramInt);
    if (MmsConfig.k())
      a(new PduComposer(this.b, localNotifyRespInd).a(), this.g);
    while (true)
    {
      return;
      a(new PduComposer(this.b, localNotifyRespInd).a());
    }
  }

  public void a()
  {
    new Thread(this).start();
  }

  public int b()
  {
    return 0;
  }

  public void run()
  {
    int i = 132;
    DownloadManager localDownloadManager = DownloadManager.b();
    boolean bool = localDownloadManager.a();
    if (bool);
    try
    {
      localDownloadManager.a(this.a, 129);
      try
      {
        byte[] arrayOfByte2 = a(this.g);
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte1 != null)
        {
          localGenericPdu = new PduParser(arrayOfByte1).a();
          if ((localGenericPdu == null) || (localGenericPdu.f() != i))
          {
            StringBuilder localStringBuilder = new StringBuilder().append("Invalid M-RETRIEVE.CONF PDU. ");
            if (localGenericPdu != null)
            {
              str = "message type: " + localGenericPdu.f();
              BLog.e("fb-mms:NotificationTransaction", str);
              this.d.a(2);
              break label573;
              a(i);
              this.d.a(this.a);
              if (!bool)
                break label536;
              label165: if (this.d.a() != 1)
              {
                this.d.a(2);
                BLog.e("fb-mms:NotificationTransaction", "NotificationTransaction failed.");
              }
              c();
              return;
              localDownloadManager.a(this.a, 128);
              a(131);
              this.d.a(this.a);
              if (bool);
              while (true)
              {
                if (this.d.a() != 1)
                {
                  this.d.a(2);
                  BLog.e("fb-mms:NotificationTransaction", "NotificationTransaction failed.");
                }
                c();
                break;
                this.d.a(1);
              }
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          this.d.a(2);
          byte[] arrayOfByte1 = null;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        GenericPdu localGenericPdu;
        BLog.d("fb-mms:NotificationTransaction", "Throwable caught in NotificationTransaction", localThrowable);
        this.d.a(this.a);
        if (!bool)
          break;
        label315: if (this.d.a() != 1)
        {
          this.d.a(2);
          BLog.e("fb-mms:NotificationTransaction", "NotificationTransaction failed.");
        }
        c();
        continue;
        String str = "null pdu";
        continue;
        Uri localUri = PduPersister.a(this.b).a(localGenericPdu, Telephony.Mms.Inbox.a);
        ContentValues localContentValues = new ContentValues(1);
        localContentValues.put("date", Long.valueOf(System.currentTimeMillis() / 1000L));
        SqliteWrapper.a(this.b, this.b.getContentResolver(), localUri, localContentValues, null, null);
        SqliteWrapper.a(this.b, this.b.getContentResolver(), this.a, null, null);
        this.a = localUri;
        i = 129;
        break label573;
        this.d.a(1);
      }
    }
    finally
    {
      this.d.a(this.a);
      if (bool);
      while (true)
      {
        if (this.d.a() != 1)
        {
          this.d.a(2);
          BLog.e("fb-mms:NotificationTransaction", "NotificationTransaction failed.");
        }
        c();
        throw localObject;
        if (this.d.a() != 0)
          break;
        this.d.a(1);
        break;
        label536: this.d.a(1);
        break label165;
        this.d.a(1);
        break label315;
        this.d.a(1);
      }
      i = 131;
      label573: switch (i)
      {
      case 130:
      default:
      case 129:
      case 131:
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.NotificationTransaction
 * JD-Core Version:    0.6.0
 */