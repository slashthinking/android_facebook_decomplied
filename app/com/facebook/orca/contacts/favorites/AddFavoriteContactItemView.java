package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.users.User;
import com.facebook.widget.CustomViewGroup;

public class AddFavoriteContactItemView extends CustomViewGroup
{
  private final TextView a;
  private final View b;
  private final UserTileView c;
  private AddFavoriteContactRow d;

  public AddFavoriteContactItemView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AddFavoriteContactItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AddFavoriteContactItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903309);
    this.a = ((TextView)getView(2131296593));
    this.c = ((UserTileView)getView(2131296588));
    this.b = getView(2131297175);
  }

  private void a()
  {
    User localUser = this.d.a();
    this.c.setParams(UserTileViewParams.a(localUser));
    this.a.setText(localUser.f());
    this.b.setOnClickListener(new AddFavoriteContactItemView.1(this));
  }

  public AddFavoriteContactRow getContactRow()
  {
    return this.d;
  }

  public void setContactRow(AddFavoriteContactRow paramAddFavoriteContactRow)
  {
    this.d = paramAddFavoriteContactRow;
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.AddFavoriteContactItemView
 * JD-Core Version:    0.6.0
 */