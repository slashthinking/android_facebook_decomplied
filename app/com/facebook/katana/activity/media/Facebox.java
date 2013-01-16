package com.facebook.katana.activity.media;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.facebook.facedetection.Tracker.DetectionData;
import com.facebook.katana.model.FacebookTagLabel;
import com.facebook.katana.provider.LocalFaceboxProvider;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.UUID;

public class Facebox
  implements FacebookTagLabel
{
  private String a;
  private PointF b;
  private float c;
  private float d;

  public Facebox(Tracker.DetectionData paramDetectionData)
  {
    this.a = UUID.randomUUID().toString();
    this.b = new PointF(paramDetectionData.c(), paramDetectionData.d());
    this.c = paramDetectionData.a();
    this.d = paramDetectionData.b();
  }

  public Facebox(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.b = new PointF(paramFloat1, paramFloat2);
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.a = paramString;
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = 1;
    int j;
    int k;
    if (Math.abs(paramFloat1 - this.b.x) < this.c / 2.0F)
    {
      j = i;
      if (Math.abs(paramFloat2 - this.b.y) >= this.d / 2.0F)
        break label70;
      k = i;
      label52: if ((j == 0) || (k == 0))
        break label76;
    }
    while (true)
    {
      return i;
      j = 0;
      break;
      label70: k = 0;
      break label52;
      label76: i = 0;
    }
  }

  public int a(String paramString, Context paramContext)
  {
    String str = StringLocaleUtil.a("%s = ? AND %s = ?", new Object[] { "image_hash", "facebox_id" });
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    arrayOfString[1] = this.a;
    return paramContext.getContentResolver().delete(LocalFaceboxProvider.a, str, arrayOfString);
  }

  public ContentValues a(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("facebox_id", this.a);
    localContentValues.put("x_pos", Float.valueOf(this.b.x));
    localContentValues.put("y_pos", Float.valueOf(this.b.y));
    localContentValues.put("width", Float.valueOf(b()));
    localContentValues.put("height", Float.valueOf(c()));
    localContentValues.put("image_hash", paramString);
    return localContentValues;
  }

  public PointF a()
  {
    return this.b;
  }

  public View a(RectF paramRectF, Context paramContext)
  {
    RectF localRectF = new RectF((this.b.x - this.c / 2.0F) * paramRectF.width() / 100.0F + paramRectF.left, (this.b.y - this.d / 2.0F) * paramRectF.height() / 100.0F + paramRectF.top, (this.b.x + this.c / 2.0F) * paramRectF.width() / 100.0F + paramRectF.left, (this.b.y + this.d / 2.0F) * paramRectF.height() / 100.0F + paramRectF.top);
    Facebox.FaceRect localFaceRect = new Facebox.FaceRect(this, paramContext);
    localFaceRect.a(localRectF);
    return localFaceRect;
  }

  public String a(Context paramContext)
  {
    return paramContext.getString(2131363011);
  }

  public boolean a(PointF paramPointF)
  {
    return a(paramPointF.x, paramPointF.y);
  }

  public float[] a(RectF paramRectF)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (this.b.x / 100.0F * paramRectF.width() + paramRectF.left);
    arrayOfFloat[1] = (this.b.y / 100.0F * paramRectF.height() + paramRectF.top + c() / 100.0F * paramRectF.height() / 4.0F);
    return arrayOfFloat;
  }

  public float b()
  {
    return this.c;
  }

  public boolean b(PointF paramPointF)
  {
    return a(100.0F * paramPointF.x, 100.0F * paramPointF.y);
  }

  public double c(PointF paramPointF)
  {
    float f1 = 100.0F * paramPointF.x - this.b.x;
    float f2 = 100.0F * paramPointF.y - this.b.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }

  public float c()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Facebox
 * JD-Core Version:    0.6.0
 */