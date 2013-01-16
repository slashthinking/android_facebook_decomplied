package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.SystemTrayNotificationManager;
import com.facebook.katana.model.FacebookPhotoTagBase;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.provider.VaultImageProvider;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.katana.service.vault.VaultHelpers;
import com.facebook.katana.service.vault.VaultTable;
import com.facebook.katana.util.ReentrantCallback;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MediaUploaderController
{
  private static int j;
  final ReentrantCallback<MediaUploaderController.MediaUploadListener> a;
  private AppSession c = null;
  private MediaUploaderController.MediaUploaderAppSessionListener d = null;
  private Context e = null;
  private ArrayList<MediaUploaderController.VaultMediaUploadRequestState> f;
  private ArrayList<MediaUploaderController.FileMediaUploadRequestState> g;
  private Map<String, MediaUploaderController.VaultMediaUploadRequestState> h = Maps.a();
  private Map<String, MediaUploaderController.FileMediaUploadRequestState> i = Maps.a();
  private int k;
  private int l;
  private ArrayList<MediaItem> m;
  private ArrayList<MediaUploaderController.MediaUploadRequest> n;
  private String o;
  private final PhotoFlowLogger p;
  private ArrayList<MediaUploaderController.MediaUnpublishedPhoto> q;

  static
  {
    if (!MediaUploaderController.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      b = bool;
      j = 0;
      return;
    }
  }

  public MediaUploaderController(Context paramContext)
  {
    this.e = paramContext;
    this.c = AppSession.a(paramContext, true);
    this.a = new ReentrantCallback();
    this.d = new MediaUploaderController.MediaUploaderAppSessionListener(this, null);
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.l = 0;
    this.k = 0;
    this.q = Lists.a();
    this.p = ((PhotoFlowLogger)FbInjector.a(paramContext).a(PhotoFlowLogger.class));
  }

  private long a(Context paramContext, MediaItem paramMediaItem)
  {
    String str = VaultImageProvider.a(paramMediaItem.c(), paramMediaItem.d());
    VaultImageProviderRow localVaultImageProviderRow = ((VaultTable)FbInjector.a(paramContext).a(VaultTable.class)).a(str);
    long l1;
    if (localVaultImageProviderRow != null)
      l1 = localVaultImageProviderRow.b;
    while (true)
    {
      return l1;
      l1 = 0L;
    }
  }

  private String a(Context paramContext, MediaUploaderController.FileMediaUploadRequestState paramFileMediaUploadRequestState, boolean paramBoolean)
  {
    MediaUploaderController.MediaUploadRequest localMediaUploadRequest = paramFileMediaUploadRequestState.d();
    String str1 = "";
    List localList = localMediaUploadRequest.g();
    if (localList != null)
      str1 = FacebookPhotoTagBase.a(localList);
    if (!paramBoolean)
      paramFileMediaUploadRequestState.a(false);
    File localFile = localMediaUploadRequest.l();
    String str2;
    if (localFile == null)
    {
      Log.a("MediaUploaderController", "Resized photo required for uploading non-vault image");
      str2 = null;
    }
    while (true)
    {
      return str2;
      Intent localIntent = localMediaUploadRequest.m();
      this.c.a(localFile.getAbsolutePath(), localIntent);
      paramFileMediaUploadRequestState.c();
      str2 = this.c.a(paramContext, paramFileMediaUploadRequestState.h(), localMediaUploadRequest.a(), localMediaUploadRequest.b(), localFile.getAbsolutePath(), localMediaUploadRequest.c(), localMediaUploadRequest.d(), localMediaUploadRequest.e(), localMediaUploadRequest.f(), str1, localMediaUploadRequest.h(), JMStaticKeysDictDestination.Encoder.a(localMediaUploadRequest.i()), this.l, localMediaUploadRequest.j(), localMediaUploadRequest.k());
      if ((!paramBoolean) && (this.m.size() == 1))
        this.c.a(localFile.getAbsolutePath(), localMediaUploadRequest.m());
      paramFileMediaUploadRequestState.a(str2);
      this.i.put(str2, paramFileMediaUploadRequestState);
    }
  }

  private String a(Context paramContext, MediaUploaderController.VaultMediaUploadRequestState paramVaultMediaUploadRequestState)
  {
    paramVaultMediaUploadRequestState.c();
    MediaUploaderController.MediaUploadRequest localMediaUploadRequest = paramVaultMediaUploadRequestState.d();
    String str = this.c.a(paramContext, paramVaultMediaUploadRequestState.g(), localMediaUploadRequest.a(), localMediaUploadRequest.b(), localMediaUploadRequest.c(), localMediaUploadRequest.d(), localMediaUploadRequest.e(), localMediaUploadRequest.f(), localMediaUploadRequest.g(), localMediaUploadRequest.h(), JMStaticKeysDictDestination.Encoder.a(localMediaUploadRequest.i()));
    paramVaultMediaUploadRequestState.a(str);
    this.h.put(str, paramVaultMediaUploadRequestState);
    return str;
  }

  private boolean a(MediaItem paramMediaItem, MediaUploaderController.MediaUploadRequest paramMediaUploadRequest)
  {
    MediaUploaderController.MediaUnpublishedPhoto localMediaUnpublishedPhoto = paramMediaUploadRequest.n();
    int i1 = 0;
    if (localMediaUnpublishedPhoto == null);
    while (true)
    {
      return i1;
      MediaItem.MediaType localMediaType1 = paramMediaItem.e();
      MediaItem.MediaType localMediaType2 = MediaItem.MediaType.PHOTO;
      i1 = 0;
      if (localMediaType1 != localMediaType2)
        continue;
      MediaUploaderController.MediaUnpublishedPhoto.SourceType localSourceType1 = localMediaUnpublishedPhoto.c();
      MediaUploaderController.MediaUnpublishedPhoto.SourceType localSourceType2 = MediaUploaderController.MediaUnpublishedPhoto.SourceType.FROM_VAULT;
      i1 = 0;
      if (localSourceType1 == localSourceType2)
      {
        boolean bool = paramMediaItem.g();
        i1 = 0;
        if (bool)
          i1 = 1;
      }
      if ((localMediaUnpublishedPhoto.c() == MediaUploaderController.MediaUnpublishedPhoto.SourceType.FROM_LOCAL_FILE) && (paramMediaItem.b().equals(localMediaUnpublishedPhoto.a())))
        i1 = 1;
      if ((i1 == 0) || (this.d == null))
        continue;
      this.d.a(localMediaUnpublishedPhoto, paramMediaItem.b());
    }
  }

  private boolean b()
  {
    int i1 = c();
    if ((i1 < 0) || (i1 >= this.m.size()));
    MediaItem localMediaItem;
    MediaUploaderController.MediaUploadRequest localMediaUploadRequest;
    for (int i2 = 0; ; i2 = 1)
    {
      return i2;
      localMediaItem = (MediaItem)this.m.get(i1);
      localMediaUploadRequest = (MediaUploaderController.MediaUploadRequest)this.n.get(i1);
      Intent localIntent = localMediaUploadRequest.m();
      this.c.a(localMediaUploadRequest.l().getAbsolutePath(), localIntent);
      if (!a(localMediaItem, localMediaUploadRequest))
        break;
    }
    boolean bool = localMediaItem.g();
    long l1 = localMediaItem.f();
    long l2;
    int i3;
    if ((!bool) && (VaultHelpers.a(this.e)))
    {
      long l3 = a(this.e, localMediaItem);
      if (l3 > 0L)
      {
        l2 = l3;
        i3 = 1;
      }
    }
    while (true)
    {
      label140: if (i3 != 0)
      {
        MediaUploaderController.VaultMediaUploadRequestState localVaultMediaUploadRequestState = new MediaUploaderController.VaultMediaUploadRequestState(l2, localMediaItem, localMediaUploadRequest);
        a(this.e, localVaultMediaUploadRequestState);
      }
      while (true)
      {
        i2 = 1;
        break;
        l2 = l1;
        i3 = 0;
        break label140;
        String str = localMediaItem.b();
        int i4 = j;
        j = i4 + 1;
        MediaUploaderController.FileMediaUploadRequestState localFileMediaUploadRequestState = new MediaUploaderController.FileMediaUploadRequestState(str, i4, localMediaItem, localMediaUploadRequest);
        a(this.e, localFileMediaUploadRequestState, true);
      }
      i3 = bool;
      l2 = l1;
    }
  }

  private int c()
  {
    monitorenter;
    try
    {
      int i1 = this.l;
      this.l = (1 + this.l);
      monitorexit;
      return i1;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(MediaUploaderController.MediaUploadListener paramMediaUploadListener)
  {
    this.a.a(paramMediaUploadListener);
  }

  public void a(ArrayList<MediaItem> paramArrayList, ArrayList<MediaUploaderController.MediaUploadRequest> paramArrayList1, String paramString)
  {
    int i1 = 0;
    if ((!b) && ((paramArrayList == null) || (paramArrayList1 == null)))
      throw new AssertionError();
    if ((!b) && (paramArrayList.size() != paramArrayList1.size()))
      throw new AssertionError();
    this.m = paramArrayList;
    this.n = paramArrayList1;
    this.o = paramString;
    this.l = 0;
    this.k = 0;
    this.q.clear();
    this.g.clear();
    this.f.clear();
    this.p.a(this.o);
    if (this.c == null)
    {
      ErrorReporting.a("photo upload error", "application session is null when trying to upload media");
      this.c = AppSession.a(this.e, true);
      if (this.c == null)
      {
        ErrorReporting.a("photo upload error", "photo uploader cannot acquire app session");
        ArrayList localArrayList = this.m;
        int i3 = 0;
        if (localArrayList != null)
          i3 = this.m.size();
        if (i3 > 0)
          SystemTrayNotificationManager.a(this.e, i3, i3, null);
      }
    }
    while (true)
    {
      return;
      this.c.a(this.d);
      int i2 = Math.min(1, paramArrayList.size());
      while (i1 < i2)
      {
        b();
        i1++;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaUploaderController
 * JD-Core Version:    0.6.0
 */