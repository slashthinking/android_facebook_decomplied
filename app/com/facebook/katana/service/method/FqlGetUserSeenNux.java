package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.features.UserSeenNux.Project;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.List;

public class FqlGetUserSeenNux extends FqlGeneratedQuery
  implements ApiMethodCallback
{
  private static final Class<?> a = FqlGetUserSeenNux.class;
  private UserSeenNux.Project b;
  private Boolean f = Boolean.valueOf(false);
  private NetworkRequestCallback<UserSeenNux.Project, Boolean> g;

  public FqlGetUserSeenNux(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, UserSeenNux.Project paramProject, NetworkRequestCallback<UserSeenNux.Project, Boolean> paramNetworkRequestCallback)
  {
    super(paramContext, paramIntent, paramString, paramServiceOperationListener, "user_seen_nux", a(paramContext, paramProject), FqlGetUserSeenNux.NuxData.class);
    this.b = paramProject;
    this.g = paramNetworkRequestCallback;
  }

  private static String a(Context paramContext, UserSeenNux.Project paramProject)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    StringBuilder localStringBuilder;
    for (String str = null; ; str = localStringBuilder.toString())
    {
      return str;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("user_id = ");
      localStringBuilder.append(localAppSession.b().userId);
      localStringBuilder.append(" AND app_id = ");
      localStringBuilder.append(paramProject.projectId);
    }
  }

  public static String a(Context paramContext, UserSeenNux.Project paramProject, NetworkRequestCallback<UserSeenNux.Project, Boolean> paramNetworkRequestCallback)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      str = localAppSession.a(paramContext, new FqlGetUserSeenNux(paramContext, null, localAppSession.b().sessionKey, null, paramProject, paramNetworkRequestCallback), 1001, 1001, null);
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if ((paramInt == 200) && (this.b != null) && (this.f != null));
    for (boolean bool = true; ; bool = false)
    {
      this.g.a(paramContext, bool, this.b, this.f.toString(), this.f);
      return;
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FqlGetUserSeenNux.NuxData.class);
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      do
        if (!localIterator.hasNext())
          break;
      while (((FqlGetUserSeenNux.NuxData)localIterator.next()).projectID != this.b.projectId);
    }
    for (this.f = Boolean.valueOf(true); ; this.f = Boolean.valueOf(false))
      return;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetUserSeenNux
 * JD-Core Version:    0.6.0
 */