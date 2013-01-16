package com.facebook.katana.friendrequests;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.katana.annotations.IsFullscreenJewelsEnabled;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;

public class PersonYouMayKnowView extends CustomRelativeLayout
{
  private final UrlImage a;
  private final TextView b;
  private TextView c;
  private ImageView d;
  private PersonYouMayKnowView.OnResponseListener e;
  private PersonYouMayKnow f;
  private final boolean g = ((Boolean)getInjector().a(Boolean.class, IsFullscreenJewelsEnabled.class)).booleanValue();

  public PersonYouMayKnowView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PersonYouMayKnowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PersonYouMayKnowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (this.g);
    for (int i = 2130903261; ; i = 2130903479)
    {
      setContentView(i);
      this.b = ((TextView)b(2131297041));
      this.a = ((UrlImage)b(2131297039));
      this.c = ((TextView)b(2131297042));
      this.d = ((ImageView)b(2131297040));
      return;
    }
  }

  private void b(PersonYouMayKnow paramPersonYouMayKnow)
  {
    this.c.setVisibility(0);
    this.c.setText(getResources().getString(2131363133));
    if (this.g);
    for (int i = 2130838341; ; i = 2130838294)
    {
      this.d.setImageResource(i);
      this.d.setOnClickListener(new PersonYouMayKnowView.1(this, paramPersonYouMayKnow));
      return;
    }
  }

  private void c(PersonYouMayKnow paramPersonYouMayKnow)
  {
    int i = paramPersonYouMayKnow.a();
    TextView localTextView = this.c;
    int j;
    if (i > 0)
    {
      j = 0;
      localTextView.setVisibility(j);
      Resources localResources = getResources();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i);
      String str = localResources.getQuantityString(2131427359, i, arrayOfObject);
      this.c.setText(str);
      if (!this.g)
        break label108;
    }
    label108: for (int k = 2130838340; ; k = 2130837506)
    {
      this.d.setImageResource(k);
      this.d.setOnClickListener(new PersonYouMayKnowView.2(this, paramPersonYouMayKnow));
      return;
      j = 8;
      break;
    }
  }

  public void a(PersonYouMayKnow paramPersonYouMayKnow)
  {
    this.f = paramPersonYouMayKnow;
    this.b.setText(paramPersonYouMayKnow.name);
    this.a.setImageParams(Uri.parse(paramPersonYouMayKnow.b()));
    this.d.setEnabled(true);
    if (paramPersonYouMayKnow.a)
      b(paramPersonYouMayKnow);
    while (true)
    {
      return;
      c(paramPersonYouMayKnow);
    }
  }

  public void setOnResponseListener(PersonYouMayKnowView.OnResponseListener paramOnResponseListener)
  {
    this.e = paramOnResponseListener;
  }

  public void setPressed(boolean paramBoolean)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.PersonYouMayKnowView
 * JD-Core Version:    0.6.0
 */