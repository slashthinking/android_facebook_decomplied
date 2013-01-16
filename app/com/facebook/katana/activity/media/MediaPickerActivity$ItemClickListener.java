package com.facebook.katana.activity.media;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.VideoItem;
import com.facebook.photos.photogallery.GalleryLauncher;
import com.google.common.collect.Lists;

class MediaPickerActivity$ItemClickListener
  implements ImageGridAdapter.OnItemClickListener
{
  private MediaPickerActivity$ItemClickListener(MediaPickerActivity paramMediaPickerActivity)
  {
  }

  public void a(MediaItem paramMediaItem)
  {
    if (MediaPickerActivity.f(this.a).e())
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelableArrayList("extra_media_items", Lists.a(new MediaItem[] { paramMediaItem }));
      this.a.setResult(-1, new Intent().putExtras(localBundle));
      this.a.finish();
    }
    while (true)
    {
      return;
      if (MediaPickerActivity.o(this.a))
      {
        MediaPickerActivity.p(this.a).a(MediaPickerActivity.d(this.a).d(paramMediaItem));
        continue;
      }
      if (!MediaPickerActivity.q(this.a))
        continue;
      if (paramMediaItem.e() == MediaItem.MediaType.PHOTO)
      {
        MediaPickerActivity.e(this.a, false);
        MediaPickerActivity.a(this.a, paramMediaItem, true, true);
        continue;
      }
      MediaPickerActivity.a(this.a, (VideoItem)paramMediaItem);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaPickerActivity.ItemClickListener
 * JD-Core Version:    0.6.0
 */