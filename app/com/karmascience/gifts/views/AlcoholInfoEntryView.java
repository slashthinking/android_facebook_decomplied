package com.karmascience.gifts.views;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.graphql.model.GraphQLAddress;
import com.facebook.graphql.model.GraphQLBirthdate;
import com.facebook.graphql.model.GraphQLMailingAddress;
import com.facebook.graphql.model.GraphQLMailingAddresses;
import com.google.common.base.Strings;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.ProductInfo;
import com.karmascience.gifts.controllers.OrderManager.SaveNewSenderAddressListener;
import com.karmascience.gifts.controllers.OrderManager.SenderMailingAddressesListener;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import com.karmascience.gifts.ui.IViewManager;
import com.karmascience.gifts.widget.AddressEntryDialogFragment.AddressEntryDialogListener;
import java.util.Calendar;
import java.util.List;

public class AlcoholInfoEntryView extends KSViewController
{
  private final OrderManager.SaveNewSenderAddressListener a = new AlcoholInfoEntryView.1(this);
  private OrderManager.SaveNewSenderAddressListener b = new AlcoholInfoEntryView.2(this);
  private final AddressEntryDialogFragment.AddressEntryDialogListener c = new AlcoholInfoEntryView.3(this);
  private final OrderManager.SenderMailingAddressesListener d = new AlcoholInfoEntryView.4(this);
  private final String e;
  private String f = null;
  private boolean g = false;
  private View h = null;
  private View i = null;
  private View j = null;
  private RadioGroup k = null;
  private View l = null;
  private TextView m = null;
  private View n = null;
  private View o;

  public AlcoholInfoEntryView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
    GraphQLBirthdate localGraphQLBirthdate = p().e().d;
    Calendar localCalendar = Calendar.getInstance();
    int i1 = -1 + localGraphQLBirthdate.month;
    localCalendar.set(localGraphQLBirthdate.year, i1, localGraphQLBirthdate.day);
    this.e = DateFormat.format("MMMM dd, yyyy", localCalendar).toString();
  }

  private void C()
  {
    D();
    this.g = false;
    this.f = null;
    p().a(this.d, o());
  }

  private void D()
  {
    this.h.setVisibility(0);
    this.i.setVisibility(8);
  }

  private void E()
  {
    this.h.setVisibility(8);
    this.i.setVisibility(0);
  }

  private void F()
  {
    p().b().a.a("sender_mailing_address", this.f);
    b(CommonViewUtils.a(4));
  }

  private void a(AlcoholInfoEntryView.AddressHolder paramAddressHolder, boolean paramBoolean)
  {
    t();
    if (paramBoolean);
    for (OrderManager.SaveNewSenderAddressListener localSaveNewSenderAddressListener = this.a; ; localSaveNewSenderAddressListener = this.b)
    {
      p().a(localSaveNewSenderAddressListener, paramAddressHolder, o());
      return;
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903047, paramViewGroup, false);
    this.h = localView.findViewById(2131296360);
    this.i = localView.findViewById(2131296361);
    this.j = localView.findViewById(2131296363);
    this.k = ((RadioGroup)localView.findViewById(2131296364));
    this.l = localView.findViewById(2131296347);
    this.m = ((TextView)localView.findViewById(2131296365));
    this.n = localView.findViewById(2131296366);
    this.o = localView.findViewById(2131296367);
    this.o.setOnClickListener(new AlcoholInfoEntryView.5(this));
    this.m.setOnClickListener(new AlcoholInfoEntryView.6(this));
    TextView localTextView = (TextView)localView.findViewById(2131296362);
    Activity localActivity = g();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.e;
    localTextView.setText(localActivity.getString(2131362325, arrayOfObject));
    return localView;
  }

  public void a()
  {
    C();
  }

  protected void a(View paramView)
  {
    EditText localEditText = (EditText)paramView.findViewById(2131296348);
    String str = p().e().b;
    if ((localEditText != null) && (str != null))
      localEditText.setText(str, TextView.BufferType.EDITABLE);
  }

  protected void a(GraphQLMailingAddresses paramGraphQLMailingAddresses)
  {
    LayoutInflater localLayoutInflater = g().getLayoutInflater();
    boolean bool;
    if ((paramGraphQLMailingAddresses != null) && (paramGraphQLMailingAddresses.addresses != null) && (paramGraphQLMailingAddresses.addresses.size() > 0))
      bool = true;
    while (true)
    {
      this.g = bool;
      if (!this.g)
        break;
      this.j.setVisibility(8);
      this.l.setVisibility(8);
      this.k.setVisibility(0);
      this.m.setVisibility(0);
      this.n.setVisibility(0);
      this.k.removeAllViews();
      int i1 = 0;
      while (true)
        if (i1 < paramGraphQLMailingAddresses.addresses.size())
        {
          GraphQLMailingAddress localGraphQLMailingAddress = (GraphQLMailingAddress)paramGraphQLMailingAddresses.addresses.get(i1);
          RadioButton localRadioButton = (RadioButton)localLayoutInflater.inflate(2130903133, this.k, false);
          localRadioButton.setText(localGraphQLMailingAddress.address.fullAddress);
          localRadioButton.setId(i1 + 1);
          localRadioButton.setTag(localGraphQLMailingAddress.id);
          this.k.addView(localRadioButton);
          localLayoutInflater.inflate(2130903540, this.k, true);
          i1++;
          continue;
          bool = false;
          break;
        }
      this.k.clearCheck();
      this.k.check(1);
    }
    while (true)
    {
      return;
      this.j.setVisibility(0);
      this.l.setVisibility(0);
      this.k.setVisibility(8);
      this.m.setVisibility(8);
      this.n.setVisibility(8);
      a(this.l);
    }
  }

  public String b()
  {
    return g().getString(2131362228);
  }

  public void c()
  {
    if (this.h.getVisibility() == 0);
    while (true)
    {
      return;
      if (this.g)
      {
        int i1 = this.k.getCheckedRadioButtonId();
        this.f = ((String)this.k.findViewById(i1).getTag());
        if (Strings.isNullOrEmpty(this.f))
          continue;
        F();
        continue;
      }
      a(new AlcoholInfoEntryView.AddressHolder(this.l), false);
    }
  }

  public String d()
  {
    return "Alcohol Info Form";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.AlcoholInfoEntryView
 * JD-Core Version:    0.6.0
 */