package com.facebook.katana.activity.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.service.method.ApiMethod;
import com.facebook.katana.service.method.MediaPublisherController;
import com.facebook.katana.service.method.MediaPublisherController.MediaPublishRetryRequest;
import com.facebook.katana.service.method.MediaPublisherController.MediaPublishRetryStatus;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.photos.analytics.WaterfallIdGenerator;
import java.util.List;

public class MediaRetryPublishActivity extends BaseFacebookActivity
{
  private List<MediaPublisherController.MediaPublishRetryRequest> n;
  private ApiMethod o;

  private void a(Intent paramIntent)
  {
    if ((!paramIntent.hasExtra("extra_publish_status_message")) || (!paramIntent.hasExtra("extra_publish_post_id")) || (!paramIntent.hasExtra("extra_publish_items")))
    {
      Log.e("Debug", "Re-publish intent not properly formatted");
      finish();
    }
    MediaPublisherController.MediaPublishRetryStatus localMediaPublishRetryStatus;
    String str1;
    String str2;
    while (true)
    {
      return;
      boolean bool = paramIntent.hasExtra("extra_publish_status_request");
      localMediaPublishRetryStatus = null;
      if (bool)
        localMediaPublishRetryStatus = (MediaPublisherController.MediaPublishRetryStatus)paramIntent.getParcelableExtra("extra_publish_status_request");
      this.n = paramIntent.getParcelableArrayListExtra("extra_publish_items");
      str1 = paramIntent.getStringExtra("extra_publish_status_message");
      str2 = paramIntent.getStringExtra("extra_publish_post_id");
      if ((this.n != null) && (this.n.size() != 0))
        break;
      Log.e("Debug", "No items to publish. Finish");
      finish();
    }
    PhotoFlowLogger localPhotoFlowLogger = (PhotoFlowLogger)FbInjector.a(getApplicationContext()).a(PhotoFlowLogger.class);
    if (paramIntent.hasExtra("extra_publish_waterfall_id"));
    for (String str3 = paramIntent.getExtras().getString("extra_publish_waterfall_id"); ; str3 = ((WaterfallIdGenerator)FbInjector.a(getApplicationContext()).a(WaterfallIdGenerator.class)).a())
    {
      localPhotoFlowLogger.a(str3);
      localPhotoFlowLogger.c(false);
      Toaster.a(this, 2131363207);
      Log.e("Debug", "Attempt to publish items: " + this.n.size());
      Context localContext = getApplicationContext();
      this.o = MediaPublisherController.a(localContext, Constants.URL.d(localContext), localMediaPublishRetryStatus, str1, this.n, str2, str3);
      finish();
      break;
    }
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    a(getIntent());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaRetryPublishActivity
 * JD-Core Version:    0.6.0
 */