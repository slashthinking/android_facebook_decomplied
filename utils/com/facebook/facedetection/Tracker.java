package com.facebook.facedetection;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.device.CpuCapabilities;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Tracker
{
  private static Tracker a = null;
  private static FaceDetectionGating c;
  private static boolean d = false;
  private static boolean e = true;
  private Tracker.InternalFaceDetector b = null;
  private File f;
  private PerformanceLogger g;

  static
  {
    try
    {
      if (CpuCapabilities.a())
      {
        System.loadLibrary("stlport_shared");
        System.loadLibrary("tracker");
        d = true;
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (true)
        Log.w("JavaTracker", "failed to create NativeDetector, UnsatisfiedLinkError");
    }
  }

  private Tracker(Context paramContext)
  {
    this.g = ((PerformanceLogger)FbInjector.a(paramContext).a(PerformanceLogger.class));
    e = b(paramContext);
    this.f = paramContext.getDir("fd-crash-reports", 0);
    try
    {
      if (CpuCapabilities.a())
        if (a(paramContext))
          this.b = new Tracker.FaceDotComDetector(this, paramContext);
        else if (!d)
          ((FbErrorReporter)FbInjector.a(paramContext).a(FbErrorReporter.class)).a("JavaTracker", "failed to create NativeDetector, UnsatisfiedLinkError");
    }
    catch (IOException localIOException)
    {
      ((FbErrorReporter)FbInjector.a(paramContext).a(FbErrorReporter.class)).a("JavaTracker failure", "IOException: " + localIOException.getMessage());
      return;
      ((FbErrorReporter)FbInjector.a(paramContext).a(FbErrorReporter.class)).a("JavaTracker", "failed to create NativeDetector, NEON not supported");
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ((FbErrorReporter)FbInjector.a(paramContext).a(FbErrorReporter.class)).a("JavaTracker failure", "OutOfMemory: " + localOutOfMemoryError.getMessage());
    }
  }

  public static Tracker a(Context paramContext, FaceDetectionGating paramFaceDetectionGating)
  {
    try
    {
      c = paramFaceDetectionGating;
      if (a == null)
        a = new Tracker(paramContext.getApplicationContext());
      Tracker localTracker = a;
      return localTracker;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static boolean a(Context paramContext)
  {
    if ((c.a(paramContext)) && (d) && (CpuCapabilities.a()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private boolean b(Context paramContext)
  {
    long l = ((OrcaSharedPreferences)FbInjector.a(paramContext).a(OrcaSharedPreferences.class)).a(FaceDetectionPrefKeys.b, 0L);
    if (System.currentTimeMillis() > l);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private native boolean init(int paramInt);

  // ERROR //
  public static void nativeCrashed(int paramInt)
  {
    // Byte code:
    //   0: ldc 44
    //   2: ldc 163
    //   4: invokestatic 165	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: new 167	java/io/File
    //   11: dup
    //   12: getstatic 23	com/facebook/facedetection/Tracker:a	Lcom/facebook/facedetection/Tracker;
    //   15: getfield 87	com/facebook/facedetection/Tracker:f	Ljava/io/File;
    //   18: ldc 169
    //   20: invokespecial 172	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore_2
    //   24: new 174	java/io/FileOutputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 177	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: astore_3
    //   33: aload_3
    //   34: new 103	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   41: iload_0
    //   42: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: ldc 182
    //   47: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokevirtual 188	java/lang/String:getBytes	()[B
    //   56: invokevirtual 192	java/io/FileOutputStream:write	([B)V
    //   59: aload_3
    //   60: ifnull +7 -> 67
    //   63: aload_3
    //   64: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   67: return
    //   68: astore 4
    //   70: aconst_null
    //   71: astore_3
    //   72: aload_3
    //   73: ifnull +7 -> 80
    //   76: aload_3
    //   77: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   80: aload 4
    //   82: athrow
    //   83: astore 4
    //   85: goto -13 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   24	33	68	finally
    //   33	59	83	finally
  }

  private native TagDescriptor[] putPhotoNative(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);

  public List<Tracker.DetectionData> a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if ((this.b != null) && (e));
    for (Object localObject = this.b.a(paramBitmap, paramInt, paramBoolean); ; localObject = Lists.a())
      return localObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.facedetection.Tracker
 * JD-Core Version:    0.6.2
 */