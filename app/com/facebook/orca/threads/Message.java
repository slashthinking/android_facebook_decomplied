package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.share.Share;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class Message
  implements Parcelable
{
  public static final Parcelable.Creator<Message> CREATOR = new Message.1();
  private final String a;
  private final String b;
  private final long c;
  private final long d;
  private final ParticipantInfo e;
  private final String f;
  private final String g;
  private final String h;
  private final long i;
  private final Coordinates j;
  private final ImmutableList<MediaResource> k;
  private final ImmutableList<TitanAttachmentInfo> l;
  private final ImmutableList<Share> m;
  private final int n;
  private final ImmutableList<ParticipantInfo> o;
  private final String p;
  private final boolean q;
  private final String r;
  private final Message.ChannelSource s;
  private final ImmutableList<MediaResource> t;
  private final long u;

  private Message(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = ((ParticipantInfo)paramParcel.readParcelable(ParticipantInfo.class.getClassLoader()));
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readLong();
    this.j = ((Coordinates)paramParcel.readParcelable(Coordinates.class.getClassLoader()));
    this.k = ImmutableList.a(paramParcel.readArrayList(MediaResource.class.getClassLoader()));
    this.l = ImmutableList.a(paramParcel.readArrayList(TitanAttachmentInfo.class.getClassLoader()));
    this.m = ImmutableList.a(paramParcel.readArrayList(Share.class.getClassLoader()));
    this.n = paramParcel.readInt();
    this.o = ImmutableList.a(paramParcel.readArrayList(ParticipantInfo.class.getClassLoader()));
    this.p = paramParcel.readString();
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.q = bool;
      this.r = paramParcel.readString();
      this.s = Message.ChannelSource.valueOf(paramParcel.readString());
      this.t = ImmutableList.a(paramParcel.readArrayList(MediaResource.class.getClassLoader()));
      this.u = paramParcel.readLong();
      return;
    }
  }

  Message(MessageBuilder paramMessageBuilder)
  {
    this.a = paramMessageBuilder.a();
    this.b = paramMessageBuilder.b();
    this.c = paramMessageBuilder.c();
    this.d = paramMessageBuilder.d();
    this.e = paramMessageBuilder.e();
    this.f = paramMessageBuilder.f();
    this.g = paramMessageBuilder.g();
    this.h = paramMessageBuilder.h();
    this.i = paramMessageBuilder.i();
    this.j = paramMessageBuilder.j();
    this.k = ImmutableList.a(paramMessageBuilder.k());
    this.l = ImmutableList.a(paramMessageBuilder.l());
    this.m = ImmutableList.a(paramMessageBuilder.m());
    this.n = paramMessageBuilder.n();
    this.o = ImmutableList.a(paramMessageBuilder.o());
    this.p = paramMessageBuilder.p();
    this.q = paramMessageBuilder.q();
    this.r = paramMessageBuilder.r();
    this.s = paramMessageBuilder.s();
    this.t = ImmutableList.a(paramMessageBuilder.t());
    this.u = paramMessageBuilder.u();
  }

  public long A()
  {
    return this.u;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }

  public boolean d()
  {
    if (this.d != 0L);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public int describeContents()
  {
    return 0;
  }

  public long e()
  {
    return this.d;
  }

  public ParticipantInfo f()
  {
    return this.e;
  }

  public String g()
  {
    return this.f;
  }

  public String h()
  {
    return this.g;
  }

  public boolean i()
  {
    if (this.g != null);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public String j()
  {
    return this.h;
  }

  public Coordinates k()
  {
    return this.j;
  }

  public List<MediaResource> l()
  {
    return this.k;
  }

  public ImmutableList<TitanAttachmentInfo> m()
  {
    return this.l;
  }

  public ImmutableList<Share> n()
  {
    return this.m;
  }

  public boolean o()
  {
    if (this.j != null);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public long p()
  {
    return this.i;
  }

  public boolean q()
  {
    if ((this.n != 0) && (this.n != 900) && (this.n != 901));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public int r()
  {
    return this.n;
  }

  public ImmutableList<ParticipantInfo> s()
  {
    return this.o;
  }

  public String t()
  {
    return this.p;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    if (u())
      localStringBuilder.append(" (").append(t()).append(")");
    localStringBuilder.append(" ").append(x());
    localStringBuilder.append(" t: ").append(this.c);
    localStringBuilder.append(" st: ").append(this.d);
    localStringBuilder.append(": ");
    String str = h();
    if (StringUtil.a(str))
      localStringBuilder.append("[empty]");
    while (true)
    {
      return localStringBuilder.toString();
      if (str.length() > 10)
      {
        localStringBuilder.append(str.substring(0, 10));
        continue;
      }
      localStringBuilder.append(str);
    }
  }

  public boolean u()
  {
    if (!StringUtil.a(this.p));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean v()
  {
    return this.q;
  }

  public String w()
  {
    return this.r;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeParcelable(this.j, paramInt);
    paramParcel.writeList(this.k);
    paramParcel.writeList(this.l);
    paramParcel.writeList(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeList(this.o);
    paramParcel.writeString(this.p);
    if (this.q);
    for (int i1 = 1; ; i1 = 0)
    {
      paramParcel.writeInt(i1);
      paramParcel.writeString(this.r);
      paramParcel.writeString(this.s.name());
      paramParcel.writeList(this.t);
      paramParcel.writeLong(this.u);
      return;
    }
  }

  public Message.ChannelSource x()
  {
    return this.s;
  }

  public List<MediaResource> y()
  {
    return this.t;
  }

  public boolean z()
  {
    if ((this.t != null) && (!this.t.isEmpty()));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.Message
 * JD-Core Version:    0.6.0
 */