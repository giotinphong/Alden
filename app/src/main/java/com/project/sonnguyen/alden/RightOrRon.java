package com.project.sonnguyen.alden;

/**
 * Created by sonnguyen on 5/19/17.
 */

public class RightOrRon {
    private int color;
    private String text;
    private boolean answer;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public RightOrRon(int color, String text, boolean answer) {

        this.color = color;
        this.text = text;
        this.answer = answer;
    }

    public RightOrRon() {

    }
}
