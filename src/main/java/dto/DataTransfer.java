package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataTransfer {

    private String key;
    private String login;
    private String password;
    private String site;
    private String link;
    private String title;
    private String subTitle;
    private String tags;

    public DataTransfer(String key,
                        String login,
                        String password,
                        String site,
                        String link,
                        String title,
                        String subTitle,
                        String tags) {
        this.key = key;
        this.login = login;
        this.password = password;
        this.site = site;
        this.link = link;
        this.title = title;
        this.subTitle = subTitle;
        this.tags = tags;
    }
}
