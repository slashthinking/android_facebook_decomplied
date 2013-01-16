package com.facebook.orca.threads;

import com.facebook.orca.location.Coordinates;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.share.Share;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

public class MessageBuilder
{
  private String a;
  private String b;
  private long c;
  private long d;
  private ParticipantInfo e;
  private String f;
  private String g;
  private String h;
  private long i;
  private Coordinates j;
  private List<MediaResource> k = Collections.emptyList();
  private List<TitanAttachmentInfo> l = Collections.emptyList();
  private List<Share> m = Collections.emptyList();
  private int n;
  private List<ParticipantInfo> o = Collections.emptyList();
  private String p;
  private boolean q;
  private String r;
  private Message.ChannelSource s = Message.ChannelSource.API;
  private List<MediaResource> t;
  private long u;

  public MessageBuilder a(int paramInt)
  {
    this.n = paramInt;
    return this;
  }

  public MessageBuilder a(long paramLong)
  {
    this.c = paramLong;
    return this;
  }

  public MessageBuilder a(Coordinates paramCoordinates)
  {
    this.j = paramCoordinates;
    return this;
  }

  public MessageBuilder a(Message.ChannelSource paramChannelSource)
  {
    this.s = paramChannelSource;
    return this;
  }

  public MessageBuilder a(Message paramMessage)
  {
    this.a = paramMessage.a();
    this.b = paramMessage.b();
    this.c = paramMessage.c();
    this.d = paramMessage.e();
    this.e = paramMessage.f();
    this.f = paramMessage.g();
    this.g = paramMessage.h();
    this.h = paramMessage.j();
    this.i = paramMessage.p();
    this.j = paramMessage.k();
    this.k = paramMessage.l();
    this.l = paramMessage.m();
    this.m = paramMessage.n();
    this.n = paramMessage.r();
    this.o = paramMessage.s();
    this.p = paramMessage.t();
    this.q = paramMessage.v();
    this.r = paramMessage.w();
    this.s = paramMessage.x();
    this.t = paramMessage.y();
    this.u = paramMessage.A();
    return this;
  }

  public MessageBuilder a(ParticipantInfo paramParticipantInfo)
  {
    this.e = paramParticipantInfo;
    return this;
  }

  public MessageBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public MessageBuilder a(List<MediaResource> paramList)
  {
    this.k = paramList;
    return this;
  }

  public MessageBuilder a(boolean paramBoolean)
  {
    this.q = paramBoolean;
    return this;
  }

  public String a()
  {
    return this.a;
  }

  public MessageBuilder b(long paramLong)
  {
    this.d = paramLong;
    return this;
  }

  public MessageBuilder b(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public MessageBuilder b(List<TitanAttachmentInfo> paramList)
  {
    this.l = paramList;
    return this;
  }

  public String b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }

  public MessageBuilder c(long paramLong)
  {
    this.i = paramLong;
    return this;
  }

  public MessageBuilder c(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public MessageBuilder c(List<Share> paramList)
  {
    this.m = paramList;
    return this;
  }

  public long d()
  {
    return this.d;
  }

  public MessageBuilder d(long paramLong)
  {
    this.u = paramLong;
    return this;
  }

  public MessageBuilder d(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public MessageBuilder d(List<ParticipantInfo> paramList)
  {
    this.o = paramList;
    return this;
  }

  public MessageBuilder e(String paramString)
  {
    this.p = paramString;
    return this;
  }

  public MessageBuilder e(List<MediaResource> paramList)
  {
    this.t = paramList;
    return this;
  }

  public ParticipantInfo e()
  {
    return this.e;
  }

  public MessageBuilder f(String paramString)
  {
    this.r = paramString;
    return this;
  }

  public String f()
  {
    return this.f;
  }

  public String g()
  {
    return this.g;
  }

  public String h()
  {
    return this.h;
  }

  public long i()
  {
    return this.i;
  }

  public Coordinates j()
  {
    return this.j;
  }

  public List<MediaResource> k()
  {
    return this.k;
  }

  public List<TitanAttachmentInfo> l()
  {
    return this.l;
  }

  public List<Share> m()
  {
    return this.m;
  }

  public int n()
  {
    return this.n;
  }

  public List<ParticipantInfo> o()
  {
    return this.o;
  }

  public String p()
  {
    return this.p;
  }

  public boolean q()
  {
    return this.q;
  }

  public String r()
  {
    return this.r;
  }

  public Message.ChannelSource s()
  {
    return this.s;
  }

  public List<MediaResource> t()
  {
    if (this.t == null);
    for (Object localObject = Lists.a(); ; localObject = this.t)
      return localObject;
  }

  public long u()
  {
    return this.u;
  }

  public Message v()
  {
    return new Message(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.MessageBuilder
 * JD-Core Version:    0.6.0
 */