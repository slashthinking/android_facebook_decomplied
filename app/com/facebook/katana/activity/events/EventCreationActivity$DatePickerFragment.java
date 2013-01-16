package com.facebook.katana.activity.events;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import com.facebook.katana.ui.DatePickerDialog;
import java.util.Calendar;

class EventCreationActivity$DatePickerFragment extends DialogFragment
  implements DatePickerDialog.OnDateSetListener
{
  private EventCreationActivity$DatePickerFragment(EventCreationActivity paramEventCreationActivity)
  {
  }

  public Dialog c(Bundle paramBundle)
  {
    if (("datepicker_start".equals(k())) || (("datepicker_end".equals(k())) && (EventCreationActivity.l(this.Y) == null)));
    for (Calendar localCalendar = EventCreationActivity.m(this.Y); ; localCalendar = EventCreationActivity.l(this.Y))
    {
      int i = localCalendar.get(1);
      int j = localCalendar.get(2);
      int k = localCalendar.get(5);
      DatePickerDialog localDatePickerDialog = new DatePickerDialog(n(), this, i, j, k);
      if ("datepicker_end".equals(k()))
        localDatePickerDialog.setButton(-2, e(2131362917), EventCreationActivity.n(this.Y));
      return localDatePickerDialog;
    }
  }

  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if ("datepicker_start".equals(k()))
      EventCreationActivity.a(this.Y, paramInt1, paramInt2, paramInt3);
    while (true)
    {
      if ((EventCreationActivity.l(this.Y) != null) && (EventCreationActivity.l(this.Y).getTimeInMillis() < EventCreationActivity.m(this.Y).getTimeInMillis()))
        EventCreationActivity.o(this.Y);
      return;
      EventCreationActivity.b(this.Y, paramInt1, paramInt2, paramInt3);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.events.EventCreationActivity.DatePickerFragment
 * JD-Core Version:    0.6.0
 */