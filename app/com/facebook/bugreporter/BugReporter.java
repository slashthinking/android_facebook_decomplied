package com.facebook.bugreporter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public class BugReporter
{
  private static Class<?> a = BugReporter.class;
  private final Resources b;
  private final ListeningExecutorService c;
  private final Executor d;
  private final BugReporterFileUtil e;

  public BugReporter(Resources paramResources, ListeningExecutorService paramListeningExecutorService, Executor paramExecutor, BugReporterFileUtil paramBugReporterFileUtil)
  {
    this.b = paramResources;
    this.c = paramListeningExecutorService;
    this.d = paramExecutor;
    this.e = paramBugReporterFileUtil;
  }

  // ERROR //
  private Uri a(Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: new 36	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: ldc 38
    //   7: invokespecial 41	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_3
    //   11: new 43	java/io/FileOutputStream
    //   14: dup
    //   15: aload_3
    //   16: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: astore 4
    //   21: aload_1
    //   22: getstatic 52	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   25: bipush 100
    //   27: aload 4
    //   29: invokevirtual 58	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   32: pop
    //   33: aload 4
    //   35: invokevirtual 61	java/io/FileOutputStream:flush	()V
    //   38: aload_3
    //   39: invokestatic 67	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   42: astore 9
    //   44: aload 9
    //   46: astore 7
    //   48: aload 4
    //   50: iconst_0
    //   51: invokestatic 72	com/google/common/io/Closeables:a	(Ljava/io/Closeable;Z)V
    //   54: goto +29 -> 83
    //   57: astore 5
    //   59: aload 4
    //   61: iconst_0
    //   62: invokestatic 72	com/google/common/io/Closeables:a	(Ljava/io/Closeable;Z)V
    //   65: aload 5
    //   67: athrow
    //   68: astore 6
    //   70: getstatic 19	com/facebook/bugreporter/BugReporter:a	Ljava/lang/Class;
    //   73: ldc 74
    //   75: aload 6
    //   77: invokestatic 79	com/facebook/orca/debug/BLog:d	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   80: aconst_null
    //   81: astore 7
    //   83: aload 7
    //   85: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   21	44	57	finally
    //   0	21	68	java/lang/Exception
    //   48	68	68	java/lang/Exception
  }

  // ERROR //
  private Uri a(File paramFile)
  {
    // Byte code:
    //   0: new 36	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: ldc 81
    //   7: invokespecial 41	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_2
    //   11: new 43	java/io/FileOutputStream
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: astore_3
    //   20: invokestatic 87	org/acra/ErrorReporter:getInstance	()Lorg/acra/ErrorReporter;
    //   23: aconst_null
    //   24: aload_3
    //   25: invokevirtual 91	org/acra/ErrorReporter:writeReportToStream	(Ljava/lang/Throwable;Ljava/io/OutputStream;)V
    //   28: aload_3
    //   29: invokevirtual 61	java/io/FileOutputStream:flush	()V
    //   32: aload_2
    //   33: invokestatic 67	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   36: astore 7
    //   38: aload 7
    //   40: astore 6
    //   42: aload_3
    //   43: iconst_0
    //   44: invokestatic 72	com/google/common/io/Closeables:a	(Ljava/io/Closeable;Z)V
    //   47: goto +28 -> 75
    //   50: astore 4
    //   52: aload_3
    //   53: iconst_0
    //   54: invokestatic 72	com/google/common/io/Closeables:a	(Ljava/io/Closeable;Z)V
    //   57: aload 4
    //   59: athrow
    //   60: astore 5
    //   62: getstatic 19	com/facebook/bugreporter/BugReporter:a	Ljava/lang/Class;
    //   65: ldc 93
    //   67: aload 5
    //   69: invokestatic 79	com/facebook/orca/debug/BLog:d	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: aconst_null
    //   73: astore 6
    //   75: aload 6
    //   77: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   20	38	50	finally
    //   0	20	60	java/lang/Exception
    //   42	60	60	java/lang/Exception
  }

  private BugReport a(Bitmap paramBitmap)
  {
    File localFile = this.e.a();
    if (localFile == null)
      throw new Exception("Could not create directory");
    String str = localFile.getName();
    Uri localUri1 = a(paramBitmap, localFile);
    Uri localUri2 = a(localFile);
    return BugReport.newBuilder().a(Uri.fromFile(localFile)).c(localUri1).b(localUri2).b(str).i();
  }

  private <T> ListenableFuture<T> a(Activity paramActivity, int paramInt, Callable<T> paramCallable)
  {
    try
    {
      PackageManager localPackageManager = paramActivity.getPackageManager();
      CharSequence localCharSequence = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramActivity.getPackageName(), 0));
      localObject = null;
      if (localCharSequence != null)
      {
        String str = localCharSequence.toString();
        localObject = str;
      }
      if (Strings.isNullOrEmpty((String)localObject))
        localObject = paramActivity.getString(2131361990);
      ProgressDialog localProgressDialog = ProgressDialog.show(paramActivity, (CharSequence)localObject, this.b.getString(paramInt), true);
      ListenableFuture localListenableFuture = this.c.a(paramCallable);
      Futures.a(localListenableFuture, new BugReporter.3(this, localProgressDialog), this.d);
      localProgressDialog.setCancelable(true);
      localProgressDialog.setCanceledOnTouchOutside(false);
      localProgressDialog.setOnDismissListener(new BugReporter.4(this, localListenableFuture));
      return localListenableFuture;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        BLog.d(a, localNameNotFoundException.getMessage());
        Object localObject = null;
      }
    }
  }

  private void a(Activity paramActivity, BugReport paramBugReport)
  {
    Intent localIntent = new Intent(paramActivity, BugReportActivity.class);
    localIntent.putExtra("report", paramBugReport);
    paramActivity.startActivity(localIntent);
  }

  private void a(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CancellationException));
    while (true)
    {
      return;
      BLog.a("Failed to create bug report", paramThrowable);
    }
  }

  private Bitmap b(Activity paramActivity)
  {
    View localView = paramActivity.getWindow().getDecorView().findViewById(16908290);
    Bitmap localBitmap = Bitmap.createBitmap(localView.getWidth(), localView.getHeight(), Bitmap.Config.RGB_565);
    localView.draw(new Canvas(localBitmap));
    return localBitmap;
  }

  public void a(Activity paramActivity)
  {
    Futures.a(a(paramActivity, 2131362013, new BugReporter.1(this, b(paramActivity))), new BugReporter.2(this, paramActivity), this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReporter
 * JD-Core Version:    0.6.0
 */