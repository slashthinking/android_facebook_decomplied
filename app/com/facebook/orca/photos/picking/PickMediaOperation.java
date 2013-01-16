package com.facebook.orca.photos.picking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.orca.attachments.MediaAttachment;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.camera.CropImage;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.images.ImageSearchActivity;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.media.MediaResource;
import com.google.common.io.ByteStreams;
import com.google.common.io.InputSupplier;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SuppressLint({"WorldWriteableFiles"})
public class PickMediaOperation extends Fragment
{
  private static final Class<?> a = PickMediaOperation.class;
  private MediaAttachmentFactory b;
  private PickMediaOperation.OnMediaPickedListener c;
  private PickMediaParams d;
  private long e = System.currentTimeMillis();

  private void K()
  {
    try
    {
      p().openFileOutput(M(), 3).close();
      p().openFileOutput(N(), 3).close();
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        BLog.a("Exception opening files", localIOException);
    }
  }

  private void L()
  {
    File localFile1 = O();
    File localFile2 = P();
    Intent localIntent = new Intent(p(), CropImage.class);
    localIntent.setDataAndType(Uri.fromFile(localFile1), "image/*");
    localIntent.putExtra("outputX", this.d.c());
    localIntent.putExtra("outputY", this.d.d());
    localIntent.putExtra("aspectX", this.d.e());
    localIntent.putExtra("aspectY", this.d.f());
    localIntent.putExtra("scale", true);
    localIntent.putExtra("output", Uri.fromFile(localFile2));
    localIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    localIntent.setFlags(3);
    if (p().getPackageManager().queryIntentActivities(localIntent, 65536).isEmpty())
      a(MediaResource.a(Uri.fromFile(O())));
    while (true)
    {
      return;
      a(localIntent, 3);
    }
  }

  private String M()
  {
    return "temp-compose-photo_" + this.e + ".jpg";
  }

  private String N()
  {
    return "temp-compose-photo-post-cropped_" + this.e + ".jpg";
  }

  private File O()
  {
    return p().getFileStreamPath(M());
  }

  private File P()
  {
    return p().getFileStreamPath(N());
  }

  private void Q()
  {
    O().deleteOnExit();
    P().deleteOnExit();
  }

  private void R()
  {
    this.d = null;
    if (this.c != null)
      this.c.b();
  }

  private void S()
  {
    this.d = null;
    if (this.c != null)
      this.c.a();
  }

  private void T()
  {
    this.d = null;
    if (this.c != null)
      this.c.c();
  }

  private void a()
  {
    K();
    File localFile = O();
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", Uri.fromFile(localFile));
    localIntent.setFlags(3);
    a(localIntent, 2);
  }

  private void a(MediaResource paramMediaResource)
  {
    this.d = null;
    if (this.c != null)
      this.c.a(paramMediaResource);
  }

  private void a(InputSupplier<? extends InputStream> paramInputSupplier, String paramString)
  {
    ByteStreams.a(paramInputSupplier, new PickMediaOperation.2(this, paramString));
  }

  private void b()
  {
    K();
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.setType("image/*");
    a(localIntent, 1);
  }

  private void c()
  {
    K();
    a(new Intent(p(), ImageSearchActivity.class), 4);
  }

  private void d()
  {
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    localIntent.putExtra("android.intent.extra.durationLimit", 10);
    localIntent.setFlags(3);
    a(localIntent, 5);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
      a(paramInt2, paramIntent);
    while (true)
    {
      return;
      if (paramInt1 == 2)
      {
        b(paramInt2, paramIntent);
        continue;
      }
      if (paramInt1 == 4)
      {
        c(paramInt2, paramIntent);
        continue;
      }
      if (paramInt1 == 3)
      {
        d(paramInt2, paramIntent);
        continue;
      }
      if (paramInt1 != 5)
        continue;
      e(paramInt2, paramIntent);
    }
  }

