package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.widget.BetterTextView;
import com.facebook.widget.CustomFrameLayout;

public class TypingItemView extends CustomFrameLayout
{
  private UserTileView a;
  private BetterTextView b;

  public TypingItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public TypingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public TypingItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    setContentView(2130903430);
    setPadding(0, 0, 0, SizeUtil.a(getContext(), 12.0F));
    this.a = ((UserTileView)b(2131297343));
    this.b = ((BetterTextView)b(2131297345));
  }

  public void setTypingItem(RowTypingItem paramRowTypingItem)
  {
    this.a.setParams(UserTileViewParams.a(paramRowTypingItem.b().e()));
    this.b.setText(getResources().getString(2131362700));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.TypingItemView
 * JD-Core Version:    0.6.0
 */