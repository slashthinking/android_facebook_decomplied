package com.facebook.feed.module;

import android.content.Context;
import com.facebook.feed.data.NewsFeedJsonParserInitializer;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class NewsFeedModule$NewsFeedJsonParserInitializerProvider extends AbstractProvider<NewsFeedJsonParserInitializer>
{
  private NewsFeedModule$NewsFeedJsonParserInitializerProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedJsonParserInitializer a()
  {
    return new NewsFeedJsonParserInitializer((Context)b(Context.class, FromApplication.class), (ObjectMapper)b(ObjectMapper.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedJsonParserInitializerProvider
 * JD-Core Version:    0.6.0
 */