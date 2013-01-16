package android_src.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android_src.database.sqlite.SqliteWrapper;
import com.facebook.orca.debug.BLog;
import java.util.Iterator;
import java.util.Set;

public final class Telephony$Threads
  implements Telephony.ThreadsColumns
{
  public static final Uri a;
  public static final Uri b;
  private static final String[] c = { "_id" };
  private static final Uri d = Uri.parse("content://mms-sms/threadID");

  static
  {
    a = Uri.withAppendedPath(Telephony.MmsSms.a, "conversations");
    b = Uri.withAppendedPath(a, "obsolete");
  }

  public static long a(Context paramContext, Set<String> paramSet)
  {
    Uri.Builder localBuilder = d.buildUpon();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (Telephony.Mms.b(str))
        str = Telephony.Mms.a(str);
      localBuilder.appendQueryParameter("recipient", str);
    }
    Uri localUri = localBuilder.build();
    Cursor localCursor = SqliteWrapper.a(paramContext, paramContext.getContentResolver(), localUri, c, null, null, null);
    BLog.a("Telephony", "getOrCreateThreadId cursor cnt: " + localCursor.getCount());
    if (localCursor != null);
    try
    {
      if (localCursor.moveToFirst())
      {
        long l = localCursor.getLong(0);
        return l;
      }
      BLog.e("Telephony", "getOrCreateThreadId returned no rows!");
      localCursor.close();
      BLog.e("Telephony", "getOrCreateThreadId failed with uri " + localUri.toString());
      throw new IllegalArgumentException("Unable to find or allocate a thread ID.");
    }
    finally
    {
      localCursor.close();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.provider.Telephony.Threads
 * JD-Core Version:    0.6.0
 */