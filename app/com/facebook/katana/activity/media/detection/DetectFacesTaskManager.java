package com.facebook.katana.activity.media.detection;

import com.facebook.katana.activity.media.MediaTagController;
import com.facebook.katana.model.PhotoItem;
import com.google.common.collect.Lists;
import java.util.List;

public class DetectFacesTaskManager
{
  private MediaTagController a;
  private DetectFacesTaskManager.FaceDetectionListener b;
  private long c;
  private boolean d = false;
  private List<PhotoItem> e = Lists.a();

  public DetectFacesTaskManager(MediaTagController paramMediaTagController)
  {
    this.a = paramMediaTagController;
    this.b = new DetectFacesTaskManager.FaceDetectionCompletionHandler(this, null);
  }

  private void a()
  {
    PhotoItem localPhotoItem = (PhotoItem)this.e.remove(0);
    new DetectFacesTask(this.a, this.b).execute(new PhotoItem[] { localPhotoItem });
    this.d = true;
  }

  public void a(List<PhotoItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      throw new IllegalArgumentException();
    if (this.e.size() > 0)
      while (!this.e.isEmpty())
        this.e.remove(0);
    this.e.addAll(paramList);
    this.c = ((PhotoItem)paramList.get(0)).a();
    if (!this.d)
      a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.detection.DetectFacesTaskManager
 * JD-Core Version:    0.6.0
 */