package com.facebook.katana.activity.media;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.katana.model.FacebookPhotoTag;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class FacebookPhotoTagSet
  implements Parcelable, Iterable<FacebookPhotoTag>
{
  public static final Parcelable.Creator<FacebookPhotoTagSet> CREATOR = new FacebookPhotoTagSet.1();
  private final List<FacebookPhotoTag> a = Lists.a();
  private final Set<Long> b = Sets.a();

  public FacebookPhotoTagSet()
  {
  }

  public FacebookPhotoTagSet(Parcel paramParcel)
  {
    this();
    paramParcel.readTypedList(this.a, FacebookPhotoTag.CREATOR);
    this.a.removeAll(Collections.singleton(null));
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)localIterator.next();
      if ((localFacebookPhotoTag == null) || (localFacebookPhotoTag.a() <= 0L))
        continue;
      this.b.add(Long.valueOf(localFacebookPhotoTag.a()));
    }
  }

  public int a()
  {
    return this.a.size();
  }

  public void a(long paramLong)
  {
    int i = 0;
    if (i < this.a.size())
      if (((FacebookPhotoTag)this.a.get(i)).a() != paramLong);
    while (true)
    {
      if ((i >= 0) && (i < this.a.size()))
      {
        this.a.remove(i);
        this.b.remove(Long.valueOf(paramLong));
      }
      return;
      i++;
      break;
      i = -1;
    }
  }

  public void a(FacebookPhotoTagSet paramFacebookPhotoTagSet)
  {
    e();
    this.b.addAll(paramFacebookPhotoTagSet.b);
    this.a.addAll(paramFacebookPhotoTagSet.a);
  }

  public void a(FacebookPhotoTag paramFacebookPhotoTag)
  {
    this.a.add(paramFacebookPhotoTag);
    if (paramFacebookPhotoTag.a() > 0L)
      this.b.add(Long.valueOf(paramFacebookPhotoTag.a()));
  }

  public void a(FacebookPhotoTag paramFacebookPhotoTag, PointF paramPointF)
  {
    if (this.a.contains(paramFacebookPhotoTag))
    {
      int i = this.a.indexOf(paramFacebookPhotoTag);
      ((FacebookPhotoTag)this.a.get(i)).b(paramPointF.x);
      ((FacebookPhotoTag)this.a.get(i)).a(paramPointF.y);
    }
  }

  public void a(List<FacebookPhotoTag> paramList)
  {
    e();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      a((FacebookPhotoTag)localIterator.next());
  }

  public List<FacebookPhotoTag> b()
  {
    return Collections.unmodifiableList(this.a);
  }

  public void b(FacebookPhotoTag paramFacebookPhotoTag)
  {
    this.a.remove(paramFacebookPhotoTag);
    if (paramFacebookPhotoTag.a() > 0L)
      this.b.remove(Long.valueOf(paramFacebookPhotoTag.a()));
  }

  public boolean b(long paramLong)
  {
    return this.b.contains(Long.valueOf(paramLong));
  }

  public ListIterator<FacebookPhotoTag> c()
  {
    return this.a.listIterator();
  }

  public List<FacebookPhotoTag> d()
  {
    ArrayList localArrayList = Lists.b(this.a.size());
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      localArrayList.add((FacebookPhotoTag)localIterator.next());
    ListIterator localListIterator = localArrayList.listIterator();
    while (localListIterator.hasNext())
    {
      if (((FacebookPhotoTag)localListIterator.next()).a() != -2L)
        continue;
      localListIterator.remove();
    }
    return Collections.unmodifiableList(localArrayList);
  }

  public int describeContents()
  {
    return 0;
  }

  public void e()
  {
    this.a.clear();
    this.b.clear();
  }

  public Iterator<FacebookPhotoTag> iterator()
  {
    return Collections.unmodifiableList(this.a).iterator();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.FacebookPhotoTagSet
 * JD-Core Version:    0.6.0
 */