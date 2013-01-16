package com.facebook.katana.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Patterns;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceContactpoints
{
  public static Collection<String> a(Context paramContext)
  {
    LinkedList localLinkedList = new LinkedList();
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getLine1Number();
    if (!StringUtils.c(str))
      localLinkedList.add(str);
    for (Account localAccount : AccountManager.get(paramContext).getAccounts())
    {
      if (!Patterns.EMAIL_ADDRESS.matcher(localAccount.name).matches())
        continue;
      localLinkedList.add(localAccount.name);
    }
    return localLinkedList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.DeviceContactpoints
 * JD-Core Version:    0.6.0
 */