  public void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      MediaResource localMediaResource = MediaResource.a(paramIntent.getData());
      MediaAttachment localMediaAttachment = this.b.b(localMediaResource);
      if (localMediaAttachment != null)
      {
        BLog.b(a, "Got attachment " + localMediaResource.c());
        try
        {
          File localFile = O();
          a(localMediaAttachment.c(), M());
          if (this.d.b())
          {
            L();
            return;
          }
          a(MediaResource.a(localFile));
        }
        catch (IOException localIOException)
        {
          BLog.d(a, "Got IOException while trying to process file", localIOException);
          R();
        }
      }
      else
      {
        S();
      }
    }
    else
    {
      R();
    }
  }

  public void a(Context paramContext)
  {
    super.a(paramContext);
    this.b = ((MediaAttachmentFactory)FbInjector.a(paramContext).a(MediaAttachmentFactory.class));
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null)
    {
      this.d = ((PickMediaParams)paramBundle.getParcelable("params"));
      this.e = paramBundle.getLong("uniqueId");
    }
  }

  public void a(PickMediaOperation.OnMediaPickedListener paramOnMediaPickedListener)
  {
    this.c = paramOnMediaPickedListener;
  }

  public void a(PickMediaParams paramPickMediaParams)
  {
    this.e = System.currentTimeMillis();
    if (this.d != null)
      BLog.a(a, "Photo operation already in progress. Shouldn't happen");
    FragmentTransaction localFragmentTransaction = r().a();
    Fragment localFragment = r().a("dialog");
    if (localFragment != null)
      localFragmentTransaction.a(localFragment);
    this.d = paramPickMediaParams;
    MediaChoiceDialog localMediaChoiceDialog = MediaChoiceDialog.a(paramPickMediaParams.a(), paramPickMediaParams.g());
    localMediaChoiceDialog.a(new PickMediaOperation.1(this));
    localMediaChoiceDialog.a(localFragmentTransaction, "dialog");
  }

  public void a(PickMediaParams paramPickMediaParams, int paramInt)
  {
    this.e = System.currentTimeMillis();
    if (this.d != null)
      BLog.a(a, "Photo operation already in progress. Shouldn't happen");
    this.d = paramPickMediaParams;
    switch (paramInt)
    {
    case 3:
    default:
    case 2:
    case 1:
    case 4:
    }
    while (true)
    {
      return;
      a();
      continue;
      b();
      continue;
      c();
    }
  }

  public void b(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
      if (this.d.b())
      {
        L();
        Q();
      }
    while (true)
    {
      return;
      a(MediaResource.a(O()));
      break;
      R();
    }
  }

  // ERROR //
  public void c(int paramInt, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_m1
    //   2: if_icmpne +94 -> 96
    //   5: aload_2
    //   6: invokevirtual 271	android/content/Intent:getData	()Landroid/net/Uri;
    //   9: astore 6
    //   11: aload_0
    //   12: invokespecial 70	com/facebook/orca/photos/picking/PickMediaOperation:O	()Ljava/io/File;
    //   15: astore 7
    //   17: aload 7
    //   19: astore 4
    //   21: aload_0
    //   22: new 198	java/io/File
    //   25: dup
    //   26: aload 6
    //   28: invokevirtual 389	android/net/Uri:getPath	()Ljava/lang/String;
    //   31: invokespecial 390	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: invokestatic 395	com/google/common/io/Files:a	(Ljava/io/File;)Lcom/google/common/io/InputSupplier;
    //   37: aload_0
    //   38: invokespecial 44	com/facebook/orca/photos/picking/PickMediaOperation:M	()Ljava/lang/String;
    //   41: invokespecial 295	com/facebook/orca/photos/picking/PickMediaOperation:a	(Lcom/google/common/io/InputSupplier;Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 96	com/facebook/orca/photos/picking/PickMediaOperation:d	Lcom/facebook/orca/photos/picking/PickMediaParams;
    //   48: invokevirtual 297	com/facebook/orca/photos/picking/PickMediaParams:b	()Z
    //   51: ifeq +33 -> 84
    //   54: aload_0
    //   55: invokespecial 299	com/facebook/orca/photos/picking/PickMediaOperation:L	()V
    //   58: return
    //   59: astore_3
    //   60: aconst_null
    //   61: astore 4
    //   63: aload_3
    //   64: astore 5
    //   66: getstatic 22	com/facebook/orca/photos/picking/PickMediaOperation:a	Ljava/lang/Class;
    //   69: ldc_w 304
    //   72: aload 5
    //   74: invokestatic 307	com/facebook/orca/debug/BLog:d	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: aload_0
    //   78: invokespecial 253	com/facebook/orca/photos/picking/PickMediaOperation:R	()V
    //   81: goto -37 -> 44
    //   84: aload_0
    //   85: aload 4
    //   87: invokestatic 302	com/facebook/orca/media/MediaResource:a	(Ljava/io/File;)Lcom/facebook/orca/media/MediaResource;
    //   90: invokespecial 171	com/facebook/orca/photos/picking/PickMediaOperation:a	(Lcom/facebook/orca/media/MediaResource;)V
    //   93: goto -35 -> 58
    //   96: aload_0
    //   97: invokespecial 253	com/facebook/orca/photos/picking/PickMediaOperation:R	()V
    //   100: goto -42 -> 58
    //   103: astore 5
    //   105: goto -39 -> 66
    //
    // Exception table:
    //   from	to	target	type
    //   5	17	59	java/io/IOException
    //   21	44	103	java/io/IOException
  }

  public void d(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      a(MediaResource.a(P()));
      Q();
    }
    while (true)
    {
      return;
      R();
    }
  }

  public void e(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1)
      R();
    while (true)
    {
      return;
      MediaResource localMediaResource = MediaResource.b(paramIntent.getData());
      MediaAttachment localMediaAttachment = this.b.b(localMediaResource);
      if (localMediaAttachment == null)
      {
        S();
        continue;
      }
      BLog.b(a, "Got video attachment " + localMediaAttachment.a().c());
      try
      {
        File localFile = O();
        a(localMediaAttachment.c(), M());
        a(MediaResource.b(localFile));
      }
      catch (IOException localIOException)
      {
        BLog.d(a, "Got IOException while trying to process file", localIOException);
        R();
      }
    }
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putParcelable("params", this.d);
    paramBundle.putLong("uniqueId", this.e);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.picking.PickMediaOperation
 * JD-Core Version:    0.6.0
 */