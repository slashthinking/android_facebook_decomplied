package com.facebook.katana.activity.media;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.view.vault.GridItemController;
import com.facebook.katana.view.vault.MediaGridItemController;
import com.facebook.photos.analytics.PhotoFlowLogger;

public class MediaPickerGridAdapter extends ForwardingGridAdapter<MediaGridItemController>
{
  private final LayoutInflater b = (LayoutInflater)a().getSystemService("layout_inflater");
  private MediaPickerActivity c;
  private final MediaPickerEnvironment d;
  private final PhotoFlowLogger e;

  public MediaPickerGridAdapter(ImageGridAdapter<MediaGridItemController> paramImageGridAdapter, MediaPickerActivity paramMediaPickerActivity, MediaPickerEnvironment paramMediaPickerEnvironment, PhotoFlowLogger paramPhotoFlowLogger)
  {
    super(paramImageGridAdapter);
    this.c = paramMediaPickerActivity;
    this.d = paramMediaPickerEnvironment;
    this.e = paramPhotoFlowLogger;
  }

  private View a(ViewGroup paramViewGroup)
  {
    View localView = this.b.inflate(2130903275, paramViewGroup, false);
    MediaGridItemController localMediaGridItemController = new MediaGridItemController(localView);
    localMediaGridItemController.a(this);
    localMediaGridItemController.a(this);
    localMediaGridItemController.a(this.d);
    registerDataSetObserver(localMediaGridItemController);
    localView.setTag(localMediaGridItemController);
    return localView;
  }

  public void a(GridItemController paramGridItemController, boolean paramBoolean)
  {
    super.a(paramGridItemController, paramBoolean);
    MediaItem localMediaItem;
    boolean bool;
    if (this.e != null)
    {
      localMediaItem = ((MediaGridItemController)paramGridItemController).c();
      bool = localMediaItem.g();
      if (!bool)
        break label57;
    }
    label57: for (String str = Long.toString(localMediaItem.f()); ; str = localMediaItem.b())
    {
      this.e.a(paramBoolean, bool, false, true, str);
      return;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = a(paramViewGroup);
    return a(paramInt, paramView, paramViewGroup, (MediaGridItemController)paramView.getTag());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaPickerGridAdapter
 * JD-Core Version:    0.6.0
 */