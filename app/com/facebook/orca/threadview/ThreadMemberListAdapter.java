package com.facebook.orca.threadview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;

public class ThreadMemberListAdapter extends BaseAdapter
{
  private final Context a;
  private final LayoutInflater b;
  private List<ThreadParticipant> c = Collections.emptyList();

  public ThreadMemberListAdapter(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    this.a = paramContext;
    this.b = paramLayoutInflater;
  }

  private View a(ThreadParticipant paramThreadParticipant, View paramView)
  {
    if (paramView == null)
      paramView = this.b.inflate(2130903411, null);
    ((TextView)paramView.findViewById(2131297475)).setText(paramThreadParticipant.a().d());
    TextView localTextView = (TextView)paramView.findViewById(2131297476);
    String str;
    if (paramThreadParticipant.c())
    {
      str = paramThreadParticipant.d().b();
      if (!StringUtil.a(str))
        break label153;
      localTextView.setVisibility(8);
    }
    while (true)
    {
      ((UserTileView)paramView.findViewById(2131297474)).setParams(UserTileViewParams.a(paramThreadParticipant));
      return paramView;
      boolean bool1 = paramThreadParticipant.b();
      str = null;
      if (bool1)
        break;
      boolean bool2 = StringUtil.a(paramThreadParticipant.e());
      str = null;
      if (bool2)
        break;
      boolean bool3 = Objects.equal(paramThreadParticipant.f(), paramThreadParticipant.e());
      str = null;
      if (bool3)
        break;
      str = paramThreadParticipant.e();
      break;
      label153: localTextView.setText(str);
      localTextView.setVisibility(0);
    }
  }

  public int getCount()
  {
    return this.c.size();
  }

  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.c.size());
    for (int i = 0; ; i = 1)
      return i;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a((ThreadParticipant)this.c.get(paramInt), paramView);
  }

  public int getViewTypeCount()
  {
    return 2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadMemberListAdapter
 * JD-Core Version:    0.6.0
 */