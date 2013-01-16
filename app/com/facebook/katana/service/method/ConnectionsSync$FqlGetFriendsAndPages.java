package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.model.FacebookFriendInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class ConnectionsSync$FqlGetFriendsAndPages extends FqlMultiQuery
{
  ConnectionsSync$FqlGetFriendsAndPages(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, long paramLong)
  {
    super(paramContext, paramIntent, paramString, a(paramContext, paramIntent, paramString, paramLong), paramServiceOperationListener);
  }

  private static LinkedHashMap<String, FqlQuery> a(Context paramContext, Intent paramIntent, String paramString, long paramLong)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("friends", new FqlSyncUsersQuery(paramContext, paramIntent, paramString, paramLong, null));
    localLinkedHashMap.put("admin", new FqlGetProfileGeneric(paramContext, paramIntent, paramString, null, "id IN (SELECT page_id FROM page_admin WHERE uid=" + paramLong + ")", ConnectionsSync.FacebookAdminPageProfile.class));
    localLinkedHashMap.put("fan", new FqlGetProfileGeneric(paramContext, paramIntent, paramString, null, "id IN (SELECT page_id FROM page_fan WHERE uid=" + paramLong + ")", ConnectionsSync.FacebookFanPageProfile.class));
    return localLinkedHashMap;
  }

  List<FacebookFriendInfo> g()
  {
    return ((FqlSyncUsersQuery)c("friends")).g();
  }

  Map<Long, ConnectionsSync.FacebookPageProfile> h()
  {
    return ((FqlGetProfileGeneric)c("admin")).g();
  }

  Map<Long, ConnectionsSync.FacebookPageProfile> i()
  {
    return ((FqlGetProfileGeneric)c("fan")).g();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ConnectionsSync.FqlGetFriendsAndPages
 * JD-Core Version:    0.6.0
 */