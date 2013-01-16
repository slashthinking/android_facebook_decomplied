package com.facebook.orca.emoji;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Map;

class EmojiAttachmentPopup$4
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    EmojiAttachmentPopup.c(this.a);
    if (EmojiAttachmentPopup.d(this.a).isEmpty())
    {
      EmojiSet localEmojiSet = (EmojiSet)Emojis.a.get(0);
      EmojiAttachmentPopup.a(this.a, EmojiAttachmentPopup.e(this.a), localEmojiSet);
      EmojiAttachmentPopup.a(this.a, (List)EmojiAttachmentPopup.d(this.a).get(EmojiAttachmentPopup.e(this.a)), localEmojiSet);
    }
    ((LinearLayout)EmojiAttachmentPopup.a(this.a, EmojiAttachmentPopup.a(this.a), 2131297271)).setVisibility(8);
    ((LinearLayout)EmojiAttachmentPopup.a(this.a, EmojiAttachmentPopup.a(this.a), 2131297279)).setVisibility(0);
    EmojiAttachmentPopup.a(this.a, "backside_button");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiAttachmentPopup.4
 * JD-Core Version:    0.6.0
 */