package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class GraphQlQueryFriendsWhoLikeConnection extends GraphQlQueryBaseCallable
{
  GraphQlQueryFriendsWhoLikeConnection(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, false);
  }

  public GraphQlQueryFriendsWhoLikeConnection a(List<GraphQlQueryFriendsWhoLikeConnection.FriendsWhoLikeConnectionField> paramList)
  {
    Preconditions.checkState(this.c.isEmpty(), "Can't add fields multiple times");
    return new GraphQlQueryFriendsWhoLikeConnection(this.a, (List)Preconditions.checkNotNull(paramList), this.b);
  }

  public GraphQlQueryFriendsWhoLikeConnection a(GraphQlQueryFriendsWhoLikeConnection.FriendsWhoLikeConnectionField[] paramArrayOfFriendsWhoLikeConnectionField)
  {
    Preconditions.checkState(this.c.isEmpty());
    return a(ImmutableList.a(paramArrayOfFriendsWhoLikeConnectionField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryFriendsWhoLikeConnection
 * JD-Core Version:    0.6.2
 */