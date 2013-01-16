package com.facebook.ipc.connections;

import android.net.Uri;
import com.facebook.base.BuildConstants;

public class ConnectionsContract
{
  public static final String a = BuildConstants.b() + ".provider.ConnectionsProvider";
  public static final Uri b;
  public static final Uri c;
  public static final Uri d;
  public static final Uri e;
  public static final Uri f;
  public static final Uri g;
  public static final Uri h;
  public static final Uri i;
  public static final Uri j;
  public static final Uri k;
  public static final Uri l;
  private static final String m = "content://" + a + "/";

  static
  {
    b = Uri.parse(m + ConnectionsContract.Selectors.CONNECTIONS_CONTENT.category + ConnectionsContract.Selectors.CONNECTIONS_CONTENT.uriSuffix);
    c = Uri.parse(m + ConnectionsContract.Selectors.CONNECTION_ID.category + ConnectionsContract.Selectors.CONNECTION_ID.uriSuffix);
    d = Uri.parse(m + ConnectionsContract.Selectors.FRIENDS_CONTENT.category + ConnectionsContract.Selectors.FRIENDS_CONTENT.uriSuffix);
    e = Uri.parse(m + ConnectionsContract.Selectors.FRIEND_UID.category + ConnectionsContract.Selectors.FRIEND_UID.uriSuffix);
    f = Uri.parse(m + ConnectionsContract.Selectors.FRIENDS_SEARCH.category + ConnectionsContract.Selectors.FRIENDS_SEARCH.uriSuffix);
    g = Uri.parse(m + ConnectionsContract.Selectors.FRIENDS_PREFIX_SEARCH.category + ConnectionsContract.Selectors.FRIENDS_PREFIX_SEARCH.uriSuffix);
    h = Uri.parse(m + ConnectionsContract.Selectors.FRIENDS_BIRTHDAYS.category + ConnectionsContract.Selectors.FRIENDS_BIRTHDAYS.uriSuffix);
    i = Uri.parse(m + ConnectionsContract.Selectors.PAGES_CONTENT.category + ConnectionsContract.Selectors.PAGES_CONTENT.uriSuffix);
    j = Uri.parse(m + ConnectionsContract.Selectors.PAGE_ID.category + ConnectionsContract.Selectors.PAGE_ID.uriSuffix);
    k = Uri.parse(m + ConnectionsContract.Selectors.PAGES_SEARCH.category + ConnectionsContract.Selectors.PAGES_SEARCH.uriSuffix);
    l = Uri.parse(m + ConnectionsContract.Selectors.SEARCH_CONTENT.category + ConnectionsContract.Selectors.SEARCH_CONTENT.uriSuffix);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.connections.ConnectionsContract
 * JD-Core Version:    0.6.0
 */