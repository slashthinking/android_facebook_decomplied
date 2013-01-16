package com.facebook.notifications.provider;

import android.os.Bundle;
import com.facebook.graphql.model.FeedStory.SeenState;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParams;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsResult;
import com.facebook.notifications.server.GQLNotificationsChangeSeenStateParams;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;

public class GQLNotificationsContentProviderHandler
  implements OrcaServiceHandler.Filter
{
  private final GQLNotificationsContentProviderHelper a;

  public GQLNotificationsContentProviderHandler(GQLNotificationsContentProviderHelper paramGQLNotificationsContentProviderHelper)
  {
    this.a = paramGQLNotificationsContentProviderHelper;
  }

  private void a(OperationParams paramOperationParams)
  {
    GQLNotificationsChangeSeenStateParams localGQLNotificationsChangeSeenStateParams = (GQLNotificationsChangeSeenStateParams)paramOperationParams.b().getParcelable("gqlNotifsUpdateSeenStatePrams");
    this.a.a(localGQLNotificationsChangeSeenStateParams.a(), localGQLNotificationsChangeSeenStateParams.b().name());
  }

  private OperationResult b(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    FetchGraphQLNotificationsParams localFetchGraphQLNotificationsParams = (FetchGraphQLNotificationsParams)paramOperationParams.b().getParcelable("fetchGraphQLNotificationsParams");
    int i;
    FetchGraphQLNotificationsResult localFetchGraphQLNotificationsResult2;
    if (DataFreshnessParam.STALE_DATA_OKAY == localFetchGraphQLNotificationsParams.a())
    {
      i = 1;
      if (i == 0)
        break label113;
      localFetchGraphQLNotificationsResult2 = this.a.a(localFetchGraphQLNotificationsParams);
      if (DataFreshnessResult.NO_DATA == localFetchGraphQLNotificationsResult2.e())
        break label113;
    }
    label113: for (Object localObject = OperationResult.a(localFetchGraphQLNotificationsResult2); ; localObject = null)
    {
      if (localObject == null)
      {
        OperationResult localOperationResult = paramOrcaServiceHandler.a(paramOperationParams);
        if (localOperationResult.c())
        {
          FetchGraphQLNotificationsResult localFetchGraphQLNotificationsResult1 = (FetchGraphQLNotificationsResult)localOperationResult.h();
          this.a.a(localFetchGraphQLNotificationsResult1);
        }
        localObject = localOperationResult;
      }
      return localObject;
      i = 0;
      break;
    }
  }

  public OperationResult a(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = paramOperationParams.a();
    if (str.equals("fetch_gql_notifications"));
    for (OperationResult localOperationResult = b(paramOperationParams, paramOrcaServiceHandler); ; localOperationResult = paramOrcaServiceHandler.a(paramOperationParams))
    {
      return localOperationResult;
      if (str.equals("gqlNotifUpdateSeenState"))
        a(paramOperationParams);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.provider.GQLNotificationsContentProviderHandler
 * JD-Core Version:    0.6.2
 */