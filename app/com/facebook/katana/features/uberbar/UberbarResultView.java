package com.facebook.katana.features.uberbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ipc.data.uberbar.UberbarResult;
import com.facebook.ipc.data.uberbar.UberbarResult.Type;
import com.facebook.orca.common.ui.util.TouchDelegateUtils;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;

class UberbarResultView extends CustomRelativeLayout
{
  public static final Class<?> a = UberbarResultView.class;
  private final TextView b;
  private final TextView c;
  private final UrlImage d;
  private final ImageView e;
  private final Resources f;
  private final View.OnClickListener g;
  private final View.OnClickListener h;
  private UberbarResult i;
  private UberbarResultView.CommunicationButtonListener j;
  private UberbarResultView.AddFriendButtonListener k;

  public UberbarResultView(Context paramContext)
  {
    this(paramContext, null);
  }

  public UberbarResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, null, 0);
  }

  public UberbarResultView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903614);
    this.b = ((TextView)b(2131297924));
    this.c = ((TextView)b(2131297925));
    this.d = ((UrlImage)b(2131297922));
    this.e = ((ImageView)b(2131297923));
    this.f = paramContext.getResources();
    this.g = new UberbarResultView.1(this);
    this.h = new UberbarResultView.2(this);
  }

  private String b(UberbarResult paramUberbarResult)
  {
    Joiner localJoiner = Joiner.on(this.f.getString(2131363411)).skipNulls();
    String str2;
    switch (UberbarResultView.3.b[paramUberbarResult.h.ordinal()])
    {
    default:
      str2 = "";
    case 1:
    case 2:
    case 3:
      while (true)
      {
        return str2;
        str2 = localJoiner.join(Strings.emptyToNull(paramUberbarResult.a), Strings.emptyToNull(paramUberbarResult.f), new Object[0]);
        continue;
        str2 = localJoiner.join(Strings.emptyToNull(this.f.getString(2131363413)), Strings.emptyToNull(paramUberbarResult.f), new Object[0]);
        continue;
        str2 = localJoiner.join(Strings.emptyToNull(this.f.getString(2131363412)), Strings.emptyToNull(paramUberbarResult.f), new Object[0]);
      }
    case 4:
    }
    switch (UberbarResultView.3.a[paramUberbarResult.b.ordinal()])
    {
    default:
    case 3:
    }
    for (String str1 = paramUberbarResult.f; ; str1 = this.f.getString(2131363414))
    {
      str2 = localJoiner.join(Strings.emptyToNull(str1), Strings.emptyToNull(paramUberbarResult.a), new Object[0]);
      break;
    }
  }

  public void a(UberbarResult paramUberbarResult)
  {
    this.i = paramUberbarResult;
    this.b.setText(paramUberbarResult.g);
    String str = b(paramUberbarResult);
    this.c.setText(str);
    if (StringUtil.a(str))
    {
      this.c.setVisibility(8);
      this.d.setImageParams(paramUberbarResult.e);
      if (paramUberbarResult.h != UberbarResult.Type.USER)
        break label234;
      switch (UberbarResultView.3.a[paramUberbarResult.b.ordinal()])
      {
      default:
        this.e.setVisibility(8);
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      return;
      this.c.setVisibility(0);
      break;
      if (paramUberbarResult.a() != null)
      {
        this.e.setImageResource(2130839002);
        this.e.setOnClickListener(this.h);
        this.e.setVisibility(0);
        continue;
      }
      this.e.setVisibility(8);
      continue;
      this.e.setImageResource(2130838998);
      this.e.setVisibility(0);
      this.e.setOnClickListener(this.g);
      continue;
      this.e.setOnClickListener(null);
      this.e.setImageResource(2130839001);
      this.e.setVisibility(0);
      continue;
      label234: this.e.setVisibility(8);
    }
  }

  public void a(UberbarResultView.AddFriendButtonListener paramAddFriendButtonListener)
  {
    this.k = paramAddFriendButtonListener;
  }

  public void a(UberbarResultView.CommunicationButtonListener paramCommunicationButtonListener)
  {
    this.j = paramCommunicationButtonListener;
  }

  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
      setTouchDelegate(TouchDelegateUtils.a(this.e, 12));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultView
 * JD-Core Version:    0.6.0
 */