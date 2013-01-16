package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder;
import com.facebook.common.util.Log;
import com.facebook.ipc.model.PrivacySetting;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.PhotoItem;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.analytics.PhotoFlowLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MediaPublisherController$MediaUploadAndPublisher
  implements MediaUploaderController.MediaUploadListener
{
  private Context a;
  private MediaUploaderController b;
  private MediaPublisherController c;
  private ArrayList<MediaItem> d;
  private ArrayList<MediaUploaderController.MediaUploadRequest> e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private Set<Long> k;
  private PrivacySetting l;
  private boolean m;
  private boolean n;
  private GraphFeedPublish.ImplicitLocation o;
  private final PhotoFlowLogger p;

  public MediaPublisherController$MediaUploadAndPublisher(Context paramContext)
  {
    this.a = paramContext;
    this.b = new MediaUploaderController(paramContext);
    this.c = null;
    this.d = null;
    this.b.a(this);
    this.m = false;
    this.p = ((PhotoFlowLogger)FbInjector.a(paramContext).a(PhotoFlowLogger.class));
  }

  public void a(String paramString1, int paramInt1, String paramString2, FacebookPhoto paramFacebookPhoto, String paramString3, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean)
  {
  }

  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, long paramLong1, long paramLong2)
  {
    Log.e(MediaPublisherController.b(), "Error uploading photo (" + paramInt1 + "): " + paramString2);
  }

  public void a(ArrayList<MediaItem> paramArrayList, ArrayList<MediaUploaderController.MediaUploadRequest> paramArrayList1, String paramString1, String paramString2, String paramString3, String paramString4, Set<Long> paramSet, String paramString5, String paramString6, PrivacySetting paramPrivacySetting, GraphFeedPublish.ImplicitLocation paramImplicitLocation)
  {
    this.d = paramArrayList;
    this.e = paramArrayList1;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramString3;
    this.i = paramString1;
    this.j = paramString2;
    this.k = paramSet;
    this.l = paramPrivacySetting;
    if (this.l == null)
      this.l = new PrivacySetting("SELF");
    this.o = paramImplicitLocation;
    this.p.a(this.g);
    boolean bool1;
    if (this.d.size() == 1)
    {
      bool1 = true;
      this.m = bool1;
      if (paramString4 == null)
        break label190;
    }
    label190: for (boolean bool2 = true; ; bool2 = false)
    {
      this.n = bool2;
      for (int i1 = 0; i1 < this.e.size(); i1++)
      {
        MediaUploaderController.MediaUploadRequest localMediaUploadRequest2 = (MediaUploaderController.MediaUploadRequest)this.e.get(i1);
        localMediaUploadRequest2.a(this.l);
        if (paramString4 == null)
          continue;
        localMediaUploadRequest2.a(true);
        localMediaUploadRequest2.a(paramString4);
      }
      bool1 = false;
      break;
    }
    if (this.m)
    {
      MediaUploaderController.MediaUploadRequest localMediaUploadRequest1 = (MediaUploaderController.MediaUploadRequest)this.e.get(0);
      localMediaUploadRequest1.a(true);
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
        localMediaUploadRequest1.a((Long)localIterator.next());
    }
    this.b.a(this.d, this.e, this.g);
  }

  public void a(List<MediaUploaderController.MediaUnpublishedPhoto> paramList, List<MediaItem> paramList1)
  {
    if ((this.m) || (this.n))
    {
      this.p.a(paramList.size(), paramList1.size());
      this.p.b(paramList.size(), paramList1.size());
    }
    while (true)
    {
      return;
      if (paramList1.size() > 0)
      {
        Log.e(MediaPublisherController.b(), "Failed uploads. Notification sent to user for re-try");
        PhotoFlowLogger localPhotoFlowLogger = this.p;
        if (paramList == null);
        for (int i1 = 0; ; i1 = paramList.size())
        {
          localPhotoFlowLogger.a(i1, paramList1.size());
          break;
        }
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MediaUploaderController.MediaUnpublishedPhoto localMediaUnpublishedPhoto = (MediaUploaderController.MediaUnpublishedPhoto)localIterator.next();
        localArrayList.add(new PhotoItem(localMediaUnpublishedPhoto.b(), localMediaUnpublishedPhoto.a(), "", "", 0L, 0, 0L, null, null));
      }
      this.c = MediaPublisherController.a(this.a, Constants.URL.d(this.a), this.i, this.j, localArrayList, JMStaticKeysDictDestination.Encoder.a(this.l), this.k, this.h, this.f, this.g, this.o);
      this.p.a(paramList.size(), paramList1.size());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaPublisherController.MediaUploadAndPublisher
 * JD-Core Version:    0.6.0
 */