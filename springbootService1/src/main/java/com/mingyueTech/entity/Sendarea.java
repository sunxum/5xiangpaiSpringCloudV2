package com.mingyueTech.entity;

public class Sendarea {
    private Integer id;

    private Integer uid;

    private Integer level1aid;

    private Integer level2aid;

    private Integer aid;

    private String areaname;

    private String detailarea;

    private String urealname;

    private String urealmobile;

    private Integer saStutas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getLevel1aid() {
        return level1aid;
    }

    public void setLevel1aid(Integer level1aid) {
        this.level1aid = level1aid;
    }

    public Integer getLevel2aid() {
        return level2aid;
    }

    public void setLevel2aid(Integer level2aid) {
        this.level2aid = level2aid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public String getDetailarea() {
        return detailarea;
    }

    public void setDetailarea(String detailarea) {
        this.detailarea = detailarea == null ? null : detailarea.trim();
    }

    public String getUrealname() {
        return urealname;
    }

    public void setUrealname(String urealname) {
        this.urealname = urealname == null ? null : urealname.trim();
    }

    public String getUrealmobile() {
        return urealmobile;
    }

    public void setUrealmobile(String urealmobile) {
        this.urealmobile = urealmobile == null ? null : urealmobile.trim();
    }

    public Integer getSaStutas() {
        return saStutas;
    }

    public void setSaStutas(Integer saStutas) {
        this.saStutas = saStutas;
    }
}