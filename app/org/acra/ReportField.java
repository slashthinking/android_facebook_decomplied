package org.acra;

public enum ReportField
{
  static
  {
    APP_VERSION_CODE = new ReportField("APP_VERSION_CODE", 1);
    APP_VERSION_NAME = new ReportField("APP_VERSION_NAME", 2);
    PACKAGE_NAME = new ReportField("PACKAGE_NAME", 3);
    FILE_PATH = new ReportField("FILE_PATH", 4);
    PHONE_MODEL = new ReportField("PHONE_MODEL", 5);
    ANDROID_VERSION = new ReportField("ANDROID_VERSION", 6);
    BUILD = new ReportField("BUILD", 7);
    BRAND = new ReportField("BRAND", 8);
    PRODUCT = new ReportField("PRODUCT", 9);
    TOTAL_MEM_SIZE = new ReportField("TOTAL_MEM_SIZE", 10);
    AVAILABLE_MEM_SIZE = new ReportField("AVAILABLE_MEM_SIZE", 11);
    CUSTOM_DATA = new ReportField("CUSTOM_DATA", 12);
    STACK_TRACE = new ReportField("STACK_TRACE", 13);
    INITIAL_CONFIGURATION = new ReportField("INITIAL_CONFIGURATION", 14);
    CRASH_CONFIGURATION = new ReportField("CRASH_CONFIGURATION", 15);
    DISPLAY = new ReportField("DISPLAY", 16);
    USER_COMMENT = new ReportField("USER_COMMENT", 17);
    USER_APP_START_DATE = new ReportField("USER_APP_START_DATE", 18);
    USER_CRASH_DATE = new ReportField("USER_CRASH_DATE", 19);
    DUMPSYS_MEMINFO = new ReportField("DUMPSYS_MEMINFO", 20);
    DROPBOX = new ReportField("DROPBOX", 21);
    LOGCAT = new ReportField("LOGCAT", 22);
    EVENTSLOG = new ReportField("EVENTSLOG", 23);
    RADIOLOG = new ReportField("RADIOLOG", 24);
    IS_SILENT = new ReportField("IS_SILENT", 25);
    DEVICE_ID = new ReportField("DEVICE_ID", 26);
    INSTALLATION_ID = new ReportField("INSTALLATION_ID", 27);
    USER_EMAIL = new ReportField("USER_EMAIL", 28);
    DEVICE_FEATURES = new ReportField("DEVICE_FEATURES", 29);
    ENVIRONMENT = new ReportField("ENVIRONMENT", 30);
    SETTINGS_SYSTEM = new ReportField("SETTINGS_SYSTEM", 31);
    SETTINGS_SECURE = new ReportField("SETTINGS_SECURE", 32);
    SHARED_PREFERENCES = new ReportField("SHARED_PREFERENCES", 33);
    PROCESS_NAME = new ReportField("PROCESS_NAME", 34);
    ACTIVITY_LOG = new ReportField("ACTIVITY_LOG", 35);
    ReportField[] arrayOfReportField = new ReportField[36];
    arrayOfReportField[0] = REPORT_ID;
    arrayOfReportField[1] = APP_VERSION_CODE;
    arrayOfReportField[2] = APP_VERSION_NAME;
    arrayOfReportField[3] = PACKAGE_NAME;
    arrayOfReportField[4] = FILE_PATH;
    arrayOfReportField[5] = PHONE_MODEL;
    arrayOfReportField[6] = ANDROID_VERSION;
    arrayOfReportField[7] = BUILD;
    arrayOfReportField[8] = BRAND;
    arrayOfReportField[9] = PRODUCT;
    arrayOfReportField[10] = TOTAL_MEM_SIZE;
    arrayOfReportField[11] = AVAILABLE_MEM_SIZE;
    arrayOfReportField[12] = CUSTOM_DATA;
    arrayOfReportField[13] = STACK_TRACE;
    arrayOfReportField[14] = INITIAL_CONFIGURATION;
    arrayOfReportField[15] = CRASH_CONFIGURATION;
    arrayOfReportField[16] = DISPLAY;
    arrayOfReportField[17] = USER_COMMENT;
    arrayOfReportField[18] = USER_APP_START_DATE;
    arrayOfReportField[19] = USER_CRASH_DATE;
    arrayOfReportField[20] = DUMPSYS_MEMINFO;
    arrayOfReportField[21] = DROPBOX;
    arrayOfReportField[22] = LOGCAT;
    arrayOfReportField[23] = EVENTSLOG;
    arrayOfReportField[24] = RADIOLOG;
    arrayOfReportField[25] = IS_SILENT;
    arrayOfReportField[26] = DEVICE_ID;
    arrayOfReportField[27] = INSTALLATION_ID;
    arrayOfReportField[28] = USER_EMAIL;
    arrayOfReportField[29] = DEVICE_FEATURES;
    arrayOfReportField[30] = ENVIRONMENT;
    arrayOfReportField[31] = SETTINGS_SYSTEM;
    arrayOfReportField[32] = SETTINGS_SECURE;
    arrayOfReportField[33] = SHARED_PREFERENCES;
    arrayOfReportField[34] = PROCESS_NAME;
    arrayOfReportField[35] = ACTIVITY_LOG;
    $VALUES = arrayOfReportField;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.ReportField
 * JD-Core Version:    0.6.0
 */