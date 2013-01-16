package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class UsersSearch extends FqlGetUsersProfile
{
  private static int a = -1;
  private final int b;
  private int f = 0;
  private int g = 0;
  private String h;

  public UsersSearch(Context paramContext, Intent paramIntent, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, a(paramString2, paramInt2, paramInt3), FacebookUser.class);
    this.f = paramInt2;
    this.h = paramString2;
    this.b = paramInt1;
    a = paramInt1;
  }

  private static String a(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("contains(");
    StringUtils.a(localStringBuilder, paramString);
    localStringBuilder.append(") ").append("LIMIT ").append(paramInt1).append(",").append(paramInt2);
    return localStringBuilder.toString();
  }

  private void a(Map<Long, FacebookUser> paramMap)
  {
    monitorenter;
    while (true)
    {
      ContentResolver localContentResolver;
      ContentValues[] arrayOfContentValues;
      try
      {
        int i = this.b;
        int j = a;
        if (i < j)
          return;
        localContentResolver = this.o.getContentResolver();
        if (this.f != 0)
          continue;
        localContentResolver.delete(ConnectionsContract.l, null, null);
        if (paramMap.size() == 0)
          continue;
        arrayOfContentValues = new ContentValues[paramMap.size()];
        Iterator localIterator = paramMap.values().iterator();
        int k = 0;
        if (localIterator.hasNext())
        {
          FacebookUser localFacebookUser = (FacebookUser)localIterator.next();
          ContentValues localContentValues = new ContentValues();
          arrayOfContentValues[k] = localContentValues;
          k++;
          localContentValues.put("user_id", Long.valueOf(localFacebookUser.mUserId));
          localContentValues.put("display_name", localFacebookUser.a());
          localContentValues.put("user_image_url", localFacebookUser.mImageUrl);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      localContentResolver.bulkInsert(ConnectionsContract.l, arrayOfContentValues);
    }
  }

  private static boolean c(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0));
    for (int i = 0; ; i = 1)
      return i;
  }

  protected void a(JsonParser paramJsonParser)
  {
    super.a(paramJsonParser);
    a(g());
  }

  public void b()
  {
    if (c(this.h))
      super.b();
    while (true)
    {
      return;
      new UsersSearch.DeleteThread(this).start();
    }
  }

  public int j()
  {
    return this.f;
  }

  public int k()
  {
    return this.g;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.UsersSearch
 * JD-Core Version:    0.6.0
 */