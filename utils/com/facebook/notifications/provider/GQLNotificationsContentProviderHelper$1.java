package com.facebook.notifications.provider;

import android.database.DatabaseUtils;
import com.google.common.base.Function;

final class GQLNotificationsContentProviderHelper$1
  implements Function<String, String>
{
  public String a(String paramString)
  {
    return DatabaseUtils.sqlEscapeString(paramString.toString());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.provider.GQLNotificationsContentProviderHelper.1
 * JD-Core Version:    0.6.2
 */