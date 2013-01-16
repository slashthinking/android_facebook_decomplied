package com.facebook.orca.threads;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.compose.MessageDraft;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ThreadSummary
  implements Parcelable
{
  public static final Parcelable.Creator<ThreadSummary> CREATOR = new ThreadSummary.1();
  private final String a;
  private final long b;
  private final long c;
  private final long d;
  private final String e;
  private final ImmutableList<ThreadParticipant> f;
  private final ImmutableList<ThreadParticipant> g;
  private final ImmutableList<ParticipantInfo> h;
  private final boolean i;
  private final UserKey j;
  private final long k;
  private final ImmutableList<ParticipantInfo> l;
  private final String m;
  private final String n;
  private final ParticipantInfo o;
  private final String p;
  private final Uri q;
  private final boolean r;
  private final boolean s;
  private final boolean t;
  private final boolean u;
  private final FolderName v;
  private final MessageDraft w;
  private final ImmutableList<ThreadSummary> x;
  private final ImmutableMap<UserKey, ThreadParticipant> y;

  private ThreadSummary(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readString();
    this.f = ImmutableList.a(paramParcel.createTypedArrayList(ThreadParticipant.CREATOR));
    this.g = ImmutableList.a(paramParcel.createTypedArrayList(ThreadParticipant.CREATOR));
    this.h = ImmutableList.a(paramParcel.createTypedArrayList(ParticipantInfo.CREATOR));
    boolean bool2;
    boolean bool3;
    label197: boolean bool4;
    label213: boolean bool5;
    if (paramParcel.readInt() != 0)
    {
      bool2 = bool1;
      this.i = bool2;
      this.j = UserKey.a(paramParcel.readString());
      this.k = paramParcel.readLong();
      this.l = ImmutableList.a(paramParcel.createTypedArrayList(ParticipantInfo.CREATOR));
      this.m = paramParcel.readString();
      this.n = paramParcel.readString();
      this.o = ((ParticipantInfo)paramParcel.readParcelable(ParticipantInfo.class.getClassLoader()));
      this.p = paramParcel.readString();
      this.q = ((Uri)paramParcel.readParcelable(null));
      if (paramParcel.readInt() == 0)
        break label314;
      bool3 = bool1;
      this.r = bool3;
      if (paramParcel.readInt() == 0)
        break label320;
      bool4 = bool1;
      this.s = bool4;
      if (paramParcel.readInt() == 0)
        break label326;
      bool5 = bool1;
      label229: this.t = bool5;
      if (paramParcel.readInt() == 0)
        break label332;
    }
    while (true)
    {
      this.u = bool1;
      this.v = ((FolderName)paramParcel.readParcelable(FolderName.class.getClassLoader()));
      this.w = ((MessageDraft)paramParcel.readParcelable(MessageDraft.class.getClassLoader()));
      this.x = ImmutableList.a(paramParcel.createTypedArrayList(CREATOR));
      this.y = a(this.f, this.g);
      return;
      bool2 = false;
      break;
      label314: bool3 = false;
      break label197;
      label320: bool4 = false;
      break label213;
      label326: bool5 = false;
      break label229;
      label332: bool1 = false;
    }
  }

  ThreadSummary(ThreadSummaryBuilder paramThreadSummaryBuilder)
  {
    Preconditions.checkNotNull(paramThreadSummaryBuilder.v());
    this.a = paramThreadSummaryBuilder.a();
    this.b = paramThreadSummaryBuilder.e();
    this.c = paramThreadSummaryBuilder.b();
    this.d = paramThreadSummaryBuilder.c();
    this.e = paramThreadSummaryBuilder.d();
    this.f = ImmutableList.a(paramThreadSummaryBuilder.h());
    this.g = ImmutableList.a(paramThreadSummaryBuilder.i());
    this.h = ImmutableList.a(paramThreadSummaryBuilder.j());
    this.i = paramThreadSummaryBuilder.f();
    this.j = paramThreadSummaryBuilder.g();
    this.k = paramThreadSummaryBuilder.k();
    this.l = ImmutableList.a(paramThreadSummaryBuilder.o());
    this.m = paramThreadSummaryBuilder.l();
    this.n = paramThreadSummaryBuilder.n();
    this.o = paramThreadSummaryBuilder.m();
    this.p = paramThreadSummaryBuilder.p();
    this.q = paramThreadSummaryBuilder.q();
    this.r = paramThreadSummaryBuilder.r();
    this.s = paramThreadSummaryBuilder.s();
    this.t = paramThreadSummaryBuilder.t();
    this.u = paramThreadSummaryBuilder.u();
    this.v = paramThreadSummaryBuilder.v();
    this.w = paramThreadSummaryBuilder.w();
    this.x = ImmutableList.a(paramThreadSummaryBuilder.x());
    this.y = a(this.f, this.g);
  }

  private static ImmutableMap<UserKey, ThreadParticipant> a(ImmutableList<ThreadParticipant> paramImmutableList1, ImmutableList<ThreadParticipant> paramImmutableList2)
  {
    HashMap localHashMap = Maps.a();
    Iterator localIterator1 = paramImmutableList1.iterator();
    while (localIterator1.hasNext())
    {
      ThreadParticipant localThreadParticipant2 = (ThreadParticipant)localIterator1.next();
      localHashMap.put(localThreadParticipant2.d(), localThreadParticipant2);
    }
    Iterator localIterator2 = paramImmutableList2.iterator();
    while (localIterator2.hasNext())
    {
      ThreadParticipant localThreadParticipant1 = (ThreadParticipant)localIterator2.next();
      localHashMap.put(localThreadParticipant1.d(), localThreadParticipant1);
    }
    return ImmutableMap.a(localHashMap);
  }

  public static ThreadSummaryBuilder newBuilder()
  {
    return new ThreadSummaryBuilder();
  }

  public ImmutableList<ThreadParticipant> A()
  {
    return this.g;
  }

  public List<ThreadParticipant> B()
  {
    return new ThreadSummary.MergedList(this.f, this.g);
  }

  public ThreadParticipant a(ParticipantInfo paramParticipantInfo)
  {
    return a(paramParticipantInfo.e());
  }

  public ThreadParticipant a(UserKey paramUserKey)
  {
    return (ThreadParticipant)this.y.get(paramUserKey);
  }

  public String a()
  {
    return this.a;
  }

  public long b()
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

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    if (!StringUtil.a(this.e));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public String f()
  {
    return this.e;
  }

  public boolean g()
  {
    return this.i;
  }

  public UserKey h()
  {
    return this.j;
  }

  public ImmutableList<ThreadParticipant> i()
  {
    return this.f;
  }

  public ImmutableList<ParticipantInfo> j()
  {
    return this.h;
  }

  public long k()
  {
    return this.k;
  }

  public ImmutableList<ParticipantInfo> l()
  {
    return this.l;
  }

  public String m()
  {
    return this.m;
  }

  public String n()
  {
    return this.n;
  }

  public ParticipantInfo o()
  {
    return this.o;
  }

  public String p()
  {
    return this.p;
  }

  public boolean q()
  {
    if (this.p != null);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public Uri r()
  {
    return this.q;
  }

  public boolean s()
  {
    if (this.q != null);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean t()
  {
    return this.r;
  }

  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(ThreadSummary.class).add("id", this.a).add("singleRecipientCanonicalThread", Boolean.valueOf(this.i));
    if (this.j != null);
    for (String str = this.j.c(); ; str = null)
      return localToStringHelper.add("singleRecipientUserKey", str).add("timestampMs", Long.valueOf(this.k)).add("participants", this.f).add("senders", this.l).toString();
  }

  public boolean u()
  {
    return this.s;
  }

  public boolean v()
  {
    return this.t;
  }

  public boolean w()
  {
    return this.u;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeTypedList(this.f);
    paramParcel.writeTypedList(this.g);
    paramParcel.writeTypedList(this.h);
    int i2;
    String str;
    label98: int i3;
    label172: int i4;
    label188: int i5;
    if (this.i)
    {
      i2 = i1;
      paramParcel.writeInt(i2);
      if (this.j == null)
        break label255;
      str = this.j.c();
      paramParcel.writeString(str);
      paramParcel.writeLong(this.k);
      paramParcel.writeTypedList(this.l);
      paramParcel.writeString(this.m);
      paramParcel.writeString(this.n);
      paramParcel.writeParcelable(this.o, paramInt);
      paramParcel.writeString(this.p);
      paramParcel.writeParcelable(this.q, paramInt);
      if (!this.r)
        break label261;
      i3 = i1;
      paramParcel.writeInt(i3);
      if (!this.s)
        break label267;
      i4 = i1;
      paramParcel.writeInt(i4);
      if (!this.t)
        break label273;
      i5 = i1;
      label204: paramParcel.writeInt(i5);
      if (!this.u)
        break label279;
    }
    while (true)
    {
      paramParcel.writeInt(i1);
      paramParcel.writeParcelable(this.v, paramInt);
      paramParcel.writeParcelable(this.w, paramInt);
      paramParcel.writeTypedList(this.x);
      return;
      i2 = 0;
      break;
      label255: str = null;
      break label98;
      label261: i3 = 0;
      break label172;
      label267: i4 = 0;
      break label188;
      label273: i5 = 0;
      break label204;
      label279: i1 = 0;
    }
  }

  public FolderName x()
  {
    return this.v;
  }

  public MessageDraft y()
  {
    return this.w;
  }

  public ImmutableList<ThreadSummary> z()
  {
    return this.x;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadSummary
 * JD-Core Version:    0.6.0
 */