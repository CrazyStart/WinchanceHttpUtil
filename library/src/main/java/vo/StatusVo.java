package vo;

import java.util.List;

/**
 * desc: add a single status
 * url: http://10.0.2.217:8888/api/statuses
 * method: post
 * params: referTime不能为空，location可以为空，details和imageUrl至少一个不为空
 * return: 所有输入参数，并新增id和userId字段，id可用于唯一识别某一条Status，userId为当前登录的userId
 *
 * desc: get all statuses
 * url: http://10.0.2.217:8888/api/statused
 * method: get
 * params: null
 * return: 以下所有字段
 *
 * desc: get all statuses of a certain user
 * url: http://10.0.2.217:8888/api/user/{userId}/statused
 * method: get
 * params: userId为所需用户的userId
 * return: 以下所有字段
 *
 * ps: all these function calls will fail if not login
 * @author mkingzhu
 *
 */
public class StatusVo {
    private Long id;

    private String userId;

    private String nickName;

    private String avatarUrl;

    private Long referTime;

    private String location;

    private String details;

    private List<String> imageUrls;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Long getReferTime() {
        return referTime;
    }

    public void setReferTime(Long referTime) {
        this.referTime = referTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
