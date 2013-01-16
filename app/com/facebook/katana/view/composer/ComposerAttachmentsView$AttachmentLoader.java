package com.facebook.katana.view.composer;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.activity.media.crop.CroppedImageGenerator;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageException;
import com.facebook.katana.util.ImageUtils.ImageOutOfMemoryException;
import java.util.Iterator;
import java.util.List;

class ComposerAttachmentsView$AttachmentLoader extends AsyncTask<Void, ImageView, Void>
{
  private LinearLayout.LayoutParams b;

  private ComposerAttachmentsView$AttachmentLoader(ComposerAttachmentsView paramComposerAttachmentsView)
  {
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    this.b = new LinearLayout.LayoutParams(ComposerAttachmentsView.a(this.a), ComposerAttachmentsView.a(this.a));
    this.b.setMargins(0, 0, ComposerAttachmentsView.b(this.a), 0);
    Iterator localIterator = ComposerAttachmentsView.c(this.a).iterator();
    MediaItem localMediaItem;
    do
    {
      if (!localIterator.hasNext())
        break;
      localMediaItem = (MediaItem)localIterator.next();
    }
    while (localMediaItem.e() != MediaItem.MediaType.PHOTO);
    while (true)
    {
      Bitmap localBitmap2;
      try
      {
        if (!((PhotoItem)localMediaItem).i())
          continue;
        localBitmap2 = CroppedImageGenerator.a((PhotoItem)localMediaItem, ComposerAttachmentsView.a(this.a), ComposerAttachmentsView.a(this.a));
        if (localBitmap2 == null)
          break;
        ImageView localImageView = new ImageView(this.a.getContext());
        localImageView.setBackgroundResource(2130837540);
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (((PhotoItem)localMediaItem).i())
          break label296;
        localBitmap3 = ImageUtils.a(localBitmap2, ((PhotoItem)localMediaItem).h(), true);
        localImageView.setImageBitmap(localBitmap3);
        localImageView.setOnClickListener(this.a);
        localImageView.setTag(localMediaItem);
        publishProgress(new ImageView[] { localImageView });
      }
      catch (ImageUtils.ImageOutOfMemoryException localImageOutOfMemoryException)
      {
        ErrorReporting.a("ComposerMediaAttachment", "out of memory error", localImageOutOfMemoryException);
        break;
        Bitmap localBitmap1 = ImageUtils.a(localMediaItem.b(), ComposerAttachmentsView.a(this.a), ComposerAttachmentsView.a(this.a));
        if (localBitmap1 == null)
          break;
        localBitmap2 = ImageUtils.a(localBitmap1, ComposerAttachmentsView.a(this.a));
        localBitmap1.recycle();
        continue;
      }
      catch (ImageUtils.ImageException localImageException)
      {
        ErrorReporting.a("ComposerMediaAttachment", "image decode error", localImageException);
      }
      break;
      return null;
      label296: Bitmap localBitmap3 = localBitmap2;
    }
  }

  protected void a(Void paramVoid)
  {
    if ((ComposerAttachmentsView.c(this.a).size() > 0) && (ComposerAttachmentsView.e(this.a)))
      View.inflate(this.a.getContext(), 2130903101, ComposerAttachmentsView.d(this.a)).setOnClickListener(this.a);
  }

  protected void a(ImageView[] paramArrayOfImageView)
  {
    ImageView localImageView;
    if (paramArrayOfImageView.length >= 1)
    {
      localImageView = paramArrayOfImageView[0];
      if (localImageView != null)
        break label15;
    }
    while (true)
    {
      return;
      label15: ComposerAttachmentsView.d(this.a).addView(localImageView, this.b);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.composer.ComposerAttachmentsView.AttachmentLoader
 * JD-Core Version:    0.6.0
 */