package com.test0.pwing.prac_sqlite;

public class MyBlock {
    private String name;
    private String descrip;

    public MyBlock(String name, String descrip) {
        this.name = name;
        this.descrip = descrip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
