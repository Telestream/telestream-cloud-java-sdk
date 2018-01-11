package net.telestream.cloud.objects;

import java.util.Date;

/**
 * Created by maciejwitowski on 1/23/16.
 */
public class Factory extends Model {
    private String id;
    private String name;
    private String url;
    private Boolean uploadOriginalVideo;
    private String s3VideosBucket;
    private Boolean s3PrivateAccess;
    private Date createdAt;
    private Date updatedAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public boolean isUploadOriginalVideo() {
        return uploadOriginalVideo;
    }

    public String getS3VideosBucket() {
        return s3VideosBucket;
    }

    public Boolean isS3PrivateAccess() {
        return s3PrivateAccess;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUploadOriginalVideo(Boolean uploadOriginalVideo) {
        this.uploadOriginalVideo = uploadOriginalVideo;
    }

    public Boolean getUploadOriginalVideo() {
        return uploadOriginalVideo;
    }
}
