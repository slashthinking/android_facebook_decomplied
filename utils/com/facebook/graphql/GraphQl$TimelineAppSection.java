package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$TimelineAppSection
{
  public static final GraphQlQueryTimelineAppSection.TimelineAppSectionField a = new GraphQlQueryTimelineAppSection.TimelineAppSectionField("id");
  public static final GraphQlQueryTimelineAppSection.TimelineAppSectionField b = new GraphQlQueryTimelineAppSection.TimelineAppSectionField("url.site(mobile)");
  public static final GraphQlQueryTimelineAppSection.TimelineAppSectionField c = new GraphQlQueryTimelineAppSection.TimelineAppSectionField("name");
  public static final GraphQlQueryTimelineAppSection.TimelineAppSectionField d = new GraphQlQueryTimelineAppSection.TimelineAppSectionField("section_type");

  public static GraphQlQueryTimelineAppSection.TimelineAppSectionField a(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryTimelineAppSection.TimelineAppSectionField("logo", paramGraphQlQueryImage);
  }

  public static GraphQlQueryTimelineAppSection a(GraphQlQueryTimelineAppSection.TimelineAppSectionField[] paramArrayOfTimelineAppSectionField)
  {
    return new GraphQlQueryTimelineAppSection(ImmutableList.a(paramArrayOfTimelineAppSectionField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.TimelineAppSection
 * JD-Core Version:    0.6.2
 */