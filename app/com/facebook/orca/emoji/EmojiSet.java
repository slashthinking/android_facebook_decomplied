package com.facebook.orca.emoji;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class EmojiSet
{
  private final int a;
  private final ImmutableList<Emoji> b;

  EmojiSet(int paramInt, ImmutableList<Emoji> paramImmutableList)
  {
    this.a = paramInt;
    this.b = paramImmutableList;
  }

  public int a()
  {
    return this.a;
  }

  public List<Emoji> b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiSet
 * JD-Core Version:    0.6.0
 */