package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.util.ErrorReporting;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MegaphoneStoryAction
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<MegaphoneStoryAction> CREATOR = new MegaphoneStoryAction.1();
  public static final String STYLE_DEFAULT = "DEFAULT";
  public static final String STYLE_PROMINENT = "PROMINENT";
  public static final String STYLE_SUBDUED = "SUBDUED";

  @JsonProperty("style")
  private final String style;

  @JsonProperty("title")
  public final String title;

  @JsonProperty("url")
  public final String url;

  private MegaphoneStoryAction()
  {
    this.style = null;
    this.title = null;
    this.url = null;
  }

  public MegaphoneStoryAction(Parcel paramParcel)
  {
    this.style = paramParcel.readString();
    this.title = paramParcel.readString();
    this.url = paramParcel.readString();
  }

  public String a()
  {
    String str;
    if ((this.style == null) || (this.style.equals("")))
      str = "DEFAULT";
    while (true)
    {
      return str;
      if ((this.style.equals("DEFAULT")) || (this.style.equals("PROMINENT")) || (this.style.equals("SUBDUED")))
      {
        str = this.style;
      }
      else
      {
        ErrorReporting.a("MegaphoneStoryAction invalid style: " + this.style, "", true);
        str = "DEFAULT";
      }
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.style);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.url);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.MegaphoneStoryAction
 * JD-Core Version:    0.6.2
 */