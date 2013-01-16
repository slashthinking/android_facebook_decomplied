package com.facebook.contacts.graphql;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.List;

public class GraphQLQueryFieldCall
{
  private String a;
  private Object[] b;

  public GraphQLQueryFieldCall(String paramString, Object[] paramArrayOfObject)
  {
    if (!Arrays.asList(paramArrayOfObject).contains(null));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.a = paramString;
      this.b = paramArrayOfObject;
      return;
    }
  }

  public String a()
  {
    return this.a;
  }

  public Object[] b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.graphql.GraphQLQueryFieldCall
 * JD-Core Version:    0.6.0
 */