package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookGroup;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FqlGetGroups extends FqlMultiQuery
  implements ApiMethodCallback
{
  private List<FacebookGroup> a;

  public FqlGetGroups(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, long paramLong)
  {
    super(paramContext, paramIntent, paramString, a(paramContext, paramIntent, paramString, paramLong), paramServiceOperationListener);
  }

  public static String a(Context paramContext)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new FqlGetGroups(paramContext, null, localAppSession.b().sessionKey, null, localAppSession.b().userId), 1001, 600, null);
    }
  }

  protected static LinkedHashMap<String, FqlQuery> a(Context paramContext, Intent paramIntent, String paramString, long paramLong)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("grouprel", new FqlGetGroups.UserRelationship(paramContext, paramIntent, paramString, null, paramLong));
    localLinkedHashMap.put("groupinfo", new FqlGetGroups.Info(paramContext, paramIntent, paramString, null, "#grouprel"));
    return localLinkedHashMap;
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    switch (paramIntent.getIntExtra("extended_type", -1))
    {
    default:
    case 600:
    }
    while (true)
    {
      return;
      Iterator localIterator = paramAppSession.d().iterator();
      while (localIterator.hasNext())
        ((AppSessionListener)localIterator.next()).e(paramAppSession, paramString1, paramInt, paramString2, paramException, this.a);
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    super.a(paramJsonParser);
    FqlGetGroups.UserRelationship localUserRelationship = (FqlGetGroups.UserRelationship)c("grouprel");
    this.a = ((FqlGetGroups.Info)c("groupinfo")).a;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      FacebookGroup localFacebookGroup = (FacebookGroup)localIterator.next();
      FqlGetGroups.UserRelationship.GroupUserRelationship localGroupUserRelationship = (FqlGetGroups.UserRelationship.GroupUserRelationship)localUserRelationship.a.get(Long.valueOf(localFacebookGroup.mId));
      if (localGroupUserRelationship == null)
        continue;
      localFacebookGroup.a(localGroupUserRelationship.mUnread);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetGroups
 * JD-Core Version:    0.6.0
 */