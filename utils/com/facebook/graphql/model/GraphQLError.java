package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class GraphQLError
  implements Parcelable
{
  public static Parcelable.Creator<GraphQLError> CREATOR = new GraphQLError.1();

  @JsonProperty("code")
  public final int code;

  @JsonProperty("debug_info")
  public final String debugInfo;

  @JsonProperty("description")
  public final String description;

  @JsonProperty("is_silent")
  public final boolean isSilent;

  @JsonProperty("is_transient")
  public final boolean isTransient;

  @JsonProperty("query_path")
  public final String queryPath;

  @JsonProperty("requires_reauth")
  public final boolean requiresReauth;

  @JsonProperty("summary")
  public final String summary;

  protected GraphQLError()
  {
    this.code = -1;
    this.summary = null;
    this.description = null;
    this.isSilent = false;
    this.isTransient = false;
    this.requiresReauth = false;
    this.debugInfo = null;
    this.queryPath = null;
  }

  private GraphQLError(Parcel paramParcel)
  {
    this.code = paramParcel.readInt();
    this.summary = paramParcel.readString();
    this.description = paramParcel.readString();
    this.isSilent = a(paramParcel.readInt());
    this.isTransient = a(paramParcel.readInt());
    this.requiresReauth = a(paramParcel.readInt());
    this.debugInfo = paramParcel.readString();
    this.queryPath = paramParcel.readString();
  }

  private static int a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
      return i;
  }

  private static boolean a(int paramInt)
  {
    int i = 1;
    if (paramInt == i);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return Objects.toStringHelper(GraphQLError.class).add("code", Integer.valueOf(this.code)).add("summary", this.summary).add("description", this.description).add("is_silent", Boolean.valueOf(this.isSilent)).add("requires_reauth", Boolean.valueOf(this.requiresReauth)).add("debug_info", this.debugInfo).add("query_path", this.queryPath).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.code);
    paramParcel.writeString(this.summary);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(a(this.isSilent));
    paramParcel.writeInt(a(this.isTransient));
    paramParcel.writeInt(a(this.requiresReauth));
    paramParcel.writeString(this.debugInfo);
    paramParcel.writeString(this.queryPath);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLError
 * JD-Core Version:    0.6.2
 */