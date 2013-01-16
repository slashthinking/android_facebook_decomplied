package com.facebook.orca.threads;

import com.facebook.orca.notify.NotificationSetting;

public class ThreadParticipantBuilder
{
  private ParticipantInfo a;
  private String b;
  private NotificationSetting c;
  private long d;
  private String e;

  public ParticipantInfo a()
  {
    return this.a;
  }

  public ThreadParticipantBuilder a(long paramLong)
  {
    this.d = paramLong;
    return this;
  }

  public ThreadParticipantBuilder a(NotificationSetting paramNotificationSetting)
  {
    this.c = paramNotificationSetting;
    return this;
  }

  public ThreadParticipantBuilder a(ParticipantInfo paramParticipantInfo)
  {
    this.a = paramParticipantInfo;
    return this;
  }

  public ThreadParticipantBuilder a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public void a(ThreadParticipant paramThreadParticipant)
  {
    this.a = paramThreadParticipant.a();
    this.b = paramThreadParticipant.g();
    this.c = paramThreadParticipant.h();
    this.d = paramThreadParticipant.i();
    this.e = paramThreadParticipant.j();
  }

  public ThreadParticipantBuilder b(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public String b()
  {
    return this.b;
  }

  public NotificationSetting c()
  {
    return this.c;
  }

  public long d()
  {
    return this.d;
  }

  public String e()
  {
    return this.e;
  }

  public ThreadParticipant f()
  {
    return new ThreadParticipant(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadParticipantBuilder
 * JD-Core Version:    0.6.0
 */