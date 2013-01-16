package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$TimelineNavAppSectionsConnection
{
  public static final GraphQlQueryTimelineNavAppSectionsConnection.TimelineNavAppSectionsConnectionField a = new GraphQlQueryTimelineNavAppSectionsConnection.TimelineNavAppSectionsConnectionField("count");

  public static GraphQlQueryTimelineNavAppSectionsConnection.TimelineNavAppSectionsConnectionField a(GraphQlQueryTimelineAppSection paramGraphQlQueryTimelineAppSection)
  {
    return new GraphQlQueryTimelineNavAppSectionsConnection.TimelineNavAppSectionsConnectionField("nodes", paramGraphQlQueryTimelineAppSection);
  }

  public static GraphQlQueryTimelineNavAppSectionsConnection a(GraphQlQueryTimelineNavAppSectionsConnection.TimelineNavAppSectionsConnectionField[] paramArrayOfTimelineNavAppSectionsConnectionField)
  {
    return new GraphQlQueryTimelineNavAppSectionsConnection(null, ImmutableList.a(paramArrayOfTimelineNavAppSectionsConnectionField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.TimelineNavAppSectionsConnection
 * JD-Core Version:    0.6.2
 */