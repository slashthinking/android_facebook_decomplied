package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.katana.util.StringUtils;
import java.util.Map;

public class MediaPublisherController$PublishPhotoWithAttachMethod extends GraphApiMethod
{
  public MediaPublisherController$PublishPhotoWithAttachMethod(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    super(paramContext, "POST", paramString1, paramString2);
    if (!StringUtils.c(paramString5))
      this.e.put("name", paramString5);
    if (StringUtils.c(paramString6))
      this.e.put("target_post", "{result=status:$.id}");
    while (true)
    {
      c(paramString3);
      d(paramString4);
      return;
      this.e.put("target_post", paramString6);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaPublisherController.PublishPhotoWithAttachMethod
 * JD-Core Version:    0.6.0
 */