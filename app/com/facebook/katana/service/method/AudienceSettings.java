package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.ipc.model.PrivacySetting;
import com.facebook.ipc.model.PrivacySetting.Category;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.FriendList;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class AudienceSettings extends FqlMultiQuery
  implements ApiMethodCallback
{
  protected static ManagedDataStore<PrivacySetting.Category, AudienceSettings> a;
  private PrivacySetting b;
  private NetworkRequestCallback<PrivacySetting.Category, AudienceSettings> f;
  private PrivacySetting.Category g;
  private List<FriendList> h;

  public AudienceSettings(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, long paramLong, PrivacySetting.Category paramCategory, NetworkRequestCallback<PrivacySetting.Category, AudienceSettings> paramNetworkRequestCallback)
  {
    super(paramContext, paramIntent, paramString, a(paramContext, paramIntent, paramString, paramLong, paramCategory), paramServiceOperationListener);
    this.f = paramNetworkRequestCallback;
    this.g = paramCategory;
  }

  protected static ManagedDataStore<PrivacySetting.Category, AudienceSettings> a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (a == null)
        a = new ManagedDataStore(new AudienceSettingsManagedStoreClient(), paramContext);
      ManagedDataStore localManagedDataStore = a;
      monitorexit;
      return localManagedDataStore;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static AudienceSettings a(Context paramContext, PrivacySetting.Category paramCategory)
  {
    return (AudienceSettings)a(paramContext).a(paramCategory);
  }

  protected static LinkedHashMap<String, FqlQuery> a(Context paramContext, Intent paramIntent, String paramString, long paramLong, PrivacySetting.Category paramCategory)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("privacy_setting", new AudienceSettings.FqlGetPrivacySetting(paramContext, paramIntent, paramString, null, paramCategory));
    localLinkedHashMap.put("friendlists", new FqlGetFriendLists(paramContext, paramIntent, paramString, null, paramLong));
    return localLinkedHashMap;
  }

  protected static void a(Context paramContext, PrivacySetting.Category paramCategory, NetworkRequestCallback<PrivacySetting.Category, AudienceSettings> paramNetworkRequestCallback)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    while (true)
    {
      return;
      FacebookSessionInfo localFacebookSessionInfo = localAppSession.b();
      localAppSession.a(paramContext, new AudienceSettings(paramContext, null, localFacebookSessionInfo.sessionKey, null, localFacebookSessionInfo.userId, paramCategory, paramNetworkRequestCallback), 1001, 1020, null);
    }
  }

  public static void g()
  {
    a = null;
  }

  public void a(PrivacySetting paramPrivacySetting)
  {
    this.b = paramPrivacySetting;
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (paramInt == 200);
    for (boolean bool = true; ; bool = false)
    {
      this.f.a(paramContext, bool, this.g, "", this);
      Iterator localIterator = paramAppSession.d().iterator();
      while (localIterator.hasNext())
        ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this);
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    super.a(paramJsonParser);
    this.b = ((AudienceSettings.FqlGetPrivacySetting)c("privacy_setting")).a;
    this.h = ((FqlGetFriendLists)c("friendlists")).g();
  }

  public boolean a(long paramLong)
  {
    if (this.h != null)
    {
      Iterator localIterator = this.h.iterator();
      do
        if (!localIterator.hasNext())
          break;
      while (((FriendList)localIterator.next()).flid != paramLong);
    }
    for (int i = 1; ; i = 0)
      return i;
  }

  public PrivacySetting h()
  {
    return this.b;
  }

  public List<FriendList> i()
  {
    return this.h;
  }

  public NetworkRequestCallback<PrivacySetting.Category, AudienceSettings> j()
  {
    return this.f;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.AudienceSettings
 * JD-Core Version:    0.6.0
 */