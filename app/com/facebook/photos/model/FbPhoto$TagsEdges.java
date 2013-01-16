package com.facebook.photos.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class FbPhoto$TagsEdges
  implements Parcelable
{
  public static final Parcelable.Creator<TagsEdges> CREATOR = new FbPhoto.TagsEdges.1();

  @JsonProperty("edges")
  public final List<FbPhotoTag> edges;

  private FbPhoto$TagsEdges()
  {
    this.edges = null;
  }

  private FbPhoto$TagsEdges(Parcel paramParcel)
  {
    this.edges = paramParcel.readBundle().getParcelableArrayList("edges");
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ArrayList localArrayList = Lists.a(this.edges);
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("edges", localArrayList);
    paramParcel.writeBundle(localBundle);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.model.FbPhoto.TagsEdges
 * JD-Core Version:    0.6.0
 */