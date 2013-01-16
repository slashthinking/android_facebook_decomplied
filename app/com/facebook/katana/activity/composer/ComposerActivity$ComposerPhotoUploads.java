package com.facebook.katana.activity.composer;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.ipc.model.PrivacySetting;
import com.facebook.katana.activity.media.FacebookPhotoTagSet;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.service.method.GraphFeedPublish.ImplicitLocation;
import com.facebook.katana.service.method.MediaPublisherController.MediaUploadAndPublisher;
import com.facebook.katana.service.method.MediaUploaderController.MediaUnpublishedPhoto;
import com.facebook.katana.service.method.MediaUploaderController.MediaUnpublishedPhoto.SourceType;
import com.facebook.katana.service.method.MediaUploaderController.MediaUploadRequest;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ComposerActivity$ComposerPhotoUploads extends Thread
{
  private final List<MediaItem> b;
  private final Intent c;
  private final String d;
  private final PrivacySetting e;
  private final long f;
  private final MediaPublisherController.MediaUploadAndPublisher g;

  public ComposerActivity$ComposerPhotoUploads(List<MediaItem> paramList, Intent paramIntent, String paramString, PrivacySetting paramPrivacySetting, long paramLong)
  {
    this.b = paramIntent;
    this.c = paramString;
    this.d = paramPrivacySetting;
    this.e = paramLong;
    Object localObject;
    this.f = localObject;
    this.g = new MediaPublisherController.MediaUploadAndPublisher(paramList.getApplicationContext());
  }

  private File a(MediaItem paramMediaItem)
  {
    File localFile1 = new File(paramMediaItem.b());
    File localFile2 = new File(ComposerActivity.c(this.a), "resized_" + StringUtils.a(6));
    try
    {
      if ((paramMediaItem.e() == MediaItem.MediaType.PHOTO) && (((PhotoItem)paramMediaItem).i()))
        ImageUtils.a(this.a, localFile1, localFile2, (PhotoItem)paramMediaItem, 960, 960, 100);
      else
        ImageUtils.a(this.a, localFile1, localFile2, 960, 960, 100);
    }
    catch (Exception localException)
    {
      FbErrorReporter localFbErrorReporter = ComposerActivity.c(this.a);
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = getClass();
      arrayOfObject1[1] = Uri.fromFile(localFile1);
      localFbErrorReporter.a("photo upload error", StringLocaleUtil.a("Failed composer photo upload (step=%s, file=%s)", arrayOfObject1), localException);
      this.a.runOnUiThread(new ComposerActivity.ComposerPhotoUploads.1(this));
      Log.a(this.a.x(), "Error starting upload: ", localException);
      PhotoFlowLogger localPhotoFlowLogger = ComposerActivity.J(this.a);
      Class localClass = localException.getClass();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Uri.fromFile(localFile1);
      localPhotoFlowLogger.a(localClass, StringUtil.a("{photo_process_error:%s}", arrayOfObject2));
    }
    return localFile2;
  }

  public void run()
  {
    if ((ComposerActivity.A(this.a) != null) && (ComposerActivity.B(this.a)));
    for (String str1 = ComposerActivity.A(this.a).a(); ; str1 = null)
    {
      long l = -1L;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      label84: MediaItem localMediaItem;
      List localList;
      ArrayList localArrayList3;
      label161: MediaUploaderController.MediaUploadRequest localMediaUploadRequest;
      label246: PhotoItem localPhotoItem;
      if (ComposerActivity.C(this.a) != null)
      {
        l = ComposerActivity.C(this.a).mPageId;
        localArrayList1 = Lists.a(this.b);
        localArrayList2 = Lists.a();
        int i = localArrayList1.size();
        Iterator localIterator = localArrayList1.iterator();
        if (!localIterator.hasNext())
          break label504;
        localMediaItem = (MediaItem)localIterator.next();
        MediaItem.MediaType localMediaType1 = localMediaItem.e();
        MediaItem.MediaType localMediaType2 = MediaItem.MediaType.PHOTO;
        Object localObject = null;
        if (localMediaType1 == localMediaType2)
        {
          FacebookPhotoTagSet localFacebookPhotoTagSet = ((PhotoItem)localMediaItem).k();
          localObject = null;
          if (localFacebookPhotoTagSet != null)
          {
            localList = localFacebookPhotoTagSet.d();
            if (localList != null)
              break label405;
            localArrayList3 = null;
            localObject = localArrayList3;
          }
        }
        localMediaUploadRequest = new MediaUploaderController.MediaUploadRequest(this.d, -1L, -1L, false, l, localObject, this.f, this.e, i, ComposerActivity.F(this.a));
        if ((localMediaItem.g()) && ((localMediaItem.e() != MediaItem.MediaType.PHOTO) || (!((PhotoItem)localMediaItem).i())))
          break label419;
        localMediaUploadRequest.a(a(localMediaItem));
        localMediaUploadRequest.a(this.c);
        if ((ComposerActivity.G(this.a) != null) && (localMediaItem.e() == MediaItem.MediaType.PHOTO))
        {
          localPhotoItem = (PhotoItem)localMediaItem;
          if (!localPhotoItem.g())
            break label441;
          if (ComposerActivity.G(this.a).containsKey(Long.valueOf(localPhotoItem.f())))
          {
            MediaUploaderController.MediaUnpublishedPhoto localMediaUnpublishedPhoto2 = (MediaUploaderController.MediaUnpublishedPhoto)ComposerActivity.G(this.a).get(Long.valueOf(localPhotoItem.f()));
            if (localMediaUnpublishedPhoto2.c() == MediaUploaderController.MediaUnpublishedPhoto.SourceType.FROM_VAULT)
              localMediaUploadRequest.a(localMediaUnpublishedPhoto2);
          }
        }
      }
      while (true)
      {
        localArrayList2.add(localMediaUploadRequest);
        break label84;
        if ((!ComposerActivity.D(this.a)) || (ComposerActivity.E(this.a) == null))
          break;
        l = ComposerActivity.E(this.a).b.longValue();
        break;
        label405: localArrayList3 = new ArrayList(localList);
        break label161;
        label419: if (!localMediaItem.g())
          break label246;
        localMediaUploadRequest.a(a(localMediaItem));
        break label246;
        label441: if (!ComposerActivity.G(this.a).containsKey(localPhotoItem.b()))
          continue;
        MediaUploaderController.MediaUnpublishedPhoto localMediaUnpublishedPhoto1 = (MediaUploaderController.MediaUnpublishedPhoto)ComposerActivity.G(this.a).get(localPhotoItem.b());
        if (localMediaUnpublishedPhoto1.c() != MediaUploaderController.MediaUnpublishedPhoto.SourceType.FROM_LOCAL_FILE)
          continue;
        localMediaUploadRequest.a(localMediaUnpublishedPhoto1);
      }
      label504: GraphFeedPublish.ImplicitLocation localImplicitLocation;
      String str3;
      label538: PhotoFlowLogger localPhotoFlowLogger;
      int j;
      if (ComposerActivity.D(this.a))
      {
        localImplicitLocation = GraphFeedPublish.ImplicitLocation.ENABLED;
        String str2 = StringUtils.a(8);
        if (l <= 0L)
          break label669;
        str3 = Long.toString(l);
        MediaPublisherController.MediaUploadAndPublisher localMediaUploadAndPublisher = this.g;
        String str4 = this.d;
        Set localSet = ComposerActivity.H(this.a);
        String str5 = ComposerActivity.I(this.a);
        PrivacySetting localPrivacySetting = this.e;
        localMediaUploadAndPublisher.a(localArrayList1, localArrayList2, str4, "", str3, str1, localSet, str2, str5, localPrivacySetting, localImplicitLocation);
        localPhotoFlowLogger = ComposerActivity.J(this.a);
        j = localArrayList1.size();
        if (ComposerActivity.H(this.a) == null)
          break label675;
      }
      label669: label675: for (int k = ComposerActivity.H(this.a).size(); ; k = 0)
      {
        localPhotoFlowLogger.a(false, j, k, JMStaticKeysDictDestination.Encoder.a(this.e), str1);
        return;
        localImplicitLocation = GraphFeedPublish.ImplicitLocation.DISABLED;
        break;
        str3 = null;
        break label538;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.ComposerPhotoUploads
 * JD-Core Version:    0.6.0
 */