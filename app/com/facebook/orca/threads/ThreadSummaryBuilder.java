package com.facebook.orca.threads;

import android.net.Uri;
import com.facebook.orca.compose.MessageDraft;
import com.facebook.orca.users.UserKey;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class ThreadSummaryBuilder
{
  private String a;
  private long b;
  private long c;
  private long d;
  private String e;
  private List<ThreadParticipant> f = ImmutableList.d();
  private List<ThreadParticipant> g = ImmutableList.d();
  private List<ParticipantInfo> h = ImmutableList.d();
  private boolean i;
  private UserKey j;
  private long k;
  private List<ParticipantInfo> l = ImmutableList.d();
  private String m;
  private ParticipantInfo n;
  private String o;
  private String p;
  private Uri q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private FolderName v;
  private MessageDraft w;
  private List<ThreadSummary> x = ImmutableList.d();

  public ThreadSummaryBuilder a(long paramLong)
  {
    this.c = paramLong;
    return this;
  }

  public ThreadSummaryBuilder a(Uri paramUri)
  {
    this.q = paramUri;
    return this;
  }

  public ThreadSummaryBuilder a(MessageDraft paramMessageDraft)
  {
    this.w = paramMessageDraft;
    return this;
  }

  public ThreadSummaryBuilder a(FolderName paramFolderName)
  {
    this.v = paramFolderName;
    return this;
  }

  public ThreadSummaryBuilder a(ParticipantInfo paramParticipantInfo)
  {
    this.n = paramParticipantInfo;
    return this;
  }

  public ThreadSummaryBuilder a(ThreadSummary paramThreadSummary)
  {
    this.a = paramThreadSummary.a();
    this.b = paramThreadSummary.b();
    this.c = paramThreadSummary.c();
    this.d = paramThreadSummary.d();
    this.e = paramThreadSummary.f();
    this.f = paramThreadSummary.i();
    this.g = paramThreadSummary.A();
    this.h = paramThreadSummary.j();
    this.i = paramThreadSummary.g();
    this.j = paramThreadSummary.h();
    this.k = paramThreadSummary.k();
    this.l = paramThreadSummary.l();
    this.m = paramThreadSummary.m();
    this.n = paramThreadSummary.o();
    this.o = paramThreadSummary.n();
    this.p = paramThreadSummary.p();
    this.q = paramThreadSummary.r();
    this.r = paramThreadSummary.t();
    this.s = paramThreadSummary.u();
    this.t = paramThreadSummary.v();
    this.u = paramThreadSummary.w();
    this.v = paramThreadSummary.x();
    this.w = paramThreadSummary.y();
    this.x = paramThreadSummary.z();
    return this;
  }

  public ThreadSummaryBuilder a(UserKey paramUserKey)
  {
    this.j = paramUserKey;
    return this;
  }

  public ThreadSummaryBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public ThreadSummaryBuilder a(List<ThreadParticipant> paramList)
  {
    this.f = paramList;
    return this;
  }

  public ThreadSummaryBuilder a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }

  public String a()
  {
    return this.a;
  }

  public long b()
  {
    return this.c;
  }

  public ThreadSummaryBuilder b(long paramLong)
  {
    this.d = paramLong;
    return this;
  }

  public ThreadSummaryBuilder b(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public ThreadSummaryBuilder b(List<ThreadParticipant> paramList)
  {
    this.g = paramList;
    return this;
  }

  public ThreadSummaryBuilder b(boolean paramBoolean)
  {
    this.r = paramBoolean;
    return this;
  }

  public long c()
  {
    return this.d;
  }

  public ThreadSummaryBuilder c(long paramLong)
  {
    this.b = paramLong;
    return this;
  }

  public ThreadSummaryBuilder c(String paramString)
  {
    this.m = paramString;
    return this;
  }

  public ThreadSummaryBuilder c(List<ParticipantInfo> paramList)
  {
    this.h = paramList;
    return this;
  }

  public ThreadSummaryBuilder c(boolean paramBoolean)
  {
    this.s = paramBoolean;
    return this;
  }

  public ThreadSummaryBuilder d(long paramLong)
  {
    this.k = paramLong;
    return this;
  }

  public ThreadSummaryBuilder d(String paramString)
  {
    this.o = paramString;
    return this;
  }

  public ThreadSummaryBuilder d(List<ParticipantInfo> paramList)
  {
    this.l = paramList;
    return this;
  }

  public ThreadSummaryBuilder d(boolean paramBoolean)
  {
    this.t = paramBoolean;
    return this;
  }

  public String d()
  {
    return this.e;
  }

  public long e()
  {
    return this.b;
  }

  public ThreadSummaryBuilder e(String paramString)
  {
    this.p = paramString;
    return this;
  }

  public ThreadSummaryBuilder e(List<ThreadSummary> paramList)
  {
    this.x = paramList;
    return this;
  }

  public ThreadSummaryBuilder e(boolean paramBoolean)
  {
    this.u = paramBoolean;
    return this;
  }

  public boolean f()
  {
    return this.i;
  }

  public UserKey g()
  {
    return this.j;
  }

  public List<ThreadParticipant> h()
  {
    return this.f;
  }

  public List<ThreadParticipant> i()
  {
    return this.g;
  }

  public List<ParticipantInfo> j()
  {
    return this.h;
  }

  public long k()
  {
    return this.k;
  }

  public String l()
  {
    return this.m;
  }

  public ParticipantInfo m()
  {
    return this.n;
  }

  public String n()
  {
    return this.o;
  }

  public List<ParticipantInfo> o()
  {
    return this.l;
  }

  public String p()
  {
    return this.p;
  }

  public Uri q()
  {
    return this.q;
  }

  public boolean r()
  {
    return this.r;
  }

  public boolean s()
  {
    return this.s;
  }

  public boolean t()
  {
    return this.t;
  }

  public boolean u()
  {
    return this.u;
  }

  public FolderName v()
  {
    return this.v;
  }

  public MessageDraft w()
  {
    return this.w;
  }

  public List<ThreadSummary> x()
  {
    return this.x;
  }

  public ThreadSummary y()
  {
    return new ThreadSummary(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadSummaryBuilder
 * JD-Core Version:    0.6.0
 */