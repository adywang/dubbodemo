package com.sentinel.demo;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicRefDemo {
    static class UserInfo {
        private String userName;
        public volatile int age;
        private String sex;

        @Override
        public String toString() {
            return "UserInfo{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    '}';
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

    public static void main(String[] args) {
        UserInfo u = new UserInfo();
        u.setAge(12);
        u.setUserName("admin");
        u.setSex("男");
        AtomicReference<UserInfo> userRef=new AtomicReference<>();
        userRef.set(u);
        UserInfo userInfo = userRef.get();
        System.out.println(userInfo);
        AtomicIntegerFieldUpdater<UserInfo> ageF = AtomicIntegerFieldUpdater.newUpdater(UserInfo.class, "age");
        int andIncrement = ageF.incrementAndGet(u);
        System.out.println(andIncrement);
    }
}
