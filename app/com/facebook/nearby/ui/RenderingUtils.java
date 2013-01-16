package com.facebook.nearby.ui;

import com.facebook.graphql.model.GraphQLAddress;
import com.facebook.orca.common.util.StringUtil;
import java.util.List;

public class RenderingUtils
{
  public static String a(List<String> paramList, GraphQLAddress paramGraphQLAddress)
  {
    String str1 = "";
    if ((paramList != null) && (!paramList.isEmpty()))
      str1 = (String)paramList.get(0);
    String str2;
    if (paramGraphQLAddress != null)
      if (!StringUtil.a(paramGraphQLAddress.street))
        str2 = paramGraphQLAddress.street;
    while (true)
    {
      if (StringUtil.a(str1));
      while (true)
      {
        return str2;
        if (StringUtil.a(paramGraphQLAddress.city))
          break label112;
        str2 = paramGraphQLAddress.city;
        break;
        if (StringUtil.a(str2))
        {
          str2 = str1;
          continue;
        }
        str2 = str1 + " · " + str2;
      }
      label112: str2 = "";
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.ui.RenderingUtils
 * JD-Core Version:    0.6.0
 */