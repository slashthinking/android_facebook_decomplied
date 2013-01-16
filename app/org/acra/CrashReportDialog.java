package org.acra;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import org.acra.reporter.ReportsCrashes;

public class CrashReportDialog extends Activity
{
  String mReportFileName = null;
  private SharedPreferences prefs = null;
  private EditText userComment = null;
  private EditText userEmail = null;

  protected void cancelNotification()
  {
    ((NotificationManager)getSystemService("notification")).cancel(666);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mReportFileName = getIntent().getStringExtra("REPORT_FILE_NAME");
    Log.d(ACRA.LOG_TAG, "Opening CrashReportDialog for " + this.mReportFileName);
    if (this.mReportFileName == null)
      finish();
    requestWindowFeature(3);
    LinearLayout localLinearLayout1 = new LinearLayout(this);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setPadding(10, 10, 10, 10);
    localLinearLayout1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    ScrollView localScrollView = new ScrollView(this);
    localLinearLayout1.addView(localScrollView, new LinearLayout.LayoutParams(-1, -1, 1.0F));
    TextView localTextView1 = new TextView(this);
    localTextView1.setText(getText(ACRA.getConfig().resDialogText()));
    localScrollView.addView(localTextView1, -1, -1);
    int i = ACRA.getConfig().resDialogCommentPrompt();
    if (i != 0)
    {
      TextView localTextView2 = new TextView(this);
      localTextView2.setText(getText(i));
      localTextView2.setPadding(localTextView2.getPaddingLeft(), 10, localTextView2.getPaddingRight(), localTextView2.getPaddingBottom());
      localLinearLayout1.addView(localTextView2, new LinearLayout.LayoutParams(-1, -2));
      this.userComment = new EditText(this);
      this.userComment.setLines(2);
      localLinearLayout1.addView(this.userComment, new LinearLayout.LayoutParams(-1, -2));
    }
    int j = ACRA.getConfig().resDialogEmailPrompt();
    if (j != 0)
    {
      TextView localTextView3 = new TextView(this);
      localTextView3.setText(getText(j));
      localTextView3.setPadding(localTextView3.getPaddingLeft(), 10, localTextView3.getPaddingRight(), localTextView3.getPaddingBottom());
      localLinearLayout1.addView(localTextView3, new LinearLayout.LayoutParams(-1, -2));
      this.userEmail = new EditText(this);
      this.userEmail.setSingleLine();
      this.userEmail.setInputType(33);
      this.prefs = getSharedPreferences(ACRA.getConfig().sharedPreferencesName(), ACRA.getConfig().sharedPreferencesMode());
      this.userEmail.setText(this.prefs.getString("acra.user.email", ""));
      localLinearLayout1.addView(this.userEmail, new LinearLayout.LayoutParams(-1, -2));
    }
    LinearLayout localLinearLayout2 = new LinearLayout(this);
    localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout2.setPadding(localLinearLayout2.getPaddingLeft(), 10, localLinearLayout2.getPaddingRight(), localLinearLayout2.getPaddingBottom());
    Button localButton1 = new Button(this);
    localButton1.setText(17039379);
    localButton1.setOnClickListener(new CrashReportDialog.1(this));
    localLinearLayout2.addView(localButton1, new LinearLayout.LayoutParams(-1, -2, 1.0F));
    Button localButton2 = new Button(this);
    localButton2.setText(17039369);
    localButton2.setOnClickListener(new CrashReportDialog.2(this));
    localLinearLayout2.addView(localButton2, new LinearLayout.LayoutParams(-1, -2, 1.0F));
    localLinearLayout1.addView(localLinearLayout2, new LinearLayout.LayoutParams(-1, -2));
    setContentView(localLinearLayout1);
    int k = ACRA.getConfig().resDialogTitle();
    if (k != 0)
      setTitle(k);
    getWindow().setFeatureDrawableResource(3, ACRA.getConfig().resDialogIcon());
    cancelNotification();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.CrashReportDialog
 * JD-Core Version:    0.6.0
 */