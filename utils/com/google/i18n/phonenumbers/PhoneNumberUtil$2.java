package com.google.i18n.phonenumbers;

class PhoneNumberUtil$2
{
  static
  {
    try
    {
      $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberUtil.PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
      try
      {
        label20: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberUtil.PhoneNumberType.TOLL_FREE.ordinal()] = 2;
        try
        {
          label31: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberUtil.PhoneNumberType.MOBILE.ordinal()] = 3;
          try
          {
            label42: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberUtil.PhoneNumberType.FIXED_LINE.ordinal()] = 4;
            try
            {
              label53: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
              try
              {
                label64: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberUtil.PhoneNumberType.SHARED_COST.ordinal()] = 6;
                try
                {
                  label76: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberUtil.PhoneNumberType.VOIP.ordinal()] = 7;
                  try
                  {
                    label88: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberUtil.PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
                    try
                    {
                      label100: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberUtil.PhoneNumberType.PAGER.ordinal()] = 9;
                      try
                      {
                        label112: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[PhoneNumberUtil.PhoneNumberType.UAN.ordinal()] = 10;
                        label124: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat = new int[PhoneNumberUtil.PhoneNumberFormat.values().length];
                        try
                        {
                          $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberUtil.PhoneNumberFormat.E164.ordinal()] = 1;
                          try
                          {
                            label144: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
                            try
                            {
                              label155: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberUtil.PhoneNumberFormat.RFC3966.ordinal()] = 3;
                              try
                              {
                                label166: $SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberUtil.PhoneNumberFormat.NATIONAL.ordinal()] = 4;
                                label177: $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource = new int[Phonenumber.PhoneNumber.CountryCodeSource.values().length];
                                try
                                {
                                  $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
                                  try
                                  {
                                    label197: $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
                                    try
                                    {
                                      label208: $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
                                      try
                                      {
                                        label219: $SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
                                        label230: return;
                                      }
                                      catch (NoSuchFieldError localNoSuchFieldError18)
                                      {
                                        break label230;
                                      }
                                    }
                                    catch (NoSuchFieldError localNoSuchFieldError17)
                                    {
                                      break label219;
                                    }
                                  }
                                  catch (NoSuchFieldError localNoSuchFieldError16)
                                  {
                                    break label208;
                                  }
                                }
                                catch (NoSuchFieldError localNoSuchFieldError15)
                                {
                                  break label197;
                                }
                              }
                              catch (NoSuchFieldError localNoSuchFieldError14)
                              {
                                break label177;
                              }
                            }
                            catch (NoSuchFieldError localNoSuchFieldError13)
                            {
                              break label166;
                            }
                          }
                          catch (NoSuchFieldError localNoSuchFieldError12)
                          {
                            break label155;
                          }
                        }
                        catch (NoSuchFieldError localNoSuchFieldError11)
                        {
                          break label144;
                        }
                      }
                      catch (NoSuchFieldError localNoSuchFieldError10)
                      {
                        break label124;
                      }
                    }
                    catch (NoSuchFieldError localNoSuchFieldError9)
                    {
                      break label112;
                    }
                  }
                  catch (NoSuchFieldError localNoSuchFieldError8)
                  {
                    break label100;
                  }
                }
                catch (NoSuchFieldError localNoSuchFieldError7)
                {
                  break label88;
                }
              }
              catch (NoSuchFieldError localNoSuchFieldError6)
              {
                break label76;
              }
            }
            catch (NoSuchFieldError localNoSuchFieldError5)
            {
              break label64;
            }
          }
          catch (NoSuchFieldError localNoSuchFieldError4)
          {
            break label53;
          }
        }
        catch (NoSuchFieldError localNoSuchFieldError3)
        {
          break label42;
        }
      }
      catch (NoSuchFieldError localNoSuchFieldError2)
      {
        break label31;
      }
    }
    catch (NoSuchFieldError localNoSuchFieldError1)
    {
      break label20;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.PhoneNumberUtil.2
 * JD-Core Version:    0.6.2
 */