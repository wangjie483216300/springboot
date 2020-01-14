package com.example.demo.model;

public class TB_GOODS_INFO {
    private int ID;
    private int FACTORY_ID;
    private String RFID;
    private int TYPE_ID;
    private String TYPE_NAME;
    private String STYLE_ID;
    private String STYLE_NAME;
    private int COLOR_ID;
    private String COLOR_NAME;
    private int SIZE_ID;
    private String SIZE_NAME;
    private int STATUS;
    private String _VERSION;
    private int _CREATE_USER_ID;
    private String _CREATE_USER_NAME;
    private String _CREATE_TIME;
    private int _UPDATE_USER_ID;
    private String _UPDATE_USER_NAME;
    private String _UPDATE_TIME;

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public int getTYPE_ID() {
        return TYPE_ID;
    }

    public void setTYPE_ID(int TYPE_ID) {
        this.TYPE_ID = TYPE_ID;
    }

    public String getTYPE_NAME() {
        return TYPE_NAME;
    }

    public void setTYPE_NAME(String TYPE_NAME) {
        this.TYPE_NAME = TYPE_NAME;
    }

    public String getSTYLE_ID() {
        return STYLE_ID;
    }

    public void setSTYLE_ID(String STYLE_ID) {
        this.STYLE_ID = STYLE_ID;
    }

    public String getSTYLE_NAME() {
        return STYLE_NAME;
    }

    public void setSTYLE_NAME(String STYLE_NAME) {
        this.STYLE_NAME = STYLE_NAME;
    }

    public int getCOLOR_ID() {
        return COLOR_ID;
    }

    public void setCOLOR_ID(int COLOR_ID) {
        this.COLOR_ID = COLOR_ID;
    }

    public String getCOLOR_NAME() {
        return COLOR_NAME;
    }

    public void setCOLOR_NAME(String COLOR_NAME) {
        this.COLOR_NAME = COLOR_NAME;
    }

    public int getSIZE_ID() {
        return SIZE_ID;
    }

    public void setSIZE_ID(int SIZE_ID) {
        this.SIZE_ID = SIZE_ID;
    }

    public String getSIZE_NAME() {
        return SIZE_NAME;
    }

    public void setSIZE_NAME(String SIZE_NAME) {
        this.SIZE_NAME = SIZE_NAME;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public String get_VERSION() {
        return _VERSION;
    }

    public void set_VERSION(String _VERSION) {
        this._VERSION = _VERSION;
    }

    public int get_CREATE_USER_ID() {
        return _CREATE_USER_ID;
    }

    public void set_CREATE_USER_ID(int _CREATE_USER_ID) {
        this._CREATE_USER_ID = _CREATE_USER_ID;
    }

    public String get_CREATE_USER_NAME() {
        return _CREATE_USER_NAME;
    }

    public void set_CREATE_USER_NAME(String _CREATE_USER_NAME) {
        this._CREATE_USER_NAME = _CREATE_USER_NAME;
    }

    public String get_CREATE_TIME() {
        return _CREATE_TIME;
    }

    public void set_CREATE_TIME(String _CREATE_TIME) {
        this._CREATE_TIME = _CREATE_TIME;
    }

    public int get_UPDATE_USER_ID() {
        return _UPDATE_USER_ID;
    }

    public void set_UPDATE_USER_ID(int _UPDATE_USER_ID) {
        this._UPDATE_USER_ID = _UPDATE_USER_ID;
    }

    public String get_UPDATE_USER_NAME() {
        return _UPDATE_USER_NAME;
    }

    public void set_UPDATE_USER_NAME(String _UPDATE_USER_NAME) {
        this._UPDATE_USER_NAME = _UPDATE_USER_NAME;
    }

    public String get_UPDATE_TIME() {
        return _UPDATE_TIME;
    }

    public void set_UPDATE_TIME(String _UPDATE_TIME) {
        this._UPDATE_TIME = _UPDATE_TIME;
    }
}
