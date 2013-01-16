package com.facebook.megaphone.module;

import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.megaphone.api.FetchMegaphoneMethod;
import com.facebook.orca.inject.AbstractProvider;

class MegaphoneModule$FetchMegaphoneMethodProvider extends AbstractProvider<FetchMegaphoneMethod>
{
  private MegaphoneModule$FetchMegaphoneMethodProvider(MegaphoneModule paramMegaphoneModule)
  {
  }

  public FetchMegaphoneMethod a()
  {
    return new FetchMegaphoneMethod((GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.module.MegaphoneModule.FetchMegaphoneMethodProvider
 * JD-Core Version:    0.6.2
 */