package in.jpsolution.okhttplibrary;

public class LoginModel {

    /**
     * status : 1
     * message : You have successfully logged in.
     * userDetail : {"studentId":1,"studentEmailId":"ishani.vnurture@gmail.com","sub_id":"2","batch_id":"56","sub_name":"ANDROID"}
     */

    private int status;
    private String message;
    private UserDetailBean userDetail;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDetailBean getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailBean userDetail) {
        this.userDetail = userDetail;
    }

    public static class UserDetailBean {
        /**
         * studentId : 1
         * studentEmailId : ishani.vnurture@gmail.com
         * sub_id : 2
         * batch_id : 56
         * sub_name : ANDROID
         */

        private int studentId;
        private String studentEmailId;
        private String sub_id;
        private String batch_id;
        private String sub_name;

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public String getStudentEmailId() {
            return studentEmailId;
        }

        public void setStudentEmailId(String studentEmailId) {
            this.studentEmailId = studentEmailId;
        }

        public String getSub_id() {
            return sub_id;
        }

        public void setSub_id(String sub_id) {
            this.sub_id = sub_id;
        }

        public String getBatch_id() {
            return batch_id;
        }

        public void setBatch_id(String batch_id) {
            this.batch_id = batch_id;
        }

        public String getSub_name() {
            return sub_name;
        }

        public void setSub_name(String sub_name) {
            this.sub_name = sub_name;
        }
    }
}
