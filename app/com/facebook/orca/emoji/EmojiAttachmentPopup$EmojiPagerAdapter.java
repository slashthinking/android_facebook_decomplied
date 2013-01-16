package com.facebook.orca.emoji;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import com.google.common.collect.Lists;
import java.util.List;

class EmojiAttachmentPopup$EmojiPagerAdapter extends PagerAdapter
{
  private final List<FrameLayout> b;
  private final EmojiSet c;

  public EmojiAttachmentPopup$EmojiPagerAdapter(EmojiAttachmentPopup paramEmojiAttachmentPopup)
  {
    this.b = Lists.a();
    this.c = null;
  }

  public EmojiAttachmentPopup$EmojiPagerAdapter(List<FrameLayout> paramList, EmojiSet paramEmojiSet)
  {
    this.b = paramEmojiSet;
    Object localObject;
    this.c = localObject;
  }

  public Object a(View paramView, int paramInt)
  {
    FrameLayout localFrameLayout = (FrameLayout)this.b.get(paramInt);
    if (localFrameLayout.getChildCount() == 0)
      localFrameLayout.addView(EmojiAttachmentPopup.a(this.a, this.c, EmojiAttachmentPopup.b(this.a, paramInt)));
    ((ViewPager)paramView).addView(localFrameLayout, 0);
    return localFrameLayout;
  }

  public void a(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((FrameLayout)paramObject);
  }

  public boolean a(View paramView, Object paramObject)
  {
    if (paramView == (FrameLayout)paramObject);
    for (int i = 1; ; i = 0)
      return i;
  }

  public int b()
  {
    return this.b.size();
  }

  public List<FrameLayout> d()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiAttachmentPopup.EmojiPagerAdapter
 * JD-Core Version:    0.6.0
 */