package com.telos.christianaushana.telos;

/**
 * Created by christianaushana on 5/2/17.
 */

// daily, weekly, bi-weekly, monthly
public class Repeat {
    String daily = "daily";
    String weekly = "weekly";
    String bi_weekly = "bi_weekly";
    String monthly = "monthly";
    String yearly = "yearly";
    private String setting;

    public Repeat(String setting) {
        this.setting = setting;
    }

    public String getRepeatSetting() {
        return setting;
    }

    public void setRepeatSetting(String setting) {
      this.setting = setting;
    }
}
