package com.facebook.orca.attachments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.images.ImageScalingUtil;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.protocol.base.ByteArrayBody;
import com.facebook.orca.protocol.base.ContentBody;
import com.facebook.orca.protocol.base.DataStreamBody;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public class MediaAttachmentUtil
{
  private final Class<?> a = MediaAttachmentUtil.class;
  private final Context b;
  private final ImageAttachmentDecoder c;
  private final ImageScalingUtil d;
  private final AndroidThreadUtil e;

  public MediaAttachmentUtil(Context paramContext, ImageAttachmentDecoder paramImageAttachmentDecoder, ImageScalingUtil paramImageScalingUtil, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.b = paramContext;
    this.c = paramImageAttachmentDecoder;
    this.d = paramImageScalingUtil;
    this.e = paramAndroidThreadUtil;
  }

  private ByteArrayBody a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    long l = System.currentTimeMillis();
    return new ByteArrayBody(localByteArrayOutputStream.toByteArray(), "image/jpeg", l + ".jpg");
  }

  private Bitmap b(MediaAttachment paramMediaAttachment, int paramInt)
  {
    Bitmap localBitmap = this.c.a(paramMediaAttachment, paramInt);
    if (localBitmap == null)
      BLog.b(this.a, "Unable to read the original bitmap");
    return localBitmap;
  }

  public Bitmap a(MediaAttachment paramMediaAttachment, int paramInt)
  {
    int i = SizeUtil.a(this.b, paramInt);
    MediaResource localMediaResource = paramMediaAttachment.a();
    int j = MediaAttachmentUtil.1.a[localMediaResource.b().ordinal()];
    Bitmap localBitmap1 = null;
    switch (j)
    {
    default:
      BLog.b(this.a, "Unexpected attachment type");
    case 3:
    case 1:
    case 2:
    }
    while (true)
    {
      return localBitmap1;
      Bitmap localBitmap3 = b(paramMediaAttachment, i);
      localBitmap1 = null;
      if (localBitmap3 != null)
      {
        localBitmap1 = this.d.a(localBitmap3, i);
        continue;
        Bitmap localBitmap2 = ThumbnailUtils.createVideoThumbnail(localMediaResource.c().getPath(), 3);
        if (localBitmap2 == null)
        {
          BLog.b(this.a, "Unable to generate a thumbnail for the video");
          localBitmap1 = null;
        }
        else
        {
          localBitmap1 = this.d.a(localBitmap2, i);
        }
      }
    }
  }

  public ContentBody a(MediaAttachment paramMediaAttachment)
  {
    Object localObject;
    switch (MediaAttachmentUtil.1.a[paramMediaAttachment.a().b().ordinal()])
    {
    default:
      BLog.b(this.a, "Unexpected attachment type");
      localObject = null;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return localObject;
      WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
      int i = localWindowManager.getDefaultDisplay().getWidth();
      int j = (int)(1.1D * Math.max(localWindowManager.getDefaultDisplay().getHeight(), i));
      Bitmap localBitmap = b(paramMediaAttachment, j);
      if (localBitmap == null)
      {
        localObject = null;
      }
      else
      {
        localObject = a(this.d.a(localBitmap, j));
        continue;
        localObject = new DataStreamBody(new File(paramMediaAttachment.a().c().getPath()), "video/3gpp", System.currentTimeMillis() + ".3gp");
        continue;
        File localFile = new File(paramMediaAttachment.a().c().getPath());
        String str = System.currentTimeMillis() + "-" + paramMediaAttachment.a().f();
        localObject = new DataStreamBody(localFile, "audio/MPEG", "audioclip-" + str + ".mp4");
      }
    }
  }

  public byte[] a(MediaAttachment paramMediaAttachment, int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap1 = this.c.a(paramMediaAttachment, paramInt1, paramInt2);
    Object localObject1 = null;
    int i = 0;
    Bitmap localBitmap2;
    label55: int j;
    int k;
    Object localObject3;
    int m;
    label70: byte[] arrayOfByte;
    label120: int i1;
    if (i < 4)
      if ((localBitmap1.getHeight() > paramInt2) || (localBitmap1.getWidth() > paramInt1))
      {
        localBitmap2 = this.d.a(localBitmap1, paramInt1, paramInt2);
        j = -1;
        k = 95;
        localObject3 = localObject1;
        m = 2147483647;
        if (k == j)
          break label251;
        localObject3 = new ByteArrayOutputStream();
        boolean bool = localBitmap2.compress(Bitmap.CompressFormat.JPEG, k, (OutputStream)localObject3);
        m = ((ByteArrayOutputStream)localObject3).size();
        if ((m == 0) || (!bool))
        {
          arrayOfByte = null;
          return arrayOfByte;
        }
        if (m <= paramInt3)
        {
          i1 = m;
          localObject1 = localObject3;
        }
      }
    label251: int i3;
    for (int i2 = i1; ; i2 = i3)
    {
      if (i2 <= paramInt3);
      for (Object localObject2 = localObject1; ; localObject2 = localObject1)
      {
        if ((localObject2 != null) && (localObject2.size() <= paramInt3))
        {
          arrayOfByte = localObject2.toByteArray();
          break label120;
          int n = Math.max(k - 10, 50);
          j = k;
          k = n;
          break label70;
          paramInt1 = (int)(0.75D * localBitmap2.getWidth());
          paramInt2 = (int)(0.75D * localBitmap2.getHeight());
          i++;
          break;
        }
        arrayOfByte = null;
        break label120;
        localBitmap2 = localBitmap1;
        break label55;
      }
      i3 = m;
      localObject1 = localObject3;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.MediaAttachmentUtil
 * JD-Core Version:    0.6.2
 */