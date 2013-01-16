package com.facebook.katana.activity.media.detection;

import com.facebook.katana.activity.media.MediaTagController;
import java.util.List;

class DetectFacesTaskManager$FaceDetectionCompletionHandler
  implements DetectFacesTaskManager.FaceDetectionListener
{
  private DetectFacesTaskManager$FaceDetectionCompletionHandler(DetectFacesTaskManager paramDetectFacesTaskManager)
  {
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    DetectFacesTaskManager.a(this.a, false);
    if ((paramLong == DetectFacesTaskManager.a(this.a)) && (paramBoolean))
      DetectFacesTaskManager.b(this.a).j();
    if (!paramBoolean)
      DetectFacesTaskManager.b(this.a).l();
    if (DetectFacesTaskManager.c(this.a).size() > 0)
      DetectFacesTaskManager.d(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.detection.DetectFacesTaskManager.FaceDetectionCompletionHandler
 * JD-Core Version:    0.6.0
 */