package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.model.FriendList;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collections;
import java.util.List;

public class FqlGetFriendLists extends FqlGeneratedQuery
{
  private List<FriendList> a;

  protected FqlGetFriendLists(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, long paramLong)
  {
    this(paramContext, paramIntent, paramString, paramServiceOperationListener, a(paramLong));
  }

  protected FqlGetFriendLists(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "friendlist", paramString2, FriendList.class);
  }

  protected static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("owner=").append(paramLong).append(" ORDER BY name");
    return localStringBuilder.toString();
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.a = JMParser.b(paramJsonParser, FriendList.class);
  }

  public List<FriendList> g()
  {
    return Collections.unmodifiableList(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetFriendLists
 * JD-Core Version:    0.6.0
 */