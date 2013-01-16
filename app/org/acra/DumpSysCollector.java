package org.acra;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import java.util.Locale;

class DumpSysCollector
{
  protected static String collectMemInfo(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    Debug.MemoryInfo localMemoryInfo1 = new Debug.MemoryInfo();
    Debug.getMemoryInfo(localMemoryInfo1);
    int i = localActivityManager.getMemoryClass();
    int j = (int)(100.0F * ((localMemoryInfo1.nativePrivateDirty + localMemoryInfo1.dalvikPrivateDirty) / (1024.0F * i)));
    int k = (int)(100 * localMemoryInfo1.nativePrivateDirty / (1024.0F * i));
    int m = (int)(100 * (localMemoryInfo1.nativePrivateDirty + localMemoryInfo1.dalvikPrivateDirty + localMemoryInfo1.otherPrivateDirty) / (1024.0F * i));
    int n = (int)(100 * localMemoryInfo1.otherPrivateDirty / (1024.0F * i));
    Locale localLocale1 = Locale.US;
    Object[] arrayOfObject1 = new Object[4];
    arrayOfObject1[0] = Integer.valueOf(j);
    arrayOfObject1[1] = Integer.valueOf(k);
    arrayOfObject1[2] = Integer.valueOf(m);
    arrayOfObject1[3] = Integer.valueOf(n);
    localStringBuilder.append(String.format(localLocale1, "percent dalvik+native / native / d+n+other / other %d / %d / %d / %d", arrayOfObject1));
    localStringBuilder.append("avail/thresh/low? " + localMemoryInfo.availMem + "/" + localMemoryInfo.threshold + "/" + localMemoryInfo.lowMemory + "/" + "(" + (int)((float)(100L * localMemoryInfo.threshold) / (float)localMemoryInfo.availMem) + "%) memclass=" + i);
    localStringBuilder.append("DebugMemInfo(kB): Private / Proportional / Shared");
    Locale localLocale2 = Locale.US;
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = Integer.valueOf(localMemoryInfo1.dalvikPrivateDirty);
    arrayOfObject2[1] = Integer.valueOf(localMemoryInfo1.dalvikPss);
    arrayOfObject2[2] = Integer.valueOf(localMemoryInfo1.dalvikSharedDirty);
    localStringBuilder.append(String.format(localLocale2, "          dalvik: %7d / %7d / %7d", arrayOfObject2));
    Locale localLocale3 = Locale.US;
    Object[] arrayOfObject3 = new Object[3];
    arrayOfObject3[0] = Integer.valueOf(localMemoryInfo1.dalvikPrivateDirty);
    arrayOfObject3[1] = Integer.valueOf(localMemoryInfo1.nativePss);
    arrayOfObject3[2] = Integer.valueOf(localMemoryInfo1.nativeSharedDirty);
    localStringBuilder.append(String.format(localLocale3, "          native: %7d / %7d / %7d", arrayOfObject3));
    Locale localLocale4 = Locale.US;
    Object[] arrayOfObject4 = new Object[3];
    arrayOfObject4[0] = Integer.valueOf(localMemoryInfo1.otherPrivateDirty);
    arrayOfObject4[1] = Integer.valueOf(localMemoryInfo1.otherPss);
    arrayOfObject4[2] = Integer.valueOf(localMemoryInfo1.otherSharedDirty);
    localStringBuilder.append(String.format(localLocale4, "           other: %7d / %7d / %7d", arrayOfObject4));
    Locale localLocale5 = Locale.US;
    Object[] arrayOfObject5 = new Object[3];
    arrayOfObject5[0] = Integer.valueOf(Debug.getGlobalGcInvocationCount());
    arrayOfObject5[1] = Integer.valueOf(Debug.getGlobalFreedSize());
    arrayOfObject5[2] = Integer.valueOf(Debug.getGlobalFreedCount());
    localStringBuilder.append(String.format(localLocale5, "GC: %d GCs, %d freed, %d free count", arrayOfObject5));
    Locale localLocale6 = Locale.US;
    Object[] arrayOfObject6 = new Object[3];
    arrayOfObject6[0] = Long.valueOf(Debug.getNativeHeapSize());
    arrayOfObject6[1] = Long.valueOf(Debug.getNativeHeapAllocatedSize());
    arrayOfObject6[2] = Long.valueOf(Debug.getNativeHeapFreeSize());
    localStringBuilder.append(String.format(localLocale6, "Native Heap: size/allocated/free %7d / %7d / %7d", arrayOfObject6));
    Locale localLocale7 = Locale.US;
    Object[] arrayOfObject7 = new Object[4];
    arrayOfObject7[0] = Integer.valueOf(Debug.getThreadAllocCount());
    arrayOfObject7[1] = Integer.valueOf(Debug.getThreadAllocSize());
    arrayOfObject7[2] = Integer.valueOf(Debug.getThreadExternalAllocCount());
    arrayOfObject7[3] = Integer.valueOf(Debug.getThreadExternalAllocSize());
    localStringBuilder.append(String.format(localLocale7, "Threads: alloc count/alloc size/ext ac/ext as %7d / %7d / %7d / %7d", arrayOfObject7));
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.DumpSysCollector
 * JD-Core Version:    0.6.0
 */