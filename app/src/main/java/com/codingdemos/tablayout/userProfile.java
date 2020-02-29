package com.codingdemos.tablayout;

public class userProfile {

        String name;
        String email;
        String password;
        String areaCode;
        String phone;
        String paddy;
        String wheat;
        String coconut;
        String cat;

        public userProfile(){

        }

        public userProfile(String name,String email,String password, String areaCode, String phone, String paddy, String wheat, String coconut, String cat) {
            this.name = name;
            this.areaCode = areaCode;
            this.email = email;
            this.password = password;
            this.phone = phone;
            this.paddy = paddy;
            this.wheat = wheat;
            this.coconut = coconut;
            this.cat = cat;
        //    this.mn = mn;
        }


    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public String getCat() { return cat; }

    public String getName() { return name; }

        public String getAreaCode() {
            return areaCode;
        }

        public String getPhone() {
            return phone;
        }

        public String getPaddy() {
            return paddy;
        }

        public String getWheat() {
            return wheat;
        }

        public String getCoconut() {
            return coconut;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setPaddy(String paddy) {
            this.paddy = paddy;
        }

        public void setWheat(String wheat) {
            this.wheat = wheat;
        }

        public void setCoconut(String coconut) {
            this.coconut = coconut;
        }

    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

    public void setCat(String cat) { this.cat = cat; }
}
