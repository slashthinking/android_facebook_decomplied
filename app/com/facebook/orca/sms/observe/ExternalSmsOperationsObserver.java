package com.facebook.orca.sms.observe;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.net.Uri.Builder;
import android_src.provider.Telephony.MmsSms;
import com.facebook.orca.database.ThreadsDatabaseSupplier;
import com.facebook.orca.notify.OrcaForegroundActivityListener;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.MessagingIdUtil;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Provider;

public class ExternalSmsOperationsObserver extends ContentObserver
{
  private final ContentResolver a;
  private final ThreadsDatabaseSupplier b;
  private final Provider<Boolean> c;
  private final OrcaForegroundActivityListener d;
  private final ExternalSmsOperationsHandler e;

  public ExternalSmsOperationsObserver(ContentResolver paramContentResolver, ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, OrcaForegroundActivityListener paramOrcaForegroundActivityListener, Provider<Boolean> paramProvider, ExternalSmsOperationsHandler paramExternalSmsOperationsHandler)
  {
    super(null);
    this.a = paramContentResolver;
    this.b = paramThreadsDatabaseSupplier;
    this.c = paramProvider;
    this.d = paramOrcaForegroundActivityListener;
    this.e = paramExternalSmsOperationsHandler;
  }

  private Set<Long> a()
  {
    HashSet localHashSet1 = new HashSet();
    Uri localUri = Telephony.MmsSms.b.buildUpon().appendQueryParameter("simple", "true").build();
    Cursor localCursor1 = this.a.query(localUri, new String[] { "_id" }, null, null, null);
    while (localCursor1.moveToNext())
      localHashSet1.add(Long.valueOf(localCursor1.getLong(localCursor1.getColumnIndex("_id"))));
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = FolderName.d.b();
    Cursor localCursor2 = localSQLiteDatabase.rawQuery("SELECT thread_id FROM threads WHERE folder=? ORDER BY thread_id", arrayOfString);
    HashSet localHashSet2 = new HashSet();
    while (localCursor2.moveToNext())
      localHashSet2.add(Long.valueOf(MessagingIdUtil.c(localCursor2.getString(localCursor2.getColumnIndex("thread_id")))));
    localHashSet2.removeAll(localHashSet1);
    return localHashSet2;
  }

  public boolean deliverSelfNotifications()
  {
    return false;
  }

  public void onChange(boolean paramBoolean)
  {
    if (!((Boolean)this.c.b()).booleanValue());
    while (true)
    {
      return;
      if (this.d.a() == null)
      {
        Set localSet = a();
        if (localSet.isEmpty())
          continue;
        this.e.a(localSet);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.observe.ExternalSmsOperationsObserver
 * JD-Core Version:    0.6.0
 */