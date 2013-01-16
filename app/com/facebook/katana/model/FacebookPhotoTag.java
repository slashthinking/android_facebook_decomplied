package com.facebook.katana.model;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.common.util.Log;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookPhotoTag extends FacebookPhotoTagBase
  implements Parcelable, FacebookTagLabel
{
  public static final Parcelable.Creator<FacebookPhotoTag> CREATOR = new FacebookPhotoTag.1();
  private final String a;
  private final PointF b;
  private final long c;
  private final long d;
  private final String e;
  private final long f;
  private final String g;

  private FacebookPhotoTag(Parcel paramParcel)
  {
    this.c = paramParcel.readLong();
    this.f = paramParcel.readLong();
    this.a = paramParcel.readString();
    this.e = paramParcel.readString();
    this.d = paramParcel.readLong();
    this.b = new PointF();
    this.b.x = (float)paramParcel.readDouble();
    this.b.y = (float)paramParcel.readDouble();
    this.g = paramParcel.readString();
  }

  public FacebookPhotoTag(JsonParser paramJsonParser)
  {
    long l1 = -1L;
    long l2 = -1L;
    double d1 = 0.0D;
    double d2 = 0.0D;
    JsonToken localJsonToken1 = FbJsonChecker.a(paramJsonParser);
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    JsonToken localJsonToken2 = localJsonToken1;
    String str2;
    label76: long l3;
    long l4;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    double d5;
    double d6;
    if (localJsonToken2 != JsonToken.END_OBJECT)
      if (localJsonToken2 == JsonToken.VALUE_STRING)
      {
        str2 = paramJsonParser.getCurrentName();
        if (str2.equals("pid"))
        {
          localObject3 = paramJsonParser.getText();
          double d12 = d2;
          double d13 = d1;
          l3 = l2;
          l4 = l1;
          localObject4 = localObject1;
          localObject5 = localObject2;
          localObject6 = localObject3;
          d5 = d12;
          d6 = d13;
        }
      }
    while (true)
    {
      localJsonToken2 = FbJsonChecker.a(paramJsonParser);
      double d7 = d5;
      localObject1 = localObject4;
      localObject2 = localObject5;
      long l5 = l3;
      long l6 = l4;
      l2 = l5;
      d1 = d6;
      d2 = d7;
      localObject3 = localObject6;
      l1 = l6;
      break;
      if (str2.equals("subject"))
      {
        localObject2 = paramJsonParser.getText();
        break label76;
      }
      if (!str2.equals("text"))
        break label76;
      localObject1 = paramJsonParser.getText();
      break label76;
      if (localJsonToken2.isNumeric())
      {
        String str1 = paramJsonParser.getCurrentName();
        if (localJsonToken2 == JsonToken.VALUE_NUMBER_INT)
        {
          if (!str1.equals("created"))
            break label285;
          l1 = paramJsonParser.getLongValue();
        }
        while (true)
        {
          if (!str1.equals("xcoord"))
            break label304;
          double d10 = paramJsonParser.getFloatValue();
          double d11 = d2;
          l3 = l2;
          l4 = l1;
          localObject4 = localObject1;
          localObject5 = localObject2;
          localObject6 = localObject3;
          d5 = d11;
          d6 = d10;
          break;
          label285: if (!str1.equals("object_id"))
            continue;
          l2 = paramJsonParser.getLongValue();
        }
        label304: if (str1.equals("ycoord"))
        {
          double d8 = paramJsonParser.getFloatValue();
          double d9 = d1;
          l3 = l2;
          l4 = l1;
          localObject4 = localObject1;
          localObject5 = localObject2;
          localObject6 = localObject3;
          d5 = d8;
          d6 = d9;
          continue;
          if (StringUtils.c((String)localObject2));
          for (this.d = -1L; ; this.d = a((String)localObject2))
          {
            this.a = ((String)localObject3);
            this.b = new PointF((float)d1, (float)d2);
            this.c = l1;
            this.e = ((String)localObject1);
            this.f = l2;
            this.g = null;
            return;
          }
        }
      }
      double d3 = d2;
      double d4 = d1;
      l3 = l2;
      l4 = l1;
      localObject4 = localObject1;
      localObject5 = localObject2;
      localObject6 = localObject3;
      d5 = d3;
      d6 = d4;
    }
  }

  public FacebookPhotoTag(String paramString1, long paramLong1, double paramDouble1, double paramDouble2, long paramLong2, String paramString2)
  {
    this(paramString1, paramLong1, paramDouble1, paramDouble2, paramLong2, paramString2, -1L, null);
  }

  public FacebookPhotoTag(String paramString1, long paramLong1, double paramDouble1, double paramDouble2, long paramLong2, String paramString2, long paramLong3, String paramString3)
  {
    this.a = paramString1;
    this.d = paramLong1;
    this.b = new PointF((float)paramDouble1, (float)paramDouble2);
    this.c = paramLong2;
    this.e = paramString2;
    this.f = paramLong3;
    this.g = paramString3;
  }

  public FacebookPhotoTag(String paramString1, long paramLong1, double paramDouble1, double paramDouble2, long paramLong2, String paramString2, String paramString3)
  {
    this(paramString1, paramLong1, paramDouble1, paramDouble2, paramLong2, paramString2, -1L, paramString3);
  }

  private long a(String paramString)
  {
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        long l1 = -1L;
    }
  }

  public long a()
  {
    return this.d;
  }

  public String a(Context paramContext)
  {
    return f();
  }

  public void a(float paramFloat)
  {
    this.b.y = paramFloat;
  }

  public float[] a(RectF paramRectF)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = ((float)c() / 100.0F * paramRectF.width() + paramRectF.left);
    arrayOfFloat[1] = ((float)d() / 100.0F * paramRectF.height() + paramRectF.top);
    return arrayOfFloat;
  }

  public PointF b()
  {
    return this.b;
  }

  public void b(float paramFloat)
  {
    this.b.x = paramFloat;
  }

  public double c()
  {
    return this.b.x;
  }

  public double d()
  {
    return this.b.y;
  }

  public int describeContents()
  {
    return 0;
  }

  public long e()
  {
    return this.c;
  }

  public String f()
  {
    return this.e;
  }

  public long g()
  {
    return this.f;
  }

  public String h()
  {
    return this.g;
  }

  public JSONObject i()
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject().put("x", c()).put("y", d());
      if (a() > 0L)
        localJSONObject.put("tag_uid", a());
      else
        localJSONObject.put("tag_text", f());
    }
    catch (JSONException localJSONException)
    {
      Log.a("", "inconceivable JSON exception", localJSONException);
      localJSONObject = null;
    }
    return localJSONObject;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.f);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.d);
    paramParcel.writeDouble(this.b.x);
    paramParcel.writeDouble(this.b.y);
    paramParcel.writeString(this.g);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPhotoTag
 * JD-Core Version:    0.6.0
 */