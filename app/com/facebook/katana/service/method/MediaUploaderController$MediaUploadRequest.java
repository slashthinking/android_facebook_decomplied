package com.facebook.katana.service.method;

import android.content.Intent;
import com.facebook.ipc.model.PrivacySetting;
import com.facebook.katana.model.FacebookPhotoTagBase;
import com.facebook.katana.model.FacebookPhotoWithTag;
import java.io.File;
import java.util.List;

public class MediaUploaderController$MediaUploadRequest
{
  private String a;
  private String b;
  private long c;
  private long d;
  private boolean e;
  private long f;
  private List<FacebookPhotoTagBase> g;
  private long h;
  private PrivacySetting i;
  private File j;
  private Intent k;
  private MediaUploaderController.MediaUnpublishedPhoto l;
  private int m;
  private String n;

  public MediaUploaderController$MediaUploadRequest(String paramString1, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, List<FacebookPhotoTagBase> paramList, long paramLong4, PrivacySetting paramPrivacySetting, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramBoolean;
    this.f = paramLong3;
    this.g = paramList;
    this.h = paramLong4;
    this.i = paramPrivacySetting;
    this.m = paramInt;
    this.n = paramString2;
  }

  public String a()
  {
    return this.a;
  }

  public void a(Intent paramIntent)
  {
    this.k = paramIntent;
  }

  public void a(PrivacySetting paramPrivacySetting)
  {
    this.i = paramPrivacySetting;
  }

  public void a(MediaUploaderController.MediaUnpublishedPhoto paramMediaUnpublishedPhoto)
  {
    this.l = paramMediaUnpublishedPhoto;
  }

  public void a(File paramFile)
  {
    this.j = paramFile;
  }

  public void a(Long paramLong)
  {
    FacebookPhotoWithTag localFacebookPhotoWithTag = new FacebookPhotoWithTag(paramLong.longValue());
    this.g.add(localFacebookPhotoWithTag);
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public String b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }

  public long d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.e;
  }

  public long f()
  {
    return this.f;
  }

  public List<FacebookPhotoTagBase> g()
  {
    return this.g;
  }

  public long h()
  {
    return this.h;
  }

  public PrivacySetting i()
  {
    return this.i;
  }

  public int j()
  {
    return this.m;
  }

  public String k()
  {
    return this.n;
  }

  public File l()
  {
    return this.j;
  }

  public Intent m()
  {
    return this.k;
  }

  public MediaUploaderController.MediaUnpublishedPhoto n()
  {
    return this.l;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaUploaderController.MediaUploadRequest
 * JD-Core Version:    0.6.0
 */