package com.facebook.graphql;

import com.google.common.base.Preconditions;
import java.util.List;

public final class GraphQlQueryVect2 extends GraphQlQueryBaseObjectImpl
{
  GraphQlQueryVect2(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, false);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryVect2
 * JD-Core Version:    0.6.2
 */