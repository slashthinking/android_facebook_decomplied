package com.facebook.feed.protocol;

import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.LifeEventUnit;
import com.facebook.graphql.GraphQl.Story;
import com.facebook.graphql.GraphQl.StoryInsights;
import com.facebook.graphql.GraphQl.TimelineSection;
import com.facebook.graphql.GraphQl.TimelineUnitsConnection;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryFeedUnitImpl;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.GraphQlQueryStoryInsights.StoryInsightsField;
import com.facebook.graphql.GraphQlQueryTimelineSection;
import com.facebook.graphql.GraphQlQueryTimelineSection.TimelineSectionField;
import com.facebook.graphql.GraphQlQueryTimelineUnitsConnection;
import com.facebook.graphql.GraphQlQueryTimelineUnitsConnection.CallOnTimelineUnitsConnection;
import com.facebook.graphql.GraphQlQueryTimelineUnitsConnection.TimelineUnitsConnectionField;
import com.facebook.graphql.GraphQlUtil;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.common.GraphQlNewsFeedDefaults;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.TimelineSection;
import com.facebook.graphql.model.TimelineUnitCollection;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.List;

public class FetchTimelineSectionMethod
  implements ApiMethod<FetchTimelineSectionParams, TimelineSection>
{
  public static final GraphQlQueryParam a = GraphQlQueryParam.a("nodeId");
  public static final GraphQlQueryParam b = GraphQlQueryParam.a("timeline_section_after");
  public static final GraphQlQueryParam c = GraphQlQueryParam.a("timeline_filter");
  private static final GraphQlQueryFeedUnitImpl f = ((GraphQlQueryFeedUnitImpl)GraphQlNewsFeedDefaults.C.get(2)).a(GraphQl.Story.e).a(GraphQl.Story.a(GraphQlQueryDefaults.m)).a(GraphQl.LifeEventUnit.a(GraphQlQueryDefaults.h)).a(GraphQl.LifeEventUnit.a(GraphQlQueryDefaults.a)).a(GraphQl.LifeEventUnit.b(GraphQlQueryDefaults.a)).a(GraphQl.LifeEventUnit.a(GraphQlQueryDefaults.p)).a(GraphQl.Story.j);
  private static final GraphQlQueryFeedUnitImpl g;
  private final GraphQLStoryHelper d;
  private final GraphQLHelper e;

  static
  {
    GraphQlQueryFeedUnitImpl localGraphQlQueryFeedUnitImpl = ((GraphQlQueryFeedUnitImpl)GraphQlNewsFeedDefaults.C.get(2)).a(GraphQl.Story.e).a(GraphQl.Story.a(GraphQlQueryDefaults.m)).a(GraphQl.LifeEventUnit.a(GraphQlQueryDefaults.h)).a(GraphQl.LifeEventUnit.a(GraphQlQueryDefaults.a)).a(GraphQl.LifeEventUnit.b(GraphQlQueryDefaults.a)).a(GraphQl.LifeEventUnit.a(GraphQlQueryDefaults.p)).a(GraphQl.Story.j);
    GraphQlQueryStoryInsights.StoryInsightsField[] arrayOfStoryInsightsField = new GraphQlQueryStoryInsights.StoryInsightsField[1];
    arrayOfStoryInsightsField[0] = GraphQl.StoryInsights.a;
    g = localGraphQlQueryFeedUnitImpl.a(GraphQl.Story.a(GraphQl.StoryInsights.a(arrayOfStoryInsightsField)));
  }

  public FetchTimelineSectionMethod(GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper)
  {
    this.d = paramGraphQLStoryHelper;
    this.e = paramGraphQLHelper;
  }

  public static GraphQlQueryTimelineSection a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (GraphQlQueryFeedUnitImpl localGraphQlQueryFeedUnitImpl = g; ; localGraphQlQueryFeedUnitImpl = f)
    {
      GraphQlQueryTimelineSection.TimelineSectionField[] arrayOfTimelineSectionField = new GraphQlQueryTimelineSection.TimelineSectionField[3];
      arrayOfTimelineSectionField[0] = GraphQl.TimelineSection.a;
      arrayOfTimelineSectionField[1] = GraphQl.TimelineSection.c;
      GraphQlQueryTimelineUnitsConnection.CallOnTimelineUnitsConnection[] arrayOfCallOnTimelineUnitsConnection = new GraphQlQueryTimelineUnitsConnection.CallOnTimelineUnitsConnection[3];
      arrayOfCallOnTimelineUnitsConnection[0] = GraphQl.TimelineUnitsConnection.b(c);
      arrayOfCallOnTimelineUnitsConnection[1] = GraphQl.TimelineUnitsConnection.a(b);
      arrayOfCallOnTimelineUnitsConnection[2] = GraphQl.TimelineUnitsConnection.a(8L);
      GraphQlQueryTimelineUnitsConnection localGraphQlQueryTimelineUnitsConnection = GraphQl.TimelineUnitsConnection.a(arrayOfCallOnTimelineUnitsConnection);
      GraphQlQueryTimelineUnitsConnection.TimelineUnitsConnectionField[] arrayOfTimelineUnitsConnectionField = new GraphQlQueryTimelineUnitsConnection.TimelineUnitsConnectionField[3];
      arrayOfTimelineUnitsConnectionField[0] = GraphQl.TimelineUnitsConnection.a;
      arrayOfTimelineUnitsConnectionField[1] = GraphQl.TimelineUnitsConnection.a(GraphQlQueryDefaults.k);
      arrayOfTimelineUnitsConnectionField[2] = GraphQl.TimelineUnitsConnection.a(localGraphQlQueryFeedUnitImpl);
      arrayOfTimelineSectionField[2] = GraphQl.TimelineSection.a(localGraphQlQueryTimelineUnitsConnection.a(arrayOfTimelineUnitsConnectionField));
      return GraphQl.TimelineSection.a(arrayOfTimelineSectionField);
    }
  }

  public static void a(TimelineSection paramTimelineSection)
  {
    if ((paramTimelineSection != null) && (paramTimelineSection.units != null) && (paramTimelineSection.units.units != null))
    {
      long l = System.currentTimeMillis();
      Iterator localIterator = paramTimelineSection.units.units.iterator();
      while (localIterator.hasNext())
        ((FeedUnit)localIterator.next()).setFetchTimeMs(l);
    }
  }

  private String b(FetchTimelineSectionParams paramFetchTimelineSectionParams)
  {
    ImmutableMap localImmutableMap = ImmutableMap.a(GraphQlQueryDefaults.e, this.d.a(), a, paramFetchTimelineSectionParams.a(), b, GraphQlUtil.b(paramFetchTimelineSectionParams.b()), c, GraphQlUtil.c(paramFetchTimelineSectionParams.d()));
    return GraphQl.a(a).a(a(paramFetchTimelineSectionParams.c())).a(localImmutableMap);
  }

  public TimelineSection a(FetchTimelineSectionParams paramFetchTimelineSectionParams, ApiResponse paramApiResponse)
  {
    JsonParser localJsonParser = this.e.a("fetch_timeline_section", 1, paramApiResponse.d());
    TimelineSection localTimelineSection = (TimelineSection)((ObjectMapper)localJsonParser.getCodec()).readValue(localJsonParser, TimelineSection.class);
    if (localTimelineSection == null)
      throw new Exception("Invalid JSON result");
    a(localTimelineSection);
    return localTimelineSection;
  }

  public ApiRequest a(FetchTimelineSectionParams paramFetchTimelineSectionParams)
  {
    return this.e.a("fetch_timeline_section", b(paramFetchTimelineSectionParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchTimelineSectionMethod
 * JD-Core Version:    0.6.0
 */