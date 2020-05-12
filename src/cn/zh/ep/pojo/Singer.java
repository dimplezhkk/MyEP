package cn.zh.ep.pojo;

public class Singer {
    private Integer id;

    private String singer;

    private String sex;

    private String singertype;

    private String hot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer == null ? null : singer.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getSingertype() {
        return singertype;
    }

    public void setSingertype(String singertype) {
        this.singertype = singertype == null ? null : singertype.trim();
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot == null ? null : hot.trim();
    }
}