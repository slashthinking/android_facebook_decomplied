package com.facebook.katana.activity.media;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.PointF;
import android.widget.ArrayAdapter;
import com.facebook.katana.features.tagging.TagTypeaheadAdapter;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.provider.LocalPhotoTagProvider;
import com.facebook.photos.photogallery.GalleryLauncher;
import com.facebook.photos.photogallery.photogalleries.production.ProductionPhotoDataAdapter;
import com.facebook.photos.photogallery.tags.Tag;

class MediaPickerActivity$ProductionPhotoDataAdapterImpl
  implements ProductionPhotoDataAdapter
{
  private MediaPickerActivity$ProductionPhotoDataAdapterImpl(MediaPickerActivity paramMediaPickerActivity)
  {
  }

  public ArrayAdapter a()
  {
    return new TagTypeaheadAdapter(this.a.getApplicationContext());
  }

  public void a(long paramLong, Tag paramTag)
  {
    FacebookPhotoTag localFacebookPhotoTag = new FacebookPhotoTag("", paramTag.c(), paramTag.a().x, paramTag.a().y, 0L, paramTag.b());
    ContentValues localContentValues = MediaTagController.a((MediaItem)MediaPickerActivity.d(this.a).getItem(MediaPickerActivity.p(this.a).getCurrentIndex()), localFacebookPhotoTag);
    this.a.getContentResolver().insert(LocalPhotoTagProvider.a, localContentValues);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaPickerActivity.ProductionPhotoDataAdapterImpl
 * JD-Core Version:    0.6.0
 */