package com.facebook.camera.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera.Size;
import java.util.Iterator;
import java.util.List;

public class MediaUtil
{
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3);
    while (true)
    {
      return paramInt3;
      if (paramInt1 < paramInt2)
      {
        paramInt3 = paramInt2;
        continue;
      }
      paramInt3 = paramInt1;
    }
  }

  public static Camera.Size a(List<Camera.Size> paramList)
  {
    int i = 0;
    Object localObject1 = null;
    if (paramList == null)
      return localObject1;
    Iterator localIterator = paramList.iterator();
    Object localObject2 = null;
    Object localObject3 = null;
    int j = 0;
    label26: Object localObject4;
    int k;
    if (localIterator.hasNext())
    {
      localObject4 = (Camera.Size)localIterator.next();
      float f = ((Camera.Size)localObject4).height / ((Camera.Size)localObject4).width;
      k = ((Camera.Size)localObject4).width * ((Camera.Size)localObject4).height;
      if ((k > j) && (Math.abs(f - 0.75F) < 1.0E-10D))
      {
        localObject3 = localObject4;
        j = k;
      }
      if (k <= i)
        break label149;
    }
    for (int m = k; ; m = i)
    {
      i = m;
      localObject2 = localObject4;
      break label26;
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        break;
      }
      localObject1 = null;
      if (localObject2 == null)
        break;
      localObject1 = localObject2;
      break;
      label149: localObject4 = localObject2;
    }
  }

  public static void a(Matrix paramMatrix, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    float f;
    if (paramBoolean)
      f = -1.0F;
    while (true)
    {
      paramMatrix.setScale(f, 1.0F);
      paramMatrix.postRotate(paramInt1);
      paramMatrix.postScale(paramInt2 / 2000.0F, paramInt3 / 2000.0F);
      paramMatrix.postTranslate(paramInt2 / 2.0F, paramInt3 / 2.0F);
      return;
      f = 1.0F;
    }
  }

  public static void a(RectF paramRectF, Rect paramRect)
  {
    paramRect.left = Math.round(paramRectF.left);
    paramRect.top = Math.round(paramRectF.top);
    paramRect.right = Math.round(paramRectF.right);
    paramRect.bottom = Math.round(paramRectF.bottom);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.utils.MediaUtil
 * JD-Core Version:    0.6.0
 */