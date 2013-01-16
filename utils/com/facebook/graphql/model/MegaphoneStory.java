package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MegaphoneStory
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<MegaphoneStory> CREATOR = new MegaphoneStory.1();

  @JsonProperty("action")
  public final MegaphoneStoryAction action;

  @JsonProperty("close_label")
  public final String closeLabel;

  @JsonProperty("content")
  public final GraphQLTextWithEntities content;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("image")
  public final GraphQLImage image;

  @JsonProperty("is_persistent")
  public final boolean isPersistent;

  @JsonProperty("location")
  public final String location;

  @JsonProperty("title")
  public final String title;

  private MegaphoneStory()
  {
    this.id = null;
    this.location = null;
    this.title = null;
    this.image = null;
    this.content = null;
    this.action = null;
    this.closeLabel = null;
    this.isPersistent = false;
  }

  private MegaphoneStory(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.location = paramParcel.readString();
    this.title = paramParcel.readString();
    this.content = ((GraphQLTextWithEntities)paramParcel.readParcelable(GraphQLTextWithEntities.class.getClassLoader()));
    this.image = ((GraphQLImage)paramParcel.readParcelable(GraphQLImage.class.getClassLoader()));
    this.action = ((MegaphoneStoryAction)paramParcel.readParcelable(MegaphoneStoryAction.class.getClassLoader()));
    this.closeLabel = paramParcel.readString();
    if (paramParcel.readInt() > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.isPersistent = bool;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.location);
    paramParcel.writeString(this.title);
    paramParcel.writeParcelable(this.content, paramInt);
    paramParcel.writeParcelable(this.image, paramInt);
    paramParcel.writeParcelable(this.action, paramInt);
    paramParcel.writeString(this.closeLabel);
    if (this.isPersistent);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.MegaphoneStory
 * JD-Core Version:    0.6.2
 */