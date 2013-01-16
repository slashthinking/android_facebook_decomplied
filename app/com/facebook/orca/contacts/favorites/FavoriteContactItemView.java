package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.common.ui.widgets.FavoritesDragSortListView.DraggableRowView;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.users.User;

public class FavoriteContactItemView extends FavoritesDragSortListView.DraggableRowView
{
  private FavoriteContactRow b;
  private TextView c;
  private View d;
  private UserTileView e;

  public FavoriteContactItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public FavoriteContactItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public FavoriteContactItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    setContentView(2130903346);
    this.c = ((TextView)getView(2131296593));
    this.e = ((UserTileView)getView(2131296588));
    this.d = getView(2131297295);
    this.d.setClickable(true);
  }

  private void b()
  {
    User localUser = this.b.a();
    this.e.setParams(UserTileViewParams.a(localUser));
    this.c.setText(localUser.f());
    this.d.setOnClickListener(new FavoriteContactItemView.1(this));
  }

  public FavoriteContactRow getContactRow()
  {
    return this.b;
  }

  public View getInnerRow()
  {
    return getChildAt(0);
  }

  public void setContactRow(FavoriteContactRow paramFavoriteContactRow)
  {
    this.b = paramFavoriteContactRow;
    b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.FavoriteContactItemView
 * JD-Core Version:    0.6.0
 */