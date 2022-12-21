package org.example;

public class JsonParse {
    private String фамилия;
    private String оценка;
    private String предмет;

    public JsonParse() {
    }

    public String getФамилия() {
        return фамилия;
    }

    public void setФамилия(String фамилия) {
        this.фамилия = фамилия;
    }

    public String getОценка() {
        return оценка;
    }

    public void setОценка(String оценка) {
        this.оценка = оценка;
    }

    public String getПредмет() {
        return предмет;
    }

    public void setПредмет(String предмет) {
        this.предмет = предмет;
    }

    @Override
    public String toString() {
        return "Студент " + фамилия +
                " получил " + оценка +
                " по предмету " + предмет;
    }
}
