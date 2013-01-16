package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FeedStorySponsoredData
  implements Parcelable
{
  public static final Parcelable.Creator<FeedStorySponsoredData> CREATOR = new FeedStorySponsoredData.1();

  @JsonProperty("id")
  public final String id;

  @JsonProperty("impression_logging_url")
  public final String impressionLoggingUrl;

  @JsonProperty("is_non_connected_page_post")
  private final boolean isNonConnectedPagePost;

  @JsonProperty("third_party_click_tracking_url")
  public final String thirdPartyClickTrackingUrl;

  @JsonProperty("third_party_impression_logging_urls")
  public final List<String> thirdPartyLoggingUrls;

  @JsonProperty("user")
  public final GraphQLProfile user;

  protected FeedStorySponsoredData()
  {
    this.id = null;
    this.user = null;
    this.impressionLoggingUrl = null;
    this.thirdPartyClickTrackingUrl = null;
    this.thirdPartyLoggingUrls = null;
    this.isNonConnectedPagePost = false;
  }

  private FeedStorySponsoredData(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.user = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
    this.impressionLoggingUrl = paramParcel.readString();
    this.thirdPartyClickTrackingUrl = paramParcel.readString();
    this.thirdPartyLoggingUrls = paramParcel.createStringArrayList();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.isNonConnectedPagePost = bool;
      return;
    }
  }

  public void a(List<String> paramList)
  {
    if (paramList == null);
    while (true)
    {
      return;
      if (this.impressionLoggingUrl != null)
        paramList.add(this.impressionLoggingUrl);
      if (this.thirdPartyLoggingUrls != null)
        paramList.addAll(this.thirdPartyLoggingUrls);
    }
  }

  public boolean a()
  {
    return this.isNonConnectedPagePost;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.user, paramInt);
    paramParcel.writeString(this.impressionLoggingUrl);
    paramParcel.writeString(this.thirdPartyClickTrackingUrl);
    paramParcel.writeStringList(this.thirdPartyLoggingUrls);
    if (this.isNonConnectedPagePost);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStorySponsoredData
 * JD-Core Version:    0.6.2
 */