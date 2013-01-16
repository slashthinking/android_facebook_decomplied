package com.facebook.katana.activity.media;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.ExifInterface;
import android.provider.MediaStore.Images.Media;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.model.PhotoItem;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.io.IOException;

public class RotationManager
{
  private static int a(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    case 1:
    case 2:
    case 4:
    case 5:
    case 7:
    default:
    case 6:
    case 3:
    case 8:
    }
    while (true)
    {
      return i;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }

  public static int a(String paramString, PhotoItem paramPhotoItem)
  {
    int i;
    if (paramPhotoItem != null)
      i = paramPhotoItem.h();
    while (true)
    {
      return i;
      try
      {
        int j = a(new ExifInterface(paramString).getAttributeInt("Orientation", 1));
        i = j;
      }
      catch (IOException localIOException)
      {
        ErrorReporting.a("RotationManager", "Error checking exif", localIOException);
        i = 0;
      }
    }
  }

  public static void a(Context paramContext, PhotoItem paramPhotoItem, int paramInt)
  {
    try
    {
      ExifInterface localExifInterface = new ExifInterface(paramPhotoItem.b());
      localExifInterface.setAttribute("Orientation", String.valueOf(b(paramInt)));
      localExifInterface.saveAttributes();
      paramPhotoItem.a(paramInt);
      localContentResolver = paramContext.getContentResolver();
      localContentValues = new ContentValues();
      localContentValues.put("orientation", String.valueOf(paramInt));
    }
    catch (IOException localIOException)
    {
      try
      {
        ContentResolver localContentResolver;
        ContentValues localContentValues;
        String str = StringLocaleUtil.a("%s = ?", new Object[] { "_id" });
        String[] arrayOfString = new String[1];
        arrayOfString[0] = String.valueOf(paramPhotoItem.a());
        if (localContentResolver.update(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues, str, arrayOfString) > 0)
          localContentResolver.notifyChange(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null);
        return;
        localIOException = localIOException;
        ErrorReporting.a("RotationManager", "Error writing exif", localIOException);
      }
      catch (Exception localException)
      {
        while (true)
          ErrorReporting.a("RotationManager", "Error writing content resolver", localException);
      }
    }
  }

  private static int b(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    case 0:
    default:
    case 90:
    case 180:
    case 270:
    }
    while (true)
    {
      return i;
      i = 6;
      continue;
      i = 3;
      continue;
      i = 8;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.RotationManager
 * JD-Core Version:    0.6.0
 */