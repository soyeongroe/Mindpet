package net.skhu;

public class MemberInfo {
    private String name;
    private String phone;
    private String birth;
    private String add;

    public MemberInfo(String name, String phone, String birth, String add){
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBirth() {
        return birth;
    }
    public void setAdd(String add) {
        this.add = add;
    }

    public String getAdd() {
        return add;
    }



}
