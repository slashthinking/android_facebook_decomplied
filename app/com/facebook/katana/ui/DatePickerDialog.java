package com.facebook.katana.ui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.widget.DatePicker;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import java.util.Calendar;

public class DatePickerDialog extends android.app.DatePickerDialog
{
  public DatePickerDialog(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2, paramInt3);
    setTitle(DefaultTimeFormatUtil.a(paramContext, TimeFormatUtil.TimeFormatStyle.DATE_PICKER_STYLE, localCalendar.getTimeInMillis()));
  }

  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2, paramInt3);
    setTitle(DefaultTimeFormatUtil.a(getContext(), TimeFormatUtil.TimeFormatStyle.DATE_PICKER_STYLE, localCalendar.getTimeInMillis()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.DatePickerDialog
 * JD-Core Version:    0.6.0
 */