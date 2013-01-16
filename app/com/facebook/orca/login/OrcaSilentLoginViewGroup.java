package com.facebook.orca.login;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.collect.ImmutableList;

public class OrcaSilentLoginViewGroup extends AuthFragmentViewGroup
{
  public static final String LAYOUT_RESOURCE = "orca:authparam:silent_login_layout";

  public OrcaSilentLoginViewGroup(Context paramContext, AuthFragmentControlBase paramAuthFragmentControlBase)
  {
    super(paramContext, paramAuthFragmentControlBase);
    setContentView(getResource("orca:authparam:silent_login_layout", 2130903361));
    EmptyListViewItem localEmptyListViewItem = (EmptyListViewItem)getView(2131297328);
    localEmptyListViewItem.a(true);
    localEmptyListViewItem.setMessage(2131362173);
    if (FbTitleBarUtil.a(this))
      ((FbTitleBar)getView(2131296299)).setButtonSpecs(ImmutableList.a(TitleBarButtonSpec.newBuilder().a(1).a(getResources().getDrawable(2130838593)).i()));
  }

  public static Bundle createParameterBundle(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("orca:authparam:silent_login_layout", paramInt);
    return localBundle;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.OrcaSilentLoginViewGroup
 * JD-Core Version:    0.6.0
 */