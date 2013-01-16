package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.ParcelUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import java.util.List;

public class GraphQLTextWithEntities
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLTextWithEntities> CREATOR = new GraphQLTextWithEntities.1();

  @JsonProperty("aggregated_ranges")
  public final List<GraphQLAggregatedRange> aggregatedRanges;

  @JsonProperty("ranges")
  public final List<GraphQLEntityRange> ranges;

  @JsonProperty("text")
  public final String text;

  protected GraphQLTextWithEntities()
  {
    this.text = null;
    this.ranges = null;
    this.aggregatedRanges = null;
  }

  public GraphQLTextWithEntities(Parcel paramParcel)
  {
    this.text = paramParcel.readString();
    if (ParcelUtil.a(paramParcel))
    {
      this.ranges = Lists.a();
      paramParcel.readTypedList(this.ranges, GraphQLEntityRange.CREATOR);
      if (!ParcelUtil.a(paramParcel))
        break label71;
      this.aggregatedRanges = Lists.a();
      paramParcel.readTypedList(this.aggregatedRanges, GraphQLAggregatedRange.CREATOR);
    }
    while (true)
    {
      return;
      this.ranges = null;
      break;
      label71: this.aggregatedRanges = null;
    }
  }

  public GraphQLTextWithEntities(String paramString)
  {
    this(paramString, null, null);
  }

  public GraphQLTextWithEntities(String paramString, List<GraphQLEntityRange> paramList, List<GraphQLAggregatedRange> paramList1)
  {
    this.text = paramString;
    this.ranges = paramList;
    this.aggregatedRanges = paramList1;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    boolean bool1 = true;
    paramParcel.writeString(this.text);
    boolean bool2;
    if (this.ranges != null)
    {
      bool2 = bool1;
      ParcelUtil.a(paramParcel, bool2);
      if (this.ranges != null)
        paramParcel.writeTypedList(this.ranges);
      if (this.aggregatedRanges == null)
        break label75;
    }
    while (true)
    {
      ParcelUtil.a(paramParcel, bool1);
      if (this.aggregatedRanges != null)
        paramParcel.writeTypedList(this.aggregatedRanges);
      return;
      bool2 = false;
      break;
      label75: bool1 = false;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLTextWithEntities
 * JD-Core Version:    0.6.2
 */