package android_src.mms.transaction;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android_src.mms.pdu.EncodedStringValue;
import android_src.mms.pdu.PduComposer;
import android_src.mms.pdu.PduParser;
import android_src.mms.pdu.PduPersister;
import android_src.mms.pdu.SendConf;
import android_src.mms.pdu.SendReq;
import android_src.mms.ui.MessageUtils;
import android_src.mms.util.RateController;
import android_src.mms.util.SendingProgressTokenManager;
import android_src.mms.util.SqliteWrapper;
import android_src.provider.Telephony.Mms.Sent;
import com.facebook.orca.debug.BLog;
import java.util.Arrays;

public class SendTransaction extends Transaction
  implements Runnable
{
  private Thread a;
  private final Uri f;

  public SendTransaction(Context paramContext, int paramInt, TransactionSettings paramTransactionSettings, String paramString)
  {
    super(paramContext, paramInt, paramTransactionSettings);
    this.f = Uri.parse(paramString);
    this.c = paramString;
    a(RetryScheduler.a(paramContext));
  }

  public void a()
  {
    this.a = new Thread(this);
    this.a.start();
  }

  public int b()
  {
    return 2;
  }

  public void run()
  {
    try
    {
      RateController localRateController = RateController.a();
      if ((localRateController.c()) && (!localRateController.d()))
        BLog.e("fb-mms:SendTransaction", "Sending rate limit surpassed.");
      while (true)
      {
        return;
        PduPersister localPduPersister = PduPersister.a(this.b);
        SendReq localSendReq = (SendReq)localPduPersister.a(this.f);
        long l1 = System.currentTimeMillis() / 1000L;
        localSendReq.a(l1);
        ContentValues localContentValues1 = new ContentValues(1);
        localContentValues1.put("date", Long.valueOf(l1));
        SqliteWrapper.a(this.b, this.b.getContentResolver(), this.f, localContentValues1, null, null);
        String str1 = MessageUtils.a(this.b);
        if (!TextUtils.isEmpty(str1))
          localSendReq.a(new EncodedStringValue(str1));
        long l2 = ContentUris.parseId(this.f);
        byte[] arrayOfByte1 = a(SendingProgressTokenManager.a(Long.valueOf(l2)), new PduComposer(this.b, localSendReq).a());
        SendingProgressTokenManager.b(Long.valueOf(l2));
        if (BLog.b(2))
        {
          String str2 = new String(arrayOfByte1);
          BLog.b("fb-mms:SendTransaction", "[SendTransaction] run: send mms msg (" + this.c + "), resp=" + str2);
        }
        SendConf localSendConf = (SendConf)new PduParser(arrayOfByte1).a();
        if (localSendConf == null)
          BLog.e("fb-mms:SendTransaction", "No M-Send.conf received.");
        byte[] arrayOfByte2 = localSendReq.b();
        byte[] arrayOfByte3 = localSendConf.c();
        if (!Arrays.equals(arrayOfByte2, arrayOfByte3))
        {
          BLog.e("fb-mms:SendTransaction", "Inconsistent Transaction-ID: req=" + new String(arrayOfByte2) + ", conf=" + new String(arrayOfByte3));
          if (this.d.a() != 1)
          {
            this.d.a(2);
            this.d.a(this.f);
            BLog.e("fb-mms:SendTransaction", "Delivery failed.");
          }
          c();
          continue;
        }
        ContentValues localContentValues2 = new ContentValues(2);
        int i = localSendConf.b();
        localContentValues2.put("resp_st", Integer.valueOf(i));
        if (i != 128)
        {
          SqliteWrapper.a(this.b, this.b.getContentResolver(), this.f, localContentValues2, null, null);
          BLog.e("fb-mms:SendTransaction", "Server returned an error code: " + i);
          if (this.d.a() != 1)
          {
            this.d.a(2);
            this.d.a(this.f);
            BLog.e("fb-mms:SendTransaction", "Delivery failed.");
          }
          c();
          continue;
        }
        localContentValues2.put("m_id", PduPersister.a(localSendConf.a()));
        SqliteWrapper.a(this.b, this.b.getContentResolver(), this.f, localContentValues2, null, null);
        Uri localUri = localPduPersister.a(this.f, Telephony.Mms.Sent.a);
        this.d.a(1);
        this.d.a(localUri);
        if (this.d.a() != 1)
        {
          this.d.a(2);
          this.d.a(this.f);
          BLog.e("fb-mms:SendTransaction", "Delivery failed.");
        }
        c();
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        BLog.d("fb-mms:SendTransaction", "Throwable caught in SendTransaction", localThrowable);
        if (this.d.a() != 1)
        {
          this.d.a(2);
          this.d.a(this.f);
          BLog.e("fb-mms:SendTransaction", "Delivery failed.");
        }
        c();
      }
    }
    finally
    {
      if (this.d.a() != 1)
      {
        this.d.a(2);
        this.d.a(this.f);
        BLog.e("fb-mms:SendTransaction", "Delivery failed.");
      }
      c();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.SendTransaction
 * JD-Core Version:    0.6.0
 */