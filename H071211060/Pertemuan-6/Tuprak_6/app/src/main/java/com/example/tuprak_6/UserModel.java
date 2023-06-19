package com.example.tuprak_6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class UserModel implements Parcelable {
    private String username;
    private String fullname;
    @DrawableRes
    private int profilePicture;
    private PostModel post;

    public UserModel(String username, String fullname, int profilePicture, PostModel post) {
        this.username = username;
        this.fullname = fullname;
        this.profilePicture = profilePicture;
        this.post = post;
    }
    public UserModel(){

    }
    protected UserModel(Parcel in) {
        username = in.readString();
        fullname = in.readString();
        profilePicture = in.readInt();
        post = in.readParcelable(PostModel.class.getClassLoader());
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(fullname);
        dest.writeInt(profilePicture);
        dest.writeParcelable(post, flags);
    }
}
