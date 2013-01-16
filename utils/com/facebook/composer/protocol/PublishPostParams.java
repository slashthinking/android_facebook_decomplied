package com.facebook.composer.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.Shareable;
import com.facebook.orca.debug.BLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class PublishPostParams
  implements Parcelable
{
  public static final Parcelable.Creator<PublishPostParams> CREATOR = new PublishPostParams.1();
  public final String a;
  public final long b;
  public final String c;
  public final String d;
  public final boolean e;
  public final boolean f;
  public final Set<Long> g;
  public final String h;
  public final String i;
  public final long j;
  public final String k;
  public final Shareable l;
  public final String m;
  private PublishPostParams.PublishType n;

  public PublishPostParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.e = bool2;
      if (paramParcel.readByte() == 0)
        break label171;
    }
    while (true)
    {
      this.f = bool1;
      ArrayList localArrayList = new ArrayList();
      paramParcel.readList(localArrayList, null);
      this.g = new HashSet(localArrayList);
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      this.j = paramParcel.readLong();
      this.k = paramParcel.readString();
      this.l = ((Shareable)paramParcel.readParcelable(Shareable.class.getClassLoader()));
      this.m = paramParcel.readString();
      this.n = ((PublishPostParams.PublishType)paramParcel.readParcelable(PublishPostParams.PublishType.class.getClassLoader()));
      return;
      bool2 = false;
      break;
      label171: bool1 = false;
    }
  }

  public PublishPostParams(PublishPostParamsBuilder paramPublishPostParamsBuilder)
  {
    this.a = paramPublishPostParamsBuilder.b();
    this.b = paramPublishPostParamsBuilder.c();
    this.c = paramPublishPostParamsBuilder.d();
    this.d = paramPublishPostParamsBuilder.e();
    this.e = paramPublishPostParamsBuilder.f();
    this.f = paramPublishPostParamsBuilder.g();
    this.g = paramPublishPostParamsBuilder.h();
    this.h = paramPublishPostParamsBuilder.i();
    this.i = paramPublishPostParamsBuilder.k();
    this.k = paramPublishPostParamsBuilder.l();
    this.j = paramPublishPostParamsBuilder.m();
    this.l = paramPublishPostParamsBuilder.n();
    this.m = paramPublishPostParamsBuilder.o();
    this.n = paramPublishPostParamsBuilder.j();
  }

  private void c()
  {
    if (this.l != null)
      this.n = PublishPostParams.PublishType.SHARE;
    while (true)
    {
      return;
      if ((this.b == this.j) && (this.d != null) && (this.k != null) && (this.e))
        this.n = PublishPostParams.PublishType.CHECK_IN;
      else
        this.n = PublishPostParams.PublishType.STATUS;
    }
  }

  public PublishPostParams.PublishType a()
  {
    if (this.n == null)
      c();
    return this.n;
  }

  public String b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isCheckin", this.e);
      localJSONObject.put("isEvent", this.f);
      localJSONObject.put("targetId", this.b);
      localJSONObject.put("userId", this.j);
      if (this.a != null)
        localJSONObject.put("requestId", this.a);
      if (this.c != null)
        localJSONObject.put("rawMessage", this.c);
      if (this.d != null)
        localJSONObject.put("pageId", this.d);
      if ((this.g != null) && (this.g.size() > 0))
        localJSONObject.put("targedIds", this.g);
      if (this.h != null)
        localJSONObject.put("privacy", this.h);
      if (this.k != null)
        localJSONObject.put("coordinates", this.k);
      if (this.l != null)
        localJSONObject.put("shareable", this.l);
      if (this.n != null)
        localJSONObject.put("publishType", this.n.name());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      while (true)
        BLog.e("PublishPostParams", "Unable to create json string for logging.");
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    int i2;
    if (this.e)
    {
      i2 = i1;
      paramParcel.writeByte((byte)i2);
      if (!this.f)
        break label156;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.g);
      paramParcel.writeList(localArrayList);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      paramParcel.writeLong(this.j);
      paramParcel.writeString(this.k);
      paramParcel.writeParcelable(this.l, paramInt);
      paramParcel.writeString(this.m);
      paramParcel.writeParcelable(this.n, paramInt);
      return;
      i2 = 0;
      break;
      label156: i1 = 0;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PublishPostParams
 * JD-Core Version:    0.6.2
 */