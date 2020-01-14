package com.example.demo.model;

public class TB_GOODS_QA_LOG {
    private int ID;
    private int FACTORY_ID;
    private int GOODS_ID;
    private int QA_ID;
    private int TAILOR_ID;
    private int STATUS;
    private String _VERSION;
    private int _CREATE_USER_ID;
    private String _CREATE_USER_NAME;
    private String _CREATE_TIME;
    private int _UPDATE_USER_ID;
    private String _UPDATE_USER_NAME;
    private String _UPDATE_TIME;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFACTORY_ID() {
        return FACTORY_ID;
    }

    public void setFACTORY_ID(int FACTORY_ID) {
        this.FACTORY_ID = FACTORY_ID;
    }

    public int getGOODS_ID() {
        return GOODS_ID;
    }

    public void setGOODS_ID(int GOODS_ID) {
        this.GOODS_ID = GOODS_ID;
    }

    public int getQA_ID() {
        return QA_ID;
    }

    public void setQA_ID(int QA_ID) {
        this.QA_ID = QA_ID;
    }

    public int getTAILOR_ID() {
        return TAILOR_ID;
    }

    public void setTAILOR_ID(int TAILOR_ID) {
        this.TAILOR_ID = TAILOR_ID;
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

    @Override
    public String toString() {
        return "TB_GOODS_QA_LOG{" +
                "ID=" + ID +
                ", FACTORY_ID=" + FACTORY_ID +
                ", GOODS_ID=" + GOODS_ID +
                ", QA_ID=" + QA_ID +
                ", TAILOR_ID=" + TAILOR_ID +
                ", STATUS=" + STATUS +
                ", _VERSION='" + _VERSION + '\'' +
                ", _CREATE_USER_ID=" + _CREATE_USER_ID +
                ", _CREATE_USER_NAME='" + _CREATE_USER_NAME + '\'' +
                ", _CREATE_TIME='" + _CREATE_TIME + '\'' +
                ", _UPDATE_USER_ID=" + _UPDATE_USER_ID +
                ", _UPDATE_USER_NAME='" + _UPDATE_USER_NAME + '\'' +
                ", _UPDATE_TIME='" + _UPDATE_TIME + '\'' +
                '}';
    }
}
