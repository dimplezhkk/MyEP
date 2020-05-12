package cn.zh.ep.pojo;

public class Send {
    private Integer id;

    private String musicname;

    private String singername;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname == null ? null : musicname.trim();
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername == null ? null : singername.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}