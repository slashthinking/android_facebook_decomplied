package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$BylineFragment
{

  @Deprecated
  public static final GraphQlQueryBylineFragment.BylineFragmentField a = new GraphQlQueryBylineFragment.BylineFragmentField("type");

  public static GraphQlQueryBylineFragment.BylineFragmentField a(GraphQlQueryIcon paramGraphQlQueryIcon)
  {
    return new GraphQlQueryBylineFragment.BylineFragmentField("icon", paramGraphQlQueryIcon);
  }

  public static GraphQlQueryBylineFragment.BylineFragmentField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryBylineFragment.BylineFragmentField("text", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryBylineFragment a(GraphQlQueryBylineFragment.BylineFragmentField[] paramArrayOfBylineFragmentField)
  {
    return new GraphQlQueryBylineFragment(ImmutableList.a(paramArrayOfBylineFragmentField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.BylineFragment
 * JD-Core Version:    0.6.2
 */