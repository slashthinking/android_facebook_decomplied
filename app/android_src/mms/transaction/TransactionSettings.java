package android_src.mms.transaction;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android_src.mms.util.SqliteWrapper;
import android_src.net.NetworkUtils;
import android_src.provider.Telephony.Carriers;
import com.facebook.orca.debug.BLog;

public class TransactionSettings
{
  private static final String[] d = { "type", "mmsc", "mmsproxy", "mmsport" };
  private String a;
  private String b;
  private int c = -1;

  public TransactionSettings(Context paramContext, String paramString)
  {
    String str1;
    Cursor localCursor;
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(paramString))
    {
      str1 = null;
      localCursor = SqliteWrapper.a(paramContext, paramContext.getContentResolver(), Uri.withAppendedPath(Telephony.Carriers.a, "current"), d, str1, null, null);
      if (BLog.b(2))
      {
        localStringBuilder = new StringBuilder().append("TransactionSettings looking for apn: ").append(str1).append(" returned: ");
        if (localCursor != null)
          break label140;
      }
    }
    label140: for (String str3 = "null cursor"; ; str3 = localCursor.getCount() + " hits")
    {
      BLog.a("fb-mms:TransactionSettings", str3);
      if (localCursor != null)
        break label170;
      BLog.e("fb-mms:TransactionSettings", "Apn is not found in Database!");
      return;
      str1 = "apn='" + paramString.trim() + "'";
      break;
    }
    label170: for (int i = 0; ; i = 1)
    {
      while (true)
      {
        String str2;
        try
        {
          if ((!localCursor.moveToNext()) || (!TextUtils.isEmpty(this.a)))
            break;
          if (!a(localCursor.getString(0), "mms"))
            continue;
          this.a = NetworkUtils.a(localCursor.getString(1).trim());
          this.b = NetworkUtils.a(localCursor.getString(2));
          if (!d())
            break label404;
          str2 = localCursor.getString(3);
          try
          {
            this.c = Integer.parseInt(str2);
            i = 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (!TextUtils.isEmpty(str2))
              break label306;
          }
          BLog.d("fb-mms:TransactionSettings", "mms port not set!");
          continue;
        }
        finally
        {
          localCursor.close();
        }
        label306: BLog.d("fb-mms:TransactionSettings", "Bad port number format: " + str2, localNumberFormatException);
      }
      localCursor.close();
      BLog.a("fb-mms:TransactionSettings", "APN setting: MMSC: " + this.a + " looked for: " + str1);
      if ((i == 0) || (!TextUtils.isEmpty(this.a)))
        break;
      BLog.e("fb-mms:TransactionSettings", "Invalid APN setting: MMSC is empty");
      break;
    }
  }

  public TransactionSettings(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 != null);
    for (String str = paramString1.trim(); ; str = null)
    {
      this.a = str;
      this.b = paramString2;
      this.c = paramInt;
      if (BLog.b(2))
        BLog.a("fb-mms:TransactionSettings", "TransactionSettings: " + this.a + " proxyAddress: " + this.b + " proxyPort: " + this.c);
      return;
    }
  }

  private static boolean a(String paramString1, String paramString2)
  {
    int i = 1;
    if (TextUtils.isEmpty(paramString1));
    while (true)
    {
      return i;
      String[] arrayOfString = paramString1.split(",");
      int j = arrayOfString.length;
      for (int k = 0; ; k++)
      {
        if (k >= j)
          break label63;
        String str = arrayOfString[k];
        if ((str.equals(paramString2)) || (str.equals("*")))
          break;
      }
      label63: i = 0;
    }
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public boolean d()
  {
    if ((this.b != null) && (this.b.trim().length() != 0));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.TransactionSettings
 * JD-Core Version:    0.6.0
 */