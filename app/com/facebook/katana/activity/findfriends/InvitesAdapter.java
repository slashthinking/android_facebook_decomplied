package com.facebook.katana.activity.findfriends;

import android.content.Context;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.util.GrowthUtils;
import java.util.ArrayList;
import java.util.List;

public class InvitesAdapter extends BaseAdapter
{
  private Spanned h;
  private boolean j;
  private boolean k;

  public InvitesAdapter(Context paramContext, ArrayList<FacebookPhonebookContact> paramArrayList, Spanned paramSpanned)
  {
    super(paramContext);
    this.a = paramArrayList;
    this.h = paramSpanned;
    this.j = GrowthUtils.a().e(this.b);
    a(paramArrayList);
  }

  protected long a(FacebookPhonebookContact paramFacebookPhonebookContact)
  {
    return paramFacebookPhonebookContact.recordId;
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.j)
      paramView = super.a(paramInt, paramView, paramViewGroup);
    while (true)
    {
      return paramView;
      if (paramInt == 0)
      {
        if (!this.k)
        {
          this.k = true;
          GrowthUtils.a().d(this.b);
        }
        if ((paramView == null) || (!(paramView instanceof LinearLayout)))
          paramView = this.d.inflate(2130903195, null);
        TextView localTextView = (TextView)paramView.findViewById(2131296843);
        localTextView.setText(this.h);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)paramView.findViewById(2131297001)).setText(((BaseAdapter.FirstLetterFriendSection)this.c.get(paramInt)).toString());
        continue;
      }
      if ((paramView == null) || ((paramView instanceof TextView)))
      {
        paramView = super.a(paramInt, paramView, paramViewGroup);
        continue;
      }
      paramView = super.a(paramInt, null, null);
    }
  }

  protected void a(View paramView, FacebookPhonebookContact paramFacebookPhonebookContact, boolean paramBoolean)
  {
    paramView.findViewById(2131296492).setVisibility(8);
  }

  protected String e()
  {
    return this.b.getString(2131363389);
  }

  protected String h()
  {
    return this.b.getString(2131363395);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.InvitesAdapter
 * JD-Core Version:    0.6.0
 */