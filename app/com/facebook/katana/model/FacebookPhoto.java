package com.facebook.katana.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.json.jsonmirror.JMAutogen.ExplicitType;
import com.facebook.common.json.jsonmirror.JMAutogen.IgnoreUnexpectedJsonFields;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.katana.provider.PhotosProvider;
import com.facebook.katana.util.StringUtils.JMNulledString;
import com.fasterxml.jackson.core.JsonParser;

@JMAutogen.IgnoreUnexpectedJsonFields
public class FacebookPhoto
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="aid")
  private String mAlbumId;

  @JMAutogen.InferredType(jsonFieldName="can_tag")
  private final boolean mCanTag;

  @JMAutogen.ExplicitType(jsonFieldName="caption", type=StringUtils.JMNulledString.class)
  private String mCaption;

  @JMAutogen.InferredType(jsonFieldName="created")
  private final long mCreated;
  private final String mFilename;
  private final byte[] mImageBytes;

  @JMAutogen.InferredType(jsonFieldName="object_id")
  private final long mObjectId;

  @JMAutogen.InferredType(jsonFieldName="owner")
  private final long mOwner;

  @JMAutogen.InferredType(jsonFieldName="pid")
  private final String mPhotoId;

  @JMAutogen.InferredType(jsonFieldName="position")
  private final long mPosition;

  @JMAutogen.InferredType(jsonFieldName="src")
  private final String mSrcUrl;

  @JMAutogen.InferredType(jsonFieldName="src_big")
  private final String mSrcUrlBig;

  @JMAutogen.InferredType(jsonFieldName="src_small")
  private final String mSrcUrlSmall;

  private FacebookPhoto()
  {
    this.mPhotoId = null;
    this.mAlbumId = null;
    this.mOwner = -1L;
    this.mSrcUrl = null;
    this.mSrcUrlBig = null;
    this.mSrcUrlSmall = null;
    this.mCaption = null;
    this.mCreated = -1L;
    this.mImageBytes = null;
    this.mObjectId = -1L;
    this.mPosition = -1L;
    this.mFilename = null;
    this.mCanTag = false;
  }

  public FacebookPhoto(String paramString1, String paramString2, long paramLong1, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, byte[] paramArrayOfByte, long paramLong3, long paramLong4, String paramString7, boolean paramBoolean)
  {
    this.mPhotoId = paramString1;
    this.mAlbumId = paramString2;
    this.mOwner = paramLong1;
    this.mCaption = paramString3;
    this.mSrcUrl = paramString4;
    this.mSrcUrlBig = paramString5;
    this.mSrcUrlSmall = paramString6;
    this.mCreated = paramLong2;
    this.mImageBytes = paramArrayOfByte;
    this.mObjectId = paramLong3;
    this.mPosition = paramLong4;
    this.mFilename = paramString7;
    this.mCanTag = paramBoolean;
  }

  public static FacebookPhoto a(Context paramContext, long paramLong)
  {
    return a(paramContext, Uri.withAppendedPath(PhotosProvider.d, Long.toString(paramLong)));
  }

  public static FacebookPhoto a(Context paramContext, Uri paramUri)
  {
    Cursor localCursor = paramContext.getContentResolver().query(paramUri, FacebookPhoto.PhotoQuery.a, null, null, null);
    String str1;
    String str2;
    long l1;
    String str3;
    String str4;
    String str5;
    String str6;
    long l2;
    byte[] arrayOfByte;
    long l3;
    long l4;
    String str7;
    boolean bool;
    if (localCursor.moveToFirst())
    {
      str1 = localCursor.getString(localCursor.getColumnIndex("pid"));
      str2 = localCursor.getString(localCursor.getColumnIndex("aid"));
      l1 = localCursor.getLong(localCursor.getColumnIndex("owner"));
      str3 = localCursor.getString(localCursor.getColumnIndex("caption"));
      str4 = localCursor.getString(localCursor.getColumnIndex("src"));
      str5 = localCursor.getString(localCursor.getColumnIndex("src_big"));
      str6 = localCursor.getString(localCursor.getColumnIndex("src_small"));
      l2 = localCursor.getLong(localCursor.getColumnIndex("created"));
      arrayOfByte = localCursor.getBlob(localCursor.getColumnIndex("thumbnail"));
      l3 = localCursor.getLong(localCursor.getColumnIndex("object_id"));
      l4 = localCursor.getLong(localCursor.getColumnIndex("position"));
      str7 = localCursor.getString(localCursor.getColumnIndex("filename"));
      if (localCursor.getInt(localCursor.getColumnIndex("can_tag")) != 0)
        bool = true;
    }
    for (FacebookPhoto localFacebookPhoto = new FacebookPhoto(str1, str2, l1, str3, str4, str5, str6, l2, arrayOfByte, l3, l4, str7, bool); ; localFacebookPhoto = null)
    {
      localCursor.close();
      return localFacebookPhoto;
      bool = false;
      break;
    }
  }

  public static FacebookPhoto a(Context paramContext, String paramString)
  {
    return a(paramContext, Uri.withAppendedPath(PhotosProvider.b, paramString));
  }

  public static FacebookPhoto a(JsonParser paramJsonParser)
  {
    return (FacebookPhoto)JMParser.a(paramJsonParser, FacebookPhoto.class);
  }

  public String a()
  {
    return this.mPhotoId;
  }

  public void a(String paramString)
  {
    this.mAlbumId = paramString;
  }

  public String b()
  {
    return this.mAlbumId;
  }

  public void b(String paramString)
  {
    this.mCaption = paramString;
  }

  public long c()
  {
    return this.mOwner;
  }

  public String d()
  {
    return this.mCaption;
  }

  public long e()
  {
    return this.mCreated;
  }

  public String f()
  {
    return this.mSrcUrl;
  }

  public String g()
  {
    return this.mSrcUrlBig;
  }

  public String h()
  {
    return this.mSrcUrlSmall;
  }

  public byte[] i()
  {
    return this.mImageBytes;
  }

  public long j()
  {
    return this.mObjectId;
  }

  public String k()
  {
    return this.mFilename;
  }

  public boolean l()
  {
    return this.mCanTag;
  }

  public long m()
  {
    return this.mPosition;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPhoto
 * JD-Core Version:    0.6.0
 */