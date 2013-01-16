package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLMedia extends FeedbackableGraphQLNode
  implements Parcelable
{

  @JsonIgnore
  public FeedStory a;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("image")
  public final GraphQLImage image;

  @JsonProperty("image_landscape")
  public final GraphQLImage imageLandscape;

  @JsonProperty("image_portrait")
  public final GraphQLImage imagePortrait;

  @JsonProperty("is_playable")
  public final boolean isPlayable;

  @JsonProperty("__type__")
  public final GraphQLObjectType objectType;

  @JsonProperty("playable_url")
  public final String playableUrl;

  protected GraphQLMedia()
  {
    this.id = null;
    this.image = null;
    this.imagePortrait = null;
    this.imageLandscape = null;
    this.isPlayable = false;
    this.playableUrl = null;
    this.objectType = null;
  }

  public GraphQLMedia(GraphQLMediaBuilder paramGraphQLMediaBuilder)
  {
    super(paramGraphQLMediaBuilder);
    this.id = paramGraphQLMediaBuilder.c();
    this.image = paramGraphQLMediaBuilder.d();
    this.imagePortrait = paramGraphQLMediaBuilder.e();
    this.imageLandscape = paramGraphQLMediaBuilder.f();
    this.isPlayable = paramGraphQLMediaBuilder.g();
    this.playableUrl = paramGraphQLMediaBuilder.h();
    this.objectType = paramGraphQLMediaBuilder.i();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLMedia
 * JD-Core Version:    0.6.2
 */