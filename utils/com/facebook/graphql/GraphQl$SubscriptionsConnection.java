package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$SubscriptionsConnection
{
  public static final GraphQlQuerySubscriptionsConnection.SubscriptionsConnectionField a = new GraphQlQuerySubscriptionsConnection.SubscriptionsConnectionField("count");

  public static GraphQlQueryCallFirst1 a(long paramLong)
  {
    return new GraphQlQueryCallFirst1(paramLong);
  }

  public static GraphQlQuerySubscriptionsConnection.SubscriptionsConnectionField a(GraphQlQueryProfile paramGraphQlQueryProfile)
  {
    return new GraphQlQuerySubscriptionsConnection.SubscriptionsConnectionField("nodes", paramGraphQlQueryProfile);
  }

  public static GraphQlQuerySubscriptionsConnection a(GraphQlQuerySubscriptionsConnection.CallOnSubscriptionsConnection[] paramArrayOfCallOnSubscriptionsConnection)
  {
    return new GraphQlQuerySubscriptionsConnection(ImmutableList.a(paramArrayOfCallOnSubscriptionsConnection), null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.SubscriptionsConnection
 * JD-Core Version:    0.6.2
 */