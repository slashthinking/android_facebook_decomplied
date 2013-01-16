package com.facebook.orca.emoji;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class EmojiAttachmentPopup$9
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a.isSelected());
    while (true)
    {
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        FrameLayout localFrameLayout = (FrameLayout)localIterator.next();
        if (localFrameLayout == this.a)
          continue;
        localFrameLayout.setSelected(false);
      }
      this.a.setSelected(true);
      if (!EmojiAttachmentPopup.d(this.e).containsKey(this.a))
        EmojiAttachmentPopup.a(this.e, this.a, this.c);
      EmojiAttachmentPopup.a(this.e, (List)EmojiAttachmentPopup.d(this.e).get(this.a), this.c);
      EmojiAttachmentPopup.a(this.e, "category_selected_" + this.d);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiAttachmentPopup.9
 * JD-Core Version:    0.6.0
 */