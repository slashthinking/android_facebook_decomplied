package com.facebook.katana.activity.media.crop;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.RotateBitmap;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.provider.LocalCropInfoProvider;
import com.facebook.katana.provider.VaultImageProvider;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CropDatabaseHelper
{
  private static final String[] a = { "coordinates0", "coordinates1", "coordinates2", "coordinates3", "coordinates4", "coordinates5", "coordinates6", "coordinates7", "image_hash" };

  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 + paramFloat1 * (paramFloat3 - paramFloat2);
  }

  public static ContentValues a(PhotoItem paramPhotoItem, CropInfo paramCropInfo)
  {
    String str = VaultImageProvider.a(paramPhotoItem.c(), paramPhotoItem.d());
    float[] arrayOfFloat = paramCropInfo.a();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("coordinates0", Float.valueOf(arrayOfFloat[0]));
    localContentValues.put("coordinates1", Float.valueOf(arrayOfFloat[1]));
    localContentValues.put("coordinates2", Float.valueOf(arrayOfFloat[2]));
    localContentValues.put("coordinates3", Float.valueOf(arrayOfFloat[3]));
    localContentValues.put("coordinates4", Float.valueOf(arrayOfFloat[4]));
    localContentValues.put("coordinates5", Float.valueOf(arrayOfFloat[5]));
    localContentValues.put("coordinates6", Float.valueOf(arrayOfFloat[6]));
    localContentValues.put("coordinates7", Float.valueOf(arrayOfFloat[7]));
    localContentValues.put("image_hash", str);
    return localContentValues;
  }

  static PointF a(PointF paramPointF, RectF paramRectF, int paramInt)
  {
    PointF localPointF = new PointF();
    switch ((paramInt + 360) % 360)
    {
    default:
      throw new IllegalArgumentException("Angle must be a multiple of 90");
    case 0:
      localPointF.x = paramPointF.x;
      localPointF.y = paramPointF.y;
    case 90:
    case 180:
    case 270:
    }
    while (true)
    {
      return localPointF;
      localPointF.x = (paramRectF.width() - paramPointF.y);
      localPointF.y = paramPointF.x;
      continue;
      localPointF.x = (paramRectF.width() - paramPointF.x);
      localPointF.y = (paramRectF.height() - paramPointF.y);
      continue;
      localPointF.x = paramPointF.y;
      localPointF.y = (paramRectF.height() - paramPointF.x);
    }
  }

  static RectF a(PointF paramPointF1, PointF paramPointF2)
  {
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    localPointF1.x = Math.min(paramPointF1.x, paramPointF2.x);
    localPointF1.y = Math.min(paramPointF1.y, paramPointF2.y);
    localPointF2.x = Math.max(paramPointF1.x, paramPointF2.x);
    localPointF2.y = Math.max(paramPointF1.y, paramPointF2.y);
    return new RectF(localPointF1.x, localPointF1.y, localPointF2.x, localPointF2.y);
  }

  static RectF a(RectF paramRectF, int paramInt)
  {
    RectF localRectF = new RectF(0.0F, 0.0F, 1.0F, 1.0F);
    PointF localPointF1 = new PointF(paramRectF.left, paramRectF.top);
    PointF localPointF2 = new PointF(paramRectF.right, paramRectF.bottom);
    return a(a(localPointF1, localRectF, paramInt), a(localPointF2, localRectF, paramInt));
  }

  public static RectF a(RectF paramRectF1, RectF paramRectF2, int paramInt)
  {
    RectF localRectF = a(paramRectF1, paramInt);
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    localPointF1.x = (int)a(localRectF.left, paramRectF2.left, paramRectF2.right);
    localPointF1.y = (int)a(localRectF.top, paramRectF2.top, paramRectF2.bottom);
    localPointF2.x = (int)a(localRectF.right, paramRectF2.left, paramRectF2.right);
    localPointF2.y = (int)a(localRectF.bottom, paramRectF2.top, paramRectF2.bottom);
    return new RectF(localPointF1.x, localPointF1.y, localPointF2.x, localPointF2.y);
  }

  private static CropInfo a(Cursor paramCursor)
  {
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (float)paramCursor.getDouble(0);
    arrayOfFloat[1] = (float)paramCursor.getDouble(1);
    arrayOfFloat[2] = (float)paramCursor.getDouble(2);
    arrayOfFloat[3] = (float)paramCursor.getDouble(3);
    arrayOfFloat[4] = (float)paramCursor.getDouble(4);
    arrayOfFloat[5] = (float)paramCursor.getDouble(5);
    arrayOfFloat[6] = (float)paramCursor.getDouble(6);
    arrayOfFloat[7] = (float)paramCursor.getDouble(7);
    return new CropInfo(arrayOfFloat);
  }

  public static DrawingElements a(CropInfo paramCropInfo, RectF paramRectF)
  {
    float[] arrayOfFloat1 = paramCropInfo.a();
    float f1 = (float)(57.295779513082323D * (float)Math.atan2(arrayOfFloat1[3] - arrayOfFloat1[1], arrayOfFloat1[2] - arrayOfFloat1[0]));
    float f2 = (arrayOfFloat1[0] + arrayOfFloat1[4]) / 2.0F;
    float f3 = (arrayOfFloat1[1] + arrayOfFloat1[5]) / 2.0F;
    float f4 = paramRectF.left + f2 * (paramRectF.right - paramRectF.left);
    float f5 = paramRectF.top + f3 * (paramRectF.bottom - paramRectF.top);
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-f1, f4, f5);
    float[] arrayOfFloat2 = new float[4];
    arrayOfFloat2[0] = (int)a(arrayOfFloat1[0], paramRectF.left, paramRectF.right);
    arrayOfFloat2[1] = (int)a(arrayOfFloat1[1], paramRectF.top, paramRectF.bottom);
    arrayOfFloat2[2] = (int)a(arrayOfFloat1[4], paramRectF.left, paramRectF.right);
    arrayOfFloat2[3] = (int)a(arrayOfFloat1[5], paramRectF.top, paramRectF.bottom);
    float[] arrayOfFloat3 = new float[4];
    localMatrix.mapPoints(arrayOfFloat3, arrayOfFloat2);
    return new DrawingElements(localMatrix, new RectF(arrayOfFloat3[0], arrayOfFloat3[1], arrayOfFloat3[2], arrayOfFloat3[3]));
  }

  private static Map<String, CropInfo> a(ContentResolver paramContentResolver)
  {
    HashMap localHashMap = Maps.a();
    Cursor localCursor = paramContentResolver.query(LocalCropInfoProvider.a, a, null, null, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
        localHashMap.put(localCursor.getString(8), a(localCursor));
      localCursor.close();
    }
    return localHashMap;
  }

  public static void a(CropState paramCropState)
  {
    CropInfo localCropInfo = b(paramCropState);
    paramCropState.h().a(localCropInfo);
  }

  public static void a(CropState paramCropState, Context paramContext)
  {
    a(paramCropState.h(), paramContext);
    CropInfo localCropInfo = b(paramCropState);
    ContentValues localContentValues = a(paramCropState.h(), localCropInfo);
    paramContext.getContentResolver().insert(LocalCropInfoProvider.a, localContentValues);
    paramCropState.h().a(localCropInfo);
  }

  public static void a(PhotoItem paramPhotoItem, Context paramContext)
  {
    String str = VaultImageProvider.a(paramPhotoItem.c(), paramPhotoItem.d());
    paramContext.getContentResolver().delete(LocalCropInfoProvider.a, StringLocaleUtil.a("%s='%s'", new Object[] { "image_hash", str }), null);
    paramPhotoItem.a(null);
  }

  public static void a(Map<String, MediaItem> paramMap, ContentResolver paramContentResolver)
  {
    Map localMap = a(paramContentResolver);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      MediaItem localMediaItem = (MediaItem)paramMap.get(str1);
      if (localMediaItem == null)
      {
        String str2 = StringLocaleUtil.a("%s = ?", new Object[] { "image_hash" });
        String[] arrayOfString = { str1 };
        paramContentResolver.delete(LocalCropInfoProvider.a, str2, arrayOfString);
        continue;
      }
      if (localMediaItem.e() != MediaItem.MediaType.PHOTO)
        continue;
      CropInfo localCropInfo = (CropInfo)localMap.get(str1);
      ((PhotoItem)localMediaItem).a(localCropInfo);
    }
  }

  public static CropInfo b(CropState paramCropState)
  {
    int i = 0;
    Matrix localMatrix1 = paramCropState.m();
    Matrix localMatrix2 = new Matrix();
    float[] arrayOfFloat;
    if (localMatrix1.invert(localMatrix2))
    {
      arrayOfFloat = new float[8];
      arrayOfFloat[0] = paramCropState.i().left;
      arrayOfFloat[1] = paramCropState.i().top;
      arrayOfFloat[2] = paramCropState.i().right;
      arrayOfFloat[3] = paramCropState.i().top;
      arrayOfFloat[4] = paramCropState.i().right;
      arrayOfFloat[5] = paramCropState.i().bottom;
      arrayOfFloat[6] = paramCropState.i().left;
      arrayOfFloat[7] = paramCropState.i().bottom;
      localMatrix2.postConcat(paramCropState.e().c());
      localMatrix2.mapPoints(arrayOfFloat);
      while (i < 4)
      {
        int j = i * 2;
        arrayOfFloat[j] /= paramCropState.e().f();
        int k = 1 + i * 2;
        arrayOfFloat[k] /= paramCropState.e().e();
        i++;
      }
    }
    for (CropInfo localCropInfo = new CropInfo(arrayOfFloat); ; localCropInfo = null)
    {
      return localCropInfo;
      ErrorReporting.a("Crop Photos", "View Matrix couldn't be inverted");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropDatabaseHelper
 * JD-Core Version:    0.6.0
 */