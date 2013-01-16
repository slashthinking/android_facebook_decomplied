package com.facebook.graphql.common;

import android.os.Parcelable;
import com.facebook.graphql.model.GraphQLError;
import com.facebook.orca.common.base.ExceptionWithExtraData;

public class GraphQLException extends Exception
  implements ExceptionWithExtraData
{
  public final GraphQLError error;

  GraphQLException(GraphQLError paramGraphQLError)
  {
    super(paramGraphQLError.description);
    this.error = paramGraphQLError;
  }

  public Parcelable a()
  {
    return this.error;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.common.GraphQLException
 * JD-Core Version:    0.6.2
 */