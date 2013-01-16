package android_src.mms.transaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android_src.mms.MmsConfig;
import android_src.mms.MmsException;
import android_src.mms.pdu.AcknowledgeInd;
import android_src.mms.pdu.EncodedStringValue;
import android_src.mms.pdu.PduComposer;
import android_src.mms.pdu.PduParser;
import android_src.mms.pdu.PduPersister;
import android_src.mms.pdu.RetrieveConf;
import android_src.mms.ui.MessageUtils;
import android_src.mms.util.DownloadManager;
import android_src.mms.util.SqliteWrapper;
import android_src.provider.Telephony.Mms;
import android_src.provider.Telephony.Mms.Inbox;
import com.facebook.orca.debug.BLog;

public class RetrieveTransaction extends Transaction
  implements Runnable
{
  static final String[] a = { "ct_l", "locked" };
  private final Uri f;
  private final String g;
  private boolean h;

  public RetrieveTransaction(Context paramContext, int paramInt, TransactionSettings paramTransactionSettings, String paramString)
  {
    super(paramContext, paramInt, paramTransactionSettings);
    if (paramString.startsWith("content://"))
    {
      this.f = Uri.parse(paramString);
      String str = a(paramContext, this.f);
      this.g = str;
      this.c = str;
      a(RetryScheduler.a(paramContext));
      return;
    }
    throw new IllegalArgumentException("Initializing from X-Mms-Content-Location is abandoned!");
  }

  private String a(Context paramContext, Uri paramUri)
  {
    Cursor localCursor = SqliteWrapper.a(paramContext, paramContext.getContentResolver(), paramUri, a, null, null, null);
    this.h = false;
    if (localCursor != null);
    try
    {
      if ((localCursor.getCount() == 1) && (localCursor.moveToFirst()))
      {
        if (localCursor.getInt(1) == 1);
        for (boolean bool = true; ; bool = false)
        {
          this.h = bool;
          String str = localCursor.getString(0);
          localCursor.close();
          return str;
        }
      }
      localCursor.close();
      throw new MmsException("Cannot get X-Mms-Content-Location from: " + paramUri);
    }
    finally
    {
    }
    throw localObject;
  }

  private static void a(Context paramContext, Uri paramUri, String paramString, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("ct_l", paramString);
    localContentValues.put("locked", Boolean.valueOf(paramBoolean));
    SqliteWrapper.a(paramContext, paramContext.getContentResolver(), paramUri, localContentValues, null, null);
  }

  private void a(RetrieveConf paramRetrieveConf)
  {
    byte[] arrayOfByte = paramRetrieveConf.d();
    AcknowledgeInd localAcknowledgeInd;
    if (arrayOfByte != null)
    {
      localAcknowledgeInd = new AcknowledgeInd(18, arrayOfByte);
      localAcknowledgeInd.a(new EncodedStringValue(MessageUtils.a(this.b)));
      if (!MmsConfig.k())
        break label69;
      a(new PduComposer(this.b, localAcknowledgeInd).a(), this.g);
    }
    while (true)
    {
      return;
      label69: a(new PduComposer(this.b, localAcknowledgeInd).a());
    }
  }

  private static boolean a(Context paramContext, RetrieveConf paramRetrieveConf)
  {
    byte[] arrayOfByte = paramRetrieveConf.c();
    Cursor localCursor;
    if (arrayOfByte != null)
    {
      String str = new String(arrayOfByte);
      String[] arrayOfString = new String[2];
      arrayOfString[0] = str;
      arrayOfString[1] = String.valueOf(132);
      localCursor = SqliteWrapper.a(paramContext, paramContext.getContentResolver(), Telephony.Mms.a, new String[] { "_id" }, "(m_id = ? AND m_type = ?)", arrayOfString, null);
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

  public void a()
  {
    new Thread(this).start();
  }

  public int b()
  {
    return 1;
  }

  public void run()
  {
    Uri localUri = null;
    try
    {
      DownloadManager.b().a(this.f, 129);
      localRetrieveConf = (RetrieveConf)new PduParser(a(this.g)).a();
      if (localRetrieveConf == null)
        throw new MmsException("Invalid M-Retrieve.conf PDU.");
    }
    catch (Throwable localThrowable)
    {
      RetrieveConf localRetrieveConf;
      BLog.d("fb-mms:RetrieveTransaction", "Throwable caught in RetreiveTransaction", localThrowable);
      return;
      if (a(this.b, localRetrieveConf))
      {
        this.d.a(2);
        this.d.a(this.f);
      }
      while (true)
      {
        SqliteWrapper.a(this.b, this.b.getContentResolver(), this.f, null, null);
        if (localUri != null);
        a(localRetrieveConf);
        if (this.d.a() != 1)
        {
          this.d.a(2);
          this.d.a(this.f);
          BLog.e("fb-mms:RetrieveTransaction", "Retrieval failed.");
        }
        c();
        break;
        localUri = PduPersister.a(this.b).a(localRetrieveConf, Telephony.Mms.Inbox.a);
        ContentValues localContentValues = new ContentValues(1);
        localContentValues.put("date", Long.valueOf(System.currentTimeMillis() / 1000L));
        SqliteWrapper.a(this.b, this.b.getContentResolver(), localUri, localContentValues, null, null);
        this.d.a(1);
        this.d.a(localUri);
        a(this.b, localUri, this.g, this.h);
      }
    }
    finally
    {
      if (this.d.a() != 1)
      {
        this.d.a(2);
        this.d.a(this.f);
        BLog.e("fb-mms:RetrieveTransaction", "Retrieval failed.");
      }
      c();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.RetrieveTransaction
 * JD-Core Version:    0.6.0
 */