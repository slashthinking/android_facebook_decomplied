package com.facebook.ipc.data.uberbar;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public final class UberbarJsonResult
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="category")
  public final String category = null;

  @JMAutogen.InferredType(jsonFieldName="friendship_status")
  public final String friendshipStatus = null;

  @JMAutogen.InferredType(jsonFieldName="native_android_url")
  public final String nativeAndroidUrl = null;

  @JMAutogen.InferredType(jsonFieldName="path")
  public final String path = null;

  @JMAutogen.InferredType(jsonFieldName="photo")
  public final String photo = null;

  @JMAutogen.InferredType(jsonFieldName="subtext")
  public final String subtext = null;

  @JMAutogen.InferredType(jsonFieldName="text")
  public final String text = null;

  @JMAutogen.InferredType(jsonFieldName="type")
  public final String type = null;

  @JMAutogen.InferredType(jsonFieldName="uid")
  public final String uid = null;

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof UberbarJsonResult;
    int i = 0;
    if (!bool1);
    while (true)
    {
      return i;
      UberbarJsonResult localUberbarJsonResult = (UberbarJsonResult)paramObject;
      boolean bool2 = Objects.equal(this.category, localUberbarJsonResult.category);
      i = 0;
      if (!bool2)
        continue;
      boolean bool3 = Objects.equal(this.friendshipStatus, localUberbarJsonResult.friendshipStatus);
      i = 0;
      if (!bool3)
        continue;
      boolean bool4 = Objects.equal(this.nativeAndroidUrl, localUberbarJsonResult.nativeAndroidUrl);
      i = 0;
      if (!bool4)
        continue;
      boolean bool5 = Objects.equal(this.path, localUberbarJsonResult.path);
      i = 0;
      if (!bool5)
        continue;
      boolean bool6 = Objects.equal(this.photo, localUberbarJsonResult.photo);
      i = 0;
      if (!bool6)
        continue;
      boolean bool7 = Objects.equal(this.subtext, localUberbarJsonResult.subtext);
      i = 0;
      if (!bool7)
        continue;
      boolean bool8 = Objects.equal(this.text, localUberbarJsonResult.text);
      i = 0;
      if (!bool8)
        continue;
      boolean bool9 = Objects.equal(this.type, localUberbarJsonResult.type);
      i = 0;
      if (!bool9)
        continue;
      boolean bool10 = Objects.equal(this.uid, localUberbarJsonResult.uid);
      i = 0;
      if (!bool10)
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = this.category;
    arrayOfObject[1] = this.friendshipStatus;
    arrayOfObject[2] = this.nativeAndroidUrl;
    arrayOfObject[3] = this.path;
    arrayOfObject[4] = this.photo;
    arrayOfObject[5] = this.subtext;
    arrayOfObject[6] = this.text;
    arrayOfObject[7] = this.type;
    arrayOfObject[8] = this.uid;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(UberbarJsonResult.class).add("category", this.category).add("friendshipStatus", this.friendshipStatus).add("nativeAndroidUrl", this.nativeAndroidUrl).add("path", this.path).add("photo", this.photo).add("subtext", this.subtext).add("text", this.text).add("type", this.type).add("uid", this.uid).toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.data.uberbar.UberbarJsonResult
 * JD-Core Version:    0.6.0
 */