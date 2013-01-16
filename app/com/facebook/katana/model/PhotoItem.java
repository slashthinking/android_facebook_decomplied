package com.facebook.katana.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.katana.activity.media.FacebookPhotoTagSet;
import com.facebook.katana.activity.media.crop.CropInfo;
import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.photos.LocalPhoto;
import com.facebook.photos.photogallery.tags.Tag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhotoItem extends MediaItem
{
  public static final Parcelable.Creator<PhotoItem> CREATOR = new PhotoItem.1();
  private int b;
  private FacebookPhotoTagSet c;
  private byte d;
  private CropInfo e;
  private LocalPhoto f;

  public PhotoItem(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt, long paramLong3, FacebookPhotoTagSet paramFacebookPhotoTagSet, CropInfo paramCropInfo)
  {
    super(paramLong1, paramString1, paramString2, paramString3, paramLong2, paramLong3);
    this.b = paramInt;
    if (paramFacebookPhotoTagSet != null);
    for (this.c = paramFacebookPhotoTagSet; ; this.c = new FacebookPhotoTagSet())
    {
      this.e = paramCropInfo;
      this.f = new LocalPhoto(a(), m(), b(), h());
      return;
    }
  }

  private PhotoItem(Parcel paramParcel)
  {
    super(paramParcel);
    this.b = paramParcel.readInt();
    this.c = ((FacebookPhotoTagSet)paramParcel.readParcelable(FacebookPhotoTagSet.class.getClassLoader()));
    this.d = paramParcel.readByte();
    if (this.d == 1);
    for (this.e = ((CropInfo)paramParcel.readParcelable(CropInfo.class.getClassLoader())); ; this.e = null)
      return;
  }

  private List<Tag> m()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)localIterator.next();
      localArrayList.add(new Tag(localFacebookPhotoTag.b(), localFacebookPhotoTag.f(), localFacebookPhotoTag.a()));
    }
    return localArrayList;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public void a(FacebookPhotoTagSet paramFacebookPhotoTagSet)
  {
    this.c = paramFacebookPhotoTagSet;
    this.f.a(m());
  }

  public void a(CropInfo paramCropInfo)
  {
    this.e = paramCropInfo;
  }

  public int h()
  {
    return this.b;
  }

  public boolean i()
  {
    if ((this.e != null) && (this.e.a() != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public CropInfo j()
  {
    return this.e;
  }

  public FacebookPhotoTagSet k()
  {
    return this.c;
  }

  public Photo l()
  {
    return this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
    if (i())
    {
      paramParcel.writeByte(1);
      paramParcel.writeParcelable(this.e, paramInt);
    }
    while (true)
    {
      return;
      paramParcel.writeByte(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.PhotoItem
 * JD-Core Version:    0.6.0
 */