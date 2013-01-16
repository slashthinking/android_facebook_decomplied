package com.facebook.graphql;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class GraphQl$Profile
{
  public static final GraphQlQueryProfileImpl.ProfileGenericField a = new GraphQlQueryProfileImpl.ProfileGenericField("name");

  @Deprecated
  public static final GraphQlQueryProfileImpl.ProfileGenericField b = new GraphQlQueryProfileImpl.ProfileGenericField("pic_square");

  public static GraphQlQueryProfileImpl.ProfileGenericField a(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryProfileImpl.ProfileGenericField("profile_picture", paramGraphQlQueryImage);
  }

  public static GraphQlQueryProfileImpl a(List<? extends GraphQlQueryFieldProfile> paramList)
  {
    return new GraphQlQueryProfileImpl(paramList, null);
  }

  public static GraphQlQueryProfileImpl a(GraphQlQueryFieldProfile[] paramArrayOfGraphQlQueryFieldProfile)
  {
    return new GraphQlQueryProfileImpl(ImmutableList.a(paramArrayOfGraphQlQueryFieldProfile), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Profile
 * JD-Core Version:    0.6.2
 */