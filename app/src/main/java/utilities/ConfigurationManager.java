package utilities;

import android.content.SharedPreferences;

public class ConfigurationManager {

    private SharedPreferences userSharedPreferences;
    private SharedPreferences.Editor userSharedPreferencesEditor;
    private String defaultStringValue= "NO_VALUE";
    private int defaultIntValue= -1;

    public ConfigurationManager GetInstance (SharedPreferences sharedPreferences)
    {
        userSharedPreferences= sharedPreferences;
        userSharedPreferencesEditor = userSharedPreferences.edit();
        return this;
    }

    public boolean RetrieveAValue(String which)
    {
        if(userSharedPreferences == null) return false;
        return userSharedPreferences.getBoolean(which, false);
    }
    public String RetrieveAValue(String which, String defaultValue)
    {
        if(userSharedPreferences == null) return defaultStringValue;
        return userSharedPreferences.getString(which, defaultValue);
    }
    public int RetrieveAValue(String which, int defaultValue)
    {
        if(userSharedPreferences == null) return defaultIntValue;
        return userSharedPreferences.getInt(which, defaultValue);
    }
    public boolean SaveAValue(String which, boolean value )
    {
        if(userSharedPreferencesEditor==null) return false;
        userSharedPreferencesEditor.putBoolean(which, value);
        userSharedPreferencesEditor.commit();
        return true;
    }
    public boolean SaveAValue(String which, String value)
    {
        if(userSharedPreferencesEditor==null) return false;
        userSharedPreferencesEditor.putString(which, value);
        userSharedPreferencesEditor.commit();
        return true;
    }
    public boolean SaveAValue(String which, int value)
    {
        if(userSharedPreferencesEditor==null) return false;
        userSharedPreferencesEditor.putInt(which, value);
        userSharedPreferencesEditor.commit();
        return true;
    }


}
