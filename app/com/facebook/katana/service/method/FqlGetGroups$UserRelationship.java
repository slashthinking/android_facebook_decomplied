package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FqlGetGroups$UserRelationship extends FqlGeneratedQuery
{
  Map<Long, FqlGetGroups.UserRelationship.GroupUserRelationship> a = new HashMap();

  protected FqlGetGroups$UserRelationship(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, long paramLong)
  {
    this(paramContext, paramIntent, paramString, paramServiceOperationListener, a(paramLong));
  }

  protected FqlGetGroups$UserRelationship(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "group_member", paramString2, FqlGetGroups.UserRelationship.GroupUserRelationship.class);
  }

  protected static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uid=").append(paramLong);
    return localStringBuilder.toString();
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FqlGetGroups.UserRelationship.GroupUserRelationship.class);
    if (localList == null);
    while (true)
    {
      return;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FqlGetGroups.UserRelationship.GroupUserRelationship localGroupUserRelationship = (FqlGetGroups.UserRelationship.GroupUserRelationship)localIterator.next();
        this.a.put(Long.valueOf(localGroupUserRelationship.mGid), localGroupUserRelationship);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetGroups.UserRelationship
 * JD-Core Version:    0.6.0
 */