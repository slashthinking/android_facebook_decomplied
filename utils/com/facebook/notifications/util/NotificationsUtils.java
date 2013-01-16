package com.facebook.notifications.util;

import android.content.Context;
import android.os.Bundle;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParams;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParamsBuilder;
import com.facebook.notifications.provider.GQLNotificationsContentProviderHelper;
import com.facebook.notifications.provider.NotificationsContentProviderHelper;
import com.facebook.notifications.server.NotificationsChangeSettingsParams;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;

public class NotificationsUtils
{
  private final Context a;
  private final OrcaServiceOperationFactory b;
  private final NotificationsContentProviderHelper c;
  private final GQLNotificationsContentProviderHelper d;

  public NotificationsUtils(Context paramContext, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, NotificationsContentProviderHelper paramNotificationsContentProviderHelper, GQLNotificationsContentProviderHelper paramGQLNotificationsContentProviderHelper)
  {
    this.a = ((Context)Preconditions.checkNotNull(paramContext));
    this.c = ((NotificationsContentProviderHelper)Preconditions.checkNotNull(paramNotificationsContentProviderHelper));
    this.d = ((GQLNotificationsContentProviderHelper)Preconditions.checkNotNull(paramGQLNotificationsContentProviderHelper));
    this.b = ((OrcaServiceOperationFactory)Preconditions.checkNotNull(paramOrcaServiceOperationFactory));
  }

  public ImmutableList<String> a(long paramLong)
  {
    return this.d.a(paramLong);
  }

  public ListenableFuture<OperationResult> a(long paramLong, boolean paramBoolean)
  {
    FetchGraphQLNotificationsParamsBuilder localFetchGraphQLNotificationsParamsBuilder = new FetchGraphQLNotificationsParamsBuilder().a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).a(paramLong);
    String str = b(paramLong);
    if (StringUtil.a(str))
    {
      localFetchGraphQLNotificationsParamsBuilder.a(10);
      localFetchGraphQLNotificationsParamsBuilder.a(Lists.a(new String[] { "null" }));
    }
    while (true)
    {
      return a(localFetchGraphQLNotificationsParamsBuilder.g(), paramBoolean);
      localFetchGraphQLNotificationsParamsBuilder.a(str);
      localFetchGraphQLNotificationsParamsBuilder.a(a(paramLong));
    }
  }

  public ListenableFuture<OperationResult> a(FetchGraphQLNotificationsParams paramFetchGraphQLNotificationsParams, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("fetchGraphQLNotificationsParams", paramFetchGraphQLNotificationsParams);
    OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = this.b.a("fetch_gql_notifications", localBundle);
    localOrcaServiceOperation.a(paramBoolean);
    return localOrcaServiceOperation.d();
  }

  public ListenableFuture<OperationResult> a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("notificationsChangeSettingsParams", new NotificationsChangeSettingsParams(paramString1, paramString2));
    return this.b.a("notifChangeSetting", localBundle).d();
  }

  public String b(long paramLong)
  {
    return this.d.b(paramLong);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.util.NotificationsUtils
 * JD-Core Version:    0.6.2
 */