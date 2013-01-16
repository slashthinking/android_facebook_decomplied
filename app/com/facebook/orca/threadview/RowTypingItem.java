package com.facebook.orca.threadview;

import com.facebook.orca.threads.ParticipantInfo;
import com.google.common.base.Objects;

public class RowTypingItem extends RowItem
{
  private final ParticipantInfo a;

  public RowTypingItem(ParticipantInfo paramParticipantInfo)
  {
    this.a = paramParticipantInfo;
  }

  public int a()
  {
    return 5;
  }

  public ParticipantInfo b()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof RowTypingItem)) && (Objects.equal(this.a.e(), ((RowTypingItem)paramObject).b().e())));
    for (int i = 1; ; i = 0)
      return i;
  }

  public int hashCode()
  {
    return a();
  }

  public String toString()
  {
    return "RowTypingItem{otherUser=" + this.a.d() + '}';
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.RowTypingItem
 * JD-Core Version:    0.6.0
 */