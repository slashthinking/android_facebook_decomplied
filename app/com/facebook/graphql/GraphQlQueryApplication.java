package com.facebook.graphql;

import com.google.common.base.Preconditions;
import java.util.List;

public final class GraphQlQueryApplication extends GraphQlQueryBaseObjectImpl
  implements GraphQlQueryEntity, GraphQlQueryNode, GraphQlQueryProfile
{
  GraphQlQueryApplication(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryApplication
 * JD-Core Version:    0.6.0
 */