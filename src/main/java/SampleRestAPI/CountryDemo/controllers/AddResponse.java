package SampleRestAPI.CountryDemo.controllers;

public class AddResponse {

    private String msg;
    private int id;

    public AddResponse(String msg, int id) {
        this.msg = msg;
        this.id = id;
    }

    public AddResponse() {

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
