package com.facebook.appcenter.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfileList;
import com.facebook.graphql.model.GraphQLText;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import java.util.List;

public class AppDetail
  implements Parcelable
{
  public static final Parcelable.Creator<AppDetail> CREATOR = new AppDetail.1();

  @JsonProperty("activity_suggested_privacy")
  public final String activitySuggestedPrivacy;

  @JsonProperty("android_store_url")
  public final String androidStoreUrl;

  @JsonProperty("app_center_categories")
  public final List<String> appCenterCategories;

  @JsonProperty("app_center_permission_summary")
  public AppCenterPermissionSummary appCenterPermissionSummary;

  @JsonProperty("average_star_rating")
  public final double averageStarRating;

  @JsonProperty("banner_logo")
  public final List<GraphQLImage> bannerLogo;

  @JsonProperty("detailed_description")
  public final String detailedDescription;

  @JsonProperty("friends_who_recently_used")
  public final GraphQLProfileList friendsWhoRecentlyUsed;

  @JsonProperty("global_usage_summary_sentence")
  public final GraphQLText globalUsageSummarySentence;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("is_facebook_app")
  public final boolean isFacebookApp;

  @JsonProperty("is_game")
  public final boolean isGame;

  @JsonProperty("mobile_canvas_url")
  public final String mobileCanvasUrl;

  @JsonProperty("name")
  public final String name;

  @JsonProperty("pic_square")
  public final String picSquare;

  @JsonProperty("privacy_url")
  public final String privacyUrl;

  @JsonProperty("screenshots_android")
  public final List<GraphQLImage> screenshotsAndroid;

  @JsonProperty("screenshots_mobile_web")
  public final List<GraphQLImage> screenshotsMobileWeb;

  @JsonProperty("short_description")
  public final String shortDescription;

  @JsonProperty("similar_applications")
  public final GraphQLNodes<SimilarAppDetail> similarApplications;

  @JsonProperty("similarApplicationsDetailList")
  public final List<SimilarAppDetail> similarApplicationsDetailList;

  @JsonProperty("square_logo")
  public final GraphQLImage square_logo;

  @JsonProperty("terms_of_service_url")
  public final String termsOfServiceUrl;

  @JsonProperty("url")
  public final String url;

  @JsonProperty("viewer_has_authorized")
  public final boolean viewerHasAuthorized;

  protected AppDetail()
  {
    this.activitySuggestedPrivacy = "";
    this.androidStoreUrl = "";
    this.appCenterCategories = null;
    this.appCenterPermissionSummary = new AppCenterPermissionSummary();
    this.averageStarRating = 0.0D;
    this.bannerLogo = null;
    this.detailedDescription = "";
    this.friendsWhoRecentlyUsed = null;
    this.globalUsageSummarySentence = null;
    this.id = "";
    this.isFacebookApp = false;
    this.isGame = false;
    this.mobileCanvasUrl = "";
    this.name = "";
    this.picSquare = "";
    this.privacyUrl = "";
    this.screenshotsAndroid = null;
    this.screenshotsMobileWeb = null;
    this.similarApplications = null;
    this.similarApplicationsDetailList = null;
    this.square_logo = null;
    this.shortDescription = "";
    this.termsOfServiceUrl = "";
    this.url = "";
    this.viewerHasAuthorized = false;
  }

  public AppDetail(Parcel paramParcel)
  {
    this.activitySuggestedPrivacy = paramParcel.readString();
    this.androidStoreUrl = paramParcel.readString();
    this.appCenterCategories = paramParcel.readArrayList(String.class.getClassLoader());
    this.appCenterPermissionSummary = ((AppCenterPermissionSummary)paramParcel.readParcelable(AppCenterPermissionSummary.class.getClassLoader()));
    this.averageStarRating = paramParcel.readDouble();
    this.bannerLogo = paramParcel.readArrayList(GraphQLImage.class.getClassLoader());
    this.detailedDescription = paramParcel.readString();
    this.friendsWhoRecentlyUsed = ((GraphQLProfileList)paramParcel.readParcelable(GraphQLProfileList.class.getClassLoader()));
    this.globalUsageSummarySentence = ((GraphQLText)paramParcel.readParcelable(GraphQLText.class.getClassLoader()));
    this.id = paramParcel.readString();
    int j;
    int k;
    if (paramParcel.readInt() == i)
    {
      j = i;
      this.isFacebookApp = j;
      if (paramParcel.readInt() != i)
        break label298;
      k = i;
      label146: this.isGame = k;
      this.mobileCanvasUrl = paramParcel.readString();
      this.name = paramParcel.readString();
      this.picSquare = paramParcel.readString();
      this.privacyUrl = paramParcel.readString();
      this.screenshotsAndroid = paramParcel.readArrayList(GraphQLImage.class.getClassLoader());
      this.screenshotsMobileWeb = paramParcel.readArrayList(GraphQLImage.class.getClassLoader());
      this.similarApplications = ((GraphQLNodes)paramParcel.readParcelable(GraphQLNodes.class.getClassLoader()));
      this.similarApplicationsDetailList = paramParcel.readArrayList(SimilarAppDetail.class.getClassLoader());
      this.shortDescription = paramParcel.readString();
      this.square_logo = ((GraphQLImage)paramParcel.readParcelable(GraphQLImage.class.getClassLoader()));
      this.termsOfServiceUrl = paramParcel.readString();
      this.url = paramParcel.readString();
      if (paramParcel.readInt() != i)
        break label304;
    }
    while (true)
    {
      this.viewerHasAuthorized = i;
      return;
      j = 0;
      break;
      label298: k = 0;
      break label146;
      label304: i = 0;
    }
  }

  public List<SimilarAppDetail> a()
  {
    List localList;
    if (this.similarApplications != null)
      localList = this.similarApplications.a();
    while (true)
    {
      return localList;
      if (this.similarApplicationsDetailList != null)
      {
        localList = this.similarApplicationsDetailList;
        continue;
      }
      localList = null;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (!(paramObject instanceof AppDetail)))
      {
        i = 0;
        continue;
      }
      AppDetail localAppDetail = (AppDetail)paramObject;
      if ((Objects.equal(this.activitySuggestedPrivacy, localAppDetail.activitySuggestedPrivacy)) && (Objects.equal(this.androidStoreUrl, localAppDetail.androidStoreUrl)) && (Objects.equal(this.appCenterCategories, localAppDetail.appCenterCategories)) && (Objects.equal(this.appCenterPermissionSummary, localAppDetail.appCenterPermissionSummary)) && (Objects.equal(Double.valueOf(this.averageStarRating), Double.valueOf(localAppDetail.averageStarRating))) && (Objects.equal(this.bannerLogo, localAppDetail.bannerLogo)) && (Objects.equal(this.detailedDescription, localAppDetail.detailedDescription)) && (Objects.equal(this.friendsWhoRecentlyUsed, localAppDetail.friendsWhoRecentlyUsed)) && (Objects.equal(this.globalUsageSummarySentence, localAppDetail.globalUsageSummarySentence)) && (Objects.equal(this.id, localAppDetail.id)) && (Objects.equal(Boolean.valueOf(this.isFacebookApp), Boolean.valueOf(localAppDetail.isFacebookApp))) && (Objects.equal(Boolean.valueOf(this.isGame), Boolean.valueOf(localAppDetail.isGame))) && (Objects.equal(this.mobileCanvasUrl, localAppDetail.mobileCanvasUrl)) && (Objects.equal(this.name, localAppDetail.name)) && (Objects.equal(this.picSquare, localAppDetail.picSquare)) && (Objects.equal(this.privacyUrl, localAppDetail.privacyUrl)) && (Objects.equal(this.screenshotsAndroid, localAppDetail.screenshotsAndroid)) && (Objects.equal(this.screenshotsMobileWeb, localAppDetail.screenshotsMobileWeb)) && (Objects.equal(this.similarApplications, localAppDetail.similarApplications)) && (Objects.equal(this.similarApplicationsDetailList, localAppDetail.similarApplicationsDetailList)) && (Objects.equal(this.shortDescription, localAppDetail.shortDescription)) && (Objects.equal(this.square_logo, localAppDetail.square_logo)) && (Objects.equal(this.termsOfServiceUrl, localAppDetail.termsOfServiceUrl)) && (Objects.equal(this.url, localAppDetail.url)) && (Objects.equal(Boolean.valueOf(this.viewerHasAuthorized), Boolean.valueOf(localAppDetail.viewerHasAuthorized))))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[24];
    arrayOfObject[0] = this.activitySuggestedPrivacy;
    arrayOfObject[1] = this.androidStoreUrl;
    arrayOfObject[2] = this.appCenterCategories;
    arrayOfObject[3] = this.appCenterPermissionSummary;
    arrayOfObject[4] = Double.valueOf(this.averageStarRating);
    arrayOfObject[5] = this.bannerLogo;
    arrayOfObject[6] = this.detailedDescription;
    arrayOfObject[7] = this.friendsWhoRecentlyUsed;
    arrayOfObject[8] = this.globalUsageSummarySentence;
    arrayOfObject[9] = this.id;
    arrayOfObject[10] = Boolean.valueOf(this.isFacebookApp);
    arrayOfObject[11] = Boolean.valueOf(this.isGame);
    arrayOfObject[12] = this.mobileCanvasUrl;
    arrayOfObject[13] = this.name;
    arrayOfObject[14] = this.picSquare;
    arrayOfObject[15] = this.privacyUrl;
    arrayOfObject[16] = this.screenshotsAndroid;
    arrayOfObject[17] = this.screenshotsMobileWeb;
    arrayOfObject[18] = this.similarApplications;
    arrayOfObject[19] = this.similarApplicationsDetailList;
    arrayOfObject[20] = this.shortDescription;
    arrayOfObject[21] = this.square_logo;
    arrayOfObject[22] = this.termsOfServiceUrl;
    arrayOfObject[23] = this.url;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return " activity_suggested_privacy : " + this.activitySuggestedPrivacy + " android_store_url : " + this.androidStoreUrl + " app_center_categories : " + this.appCenterCategories + " app_center_permission_summary : " + this.appCenterPermissionSummary + " average_star_rating : " + this.averageStarRating + " bannerLogo : " + this.bannerLogo + " detailed description : " + this.detailedDescription + " friends_who_recently_used : " + this.friendsWhoRecentlyUsed + " id : " + this.id + " is_facebook_app : " + this.isFacebookApp + " is_game : " + this.isGame + " mobile_canvas_url : " + this.mobileCanvasUrl + " name : " + this.name + " pic_square : " + this.picSquare + " privacy_url : " + this.privacyUrl + " android_screenshots : " + this.screenshotsAndroid + " mobile_web_screenshots : " + this.screenshotsMobileWeb + " similar applications : " + this.similarApplications + " similar applications detail list: " + this.similarApplicationsDetailList + " short_description : " + this.shortDescription + " square logo : " + this.square_logo + " terms_of_service_url : " + this.termsOfServiceUrl + " url : " + this.url + " viewer_has_authorized : " + this.viewerHasAuthorized;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.activitySuggestedPrivacy);
    paramParcel.writeString(this.androidStoreUrl);
    paramParcel.writeList(this.appCenterCategories);
    paramParcel.writeParcelable(this.appCenterPermissionSummary, paramInt);
    paramParcel.writeDouble(this.averageStarRating);
    paramParcel.writeList(this.bannerLogo);
    paramParcel.writeString(this.detailedDescription);
    paramParcel.writeParcelable(this.friendsWhoRecentlyUsed, paramInt);
    paramParcel.writeParcelable(this.globalUsageSummarySentence, paramInt);
    paramParcel.writeString(this.id);
    int j;
    int k;
    if (this.isFacebookApp)
    {
      j = i;
      paramParcel.writeInt(j);
      if (!this.isGame)
        break label234;
      k = i;
      label111: paramParcel.writeInt(k);
      paramParcel.writeString(this.mobileCanvasUrl);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.picSquare);
      paramParcel.writeString(this.privacyUrl);
      paramParcel.writeList(this.screenshotsAndroid);
      paramParcel.writeList(this.screenshotsMobileWeb);
      paramParcel.writeParcelable(this.similarApplications, paramInt);
      paramParcel.writeList(this.similarApplicationsDetailList);
      paramParcel.writeString(this.shortDescription);
      paramParcel.writeParcelable(this.square_logo, paramInt);
      paramParcel.writeString(this.termsOfServiceUrl);
      paramParcel.writeString(this.url);
      if (!this.viewerHasAuthorized)
        break label240;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      return;
      j = 0;
      break;
      label234: k = 0;
      break label111;
      label240: i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.graphql.model.AppDetail
 * JD-Core Version:    0.6.0
 */