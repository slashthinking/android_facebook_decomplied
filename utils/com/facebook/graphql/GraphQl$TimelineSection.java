package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$TimelineSection
{
  public static final GraphQlQueryTimelineSection.TimelineSectionField a = new GraphQlQueryTimelineSection.TimelineSectionField("id");
  public static final GraphQlQueryTimelineSection.TimelineSectionField b = new GraphQlQueryTimelineSection.TimelineSectionField("url.site(mobile)");
  public static final GraphQlQueryTimelineSection.TimelineSectionField c = new GraphQlQueryTimelineSection.TimelineSectionField("label");

  public static GraphQlQueryTimelineSection.TimelineSectionField a(GraphQlQueryTimelineUnitsConnection paramGraphQlQueryTimelineUnitsConnection)
  {
    return new GraphQlQueryTimelineSection.TimelineSectionField("timeline_units", paramGraphQlQueryTimelineUnitsConnection);
  }

  public static GraphQlQueryTimelineSection a(GraphQlQueryTimelineSection.TimelineSectionField[] paramArrayOfTimelineSectionField)
  {
    return new GraphQlQueryTimelineSection(ImmutableList.a(paramArrayOfTimelineSectionField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.TimelineSection
 * JD-Core Version:    0.6.2
 */