package com.facebook.katana.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.katana.service.method.MarkJewelSeen.Jewel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class JewelTitleBar extends TitleBar
{
  private static final ImmutableMap<MarkJewelSeen.Jewel, PopupViewDelegate.PopupState> a = ImmutableMap.a(MarkJewelSeen.Jewel.FRIEND_REQUESTS, PopupViewDelegate.PopupState.FRIEND_REQUESTS, MarkJewelSeen.Jewel.INBOX, PopupViewDelegate.PopupState.MESSAGES, MarkJewelSeen.Jewel.NOTIFICATIONS, PopupViewDelegate.PopupState.NOTIFICATIONS);
  private ImmutableMap<MarkJewelSeen.Jewel, JewelButton> b;
  private JewelTitleBar.OnJewelClickListener c;

  public JewelTitleBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public JewelTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public JewelTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public View a(MarkJewelSeen.Jewel paramJewel)
  {
    return (View)this.b.get(paramJewel);
  }

  protected void a(MarkJewelSeen.Jewel paramJewel, View paramView)
  {
    if (this.c != null)
      this.c.a(paramJewel, paramView);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ImmutableMap.a(MarkJewelSeen.Jewel.FRIEND_REQUESTS, (JewelButton)findViewById(2131297913), MarkJewelSeen.Jewel.INBOX, (JewelButton)findViewById(2131297914), MarkJewelSeen.Jewel.NOTIFICATIONS, (JewelButton)findViewById(2131297915));
    Iterator localIterator = this.b.b().iterator();
    while (localIterator.hasNext())
    {
      MarkJewelSeen.Jewel localJewel = (MarkJewelSeen.Jewel)localIterator.next();
      ((JewelButton)this.b.get(localJewel)).setOnClickListener(new JewelTitleBar.1(this, localJewel));
    }
  }

  public void setActiveState(PopupViewDelegate.PopupState paramPopupState)
  {
    Iterator localIterator = a.a().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      JewelButton localJewelButton = (JewelButton)this.b.get(localEntry.getKey());
      if (paramPopupState == localEntry.getValue());
      for (boolean bool = true; ; bool = false)
      {
        localJewelButton.setActive(bool);
        break;
      }
    }
  }

  public void setJewelClickListener(JewelTitleBar.OnJewelClickListener paramOnJewelClickListener)
  {
    this.c = paramOnJewelClickListener;
  }

  public void setJewelCount(MarkJewelSeen.Jewel paramJewel, int paramInt)
  {
    ((JewelButton)this.b.get(paramJewel)).setUnseenCount(paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.JewelTitleBar
 * JD-Core Version:    0.6.0
 */