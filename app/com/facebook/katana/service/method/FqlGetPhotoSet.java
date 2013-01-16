package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.model.FacebookPhotoSet;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.fasterxml.jackson.core.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FqlGetPhotoSet extends FqlGeneratedQuery
  implements ApiMethodCallback
{
  private final NetworkRequestCallback<String, FacebookPhotoSet> a;
  private String b;
  private List<Long> f;
  private final String g;

  private FqlGetPhotoSet(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2, NetworkRequestCallback<String, FacebookPhotoSet> paramNetworkRequestCallback)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "photoset_photo", c(paramString2), FqlGetPhotoSet.PhotoSetEntry.class);
    this.g = paramString2;
    this.a = paramNetworkRequestCallback;
  }

  public static String a(Context paramContext, String paramString, NetworkRequestCallback<String, FacebookPhotoSet> paramNetworkRequestCallback)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new FqlGetPhotoSet(paramContext, null, localAppSession.b().sessionKey, null, paramString, paramNetworkRequestCallback), 1001, 85, null);
    }
  }

  private static String c(String paramString)
  {
    return "photoset_token = " + DatabaseUtils.sqlEscapeString(paramString);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    boolean bool;
    if (this.f != null)
    {
      bool = true;
      if (!bool)
        break label119;
    }
    label119: for (FacebookPhotoSet localFacebookPhotoSet = new FacebookPhotoSet(this.g, this.f); ; localFacebookPhotoSet = null)
    {
      if (this.a != null)
        this.a.a(paramContext, bool, this.g, this.b, localFacebookPhotoSet);
      Iterator localIterator = paramAppSession.d().iterator();
      while (localIterator.hasNext())
        ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.g, localFacebookPhotoSet);
      bool = false;
      break;
    }
  }

  protected void a(HttpOperation.ResponseInputStream paramResponseInputStream)
  {
    this.b = paramResponseInputStream.b();
    a(b(this.b));
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FqlGetPhotoSet.PhotoSetEntry.class);
    if (localList == null);
    while (true)
    {
      return;
      ArrayList localArrayList = new ArrayList(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        localArrayList.add(Long.valueOf(((FqlGetPhotoSet.PhotoSetEntry)localIterator.next()).mPhotoFBID));
      this.f = localArrayList;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetPhotoSet
 * JD-Core Version:    0.6.0
 */