package com.facebook.orca.threadlist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.users.PicCropInfo;
import com.facebook.orca.users.ShortNameHelper;
import com.facebook.orca.users.User;
import com.facebook.widget.CustomViewGroup;

class ContactGridCellView extends CustomViewGroup
{
  private UserTileView a;
  private TextView b;
  private User c;

  public ContactGridCellView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ContactGridCellView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ContactGridCellView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903113);
    this.a = ((UserTileView)getView(2131296588));
    this.b = ((TextView)getView(2131296589));
  }

  public void a(User paramUser)
  {
    this.c = paramUser;
    PicCropInfo localPicCropInfo = this.c.s();
    if (localPicCropInfo == null)
      localPicCropInfo = this.c.r();
    this.a.setParams(UserTileViewParams.a(localPicCropInfo));
    ShortNameHelper localShortNameHelper = new ShortNameHelper();
    this.b.setText(localShortNameHelper.a(this.c));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ContactGridCellView
 * JD-Core Version:    0.6.0
 */