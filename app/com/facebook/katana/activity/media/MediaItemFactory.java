package com.facebook.katana.activity.media;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.webkit.MimeTypeMap;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.model.VideoItem;

public class MediaItemFactory
{
  private static final String[] a = { "_id", "_data", "orientation", "mime_type", "datetaken", "_display_name" };
  private static final String[] b = { "_id", "_data", "mime_type", "datetaken", "_display_name" };
  private ContentResolver c;

  public static String a(String paramString)
  {
    String str1 = b(paramString);
    if (str1 == null);
    for (String str2 = null; ; str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str1.toLowerCase()))
      return str2;
  }

  private Cursor b(Uri paramUri)
  {
    Cursor localCursor = this.c.query(paramUri, a, null, null, null);
    if (localCursor != null);
    while (true)
    {
      return localCursor;
      localCursor = this.c.query(paramUri, b, null, null, null);
    }
  }

  public static String b(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if ((i < 0) || (i == -1 + paramString.length()));
    for (String str = null; ; str = paramString.substring(1 + paramString.lastIndexOf('.')))
      return str;
  }

  private Cursor c(String paramString)
  {
    return this.c.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, a, "_data = ?", new String[] { paramString }, null);
  }

  private MediaItem c(Uri paramUri)
  {
    String str = a(paramUri.getPath());
    Object localObject = null;
    if (str == null);
    while (true)
    {
      return localObject;
      MediaItem.MediaType localMediaType = MediaItem.a(str);
      localObject = null;
      if (localMediaType == null)
        continue;
      switch (MediaItemFactory.1.a[localMediaType.ordinal()])
      {
      default:
        localObject = null;
        break;
      case 1:
        localObject = new PhotoItem(-1L, paramUri.getPath(), "", str, 0L, 0, -1L, null, null);
        break;
      case 2:
        localObject = new VideoItem(-1L, paramUri.getPath(), "", str, 0L, -1L);
      }
    }
  }

  public MediaItem a(Uri paramUri)
  {
    String str1 = paramUri.getScheme();
    Cursor localCursor;
    if ("file".equals(str1))
    {
      localCursor = c(paramUri.getPath());
      if (localCursor == null);
    }
    while (true)
    {
      try
      {
        if (localCursor.moveToFirst())
          continue;
        MediaItem localMediaItem = c(paramUri);
        localObject1 = localMediaItem;
        return localObject1;
        boolean bool = "content".equals(str1);
        localObject1 = null;
        if (!bool)
          continue;
        localCursor = b(paramUri);
        break;
        String str2 = localCursor.getString(localCursor.getColumnIndex("mime_type"));
        int i = MediaItemFactory.1.a[MediaItem.a(str2).ordinal()];
        localObject1 = null;
        switch (i)
        {
        default:
          if (localCursor == null)
            continue;
          localCursor.close();
          break;
        case 1:
          localObject1 = new PhotoItem(localCursor.getLong(0), localCursor.getString(1), localCursor.getString(5), localCursor.getString(3), localCursor.getLong(4), localCursor.getInt(2), -1L, null, null);
          continue;
          continue;
        case 2:
        }
      }
      finally
      {
        if (localCursor == null)
          continue;
        localCursor.close();
      }
      Object localObject1 = new VideoItem(localCursor.getLong(0), localCursor.getString(1), localCursor.getString(4), localCursor.getString(2), localCursor.getLong(3), -1L);
    }
  }

  public void a(ContentResolver paramContentResolver)
  {
    this.c = paramContentResolver;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaItemFactory
 * JD-Core Version:    0.6.0
 */