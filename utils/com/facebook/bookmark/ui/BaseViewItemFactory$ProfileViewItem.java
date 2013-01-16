package com.facebook.bookmark.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.widget.UrlImage;

public class BaseViewItemFactory$ProfileViewItem extends BookmarkAdapter.BaseViewItem<BaseViewItemFactory.ProfileViewHolder, Bookmark>
{
  public BaseViewItemFactory$ProfileViewItem(BaseViewItemFactory paramBaseViewItemFactory, BookmarkAdapter.RowType paramRowType, Bookmark paramBookmark)
  {
    super(paramRowType, 2130903073, paramBookmark, paramBaseViewItemFactory.b);
  }

  private void a(UrlImage paramUrlImage, ImageView paramImageView)
  {
    if (BaseViewItemFactory.a() < 0)
    {
      BaseViewItemFactory.a(Math.round(SizeUtil.a(this.a.a, 1.0F)));
      BaseViewItemFactory.b(Math.round(SizeUtil.a(this.a.a, 2.0F)));
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.height = (paramUrlImage.getLayoutParams().height + BaseViewItemFactory.b());
    localLayoutParams.width = (paramUrlImage.getLayoutParams().width + 2 * BaseViewItemFactory.a());
    localLayoutParams.leftMargin = (((RelativeLayout.LayoutParams)paramUrlImage.getLayoutParams()).leftMargin - BaseViewItemFactory.a());
    localLayoutParams.addRule(6, 2131296413);
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.requestLayout();
  }

  public BaseViewItemFactory.ProfileViewHolder a(View paramView)
  {
    return new BaseViewItemFactory.ProfileViewHolder(paramView);
  }

  public void a(BaseViewItemFactory.ProfileViewHolder paramProfileViewHolder)
  {
    a(paramProfileViewHolder.d, paramProfileViewHolder.a);
    if (((Bookmark)this.d).pic != null)
      paramProfileViewHolder.d.setImageParams(Uri.parse(((Bookmark)this.d).pic));
    paramProfileViewHolder.e.setText(((Bookmark)this.d).name);
    paramProfileViewHolder.e.setTextColor(this.a.a.getResources().getColor(2131165336));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.BaseViewItemFactory.ProfileViewItem
 * JD-Core Version:    0.6.2
 */