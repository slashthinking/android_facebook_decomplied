package com.facebook.facedetection;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.Log;
import com.facebook.analytics.performance.PerformanceLogger;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

class Tracker$FaceDotComDetector
  implements Tracker.InternalFaceDetector
{
  public Tracker$FaceDotComDetector(Tracker paramTracker, Context paramContext)
  {
    new DataBanksLoader(paramContext);
    if (Build.VERSION.SDK_INT < 14);
    for (int i = 0; !Tracker.a(paramTracker, i); i = 1)
      throw new OutOfMemoryError("NativeTracker allocation failed");
  }

  public List<Tracker.DetectionData> a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = Lists.a();
    Tracker.a(this.a).a("face_detection_tracker");
    try
    {
      int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
      paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      TagDescriptor[] arrayOfTagDescriptor = Tracker.a(this.a, arrayOfInt, paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt, paramBoolean);
      if (arrayOfTagDescriptor != null)
      {
        int i = arrayOfTagDescriptor.length;
        for (int j = 0; j < i; j++)
        {
          TagDescriptor localTagDescriptor = arrayOfTagDescriptor[j];
          if (localTagDescriptor != null)
            localArrayList.add(new Tracker.DetectionData(this.a, localTagDescriptor));
        }
      }
      return localArrayList;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        Log.w("JavaTracker", "OOME in detection: " + localOutOfMemoryError.getMessage());
        Tracker.a(this.a).b("face_detection_tracker");
      }
    }
    finally
    {
      Tracker.a(this.a).b("face_detection_tracker");
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.facedetection.Tracker.FaceDotComDetector
 * JD-Core Version:    0.6.2
 */