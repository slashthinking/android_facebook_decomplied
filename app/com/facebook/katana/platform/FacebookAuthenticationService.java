package com.facebook.katana.platform;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.Settings;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.UserValuesManager;
import com.google.common.base.Preconditions;

public class FacebookAuthenticationService extends Service
{
  private static final Class<?> a = FacebookAuthenticationService.class;
  private static final String b = a.getSimpleName();
  private FacebookAuthenticationService.FacebookAccountAuthenticator c;

  public static int a(Context paramContext)
  {
    return AccountManager.get(paramContext).getAccountsByType("com.facebook.auth.login").length;
  }

  public static Account a(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString);
    Account[] arrayOfAccount = AccountManager.get(paramContext).getAccountsByType("com.facebook.auth.login");
    int i = arrayOfAccount.length;
    for (int j = 0; ; j++)
    {
      Account localAccount = null;
      if (j < i)
      {
        if (!paramString.equals(arrayOfAccount[j].name))
          continue;
        localAccount = arrayOfAccount[j];
      }
      return localAccount;
    }
  }

  public static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    monitorenter;
    while (true)
    {
      try
      {
        Account localAccount = b(paramContext, paramString);
        if (localAccount == null)
          return;
        ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", paramBoolean1);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("account_name", paramString);
        localContentValues.put("account_type", "com.facebook.auth.login");
        if (paramBoolean2)
        {
          i = 1;
          localContentValues.put("ungrouped_visible", Integer.valueOf(i));
          paramContext.getContentResolver().insert(ContactsContract.Settings.CONTENT_URI, localContentValues);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      int i = 0;
    }
  }

  public static void a(Intent paramIntent, int paramInt, String paramString)
  {
    AccountAuthenticatorResponse localAccountAuthenticatorResponse = (AccountAuthenticatorResponse)paramIntent.getParcelableExtra("accountAuthenticatorResponse");
    if (localAccountAuthenticatorResponse == null)
      Log.a(a, "No callback IBinder");
    while (true)
    {
      return;
      localAccountAuthenticatorResponse.onError(paramInt, paramString);
    }
  }

  public static void a(Intent paramIntent1, Intent paramIntent2)
  {
    paramIntent2.putExtra("accountAuthenticatorResponse", paramIntent1.getParcelableExtra("accountAuthenticatorResponse"));
  }

  public static void a(Intent paramIntent, String paramString)
  {
    AccountAuthenticatorResponse localAccountAuthenticatorResponse = (AccountAuthenticatorResponse)paramIntent.getParcelableExtra("accountAuthenticatorResponse");
    if (localAccountAuthenticatorResponse == null)
      Log.a(a, "No callback IBinder");
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("authAccount", paramString);
      localBundle.putString("accountType", "com.facebook.auth.login");
      localAccountAuthenticatorResponse.onResult(localBundle);
    }
  }

  // ERROR //
  public static Account b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 152	com/facebook/katana/platform/FacebookAuthenticationService:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +160 -> 174
    //   17: new 48	android/accounts/Account
    //   20: dup
    //   21: aload_1
    //   22: ldc 35
    //   24: invokespecial 154	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore 5
    //   29: aload_0
    //   30: invokestatic 33	android/accounts/AccountManager:get	(Landroid/content/Context;)Landroid/accounts/AccountManager;
    //   33: astore 6
    //   35: aload 6
    //   37: aload 5
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 158	android/accounts/AccountManager:addAccountExplicitly	(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Z
    //   44: ifne +33 -> 77
    //   47: getstatic 15	com/facebook/katana/platform/FacebookAuthenticationService:a	Ljava/lang/Class;
    //   50: new 160	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   57: ldc 163
    //   59: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 124	com/facebook/common/util/Log:a	(Ljava/lang/Class;Ljava/lang/String;)V
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_2
    //   76: areturn
    //   77: aload 5
    //   79: astore_2
    //   80: aload_0
    //   81: aload_1
    //   82: invokestatic 175	com/facebook/katana/provider/UserValuesManager:b	(Landroid/content/Context;Ljava/lang/String;)V
    //   85: goto -13 -> 72
    //   88: astore_3
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    //   94: astore 7
    //   96: invokestatic 180	com/facebook/base/BuildConstants:a	()Z
    //   99: ifeq +60 -> 159
    //   102: getstatic 15	com/facebook/katana/platform/FacebookAuthenticationService:a	Ljava/lang/Class;
    //   105: new 160	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   112: ldc 163
    //   114: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 182
    //   123: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 184
    //   128: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 186
    //   133: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 188
    //   138: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 190
    //   143: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: aload 7
    //   151: invokestatic 193	com/facebook/common/util/Log:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   154: aconst_null
    //   155: astore_2
    //   156: goto -84 -> 72
    //   159: getstatic 23	com/facebook/katana/platform/FacebookAuthenticationService:b	Ljava/lang/String;
    //   162: ldc 195
    //   164: aload 7
    //   166: invokestatic 200	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: aconst_null
    //   170: astore_2
    //   171: goto -99 -> 72
    //   174: aload 4
    //   176: astore_2
    //   177: goto -97 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   5	35	88	finally
    //   35	72	88	finally
    //   80	85	88	finally
    //   96	169	88	finally
    //   35	72	94	java/lang/SecurityException
  }

  public static boolean c(Context paramContext, String paramString)
  {
    int i = 0;
    if (paramString == null)
      return i;
    Cursor localCursor = paramContext.getContentResolver().query(ContactsContract.Settings.CONTENT_URI, new String[] { "ungrouped_visible" }, "account_type='com.facebook.auth.login' AND account_name='" + paramString + "'", null, null);
    int j;
    if (localCursor != null)
      if (localCursor.moveToNext())
      {
        j = localCursor.getInt(0);
        label76: localCursor.close();
      }
    while (true)
    {
      i = 0;
      if (j != 1)
        break;
      i = 1;
      break;
      j = 0;
      break label76;
      j = 0;
    }
  }

  public static boolean d(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    boolean bool = false;
    if (paramString == null);
    while (true)
    {
      return bool;
      Account localAccount = a(paramContext, paramString);
      bool = false;
      if (localAccount == null)
        continue;
      bool = ContentResolver.getSyncAutomatically(localAccount, "com.android.contacts");
    }
  }

  public static void e(Context paramContext, String paramString)
  {
    AccountManager localAccountManager = AccountManager.get(paramContext);
    Account[] arrayOfAccount = localAccountManager.getAccountsByType("com.facebook.auth.login");
    String str = UserValuesManager.c(paramContext);
    int i = arrayOfAccount.length;
    for (int j = 0; j < i; j++)
    {
      if (arrayOfAccount[j].name.equals(paramString))
        continue;
      if (arrayOfAccount[j].name.equals(str))
        UserValuesManager.b(paramContext, null);
      localAccountManager.removeAccount(arrayOfAccount[j], null, null);
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    if ("android.accounts.AccountAuthenticator".equals(paramIntent.getAction()));
    for (IBinder localIBinder = this.c.getIBinder(); ; localIBinder = null)
    {
      return localIBinder;
      Log.a(a, "Bound with unknown intent: " + paramIntent);
    }
  }

  public void onCreate()
  {
    this.c = new FacebookAuthenticationService.FacebookAccountAuthenticator(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.FacebookAuthenticationService
 * JD-Core Version:    0.6.0
 */