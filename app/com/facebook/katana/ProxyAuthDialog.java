package com.facebook.katana;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Toaster;
import com.facebook.katana.activity.PlatformDialogActivity;
import com.facebook.katana.util.URLQueryBuilder;
import com.facebook.orca.annotations.AuthNotRequired;
import java.util.Iterator;
import java.util.Set;

@AuthNotRequired
public class ProxyAuthDialog extends PlatformDialogActivity
{
  private static final Class<?> p = ProxyAuthDialog.class;

  // ERROR //
  private byte[] n()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 25	com/facebook/katana/ProxyAuthDialog:l	()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 31	com/facebook/katana/util/StringUtils:c	(Ljava/lang/String;)Z
    //   9: ifeq +8 -> 17
    //   12: aload_0
    //   13: invokevirtual 34	com/facebook/katana/ProxyAuthDialog:j	()Ljava/lang/String;
    //   16: astore_1
    //   17: aload_1
    //   18: ldc 36
    //   20: invokevirtual 41	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   23: ifeq +32 -> 55
    //   26: ldc 43
    //   28: new 45	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   35: ldc 48
    //   37: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: iconst_1
    //   48: invokestatic 61	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   51: aconst_null
    //   52: astore_3
    //   53: aload_3
    //   54: areturn
    //   55: aload_0
    //   56: invokevirtual 65	com/facebook/katana/ProxyAuthDialog:getPackageManager	()Landroid/content/pm/PackageManager;
    //   59: aload_1
    //   60: bipush 64
    //   62: invokevirtual 71	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   65: astore 4
    //   67: ldc 73
    //   69: invokestatic 79	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   72: astore 6
    //   74: aload 6
    //   76: aload 4
    //   78: getfield 85	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   81: iconst_0
    //   82: aaload
    //   83: invokevirtual 90	android/content/pm/Signature:toByteArray	()[B
    //   86: invokevirtual 94	java/security/MessageDigest:update	([B)V
    //   89: aload 6
    //   91: invokevirtual 97	java/security/MessageDigest:digest	()[B
    //   94: astore_3
    //   95: goto -42 -> 53
    //   98: astore_2
    //   99: ldc 99
    //   101: new 45	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   108: ldc 101
    //   110: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_1
    //   114: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: iconst_1
    //   121: invokestatic 61	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   124: aconst_null
    //   125: astore_3
    //   126: goto -73 -> 53
    //   129: astore 5
    //   131: ldc 103
    //   133: ldc 105
    //   135: iconst_1
    //   136: invokestatic 61	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   139: aconst_null
    //   140: astore_3
    //   141: goto -88 -> 53
    //
    // Exception table:
    //   from	to	target	type
    //   55	67	98	android/content/pm/PackageManager$NameNotFoundException
    //   67	74	129	java/security/NoSuchAlgorithmException
  }

  public void a(Bundle paramBundle)
  {
    if (getCallingPackage() == null)
    {
      ErrorReporting.a("sso", "getCallingPackage==null; finish() called. see t1118578", true);
      Toaster.a(this, getString(2131363007));
      finish();
    }
    while (true)
    {
      super.a(paramBundle);
      return;
      if (n() != null)
        continue;
      ErrorReporting.a("sso", "getCallingPackageSigHash==null; finish() called. see t1732910", true);
      Toaster.a(this, getString(2131363008));
      finish();
    }
  }

  protected void i()
  {
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = getIntent().getExtras();
    Iterator localIterator = localBundle2.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Object localObject = localBundle2.get(str2);
      if (!(localObject instanceof String))
        continue;
      localBundle1.putString(str2, (String)localObject);
    }
    String str1 = Base64.encodeToString(n(), 9);
    localBundle1.putString("type", "user_agent");
    localBundle1.putString("redirect_uri", "fbconnect://success");
    localBundle1.putString("display", "touch");
    localBundle1.putString("android_key", str1);
    this.o = (Constants.URL.e(this) + "?" + URLQueryBuilder.a(localBundle1));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ProxyAuthDialog
 * JD-Core Version:    0.6.0
 */