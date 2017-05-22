package com.project.sonnguyen.alden.data;

/**
 * Created by sonnguyen on 5/22/17.
 */

public class StudyContent {
    private String Fromto,Content;
    private int Week;
    private boolean Isfinish;

    public int getWeek() {
        return Week;
    }

    public void setWeek(int week) {
        Week = week;
    }

    public String getFromto() {
        return Fromto;
    }

    public void setFromto(String fromto) {
        Fromto = fromto;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public boolean isfinish() {
        return Isfinish;
    }

    public void setIsfinish(boolean isfinish) {
        Isfinish = isfinish;
    }

    public StudyContent() {

    }
}
