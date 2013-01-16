package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlatformApplication
{

  @JsonProperty("android_app_config")
  public final PlatformNativeApplicationConfig androidAppConfig = null;

  @JsonProperty("android_store_url")
  public final String androidStoreUrl = null;

  @JsonProperty("app_center_cover_image")
  public final GraphQLImage appCenterCoverImage = null;

  @JsonProperty("average_star_rating")
  public final float averageStarRating = 0.0F;

  @JsonProperty("canvas_url")
  public final String canvasUrl = null;

  @JsonProperty("global_usage_summary_sentence")
  public final GraphQLTextWithEntities globalUsageSentence = null;

  @JsonProperty("id")
  public final String id = null;

  @JsonProperty("name")
  public final String name = null;

  @JsonProperty("social_usage_summary_sentence")
  public final GraphQLTextWithEntities socialUsageSentence = null;

  @JsonProperty("url")
  public final String url = null;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PlatformApplication
 * JD-Core Version:    0.6.0
 */