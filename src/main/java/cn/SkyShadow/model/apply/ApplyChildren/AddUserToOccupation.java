package cn.SkyShadow.model.apply.ApplyChildren;

import cn.SkyShadow.model.Occupation;
import cn.SkyShadow.model.User;
import cn.SkyShadow.model.apply.Apply;

/**
 * 将用户添加到职业
 * Created by RichardW on 9/22/2016.
 */
public class AddUserToOccupation extends Apply {
    private User person;
    private Occupation occupation;

    public User getPerson() {
        return person;
    }

    public void setPerson(User person) {
        this.person = person;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }
}
