package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$ReportInfo
{
  public static final GraphQlQueryReportInfo.ReportInfoField a = new GraphQlQueryReportInfo.ReportInfoField("action");
  public static final GraphQlQueryReportInfo.ReportInfoField b = new GraphQlQueryReportInfo.ReportInfoField("undo_action");

  public static GraphQlQueryReportInfo a(GraphQlQueryReportInfo.ReportInfoField[] paramArrayOfReportInfoField)
  {
    return new GraphQlQueryReportInfo(ImmutableList.a(paramArrayOfReportInfoField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.ReportInfo
 * JD-Core Version:    0.6.2
 */