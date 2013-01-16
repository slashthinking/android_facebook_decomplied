package com.facebook.katana.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.katana.provider.PhotosProvider;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class FacebookAlbum
{
  private final String a;
  private String b;
  private final long c;
  private final String d;
  private final long e;
  private final long f;
  private final String g;
  private final String h;
  private final String i;
  private final int j;
  private final String k;
  private final String l;
  private final byte[] m;
  private String n;
  private boolean o = false;
  private final long p;
  private final String[] q;

  public FacebookAlbum(JsonParser paramJsonParser)
  {
    long l1 = -1L;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    long l2 = -1L;
    long l3 = -1L;
    int i1 = -1;
    int i2 = -1;
    long l4 = -1L;
    JsonToken localJsonToken1 = FbJsonChecker.a(paramJsonParser);
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    JsonToken localJsonToken2 = localJsonToken1;
    JsonToken localJsonToken3 = JsonToken.END_OBJECT;
    String str2;
    label117: Object localObject10;
    Object localObject11;
    int i3;
    int i4;
    Object localObject12;
    Object localObject13;
    long l6;
    Object localObject14;
    long l7;
    long l9;
    Object localObject17;
    Object localObject18;
    Object localObject19;
    long l10;
    Object localObject20;
    if (localJsonToken2 != localJsonToken3)
    {
      JsonToken localJsonToken4 = JsonToken.VALUE_STRING;
      if (localJsonToken2 == localJsonToken4)
      {
        str2 = paramJsonParser.getCurrentName();
        if (str2.equals("aid"))
        {
          localObject9 = paramJsonParser.getText();
          long l28 = l4;
          localObject10 = localObject5;
          localObject11 = localObject4;
          i3 = i2;
          i4 = i1;
          localObject12 = localObject3;
          localObject13 = localObject2;
          l6 = l3;
          localObject14 = localObject1;
          Object localObject33 = localObject7;
          Object localObject34 = localObject6;
          l7 = l28;
          long l29 = l2;
          l9 = l1;
          localObject17 = localObject9;
          localObject18 = localObject34;
          localObject19 = localObject8;
          l10 = l29;
          localObject20 = localObject33;
        }
      }
    }
    while (true)
    {
      localJsonToken2 = FbJsonChecker.a(paramJsonParser);
      long l11 = l7;
      localObject7 = localObject20;
      localObject6 = localObject18;
      localObject8 = localObject19;
      localObject9 = localObject17;
      long l12 = l6;
      localObject3 = localObject12;
      localObject2 = localObject13;
      i2 = i3;
      i1 = i4;
      localObject5 = localObject10;
      localObject4 = localObject11;
      l4 = l11;
      long l13 = l10;
      localObject1 = localObject14;
      l1 = l9;
      l2 = l13;
      l3 = l12;
      break;
      if (str2.equals("cover_pid"))
      {
        localObject5 = paramJsonParser.getText();
        break label117;
      }
      if (str2.equals("name"))
      {
        localObject1 = paramJsonParser.getText();
        break label117;
      }
      if (str2.equals("description"))
      {
        localObject2 = paramJsonParser.getText();
        break label117;
      }
      if (str2.equals("location"))
      {
        localObject3 = paramJsonParser.getText();
        break label117;
      }
      if (str2.equals("link"))
      {
        localObject4 = paramJsonParser.getText();
        break label117;
      }
      if (str2.equals("visible"))
      {
        localObject8 = paramJsonParser.getText();
        break label117;
      }
      if (str2.equals("type"))
      {
        localObject6 = paramJsonParser.getText();
        break label117;
      }
      if (str2.equals("error_msg"))
      {
        localObject7 = paramJsonParser.getText();
        break label117;
      }
      if (!str2.equals("owner"))
        break label117;
      l1 = Long.parseLong(paramJsonParser.getText());
      break label117;
      JsonToken localJsonToken5 = JsonToken.VALUE_NUMBER_INT;
      if (localJsonToken2 == localJsonToken5)
      {
        String str1 = paramJsonParser.getCurrentName();
        if (str1.equals("owner"))
        {
          long l25 = paramJsonParser.getLongValue();
          long l26 = l4;
          localObject10 = localObject5;
          localObject11 = localObject4;
          i3 = i2;
          i4 = i1;
          localObject12 = localObject3;
          localObject13 = localObject2;
          l6 = l3;
          localObject14 = localObject1;
          Object localObject31 = localObject7;
          Object localObject32 = localObject6;
          l7 = l26;
          long l27 = l2;
          l9 = l25;
          localObject17 = localObject9;
          localObject18 = localObject32;
          localObject19 = localObject8;
          l10 = l27;
          localObject20 = localObject31;
          continue;
        }
        if (str1.equals("created"))
        {
          long l23 = paramJsonParser.getLongValue();
          long l24 = l4;
          localObject10 = localObject5;
          localObject11 = localObject4;
          i3 = i2;
          i4 = i1;
          localObject12 = localObject3;
          localObject13 = localObject2;
          l6 = l3;
          localObject14 = localObject1;
          Object localObject29 = localObject7;
          Object localObject30 = localObject6;
          l7 = l24;
          l9 = l1;
          localObject17 = localObject9;
          localObject18 = localObject30;
          localObject19 = localObject8;
          l10 = l23;
          localObject20 = localObject29;
          continue;
        }
        if (str1.equals("modified"))
        {
          long l20 = paramJsonParser.getLongValue();
          long l21 = l4;
          localObject10 = localObject5;
          localObject11 = localObject4;
          i3 = i2;
          i4 = i1;
          localObject12 = localObject3;
          localObject13 = localObject2;
          l6 = l20;
          localObject14 = localObject1;
          Object localObject27 = localObject7;
          Object localObject28 = localObject6;
          l7 = l21;
          long l22 = l2;
          l9 = l1;
          localObject17 = localObject9;
          localObject18 = localObject28;
          localObject19 = localObject8;
          l10 = l22;
          localObject20 = localObject27;
          continue;
        }
        if (str1.equals("size"))
        {
          int i6 = paramJsonParser.getIntValue();
          long l18 = l4;
          localObject10 = localObject5;
          localObject11 = localObject4;
          i3 = i2;
          i4 = i6;
          localObject12 = localObject3;
          localObject13 = localObject2;
          l6 = l3;
          localObject14 = localObject1;
          Object localObject25 = localObject7;
          Object localObject26 = localObject6;
          l7 = l18;
          long l19 = l2;
          l9 = l1;
          localObject17 = localObject9;
          localObject18 = localObject26;
          localObject19 = localObject8;
          l10 = l19;
          localObject20 = localObject25;
          continue;
        }
        if (str1.equals("error_code"))
        {
          int i5 = paramJsonParser.getIntValue();
          long l16 = l4;
          localObject10 = localObject5;
          localObject11 = localObject4;
          i3 = i5;
          i4 = i1;
          localObject12 = localObject3;
          localObject13 = localObject2;
          l6 = l3;
          localObject14 = localObject1;
          Object localObject23 = localObject7;
          Object localObject24 = localObject6;
          l7 = l16;
          long l17 = l2;
          l9 = l1;
          localObject17 = localObject9;
          localObject18 = localObject24;
          localObject19 = localObject8;
          l10 = l17;
          localObject20 = localObject23;
          continue;
        }
        if (str1.equals("object_id"))
        {
          long l14 = paramJsonParser.getLongValue();
          localObject10 = localObject5;
          localObject11 = localObject4;
          i3 = i2;
          i4 = i1;
          localObject12 = localObject3;
          localObject13 = localObject2;
          l6 = l3;
          localObject14 = localObject1;
          Object localObject21 = localObject7;
          Object localObject22 = localObject6;
          l7 = l14;
          long l15 = l2;
          l9 = l1;
          localObject17 = localObject9;
          localObject18 = localObject22;
          localObject19 = localObject8;
          l10 = l15;
          localObject20 = localObject21;
          continue;
          if (i2 > 0)
            throw new FacebookApiException(i2, (String)localObject7);
          this.a = ((String)localObject9);
          this.c = l1;
          this.d = ((String)localObject1);
          this.b = ((String)localObject5);
          this.e = l2;
          this.f = l3;
          this.g = ((String)localObject2);
          this.h = ((String)localObject3);
          this.i = ((String)localObject4);
          this.j = i1;
          this.k = ((String)localObject8);
          if (localObject6 == null);
          for (this.l = "normal"; ; this.l = ((String)localObject6))
          {
            this.m = null;
            this.p = l4;
            this.q = null;
            return;
          }
        }
      }
      long l5 = l4;
      localObject10 = localObject5;
      localObject11 = localObject4;
      i3 = i2;
      i4 = i1;
      localObject12 = localObject3;
      localObject13 = localObject2;
      l6 = l3;
      localObject14 = localObject1;
      Object localObject15 = localObject7;
      Object localObject16 = localObject6;
      l7 = l5;
      long l8 = l2;
      l9 = l1;
      localObject17 = localObject9;
      localObject18 = localObject16;
      localObject19 = localObject8;
      l10 = l8;
      localObject20 = localObject15;
    }
  }

  public FacebookAlbum(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, long paramLong3, String paramString5, String paramString6, String paramString7, int paramInt, String paramString8, String paramString9, byte[] paramArrayOfByte, long paramLong4, String[] paramArrayOfString)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.n = paramString3;
    this.c = paramLong1;
    this.d = paramString4;
    this.e = paramLong2;
    this.f = paramLong3;
    this.g = paramString5;
    this.h = paramString6;
    this.i = paramString7;
    this.j = paramInt;
    this.k = paramString8;
    this.l = paramString9;
    this.m = paramArrayOfByte;
    this.p = paramLong4;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      paramArrayOfString = null;
    this.q = paramArrayOfString;
  }

  public static FacebookAlbum a(Context paramContext, long paramLong)
  {
    return a(paramContext, Uri.withAppendedPath(PhotosProvider.h, Long.toString(paramLong)));
  }

  public static FacebookAlbum a(Context paramContext, Uri paramUri)
  {
    Cursor localCursor = paramContext.getContentResolver().query(paramUri, FacebookAlbum.AlbumQuery.a, null, null, null);
    String[] arrayOfString;
    if (localCursor.moveToFirst())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("pids"));
      boolean bool = TextUtils.isEmpty(str);
      arrayOfString = null;
      if (!bool)
        arrayOfString = str.split(",");
    }
    for (FacebookAlbum localFacebookAlbum = new FacebookAlbum(localCursor.getString(localCursor.getColumnIndex("aid")), localCursor.getString(localCursor.getColumnIndex("cover_pid")), localCursor.getString(localCursor.getColumnIndex("cover_url")), localCursor.getLong(localCursor.getColumnIndex("owner")), localCursor.getString(localCursor.getColumnIndex("name")), localCursor.getLong(localCursor.getColumnIndex("created")), localCursor.getLong(localCursor.getColumnIndex("modified")), localCursor.getString(localCursor.getColumnIndex("description")), localCursor.getString(localCursor.getColumnIndex("location")), null, localCursor.getInt(localCursor.getColumnIndex("size")), localCursor.getString(localCursor.getColumnIndex("visibility")), localCursor.getString(localCursor.getColumnIndex("type")), localCursor.getBlob(localCursor.getColumnIndex("thumbnail")), localCursor.getLong(localCursor.getColumnIndex("object_id")), arrayOfString); ; localFacebookAlbum = null)
    {
      localCursor.close();
      return localFacebookAlbum;
    }
  }

  public static FacebookAlbum a(Context paramContext, String paramString)
  {
    return a(paramContext, Uri.withAppendedPath(PhotosProvider.f, paramString));
  }

  public String a()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.n = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public String b()
  {
    return this.b;
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  public long c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public long e()
  {
    return this.e;
  }

  public long f()
  {
    return this.f;
  }

  public String g()
  {
    return this.g;
  }

  public String h()
  {
    return this.h;
  }

  public int i()
  {
    return this.j;
  }

  public String j()
  {
    return this.k;
  }

  public String k()
  {
    return this.n;
  }

  public String l()
  {
    return this.l;
  }

  public long m()
  {
    return this.p;
  }

  public String[] n()
  {
    return this.q;
  }

  public boolean o()
  {
    return this.o;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookAlbum
 * JD-Core Version:    0.6.0
 */