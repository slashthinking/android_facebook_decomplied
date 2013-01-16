package com.facebook.notifications.protocol;

import android.os.Bundle;
import com.facebook.notifications.server.FetchNotificationsParams;
import com.facebook.notifications.server.GQLNotificationsChangeSeenStateParams;
import com.facebook.notifications.server.GetNotificationsSettingsParams;
import com.facebook.notifications.server.NotificationsChangeReadParams;
import com.facebook.notifications.server.NotificationsChangeSettingsParams;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import javax.inject.Provider;

public class NotificationsServiceHandler
  implements OrcaServiceHandler
{
  private final Provider<SingleMethodRunner> a;
  private final FetchNotificationsMethod b;
  private final NotificationsChangeReadMethod c;
  private final NotificationsChangeSettingsMethod d;
  private final FetchGraphQLNotificationsMethod e;
  private final GQLNotificationsChangeSeenStateMethod f;
  private final FetchStaleClientNotificationMethod g;
  private final GetNotificationsSettingsMethod h;

  public NotificationsServiceHandler(Provider<SingleMethodRunner> paramProvider, FetchNotificationsMethod paramFetchNotificationsMethod, NotificationsChangeReadMethod paramNotificationsChangeReadMethod, NotificationsChangeSettingsMethod paramNotificationsChangeSettingsMethod, FetchGraphQLNotificationsMethod paramFetchGraphQLNotificationsMethod, FetchStaleClientNotificationMethod paramFetchStaleClientNotificationMethod, GetNotificationsSettingsMethod paramGetNotificationsSettingsMethod, GQLNotificationsChangeSeenStateMethod paramGQLNotificationsChangeSeenStateMethod)
  {
    this.a = paramProvider;
    this.b = paramFetchNotificationsMethod;
    this.c = paramNotificationsChangeReadMethod;
    this.d = paramNotificationsChangeSettingsMethod;
    this.e = paramFetchGraphQLNotificationsMethod;
    this.f = paramGQLNotificationsChangeSeenStateMethod;
    this.g = paramFetchStaleClientNotificationMethod;
    this.h = paramGetNotificationsSettingsMethod;
  }

  private OperationResult a()
  {
    return OperationResult.a((FetchStaleClientNotificationMethod.Result)((SingleMethodRunner)this.a.b()).a(this.g, null));
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    FetchNotificationsParams localFetchNotificationsParams = (FetchNotificationsParams)paramOperationParams.b().getParcelable("fetchNotificationsParams");
    return OperationResult.a((FetchNotificationsResult)((SingleMethodRunner)this.a.b()).a(this.b, localFetchNotificationsParams));
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    NotificationsChangeReadParams localNotificationsChangeReadParams = (NotificationsChangeReadParams)paramOperationParams.b().getParcelable("notificationsMarkReadParams");
    ((SingleMethodRunner)this.a.b()).a(this.c, localNotificationsChangeReadParams);
    return OperationResult.b();
  }

  private OperationResult d(OperationParams paramOperationParams)
  {
    NotificationsChangeSettingsParams localNotificationsChangeSettingsParams = (NotificationsChangeSettingsParams)paramOperationParams.b().getParcelable("notificationsChangeSettingsParams");
    ((SingleMethodRunner)this.a.b()).a(this.d, localNotificationsChangeSettingsParams);
    return OperationResult.b();
  }

  private OperationResult e(OperationParams paramOperationParams)
  {
    FetchGraphQLNotificationsParams localFetchGraphQLNotificationsParams = (FetchGraphQLNotificationsParams)paramOperationParams.b().getParcelable("fetchGraphQLNotificationsParams");
    return OperationResult.a((FetchGraphQLNotificationsResult)((SingleMethodRunner)this.a.b()).a(this.e, localFetchGraphQLNotificationsParams));
  }

  private OperationResult f(OperationParams paramOperationParams)
  {
    GQLNotificationsChangeSeenStateParams localGQLNotificationsChangeSeenStateParams = (GQLNotificationsChangeSeenStateParams)paramOperationParams.b().getParcelable("gqlNotifsUpdateSeenStatePrams");
    ((SingleMethodRunner)this.a.b()).a(this.f, localGQLNotificationsChangeSeenStateParams);
    return OperationResult.b();
  }

  private OperationResult g(OperationParams paramOperationParams)
  {
    GetNotificationsSettingsParams localGetNotificationsSettingsParams = (GetNotificationsSettingsParams)paramOperationParams.b().getParcelable("notificationsGetSettingsParams");
    return OperationResult.a((GetNotificationsSettingsResult)((SingleMethodRunner)this.a.b()).a(this.h, localGetNotificationsSettingsParams));
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    OperationResult localOperationResult;
    if ("fetch_notifications".equals(str))
      localOperationResult = b(paramOperationParams);
    while (true)
    {
      return localOperationResult;
      if ("notifMarkRead".equals(str))
      {
        localOperationResult = c(paramOperationParams);
      }
      else if ("notifChangeSetting".equals(str))
      {
        localOperationResult = d(paramOperationParams);
      }
      else if ("fetch_gql_notifications".equals(str))
      {
        localOperationResult = e(paramOperationParams);
      }
      else if ("gqlNotifUpdateSeenState".equals(str))
      {
        localOperationResult = f(paramOperationParams);
      }
      else if ("fetchStaleClientNotification".equals(str))
      {
        localOperationResult = a();
      }
      else
      {
        if (!"getNotificationsSettings".equals(str))
          break;
        localOperationResult = g(paramOperationParams);
      }
    }
    throw new Exception("Unknown operation type");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.NotificationsServiceHandler
 * JD-Core Version:    0.6.2
 */