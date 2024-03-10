package com.example.demo2.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "LanguageBean")
@SessionScoped
public class LanguageBean implements Serializable {
    private String localeCode;

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public Map<String, Object> getCountries() {
        Map<String, Object> countries = new LinkedHashMap<>();
        countries.put("English", "en");
        countries.put("French", "fr");
        return countries;
    }

    public void changeLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(localeCode));
    }


}
