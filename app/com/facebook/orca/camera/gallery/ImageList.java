package com.facebook.orca.camera.gallery;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;

public class ImageList extends BaseImageList
  implements IImageList
{
  static final String[] h;
  private static final Class<?> i = ImageList.class;
  private static final String[] j = { "image/jpeg", "image/png", "image/gif" };

  static
  {
    h = new String[] { "_id", "_data", "datetaken", "mini_thumb_magic", "orientation", "title", "mime_type", "date_modified" };
  }

  public ImageList(ContentResolver paramContentResolver, Uri paramUri1, Uri paramUri2, int paramInt, String paramString)
  {
    super(paramContentResolver, paramUri1, paramInt, paramString);
    this.f = paramUri2;
  }

  protected BaseImage a(Cursor paramCursor)
  {
    long l1 = paramCursor.getLong(0);
    String str1 = paramCursor.getString(1);
    long l2 = paramCursor.getLong(2);
    if (l2 == 0L)
      l2 = 1000L * paramCursor.getLong(7);
    long l3 = paramCursor.getLong(3);
    int k = paramCursor.getInt(4);
    String str2 = paramCursor.getString(5);
    String str3 = paramCursor.getString(6);
    if ((str2 == null) || (str2.length() == 0))
      str2 = str1;
    return new Image(this, this.a, l1, paramCursor.getPosition(), a(l1), str1, l3, str3, l2, str2, str2, k);
  }

  protected long b(Cursor paramCursor)
  {
    return paramCursor.getLong(0);
  }

  protected Cursor d()
  {
    return MediaStore.Images.Media.query(this.a, this.c, h, g(), h(), f());
  }

  protected String g()
  {
    if (this.e == null);
    for (String str = "(mime_type in (?, ?, ?))"; ; str = "(mime_type in (?, ?, ?)) AND bucket_id = ?")
      return str;
  }

  protected String[] h()
  {
    String[] arrayOfString;
    if (this.e != null)
    {
      int k = j.length;
      arrayOfString = new String[k + 1];
      System.arraycopy(j, 0, arrayOfString, 0, k);
      arrayOfString[k] = this.e;
    }
    while (true)
    {
      return arrayOfString;
      arrayOfString = j;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.gallery.ImageList
 * JD-Core Version:    0.6.0
 */