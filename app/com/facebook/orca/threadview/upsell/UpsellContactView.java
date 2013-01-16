package com.facebook.orca.threadview.upsell;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.contacts.models.ContactPicCropInfoGenerator;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.users.Name;
import com.facebook.widget.CustomViewGroup;

public class UpsellContactView extends CustomViewGroup
{
  private final ContactPicCropInfoGenerator a = (ContactPicCropInfoGenerator)getInjector().a(ContactPicCropInfoGenerator.class);
  private final UserTileView b;
  private final TextView c;

  public UpsellContactView(Context paramContext)
  {
    this(paramContext, null);
  }

  public UpsellContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public UpsellContactView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903364);
    this.b = ((UserTileView)getView(2131297337));
    this.c = ((TextView)getView(2131297338));
  }

  public void setContactSummary(ContactSummary paramContactSummary)
  {
    this.b.setParams(UserTileViewParams.a(paramContactSummary, this.a));
    this.c.setText(paramContactSummary.getName().f());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.upsell.UpsellContactView
 * JD-Core Version:    0.6.0
 */