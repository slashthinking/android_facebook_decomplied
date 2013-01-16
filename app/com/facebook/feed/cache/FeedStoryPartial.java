package com.facebook.feed.cache;

import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;

public class FeedStoryPartial extends FeedUnitPartial
{
  public static final String a = GraphQLObjectType.ObjectType.Story.toString();
  public final boolean b;

  public FeedStoryPartial(FeedStoryPartial.Builder paramBuilder)
  {
    super(FeedStoryPartial.Builder.a(paramBuilder), FeedStoryPartial.Builder.b(paramBuilder));
    this.b = FeedStoryPartial.Builder.c(paramBuilder);
  }

  public FeedUnitPartial a(FeedUnitPartial paramFeedUnitPartial)
  {
    Object localObject;
    if (!(paramFeedUnitPartial instanceof FeedStoryPartial))
    {
      localObject = super.a(paramFeedUnitPartial);
      return localObject;
    }
    FeedStoryPartial.Builder localBuilder = new FeedStoryPartial.Builder();
    if (paramFeedUnitPartial.d > this.d)
    {
      localBuilder.a((FeedStoryPartial)paramFeedUnitPartial);
      label46: if ((!this.b) && (!((FeedStoryPartial)paramFeedUnitPartial).b))
        break label89;
    }
    label89: for (boolean bool = true; ; bool = false)
    {
      localObject = localBuilder.a(bool).a();
      break;
      localBuilder.a(this);
      break label46;
    }
  }

  public FeedStory a(FeedStory paramFeedStory)
  {
    if (paramFeedStory == null)
      paramFeedStory = null;
    while (true)
    {
      return paramFeedStory;
      if (paramFeedStory.getFetchTimeMs() > this.d)
      {
        if (!this.b)
          continue;
        paramFeedStory.y();
        continue;
      }
      paramFeedStory = new FeedStoryBuilder(paramFeedStory).a(this.b).b(this.d).G();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedStoryPartial
 * JD-Core Version:    0.6.0
 */