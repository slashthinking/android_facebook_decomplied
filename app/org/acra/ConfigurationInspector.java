package org.acra;

import android.content.res.Configuration;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class ConfigurationInspector
{
  private static final String FIELD_MCC = "mcc";
  private static final String FIELD_MNC = "mnc";
  private static final String FIELD_SCREENLAYOUT = "screenLayout";
  private static final String FIELD_UIMODE = "uiMode";
  private static final String PREFIX_HARDKEYBOARDHIDDEN = "HARDKEYBOARDHIDDEN_";
  private static final String PREFIX_KEYBOARD = "KEYBOARD_";
  private static final String PREFIX_KEYBOARDHIDDEN = "KEYBOARDHIDDEN_";
  private static final String PREFIX_NAVIGATION = "NAVIGATION_";
  private static final String PREFIX_NAVIGATIONHIDDEN = "NAVIGATIONHIDDEN_";
  private static final String PREFIX_ORIENTATION = "ORIENTATION_";
  private static final String PREFIX_SCREENLAYOUT = "SCREENLAYOUT_";
  private static final String PREFIX_TOUCHSCREEN = "TOUCHSCREEN_";
  private static final String PREFIX_UI_MODE = "UI_MODE_";
  private static final String SUFFIX_MASK = "_MASK";
  private static SparseArray<String> mHardKeyboardHiddenValues = new SparseArray();
  private static SparseArray<String> mKeyboardHiddenValues;
  private static SparseArray<String> mKeyboardValues = new SparseArray();
  private static SparseArray<String> mNavigationHiddenValues;
  private static SparseArray<String> mNavigationValues;
  private static SparseArray<String> mOrientationValues;
  private static SparseArray<String> mScreenLayoutValues;
  private static SparseArray<String> mTouchScreenValues;
  private static SparseArray<String> mUiModeValues;
  private static final HashMap<String, SparseArray<String>> mValueArrays;

  static
  {
    mKeyboardHiddenValues = new SparseArray();
    mNavigationValues = new SparseArray();
    mNavigationHiddenValues = new SparseArray();
    mOrientationValues = new SparseArray();
    mScreenLayoutValues = new SparseArray();
    mTouchScreenValues = new SparseArray();
    mUiModeValues = new SparseArray();
    mValueArrays = new HashMap();
    mValueArrays.put("HARDKEYBOARDHIDDEN_", mHardKeyboardHiddenValues);
    mValueArrays.put("KEYBOARD_", mKeyboardValues);
    mValueArrays.put("KEYBOARDHIDDEN_", mKeyboardHiddenValues);
    mValueArrays.put("NAVIGATION_", mNavigationValues);
    mValueArrays.put("NAVIGATIONHIDDEN_", mNavigationHiddenValues);
    mValueArrays.put("ORIENTATION_", mOrientationValues);
    mValueArrays.put("SCREENLAYOUT_", mScreenLayoutValues);
    mValueArrays.put("TOUCHSCREEN_", mTouchScreenValues);
    mValueArrays.put("UI_MODE_", mUiModeValues);
    Field[] arrayOfField = Configuration.class.getFields();
    int i = arrayOfField.length;
    for (int j = 0; ; j++)
      if (j < i)
      {
        Field localField = arrayOfField[j];
        if ((!Modifier.isStatic(localField.getModifiers())) || (!Modifier.isFinal(localField.getModifiers())))
          continue;
        String str = localField.getName();
        try
        {
          if (str.startsWith("HARDKEYBOARDHIDDEN_"))
          {
            mHardKeyboardHiddenValues.put(localField.getInt(null), str);
            continue;
          }
          if (str.startsWith("KEYBOARD_"))
            mKeyboardValues.put(localField.getInt(null), str);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.w(ACRA.LOG_TAG, "Error while inspecting device configuration: ", localIllegalArgumentException);
          continue;
          if (str.startsWith("KEYBOARDHIDDEN_"))
            mKeyboardHiddenValues.put(localField.getInt(null), str);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.w(ACRA.LOG_TAG, "Error while inspecting device configuration: ", localIllegalAccessException);
        }
        if (str.startsWith("NAVIGATION_"))
        {
          mNavigationValues.put(localField.getInt(null), str);
        }
        else if (str.startsWith("NAVIGATIONHIDDEN_"))
        {
          mNavigationHiddenValues.put(localField.getInt(null), str);
        }
        else if (str.startsWith("ORIENTATION_"))
        {
          mOrientationValues.put(localField.getInt(null), str);
        }
        else if (str.startsWith("SCREENLAYOUT_"))
        {
          mScreenLayoutValues.put(localField.getInt(null), str);
        }
        else if (str.startsWith("TOUCHSCREEN_"))
        {
          mTouchScreenValues.put(localField.getInt(null), str);
        }
        else
        {
          if (!str.startsWith("UI_MODE_"))
            continue;
          mUiModeValues.put(localField.getInt(null), str);
        }
      }
      else
      {
        return;
      }
  }

  private static String activeFlags(SparseArray<String> paramSparseArray, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramSparseArray.size(); i++)
    {
      int j = paramSparseArray.keyAt(i);
      if (!((String)paramSparseArray.get(j)).endsWith("_MASK"))
        continue;
      int k = paramInt & j;
      if (k <= 0)
        continue;
      if (localStringBuilder.length() > 0)
        localStringBuilder.append('+');
      localStringBuilder.append((String)paramSparseArray.get(k));
    }
    return localStringBuilder.toString();
  }

  private static String getFieldValueName(Configuration paramConfiguration, Field paramField)
  {
    String str1 = paramField.getName();
    String str2;
    if ((str1.equals("mcc")) || (str1.equals("mnc")))
      str2 = Integer.toString(paramField.getInt(paramConfiguration));
    while (true)
    {
      return str2;
      if (str1.equals("uiMode"))
      {
        str2 = activeFlags((SparseArray)mValueArrays.get("UI_MODE_"), paramField.getInt(paramConfiguration));
        continue;
      }
      if (str1.equals("screenLayout"))
      {
        str2 = activeFlags((SparseArray)mValueArrays.get("SCREENLAYOUT_"), paramField.getInt(paramConfiguration));
        continue;
      }
      SparseArray localSparseArray = (SparseArray)mValueArrays.get(str1.toUpperCase() + '_');
      if (localSparseArray == null)
      {
        str2 = Integer.toString(paramField.getInt(paramConfiguration));
        continue;
      }
      str2 = (String)localSparseArray.get(paramField.getInt(paramConfiguration));
      if (str2 != null)
        continue;
      str2 = Integer.toString(paramField.getInt(paramConfiguration));
    }
  }

  public static String toString(Configuration paramConfiguration)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = paramConfiguration.getClass().getFields();
    int i = arrayOfField.length;
    label168: for (int j = 0; ; j++)
      if (j < i)
      {
        Field localField = arrayOfField[j];
        try
        {
          if (Modifier.isStatic(localField.getModifiers()))
            continue;
          localStringBuilder.append(localField.getName()).append('=');
          if (localField.getType().equals(Integer.TYPE))
            localStringBuilder.append(getFieldValueName(paramConfiguration, localField));
          while (true)
          {
            localStringBuilder.append('\n');
            break label168;
            if (localField.get(paramConfiguration) != null)
              break;
            localStringBuilder.append("null");
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          while (true)
          {
            Log.e(ACRA.LOG_TAG, "Error while inspecting device configuration: ", localIllegalArgumentException);
            break;
            localStringBuilder.append(localField.get(paramConfiguration).toString());
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.e(ACRA.LOG_TAG, "Error while inspecting device configuration: ", localIllegalAccessException);
        }
      }
      else
      {
        return localStringBuilder.toString();
      }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.ConfigurationInspector
 * JD-Core Version:    0.6.0
 */