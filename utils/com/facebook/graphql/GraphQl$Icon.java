package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Icon
{
  public static final GraphQlQueryIcon.IconField a = new GraphQlQueryIcon.IconField("name");
  public static final GraphQlQueryIcon.IconField b = new GraphQlQueryIcon.IconField("uri");
  public static final GraphQlQueryIcon.IconField c = new GraphQlQueryIcon.IconField("width");
  public static final GraphQlQueryIcon.IconField d = new GraphQlQueryIcon.IconField("height");
  public static final GraphQlQueryIcon.IconField e = new GraphQlQueryIcon.IconField("scale");

  public static GraphQlQueryCallScale1 a(String paramString)
  {
    return new GraphQlQueryCallScale1(paramString);
  }

  public static GraphQlQueryIcon a(GraphQlQueryIcon.CallOnIcon[] paramArrayOfCallOnIcon)
  {
    return new GraphQlQueryIcon(ImmutableList.a(paramArrayOfCallOnIcon), null, null);
  }

  public static GraphQlQueryIcon a(GraphQlQueryIcon.IconField[] paramArrayOfIconField)
  {
    return new GraphQlQueryIcon(null, ImmutableList.a(paramArrayOfIconField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Icon
 * JD-Core Version:    0.6.2
 */