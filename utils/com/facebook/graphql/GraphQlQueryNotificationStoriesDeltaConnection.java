package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class GraphQlQueryNotificationStoriesDeltaConnection extends GraphQlQueryBaseCallable
{
  GraphQlQueryNotificationStoriesDeltaConnection(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, false);
  }

  public GraphQlQueryNotificationStoriesDeltaConnection a(List<GraphQlQueryNotificationStoriesDeltaConnection.NotificationStoriesDeltaConnectionField> paramList)
  {
    Preconditions.checkState(this.c.isEmpty(), "Can't add fields multiple times");
    return new GraphQlQueryNotificationStoriesDeltaConnection(this.a, (List)Preconditions.checkNotNull(paramList), this.b);
  }

  public GraphQlQueryNotificationStoriesDeltaConnection a(GraphQlQueryNotificationStoriesDeltaConnection.NotificationStoriesDeltaConnectionField[] paramArrayOfNotificationStoriesDeltaConnectionField)
  {
    Preconditions.checkState(this.c.isEmpty());
    return a(ImmutableList.a(paramArrayOfNotificationStoriesDeltaConnectionField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryNotificationStoriesDeltaConnection
 * JD-Core Version:    0.6.2
 */